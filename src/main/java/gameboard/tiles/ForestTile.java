package gameboard.tiles;

/**
 * this class represents a forest tile with its properties
 * @author Luisaibele
 *
 */
public class ForestTile extends Tile{

	/**
	 * the constructor sets the id for each forest tile
	 * @param id
	 */
	public ForestTile(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * the method return that the farmer can't run over a forest tile 
	 */
	@Override
	public boolean isSolid() {
		return false;
	}

}
