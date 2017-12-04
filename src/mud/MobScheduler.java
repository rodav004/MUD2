package mud;
import java.util.ArrayList;
import java.util.Random;
public class MobScheduler extends MOB implements Runnable{

	public MobScheduler(String name, String description, String phrase, Room location, ArrayList<Item> item) {
		super(name, description, phrase, location, item);
	}

	public Runnable runnableForMob(MOB theMob) {
		return () -> {
			Random rand = new Random();
			int wait = rand.nextInt(30) + 1;
			int door = rand.nextInt(3);
			if (location.hasDoor(door)) {
				String direction;
				switch (door) {
					case 0: direction = "north"; break;
					case 1: direction = "east";  break;
					case 2: direction = "south"; break;
					case 3: direction = "west";  break;
					default: direction = null;
				}
				return (Runnable) () -> {
					if (direction != null) {
						try {
							Thread.sleep(wait * 1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						theMob.move(direction);
					}
				};
			}
		};
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub	
	}

}

