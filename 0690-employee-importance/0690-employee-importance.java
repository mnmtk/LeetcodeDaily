class Solution {
    Map<Integer, Employee> emap;

    public int getImportance(List<Employee> employees, int id) {
        // Create a map for easy access to employees by ID
        emap = new HashMap<>();
        for (Employee e : employees) {
            emap.put(e.id, e);
        }

        // Initialize a queue with the employee of the given ID
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(emap.get(id));

        int ans = 0;

        while (!queue.isEmpty()) {
            // Dequeue an employee
            Employee current = queue.poll();
            // Add the importance of the current employee
            ans += current.importance;

            // Add subordinates to the queue
            for (int subId : current.subordinates) {
                queue.offer(emap.get(subId));
            }
        }

        return ans;
    }
}
