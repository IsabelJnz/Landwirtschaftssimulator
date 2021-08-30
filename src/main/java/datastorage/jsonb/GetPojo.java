/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.Game;
import gameboard.GameBoard;
import gameboard.tiles.FieldTile;
import datastorage.jsonb.GetJsonb;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 *
 */
public class GetPojo {
	
	/**
	 * @return deserialized as a new game object of the cash and filling values
	 */
	public Game toDeserializeGame() {
		//Klassenobjekt	
		GetJsonb gjb = new GetJsonb();
		Jsonb jb = JsonbBuilder.create();
		Game deserialized = jb.fromJson(gjb.toSerializeGame(), Game.class);
		System.out.println("deserialized, neues Klassenobjekt = " + deserialized);
		return deserialized;	
	}
	
	/**
	 * @return deserialized as a new Enum object of the level of difficulty
	 */
	public LevelOfDifficulty toDeserializeLevel() {
		//Klassenobjekt	
		GetJsonb gjb = new GetJsonb();
		Jsonb jb = JsonbBuilder.create();
		LevelOfDifficulty deserialized = jb.fromJson(gjb.toSerializeLevel(), LevelOfDifficulty.class);
		return deserialized;
	}
	
	/**
	 * @return deserialized as a new GameBoard object of the farmer's and machine's positions
	 */
	public GameBoard toDeserializePosition() {  //eventuell mit Vererbung f�r die Ger�te und den Menschen
		//Klassenobjekt	
		GetJsonb gjb = new GetJsonb();
		Jsonb jb = JsonbBuilder.create();
		GameBoard deserialized = jb.fromJson(gjb.toSerializePosition(), GameBoard.class);
		return deserialized;	
	}
	
	/**
	 * @return deserialized as a new GameBoard object of the fieldtile's contitions
	 */
	public FieldTile toDeserializeTiles() {  //eventuell mit Vererbung f�r die Felder 1-3
		//Klassenobjekt	
		GetJsonb gjb = new GetJsonb();
		Jsonb jb = JsonbBuilder.create();
		FieldTile deserialized = jb.fromJson(gjb.toSerializeTiles(), FieldTile.class);
		return deserialized;	
	}
}
