package board;

import rooms.Room;

public class Board {


    private Room[][] board;

    public Board(Room[][] board)
    {
        this.board = board;
    }

    // prints each room and element on map
    public void printMap()
    {
            for (Room[] column : board)
            {
            		for (Room room : column)
                {
            			room.print();
                }
            		System.out.println();
            }
            System.out.println();
        }
 //   }
    public Room[][] getBoard() {
        return board;
    }

    public void setBoard(Room[][] board) {
        this.board = board;
    }

}
