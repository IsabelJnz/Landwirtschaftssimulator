package machines;

public class Tank{

	private int petrolCapacity = 150;
    private int petrolLevel;
    private int y;
    private int x;
 
    /** 
     * this constructor sets the petrol level and the coordinates
     * @param petrolLevel, x, y
     */
    public Tank(int petrolLevel, int x, int y) {  
    	this.petrolLevel = petrolLevel;
    	this.x = x;
    	this.y = y;
    }
    
    /** 
     * this method minimizes the petrol level when the vehicle is moving
     * @return petrolLevel
     */
    public int move(int petrolLevel, int x, int y) {
    	if(x == +-1 || y == +-1) {
    		petrolLevel--;
    	} return petrolLevel;
    }
    
    /** 
     * this method warns the player when the petrol level is low
     * and ends the game when the petrol is empty
     */
    public void lowPetrolLevel(int petrolLevel) {
    	if(petrolLevel <= 50) {
    		System.out.println("The petrol level is only " + petrolLevel + "l.");
    		System.out.println("Please refuel your vehicle!");
    } 	else if (petrolLevel == 0) {
    		System.out.println("The tank is empty!");
    		System.out.println("Game Over!");
    }
    }
    
    
}

