package ident;

import java.util.*;

public class AnagramProcessor {

    public static void processAndPrint(String value) {
        List<String> result = process(value);
        System.out.println(result);
    }

    public static List<String> process(String value) {
        String cleaned = stripPunctuation(value, "'");
        String[] words = getValidWords(cleaned);

        Map<String, Set<String>> potentialAnagramsMap = new HashMap<>();
        for (String word : words) {
            if (word.length() > 1) {
                String key = getKey(word);
                Set<String> existingWords = potentialAnagramsMap.getOrDefault(key, new HashSet<>());
                if (existingWords.stream().noneMatch(word::equalsIgnoreCase)) {
                    existingWords.add(word);
                    potentialAnagramsMap.put(key, existingWords);
                }
            }
        }

        List<String> anagrams = new ArrayList<>();
        for (Set<String> potentialAnagrams : potentialAnagramsMap.values()) {
            if (potentialAnagrams.size() > 1) {
                anagrams.addAll(potentialAnagrams);
            }
        }

        return anagrams;
    }

    private static String getKey(String word) {
        String cleaned = stripPunctuation(word);
        char[] wordCharacters = cleaned.toLowerCase().toCharArray();
        Arrays.sort(wordCharacters);
        return new String(wordCharacters);
    }

    private static String[] getValidWords(String value) {
        return value.trim().split(" ");
    }

    private static String stripPunctuation(String value) {
        return stripPunctuation(value, "");
    }

    private static String stripPunctuation(String value, String excludingCharacters) {
        return value.replaceAll("[^a-zA-Z0-9 " + excludingCharacters + "]", "");
    }
}
