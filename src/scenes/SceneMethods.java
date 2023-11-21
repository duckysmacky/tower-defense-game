package scenes;

import java.awt.*;

// Interface class stores all methods for all scenes to implement
// Interface class is mainly used just to store methods in case we need it for every child (in our case all scenes)
public interface SceneMethods {

    public void render(Graphics g);

    public void mouseClicked(int x, int y);
    public void mouseMoved(int x, int y);
    public void mousePressed(int x, int y);
    public void mouseReleased(int x, int y);

}
