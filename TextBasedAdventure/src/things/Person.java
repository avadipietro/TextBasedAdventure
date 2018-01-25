package things;
import rooms.Room;
import rooms.VoidRoom;
import rooms.Staircase;
import board.Board;

import java.util.Scanner;

public class Person {
	
	Scanner in = new Scanner(System.in);
	
	public static Person Person;
	private Room room;
	
	private int x;
	private int y;
	
	// getters and setters, object constructors
	public Person (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	public void printRoom() {
		System.out.print("x");
	}
	
	public void placePlayer() {
		x = 1;
		y = 1;
	}
	
	// moves player on the board given WASD
	public void movePlayer(String move, Board tech, Person player) {

		Person[] empty = {};
		Item[] empty2 = {};
		boolean valid = true;
		tech.getBoard()[this.y][this.x].setOccupants(empty);
		
		if (this.y < 0 || this.y > 17 || this.x < 0 || this.x > 7) { // avoids error when trying to leave board
			System.out.println("You can only leave the building through the [S] spaces on the first floor.");
		}
		else if (move.equals("w")) {
			if (this.y == 0) {
				valid = false;
			}
			else {
				this.y--;
			}
		}
		else if (move.equals("a")) {
			if (this.x == 0) {
				valid = false;
			}
			else {
				this.x--;
			}
		}
		else if (move.equals("s")) {
			if (this.y == 17) {
				valid = false;
			}
			else {
				this.y++;
			}
		}
		else if (move.equals("d")) {
			if (this.x == 7) {
				valid = false;
			}
			else {
				this.x++;
			}
		}
		// shows item list
		else if (move.equals("i")) {
		//	Item.viewItems(jItems);
		}
		else {
			System.out.println("Please enter a valid move.");
		}
		
		// avoids void room error, reverses steps
		if (tech.getBoard()[this.y][this.x] instanceof VoidRoom) {
			System.out.println("You cannot enter this area.");
			if (move.equals("w")) {
				this.y++;
			}
			else if (move.equals("a")) {
				this.x++;
			}
			else if (move.equals("s")) {
				this.y--;
			}
			else if (move.equals("d")) {
				this.x--;
			}
		}
			if (!valid) {
				System.out.println("You can only leave the building through the [S] spaces on the first floor.");
			}
		
			tech.getBoard()[this.y][this.x].addOccupant(player);
			
			if (tech.getBoard()[this.y][this.x] instanceof Staircase) {
				System.out.println("This guard thanks you for his items.");
			}
			
			if (tech.getBoard()[this.y][this.x].getItems().length != 0) {
				System.out.println("You found an item!");
				tech.getBoard()[this.y][this.x].setItems(empty2);
			}
		
	}

	public String chooseMove() {
		String direction = in.nextLine();
		return direction;
	}

}
