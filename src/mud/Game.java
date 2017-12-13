package mud;
import java.util.ArrayList;

public class Game {
	public static Room xLab;
	public static Room jillsOffice;
	public static Room tomsOffice;
	public static Room justinsOffice;
	public static Room rachelsOffice;
	public static Room jrLobby;
	public static Room jr128;
	public static Room jr130;
	public static Room roboticsLab;
	public static Room hallwayOne;
	public static Room hallwayTwo;
	public static Room hallwayThree;
	public static Room hallwayFour;
	public static Room hallwayFive;
	public static Room outside;
	public static Room bathroom;
	public static Room stairs;
	public static Room vanMeterLobby;
	public static Room vanMeterHallway;
	public static Room vmClassRoom;
	public static Room theVan;
	
	
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
	
	public static ArrayList<Character> mobsTracker = new ArrayList<>();
	
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
		
		//HallwayThree
		ArrayList<Item> itemsHallThree = new ArrayList<>();
		Door[] doorsHallThree = {null, null, null, null};
		hallwayThree = new Room("Third stretch of hallway", "", itemsHallThree, doorsHallThree);
		
		//HallwayFour
		ArrayList<Item> itemsHallFour = new ArrayList<>();
		Door[] doorsHallFour = {null, null, null, null};
		hallwayFour = new Room("Fourth stretch of hallway", "", itemsHallFour, doorsHallFour);
		
		//HallwayFive
		ArrayList<Item> itemsHallFive = new ArrayList<>();
		Door[] doorsHallFive = {null, null, null, null};
		hallwayFive = new Room("Fifth stretch of hallway", "", itemsHallFive, doorsHallFive);
		
		//Outside creation
		ArrayList<Item> itemsOutside = new ArrayList<>();
		Door[] doorsOutside = {null, null, null, null};
		outside = new Room("Outside", "There's a nice bench here.", itemsOutside, doorsOutside);
		
		//Bathroom
		ArrayList<Item> itemsBathroom = new ArrayList<>();
		Door[] doorsBathroom = {null, null, null, null};
		bathroom = new Room("Bathrooms", "Why would there be food in here?", itemsBathroom, doorsBathroom);
		
		//JR130
		ArrayList<Item> itemsJR130 = new ArrayList<>();
		Door[] doorsJR130 = {null, null, null, null};
		jr130 = new Room("JR130", "", itemsJR130, doorsJR130);
		
		//Rachel's office
		ArrayList<Item> itemsRachelsOffice = new ArrayList<>();
		Door[] doorsRachelsOffice = {null, null, null, null};
		rachelsOffice = new Room("Rachel Grotheer's office", "", itemsRachelsOffice, doorsRachelsOffice);
		
		//Robotics Lab
		ArrayList<Item> itemsRobLab = new ArrayList<>();
		Door[] doorsRobLab = {null, null, null, null};
		roboticsLab = new Room("Robotics Lab", "", itemsRobLab, doorsRobLab);
		
		//Stairs
		ArrayList<Item> itemsStairs = new ArrayList<>();
		Door[] doorsStairs = {null, null, null, null};
		stairs = new Room("Stairs", "", itemsStairs, doorsStairs);
		
		//VM lobby
		ArrayList<Item> itemsVMLobby = new ArrayList<>();
		Door[] doorsVMLobby = {null, null, null, null};
		vanMeterLobby = new Room("Van Meter Lobby", "", itemsVMLobby, doorsVMLobby);
		
		//VM hall
		ArrayList<Item> itemsVMHall = new ArrayList<>();
		Door[] doorsVMHall = {null, null, null, null};
		vanMeterHallway = new Room("Van Meter Hallway", "", itemsVMHall, doorsVMHall);
		
		//VM Class
		ArrayList<Item> itemsVMClass = new ArrayList<>();
		itemsVMClass.add(mints);
		Door[] doorsVMClass = {null, null, null, null};
		vmClassRoom = new Room("Van Meter Classroom", "", itemsVMClass, doorsVMClass);
		
		//The Van
		ArrayList<Item> itemsTheVan = new ArrayList<>();
		Door[] doorsTheVan = {null, null, null, null};
		theVan = new Room("The Van", "Why is there no food here?", itemsTheVan, doorsTheVan);
		
		//Construct a door
		Door toOutside = new Door(outside);
		Door toJRLobby = new Door(jrLobby);
		Door toHallOne = new Door(hallwayOne);
		Door toHallTwo = new Door(hallwayTwo);
		Door toHallThree = new Door(hallwayThree);
		Door toHallFour = new Door(hallwayFour);
		Door toHallFive = new Door(hallwayFive);
		Door toxLab = new Door(xLab);
		Door toJR128 = new Door(jr128);
		Door toJR130 = new Door(jr130);
		Door toRobLab = new Door(roboticsLab);
		Door toBathroom = new Door(bathroom);
		Door toJillsOffice = new Door(jillsOffice);
		Door toJustinsOffice = new Door(justinsOffice);
		Door toTomsOffice = new Door(tomsOffice);
		Door toRachelsOffice = new Door(rachelsOffice);
		Door toStairs = new Door(stairs);
		Door toVMLobby = new Door(vanMeterLobby);
		Door toVMHall = new Door(vanMeterHallway);
		Door toVMClass = new Door(vmClassRoom);
		Door toVan = new Door(theVan);
		//Assign doors to rooms
		doorsOutside[0] = toJRLobby;
		doorsJRLobby[2] = toOutside;
		doorsJRLobby[1] = toHallOne;
		doorsHallOne[3] = toJRLobby;
		doorsHallOne[1] = toBathroom;
		doorsHallOne[2] = toHallTwo;
		doorsBathroom[3] = toHallOne;
		doorsHallTwo[0] = toHallOne;
		doorsHallTwo[1] = toJillsOffice;
		doorsHallTwo[2] = toHallThree;
		doorsHallTwo[3] = toxLab;
		doorsxLab[1] = toHallTwo;
		doorsJR128[1] = toHallThree;
		doorsJR130[1] = toHallFour;
		doorsRobLab[1] = toHallFive;
		doorsHallThree[0] = toHallTwo;
		doorsHallThree[1] = toJustinsOffice;
		doorsHallThree[2] = toHallFour;
		doorsHallThree[3] = toJR128;
		doorsHallFour[0] = toHallThree;
		doorsHallFour[1] = toTomsOffice;
		doorsHallFour[2] = toHallFive;
		doorsHallFour[3] = toJR130;
		doorsHallFive[0] = toHallFour;
		doorsHallFive[1] = toRachelsOffice;
		doorsHallFive[2] = toStairs;
		doorsHallFive[3] = toRobLab;
		doorsJillsOffice[3] = toHallTwo;
		doorsJustinsOffice[3] = toHallThree;
		doorsTomsOffice[3] = toHallFour;
		doorsRachelsOffice[3] = toHallFive;
		doorsStairs[0] = toHallFive;
		doorsStairs[2] = toVMLobby;
		doorsVMLobby[0] = toStairs;
		doorsVMLobby[3] = toVMHall;
		doorsVMLobby[1] = toVan;
		doorsTheVan[3] = toVMLobby;
		doorsVMHall[1] = toVMLobby;
		doorsVMHall[0] = toVMClass;
		doorsVMClass[2] = toVMHall;
		
		//MOBS
		jill = new MOB("Jill", "Jill is done with your shit.", "Turn in the lab.", jillsOffice, null);
		tomK = new MOB("Tom K", "Tom is on sabatical.", "42", tomsOffice, null);
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