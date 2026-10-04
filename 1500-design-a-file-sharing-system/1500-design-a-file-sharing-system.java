import java.util.*;

class FileSharing {
    private int totalChunks;
    private int nextUserId;
    private PriorityQueue<Integer> reusedIds;
    private Map<Integer, Set<Integer>> userChunks; // userID -> Set of owned chunkIDs

    public FileSharing(int m) {
        this.totalChunks = m;
        this.nextUserId = 1;
        this.reusedIds = new PriorityQueue<>();
        this.userChunks = new HashMap<>();
    }

    public int join(List<Integer> ownedChunks) {
        int userId = reusedIds.isEmpty() ? nextUserId++ : reusedIds.poll();
        userChunks.put(userId, new HashSet<>(ownedChunks)); // HashSet allows O(1) chunk lookups
        return userId;
    }

    public void leave(int userID) {
        if (userChunks.containsKey(userID)) {
            userChunks.remove(userID);
            reusedIds.offer(userID); // Recycle User ID
        }
    }

    public List<Integer> request(int userID, int chunkID) {
        List<Integer> owners = new ArrayList<>();

        // WHAT WE SHOULD DO: Scan active users to collect owners of chunkID
        for (Map.Entry<Integer, Set<Integer>> entry : userChunks.entrySet()) {
            if (entry.getValue().contains(chunkID)) {
                owners.add(entry.getKey());
            }
        }

        if (!owners.isEmpty()) {
            Collections.sort(owners); // Sort results to return strictly ascending IDs
            
            if (userChunks.containsKey(userID)) {
                userChunks.get(userID).add(chunkID); // Add chunk to requesting user's set
            }
        }

        return owners;
    }
}