package mud;
import java.util.Arrays;
import java.util.List;

public class Parser {
	
	public static String parse(Character playerOne, String input) {
		List<String> splitStrings = Arrays.asList(input.split(" "));
		
		if (splitStrings.get(0).equals("exit")) {
			System.exit(0);
			String r = "Exiting the game...";
		}
		else if (splitStrings.get(0).equals("move")) {
			playerOne.move(splitStrings.get(1));
			String r = playerOne.move(splitStrings.get(1));
		}
		
		else if (splitStrings.get(0).equals("get")) {
			playerOne.addItem(splitStrings.get(1));
			String r = playerOne.addItem(splitStrings.get(1));
		}
		else if (splitStrings.get(0).equals("drop")) {
			playerOne.removeItem(splitStrings.get(1));
			String r = playerOne.removeItem(splitStrings.get(1));
		}
		else {
			String r = "Oops! I don't know what you're trying to say!";
		}
		return r;
	}

}
