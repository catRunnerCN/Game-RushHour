package RusHourG5;/**
 * The MapU class provides utility methods to access and update game maps and records from the MapLibrary class.
 *
 * The getMap() method takes a parameter level representing the level of the game map to retrieve, and returns an array of Attribute objects representing the cars on the game board for that level.
 *
 * The getRecord() method takes a parameter level representing the level of the game, and returns an integer representing the current player's record for that level.
 *
 * The updateRecord() method takes parameters level and record, and updates the player's record for the specified level in the MapLibrary class.
 */

public class MapU {/**
 * Returns an array of Attribute objects representing the cars on the game board for the specified level.
 *
 * Level An integer representing the level of the game map to retrieve.
 */

	public MapU(){


	}

	public Attribute[] getMap(int level){
		return MapLibrary.getMap(level);
	}/**
	 * Returns an integer representing the current player's record for the specified level.
	 *
	 * @param level An integer representing the level of the game.
	 * @return An integer representing the current player's record for the specified level.
	 */


	public int getRecord(int level){
		return MapLibrary.getRecord(level);
	}/**
	 * Updates the player's record for the specified level in the MapLibrary class.
	 *
	 * @param level An integer representing the level of the game.
	 * @param record An integer representing the player's record for the specified level.
	 */


	public void updateRecode(int level,int record){
		MapLibrary.writeRecord(level, record);
	}


}
