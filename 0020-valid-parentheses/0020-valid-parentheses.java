class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(c);
            } else if ( stack.isEmpty() || c != map.get(stack.pop())) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}