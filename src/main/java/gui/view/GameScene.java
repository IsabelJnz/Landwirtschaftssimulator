package gui.view;

import gameboard.objects.MovingObject;
import gui.controller.GameController;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

import static gui.view.ViewManager.HEIGHT;
import static gui.view.ViewManager.WIDTH;

/**
 * This class implements the game scene. It consists of a gridpane for the matchfield, a pane on the right side with
 * buttons for moving around the field and choosing the machine / farmer and a horizontal box with all the necessary
 * information the player should see during playing. The matchfield, side pane and box are implemented by other
 * classes.
 *
 * @author Judith
 */
public class GameScene {
    private Pane gamePane;
    private Scene gameScene;
    private Matchfield matchfield;
    private MovingObject movingObject = new MovingObject();
    private InformationBox informationBox;
    private SideControlPane sideControlPane;

    /**
     * This method implements all the Nodes for the game scene with the help of the other classes InformationBox,
     * Matchfield, MovingObjectOnMatchfield and SideControlPane. It also adds event handlers to the game scene to
     * react to the players input on the keyboard.
     *
     * @param farmer hands the boolean selected to the method initializeSideControlPane()
     * @param tractor hands the boolean selected to the method initializeSideControlPane()
     * @param harvester hands the boolean selected to the method initializeSideControlPane()
     * @param cultivator hands the boolean selected to the method initializeSideControlPane()
     * @param dumpTruck hands the boolean selected to the method initializeSideControlPane()
     * @param seedDrill hands the boolean selected to the method initializeSideControlPane()
     * @param stageOfGrowthField1 hands the integer to the method initializeMatchfield()
     * @param stageOfGrowthField2 hands the integer to the method initializeMatchfield()
     * @param stageOfGrowthField3 hands the integer to the method initializeMatchfield()
     * @param selectedObject integer of the selected moving object that is shown on the matchfield
     * @param column index of the column to which the image view is set
     * @param row index of the column to which the image view is set
     *
     */
    public void initializeGameScene(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                                    boolean dumpTruck, boolean seedDrill, int stageOfGrowthField1,
                                    int stageOfGrowthField2, int stageOfGrowthField3, int selectedObject,
                                    int column, int row, GameController gameController){
        gamePane = new Pane();
        gameScene = new Scene(gamePane, WIDTH, HEIGHT);
        gamePane.setPrefWidth(WIDTH);
        gamePane.setPrefHeight(HEIGHT);
        initializeInformationBox();
        initializeSideControlPane(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, gameController);
        initializeMatchfield(stageOfGrowthField1, stageOfGrowthField2, stageOfGrowthField3, selectedObject, column, row);
        movingObject.setX(column);
        movingObject.setY(row);
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) ->{
            gameController.setBooleansPressed(event);
        });

        gameScene.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            gameController.setBooleansReleased(event);
        });
    }

    /**
     * Getter for the gameScene.
     *
     * @return the requested gameScene
     */
    public Scene getGameScene(){
        return gameScene;
    }

    /**
     * This method gets the informationBox from the class InformationBox that implements a HBOX with all the information
     * for the player. It adds the box to the gamePane.
     */
    private void initializeInformationBox(){
        informationBox = new InformationBox();
        gamePane.getChildren().add(informationBox.getInformationBox());
    }

    /**
     * Getter for the implemented informationBox.
     *
     * @return the requested informationBox
     */
    public InformationBox getInformationBox(){
        return informationBox;
    }

    /**
     * This method gets the sideControlPane from the class SideControlPane that implements a Pane with all the buttons
     * to move around the matchfield and to choose the machine / farmer and adds it to the gamePane.
     *
     * @param farmer hands the boolean to the constructor of the class SideControlPane
     * @param tractor hands the boolean to the constructor of the class SideControlPane
     * @param harvester hands the boolean to the constructor of the class SideControlPane
     * @param cultivator hands the boolean to the constructor of the class SideControlPane
     * @param dumpTruck hands the boolean to the constructor of the class SideControlPane
     * @param seedDrill hands the boolean to the constructor of the class SideControlPane
     */
    private void initializeSideControlPane(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                                           boolean dumpTruck, boolean seedDrill, GameController gameController){
        sideControlPane = new SideControlPane(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill,
                gameController);
        gamePane.getChildren().add(sideControlPane.getSidePane());
    }

    /**
     * Getter for the implemented sideCotrolPane.
     *
     * @return the requested sideControlPane
     */
    public SideControlPane getSideControlPane(){
        return sideControlPane;
    }

    /**
     * Getter for the implemented matchfield.
     *
     * @return the requested matchfield
     */
    public Matchfield getMatchfield(){
        return matchfield;
    }

    /**
     * This method gets the matchfield from the class Matchfield that implements the grid pane of the matchfield and
     * adds it to the gamePane.
     *
     * @param stageOfGrowthField1 hands the integer to the constructor of the class Matchfield
     * @param stageOfGrowthField2 hands the integer to the constructor of the class Matchfield
     * @param stageOfGrowthField3 hands the integer to the constructor of the class Matchfield
     * @param selectedObject integer of the selected moving object that is shown on the matchfield
     * @param column index of the column to which the image view is set
     * @param row index of the column to which the image view is set
     */
    private void initializeMatchfield(int stageOfGrowthField1, int stageOfGrowthField2, int stageOfGrowthField3,
                                           int selectedObject, int column, int row){
        matchfield = new Matchfield(stageOfGrowthField1, stageOfGrowthField2, stageOfGrowthField3);
        matchfield.initializeMovingObject(selectedObject, column, row);
        gamePane.getChildren().add(matchfield.getMatchfield());
    }
}
