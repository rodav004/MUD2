package mud;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {		
		Game.start();
		UserInterface UI = new UserInterface();
		UserInterface UI2 = new UserInterface();
		
		MobObserver.singleton.addObserver(UI);
		MobObserver.singleton.addObserver(UI2);
		UI.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI.getFrame().setSize(750,250);
		UI.getFrame().setVisible(true);	
		UI2.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI2.getFrame().setSize(750, 250);
		UI2.getFrame().setLocation(750,0);
		UI2.getFrame().setVisible(true);  
	}
}
