package problemSolution;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // Push opening bracket onto stack
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false; // Unmatched closing bracket
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) return false; // Mismatched pair
            }
        }
        
        return stack.isEmpty(); // If stack is empty, brackets are balanced
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String test1 = "{[()]}"; // Balanced
        String test2 = "{[(])}"; // Unbalanced
        
        System.out.println("Test 1: " + isBalanced(test1)); // Output: true
        System.out.println("Test 2: " + isBalanced(test2)); // Output: false
    }
}
