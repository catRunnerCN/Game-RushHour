package RusHourG5;

//import java.awt.Color;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;

import javax.swing.JButton;
import java.io.Serial;/**
 * The Car class represents a car in the game. It extends JButton and adds an id, a name, and a direction attribute.
 */

public class Car extends JButton{

	/**
	 * The car's id.
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	int id;//±àºÅ
	/**
	 * The car's name.
	 */
	String name;
	/**
	 * The car's direction. true for horizontal, false for vertical.
	 */
	boolean direction;

	public void setDirection(boolean direction) {
        this.direction = direction;
    }
	/**
	 * Returns the car's id.
	 */
	public Car(int id,String str){
		super("");
		name = str;
		this.id = id;
	}/**
	 * Sets the car's id.
	 */
	
	public int getId() {
		return id;
	}

	
	
}
