package mud;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class MobScheduler {

	private MobScheduler() {}

	public static final MobScheduler singleton = new MobScheduler();

	private static final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void scheduleMOB(MOB theMob) {
		threadPool.submit(MobScheduler.runnableForMob(theMob));
        }
		
	public static Runnable runnableForMob(MOB theMob) {
		return () -> {
			while (true) {
				Random rand = new Random();
				int wait = rand.nextInt(30) + 1;
				int door = rand.nextInt(3);
				if (theMob.location.hasDoor(door)) {
					String direction;
					switch (door) {
						case 0:
							direction = "north";
							break;
						case 1:
							direction = "east";
							break;
						case 2:
							direction = "south";
							break;
						case 3:
							direction = "west";
							break;
						default:
							direction = null;
							break;
					}
					if (direction != null) {
						theMob.move(direction);
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
