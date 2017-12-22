package rooms;

import things.Item;
import things.Person;

public class Classroom extends Room {

	public Classroom(Person[] occupants, Item[] items, int x, int y) {
		super(occupants, items, x, y);
	}

	@Override
	public void print() {
		if (getOccupants().length != 0)
        {
            getOccupants()[0].printRoom();
        }
        else
        {
            System.out.print("[ ]");
        }
		
	}

}
