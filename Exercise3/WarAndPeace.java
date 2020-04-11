package ne222hz_assign2.Exercise3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WarAndPeace {

	public static void main(String[] args) {
		long uniqueWordCount;
		String text = readText("C:\\Users\\noori\\OneDrive\\Skrivbord\\Java\\WarAndPeace.txt"); // My own method for
		String[] words = text.split(" ");
		System.out.println("Initial word count: " + words.length);

		Stream<String> stream = Arrays.stream(words);

		uniqueWordCount = stream.map(String::toLowerCase).collect(Collectors.groupingBy(w -> w, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).count();

		System.out.println("uniqueWordCount = " + uniqueWordCount);

	}

	private static String readText(String filePath) {
		String content = null;
		try {
			content = Files.readAllLines(Paths.get(filePath)).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

}