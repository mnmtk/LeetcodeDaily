class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while(left <= right) {
            char currFirst = s.charAt(left);
            char currLast = s.charAt(right);

            if (!Character.isLetterOrDigit(currFirst)) {
                left++;
            } else if(!Character.isLetterOrDigit(currLast)) {
        		right--;
        	} else if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                return false;
            } else {
                left++;
                right--;
            }

           
        }

        return true;
        
    }
}