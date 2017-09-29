package mud;

public class Parse {

	public static void parse(String input)
	{
		if (input.equals("exit"))
		{
			System.out.println("You have ended the game.");
			System.exit(0);
		}
	}
}
