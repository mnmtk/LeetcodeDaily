import java.util.ArrayList;
import java.util.List;

class Solution {
    public String multiply(String num1, String num2) {
        // Handle edge cases
        if (num1.equals("0") || num2.equals("0")) return "0";

        int sign = (num1.charAt(0) == '-' ^ num2.charAt(0) == '-') ? -1 : 1;

        // Remove negative sign if present
        if (num1.charAt(0) == '-') num1 = num1.substring(1);
        if (num2.charAt(0) == '-') num2 = num2.substring(1);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < num1.length() + num2.length(); i++) {
            ans.add(0); // Initialize with zeros
        }

        // Multiply each digit and accumulate results
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + ans.get(i + j + 1);

                ans.set(i + j + 1, sum % 10); // Set current position
                ans.set(i + j, ans.get(i + j) + sum / 10); // Carry over
            }
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        if (sign == -1) result.append('-'); // Add negative sign if needed

        // Skip leading zeros
        int first = 0;
        while (first < ans.size() && ans.get(first) == 0) {
            first++;
        }

        // Append the result digits
        for (int i = first; i < ans.size(); i++) {
            result.append(ans.get(i));
        }

        return result.toString();
    }
}