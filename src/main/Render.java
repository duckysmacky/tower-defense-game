package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Render {
    private Game game;

    public Render(Game game) {
        this.game = game;
    }

    public void render(Graphics g) {

        // We are going to render the scene according to the game state
        switch (GameStates.gameState) {

            case MENU:
                game.getMenu().render(g); // Grabs the menu class, calls render from it to place tiles

                break;
            case PLAYING:
                game.getPlaying().render(g);

                break;
            case SETTINGS:
                game.getSettings().render(g);

                break;

        }
    }
}
