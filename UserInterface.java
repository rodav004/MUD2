package mud;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;

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
	private JButton roomItemOne = new JButton();
	private JButton roomItemTwo = new JButton();
	private JLabel roomName = new JLabel();
	
	private JPanel inventoryPanel;
	private JLabel inventoryItemsLabel = new JLabel("Inventory");
	private JButton inventoryItemOne = new JButton("Apple");
	private JButton inventoryItemTwo = new JButton("Torch");
	private JButton inventoryItemThree = new JButton("Rock");
	private JButton inventoryItemFour = new JButton("Pen");
	

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
		roomItemOne.hide();
		roomItemTwo.hide();
		inventoryItemsLabel.hide();
		inventoryItemOne.hide();
		inventoryItemTwo.hide();
		inventoryItemThree.hide();
		inventoryItemFour.hide(); 
		
			inputButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (inc == 0) {
					String name = inputBox.getText();
					ArrayList<Item> inventory = new ArrayList<Item>();
					playerOne = new Character(name, "You have no description yet", Game.room1, inventory);
					outBox.setText("Hello " + name + "! You are in the " + Game.room1.getName());
					roomName.setText(Game.room1.getName());
					roomItemOne.setText(playerOne.location.getSingularItem(0));
					roomItemTwo.setText(playerOne.location.getSingularItem(1));
					roomItemOne.show();
					roomItemTwo.show();
					inventoryItemsLabel.show();
					inputBox.setText("Enter command");
					inc++;
					}
			else {
				String action = inputBox.getText();
				String result = Parse.parse(playerOne, action);
				if (playerOne.location.equals(Game.room1)) {
					roomName.setText(Game.room1.getName());
					roomItemOne.setText(playerOne.location.getSingularItem(0));
					roomItemTwo.setText(playerOne.location.getSingularItem(1));
				}
				else {
					roomName.setText(Game.room2.getName());
					roomItemOne.setText(playerOne.location.getSingularItem(0));
					roomItemTwo.setText(playerOne.location.getSingularItem(1));
				}
				outBox.setText(result);
				inputBox.setText("");
				}
			}
		}); 		

		roomItemOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = Parse.parse(playerOne, "get " + roomItemOne.getText());
				outBox.setText(action);
				if (playerOne.location.equals(Game.room1)) {
					inventoryItemOne.show();
					roomItemOne.hide();
				}
				if (playerOne.location.equals(Game.room2)) {
					inventoryItemThree.show();
					roomItemOne.hide();
				}
			}
		});
		
		roomItemTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = Parse.parse(playerOne, "get " + roomItemTwo.getText());
				outBox.setText(action);
				if (playerOne.location.equals(Game.room1)) {
					inventoryItemTwo.show();
					roomItemTwo.hide();
				}
				if (playerOne.location.equals(Game.room2)) {
					inventoryItemThree.show();
					roomItemTwo.hide();
				}
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
