package models;

import models.enums.CellType;

public class Cell {
    public static final int height = (int) (Game.CANVAS_HEIGHT / Game.Y_BLOCK_NUMBER);
    public static final int width = (int) (Game.CANVAS_WIDTH / Game.X_BLOCK_NUMBER);

    public CellType type = CellType.EMPTY;


}
