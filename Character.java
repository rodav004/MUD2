
package mud;
import java.util.ArrayList;

public class Character extends GameObject {
	Room location;
	ArrayList<Item> inventory;
	
	public Character(String name, String description, Room location, ArrayList<Item> inventory) {
		this.description = description;
		this.name = name;
		this.location = location;
		this.inventory = inventory;
	}
	
	public ArrayList<String> getItems() {
		ArrayList<Item> items = this.inventory;
		ArrayList<String> itemNames = new ArrayList<>();
		for (Item item : items) {
			itemNames.add(item.name);
		}
		return itemNames;
	}
	//Add an item to inventory
	public String addItem(String itemName)
	{
		ArrayList<Item> roomItems = location.items;
		String result = "";
		for (Item items: roomItems)
		{
			if (items.getName().equals(itemName))
			{
				Item foundItem = items;
				inventory.add(foundItem);
				roomItems.remove(foundItem);
				result = "Hooray! The item " + foundItem.getName() + " is now in your inventory. The description is " + foundItem.getDescription() + ".";
			}
			else
			{
				result = "Sorry! The item is not in this room.";
			}
		}
		return result;
	}
	
        public String removeItem(String itemName)
	{
		String result = "";
		ArrayList<Item> inventoryItems = this.inventory;
		ArrayList<Item> roomItems = location.items;
		for (Item items : inventoryItems)
			if (items.getName().equals(itemName))
			{
				Item foundItem = items;
				roomItems.add(foundItem);
				inventory.remove(foundItem);
				result = "The item " + itemName + " has been removed from your inventory and is in " + location + ".";
			}
			else result = "The item " + itemName + " is not in your inventory.";
		return result;
	}
	
	public String move(String direction) {
		String newRoom = null;
		
		if (direction.equals("north") || direction.equals("up")) {
			Door exit = location.doors[0];
			if (exit != null) {
				newRoom = "You enter the " + exit.room.name + ". "+ exit.room.description;
				this.location = exit.room;
			}
			else {
				newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction.equals("south") || direction.equals("down")) {
			Door exit = this.location.doors[2];
			if (exit != null) {
				newRoom = "You enter the " + exit.room.name + ". "+ exit.room.description;
				this.location = exit.room;
			}
			else {
				newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction.equals("east") || direction.equals("right")) {
			Door exit = location.doors[1];
			if (exit != null) {
				newRoom = "You enter the " + exit.room.name + ". "+ exit.room.description;
				this.location = exit.room;
			}
			else {
				newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction.equals("west") || direction.equals("left")) {
			Door exit = location.doors[3];
			if (exit != null) {
				newRoom = "You enter the " + exit.room.name + ". "+ exit.room.description;
				this.location = exit.room;
			}
			else {
				newRoom = "There is not a door in that direction!";
			}
		}
		else{
			newRoom = "Sorry, that is not a valid direction!";
		}
		
		return newRoom;
		
	}
	
	
}
