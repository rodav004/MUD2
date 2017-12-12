package mud;

public class MOB extends Character {
	
	private String phrase;

	public MOB(String name, String description, String phrase, Room location) {
		super(name, description, location);
		this.phrase = phrase;
	}

	@Override
	public String move(String direction) {
		String result = super.move(direction);
		System.out.println(this.getName() + " is in " + this.location.getName());
		return result;
	}
	
}
