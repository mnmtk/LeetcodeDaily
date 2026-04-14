class Solution {

    private Boolean isVowel(char s) {
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') return true;
        if (s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U') return true;
        return false;
    }

    public String reverseVowels(String s) {
        Stack<Character> vowels = new Stack();

        for(int i = 0 ; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                vowels.push(s.charAt(i));
            }
        }

        StringBuilder builder = new StringBuilder();

        for(int i = 0 ; i < s.length(); i ++) {
             if(isVowel(s.charAt(i))) {
               builder.append(vowels.pop());
             } else {
                builder.append(s.charAt(i));
             }
        }

        return builder.toString();
    }
}