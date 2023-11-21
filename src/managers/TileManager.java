package managers;

import extras.LoadSave;
import objects.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager {
    public Tile GRASS, WATER, ROAD;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {
        
        loadAtlas();
        createTiles();

    }

    private void createTiles() {

       tiles.add(GRASS = new Tile(getSprite(8, 1))); // ID (Index) of 0
       tiles.add(WATER = new Tile(getSprite(0, 6))); // ID of 1
       tiles.add(ROAD = new Tile(getSprite(9, 0))); // ID of 2, etc

    }

    private void loadAtlas() {
        atlas = LoadSave.getSpriteAtlas();
    }

    private BufferedImage getSprite(int x, int y) {
        return atlas.getSubimage(x * 32, y * 32, 32, 32); // Gets a single tile by its X and Y location (coordinates in the image grid)
    }

    public BufferedImage getSprite(int id) {
        return tiles.get(id).getSprite(); // Gets a tile by its ID (index in the array)
    }

}
