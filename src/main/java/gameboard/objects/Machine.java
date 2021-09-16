package gameboard.objects;

import exceptions.EmptyTankException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * This class implements the methods, that are basic functions for every Machine.
 * @author Luisaibele, Hanna
 *
 */
public class Machine extends MovingObject{

	private final int PETROL_TANK_CAPACITY = 150;
	//stands for the petrol tank of the machines
	private IntegerProperty petrolTankFillLevel = new SimpleIntegerProperty();

	
	/**
	 * this empty constructor is there for starting a new game
	 */
	public Machine() {
		super(18, 7, false);
		petrolTankFillLevel.set(150);
	}
	
	/**
	 * the constructor sets the position in the coordinate system
	 * @param
	 */
	public Machine(int x, int y, boolean selected, int petrolTankFillLevel) {
		super(x, y, selected);
		this.petrolTankFillLevel.set(petrolTankFillLevel);
	}
	

	
	 /** 
     * this method minimizes the petrol level when the vehicle is moving
     * @return petrolLevel
     */
    public int caculateTankConsumption(int petrolTankFillLevel, int x, int y) {
    	//check with pushing of buttons or with moving method of machine
    	if(x == +-1 || y == +-1) {
    		petrolTankFillLevel--;
    	} return petrolTankFillLevel;
    }
    
    /** 
     * this method warns the player when the petrol level is low
     * and ends the game when the petrol is empty
     */
    public void lowPetrolLevel(int tank) throws EmptyTankException{
    	if(tank <= 50) { //little reminder to fuel the machine
    		System.out.println("There are only " + tank + "l left in the tank.");
    		System.out.println("Please go to the gasstation!");
    		} 
    	else if (tank == 0) { //tank is empty -> Game Over!
    		throw new EmptyTankException("You can not move any further, "
    				+ "the tank is empty! \n Game Over!");		
    }
    	
    }

	/**
	 * Getter for the petrolTankFillLevel
	 * @return the petrolTankFillLevel
	 */
	public int getPetrolTankFillLevel() {
		return petrolTankFillLevel.get();
	}

	/**
	 * Setter for the variable PetrolTankFillLevel
	 * @param petrolTankFillLevel
	 */
	public void setPetrolTankFillLevel(int petrolTankFillLevel){ this.petrolTankFillLevel.set(petrolTankFillLevel);}

	/**
	 * Getter for the IntegerProperty pertrolTankFillLevel
	 * @return
	 */
	public IntegerProperty petrolTankFillLevel(){ return petrolTankFillLevel; }

	/**
	 * method for serializing the petrolTankFillLevel to give it back as
	 * an information to the user 
	 * @return
	 */
	public String getPetrolTankFillLevelAsString(){
		return "" + petrolTankFillLevel.get();
	}
	
}
