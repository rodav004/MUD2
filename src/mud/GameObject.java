package mud;


public class GameObject {
	String name;
	String description;
	
	public GameObject() {
	
	}
	
	private void setName(String newName) {
		this.name = newName;
	}
	
	public String getName() {
		return this.name;
	}
	
	private void setDescription(String newDescription) {
		this.description = newDescription;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	
}
