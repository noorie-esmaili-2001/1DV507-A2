package ne222hz_assign2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class WarAndPeace {

	public static void main(String[] args) {
		long wordCount;
		String text = readText("C:\\Users\\noori\\OneDrive\\Skrivbord\\WarAndPeace.txt"); // My own method for readText
		String[] words = text.split(" ");
		Stream stream = Arrays.stream(words);
		System.out.println("Initial word count: " + words.length);

//		Predicate<String> predicate = s -> s.matches("[0-9]");
//		wordCount = stream.filter(predicate).count();
		
		wordCount = stream.distinct().count();
		System.out.println(wordCount);
	}

	private static String readText(String filePath) {
		String text = "";
		try {
			text = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;

	}

}