package mud;

import java.util.ArrayList;

public class Character extends GameObject {
	Room location;
	
	public Character(String name, String description, Room location) {
		this.description = description;
		this.name = name;
		this.location = location;
		this.location.characters.add(this);
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
			synchronized (this) {
				this.location.characters.remove(this);
				this.location = exit.room;
				this.location.characters.add(this);
			}
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
