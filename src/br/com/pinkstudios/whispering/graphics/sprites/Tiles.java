package br.com.pinkstudios.whispering.graphics.sprites;

import br.com.pinkstudios.whispering.graphics.spritesheet.Spritesheet;
import br.com.pinkstudios.whispering.graphics.spritesheet.Spritesheets;

import java.awt.image.BufferedImage;

public enum Tiles {

    // Wall

    WALL_TILE_1(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 0, 0),
    WALL_TILE_2(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 1, 0),
    WALL_TILE_3(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 2, 0),
    WALL_TILE_4(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 3, 0),
    WALL_TILE_5(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 4, 0),
    WALL_TILE_6(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 5, 0),
    WALL_TILE_7(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 6, 0),
    WALL_TILE_8(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 7, 0),
    WALL_TILE_9(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 8, 0),

    // Floor

    FLOOR_TILE_1(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 0, 1),
    FLOOR_TILE_2(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 1, 1),
    FLOOR_TILE_3(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 2, 1),
    FLOOR_TILE_4(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 3, 1),
    FLOOR_TILE_5(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 4, 1),
    FLOOR_TILE_6(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 5, 1),
    FLOOR_TILE_7(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 6, 1),
    FLOOR_TILE_8(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 7, 1),
    FLOOR_TILE_9(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 8, 1),
    FLOOR_TILE_10(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 0, 2),
    FLOOR_TILE_11(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 1, 2),
    FLOOR_TILE_12(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 2, 2),
    FLOOR_TILE_13(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 3, 2),
    FLOOR_TILE_14(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 4, 2),
    FLOOR_TILE_15(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 5, 2),
    FLOOR_TILE_16(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 6, 2),
    FLOOR_TILE_17(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 7, 2),
    FLOOR_TILE_18(Spritesheets.NOT_ANIMATED_TILES.getSpritesheet(), 8, 2);

    private BufferedImage sprite;
    private final int TILE_SIZE = 16;

    Tiles(Spritesheet spritesheet, int locX, int locY){
        this.sprite = spritesheet.getSprite(locX*TILE_SIZE, locY*TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public static void load() {}

}
