
import models.Game;
import models.enums.CellType;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key "+e.getKeyCode()+" was pressed.");
        switch (e.getKeyCode()){
            case 37: Game.moveBlock((byte) -1); break;
            case 39: Game.moveBlock((byte) 1); break;
            case 32: Game.turnBlock(); break;
            case 40: Game.FPS = 10; break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Game.FPS = 2;
    }
}

