import java.util.*;

class VideoSharingPlatform {
    private int nextId;
    private PriorityQueue<Integer> reusedIds;
    private Map<Integer, String> videos;
    private Map<Integer, int[]> stats; // vid -> [views, likes, dislikes]

    public VideoSharingPlatform() {
        this.nextId = 0;
        this.reusedIds = new PriorityQueue<>();
        this.videos = new HashMap<>();
        this.stats = new HashMap<>();
    }

    public int upload(String video) {
        int vid = reusedIds.isEmpty() ? nextId++ : reusedIds.poll();
        videos.put(vid, video);
        stats.put(vid, new int[]{0, 0, 0});
        return vid;
    }

    public void remove(int videoId) {
        if (videos.containsKey(videoId)) {
            videos.remove(videoId);
            stats.remove(videoId);
            reusedIds.offer(videoId);
        }
    }

    public String watch(int videoId, int startMinute, int endMinute) {
        if (!videos.containsKey(videoId)) {
            return "-1";
        }
        stats.get(videoId)[0]++;
        String video = videos.get(videoId);
        int end = Math.min(endMinute + 1, video.length());
        return video.substring(startMinute, end);
    }

    public void like(int videoId) {
        if (stats.containsKey(videoId)) {
            stats.get(videoId)[1]++;
        }
    }

    public void dislike(int videoId) {
        if (stats.containsKey(videoId)) {
            stats.get(videoId)[2]++;
        }
    }

    public int[] getLikesAndDislikes(int videoId) {
        if (!stats.containsKey(videoId)) {
            return new int[]{-1};
        }
        int[] st = stats.get(videoId);
        return new int[]{st[1], st[2]};
    }

    public int getViews(int videoId) {
        if (!stats.containsKey(videoId)) {
            return -1;
        }
        return stats.get(videoId)[0];
    }
}