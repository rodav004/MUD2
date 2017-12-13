package mud;

import java.util.Observable;

public final class MobObserver extends Observable {

	private MobObserver() {}
	
	public static final MobObserver singleton = new MobObserver();
	
	public void update() {
		setChanged();
		notifyObservers();
	}
}