// enumeration containing fish types: bottom feeders, shallow water fish, etc.
// INCOMPLETE: need more species

public enum FishType {
	HOGCHOKER("hogchoker", 12, 20); // example of a type of bottom feeder
	
	private final String name;
	private final int speed;
	private final int size;
	
	private FishType(final String name, int speed, int size) {
		this.name = name;
		this.speed = speed;
		this.size = size;
	}
	public int getSpeed(){
		return speed;
	}
	
	public String getName() {
		return name;
	}
	public int getSize() {
		return size;
	}
	
	
}
