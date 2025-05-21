class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            } else {
                if (abbr.charAt(j) == '0') return false; // leading zero is not allowed
                int val = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    val = val * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += val;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
