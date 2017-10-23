package mud;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class UserInterface {
	
	private static Scanner input;
	private JTextField inputBox;
	private JTextField outBox;
	private JList<String> displayInventory;
	private JList<String> displayRoomItems;
	private JLabel displayActions;
	private JPanel inputPanel;
	private JButton inputButton;
	public JFrame getFrame() {
		return this.frm;
	}
	private JFrame frm;

	public UserInterface() {
		this.frm = new JFrame("MUD");
		frm.setSize(300,300);

		this.inputBox = new JTextField();

		inputBox.setEditable(true);
		inputBox.setText("Enter command");
		//displayActions.setText("What is your name?");
		//String name = inputBox.getText();
		
		this.inputButton = new JButton("Submit");
		this.outBox = new JTextField();
		outBox.setEditable(false);

		this.inputPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		inputPanel.add(inputBox);
		inputPanel.add(inputButton);

		Container cp = frm.getContentPane();
		cp.add(outBox, BorderLayout.CENTER);
		//cp.add(displayActions, BorderLayout.NORTH);
		cp.add(inputPanel, BorderLayout.SOUTH);
		//cp.add(displayInventory, BorderLayout.WEST);
		//cp.add(displayRoomItems, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		
		Game.start();

		/*input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		ArrayList<Item> inventory = new ArrayList<Item>();
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
			String result = Parser.parse(playerOne, command);
			System.out.println(result);
		}*/
		UserInterface UI = new UserInterface();
		UI.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//UI.getFrame().setTitle(Game.room1.getName());
		UI.getFrame().setSize(500,250);
		UI.getFrame().setVisible(true);
		
	}

}
