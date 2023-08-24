package br.com.pinkstudios.whispering.graphics.sprites;

import br.com.pinkstudios.whispering.graphics.spritesheet.Spritesheet;
import br.com.pinkstudios.whispering.graphics.spritesheet.Spritesheets;

import java.util.ArrayList;
import java.util.List;

public enum Animations {

    // Player
    ENTITY_PLAYER_IDLE(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 33, 6, 12),
    ENTITY_PLAYER_RIGHT(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 0, 6, 8),
    ENTITY_PLAYER_RIGHT_UP(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 7, 6, 8),
    ENTITY_PLAYER_RIGHT_DOWN(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 4, 6, 8),
    ENTITY_PLAYER_LEFT(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 2, 6, 8),
    ENTITY_PLAYER_LEFT_UP(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 6, 6, 8),
    ENTITY_PLAYER_LEFT_DOWN(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 5, 6, 8),
    ENTITY_PLAYER_UP(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 1, 6, 8),
    ENTITY_PLAYER_DOWN(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 3, 6,8),

    ENTITY_PLAYER_DASH_RIGHT(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 8, 3,6),
    ENTITY_PLAYER_DASH_UP(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 9, 3,6),
    ENTITY_PLAYER_DASH_LEFT(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 10, 3,6),
    ENTITY_PLAYER_DASH_DOWN(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 11, 3,6),
    ENTITY_PLAYER_DASH_RIGHT_DOWN(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 12, 3,6),
    ENTITY_PLAYER_DASH_LEFT_DOWN(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 13, 3,6),
    ENTITY_PLAYER_DASH_LEFT_UP(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 14, 3,6),
    ENTITY_PLAYER_DASH_RIGHT_UP(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 15, 3,6),

    ENTITY_PLAYER_DIE(Spritesheets.ENTITIES_PLAYER.getSpritesheet(), 16, 6,16);

    private final Animation animation;

    Animations(Spritesheet spritesheet, int loc, int length, int speed){
        animation = new Animation(spritesheet, loc, length, speed);
    }

    public Animation getAnimation() {
        return animation;
    }

    public static void load(){ }

    public void reset() {
        animation.setCurrentFrame(0);
    }

}
