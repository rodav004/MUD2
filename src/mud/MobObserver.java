package mud;

import java.util.Observable;
/***
 * MobObserver Creates an observable for when MOBs change rooms
 * @author Cara Lam, Rosie David, Michael Savich
 */

public final class MobObserver extends Observable {

	private MobObserver() {}
	
	public static final MobObserver singleton = new MobObserver();
	
	public void update() {
		setChanged();
		notifyObservers();
	}
}