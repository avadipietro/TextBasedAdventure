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
    		
    		for (int a = 1; a <= 16; a++) { //VERT HALLWAYS
    			for (int b = 1; b <= 6; b += 5) {
    				map[a][b] = new Hallway(people, items, a, b);
    				System.out.print(a);
    				System.out.print(",");
    				System.out.print(b);
    				map[a][b].print();
    			}
    		}
    		System.out.println();
    		for (int a = 1; a <= 16; a += 15) { //HORZ HALLWAYS
    			for (int b = 2; b <= 5; b ++) {
    				map[a][b] = new Hallway(people, items, a, b);
    				System.out.print(a);
    				System.out.print(",");
    				System.out.print(b);
    				map[a][b].print();
    			}
    		}
    		System.out.println();
    		for (int a = 0; a <= 17; a += 2) { //HORZ CLASSROOMS
    			for (int b = 2; b <= 5; b ++) {
    				map[a][b] = new Classroom(people, items, a, b);
    				System.out.print(a);
    				System.out.print(",");
    				System.out.print(b);
    				map[a][b].print();
    			}
    			if (a == 2) {
    				a += 11;
    			}
    		}
    		System.out.println();
    		for (int a = 3; a <= 14; a ++) { //VERT CLASSROOMS
    			for (int b = 0; b <= 7; b += 2) {
    				map[a][b] = new Classroom(people, items, a, b);
    				System.out.print(a);
    				System.out.print(",");
    				System.out.print(b);
    				map[a][b].print();
    				
    				if (b == 2) {
        				b++;
        			}
    			}
    		}
    		System.out.println(); // STAIRCASES
    		for (int a = 1; a <= 16; a += 15) {
	    		for (int b = 0; b <= 7; b += 7) {
	    			map[a][b] = new Staircase(people, items, a, b);
	    			System.out.print(a);
    				System.out.print(",");
    				System.out.print(b);
    				map[a][b].print();
	    		}
    		}
    		System.out.println();
    		for (int a = 3; a <= 14; a++) { //MIDDLE VOID
    			for (int b = 3; b <= 4; b++) {
    				map[a][b] = new VoidRoom(people, items, a, b);
    				System.out.print(a);
    				System.out.print(",");
    				System.out.print(b);
    				map[a][b].print();
    			}
    		}
    		System.out.println(); // BIG MISC VOID
    		for (int a = 0; a <= 17; a += 17) {
	    		for (int b = 0; b <= 7; b++) {
	    			map[a][b] = new VoidRoom(people, items, a, b);
	    			System.out.print(a);
    				System.out.print(",");
    				System.out.print(b);
    				map[a][b].print();
	    			if (b == 1) {
	    				b += 4;
	    			}
	    		}
    		}
    		System.out.println(); // SMALL MISC VOID
    		for (int a = 2; a <= 15; a += 12) {
	    		for (int b = 0; b <= 7; b += 7) {
	    			map[a][b] = new VoidRoom(people, items, a, b);
	    			System.out.print(a);
    				System.out.print(",");
    				System.out.print(b);
    				map[a][b].print();
	    		}
    		}
    		System.out.println();
    		Board tech = new Board(map);
    		tech.printMap();
    	
       /* Room[][] map = new Room[18][8];
        for (int j = 0; j<map.length; j++)
        {
        	Room[] row = map[j];
            for (int i = 0; i<row.length;i++)
            {
                Person[] people = {};
                Item[] items = {};

                row[i] = new Hallway(people, items, i, j);
            }

        }*/
        

        /*Board tech = new Board(map);
        tech.printMap();
    
        boolean gameOn = true;
        Person player1 = new Person(1, "N", 6);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            System.out.println("Welcome to the Halls of Tech, " + player1.getName());
            map[0][0].addOccupant(player1);

            tech.printMap();
            player1.printRoom();
            String move = player1.chooseMove();
            player1.movePlayer(move);
            player1.movePlayer(tech, player1, move);
           // gameOn = false;
          

        }
		in.close();
		*/
    }

}



