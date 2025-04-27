class Solution {
    public int orangesRotting(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        // Linked list kiu use kri?
        // Linked list easy hoti hai implement krni aur BFS ke liye efficient hoti hai
        
        // add aur remove O(1) mei hojata hai
        // java ke case mei implementation wise bhi built in use kr ri hu.
        // whether you use the Queue interface directly or
        // implement a queue using classes like LinkedList its your choice only.

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //sara graph traverse kro aur:
                if(grid[i][j]==2) q.add(new Pair(i,j)); 
                //rotten oranges add krdo queue mei
            }
        }

        int ans=0;
        while(!q.isEmpty()){ 
            // jab tak queue mei hai jaan!

            int size=q.size();
            // making sure jo abhi add hua hai utna hi krna hai iterate
            //hame newwly rotten oranges are added to the queue during the iteration nai process krna hai

            while(size-- >0){
                Pair x=q.poll(); //orange chako
                int r=x.r,c=x.c; //uski location store krlo

                if(r>0 && grid[r-1][c]==1){ //left ka orange sad jayega
                    grid[r-1][c]=2;
                    q.add(new Pair(r-1,c));

                }
                if(r<n-1 && grid[r+1][c]==1){ //right ka orange sad jayega
                    grid[r+1][c]=2;
                    q.add(new Pair(r+1,c));

                }

                if(c>0 && grid[r][c-1]==1){ //upar ka orange sad jayega
                    grid[r][c-1]=2;
                    q.add(new Pair(r,c-1));

                }
                if(c<m-1 && grid[r][c+1]==1){ //niche ka orange sad jayega
                    grid[r][c+1]=2;
                    q.add(new Pair(r,c+1));

                }
            }

            if(!q.isEmpty()) ans++; 
        }

        for(int i=0;i<n;i++){ 
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1; //agar ke bhi orange nai sada to
            }
        }

        return ans; 
    }
}
  class Pair{
    int r;
    int c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
}
  }