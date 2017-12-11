package mud;
import java.util.Random;
import java.util.ArrayList;
public class MOB extends Character{
	static String phrase;
	static Item item;
	
	public MOB(String name, String description, String phrase, Room location, ArrayList<Item> item) {
		super(name, description, location, item);
		this.phrase = phrase;
	}
	
	public void update() {
		MobObserver.singleton.updateUI();
	}
}
