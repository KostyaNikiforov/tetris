package models;

import models.enums.BlockType;
import models.enums.Rotation;
import models.fields.Vector;

public class Block {
    public BlockType type;
    public Rotation rotation = Rotation.ONE;

    private Vector[][][] blocksTable = {

            {
                {new Vector(-1, -1), new Vector(-1, 0), new Vector(0, -1)}, // SQUARE
                    {new Vector(-1, -1), new Vector(-1, 0), new Vector(0, -1)}, // TWO
                    {new Vector(-1, -1), new Vector(-1, 0), new Vector(0, -1)}, // THREE
                    {new Vector(-1, -1), new Vector(-1, 0), new Vector(0, -1)}}, // FOUR
            {
                {new Vector(0, -1), new Vector(0, -2), new Vector(0, 1)}, // STRAIGHT
                    {new Vector(2, 0), new Vector(1, 0), new Vector(-1, 0)}, // TWO
                    {new Vector(0, -1), new Vector(0, 1), new Vector(0, 2)}, // THREE
                    {new Vector(-2, 0), new Vector(-1, 0), new Vector(1, 0)},}, // FOUR
            {
                {new Vector(-1, -1), new Vector(-1, 0), new Vector(0, 1)}, // CURVE_LEFT
                    {new Vector(1, -1), new Vector(0, -1), new Vector(-1, 0)}, // TWO
                    {new Vector(0, -1), new Vector(1, 0), new Vector(1, 1)}, // THREE
                    {new Vector(-1, 1), new Vector(0, 1), new Vector(1, 0)}}, // FOUR
            {
                {new Vector(1, -1), new Vector(1, 0), new Vector(0, 1)}, // CURVE_RIGHT
                    {new Vector(-1, 0), new Vector(0, 1), new Vector(1, 1)}, // TWO
                    {new Vector(0, -1), new Vector(-1, 0), new Vector(-1, 1)}, // THREE
                    {new Vector(1, 0), new Vector(0, -1), new Vector(-1, -1)}}, // FOUR
            {
                {new Vector(-1, -1), new Vector(0, -1), new Vector(0, 1)}, // CORNER_LEFT
                    {new Vector(1, -1), new Vector(1, 0), new Vector(-1, 0)}, // TWO
                    {new Vector(1, 1), new Vector(0, 1), new Vector(0, -1)}, // THREE
                    {new Vector(-1, 1), new Vector(-1, 0), new Vector(1, 0)}}, // FOUR
            {
                {new Vector(1, -1), new Vector(0, -1), new Vector(0, 1)}, // CORNER_RIGHT
                    {new Vector(1, 1), new Vector(1, 0), new Vector(-1, 0)}, // TWO
                    {new Vector(0, -1), new Vector(0, 1), new Vector(-1, 1)}, // THREE
                    {new Vector(-1, -1), new Vector(-1, 0), new Vector(1, 0)}} // FOUR
    };

    public Block() {
        int randomTypeNumber = (int) (Math.random() * 6);
        this.type = BlockType.values()[randomTypeNumber];
        System.out.println(this.type.name());
    }

    public int getX(int partNumber) {
        return blocksTable[type.getNumber()][rotation.getNumber()][partNumber].getX();
    }

    public int getY(int partNumber) {
        return blocksTable[type.getNumber()][rotation.getNumber()][partNumber].getY();
    }

    public void changeType(){
        int newTypeNumber = this.type.getNumber() + 1;
        if (newTypeNumber > 5) {
            newTypeNumber = 0;
        }
        this.type = BlockType.values()[newTypeNumber];
    }

    public void changeRotation(){
        int newRotationNumber = this.rotation.getNumber() + 1;
        if (newRotationNumber > 3) {
            newRotationNumber = 0;
        }
        this.rotation = Rotation.values()[newRotationNumber];
    }
}
