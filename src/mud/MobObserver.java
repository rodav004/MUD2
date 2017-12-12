package mud;

import java.util.Observable;

public final class MobObserver extends Observable {

	private MobObserver() {}
	
	public static final MobObserver singleton = new MobObserver();
	
	public void update() {
		//System.out.println(this);
		//System.out.println("updateUI was called");
		setChanged();
		notifyObservers();
	}
}