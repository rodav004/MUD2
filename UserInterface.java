package mud;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class UserInterface {
	
	private JTextField inputBox;
	private JTextField outBox;
	private JPanel inputPanel;
	private JButton inputButton;
	public static int inc = 0;
	private Character playerOne;

	public JFrame getFrame() {
		return this.frm;
	}
	private JFrame frm;

	private String inputBoxPlaceholder = "Enter name";
	public UserInterface() {
		this.frm = new JFrame("MUD");
		frm.setSize(500,300);

		this.inputBox = new JTextField(10);

		inputBox.setEditable(true);
		inputBox.setText("Enter name");
		inputBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				inputBox.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (inputBox.getText().equals("")) {
					inputBox.setText(inputBoxPlaceholder);
				}
			}
		});
		
		this.inputButton = new JButton("Submit");
		this.outBox = new JTextField();
		outBox.setEditable(false);
		
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (inc == 0) {
					String name = inputBox.getText();
					ArrayList<Item> inventory = new ArrayList<Item>();
					playerOne = new Character(name, "You have no description yet", Game.room1, inventory);
					outBox.setText("Hello " + name + "! You are in the " + Game.room1.getName());
					inputBoxPlaceholder = "Enter command";
					inc++;
				}
				else {
					String action = inputBox.getText();
					String result = Parser.parse(playerOne, action);
					outBox.setText(result);
				}

				inputBox.setText(inputBoxPlaceholder);
			}
		});

		this.inputPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		inputPanel.add(inputBox);
		inputPanel.add(inputButton);
		inputButton.requestFocusInWindow();
		Container cp = frm.getContentPane();
		cp.add(outBox, BorderLayout.CENTER);
		//cp.add(displayActions, BorderLayout.NORTH);
		cp.add(inputPanel, BorderLayout.SOUTH);
		//cp.add(displayInventory, BorderLayout.WEST);
		//cp.add(displayRoomItems, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		
		Game.start();
		inc = 0;

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
		UI.getFrame().setSize(750,250);
		UI.getFrame().setVisible(true);
		
	}

}
