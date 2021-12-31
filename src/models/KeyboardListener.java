package models;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 37: Game.moveBlock(-1); break;
            case 39: Game.moveBlock(1); break;
            case 32: Game.turnBlock(); break;
            case 40: Game.FPS = 20; break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Game.FPS = 2;
    }
}

