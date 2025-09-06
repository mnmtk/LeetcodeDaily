class Solution {
    public String simplifyPath(String path) {

        String[] components  = new String[3000];
        Stack<String> stack = new Stack<>();

        components = path.split("/");

        for(String component : components) {
            if (component.equals("") || component.equals(".")) {
                continue;
            } else if (component.equals("..")) { //equals for string, == for memory reference
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String dir : stack) {
            ans.append("/").append(dir);
        }

        String ansL = ans.toString();

        return ansL.length() == 0 ? "/" : ansL;
        
    }
}