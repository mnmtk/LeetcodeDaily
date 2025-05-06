class Solution {
    public int strStr(String haystack, String needle) {
       // using rabin karpalgo
       //using basic hash functions

       if(needle.length()>haystack.length())
       {
           return -1;
       }

       int hash1=0;
       for(int i=0;i<needle.length();i++)
       {
           hash1+=needle.charAt(i)-'a';
       }
        int hash2=0;
        
        for(int j=0;j<needle.length();j++)
        {
            hash2+=haystack.charAt(j)-'a';
        }
    
        if(hash1==hash2)
        {
            int i;
            for( i=0;i<needle.length();i++)
            {
                if(needle.charAt(i)!=haystack.charAt(i))
                {
                    break;
                }
            }
            if(i==needle.length())
            {
                return 0;
            }
        }
       for(int j=needle.length();j<haystack.length();j++)
       {
           hash2-=haystack.charAt(j-needle.length())-'a';
           hash2+=haystack.charAt(j)-'a';
             if(hash1==hash2)
        {
            int i;
            for( i=0;i<needle.length();i++)
            {
                if(needle.charAt(i)!=haystack.charAt(j-needle.length()+1+i))
                {
                    break;
                }
            }
            if(i==needle.length())
            {
                return j-needle.length()+1;
            }
        }
       }
       return -1;

    }
}