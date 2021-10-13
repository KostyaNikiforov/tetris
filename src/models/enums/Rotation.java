package models.enums;

public enum Rotation {
    ONE(0),
    TWO(1),
    THREE(2),
    FOUR(3);

    private int number;

    Rotation(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
