package mud;
import java.util.ArrayList;
/***
 * Room deals with creating rooms
 * @author Cara Lam, Rosie David, Michael Savich
 */
public class Room extends GameObject {
	ArrayList<Item> items;
	Door[] doors;
	
	public Room(String name, String description, ArrayList<Item> items, Door[] doors) {
		this.name = name;
		this.description = description;
		this.items = items;
		this.doors = doors;
	}
	
	public ArrayList<String> getItems() {
		ArrayList<Item> items = this.items;
		ArrayList<String> itemNames = new ArrayList<>();
		for (Item item : items) {
			itemNames.add(item.name);
		}
		return itemNames;
	}
	
	public String getSingularItem(int index) {
		return items.get(index).getName();
	}
	
	public boolean contains(Item i) {
		return items.contains(i);
	}
	
	public boolean hasDoor(int direction) {
		if (doors[direction] != null) {
			return true;
		}
		else return false;
	}
	
}