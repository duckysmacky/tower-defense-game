package scenes;

import main.Game;
import main.GameStates;
import ui.MyButton;

import java.awt.*;

public class Settings extends GameScene implements SceneMethods {
    private MyButton bMenu;

    public Settings(Game game) {
        super(game);
        initButtons();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 640, 640);

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
