package main;

import inputs.KeyboardListener;
import inputs.MyMouseListener;

import javax.swing.JPanel;
import java.awt.*;

public class GameScreen extends JPanel {
    private Game game;

    private Dimension size;

    private long lastTime;
    private int frames;

    private MyMouseListener myMouseListener; // Adds the listener methods
    private KeyboardListener keyboardListener;

    public GameScreen(Game game) {
        this.game = game;

        setPanelSize();
    }

    private void setPanelSize() {

        size = new Dimension(640, 640); // Give base size for window for later reference
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the super class to render frames
        game.getRender().render(g); // Call the render class to render the scene
    }

    public void initInputs() {

        myMouseListener = new MyMouseListener(game); // Set the variables with new classes
        keyboardListener = new KeyboardListener();

        addMouseListener(myMouseListener); // Set ... with our listeners
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);

        requestFocus(); // Direct the inputs to our JFrame (aka focus the app)

    }

}
