// enumeration containing fish types: bottom feeders, shallow water fish, etc.
// NEED: more research about size and speed of each fish

public enum FishType {
	
	// bottom feeders
	HOGCHOKER("hogchoker", 0.01, 0.1),
	SILVERSIDE("Atlantic silverside", 0.01, 0.1),
	FLOUNDER("summer flounder", 0.01, 0.1),
	
	// middle section (all live in schools)
	PERCH("white perch", 0.01, 0.1),
	MINNOW("sheepshead minnow", 0.01, 0.1),
	WEAKFISH("weakfish", 0.01, 0.1),
	
	// close to surface (all live in schools)
	SPOT("spot", 0.01, 0.1),
	MENHADEN("Atlantic menhaden", 0.01, 0.1),
	MUMMICHOG("mummichog", 0.01, 0.1);
	
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
