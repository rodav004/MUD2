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
	/**
	 * 
	 * @return an ArrayList of the names of the items in inventory
	 */
	public ArrayList<String> getItems() {
		ArrayList<Item> items = this.inventory;
		ArrayList<String> itemNames = new ArrayList<>();
		for (Item item : items) {
			itemNames.add(item.name);
		}
		return itemNames;
	}
	/**
	 * addItem adds an item to the inventory
	 * @param itemName takes in the item to be added to inventory
	 * @return result a String declaring whether the item was added or not
	 */
	
	public String addItem(String itemName)
	{
		ArrayList<Item> roomItems = new ArrayList<>(location.items);
		String result = null;
		for (Item items: roomItems)
		{
			if (items.name.equals(itemName))
			{
				Item foundItem = items;
				inventory.add(foundItem);
				location.items.remove(foundItem);
				result = "Hooray! The item " + foundItem.getName() + " is now in your inventory. The description is: " + foundItem.getDescription();
				break;
			}
			else result = "Sorry! The item is not in this room.";
		}
		return result;
	}
	/**
	 * removeItem removes an item from inventory
	 * @param itemName method takes in the name of the item to be found
	 * @return String declaring if the item has been removed or if the item is not in inventory
	 */
	public String removeItem(String itemName)
	{
		String result = null;
		ArrayList<Item> inventoryItems = new ArrayList<>(this.inventory);
		for (Item items : inventoryItems) {
			if (items.name.equals(itemName))
			{
				Item foundItem = items;
				location.items.add(foundItem);
				inventory.remove(foundItem);
				result = "The item " + itemName + " has been removed from your inventory and is in the " + location.name + ".";
				break;
			}
			else result = "The item " + itemName + " is not in your inventory.";
			}
		return result;
	}
	
	/**
	 * move changes the room a character is in
	 * @param direction checks for door and moves in said direction
	 * @return String stating whether or not the character has moved rooms
	 */
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
