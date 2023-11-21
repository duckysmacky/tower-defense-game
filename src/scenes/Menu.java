package scenes;

import extras.LoadSave;
import main.Game;
import main.GameStates;
import ui.MyButton;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Menu extends GameScene implements SceneMethods {
    private BufferedImage img; // Variable to store images
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;

    private MyButton bPlaying, bSettings, bQuit;

    public Menu(Game game) {
        super(game);
        random = new Random();
        importImg();
        loadSprites(); // Load the sprites into the array
        initButtons();
    }

    @Override
    public void render(Graphics g) {
        drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)) { // If clicked coordinates contain same coordinates as the Playing button
            GameStates.SetGameState(GameStates.PLAYING); // Set gamestate to Playing
        }
        if (bSettings.getBounds().contains(x, y)) {
            GameStates.SetGameState(GameStates.SETTINGS);
        }
        if (bQuit.getBounds().contains(x, y)) {
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlaying.setMouseOver(false);
        bSettings.setMouseOver(false);
        bQuit.setMouseOver(false);

        if (bPlaying.getBounds().contains(x, y)) { // If mouse moved over the same coordinates as the Playing button
            bPlaying.setMouseOver(true);
        }
        if (bSettings.getBounds().contains(x, y)) { // If mouse moved over the same coordinates as the Playing button
            bSettings.setMouseOver(true);
        }
        if (bQuit.getBounds().contains(x, y)) { // If mouse moved over the same coordinates as the Playing button
            bQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)) { // If mouse moved over the same coordinates as the Playing button
            bPlaying.setMousePressed(true);
        }
        if (bSettings.getBounds().contains(x, y)) { // If mouse moved over the same coordinates as the Playing button
            bSettings.setMousePressed(true);
        }
        if (bQuit.getBounds().contains(x, y)) { // If mouse moved over the same coordinates as the Playing button
            bQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        bPlaying.setMousePressed(false);
        bSettings.setMousePressed(false);
        bQuit.setMousePressed(false);
    }

    private void initButtons() {
        int w = 150;
        int h = w / 3;
        int x = 640 / 2 - w / 2;
        int y = 150;
        int yOffset = 100;

        bPlaying = new MyButton("Play", x, y, w, h);
        bSettings = new MyButton("Settings", x, y + yOffset, w, h);
        bQuit = new MyButton("Quit", x, y + yOffset * 2, w, h);
    }

    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
        bSettings.draw(g);
        bQuit.draw(g);
    }

    private void importImg() {

        img = LoadSave.getSpriteAtlas();

    }

    private void loadSprites() {

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {

                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32)); // Scans the sprite atlas and adds each sprite to the sprites array

            }
        }

    }

    private int getRandomInt() {
        return random.nextInt(100);
    }
}
