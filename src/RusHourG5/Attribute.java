package RusHourG5;/**
 * The Attribute class represents an attribute of a car in the game.
 * It stores the car's id, direction, and position coordinates.
 */

public class Attribute {/**
 * The car's id.
 */
	private final int id;/**
 * The car's direction. true for horizontal, false for vertical.
 */
	private final boolean direction;
	/**
	 * The x-coordinate of the car's top-left corner.
	 */
	private final int x;
	/**
	 * The y-coordinate of the car's top-left corner.
	 */
	private final int y;
	/**
	 * Constructs a new Attribute object with the specified id, x-coordinate, y-coordinate, and direction.
	 * @param id The car's id.
	 * @param x The x-coordinate of the car's top-left corner.
	 * @param y The y-coordinate of the car's top-left corner.
	 * @param direction The car's direction. true for horizontal, false for vertical.
	 */
	
	public Attribute(int id,int x,int y,boolean direction){
		this.id = id;
		this.x = x;
		this.y = y;
		this.direction = direction;
		Car car = new Car(id, "");
		car.setDirection(direction);
	}/**
	 * Returns the car's id.
	 * @return The car's id.
	 */

	public int getId() {
		return id;
	}

	/**
	 * Returns the car's direction. true for horizontal, false for vertical.
	 * @return The car's direction.
	 */

	public boolean getDirection() {
		return direction;
	}

	/**
	 * Returns the x-coordinate of the car's top-left corner.
	 * @return The x-coordinate of the car's top-left corner.
	 */

	public int getX() {
		return x;
	}

	/**
	 * Returns the y-coordinate of the car's top-left corner.
	 * @return The y-coordinate of the car's top-left corner.
	 */

	public int getY() {
		return y;
	}


}
