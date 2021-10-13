package models;

import java.awt.*;
import models.Cell;
import models.Game;

// class which inherits the Canvas class
// to create Canvas
public class GameCanvas extends Canvas {

    // class constructor
    public GameCanvas() {
        super();
        setBackground (Color.getHSBColor(135, 49, 85));
        setBounds(150, 50, Game.CANVAS_WIDTH, Game.CANVAS_HEIGHT);
    }

    public void drawBlock(int x, int y){
        Graphics g = this.getGraphics();
        g.fillRect(Cell.width * x, Cell.height * (y - Game.SUBSPACE), Cell.width, Cell.height);
    }

}
