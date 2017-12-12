package mud;

import java.util.ArrayList;

public class Player extends Character {
	
	private ArrayList<Item> inventory;

	public Player(String name, String description, Room location, ArrayList<Item> inventory) {
		super(name, description, location, inventory);
		this.inventory = inventory;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return an ArrayList of the items in inventory
	 */
	public ArrayList<Item> getItems() {
		return this.inventory;
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
	
	public String look() {
		return location.getDescription();
	}
	
}
