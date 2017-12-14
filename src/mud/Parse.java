package mud;
import java.util.Arrays;
/***
 * Parse parses the input and returns a String value
 * @author Cara Lam, Rosie David, Michael Savich
 */
import java.util.List;
import java.util.ArrayList;
public class Parse {
/**
 * @author Cara Lam, Rosie David, Michael Savich
 * @param playerOne the character doing the arr[0]
 * @param input the arr[0] to be done
 * @return a String saying the result of the arr[0]
 */
	public static String parse(Player playerOne, String input) {
		String[] arr = input.split(" ");
		String r;
		if (arr[0].equals("move")) {
			r = playerOne.move(arr[1]);
		}
		else if (arr[0].equals("get")) {
			r = playerOne.addItem(arr[1]);
		}
		else if (arr[0].equals("drop")) {
			r = playerOne.removeItem(arr[1]);
		}
		else if (arr[0].equals("examine")) {
			Item itemWanted = null;
			for (Item item : playerOne.location.items) {
				if (arr[1].equals(item.name)) {
					itemWanted = item;
				}
			}
			r  = itemWanted.getContainedItem(playerOne, itemWanted);
		}
		else if (arr[0].equals("talk")) {
			arr[1] = arr[2];
			MOB find = null;
			for (MOB character : Game.phrases) {
				if (character.name.toLowerCase().equals(arr[1].toLowerCase())) {
					find = character;
				}
			}
			r = find.phrase;
		}
		else if (arr[0].equals("describe")) {
			if (arr[1].equals("room")) {
				r = playerOne.location.description;
			}
			else if (arr[1].equals("character")) {
				Character find = null;
				for (Character finder : Game.mobsTracker) {
					if (finder.name.toLowerCase().equals(arr[2].toLowerCase())) {
						find = finder;
					}
				}
				r = find.description;
			}
			else if (arr[1].equals("item")) {
				Item find = null;
				for (Item it : Game.items) {
					if (it.name.toLowerCase().equals(arr[2].toLowerCase())) {
						find = it;
					}
				}
				r = find.description;
			}
			else r = "Sorry, that doesn't have a description.";
		}
		else {
			r = "Oops! I don't know what you're trying to say!";
		}
		return r;
	}

}
