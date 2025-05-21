package problemSolution;
import java.io.*;
import java.util.*;

public class MostRepeatedWordInFile {
    public static String findMostRepeatedWord(String fileName) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        reader.close();

        String mostRepeatedWord = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostRepeatedWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostRepeatedWord + " (Repeated " + maxCount + " times)";
    }

    public static void main(String[] args) throws IOException {
        String fileName = "C:/Users/priya/Downloads/sample.txt"; // Change this to your file path
        System.out.println("Most repeated word: " + findMostRepeatedWord(fileName));
    }
}
