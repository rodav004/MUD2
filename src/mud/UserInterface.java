package mud;

import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

	private JTextField inputBox;
	private JTextField outBox;
	private JPanel inputPanel;
	private JButton inputButton;

	private static enum EntryState {
		NAME("Enter name"),
		COMMAND("Enter command");

		public String promptString;
		EntryState(String prompt) {
			promptString = prompt;
		}
	}
	private EntryState entryState = EntryState.NAME;

	private Player playerOne;
	
	private JPanel roomPanel = new JPanel();
	private JPanel roomItemPanel = new JPanel();
	private JLabel roomName = new JLabel();
	private JTextArea mobsInRoom = new JTextArea();

	private JPanel inventoryPanel = new JPanel();
	private JLabel inventoryItemsLabel = new JLabel("Inventory");
	
	private JTextArea instructions = new JTextArea();
	
	public JFrame getFrame() {
		return this.frm;
	}
	private JFrame frm;

	private static List<UserInterface> instances = new ArrayList<UserInterface>();

	public static void mobDidMove(MOB mob) {
		instances.forEach(UserInterface::update);
	}

	public UserInterface() {
		UserInterface.instances.add(this);

		//creation of the frame
		this.frm = new JFrame("MUD");
		frm.setSize(500,300);

		//creation of input box
		this.inputBox = new JTextField(10);

		inputBox.setEditable(true);
		inputBox.setText("Enter name");
		inputBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (inputBox.getText().equals(entryState.promptString)) {
					inputBox.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (inputBox.getText().equals("")) {
					inputBox.setText(entryState.promptString);
				}
			}
		});
				
		//creation of bottom bar where the player will enter actions
		this.inputButton = new JButton("Submit");
		this.outBox = new JTextField();
		outBox.setEditable(false);
		instructions.setEditable(false);
		mobsInRoom.setVisible(false);


		//setting the instructions text area
		instructions.setText(
				"To change rooms: move + north/south/east/west\n" +
				"To add an item to inventory, click the button\n" +
				"To drop an item: drop + item name"
		);
		
		outBox.setText("Welcome to our unnamed game!");
		inputButton.addActionListener((e) -> {
				if (entryState == EntryState.NAME) {

					String name = inputBox.getText();
					playerOne = Game.newPlayer(inputBox.getText());
					roomName.setText(playerOne.location.getName());
					outBox.setText("Hello " + name + "! You are in the " + roomName.getText());


					inventoryItemsLabel.setVisible(true);
					mobsInRoom.setVisible(true);
					entryState = EntryState.COMMAND;
					inputBox.setText(EntryState.COMMAND.promptString);
				} else {
					String action = Parser.parse(playerOne, inputBox.getText());
					outBox.setText(action);
				}
				update();
		});

		this.inputPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		inputPanel.add(inputBox);
		inputPanel.add(inputButton);
		
		roomItemPanel.add(roomName);
		roomItemPanel.setLayout(new BoxLayout(roomItemPanel, BoxLayout.Y_AXIS));
		
		roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));
		roomPanel.add(new JScrollPane(roomItemPanel));
		roomPanel.add(mobsInRoom);

		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
		
		Container cp = frm.getContentPane();
		cp.add(outBox, BorderLayout.CENTER);
		cp.add(inputPanel, BorderLayout.SOUTH);
		cp.add(roomPanel, BorderLayout.WEST);
		cp.add(new JScrollPane(inventoryPanel), BorderLayout.EAST);
		cp.add(instructions, BorderLayout.NORTH);
	}

	public void update() {
		roomItemPanel.removeAll();
		for (Item i : playerOne.location.items) {
			JButton itemButton = new JButton(i.name);
			itemButton.addActionListener((e) -> { Parser.parse(playerOne, "get " + i.name); update();});
			roomItemPanel.add(itemButton);
		}

		inventoryPanel.removeAll();
		for (Item i : playerOne.getItems()) {
			JButton itemButton = new JButton(i.name);
			itemButton.addActionListener((e) -> { Parser.parse(playerOne, "drop " + i.name); update();});
			inventoryPanel.add(itemButton);
		}

		mobsInRoom.setText("Other Characters:\n");
		playerOne.location.characters.stream()
				.filter((o) -> (o instanceof MOB))
				.map(Character::getName)
				.map(StringUtils::appendNewline)
				.forEach(mobsInRoom::append);

		inputBox.setText(entryState.promptString);

		frm.revalidate();
		frm.repaint();
	}

	public static void main(String[] args) {
		Game.start();
		UserInterface UI = new UserInterface();
		UI.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI.getFrame().setSize(750,250);
		UI.getFrame().setVisible(true);	
	}

}

