import models.Game;
import models.enums.CellType;

public class GameLoop {

    public static void gameLoop() throws InterruptedException{
        Game.fillUpField();
        Game.createNewBlock();

        while (true) {
            Thread.sleep(Game.getSpeed());
            if (Game.play) {
                Game.step();
                Game.update();
            }
        }
    }

}
