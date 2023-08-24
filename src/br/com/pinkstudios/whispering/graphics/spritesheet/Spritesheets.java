package br.com.pinkstudios.whispering.graphics.spritesheet;

public enum Spritesheets {

    NOT_ANIMATED_TILES("/maps/not_animated_tiles.png"),
    ENTITIES_PLAYER("/entities/player_v2.png");

    private final Spritesheet spritesheet;

    Spritesheets(String path){
        this.spritesheet = new Spritesheet(path);
    }

    public Spritesheet getSpritesheet() {
        return spritesheet;
    }

    public static void load(){ }

}
