package RusHourG5;

//import java.io.DataInputStream;
//import java.io.DataOutputStream;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;/**
 * The MapLibrary class provides a static array of pre-defined game maps, each represented as a 2D array of Attribute objects.
 * Each map is stored as an array of Attribute objects, where each attribute represents a car on the game board with a unique ID, position, and orientation.
 *
 * The map array contains four pre-defined game maps categorized as easy, mid, hard, and hell levels.
 * Each map is accessible by its index in the array, where index 0 represents the easy level, index 1 represents the mid level, and so on.
 *
 * The Attribute class represents attributes of a car on the game board, including its ID, position (x,y), and orientation (direction).
 * The ID corresponds to each car type, x and y correspond to the top-left corner array subscript, and direction is true for horizontal placement and false for vertical placement.
 *
 * Overall, this class provides a convenient way to access pre-defined game maps for the Rush Hour puzzle game.
 */

public class MapLibrary {

	//ID--Car:0brown 1yellow 2green 3blue 4gray 5purple 6darkpurple
	//7bigGray 8bigRed 9bigPurple 10bigBlue 19red
	//Attribute(id,x,y,direction)£¬id for each car,x and y for the upper left array subscript, horizontal for true direction, vertical for false direction
	static String[] array;
	public static Attribute[][] map = new Attribute[][]{

		{//easy
			new Attribute(0,0,0,true),new Attribute(1,2,1,true),new Attribute(2,4,4,true),new Attribute(3,4,0,false),new Attribute(9,0,5,false),
			new Attribute(9,1,0,false),new Attribute(7,1,3,false),new Attribute(10,5,2,true)
		},

		{//mid

			new Attribute(1,2,1,true),new Attribute(2,2,3,false),new Attribute(3,3,0,true),
			new Attribute(5,1,0,false),new Attribute(7,1,1,true),new Attribute(8,5,3,true),
			new Attribute(10,4,3,true),new Attribute(9,3,2,false)
		},

		{//hard
			new Attribute(0,3,4,true),new Attribute(1,2,0,true),new Attribute(2,0,0,false),
			new Attribute(3,0,3,true),/*new Attribute(4,5,2,true),*/new Attribute(5,0,1,true),
			new Attribute(6,2,2,false),new Attribute(7,1,1,true),new Attribute(8,4,2,true),
			new Attribute(10,3,1,false),new Attribute(3,5,2,true),new Attribute(5,3,0,false),
			new Attribute(2,0,5,false),new Attribute(5,2,3,false)
		},
		{//hell
			new Attribute(0,3,2,false),new Attribute(1,2,2,true),new Attribute(2,1,5,true),
			new Attribute(4,2,0,false),new Attribute(5,3,5,false),new Attribute(6,3,3,true),
			new Attribute(7,5,0,true),new Attribute(10,0,4,false),new Attribute(9,0,1,false),
			new Attribute(3,0,2,false),new Attribute(2,4,3,false)
		},
	};



	public static Attribute[] getMap(int level){
		if(level == 1 || level ==2) {
		Attribute[] temp = new Attribute[8];
			System.arraycopy(map[level - 1], 0, temp, 0, 8);

		return temp;}
		else {
			Attribute[] temp;
			if (level == 3)
			{
				temp = new Attribute[13];
			for(int i=0;i<13;i++){
				temp[i] = map[level-1][i];
			}

			}
			else {
				temp = new Attribute[11];
				for(int i=0;i<11;i++){
					temp[i] = map[level-1][i];
				}

			}
			return temp;
		}
		}

	public static int getElementsNumberInMap(int level){
		if(level == 1 || level == 2)
			return 8;
		else if(level == 3)
			return 13;
		else
		return 11;
	}

	public static int getRecord(int level) {
		String[] array = null;
		File file = new File("D://GameRecord");

		if (!file.exists()) {
			file.mkdirs();
		}

		File record = new File("D://GameRecord/record.txt");

		try {
			if (!record.exists()) {
				// If the record file does not exist, a new record file is created
				record.createNewFile();
				String s = "9999,9999";
				Files.write(record.toPath(), s.getBytes());
			}

			// Read the contents of the record file
			String str = Files.readString(record.toPath());
			array = str.split(",");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (array != null && level >= 1 && level <= array.length) {
			String recordStr = array[level - 1];
			if (recordStr != null && !recordStr.isEmpty()) {
				return Integer.parseInt(recordStr);
			}
		}

		return 0;
	}


	public static void writeRecord(int level, int step) {

	    File record = new File("D://GameRecord/record.txt");

	    try {
	        // Clear the original record
	        FileWriter fileWriter = new FileWriter(record);
	        fileWriter.write("");
	        fileWriter.flush();
	        fileWriter.close();

	        // Rewrite text
	        StringBuilder sb = new StringBuilder();
	        array[level - 1] = Integer.toString(step);
	        sb.append(array[0]);
	        for (int i = 1; i < array.length; i++) {
	            sb.append(",").append(array[i]);
	        }

	        Files.write(record.toPath(), sb.toString().getBytes());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
