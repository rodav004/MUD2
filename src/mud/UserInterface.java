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

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;
import java.util.Observer;

public class UserInterface implements Observer{	
	
	private JTextField inputBox;
	private JTextField outBox;
	private JPanel inputPanel;
	private JButton inputButton;
	public static int inc = 0;
	private static Player playerOne;
	
	private JPanel roomPanel;
	private static JPanel roomItemPanel;
	private JLabel roomName = new JLabel();
	private JTextArea mobsInRoom = new JTextArea();
	
	private static JPanel inventoryPanel;
	private JLabel inventoryItemsLabel = new JLabel("Inventory");
	
	private JTextArea instructions = new JTextArea();
	
	private ArrayList<MOB> MOBSlist = new ArrayList<>();
	//private JList<String> mobsInRoom= new JList<String>();
	
	public JFrame getFrame() {
		return this.frm;
	}
	private JFrame frm;

	public UserInterface() {

		Game.mobMovement.addObserver(this);

		//creation of the frame
		this.frm = new JFrame("MUD");
		frm.setSize(500,300);

		//creation of input box
		this.inputBox = new JTextField(10);		

		inputBox.setEditable(true);
		inputBox.setText("Enter name");
		
		
		inputBox.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				inputBox.setText("");		
			}
			@Override public void focusLost(FocusEvent e) {	}
		});
				
		//creation of bottom bar where the player will enter actions
		this.inputButton = new JButton("Submit");
		this.outBox = new JTextField();
		outBox.setEditable(false);
		instructions.setEditable(false);
		mobsInRoom.setEditable(false);
		
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
					playerOne = new Player(name, "You have no description yet", Game.niceRoom, inventory);
					outBox.setText("Hello " + name + "! You are in the " + Game.niceRoom.getName());
					roomName.setText(playerOne.location.getName());
					inventoryItemsLabel.setVisible(true);
					mobsInRoom.setVisible(true);
					updateItems();
					inputBox.setText("Enter command");
					inc++;
				}
				else {
					String action = inputBox.getText();
					String result = Parser.parse(playerOne, action);
					roomName.setText(playerOne.location.name);
					updateItems();
					outBox.setText(result);
					inputBox.setText("");
				}
			}
		});
			
		this.inputPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		inputPanel.add(inputBox);
		inputPanel.add(inputButton);
		
		roomItemPanel = new JPanel();
		roomItemPanel.add(roomName);
		roomItemPanel.setLayout(new BoxLayout(roomItemPanel, BoxLayout.Y_AXIS));
		
		roomPanel = new JPanel();
		roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));
		roomPanel.add(roomItemPanel);
		roomPanel.add(mobsInRoom);
		
		inventoryPanel = new JPanel();
		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
		
		Container cp = frm.getContentPane();
		cp.add(outBox, BorderLayout.CENTER);
		cp.add(inputPanel, BorderLayout.SOUTH);
		cp.add(roomPanel, BorderLayout.WEST);
		cp.add(inventoryPanel, BorderLayout.EAST);
		cp.add(instructions, BorderLayout.NORTH);
	}

	public static void main(String[] args) {		
		Game.start();
		UserInterface UI = new UserInterface();
		
		inc = 0;
		UI.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI.getFrame().setSize(750,250);
		UI.getFrame().setVisible(true);	
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//mobsInRoom.append("test one \n");
		//System.out.println(mobsInRoom.getText());

		MOBSlist.removeAll(MOBSlist);
		for (MOB m : Game.mobsTracker) {
			//mobsInRoom.append("test two \n");
			//System.out.println(m.name + " is in " + m.location.getName());
			if (playerOne != null && m.location == playerOne.location ) {
				MOBSlist.add(m);
			}
		}
		mobsInRoom.setText("Characters in this room:\n");
		for (MOB m : MOBSlist) {
			//mobsInRoom.append("test three \n");
			mobsInRoom.append(m.getName() + "\n");
		}
	}
	
	public static void updateItems() {
		roomItemPanel.removeAll();
		for (Item i : playerOne.location.items) {
			JButton itemButton = new JButton(i.name);
			itemButton.addActionListener((e) -> {
				Parser.parse(playerOne, "get " + i.name);
				updateItems();
			});
			roomItemPanel.add(itemButton);
		}
		inventoryPanel.removeAll();
		for (Item i : playerOne.getItems()) {
			JButton itemButton = new JButton(i.name);
			itemButton.addActionListener((e) -> {
				Parser.parse(playerOne, "drop " + i.name);
				updateItems();
			});
			inventoryPanel.add(itemButton);
		}

	}
}
