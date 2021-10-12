package models;

import models.enums.BlockType;

public class Block {
    public BlockType type;

    public Block() {
        System.out.println("BLOCK");
        this.type = BlockType.values()[(int) (Math.random() * 6)];
        System.out.println(this.type.name());
    }
}
