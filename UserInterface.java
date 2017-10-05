package mud;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class UserInterface {
	
	private static Scanner input;

	public static void main(String[] args) {
		
		Game.start();

		input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		List<Item> inventory = new ArrayList<Item>();
		Character playerOne = new Character(name, "You have no description yet.", Game.room1, inventory);
		
		String roomName = Game.room1.getName();
		System.out.println("Hello " + name + "! You are in " + roomName);
		
		boolean end = false;
		while (!end) {
			System.out.println("Enter command");
			String command = input.nextLine();
			if (command.equals("exit"))
			{
				end = true;
				System.out.println("You have ended the game");
				System.exit(0);
			}
			String result = Parse.parse(playerOne, command);
			System.out.println(result);
		}
		
		
	}

}
