package mud;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
	public static Room niceRoom;
	public static Room okayRoom;

	public static List<Player> players = new ArrayList<>();

	private static List<Room> rooms;

	private static List<Item> items;
	
	private static ArrayList<MOB> mobsTracker = new ArrayList<>();

	public static List<Character> nearbyCharacters(Player player) {
		return Stream.concat(
				players.stream(),
				mobsTracker.stream())
				.filter((c) -> c.location == player.location)
				.collect(Collectors.toList());
	}

	public static Observable mobMovement = new Observable() {
		@Override
		public void notifyObservers() {
			this.setChanged();
			super.notifyObservers();
		}
	};

	public static Player newPlayer(String playerName) {
		Player player = new Player(playerName, "You have no description yet", Game.rooms.get(0), new ArrayList<>());
		players.add(player);
		return player;
	}

	public static void start() {
		rooms = Arrays.asList(
				new Room(
						"X-Lab", "A place for MACS students to do work.",
						new Item("laptop", "A necessary item for computer science students"),
						new Item("notebook", "A notebook? Who uses these anymore?"),
						new Item("mints", "But are they floor mints?")
				),
				new Room(
						"Jill's Office", "The door is open.",
						new Item("trail mix","A good snack")
				),
				new Room(
						"Tom's Office", "The door is open."
				),
				new Room(
						"Justin's Office", "The door is open."
				),
				new Room(
						"Julia Roger's Lobby", "A place where students wait for class.",
						new Item("backpack", "Useful for holding stuff")
				),
				new Room(
						"JR128", "Everyone's favorite lecture classroom.",
						new Item("paper", "Probably good for writing"),
						new Item("textbook", "Looks like its never been opened")
				),
				new Room(
						"Outside", "There's a nice bench here."
				),
				new Room(
						"First stretch of hallway", ""
				),
				new Room(
						"Second stretch of hallway", "",
						new Item("granola bar", "Cara's only food")
				),
				new Room(
						"Okay Room", "This room is okay.",
						new Item("rock","It's grayish and hard."),
						new Item("pen","Useful for writing.")
				),
				new Room(
						"Nice Room","This is a nice room.",
						new Item("torch","This is a burning stick."),
						new Item("apple","A yummy red fruit.")
				)
		);

		connectRooms("Nice Room", 1, "X-Lab");
		connectRooms("Nice Room", 2, "Okay Room");
		connectRooms("Okay Room", 1, "Jill's Office");
		connectRooms("X-Lab", 2, "Jill's Office");

		List<MOB> mobs = Arrays.asList(
				new MOB("Jill", "Jill is done with your shit.", "Turn in the lab.", findRoom("Nice Room")),
				new MOB("Tom K", "Tom is on sabatical.", "42", findRoom("Okay Room")),
				new MOB("Justin Brody", "", "", findRoom("Justin's Office")),
				new MOB("Tom M","Founder of Floor Snacks.", "There's food in the floor if you want some.", findRoom("X-Lab")),
				new MOB("Muhammad", "Muhammad is working on a lab.", "Is Jill in her office?", findRoom("X-Lab")),
				new MOB("Justin Clitheroe", "", "Something obnoxious", findRoom("X-Lab")),
				new MOB("Cat", "", "I'm so behind!", findRoom("X-Lab")),
				new MOB("Julian", "Julian is actually doing work.", "*friendly wave*", findRoom("X-Lab")),
				new MOB("Rosie", "", "", findRoom("X-Lab")),
				new MOB("Cara", "", "", findRoom("X-Lab")),
				new MOB("Michael", "", "", findRoom("X-Lab"))
		);
		mobs.forEach(MobScheduler::scheduleMOB);
		mobsTracker.addAll(mobs);
	}

	private static void addItem(String roomName, String ...itemName) {
		Room theRoom = findRoom(roomName);
		Arrays.stream(itemName)
				.map(Game::findItem)
				.forEach(theRoom.items::add);
	}

	private static Item findItem(String itemName) {
		return items.stream().filter((i) -> i.name.equalsIgnoreCase(itemName)).findFirst().get();
	}
	private static Room findRoom(String roomName) {
		return rooms.stream().filter((r) -> r.name.equalsIgnoreCase(roomName)).findFirst().get();
	}

	private static void connectRooms(String roomName, int direction, String connectedRoomName) {
		rooms.stream().map(Room::getName).forEach(System.out::println);
		Room theRoom = rooms.stream().filter((r) -> r.getName().equalsIgnoreCase(connectedRoomName)).findFirst().get();
		Room otherRoom = rooms.stream().filter((r) -> r.getName().equalsIgnoreCase(connectedRoomName)).findFirst().get();
		theRoom.doors[direction] = new Door(otherRoom);

		int oppositeDirection = direction + ((direction < 2) ? 2 : -2);
		otherRoom.doors[oppositeDirection] = new Door(theRoom);
	}

}
