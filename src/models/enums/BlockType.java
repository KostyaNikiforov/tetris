package models.enums;

import models.fields.Vector;

public enum BlockType {
    SQUARE (new Vector(-1, -1), new Vector(-1, 0), new Vector(0, -1)),
    STRAIGHT(new Vector(0, -1), new Vector(0, -2), new Vector(0, 1)),
    CURVE_LEFT(new Vector(-1, -1), new Vector(-1, 0), new Vector(0, 1)),
    CURVE_RIGHT(new Vector(1, -1), new Vector(1, 0), new Vector(0, 1)),
    CORNER_LEFT(new Vector(-1, -1), new Vector(0, -1), new Vector(0, 1)),
    CORNER_RIGHT(new Vector(1, -1), new Vector(0, -1), new Vector(0, 1));

    private final Vector CELL1;
    private final Vector CELL2;
    private final Vector CELL3;

    BlockType(Vector BLOCK1, Vector BLOCK2, Vector BLOCK3){
        this.CELL1 = BLOCK1;
        this.CELL2 = BLOCK2;
        this.CELL3 = BLOCK3;
    }

    public Vector getCELL1(){
        return CELL1;
    }
    public Vector getCELL2(){
        return CELL2;
    }
    public Vector getCELL3(){
        return CELL3;
    }
}
