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
import javax.swing.JTextArea;
import javax.swing.JList;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Observable;
import java.util.Observer;
public class UserInterface implements Observer{	
	
	private JTextField inputBox;
	private JTextField outBox;
	private JPanel inputPanel;
	private JButton inputButton;
	public static int inc = 0;
	private Character playerOne;
	
	private JPanel roomPanel;
	private JPanel roomItemPanel;
	private JPanel roomMobs;
	private JButton roomItemOne = new JButton("apple");
	private JButton roomItemTwo = new JButton("torch");
	private JButton roomItemThree = new JButton("rock");
	private JButton roomItemFour = new JButton("pen");
	private JLabel roomName = new JLabel();
	private JTextArea mobsInRoom = new DebuggyJTextArea();
	
	private JPanel inventoryPanel;
	private JLabel inventoryItemsLabel = new JLabel("Inventory");
	private JButton inventoryItemOne = new JButton("apple");
	private JButton inventoryItemTwo = new JButton("torch");
	private JButton inventoryItemThree = new JButton("rock");
	private JButton inventoryItemFour = new JButton("pen");
	
	private JTextArea instructions = new JTextArea();
	
	private ArrayList<JButton> roomItemButtons = new ArrayList<>();
	private ArrayList<JButton> inventoryItemButtons = new ArrayList<>();
	private ArrayList<MOB> MOBSlist = new ArrayList<>();
	//private JList<String> mobsInRoom= new JList<String>();
	
	public JFrame getFrame() {
		return this.frm;
	}
	private JFrame frm;

	public UserInterface() { 
		//adding all buttons to the corresponding arraylist
		roomItemButtons.add(roomItemOne);
		roomItemButtons.add(roomItemTwo);
		roomItemButtons.add(roomItemThree);
		roomItemButtons.add(roomItemFour);
		
		inventoryItemButtons.add(inventoryItemOne);
		inventoryItemButtons.add(inventoryItemTwo);
		inventoryItemButtons.add(inventoryItemThree);
		inventoryItemButtons.add(inventoryItemFour);
		
		//creation of the frame
		this.frm = new JFrame("MUD");
		frm.setSize(500,300);

		//creation of input box
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
				
		//creation of bottom bar where the player will enter actions
		this.inputButton = new JButton("Submit");
		this.outBox = new JTextField();
		outBox.setEditable(false);
		instructions.setEditable(false);
		mobsInRoom.setVisible(false);
		
		//setting room and inventory items to be hidden
		for (JButton button: roomItemButtons) {
			button.setVisible(false);
		}
		for (JButton button: inventoryItemButtons) {
			button.setVisible(false);
		}
		
		//setting the instructions text area
		instructions.append("To change rooms: move + north/south/east/west \n");
		instructions.append("To add an item to inventory, click the button \n");
		instructions.append("To drop an item: drop + item name");
		
		outBox.setText("Welcome to our unnamed game!");
			inputButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (inc == 0) {
					String name = inputBox.getText();
					ArrayList<Item> inventory = new ArrayList<Item>();
					playerOne = new Character(name, "You have no description yet", Game.niceRoom, inventory);
					outBox.setText("Hello " + name + "! You are in the " + Game.niceRoom.getName());
					roomName.setText(playerOne.location.getName());
					roomItemOne.setVisible(true);
					roomItemTwo.setVisible(true);
					inventoryItemsLabel.setVisible(true);
					mobsInRoom.setVisible(true);
					inputBox.setText("Enter command");
					inc++;
					}
			else {
				String action = inputBox.getText();
				String result = Parse.parse(playerOne, action);
				if (playerOne.location.equals(Game.niceRoom)) {
					roomName.setText(Game.niceRoom.getName());
					roomItemThree.setVisible(false);
					roomItemFour.setVisible(false);
					if (inventoryItemOne.isVisible()) {
						roomItemOne.setVisible(false);
					}
					else roomItemOne.setVisible(true);
					if (inventoryItemTwo.isVisible()) {
						roomItemTwo.setVisible(false);
					}
					else roomItemTwo.setVisible(true);
				}
				if (playerOne.location.equals(Game.okayRoom)) {
					roomName.setText(Game.okayRoom.getName());
					roomItemOne.setVisible(false);
					roomItemTwo.setVisible(false);
					if (inventoryItemThree.isVisible()) {
						roomItemThree.setVisible(false);
					}
					else roomItemThree.setVisible(true);
					if (inventoryItemFour.isVisible()) {
						roomItemFour.setVisible(false);
					}
					else roomItemFour.setVisible(true);
				}
				if (action.contains("drop")) {
					if (action.contains("apple")) {
						inventoryItemOne.setVisible(false);
						if (playerOne.location.equals(Game.niceRoom)) {
						roomItemOne.setVisible(true);
						}
					}
					if (action.contains("torch")) {
						inventoryItemTwo.setVisible(false);
						if (playerOne.location.equals(Game.niceRoom)) {
							roomItemTwo.setVisible(true);
						}
					}
					if (action.contains("rock")) {
						inventoryItemThree.setVisible(false);
						if (playerOne.location.equals(Game.okayRoom)) {
							roomItemThree.setVisible(true);
						}
					}
					if (action.contains("pen")) {
						inventoryItemFour.setVisible(false);
						if (playerOne.location.equals(Game.okayRoom)) {
							roomItemFour.setVisible(true);
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
				String action = Parse.parse(playerOne, "get " + roomItemOne.getText());
				outBox.setText(action);
				roomItemOne.setVisible(false);
				inventoryItemOne.setVisible(true);
			}
		});
		
		roomItemTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = Parse.parse(playerOne, "get " + roomItemTwo.getText());
				outBox.setText(action);
				roomItemTwo.setVisible(false);
				inventoryItemTwo.setVisible(true);
			}
		});
		
		roomItemThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = Parse.parse(playerOne, "get " + roomItemThree.getText());
				outBox.setText(action);
				roomItemThree.setVisible(false);
				inventoryItemThree.setVisible(true);
			}
		});
		
		roomItemFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = Parse.parse(playerOne, "get " + roomItemFour.getText());
				outBox.setText(action);
				roomItemFour.setVisible(false);
				inventoryItemFour.setVisible(true);
			}
		});
		
			
		this.inputPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		inputPanel.add(inputBox);
		inputPanel.add(inputButton);
		
		roomItemPanel = new JPanel();
		roomItemPanel.add(roomName);
		roomItemPanel.setLayout(new BoxLayout(roomItemPanel, BoxLayout.Y_AXIS));
		for (JButton button: roomItemButtons) {
			roomItemPanel.add(button);
		}
		
		roomPanel = new JPanel();
		roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));
		roomPanel.add(roomItemPanel);
		roomPanel.add(mobsInRoom);
		
		inventoryPanel = new JPanel();
		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
		for (JButton button: inventoryItemButtons) {
			inventoryPanel.add(button);
		}
		
		Container cp = frm.getContentPane();
		cp.add(outBox, BorderLayout.CENTER);
		cp.add(inputPanel, BorderLayout.SOUTH);
		cp.add(roomPanel, BorderLayout.WEST);
		cp.add(inventoryPanel, BorderLayout.EAST);
		cp.add(instructions, BorderLayout.NORTH);
	}

	public static void main(String[] args) {		
		Game.start();
		UserInterface ui = new UserInterface();
		MobObserver.singleton.addObserver(ui);
		inc = 0;
		UserInterface UI = new UserInterface();
		UI.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI.getFrame().setSize(750,250);
		UI.getFrame().setVisible(true);	
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(mobsInRoom.getText());
		mobsInRoom.append("test one \n");
		System.out.println(mobsInRoom.getText());

		MOBSlist.removeAll(MOBSlist);
		for (MOB m : Game.mobsTracker) {
			mobsInRoom.append("test two \n");
			System.out.println(m.name + " is in " + m.location.getName());
			if (playerOne != null && m.location == playerOne.location ) {
				MOBSlist.add(m);
			}
		}
		for (MOB m : MOBSlist) {
			mobsInRoom.append("test three \n");
			mobsInRoom.append(m.getName() + "\n");
		}
	}
}

class DebuggyJTextArea extends JTextArea {
	public void append(String str) {
		super.append(str);
		System.out.println("Set with " + str);
		System.out.println(this.getText());
	}
}
