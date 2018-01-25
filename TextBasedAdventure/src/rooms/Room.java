package rooms;

import things.Person;
import things.Item;

import java.util.Arrays;

public abstract class Room {

    private Person[] occupants;
    private Item[] items;
    private int x, y;
    
    // basic getters/setters/object constructors
    public Room (Person[] occupants, Item[] items, int x, int y)
    {
    		this.x = x;
    		this.y = y;
        this.occupants = occupants;
        this.items = items;
    }

    public Person[] getOccupants() {
        return occupants;
    }

    public void setOccupants(Person[] occupants) {
        this.occupants = occupants;
    }
    
    // adds a person to the current room
    public void addOccupant(Person p)
    {
        this.occupants = Arrays.copyOf(this.occupants,this.occupants.length+1);
        this.occupants[this.occupants.length-1] = p;
        p.setRoom(this);
    }
    
    public void setItems(Item[] items) {
        this.items = items;
    }
    
    public Item[] getItems() {
        return items;
    }
    
    // adds an item to the current room
    public void addItem(Item i)
    {
        this.items = Arrays.copyOf(this.items, this.items.length+1);
        this.items[this.items.length-1] = i;
        i.setRoom(this);
    }
            
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    public abstract void print();
}
