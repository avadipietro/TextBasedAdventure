package things;
import rooms.Room;

import java.util.Scanner;

public class Person {
	
	public static Person Person;
	private int floor;		// from 0 to 8
	private char direction;	// NESW
	private int roomNumber; // from 1 to 24
	private Room room;
	
	public Person (int floor, char direction, int roomNumber) {
		this.floor = floor;
		this.direction = direction;
		this.roomNumber = roomNumber;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public void printRoom() {
		System.out.print("★");
	}
	
	/* MOVEMENTS:
	 * player can change floors
	 */
	public void movePlayer(int floor, char direction, int steps) {
		
	}
	
	Scanner in = new Scanner(System.in);
	
	public String getName() {
		String name = in.nextLine();
		return name;
	}

}