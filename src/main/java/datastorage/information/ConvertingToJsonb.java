/**
 * 
 */
package datastorage.information;

import datastorage.jsonb.GetJsonbMovingObject;
import datastorage.jsonb.GetJsonbValue;

/**
 * @author Isabel
 *
 */
public class ConvertingToJsonb {
	/**
	 * This method is converting all the data into a JSONB file
	 * 
	 */
	public void SetSavingInformation() {// Methodenname wird noch ge�ndert
	// all numeric values
		GetJsonbValue gjv = new GetJsonbValue();
			gjv.toSerializeGame();
			gjv.toSerializeLevel();
			gjv.toSerializeFieldtiles();// Exception werfen um speicher vorgan zu pr�fen
			gjv.toSerializeSilo();
			gjv.toSerializeCourtTrade();
						
	// all position values	
		GetJsonbMovingObject gjp = new GetJsonbMovingObject();
			gjp.toSerializeFarmer();
			gjp.toSerializeTractor();
			gjp.toSerializeHarvester();// Exception
			gjp.toSerializeCultivator();
			gjp.toSerializeDumpTruck();
			gjp.toSerializeSeedDrill();
	}
}
