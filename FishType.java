// enumeration containing fish types: bottom feeders, shallow water fish, etc.
// INCOMPLETE: need more species

public enum FishType {
	HOGCHOKER("hogchoker"); // example of a type of bottom feeder
	
	private final String name;
	
	private FishType(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
}
