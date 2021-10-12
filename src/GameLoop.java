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
                Main.window.gameCanvas.update(Main.window.gameCanvas.getGraphics());
                update();
            }
        }
    }

    public static void update() {
        for (int x = 0; x < Game.X_BLOCK_NUMBER; x++) {
            for (int y = Game.SUBSPACE; y < Game.Y_BLOCK_NUMBER + Game.SUBSPACE; y++){
                // GAME OVER CHECK
                if (y == Game.SUBSPACE && Game.field[x][y].type == CellType.STANDING) {
                    Game.restart();
                    break;
                }
                if (Game.field[x][y].type != CellType.EMPTY) {
                    Main.window.gameCanvas.drawBlock(x, y);
                }
            }
        }

    }
}
