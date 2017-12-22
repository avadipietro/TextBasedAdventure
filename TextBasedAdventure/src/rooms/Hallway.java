package rooms;

import things.Item;
import things.Person;


public class Hallway extends Room {

    public Hallway(Person[] people, Item[] items, int x, int y)
    {
        super(people, items, x, y);
    }

    public void print()
    {
        if (getOccupants().length != 0)
        {
            getOccupants()[0].printRoom();
        }
        else
        {
            System.out.print("░░░");
        }
    }
}
