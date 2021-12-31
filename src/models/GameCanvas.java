package models;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class GameCanvas extends Canvas {
    public GameCanvas() {
        super();
        setBackground (Color.getHSBColor(135, 49, 85));
        setBounds(150, 50, Game.CANVAS_WIDTH, Game.CANVAS_HEIGHT);
    }

    public void drawBlock(int x, int y){
        Graphics g = this.getGraphics();
        g.fillRect(Cell.WIDTH * x, Cell.HEIGHT * (y - Game.SUBSPACE), Cell.WIDTH, Cell.HEIGHT);
    }
}
