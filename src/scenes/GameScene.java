package scenes;

import main.Game;

// Parent class for all scenes
public class GameScene {

    private Game game;

    public GameScene(Game game) {
        this.game = game;
    }

    public Game getGame() { // Simple method to return game in case we need it in children classes
        return game;
    }

}
