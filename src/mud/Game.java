package mud;
import java.util.ArrayList;

public class Game {
	public static Room niceRoom;
	public static Room okayRoom;
	
	public static Room xLab;
	public static Room jillsOffice;
	public static Room tomsOffice;
	public static Room justinsOffice;
	public static Room jrLobby;
	public static Room jr128;
	public static Room hallwayOne;
	public static Room hallwayTwo;
	public static Room outside;
	public static Room bathroom;
	public static Room jr130;
	public static Room jrStairs;
	public static Room vanMeterLobby;
	public static Room vanMeterHallway;
	public static Room vmClassRoom;
	
	public static MOB jill;
	public static MOB tomK;
	public static MOB tomM;
	public static MOB muhammad;
	public static MOB justinBrody;
	public static MOB justinC;
	public static MOB cat;
	public static MOB julian;
	public static MOB econProf;
	public static MOB rosie;
	public static MOB cara;
	public static MOB michael;
	
	public static ArrayList<MOB> mobsTracker = new ArrayList<>();
	
	public static void start() {
		
		//Items
		Item laptop = new Item("laptop", "A necessary item for computer science students");
		Item notebook = new Item("notebook", "A notebook? Who uses these anymore?");
		Item textbook = new Item("textbook", "Looks like its never been opened");
		Item paper = new Item("paper", "Probably good for writing");
		Item mints = new Item("mints", "But are they floor mints?");
		Item granolaBar = new Item("granola bar", "Cara's only food");
		Item backpack = new Item("backpack", "Useful for holding stuff");
		Item trailMix = new Item("trail mix", "A good snack");
		
		//xLab creation
		ArrayList<Item> itemsxLab = new ArrayList<>();
		itemsxLab.add(laptop);
		itemsxLab.add(notebook);
		Door[] doorsxLab = {null, null, null, null};
		xLab = new Room("X-Lab", "A place for MACS students to do work.", itemsxLab, doorsxLab);
		
		//jillsOffice creation
		ArrayList<Item> itemsJillsOffice = new ArrayList<>();
		itemsJillsOffice.add(trailMix);
		Door[] doorsJillsOffice = {null, null, null, null};
		jillsOffice = new Room("Jill's Office", "The door is open.", itemsJillsOffice, doorsJillsOffice);
		
		//Tom's office creation
		ArrayList<Item> itemsTomsOffice = new ArrayList<>();
		Door[] doorsTomsOffice = {null, null, null, null};
		tomsOffice = new Room("Tom's Office", "The door is open.", itemsTomsOffice, doorsTomsOffice);
		
		//Justin's office creation
		ArrayList<Item> itemsJustinsOffice = new ArrayList<>();
		Door[] doorsJustinsOffice = {null, null, null, null};
		justinsOffice = new Room("Justin's Office", "The door is open.", itemsJustinsOffice, doorsJustinsOffice);
		
		//Julia Roger's Lobby creation
		ArrayList<Item> itemsJRLobby = new ArrayList<>();
		itemsJRLobby.add(backpack);
		Door[] doorsJRLobby = {null, null, null, null};
		jrLobby = new Room("Julia Roger's Lobby", "A place where students wait for class.", itemsJRLobby, doorsJRLobby);
		
		//JR128 creation
		ArrayList<Item> itemsJR128 = new ArrayList<>();
		itemsJR128.add(textbook);
		itemsJR128.add(paper);
		Door[] doorsJR128 = {null, null, null, null};
		jr128 = new Room("JR128", "Everyone's favorite lecture classroom.", itemsJR128, doorsJR128);
		
		//HallwayOne creation
		ArrayList<Item> itemsHallOne = new ArrayList<>();
		Door[] doorsHallOne = {null, null, null, null};
		hallwayOne = new Room("First stretch of hallway", "", itemsHallOne, doorsHallOne);
		
		//HallwayTwo creation
		ArrayList<Item> itemsHallTwo = new ArrayList<>();
		Door[] doorsHallTwo = {null, null, null, null};
		hallwayTwo = new Room("Second stretch of hallway", "", itemsHallTwo, doorsHallTwo);
		
		//Outside creation
		ArrayList<Item> itemsOutside = new ArrayList<>();
		Door[] doorsOutside = {null, null, null, null};
		outside = new Room("Outside", "There's a nice bench here.", itemsOutside, doorsOutside);
		
		// Room 1
		
		// Room 1 items
		Item torch = new Item("torch","This is a burning stick.");
		Item apple = new Item("apple","A yummy red fruit.");
		
		//Room 1 attributes
		ArrayList<Item> itemsniceRoom = new ArrayList<>();
			itemsniceRoom.add(apple);
			itemsniceRoom.add(torch);
		Door[] doorsniceRoom = {null,null,null,null};
		
		//Room 1 constructed
		niceRoom = new Room("Nice Room","This is a nice room.",itemsniceRoom, doorsniceRoom);
		
		//Room 2
		
		//Room 2 Items
		Item rock = new Item("rock","It's grayish and hard.");
		Item pen = new Item("pen","Useful for writing.");
		
		//Room 2 attributes
		ArrayList<Item> itemsokayRoom = new ArrayList<>();
			itemsokayRoom.add(rock);
			itemsokayRoom.add(pen);
		Door[] doorsokayRoom = {null,null,null,null};
		
		//Room 2 constructed
		okayRoom = new Room("Okay Room","This room is okay.",itemsokayRoom,doorsokayRoom);
		
		//Construct a door
		Door toOkayRoom = new Door(okayRoom);
		Door toNiceRoom = new Door(niceRoom);
		Door toxLab = new Door(xLab);
		Door toJillsOffice = new Door(jillsOffice);
		//Assign doors to rooms
		doorsniceRoom[1] = toxLab;
		doorsniceRoom[2] = toOkayRoom;
		doorsokayRoom[0] = toNiceRoom;
		doorsokayRoom[1] = toJillsOffice;
		doorsxLab[3] = toNiceRoom;
		doorsxLab[2] = toJillsOffice;
		doorsJillsOffice[3] = toOkayRoom;
		doorsJillsOffice[0] = toxLab;
		
		//MOBS
		jill = new MOB("Jill", "Jill is done with your shit.", "Turn in the lab.", niceRoom, null);
		tomK = new MOB("Tom K", "Tom is on sabatical.", "42", okayRoom, null);
		tomM = new MOB("Tom M","Founder of Floor Snacks.", "There's food in the floor if you want some.", xLab, null);
		muhammad = new MOB("Muhammad", "Muhammad is working on a lab.", "Is Jill in her office?", xLab, null);
		justinBrody = new MOB("Justin Brody", "", "", justinsOffice, null);
		justinC = new MOB("Justin Clitheroe", "", "Something obnoxious", xLab, null);
		cat = new MOB("Cat", "", "I'm so behind!", xLab, null);
		julian = new MOB("Julian", "Julian is actually doing work.", "*friendly wave*", xLab, null);
		econProf = new MOB("Econ Professor", "He teaches econ downstairs.", "Stop dropping mints in my classroom!", vmClassRoom, null);
		rosie = new MOB("Rosie", "", "", xLab, null);
		cara = new MOB("Cara", "", "", xLab, null);
		michael = new MOB("Michael", "", "", xLab, null);
		MobScheduler.scheduleMOB(jill);
		MobScheduler.scheduleMOB(tomK);
		MobScheduler.scheduleMOB(tomM);
		MobScheduler.scheduleMOB(muhammad);
		MobScheduler.scheduleMOB(justinBrody);
		MobScheduler.scheduleMOB(justinC);
		MobScheduler.scheduleMOB(cat);
		MobScheduler.scheduleMOB(julian);
		MobScheduler.scheduleMOB(econProf);
		mobsTracker.add(jill);
		mobsTracker.add(tomK);
		mobsTracker.add(tomM);
		mobsTracker.add(muhammad);
		mobsTracker.add(justinBrody);
		mobsTracker.add(justinC);
		mobsTracker.add(cat);
		mobsTracker.add(julian);
		mobsTracker.add(econProf);
	}
}
