package mud;
import java.util.List;

public class Room extends GameObject {
	List<Item> items;
	List<Character> characters;
	Door[] doors;
	
	public Room(String name, String description, List<Item> items, List<Character> characters,Door[] doors) {
		this.name = name;
		this.description = description;
		this.items = items;
		this.characters = characters;
		this.doors = doors;
	}

	public boolean hasDoor(int doorIndex) {
		return doors[doorIndex] == null;
	}

public String getSingularItem(int index) {
		return items.get(index).getName();
	}
}
