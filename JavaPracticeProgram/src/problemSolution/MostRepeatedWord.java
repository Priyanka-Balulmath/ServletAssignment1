package problemSolution;
import java.util.*;

public class MostRepeatedWord {
    public static String findMostRepeatedWord(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+"); // Convert to lowercase and split by spaces
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each word
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Sort by frequency in descending order
        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String sentence = "This is a test. This test is just a test.";
        System.out.println("Most repeated word: " + findMostRepeatedWord(sentence)); 
        // Output: "test"
    }
}
