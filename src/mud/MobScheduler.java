package mud;
import java.util.ArrayList;
import java.util.Random;
public class MobScheduler extends MOB implements Runnable{

	public MobScheduler(String name, String description, String phrase, Room location, ArrayList<Item> item) {
		super(name, description, phrase, location, item);
	}

	public Runnable moveRoom() {
		return () -> {
			Random rand = new Random();
			int wait = rand.nextInt(30) + 1;
			int door = rand.nextInt(3);
			if (location.hasDoor(door)) {
				String direction;
				if (door == 0) {
					direction = "north";
				}
				if (door == 1) {
					direction = "east";
				}
				if (door == 2) {
					direction = "south";
				}
				else {
					direction = "west";
				}
				try {
					Thread.sleep(wait*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				MOB.move(direction);
			}
		};
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub	
	}

}

