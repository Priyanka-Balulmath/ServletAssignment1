package problemSolution;

import java.util.*;

public class CharacterFrequency {
    public static void findCharacterFrequencies(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count occurrences
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Sort by frequency in descending order
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display results
        System.out.println("Most repeated character: " + sortedList.get(0).getKey());
        System.out.println("Character frequencies in descending order:");
        for (Map.Entry<Character, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String input = "hello world!";
        findCharacterFrequencies(input);
    }
}


