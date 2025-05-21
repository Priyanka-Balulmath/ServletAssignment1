package problemSolution;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // Split by spaces, removing extra spaces
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        return reversed.toString().trim(); // Remove trailing space
    }

    public static void main(String[] args) {
        String s = "  the sky is blue  ";
        System.out.println("Reversed: " + reverseWords(s)); 
        // Output: "blue is sky the"
    }
}
