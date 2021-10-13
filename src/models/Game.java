package models;

import models.enums.CellType;

public class Game {
    public static final int CANVAS_HEIGHT = 400; // px
    public static final int CANVAS_WIDTH = 200; // px

    public static final int X_BLOCK_NUMBER = 9; // Blocks
    public static final int Y_BLOCK_NUMBER = 18; // Blocks

    public static final int X_SPAWN_POINT = X_BLOCK_NUMBER / 2;
    public static final int Y_SPAWN_POINT = 3;

    public static double FPS = 4; // Blocks per second

    public static boolean play = true;

    public static int SUBSPACE = 5; // Blocks

    public static Cell[][] field = new Cell[X_BLOCK_NUMBER][Y_BLOCK_NUMBER + SUBSPACE];

    public static Block blockNow;

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
                    Game.field[x][y] = new Cell();
                }
            }
        }
    }

    public static void step(){
        // System.out.println("STEP");
        for (int x = 0; x < Game.X_BLOCK_NUMBER; x++) {
            for (int y = 0; y < Game.Y_BLOCK_NUMBER + Game.SUBSPACE; y++){
                if (Game.field[x][y].type == CellType.MAIN) {
                    cleanUpField();
                    if (!verticalСollisionCheck(x, y, 1)) {
                        displayBlock(x, y + 1);
                    } else {
                        field[x][y].type = CellType.STANDING;
                        field[x + blockNow.getX(0)][y + blockNow.getY(0)].type = CellType.STANDING;
                        field[x + blockNow.getX(1)][y + blockNow.getY(1)].type = CellType.STANDING;
                        field[x + blockNow.getX(2)][y + blockNow.getY(2)].type = CellType.STANDING;
                        createNewBlock();
                    }
                    return;
                }
            }
        }
    }

    public static void displayBlock(int x, int y){
        // System.out.println("RENDERING BLOCK");

        field[x][y].type = CellType.MAIN;
        field[x + blockNow.getX(0)][y + blockNow.getY(0)].type = CellType.FALLING;
        field[x + blockNow.getX(1)][y + blockNow.getY(1)].type = CellType.FALLING;
        field[x + blockNow.getX(2)][y + blockNow.getY(2)].type = CellType.FALLING;

    }

    public static void createNewBlock(){
        System.out.println("CREATING NEW BLOCK");

        blockNow = new Block();

        System.out.println(blockNow.type.name());
        field[X_SPAWN_POINT][Y_SPAWN_POINT].type = CellType.MAIN;

    }

    public static void stop(){
        play = false;
    }

    public static void restart(){
        play = true;
        fillUpField();
        createNewBlock();
    }

    public static boolean verticalСollisionCheck(int main_x, int main_y, int move){

        if ((main_y + blockNow.getY(2) + move < Y_BLOCK_NUMBER + SUBSPACE) &&
                (main_y + blockNow.getY(1) + move < Y_BLOCK_NUMBER + SUBSPACE) &&
                (main_y + blockNow.getY(0) + move< Y_BLOCK_NUMBER + SUBSPACE) &&
                (field[main_x + blockNow.getX(0)][main_y + blockNow.getY(0) + move].type != CellType.STANDING) &&
                (field[main_x + blockNow.getX(1)][main_y + blockNow.getY(1) + move].type != CellType.STANDING) &&
                (field[main_x + blockNow.getX(2)][main_y + blockNow.getY(2) + move].type != CellType.STANDING)) {
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
                (x + blockNow.getX(0) +move > -1) &&
                (field[x + move][y + blockNow.getY(1)].type != CellType.STANDING) &&
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
        for (int x = 0; x < X_BLOCK_NUMBER; x++) {
            for (int y = 0; y < Y_BLOCK_NUMBER + Game.SUBSPACE; y++){
                if (Game.field[x][y].type == CellType.MAIN) {
                    if (!horizontalСollisionCheck(x, y, move)) {
                        System.out.println("MOVING - " + move);
                        cleanUpField();
                        displayBlock(x + move, y);
                        return;
                    }
                    return;
                }
            }
        }
    }


    public static void turnBlock(){
        Game.turnBlock();

    }

}
