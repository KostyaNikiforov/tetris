package models;

import com.sun.tools.javac.Main;
import models.enums.CellType;

public class Game {
    public static Window window = new Window();

    public static final int CANVAS_HEIGHT = 400; // px
    public static final int CANVAS_WIDTH = 200; // px

    public static final int X_BLOCK_NUMBER = 10; // Blocks
    public static final int Y_BLOCK_NUMBER = 20; // Blocks

    public static final int X_SPAWN_POINT = X_BLOCK_NUMBER / 2;
    public static final int Y_SPAWN_POINT = 3;

    public static double FPS = 2; // Blocks per second

    public static boolean play = true;

    public static int SUBSPACE = 5; // Blocks

    public static Cell[][] field = new Cell[X_BLOCK_NUMBER][Y_BLOCK_NUMBER + SUBSPACE];

    private static int gameLevel = 1;
    private static int gameScore = 0;


    public static Block blockNow;
    public static int mainYNow;
    public static int mainXNow;

    public static int getSpeed(){
        return (int) (1000 / FPS);
    }


    public static void fillUpField(){
        for (int x = 0; x < Game.X_BLOCK_NUMBER; x++) {
            for (int y = 0; y < Game.Y_BLOCK_NUMBER + Game.SUBSPACE; y++){
                Game.field[x][y] = new Cell();
            }
        }
    }

    public static void cleanUpField(){
        for (int x = 0; x < Game.X_BLOCK_NUMBER; x++) {
            for (int y = 0; y < Game.Y_BLOCK_NUMBER + Game.SUBSPACE; y++){
                if (Game.field[x][y].type != CellType.STANDING){
                    Game.field[x][y].type = CellType.EMPTY;
                }
            }
        }
    }

    public static void step(){
        cleanUpField();
        if (!verticalСollisionCheck(mainXNow, mainYNow, 1)) {
            mainYNow++;
            displayBlock(mainXNow, mainYNow);
        } else {

            field[mainXNow][mainYNow].type = CellType.STANDING;
            field[mainXNow + blockNow.getX(0)][mainYNow + blockNow.getY(0)].type = CellType.STANDING;
            field[mainXNow + blockNow.getX(1)][mainYNow + blockNow.getY(1)].type = CellType.STANDING;
            field[mainXNow + blockNow.getX(2)][mainYNow + blockNow.getY(2)].type = CellType.STANDING;

            int fullLinesNumber = removeFullLine();
            if (fullLinesNumber > 0) {
                updateGameRate(fullLinesNumber);
            }
            createNewBlock();
        }
    }

    public static void displayBlock(int x, int y){

        field[x][y].type = CellType.FALLING;
        field[x + blockNow.getX(0)][y + blockNow.getY(0)].type = CellType.FALLING;
        field[x + blockNow.getX(1)][y + blockNow.getY(1)].type = CellType.FALLING;
        field[x + blockNow.getX(2)][y + blockNow.getY(2)].type = CellType.FALLING;

    }

    public static void createNewBlock(){
        blockNow = new Block();

        mainXNow = X_SPAWN_POINT;
        mainYNow = Y_SPAWN_POINT;
    }

    public static void stop(){
        play = false;
    }
    public static void start(){
        play = true;
    }
    public static void pause(){
        play = !play;
    }



    public static void restart(){
        fillUpField();
        createNewBlock();
        nullifyGameRate();
        start();
    }

    public static boolean verticalСollisionCheck(int x, int y, int move){
        if (
                (y + blockNow.getY(2) + move < Y_BLOCK_NUMBER + SUBSPACE) &&
                (y + blockNow.getY(1) + move < Y_BLOCK_NUMBER + SUBSPACE) &&
                (y + blockNow.getY(0) + move< Y_BLOCK_NUMBER + SUBSPACE) &&
                (field[x][y + move].type != CellType.STANDING) &&
                (field[x + blockNow.getX(0)][y + blockNow.getY(0) + move].type != CellType.STANDING) &&
                (field[x + blockNow.getX(1)][y + blockNow.getY(1) + move].type != CellType.STANDING) &&
                (field[x + blockNow.getX(2)][y + blockNow.getY(2) + move].type != CellType.STANDING))
        {
            return false;
        } else {
            return true;
        }
    }
    public static boolean horizontalСollisionCheck(int x, int y, int move){
        if (
                (x + move < X_BLOCK_NUMBER) &&
                (x + blockNow.getX(2) + move < X_BLOCK_NUMBER) &&
                (x + blockNow.getX(1) + move < X_BLOCK_NUMBER) &&
                (x + blockNow.getX(0) +move < X_BLOCK_NUMBER) &&
                (x + move > -1) &&
                (x + blockNow.getX(2) + move > -1) &&
                (x + blockNow.getX(1) + move > -1) &&
                (x + blockNow.getX(0) + move > -1) &&
                (field[x + move][y].type != CellType.STANDING) &&
                (field[x + blockNow.getX(0) + move][y + blockNow.getY(0)].type != CellType.STANDING) &&
                (field[x + blockNow.getX(1) + move][y + blockNow.getY(1)].type != CellType.STANDING) &&
                (field[x + blockNow.getX(2) + move][y + blockNow.getY(2)].type != CellType.STANDING))
        {
            return false;
        } else {
            return true;
        }
    }

    public static void moveBlock(byte move){
        if (!horizontalСollisionCheck(mainXNow, mainYNow, move)) {
            cleanUpField();
            mainXNow += move;
            displayBlock(mainXNow, mainYNow);

            update();
        }
    }


    public static void turnBlock(){
        blockNow.changeRotation();
        if (!horizontalСollisionCheck(mainXNow, mainYNow, 0) && !verticalСollisionCheck(mainXNow, mainYNow, 1)) {
            System.out.println("TURNING BLOCK");
            cleanUpField();

            displayBlock(mainXNow, mainYNow);
            update();
        } else {
            blockNow.changeRotation(-1);
        }
    }

    public static int removeFullLine(){
        System.out.println("FULL LINE CHECKING");
        int fullLinesNumber = 0;

        for (int y = 0; y < Game.Y_BLOCK_NUMBER + Game.SUBSPACE; y++) {
            boolean fullLine = true;
            for (int x = 0; x < Game.X_BLOCK_NUMBER; x++){
                if (Game.field[x][y].type != CellType.STANDING) {
                    fullLine = false;
                    break;
                }
            }
            if (fullLine) {
                fullLinesNumber++;
                System.out.println("FULL LINE WAS FOUND.");
                for (int sy = y; sy > 0 + Game.SUBSPACE; sy--) {
                    for (int x = 0; x < Game.X_BLOCK_NUMBER; x++) {
                        Game.field[x][sy].type = Game.field[x][sy - 1].type;
                    }
                }
            }
        }
        return fullLinesNumber;
    }


    public static void update() {
        // Clearing canvas
        Game.window.gameCanvas.update(Game.window.gameCanvas.getGraphics());

        // Drawing black cell
        for (int x = 0; x < Game.X_BLOCK_NUMBER; x++) {
            for (int y = Game.SUBSPACE; y < Game.Y_BLOCK_NUMBER + Game.SUBSPACE; y++){
                // GAME OVER CHECK
                if (y == Game.SUBSPACE && Game.field[x][y].type == CellType.STANDING) {
                    Game.restart();
                    break;
                }
                if (Game.field[x][y].type != CellType.EMPTY) {
                    window.gameCanvas.drawBlock(x, y);
                }

            }
        }

    }

    public static void updateGameRate(int fullLinesNumber){
        switch (fullLinesNumber){
            case 1: gameScore += 100; break;
            case 2: gameScore += 300; break;
            case 3: gameScore += 700; break;
            case 4: gameScore += 1500; break;
            default: break;
        }
        gameLevel = Math.round(gameScore / 20000);

        // Speed up the game
        FPS = gameLevel + 1;

        window.setGameScore(gameScore);
        window.setGameLevel(gameLevel);
    }

    public static void nullifyGameRate(){
        gameLevel = 0;
        gameScore = 0;
        FPS = gameLevel + 1;

        window.setGameScore(gameScore);
        window.setGameLevel(gameLevel);
    }

}
