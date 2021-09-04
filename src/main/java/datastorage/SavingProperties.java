/**
 * 
 */
package datastorage;

import datastorage.information.ConvertingToJsonb;
import datastorage.information.fromjsonb.ConvertingFromJsonb;
import exceptions.datastorage.ReloadGameException;
import exceptions.datastorage.SavingGameException;

/**
 * @author Isabel
 *
 */
public class SavingProperties {

	/**
	 * This method deals with starting a new game, all necessary information of the game will be set in this method.
	 */
	public void CreateNewGame() {
		// alle Informationen f�r den Spielstart gesammelt aufrufen
		// LEvelauswahl
		//Game
		//Poitionen der Ojekte
		//Tank
		//Silof�llstand
	}
	
	/**
	 * This method deals with saving the Game status, if there are any problems with saving the game a the SavingGameException will be thrown.
	 */
	public void SavingGame() {
		ConvertingToJsonb ctj = new ConvertingToJsonb();
		try {
			ctj.SetSavingInformation();// Exception: SavingGameException einf�gen
		}catch(Exception ie) {
			System.out.println("Sorry, something went wrong during saving the game...\n Please try again");
		}
	}
	
	/**
	 * This method deals with reloading the Game status, if there are any problems with reloading the game a the ReloadGameException will be thrown.
	 */
	public void ReloadGame() {
		ConvertingFromJsonb cfj = new ConvertingFromJsonb();
		try {
			cfj.GetSavingInformation();// Exception: ReloadGameException einf�gen
		}catch(Exception ie) {
			System.out.println("Sorry, something went wrong during reloading the game state...\\n Please try again");
		}
	}
}
