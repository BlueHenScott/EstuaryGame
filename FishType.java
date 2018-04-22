// enumeration containing fish types: bottom feeders, shallow water fish, etc.
// INCOMPLETE: need more species

public enum FishType {
	HOGCHOKER("hogchoker", 12, 0.1); // example of a type of bottom feeder
	
	private final String name;
	private final int speed;
	private final double size;
	
	private FishType(final String name, int speed, double size) {
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
	public double getSize() {
		return size;
	}
	
	
}
