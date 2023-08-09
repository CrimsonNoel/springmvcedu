package auth;

public class Auth {

	private String id;
	private String name;
//constructor, setter, getter, toString
	public Auth(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Auth [id=" + id + ", name=" + name + "]";
	}

	
	
	

}
