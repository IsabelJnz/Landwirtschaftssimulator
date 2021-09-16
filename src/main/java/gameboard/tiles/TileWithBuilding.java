package gameboard.tiles;

/**
 * this class represents a tile with a building on it on the gameboard
 * @author Luisaibele
 *
 */
public class TileWithBuilding extends Tile{

	/**
	 * Constructor of TileWithBuilding
	 */
	public TileWithBuilding() {
		super();
		
	}
	
	/**
	 * this method checks if the farmer can run over a tile with a building on it 
	 * and returns the equal boolean value
	 */
	@Override
	public boolean isSolid() {
		return false;
	}
	

}
