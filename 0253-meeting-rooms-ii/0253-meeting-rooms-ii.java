//you can say that once a room is added to the heap, it stays there until it is replaced by another meeting that can reuse the same room. Here's how to frame this idea:

//Room Addition: When a new meeting starts and no existing room is available 
//(i.e., all rooms are still occupied by earlier meetings), a new room is added to the heap. 
//This happens when the start time of the new meeting is less than the earliest end time in the heap.

//Room Replacement: If a new meeting starts and there is a room that will become available before 
//or at the start time of this new meeting (i.e., the earliest end time in the heap is less than or equal 
//to the start time of the new meeting), then that room is "replaced" or reused. 
//This is achieved by removing the earliest end time from the heap (freeing up the room) and adding the end time of the new meeting to the heap.


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
   
    if (intervals.length == 0) {
      return 0;
    }


    PriorityQueue<Integer> allocator =
        new PriorityQueue<Integer>(
            intervals.length,
            new Comparator<Integer>() {
              public int compare(Integer a, Integer b) {
                return a - b;
              }
            });


    Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          public int compare(final int[] a, final int[] b) {
            return a[0] - b[0];
          }
        });

    
    allocator.add(intervals[0][1]);

 
    for (int i = 1; i < intervals.length; i++) {

      if (intervals[i][0] >= allocator.peek()) {
        allocator.poll();
      }


      allocator.add(intervals[i][1]);
    }


    return allocator.size();
  }
}