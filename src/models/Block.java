package models;

import models.enums.BlockType;
import models.enums.Rotation;
import java.awt.Point;

public class Block {
    public BlockType type;
    public Rotation rotation = Rotation.ONE;

    private Point[][][] blocksTable = {
            {
                {new Point(-1, -1), new Point(-1, 0), new Point(0, -1)}, // SQUARE
                    {new Point(-1, -1), new Point(-1, 0), new Point(0, -1)}, // TWO
                    {new Point(-1, -1), new Point(-1, 0), new Point(0, -1)}, // THREE
                    {new Point(-1, -1), new Point(-1, 0), new Point(0, -1)}}, // FOUR
            {
                {new Point(0, -1), new Point(0, -2), new Point(0, 1)}, // STRAIGHT
                    {new Point(2, 0), new Point(1, 0), new Point(-1, 0)}, // TWO
                    {new Point(0, -1), new Point(0, 1), new Point(0, 2)}, // THREE
                    {new Point(-2, 0), new Point(-1, 0), new Point(1, 0)},}, // FOUR
            {
                {new Point(-1, -1), new Point(-1, 0), new Point(0, 1)}, // CURVE_LEFT
                    {new Point(1, -1), new Point(0, -1), new Point(-1, 0)}, // TWO
                    {new Point(0, -1), new Point(1, 0), new Point(1, 1)}, // THREE
                    {new Point(-1, 1), new Point(0, 1), new Point(1, 0)}}, // FOUR
            {
                {new Point(1, -1), new Point(1, 0), new Point(0, 1)}, // CURVE_RIGHT
                    {new Point(-1, 0), new Point(0, 1), new Point(1, 1)}, // TWO
                    {new Point(0, -1), new Point(-1, 0), new Point(-1, 1)}, // THREE
                    {new Point(1, 0), new Point(0, -1), new Point(-1, -1)}}, // FOUR
            {
                {new Point(-1, -1), new Point(0, -1), new Point(0, 1)}, // CORNER_LEFT
                    {new Point(1, -1), new Point(1, 0), new Point(-1, 0)}, // TWO
                    {new Point(1, 1), new Point(0, 1), new Point(0, -1)}, // THREE
                    {new Point(-1, 1), new Point(-1, 0), new Point(1, 0)}}, // FOUR
            {
                {new Point(1, -1), new Point(0, -1), new Point(0, 1)}, // CORNER_RIGHT
                    {new Point(1, 1), new Point(1, 0), new Point(-1, 0)}, // TWO
                    {new Point(0, -1), new Point(0, 1), new Point(-1, 1)}, // THREE
                    {new Point(-1, -1), new Point(-1, 0), new Point(1, 0)}} // FOUR
    };

    public Block() {
        int randomTypeNumber = (int) (Math.random() * 6);
        this.type = BlockType.values()[randomTypeNumber];
        System.out.println(this.type.name());
    }

    public int getX(int partNumber) {
        return blocksTable[type.getNumber()][rotation.getNumber()][partNumber].x;
    }

    public int getY(int partNumber) {
        return blocksTable[type.getNumber()][rotation.getNumber()][partNumber].y;
    }

    public void changeRotation(){
        int newRotationNumber = this.rotation.getNumber() + 1;
        if (newRotationNumber > 3) {
            newRotationNumber = 0;
        }
        this.rotation = Rotation.values()[newRotationNumber];
    }

    public void changeRotation(int dir){
        int newRotationNumber = this.rotation.getNumber() + dir;
        if (newRotationNumber > 3) {
            newRotationNumber = 0;
        } else if (newRotationNumber < 0) {
            newRotationNumber = 3;
        }
        this.rotation = Rotation.values()[newRotationNumber];
    }
}
