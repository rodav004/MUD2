package mud;
import java.util.ArrayList;
/***
 * Game creates all of the items, MOBS, rooms and doors
 * @author Cara Lam, Rosie David, Michael Savich
 */
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
	public static ArrayList<MOB> phrases = new ArrayList<>();
	public static ArrayList<Item> items = new ArrayList<>(); 
	
	public static void start() {
		
		//Items
		Item laptop = new Item("laptop", "A necessary item for computer science students");
		Item notebook = new Item("notebook", "A notebook? Who uses these anymore?");
		Item paper = new Item("paper", "Probably good for writing");
		Item mints = new Item("mints", "But are they floor mints?");
		Item granolaBar = new Item("granola bar", "The only food Cara eats");
		Item trailMix = new Item("trail mix", "A good snack");
		Item apple = new Item("apple", "A delicious red fruit");
		Item backpack = new Item("backpack", "Useful for holding stuff", apple);
		Item note = new Item("note", "It looks private. Better not read it");		
		Item textbook = new Item("textbook", "Looks like its never been used", note);
		Item test = new Item("an old test", "Someone got a bad grade!");
		Item essay = new Item("essay", "Let's hope this wasn't printed during Jill's class!");
		Item printer = new Item("printer", "Just print to the x-lab instead!", essay);
		items.add(laptop);
		items.add(notebook);
		items.add(paper);
		items.add(mints);
		items.add(granolaBar);
		items.add(trailMix);
		items.add(apple);
		items.add(backpack);
		items.add(note);
		items.add(textbook);
		items.add(test);
		items.add(essay);
		items.add(printer);
		//xLab creation
		ArrayList<Item> itemsxLab = new ArrayList<>();
		itemsxLab.add(laptop);
		itemsxLab.add(notebook);
		itemsxLab.add(backpack);
		itemsxLab.add(granolaBar);
		Door[] doorsxLab = {null, null, null, null};
		xLab = new Room("X-Lab", "There's a hole in the floor. Wonder whats in it.", itemsxLab, doorsxLab);
		
		//jillsOffice creation 
		ArrayList<Item> itemsJillsOffice = new ArrayList<>();
		itemsJillsOffice.add(trailMix);
		Door[] doorsJillsOffice = {null, null, null, null};
		jillsOffice = new Room("Jill's Office", "There's some code written on the whiteboard.", itemsJillsOffice, doorsJillsOffice);
		
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
		itemsJR128.add(printer);
		Door[] doorsJR128 = {null, null, null, null};
		jr128 = new Room("JR128", "Everyone's favorite lecture classroom.", itemsJR128, doorsJR128);
		
		//HallwayOne creation
		ArrayList<Item> itemsHallOne = new ArrayList<>();
		itemsHallOne.add(test);
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
		bathroom = new Room("Bathrooms", "Theres no paper towels.", itemsBathroom, doorsBathroom);
		
		//JR130
		ArrayList<Item> itemsJR130 = new ArrayList<>();
		Door[] doorsJR130 = {null, null, null, null};
		jr130 = new Room("JR130", "", itemsJR130, doorsJR130);
		
		//Rachel's office
		ArrayList<Item> itemsRachelsOffice = new ArrayList<>();
		Door[] doorsRachelsOffice = {null, null, null, null};
		rachelsOffice = new Room("Rachel Grotheer's office", "There's integrals on the board.", itemsRachelsOffice, doorsRachelsOffice);
		
		//Robotics Lab
		ArrayList<Item> itemsRobLab = new ArrayList<>();
		Door[] doorsRobLab = {null, null, null, null};
		roboticsLab = new Room("Robotics Lab", "You don't see any robots.", itemsRobLab, doorsRobLab);
		
		//Stairs
		ArrayList<Item> itemsStairs = new ArrayList<>();
		Door[] doorsStairs = {null, null, null, null};
		stairs = new Room("Stairs", "But we all know you'd rather use the elevator", itemsStairs, doorsStairs);
		
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
		vmClassRoom = new Room("Van Meter Classroom", "Compsci students drop mints here", itemsVMClass, doorsVMClass);
		
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
		jill = new MOB("Jill", "Jill gets frozen yogurt on Friday", "Have you turned in the lab yet?", jillsOffice, null);
		tomK = new MOB("Tom K", "42", "42", tomsOffice, null);
		tomM = new MOB("Tom M","Founder of Floor Snacks.", "There's food in the floor if you want some.", xLab, null);
		muhammad = new MOB("Muhammad", "Muhammad is working on a lab.", "Is Jill in her office?", xLab, null);
		justinC = new MOB("Justin Clitheroe", "The office is not this Justins.", "Something obnoxious", xLab, null);
		cat = new MOB("Cat", "Cat is a comp sci major", "I'm so behind!", xLab, null);
		julian = new MOB("Julian", "Julian is actually doing work.", "*friendly wave*", xLab, null);
		econProf = new MOB("Econ Professor", "He teaches econ downstairs.", "Stop dropping mints in my classroom!", vmClassRoom, null);
		rosie = new MOB("Rosie", "Rosie is going to be in Costa Rica soon", "What's your major?", xLab, null);
		cara = new MOB("Cara", "Cara is going to Ghana", "How are you?", xLab, null);
		michael = new MOB("Michael", "Michael is coding", "Let's talk about gaming.", xLab, null);
		phrases.add(jill);
		phrases.add(tomK);
		phrases.add(tomM);
		phrases.add(muhammad);
		phrases.add(justinC);
		phrases.add(cat);
		phrases.add(julian);
		phrases.add(econProf);
		phrases.add(rosie);
		phrases.add(cara);
		phrases.add(michael);
		MobScheduler.scheduleMOB(jill);
		MobScheduler.scheduleMOB(tomK);
		MobScheduler.scheduleMOB(tomM);
		MobScheduler.scheduleMOB(muhammad);
		MobScheduler.scheduleMOB(justinC);
		MobScheduler.scheduleMOB(cat);
		MobScheduler.scheduleMOB(julian);
		MobScheduler.scheduleMOB(econProf);
		mobsTracker.add(jill);
		mobsTracker.add(tomK);
		mobsTracker.add(tomM);
		mobsTracker.add(muhammad);
		mobsTracker.add(justinC);
		mobsTracker.add(cat);
		mobsTracker.add(julian);
		mobsTracker.add(econProf);
	}
}