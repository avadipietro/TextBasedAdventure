package things;
import board.Board;
import rooms.Room;

public class Item {
	
	private int x;
	private int y;
	private Room room;
	private String name;
	
	public static String[][] generateItem() {
		String[] items = {"absence note", "stolen hall pass", "pair of Yeezys", "pre-sharpened pencils",
				"Smashburger voucher", "Cool Ranch Doritos", "Spicy Sweet Chili Doritos", "Doritos Flamas",
				"brass knuckles", "gym uniform", "SGO card", "really cool hat", "Bill Nye VHS collection",
				"iPhone charger", "calculus textbook", "antidepressants", "tardy slip", "school play ticket",
				"water bottle", "apple", "looseleaf", "someone's report card", "SAT prep book", "calculator"};
		
		// randomly chooses items from array to belong to each security guard
		int rand1 = 0; int rand2 = 0; int rand3 = 0; int rand4 = 0;
		String[][] jItems = new String[4][4];
		String[] jeffItems = new String[4]; String[] joeItems = new String[4];
		String[] johnItems = new String[4]; String[] jackItems = new String[4]; 
		
		for (int z = 0; z <= 3; z++) {
			rand1 = (int) (Math.random() * 6);
	        rand2 = ((int) (Math.random() * 6)) + 6;
	        rand3 = ((int) (Math.random() * 6)) + 12;
	        rand4 = ((int) (Math.random() * 6)) + 18;
	        if (z == 0) {
	        		jeffItems[0] = items[rand1];
	        		jeffItems[1] = items[rand2];
	        		jeffItems[2] = items[rand3];
	        		jeffItems[3] = items[rand4];
	        		jItems[0] = jeffItems;
	        }
	        if (z == 1) {
		        	joeItems[0] = items[rand1];
	        		joeItems[1] = items[rand2];
	        		joeItems[2] = items[rand3];
	        		joeItems[3] = items[rand4];
	        		jItems[1] = joeItems;
	        }
	        if (z == 2) {
		        	johnItems[0] = items[rand1];
	        		johnItems[1] = items[rand2];
	        		johnItems[2] = items[rand3];
	        		johnItems[3] = items[rand4];
	        		jItems[2] = johnItems;
	        }
	        if (z == 3) {
		        	jackItems[0] = items[rand1];
	        		jackItems[1] = items[rand2];
	        		jackItems[2] = items[rand3];
	        		jackItems[3] = items[rand4];
	        		jItems[3] = jackItems;
	        }
		}		
		return jItems;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public void printRoom() {
		System.out.print("*");
	}
	
	public void printRoom(String diff) {
		if (diff.equals("h")) {
			System.out.print(" ");
		}
	} 
	 public static void viewItems(String[][] items) {
		 
		boolean obtained = true;
		 
		for (String[] item : items) {
			for (String ite : item) {
				System.out.print(ite);
				if (obtained) {
					System.out.println(" (!)");
				}
				else {
					System.out.println("");
				}
			}
		}
	 }
}