package mud;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Parse {
/**
 * 
 * @param playerOne the character doing the action
 * @param input the action to be done
 * @return a String saying the result of the action
 */
	public static String parse(Character playerOne, String input) {
		String[] arr = input.split(" ");
		String action = arr[0];
		String direction = arr[1];
		String r;
		if (action.equals("move")) {
			r = playerOne.move(direction);
		}
		else if (action.equals("get")) {
			r = playerOne.addItem(direction);
		}
		else if (action.equals("drop")) {
			r = playerOne.removeItem(direction);
		}
		else if (action.equals("examine")) {
			String get;
			ArrayList<String> items = playerOne.location.getItems();
			for (String i : items) {
				if (i.equals(direction)) {
					get = i;
				}
			}
			Item getter = null;
			ArrayList<Item> what = playerOne.location.items;
			for (Item x : what) {
				if (x.getName().equals(getter)) {
					getter = x;
				}
			}
			r = getter.getContainedItem(playerOne, getter);
		}
		else {
			r = "Oops! I don't know what you're trying to say!";
		}
		return r;
	}

}
