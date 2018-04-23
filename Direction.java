// rudimentary Direction enum (to be edited later)

public enum Direction {
	NORTH("north"),
	SOUTH("south"),
	EAST("east"),
	WEST("west"),
	
	NORTHEAST("northeast"),
	NORTHWEST("northwest"),
	SOUTHEAST("southeast"),
	SOUTHWEST("southwest");
	
	private final String name;
	
	private Direction(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
