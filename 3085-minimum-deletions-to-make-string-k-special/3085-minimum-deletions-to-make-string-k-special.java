class Solution {
    public int minimumDeletions(String word, int k) {
        int count[]=new int[26];
        
        // Count the frequency of each character in the word
        for(int i=0;i<word.length();i++)
            count[word.charAt(i)-'a']++;
        
        // Sort the frequency array in ascending order
        Arrays.sort(count);
        
        int answer=Integer.MAX_VALUE;

        int prefix_sum=0;
        
        // Iterate over each character frequency
        for (int i=0; i <count.length; i++) {
            // Skip if character frequency is 0
            if(count[i]==0)
                continue;

            // Current deletion count starts with prefix_sum
            int curr=prefix_sum;
            
            // Check for characters with frequency higher than the limit (count[i] + k)
            for (int j=i+1; j<count.length; j++) {
                // If frequency is too high, calculate necessary deletions
                if(count[j]>count[i]+k)
                    curr+=count[j]-(count[i]+k);
            }

            // Update answer with the minimum deletion count found
            answer=Math.min(answer,curr);
            
            // Update prefix_sum with the current character's frequency
            prefix_sum+=count[i];
        }
    
        // Return the minimum deletions required, or 0 if no deletions needed
        return answer==Integer.MAX_VALUE?0:answer;
    }
}