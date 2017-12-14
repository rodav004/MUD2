package mud;
import java.util.Random;
import java.util.ArrayList;
/***
 * MOB Creates MOBs and contains methods specific to MOBs 
 * @author Cara Lam, Rosie David, Michael Savich
 */

public class MOB extends Character{
	String phrase;
	Item item;
	
	public MOB(String name, String description, String phrase, Room location, ArrayList<Item> item) {
		super(name, description, location, item);
		this.phrase = phrase;
	}
	
	public String getPhrase() {
		return phrase;
	}
	
	public void update() {
		MobObserver.singleton.update();
	}
}