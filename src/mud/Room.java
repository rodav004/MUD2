package mud;
import java.util.ArrayList;
import java.util.List;

/**
* A room in the MUD.
* Contains Characters and Items.
* Note that Characters also have a reference to a room,
* so both fields should be modified at the same time to prevent an
* inconsistency.
*/
public class Room extends GameObject {
	ArrayList<Item> items;
	ArrayList<Character> characters = new ArrayList<Character>();
	Door[] doors;
	
	public Room(String name, String description, ArrayList<Item> items, Door[] doors) {
		this.name = name;
		this.description = description;
		this.items = items;
		this.doors = doors;
		this.characters = characters;
	}
	
	public ArrayList<Item> getItems() {
		return this.items;
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
