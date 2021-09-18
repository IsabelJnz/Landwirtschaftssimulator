package gameboard.tiles;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the basic structure of a tile 
 * with its several properties.
 * 
 * @author Luisaibele
 *
 */
public class Tile {
	
	/**
	 * Empty Constructor of Tile
	 * 
	 */
	public Tile() {
		
	}


	/**
	 * this method is supposed to check if the farmer can run over 
	 * a specific tile or not.
	 * 
	 * @return a boolean variable to show if it's possible or not to run over the field
	 */
	public boolean isSolid() {
		return false; 
	}

}
