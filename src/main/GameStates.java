package main;

// Enum is a class which holds constant values
public enum GameStates {
    PLAYING, MENU, SETTINGS;

    public static GameStates gameState = MENU;
    public static void SetGameState(GameStates state) {
        gameState = state;
    }

}
