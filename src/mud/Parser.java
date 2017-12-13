package mud;


public class Parser {
/**
 * 
 * @param playerOne the character doing the action
 * @param input the action to be done
 * @return a String saying the result of the action
 */	
	public static String parse(Player playerOne, String input) {
		input.toLowerCase();
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
		else if (splitStrings[0].equals("talk")) {
			r = playerOne.talkTo(splitStrings[2]);
		}
		else if (splitStrings[0].equals("examine")) {
			Item itemWanted = null;
			for (Item item : playerOne.location.items) {
				if (splitStrings[1].equals(item.name)) {
					itemWanted = item;
				}
			}
			return itemWanted.getContainedItem(playerOne, itemWanted);
		}
		else {
			r = "Oops! I don't know what you're trying to say!";
		}
		return r;
	}

}
