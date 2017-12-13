package mud;
import java.util.ArrayList;

public class Character extends GameObject {
	public Room location;
	ArrayList<Item> inventory;
	String phrase;
	
	public Character(String name, String description, String phrase, Room location, ArrayList<Item> item) {
		this.description = description;
		this.name = name;
		this.location = location;
		this.inventory = item;
		this.phrase = phrase;
		location.characters.add(this);
	}
	
	/* public String getSingularItem(int index) {
		return inventory.get(index).getName();
	} */
	
	/**
	 * addItem adds an item to the inventory
	 * @param itemName takes in the item to be added to inventory
	 * @return result a String declaring whether the item was added or not
	 */
	
	public String addItem(String itemName)
	{
		ArrayList<Item> roomItems = new ArrayList<>(location.items);
		String result = null;
		if (roomItems.isEmpty()) {
			result = "There are no items in this room."; }
		for (Item items: roomItems)
		{
			String roomItemName = items.name;
			if (roomItemName.equals(itemName))
			{
				Item foundItem = items;
				inventory.add(foundItem);
				location.items.remove(foundItem);
				result = "Hooray! The item " + foundItem.getName() + " is now in your inventory. The description is: " + foundItem.getDescription() + ".";
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
		if (inventory.isEmpty()) {
			result = "Sorry, your inventory is empty.";  }

		for (Item items : inventoryItems) {
			if (items.name.equals(itemName))
			{
				Item foundItem = items;
				location.items.add(foundItem);
				inventory.remove(foundItem);
				result = "The item " + itemName + " has been removed from your inventory and is in " + location.name + ".";
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
				newRoom = "You enter " + exit.room.name + ". "+ exit.room.description;
				location = exit.room;
			}
			else {
				newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction.equals("south") || direction.equals("down")) {
			Door exit = location.doors[2];
			if (exit != null) {
				newRoom = "You enter " + exit.room.name + ". "+ exit.room.description;
				location = exit.room;
			}
			else {
				newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction.equals("east") || direction.equals("right")) {
			Door exit = location.doors[1];
			if (exit != null) {
				newRoom = "You enter " + exit.room.name + ". "+ exit.room.description;
				location = exit.room;
			}
			else {
				newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction.equals("west") || direction.equals("left")) {
			Door exit = location.doors[3];
			if (exit != null) {
				newRoom = "You enter " + exit.room.name + ". "+ exit.room.description;
				location = exit.room;
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
	
	public String speak(Player p) {
		if (p.location.equals(this.location)) {
			return this.phrase;
		}
		else {
			return "Sorry, that person is not in this room!";
		}
	}
	
	
}
