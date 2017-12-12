package mud;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {		
		Game.start();
		
		UserInterface UI1 = new UserInterface();
		
		MobObserver.singleton.addObserver(UI1);
		UI1.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI1.getFrame().setSize(750,500);
		UI1.getFrame().setVisible(true);
		
		UserInterface UI2 = new UserInterface();
		
		MobObserver.singleton.addObserver(UI2);
		UI2.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI2.getFrame().setSize(750,500);
		UI2.getFrame().setVisible(true);
	}
	
}
