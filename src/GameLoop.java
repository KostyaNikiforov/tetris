import models.Game;
import models.enums.CellType;

public class GameLoop {

    public static void gameLoop() throws InterruptedException{
        Game.fillUpField();
        Game.createNewBlock();

        while (true) {
            Thread.sleep(1000);
            while (Game.play) {
                Thread.sleep(Game.getSpeed());
                Game.step();
                Game.update();
            }
        }
    }

}
