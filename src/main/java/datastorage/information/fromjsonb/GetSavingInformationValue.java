/**
 * 
 */
package datastorage.information.fromjsonb;

import datastorage.pojo.GetPojoValue;
import gameboard.tiles.FieldTile;
import simulator.GameValue;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 * This class converts the JSONB file into a class object and generates new constructor values
 *
 */
public class GetSavingInformationValue {

	/**
	 * This method deserialize the JSONB file. It is also possible to get the values of the cash, the tank filling and the gameday.
	 * It implements a new GameValue object by using the class constructor.
	 */
	public void GetSavingInformationGame() {
		GetPojoValue gpv = new GetPojoValue();
			GameValue deserializedcash = gpv.toDeserializeGame();
			int cash = deserializedcash.getCash();
			
			GameValue deserializedfilling = gpv.toDeserializeGame();
			double filling = deserializedfilling.getFilling();
			
			GameValue deserializedday = gpv.toDeserializeGame();
			int day = deserializedday.getDay();
		
			GameValue updatedGame = new GameValue(cash, filling, day);
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the level of difficulty.
	 * It implements a new LevelOfDifficulty object by using the class constructor.
	 */
	public void GetSavingInformationLevel() {
		GetPojoValue gpv = new GetPojoValue();
			LevelOfDifficulty deserializedlevel = gpv.toDeserializeLevel();
			int newLevel = deserializedlevel.getLevel();
			
			LevelOfDifficulty updatedLevel = new LevelOfDifficulty(newLevel);
					
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the growth state of field one, the growth state of field two and the growth state of field three.
	 * It implements a new FieldTile object by using the class constructor.
	 */
	public void GetSavingInformationFieldtiles() {
		GetPojoValue gpv = new GetPojoValue();
			FieldTile deserializedft1 = gpv.toDeserializeFieldtiles();
			int ft1 = deserializedft1.getGrowthState();
			
			FieldTile deserializedft2 = gpv.toDeserializeFieldtiles();
			int ft2 = deserializedft2.getGrowthState2();
			
			FieldTile deserializedft3 = gpv.toDeserializeFieldtiles();
			int ft3 = deserializedft3.getGrowthState3();
			
		FieldTile updatedFieldTile = new FieldTile(0, ft1, ft2, ft3);
					
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the filling level of tank one and two.
	 * It implements a new FieldTile object by using the class constructor.
	 */
	public void GetSavingInformationTank() {
		GetPojoValue gpv = new GetPojoValue();
//			Class deserializedtank1 = gpv.toDeserializeTank();
//			int tank1 = deserializedcash.getCash();
//			
//			Class deserializedtank2 = gpv.toDeserializeTank();
//			int tank2 = deserializedfilling.getFilling();
//			
//		Game updatedGame = new Game(cash, filling, day);
	}
}
