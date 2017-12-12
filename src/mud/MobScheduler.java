package mud;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Observable;

public class MobScheduler{
	
	private MobScheduler() {
	}

	private static final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void scheduleMOB(MOB theMob) {
		threadPool.submit(MobScheduler.runnableForMob(theMob));
        }
		
	public static Runnable runnableForMob(MOB theMob) {
		return () -> {
			Random rand = new Random();
			while (true) {
			int wait = rand.nextInt(15) + 1;
			int door = rand.nextInt(4);
			//System.out.println(theMob.getName() + ": door is " + door);
			//System.out.println(theMob.getName() + ": wait is " + wait);
			if (theMob.location.hasDoor(door)) {
				String direction;
				switch (door) {
					case 0: direction = "north"; break;
					case 1: direction = "east";  break;
					case 2: direction = "south"; break;
					case 3: direction = "west";  break;
					default: direction = null;   break;
				}
				if (direction != null) {
					theMob.move(direction);
					System.out.println(theMob.move(direction));
					theMob.update();
				}
			}
			try {
				Thread.sleep(wait * 1000);	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		};
	}
	
}
