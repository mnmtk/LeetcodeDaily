class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> stack = new Stack<>();
        Set<Integer> index = new HashSet<>();

        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')' && stack.isEmpty() != true){
                stack.pop();
            } else if (s.charAt(i) == ')') {
                index.add(i);
            } 
        }

        while(!stack.isEmpty()) {
            index.add(stack.pop());
        }

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(!index.contains(i)) {
            str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}