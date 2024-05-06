package org.gk.reception.util;

public class Utilities {
    // Function to capitalize the first letter of each word in a string
    public static String capitalizeWords(String str) {
        StringBuilder result = new StringBuilder();

        // Split the string into words
        String[] words = str.split("\\s+");

        // Capitalize the first letter of each word
        for (String word : words) {
            if (!word.isEmpty()) { // Check if the word is not empty
                char firstLetter = Character.toUpperCase(word.charAt(0));
                result.append(firstLetter).append(word.substring(1)).append(" ");
            }
        }
        return result.toString();
    }

}
