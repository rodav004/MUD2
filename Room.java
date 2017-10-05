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
}
