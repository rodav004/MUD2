package mud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room extends GameObject {
	List<Item> items;
	Door[] doors;
	

	public Room(String name, String description, Item ...items) {
		this.name = name;
		this.description = description;
		this.items = new ArrayList<Item>(Arrays.asList(items));
		this.doors = new Door[4];
	}

	public Room(String name, String description) {
		 this(name, description, new Item[0]);
	}

	public boolean hasDoor(int doorIndex) {
		return doors[doorIndex] == null;
	}

	public String getSingularItem(int index) {
		return items.get(index).getName();
	}

}
