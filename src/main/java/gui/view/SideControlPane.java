package gui.view;

import gui.controller.GameController;
import gui.model.ImageManager;
import gui.model.LSButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import static gui.view.ViewManager.HEIGHT;
import static gui.view.ViewManager.WIDTH;

/**
 * This class implements the side pane with the buttons to move around the matchfield and to choose the
 * machine / farmer.
 *
 * @author Judith
 */
public class SideControlPane {
    /**
     * pane that holds all the nodes of the sidePane on the right side of the gameScene
     */
    private Pane sidePane = new Pane();
    /**
     * grid pane that holds the buttons to choose the moving object
     */
    private GridPane machinePane = new GridPane();
    /**
     * button to choose the farmer
     */
    private LSButton farmerButton;
    /**
     * button to choose the tractor
     */
    private LSButton tractorButton;
    /**
     * button to choose the harvester
     */
    private LSButton harvesterButton;
    /**
     * button to choose the cultivator
     */
    private LSButton cultivatorButton;
    /**
     * button to choose the dumpTruck
     */
    private LSButton dumpTruckButton;
    /**
     * button to choose the seedDrill
     */
    private LSButton seedDrillButton;
    /**
     * button to move right
     */
    private LSButton buttonRight;
    /**
     * button to move left
     */
    private LSButton buttonLeft;
    /**
     * button to move up
     */
    private LSButton buttonUp;
    /**
     * button to move down
     */
    private LSButton buttonDown;
    /**
     * button to take some action like exit vehicle, sell grain, unload tumpTruck, ...
     */
    private LSButton buttonAction;
    /**
     * height of the side pane
     */
    private static final int HEIGHT_PANE = 860;
    /**
     * width of the side pane
     */
    private static final int WIDTH_PANE = 250;
    /**
     * String with the path to the image of the farmer
     */
    private final String PATH_TO_FARMER = "src/main/java/gui/view/resources/farmer/farmerSide.png";
    /**
     * String with the path to the image of the tractor
     */
    private final String PATH_TO_TRACTOR = "src/main/java/gui/view/resources/machines/tractorSide.png";
    /**
     * String with the path to the image of the harvester
     */
    private final String PATH_TO_HARVESTER = "src/main/java/gui/view/resources/machines/harvesterSide.png";
    /**
     * String with the path to the image of the cultivator
     */
    private final String PATH_TO_CULTIVATOR = "src/main/java/gui/view/resources/machines/cultivatorSide.png";
    /**
     * String with the path to the image of the dumpTruck
     */
    private final String PATH_TO_DUMP_TRUCK = "src/main/java/gui/view/resources/machines/dumpTruckSide.png";
    /**
     * String with the path to the image of the seedDrill
     */
    private final String PATH_TO_SEED_DRILL = "src/main/java/gui/view/resources/machines/seedDrillSide.png";
    /**
     * object of the class GameController to set the booleans for moving around pressed and released
     */
    GameController gameController;


    /**
     * Construcs an object of the class SideControlPane. It immediately initializes the sidePane.
     *
     * @param farmer hands the boolean to the method initializeSidePane()
     * @param tractor hands the boolean to the method initializeSidePane()
     * @param harvester hands the boolean to the method initializeSidePane()
     * @param cultivator hands the boolean to the method initializeSidePane()
     * @param dumpTruck hands the boolean to the method initializeSidePane()
     * @param seedDrill hands the boolean to the method initializeSidePane()
     * @param gameController from the class game to make the buttons for moving around work
     */
    protected SideControlPane(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                              boolean dumpTruck, boolean seedDrill, GameController gameController){
        initializeSidePane(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
        this.gameController = gameController;
    }

    /**
     * Sets the size and layout of the pane and creates all the nodes with the help of the other methods of the class.
     *
     * @param farmer - hands the boolean to the method setButtonsDisabled()
     * @param tractor - hands the boolean to the method setButtonsDisabled()
     * @param harvester - hands the boolean to the method setButtonsDisabled()
     * @param cultivator - hands the boolean to the method setButtonsDisabled()
     * @param dumpTruck - hands the boolean to the method setButtonsDisabled()
     * @param seedDrill - hands the boolean to the method setButtonsDisabled()
     */
    private void initializeSidePane(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                                    boolean dumpTruck, boolean seedDrill){
        sidePane.setPrefWidth(WIDTH_PANE);
        sidePane.setPrefHeight(HEIGHT_PANE);
        sidePane.setLayoutX(WIDTH - WIDTH_PANE);
        sidePane.setLayoutY(HEIGHT - HEIGHT_PANE);
        createMachinePane();
        fillMachinePaneWithButtons();
        setButtonsDisabled(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
        createControlButtons();
    }

    /**
     * Creates the grid pane, that holds the buttons to choose the machine / farmer to move around the field.
     */
    private void createMachinePane(){
        machinePane.setHgap(0);
        machinePane.setVgap(0);
        machinePane.setPrefHeight(HEIGHT * 0.65);
        machinePane.setPrefWidth(WIDTH_PANE);
        machinePane.setGridLinesVisible(true);

        ColumnConstraints colConst = new ColumnConstraints();
        for (int i = 0; i < 2; i++) {
            colConst.setPercentWidth(100 / 2);
            machinePane.getColumnConstraints().add(colConst);
        }

        RowConstraints rowConst = new RowConstraints();
        for (int i = 0; i < 3; i++) {
            rowConst.setPercentHeight(100 / 3);
            machinePane.getRowConstraints().add(rowConst);
        }
        sidePane.getChildren().add(machinePane);
    }

    /**
     * Loads the images, initializes the image views and buttons and adds them with the help of the method
     * addToGridPane() to the machinePane.
     */
    private void fillMachinePaneWithButtons(){
        Image imageFarmer = new ImageManager().getImage(PATH_TO_FARMER, WIDTH_PANE / 2, WIDTH_PANE / 2,
                true, false);
        farmerButton = new LSButton(imageFarmer,
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(farmerButton, 0, 0);

        Image imageTractor = new ImageManager().getImage(PATH_TO_TRACTOR , WIDTH_PANE / 2, WIDTH_PANE / 2,
                true, false);
        tractorButton = new LSButton(imageTractor,
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(tractorButton, 1, 0);

        Image imageHarvester = new ImageManager().getImage(PATH_TO_HARVESTER, WIDTH_PANE / 2,
                WIDTH_PANE / 2, true, false);
        harvesterButton = new LSButton(imageHarvester,
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(harvesterButton, 0, 1);

        Image imageCultivator = new ImageManager().getImage(PATH_TO_CULTIVATOR, WIDTH_PANE / 2,
                WIDTH_PANE / 2, true, false);
        cultivatorButton = new LSButton(imageCultivator,
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(cultivatorButton, 1, 1);

        Image imageDumpTruck = new ImageManager().getImage(PATH_TO_DUMP_TRUCK, WIDTH_PANE / 2,
                WIDTH_PANE / 2, true, false);
        dumpTruckButton = new LSButton(imageDumpTruck,
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(dumpTruckButton, 0, 2);

        Image imageSeedDrill = new ImageManager().getImage(PATH_TO_SEED_DRILL, WIDTH_PANE / 2,
                WIDTH_PANE / 2, true, false);
        seedDrillButton = new LSButton(imageSeedDrill, HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(seedDrillButton, 1, 2);
    }

    /**
     * Adds the given button to the machinePane at the given column and row index.
     *
     * @param button - button / node that is added to the machinePane
     * @param column - index of the column to which the node ist added
     * @param row - index of the row to which the node ist added
     */
    private void addToGridPane(LSButton button, int column, int row){
        machinePane.setColumnIndex(button, column);
        machinePane.setRowIndex(button, row);
        machinePane.getChildren().add(button);
    }

    /**
     * Sets the buttons of the machinePane disabled, depending on the parameters that are handed to this method.
     * Machines / farmer, that are not in use should be disabled when walking around and able to click when choosing
     * the next machine / farmer.
     *
     * @param farmer - sets the farmerButton disabled if true
     * @param tractor - sets the tractorButton disabled if true
     * @param harvester - sets the harvesterButton disabled if true
     * @param cultivator - sets the cultivatorButton disabled if true
     * @param dumpTruck - sets the dumpTruckButton disabled if true
     * @param seedDrill - sets the seedDrillButton disabled if true
     */
    public void setButtonsDisabled(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                                    boolean dumpTruck, boolean seedDrill){
        farmerButton.setDisable(!farmer);
        tractorButton.setDisable(!tractor);
        harvesterButton.setDisable(!harvester);
        cultivatorButton.setDisable(!cultivator);
        dumpTruckButton.setDisable(!dumpTruck);
        seedDrillButton.setDisable(!seedDrill);
    }

    /**
     * Creates the buttons with those the player can move the machine / farmer around the matchfield as well as the
     * button that can be clicked, when some action is possible to do.
     */
    private void createControlButtons(){
        buttonUp = new LSButton("W", 50, 50,95,HEIGHT/100*70, 14);
        buttonUp.setOnMousePressed(MouseEvent -> {
            gameController.setUpPressed(true);
        });
        buttonUp.setOnMouseReleased(MouseEvent -> {
            gameController.setUpPressed(false);
        });
        buttonDown = new LSButton("S", 50, 50, 95, HEIGHT/100*77, 14);
        buttonDown.setOnMousePressed(MouseEvent -> {
            gameController.setDownPressed(true);
        });
        buttonDown.setOnMouseReleased(MouseEvent -> {
            gameController.setDownPressed(false);
        });
        buttonLeft = new LSButton("A", 50, 50,40,HEIGHT/100*77, 14);
        buttonLeft.setOnMousePressed(MouseEvent -> {
            gameController.setLeftPressed(true);
        });
        buttonLeft.setOnMouseReleased(MouseEvent -> {
            gameController.setLeftPressed(false);
        });
        buttonRight = new LSButton("D", 50, 50,150,HEIGHT/100*77, 14);
        buttonRight.setOnMousePressed(MouseEvent -> {
            gameController.setRightPressed(true);
        });
        buttonRight.setOnMouseReleased(MouseEvent -> {
            gameController.setRightPressed(false);
        });
        buttonAction = new LSButton("", 50, 150,45,HEIGHT/100*87, 14);
        Image image = new ImageManager().getImage("src/main/java/gui/model/resources/background_orange.png",
                150, 50, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        buttonAction.setBackground(background);
        buttonAction.setDisable(true);
        sidePane.getChildren().addAll(buttonUp, buttonDown, buttonLeft, buttonRight, buttonAction);
    }

    /**
     * Getter for the sidePane.
     *
     * @return - the requested sidePane
     */
    protected Pane getSidePane(){
        return sidePane;
    }

    /**
     * Getter for the buttonAction.
     *
     * @return the requested buttonAction
     */
    public LSButton getButtonAction() {
        return buttonAction;
    }

    /**
     * Getter for the farmerButton.
     *
     * @return the requested farmerButton
     */
    public LSButton getFarmerButton() {
        return farmerButton;
    }

    /**
     * Getter for the tractorButton.
     *
     * @return the requested tractorButton
     */
    public LSButton getTractorButton() {
        return tractorButton;
    }

    /**
     * Getter for the harvesterButton.
     *
     * @return the requested harvesterButton
     */
    public LSButton getHarvesterButton() {
        return harvesterButton;
    }

    /**
     * Getter for the cultivatorButton.
     *
     * @return the requested cultivatorButton
     */
    public LSButton getCultivatorButton() {
        return cultivatorButton;
    }

    /**
     * Getter for the dumpTruckButton.
     *
     * @return the requested dumpTruckButton
     */
    public LSButton getDumpTruckButton() {
        return dumpTruckButton;
    }

    /**
     * Getter for the seedDrillButton.
     *
     * @return the requested seedDrillButton
     */
    public LSButton getSeedDrillButton() {
        return seedDrillButton;
    }

}
