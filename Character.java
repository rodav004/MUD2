package mud;
import java.util.List;
import java.util.ArrayList;

public class Character extends GameObject {
	Room location;
	final List<Item> inventory = new ArrayList<>();
	
	public Character(String name, String description, Room location, List<Item> inventory) {
		this.description = description;
		this.name = name;
		this.location = location;
		this.inventory.addAll(inventory);
	}
	/**
	 * 
	 * @return an List of the names of the items in inventory
	 */
	public List<String> getItems() {
		List<Item> items = this.inventory;
		List<String> itemNames = new ArrayList<>();
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
		List<Item> roomItems = new ArrayList<>(location.items);
		String result = null;
		if (roomItems.isEmpty()) {
			result = "Sorry! The item is not in this room.";
		}
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
		List<Item> inventoryItems = new ArrayList<>(this.inventory);
		List<Item> roomItems = new ArrayList<>(location.items);
		if (inventory.isEmpty()) {
			result = "Sorry, your inventory is empty.";
		}
		for (Item items : inventoryItems) {
			if (items.name.equals(itemName))
			{
				Item foundItem = items;
				location.items.add(foundItem);
				inventory.remove(foundItem);
				result = "The item " + itemName + " has been removed from your inventory and is in " + location.name + ".";
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

		direction = direction.toLowerCase();
		Door exit = null;
		boolean validDirection = true;

		switch (direction) {
			case "up":
			case "north":
				exit = location.doors[0];
				break;
			case "down":
			case "south":
				exit = this.location.doors[2];
				break;
			case "right":
			case "east":
				exit = location.doors[1];
				break;
			case "left":
			case "west":
				exit = location.doors[3];
				break;
			default:
				validDirection = false;
				break;
		}

		if (validDirection && exit != null) {
			newRoom = "You enter the " + exit.room.name + ". "+ exit.room.description;
			this.location = exit.room;
		}
		else if (validDirection && exit == null) {
			newRoom = "There is no door in that direction!";
		}
		else if (!validDirection) {
			newRoom = "Sorry, that is not a valid direction!";
		}
		
		return newRoom;
		
	}

	public String look() {
		return location.getDescription();
	}
	
}
