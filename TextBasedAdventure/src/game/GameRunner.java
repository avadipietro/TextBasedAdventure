package game;

import things.Item;
import rooms.*;
import things.Person;
import board.Board;

import java.util.Scanner;

public class GameRunner {

    public static void main (String[] args)
    {
    		Person[] people = {};
        Item[] items = {};
    		Room[][] map = new Room[18][8];
    		
    		for (int a = 1; a <= 16; a++) { //generates vertical hallways
    			for (int b = 1; b <= 6; b += 5) {
    				map[a][b] = new Hallway(people, items, a, b);
    			}
    		}
    		for (int a = 1; a <= 16; a += 15) { //generates horizontal hallways
    			for (int b = 2; b <= 5; b ++) {
    				map[a][b] = new Hallway(people, items, a, b);
    			}
    		}
    		for (int a = 0; a <= 17; a += 2) { //generates horizontal classrooms
    			for (int b = 2; b <= 5; b ++) {
    				map[a][b] = new Classroom(people, items, a, b);
    			}
    			if (a == 2) {
    				a += 11;
    			}
    		}
    		for (int a = 3; a <= 14; a ++) { //generates vertical classrooms
    			for (int b = 0; b <= 7; b += 2) {
    				map[a][b] = new Classroom(people, items, a, b);	
    				if (b == 2) {
        				b++;
        			}
    			}
    		}
    		for (int a = 1; a <= 16; a += 15) { //generates staircases
	    		for (int b = 0; b <= 7; b += 7) {
	    			map[a][b] = new Staircase(people, items, a, b);
	    		}
    		}
    		for (int a = 3; a <= 14; a++) { //generates middle void rooms
    			for (int b = 3; b <= 4; b++) {
    				map[a][b] = new VoidRoom(people, items, a, b);
    			}
    		}
    		for (int a = 0; a <= 17; a += 17) { //generates big miscellaneous void rooms
	    		for (int b = 0; b <= 7; b++) {
	    			map[a][b] = new VoidRoom(people, items, a, b);
	    			if (b == 1) {
	    				b += 4;
	    			}
	    		}
    		}
    		for (int a = 2; a <= 15; a += 13) { //generates small miscellaneous void rooms
	    		for (int b = 0; b <= 7; b += 7) {
	    			map[a][b] = new VoidRoom(people, items, a, b);
	    		}
    		}
    		//Creates new board, begins game, and adds player
    		Board tech = new Board(map);
    
        boolean gameOn = true;
        Person player1 = new Person(1, 1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            System.out.println("It's 5th period at Brooklyn Tech. You're awfully bored, and you \n"
    				+ "just want to go home and chill. You decide to try and escape the \n"
    				+ "building, but the security guards stop you. After some sweet \n"
    				+ "talking, they decide to allow you to sneak out under one condition: \n"
    				+ "you bring them all the items they need. Here is your item list: \n");
            // randomly generates item list, views item list
            String[][] jItems = Item.generateItem();
            Item.viewItems(jItems);
            System.out.println("\nThere is a (!) next to items that you haven't obtained yet. Each item \n"
            		+ "is shown as a * on the map. To view these items at any time, enter i. \n"
            		+ "Each [S] is a staircase and can be used to exit the building. There is \n"
            		+ "one guard in each staircase. Once you give each guard their items, \n"
            		+ "you will be allowed to leave. So, how difficult do you want the game to be? \n"
            		+ "  [e] easy: item locations are shown \n"
            		+ "  [h] hard: item locations are hidden");
            
            String u = "";
            while (!u.equals("e") && !u.equals("h")) {
            	u = in.nextLine();
	            if (u.equals("e")) {
	            	// shown location
	            }
	            else if (u.equals("h")) {
	            	// hidden location
	            }
	            else {
	            		System.out.println("Please enter 'e' or 'h' only.");
	            }
            }
            
            
            System.out.println("You are represented by an x. To move, use WASD. Good luck. \n");
            
            // adds items to random rooms
            int o = 0;
            Item i = new Item();
            while (o < 24) {
            		int m = (int) (Math.random() * 8);
            		int n = (int) (Math.random() * 18);
            		if (map[n][m] instanceof Classroom && map[n][m].getItems().length == 0) {
            			map[n][m].addItem(i);
            			o++;
            		}
            }
            map[1][1].addOccupant(player1);
            
            // prints map, moves player
            while(gameOn) {
            		tech.printMap();
            		String move = player1.chooseMove();
            		player1.movePlayer(move, tech, player1);
            }

        }
		in.close();
    }

}
    



