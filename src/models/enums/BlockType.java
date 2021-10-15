package models.enums;

public enum BlockType {
    O(0),
    I(1),
    Z(2),
    S(3),
    L(4),
    J(5);

    private int number;

    BlockType(int number){
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
