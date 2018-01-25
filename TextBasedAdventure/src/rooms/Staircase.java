package rooms;

import things.Item;
import things.Person;

public class Staircase extends Room{

	public Staircase(Person[] occupants, Item[] items, int x, int y) {
		super(occupants, items, x, y);
	}

	@Override
	public void print() {
		System.out.print("[");
		if (getOccupants().length != 0)
        {
            getOccupants()[0].printRoom();
        }
        else
        {
            System.out.print("S");
        }
		System.out.print("]");
	}

}
