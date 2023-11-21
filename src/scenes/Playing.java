package scenes;

import extras.LevelBuilder;
import main.Game;
import main.GameStates;
import managers.TileManager;
import ui.MyButton;

import java.awt.*;

public class Playing extends GameScene implements SceneMethods {
    private int[][] lvl;
    private TileManager tileManager;

    private MyButton bMenu;

    public Playing(Game game) {
        super(game);
        lvl = LevelBuilder.getLevelData();
        tileManager = new TileManager();
        initButtons();
    }

    @Override
    public void render(Graphics g) {
        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x]; // Get the ID of a tile from the lvl 2D array (aka level plan)

                g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null); // Draw correct tiles according to their ID and coordinates

            }
        }

        drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) { // If clicked coordinates contain same coordinates as the button
            GameStates.SetGameState(GameStates.MENU);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        if (bMenu.getBounds().contains(x, y)) { // If mouse moved over the same coordinates as the button
            bMenu.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        bMenu.setMousePressed(false);
    }

    private void initButtons() {
        int w = 90;
        int h = w / 3;
        int x = 4;
        int y = 4;

        bMenu = new MyButton("Menu", x, y, w, h);
    }

    private void drawButtons(Graphics g) {
        bMenu.draw(g);
    }


}
