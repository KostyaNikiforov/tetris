package models;

import models.enums.CellType;

public class Cell {
    public static final int HEIGHT;
    public static final int WIDTH;
    public CellType type;

    static {
        HEIGHT = Game.CANVAS_HEIGHT / Game.Y_BLOCK_NUMBER;
        WIDTH = Game.CANVAS_WIDTH / Game.X_BLOCK_NUMBER;
    }

    public Cell() {
        type = CellType.EMPTY;
    }
}
