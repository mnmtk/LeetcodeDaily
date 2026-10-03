import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        // 1. Extract base hostname
        String hostname = getHostname(startUrl);

        // 2. Thread-safe set to track visited URLs
        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);

        // 3. Thread-safe queue for pending URLs
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add(startUrl);

        // 4. Atomic counter to track active tasks (in-queue + currently processing)
        AtomicInteger activeTasks = new AtomicInteger(1);

        // 5. Create a thread pool with 10 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(10);

        while (activeTasks.get() > 0) {
            String currentUrl;
            try {
                // Poll with a small timeout so the thread doesn't block forever if work finishes
                currentUrl = queue.poll(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                break;
            }

            if (currentUrl == null) {
                continue;
            }

            // Submit a task to the thread pool for execution
            executor.submit(() -> {
                try {
                    // Blocking HTTP call simulation (~15ms)
                    List<String> nextUrls = htmlParser.getUrls(currentUrl);

                    for (String nextUrl : nextUrls) {
                        // Check hostname and attempt thread-safe insert into set
                        if (getHostname(nextUrl).equals(hostname) && visited.add(nextUrl)) {
                            activeTasks.incrementAndGet(); // Track new work
                            queue.add(nextUrl);
                        }
                    }
                } finally {
                    // Mark task as complete
                    activeTasks.decrementAndGet();
                }
            });
        }

        // Shut down the executor service cleanly
        executor.shutdown();
        return new ArrayList<>(visited);
    }

    private String getHostname(String url) {
        // "http://news.yahoo.com/news" -> split by '/' gives ["http:", "", "news.yahoo.com", ...]
        return url.split("/")[2];
    }
}