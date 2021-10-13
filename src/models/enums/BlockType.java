package models.enums;

public enum BlockType {
    SQUARE(0),
    STRAIGHT(1),
    CURVE_LEFT(2),
    CURVE_RIGHT(3),
    CORNER_LEFT(4),
    CORNER_RIGHT(5);

    private int number;

    BlockType(int number){
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
