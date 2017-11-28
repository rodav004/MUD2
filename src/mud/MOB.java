package mud;

import java.util.ArrayList;
import java.util.Random;

public class MOB extends Character {
	
	private Item mobItem;
	private String speech;
	
	public MOB(String name, String description, Room location, Item mobItem, String speech) {
		super(name, description, location);
		this.mobItem = mobItem;
		this.speech = speech;
		// TODO Auto-generated constructor stub
	}
	
	public Item getMobItem(){
		return mobItem;
	}
	
	public String getSpeech() {
		return speech;
	}
	
	private Random rand = new Random();
	public void step() {
	}
}