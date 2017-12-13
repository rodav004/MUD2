package mud;

public class Item extends GameObject {
	Item containedItem;
	boolean contains;
	
	public Item(String name, String description) {
	this.name = name;
	this.description = description;
	contains = false;
	}
	
	public Item(String name, String description, Item containedItem) {
		this.name = name;
		this.description = description;
		this.containedItem = containedItem;
		contains = true;
	}
	
	public boolean containsItem() {
		return contains;
	}
	
	public String getContainedItem(Player player, Item item) {
		String result = "";
		if (item.containsItem()) {
			player.inventory.add(item.containedItem);
			result = "The " + item.name + " contains " + item.containedItem.name + ". " + item.containedItem.name + " is now in your inventory.";
		}
		else result = "Sorry, the item does not contain another item.";
		return result;
	}
	
