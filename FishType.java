// enumeration containing fish types: bottom feeders, shallow water fish, etc.
// NEED: more research about size and speed of each fish

public enum FishType {
	
	// bottom feeders
	HOGCHOKER("hogchoker", 0.1, 1),
	SILVERSIDE("atlantic_silverside", 0.1, 1),
	FLOUNDER("summer_flounder", 0.1, 1),
	
	// middle section (all live in schools)
	PERCH("white_perch", 0.1, 1),
	MINNOW("sheepshead_minnow", 0.1, 1),
	WEAKFISH("weakfish", 0.1, 1),
	
	// close to surface (all live in schools)
	SPOT("spot", 0.1, 1),
	MENHADEN("atlantic_menhaden", 0.1, 1),
	MUMMICHOG("mummichog", 0.1, 1);
  
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
