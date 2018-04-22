// enumeration containing fish types: bottom feeders, shallow water fish, etc.
// INCOMPLETE: need more species

public enum FishType {
	HOGCHOKER("hogchoker", 0.01, 0.1); // example of a type of bottom feeder
	
	private final String name;
	private final double speed;
	private final double size;
	
	private FishType(final String name, double speed, double size) {
		this.name = name;
		this.speed = speed;
		this.size = size;
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public String getName() {
		return name;
	}
	public double getSize() {
		return size;
	}
	
	
}
