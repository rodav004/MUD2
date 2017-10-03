package mud;
import java.util.Scanner;


public class UserInterface {
	
	private static Scanner input;

	public static void main(String[] args) {
		
		Game.start();

		input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();

		Character playerOne = new Character(name, "You have no description yet.", Game.room1, null);
		
		System.out.println("Hello " + name + "! You are in " + Game.room1.name);
		
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
		
			String result = Parser.parse(playerOne,command);
			System.out.println(result);
		}
		
	}

}
