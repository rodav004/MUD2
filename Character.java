package mud;
import java.util.List;
import java.util.ArrayList;

public class Character extends GameObject {
	Room location;
	List<Item> inventory;
	
	public Character(String name, String description, Room location, List<Item> inventory) {
		this.description = description;
		this.name = name;
		this.location = location;
		this.inventory = inventory;
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
		for (Item items: roomItems)
		{
			String roomItemName = items.name;
			if (roomItemName.equals(itemName))
			{
				Item foundItem = items;
				inventory.add(foundItem);
				roomItems.remove(foundItem);
				result = "Hooray! The item " + foundItem.getName() + " is now in your inventory. The description is: " + foundItem.getDescription() + ".";
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
		for (Item items : inventoryItems) {
			if (items.name.equals(itemName))
			{
				Item foundItem = items;
				roomItems.add(foundItem);
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

		switch (direction) {
			case "up":
			case "north":
				Door exit = location.doors[0];
				if (exit != null) {
					newRoom = "You enter the " + exit.room.name + ". "+ exit.room.description;
					this.location = exit.room;
				}
				else {
					newRoom = "There is not a door in that direction!";
				}
				break;
			case "down":
			case "south":
				Door exit = this.location.doors[2];
				if (exit != null) {
					newRoom = "You enter the " + exit.room.name + ". "+ exit.room.description;
					this.location = exit.room;
				}
				else {
					newRoom = "There is not a door in that direction!";
				}
				break;
			case "right":
			case "east":
				Door exit = location.doors[1];
				if (exit != null) {
					newRoom = "You enter the " + exit.room.name + ". "+ exit.room.description;
					this.location = exit.room;
				}	
				else {
					newRoom = "There is not a door in that direction!";
				}
				break;
			case "left":
			case "west":
				Door exit = location.doors[3];
				if (exit != null) {
					newRoom = "You enter the " + exit.room.name + ". "+ exit.room.description;
					this.location = exit.room;
				}
				else {
					newRoom = "There is not a door in that direction!";
				}
				break;
			default:
				newRoom = "Sorry, that is not a valid direction!";
				break;
			}
		}
		
		return newRoom;
		
	}
	
	
}
