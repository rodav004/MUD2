package mud;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

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
	
	private JPanel roomItemPanel;
	private JButton roomItemOne = new JButton("apple");
	private JButton roomItemTwo = new JButton("torch");
	private JButton roomItemThree = new JButton("rock");
	private JButton roomItemFour = new JButton("pen");
	private JLabel roomName = new JLabel();
	
	private JPanel inventoryPanel;
	private JLabel inventoryItemsLabel = new JLabel("Inventory");
	private JButton inventoryItemOne = new JButton("apple");
	private JButton inventoryItemTwo = new JButton("torch");
	private JButton inventoryItemThree = new JButton("rock");
	private JButton inventoryItemFour = new JButton("pen");
	
	private JTextArea instructions = new JTextArea();
	
	public JFrame getFrame() {
		return this.frm;
	}
	private JFrame frm;

	public UserInterface() { 
		
		this.frm = new JFrame("MUD");
		frm.setSize(500,300);

		this.inputBox = new JTextField(10);

		inputBox.setEditable(true);
		inputBox.setText("Enter name");
				inputBox.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!(inputBox.getText().equals("Enter name") || inputBox.getText().equals("Enter command"))) {
				}
				else {
					inputBox.setText("");
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!(inputBox.getText().equals("Enter name") || inputBox.getText().equals("Enter command"))) {
				}
				else {
					inputBox.setText("");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (!(inputBox.getText().equals("Enter name")
					|| inputBox.getText().equals("Enter command")
					|| inputBox.getText().equals(""))) {	
				}
				else if (inc == 0) {
						inputBox.setText("Enter name");
				}
				else {
					inputBox.setText("Enter command");
				}
			}
		});
		this.inputButton = new JButton("Submit");
		this.outBox = new JTextField();
		outBox.setEditable(false);
		instructions.setEditable(false);
		
		roomItemOne.hide();
		roomItemTwo.hide();
		roomItemThree.hide();
		roomItemFour.hide();
		inventoryItemsLabel.hide();
		inventoryItemOne.hide();
		inventoryItemTwo.hide();
		inventoryItemThree.hide();
		inventoryItemFour.hide(); 
		
		String move = "To change rooms: move + north/south/east/west";
		String getItem = "To add an item to inventory, click the button";
		String dropItem = "To drop an item: remove + item name";
		instructions.setText(move + "\n" + getItem + "\n" + dropItem);
		outBox.setText("Welcome to our unnamed game!");
			inputButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (inc == 0) {
					String name = inputBox.getText();
					ArrayList<Item> inventory = new ArrayList<Item>();
					playerOne = new Character(name, "You have no description yet", Game.room1, inventory);
					outBox.setText("Hello " + name + "! You are in the " + Game.room1.getName());
					roomName.setText(Game.room1.getName());
					roomItemOne.show();
					roomItemTwo.show();
					inventoryItemsLabel.show();
					inputBox.setText("Enter command");
					inc++;
					}
			else {
				String action = inputBox.getText();
				String result = Parser.parse(playerOne, action);
				if (playerOne.location.equals(Game.room1)) {
					roomName.setText(Game.room1.getName());
					roomItemThree.hide();
					roomItemFour.hide();
					if (inventoryItemOne.isVisible()) {
						roomItemOne.hide();
					}
					else roomItemOne.show();
					if (inventoryItemTwo.isVisible()) {
						roomItemTwo.hide();
					}
					else roomItemTwo.show();
				}
				if (playerOne.location.equals(Game.room2)) {
					roomName.setText(Game.room2.getName());
					roomItemOne.hide();
					roomItemTwo.hide();
					if (inventoryItemThree.isVisible()) {
						roomItemThree.hide();
					}
					else roomItemThree.show();
					if (inventoryItemFour.isVisible()) {
						roomItemFour.hide();
					}
					else roomItemFour.show();
				}
				if (action.contains("drop")) {
					if (action.contains("apple")) {
						inventoryItemOne.hide();
						if (playerOne.location.equals(Game.room1)) {
						roomItemOne.show();
						}
					}
					if (action.contains("torch")) {
						inventoryItemTwo.hide();
						if (playerOne.location.equals(Game.room1)) {
							roomItemTwo.show();
						}
					}
					if (action.contains("rock")) {
						inventoryItemThree.hide();
						if (playerOne.location.equals(Game.room2)) {
							roomItemThree.show();
						}
					}
					if (action.contains("pen")) {
						inventoryItemFour.hide();
						if (playerOne.location.equals(Game.room2)) {
							roomItemFour.show();
						}
					}
				}
				outBox.setText(result);
				inputBox.setText("");
				}
			}
		}); 		

		roomItemOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = Parser.parse(playerOne, "get " + roomItemOne.getText());
				outBox.setText(action);
				roomItemOne.hide();
				inventoryItemOne.show();
			}
		});
		
		roomItemTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = Parser.parse(playerOne, "get " + roomItemTwo.getText());
				outBox.setText(action);
				roomItemTwo.hide();
				inventoryItemTwo.show();
			}
		});
		
		roomItemThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = Parser.parse(playerOne, "get " + roomItemThree.getText());
				outBox.setText(action);
				roomItemThree.hide();
				inventoryItemThree.show();
			}
		});
		
		roomItemFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = Parser.parse(playerOne, "get " + roomItemFour.getText());
				outBox.setText(action);
				roomItemFour.hide();
				inventoryItemFour.show();
			}
		});
		
			
		this.inputPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		inputPanel.add(inputBox);
		inputPanel.add(inputButton);
		
		roomItemPanel = new JPanel();
		roomItemPanel.setLayout(new BoxLayout(roomItemPanel, BoxLayout.Y_AXIS));
		roomItemPanel.add(roomName);
		roomItemPanel.add(roomItemOne);
		roomItemPanel.add(roomItemTwo);
		roomItemPanel.add(roomItemThree);
		roomItemPanel.add(roomItemFour);
		
		inventoryPanel = new JPanel();
		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
		inventoryPanel.add(inventoryItemsLabel);
		inventoryPanel.add(inventoryItemOne);
		inventoryPanel.add(inventoryItemTwo);
		inventoryPanel.add(inventoryItemThree);
		inventoryPanel.add(inventoryItemFour); 
		
		Container cp = frm.getContentPane();
		cp.add(outBox, BorderLayout.CENTER);
		cp.add(inputPanel, BorderLayout.SOUTH);
		cp.add(roomItemPanel, BorderLayout.WEST);
		cp.add(inventoryPanel, BorderLayout.EAST);
		cp.add(instructions, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		
		Game.start();
		inc = 0;

		/*input = new Scanner(System.in);
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
