package mud;


public class Parser {
/**
 * 
 * @param playerOne the character doing the action
 * @param input the action to be done
 * @return a String saying the result of the action
 */	
	public static String parse(Character playerOne, String input) {
		String[] splitStrings = input.split(" ");
		String r = "test";
		
		if (splitStrings[0].equals("exit")) {
			System.exit(0);
			r = "Exiting the game... Goodbye!";
		}
		else if (splitStrings[0].equals("move")) {		
			r = playerOne.move(splitStrings[1]);
		}
		
		else if (splitStrings[0].equals("get")) {
			r = playerOne.addItem(splitStrings[1]);
		}
		else if (splitStrings[0].equals("drop")) {
			r = playerOne.removeItem(splitStrings[1]);
		}
		else if (splitStrings[0].equals("look")) {
			r = playerOne.look();
		}
		else {
			r = "Oops! I don't know what you're trying to say!";
		}
		return r;
	}

}
