package mud;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class MobScheduler {

	private MobScheduler() {
	}

	private static final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void scheduleMOB(MOB theMob) {
		threadPool.submit(MobScheduler.runnableForMob(theMob));
	}

	public static Runnable runnableForMob(MOB theMob) {
		return () -> {
			while (true) {
				Random rand = new Random();
				int wait = rand.nextInt(30) + 1;

				List<Integer> validDirections = new ArrayList<>();
				Door[] theDoors = theMob.location.doors;
				for (int i = 0; i < theDoors.length; i++) {
					if (theDoors[i] != null) validDirections.add(i);
				}
				if (validDirections.size() == 0) continue;
				int door = validDirections.get(rand.nextInt(validDirections.size()));
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
				theMob.move(direction);
				UserInterface.mobDidMove(theMob);

				try {
					Thread.sleep(wait * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
