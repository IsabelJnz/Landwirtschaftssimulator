package gui.controller;

import gameboard.objects.MovingObject;
import gameboard.tiles.FieldTile;
import gui.view.GameScene;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameController {
    private AnimationTimer gameTimer;
    private boolean rightPressed;
    private boolean leftPressed;
    private boolean upPressed;
    private boolean downPressed;
    private int fieldCounter = 0;
    int growthStageField1;
    int growthStageField2;
    int growthSTageField3;



    public void setBooleansPressed(KeyEvent keyEvent){
        if (keyEvent.getCode().equals(KeyCode.D)) {
            rightPressed = true;
            System.out.println("right pressed");
        } else if (keyEvent.getCode().equals(KeyCode.A)){
            leftPressed = true;
            System.out.println("left pressed");
        } else if (keyEvent.getCode().equals(KeyCode.W)){
            upPressed = true;
            System.out.println("up pressed");
        } else if (keyEvent.getCode().equals(KeyCode.S)){
            downPressed = true;
            System.out.println("down pressed");
        }
    }

    public void setBooleansReleased(KeyEvent keyEvent){
        if (keyEvent.getCode().equals(KeyCode.D)) {
            rightPressed = false;
            System.out.println("right released");
        } else if (keyEvent.getCode().equals(KeyCode.A)){
            leftPressed = false;
            System.out.println("left released");
        } else if (keyEvent.getCode().equals(KeyCode.W)){
            upPressed = false;
            System.out.println("up released");
        } else if (keyEvent.getCode().equals(KeyCode.S)){
            downPressed = false;
            System.out.println("down released");
        }
    }

    public void initGameLoop(GameScene gameScene, FieldTile fieldTile, MovingObject movingObject){
        gameTimer = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_000) {
                    gameScene.moveObject(movingObject);
                    proofAction(gameScene);
                    lastUpdate = now;
                    proofFieldCounter(gameScene, fieldTile);
                }
            }
        };
        gameTimer.start();
    }

    public void proofFieldCounter(GameScene gameScene, FieldTile fieldTile){
        fieldCounter++;
        growthStageField1 = fieldTile.getGrowthState();
        growthStageField2 = fieldTile.getGrowthState2();
        growthSTageField3 = fieldTile.getGrowthState3();
        if (fieldCounter == 100) {
            if (growthStageField1 > 1 && growthStageField1 < 6) {
                //fieldTile.setGrowthState(growthStageField1+1);
            }
            if (growthStageField2 > 1 && growthStageField2 < 6) {
                fieldTile.setGrowthState2(growthStageField2+1);
            }
            if (growthSTageField3 > 1 && growthSTageField3 < 6) {
                fieldTile.setGrowthState3(growthSTageField3+1);
                gameScene.setField3(growthSTageField3+1);
            }
            fieldCounter = 0;
        }
    }


    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }


    private void proofAction(GameScene gameScene, MovingObject movingObject){
        int x = movingObject.getX();
        int y = movingObject.getY();
        if ((x == 16 || x == 17) && y == 13) {
            gameScene.getSideControlPane().getButtonAction().setDisable(false);
            gameScene.getSideControlPane().getButtonAction().setText("select vehicle");
        } else if (x == ) {

        }

        else {
            gameScene.getSideControlPane().getButtonAction().setDisable(true);
            gameScene.getSideControlPane().getButtonAction().setText("");
        }
    }


}