package gui.view;

import gui.controller.SceneController;
import gui.model.ImageManager;
import gui.model.LSButton;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import java.io.File;

import static gui.view.ViewManager.HEIGHT;
import static gui.view.ViewManager.WIDTH;

/**
 * This class implements the menuScene. This scene is the first scene that is shown, when starting the game. It provides
 * buttons for a new game, load game, help and end game.
 *
 * @author Judith
 */

public class MenuScene {
    /**
     * new pane that holds all the nodes of the menuScene
     */
    private Pane menuPane;
    /**
     * new scene that show the menuPane
     */
    private Scene menuScene;
    /**
     * String with the path to the background image of the scene
     */
    private static final String PATH_TO_BACKGROUND_IMAGE = "src/main/java/gui/view/resources/background/field.jpg";
    /**
     * button for reloading the old game
     */
    private LSButton buttonLoadGame;

    /**
     * Constructs an object of the class MenuScene. It initializes the menuPane with the method initializeMenuPane().
     */
    public MenuScene(){
        menuPane = new Pane();
        menuScene = new Scene(menuPane, WIDTH, HEIGHT);
        initializeMenuPane();
    }

    /**
     * This method sets the style of the menuPane and initializes the buttons with the method initializeButtons().
     */
    private void initializeMenuPane(){
        menuPane.setPrefWidth(WIDTH);
        menuPane.setPrefHeight(HEIGHT);
        Image image = new ImageManager().getImage(PATH_TO_BACKGROUND_IMAGE, WIDTH, HEIGHT, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        menuPane.setBackground(background);
        initializeButtons();
    }

    /**
     * This method implements the buttons of the menu. Therefore, it uses a VBox.
     */
    private void initializeButtons(){
        SceneController sceneController = new SceneController();
        VBox menuBox = new VBox(10);
        menuBox.setLayoutX(WIDTH/2 - 100);
        menuBox.setLayoutY(HEIGHT/2 - 150);

        LSButton buttonNewGame = new LSButton("new game", 50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonNewGame.setOnMouseClicked(sceneController.setSceneToDifficultyScene);
        buttonLoadGame = new LSButton("load game",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonLoadGame.setOnMouseClicked(sceneController.setSceneToReloadGameScene);
        LSButton buttonHelp = new LSButton("help",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonHelp.setOnMouseClicked(sceneController.setSceneToHelpScene);
        LSButton buttonEnd = new LSButton("end game",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonEnd.setOnMouseClicked(sceneController.endGame);

        menuBox.getChildren().addAll(buttonNewGame, buttonLoadGame, buttonHelp, buttonEnd);
        menuPane.getChildren().add(menuBox);
        buttonDisabled();
    }

    /**
     * Getter for the menuScene.
     *
     * @return the requested menuScene.
     */
    public Scene getMenuScene(){
        return menuScene;
    }

    /**
     * This method helps to set the button load game disabled or not. e.g. when the game is played for the first time,
     * the button should be disabled as there is nothing to be reloaded. Therefore, it proofs if the text file exits.
     */
    private void buttonDisabled() {
        File gameFile = new File("src/main/java/datastorage/information/farmersimulator.txt");
        if (!gameFile.exists()) {
            buttonLoadGame.setDisable(true);
        }
    }
   
}
