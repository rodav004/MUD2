package mud;
import java.util.Scanner;


public class UserInterface {
	
	private static Scanner input;

	public static void main(String[] args) {
		
		Game.start();

 		String start = "Hello! Your name is Bob and you are in the Nice Room.";
 		System.out.println(start);
 		input = new Scanner(System.in);
 		String direction = input.next();
		direction = direction.toString();
		String r = Game.person.move(direction);
		System.out.println(r);
		
		creating a new charcater hopefully
		input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.next();

		Character playerOne = new Character(name, "You have no description yet.", Game.room1, null);
		
		System.out.println(Game.room1.getName());
		
		System.out.println("Hello " + name + "! You are in " + Game.room1.name);
		do {
			System.out.println("Enter command")
			String command = input.next();
			//Game.parse(command); idk what to call parse on
		} while (!command.equals("exit")); //also unworking but the concept is there
		
		
	}

}
