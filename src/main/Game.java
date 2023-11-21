package main;

import inputs.KeyboardListener;
import inputs.MyMouseListener;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame implements Runnable {
    private GameScreen gameScreen;
    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;

    private Thread gameThread; // Basically allows us to run multiple things at the same time

    private final double FPS_SET = 144;
    private final double UPS_SET = 60;

    public Game() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); // End program on close
        setLocationRelativeTo(null); // Centre position
        setResizable(false);

        initClasses(); // Initiate all classes

        add(gameScreen); // Adds our game screen panel to the frame

        pack(); // Makes sure the window size is correct
        setVisible(true);
    }

    private void initClasses() {
        render = new Render(this); // Render THIS game
        gameScreen = new GameScreen(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }

    private void start() {

        gameThread = new Thread(this) {}; // Initiate a thread from already existing one at the bottom
        gameThread.start(); // Start the thread

    }

    private void updateGame() {



    }

    public static void main(String[] args) {

        System.out.println("Game started");

        Game game = new Game(); // Create the thread
        game.gameScreen.initInputs();
        game.start(); // Start the thread

    }

    @Override
    public void run() {
        // 1 000 000 000 nanosec (equals to 1 sec) / 60 = 16666666.6667 nanosec = 0.01666(6) seconds => PER FRAME 60 FPS
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();

        int frames = 0;
        int updates = 0;

        long now;

        long lastTime = System.currentTimeMillis();

        while (true) { // Infinite game loop

            now = System.nanoTime();
            // Render
            if (now - lastFrame >= timePerFrame) { // If we have been displaying last frame for longer than it's supposed to be

                repaint(); // Redraws the frame
                lastFrame = now; // Save last frame time
                frames++;

            }

            // Update
            if (now - lastUpdate >= timePerUpdate) {

                updateGame(); //Updates the game
                lastUpdate = now;
                updates++;

            }

            // Runs every second (FPS / UPS)
            if (System.currentTimeMillis() - lastTime >= 1000) { // Current time in millis - current time in millis but smaller (as we set it to time before)

                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTime = System.currentTimeMillis(); // Set to newer time

            }

        }
    }

    // Getters and setters
    public Render getRender() {
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Settings getSettings() {
        return settings;
    }
}