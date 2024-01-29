package se.lnu.Exercise3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WarAndPeace {

    public static void main(String[] args) {
        String text = readText();

        if (text != null) {
            String[] words = text.split("\\s+");
            System.out.println("Initial word count: " + words.length);

            long uniqueWordCount = Arrays.stream(words)
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue() == 1)
                    .count();

            System.out.println("Unique word count: " + uniqueWordCount);
        }
    }

    private static String readText() {
        try {
            Path filePath = Paths.get("war&peace", "war-and-peace.txt");
            return Files.readString(filePath);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return null;
        }
    }
}
