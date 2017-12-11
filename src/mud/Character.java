package mud;

import java.util.ArrayList;

public class Character extends GameObject {
	Room location;
	
	public Character(String name, String description, Room location) {
		this.description = description;
		this.name = name;
		this.location = location;
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
	
	public String look() {
		return location.getDescription();
	}
	

}
