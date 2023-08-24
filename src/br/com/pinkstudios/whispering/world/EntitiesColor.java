package br.com.pinkstudios.whispering.world;

import br.com.pinkstudios.whispering.Main;

import java.awt.*;

public enum EntitiesColor {

    // Entities
    PLAYER("color_player"),

    // Tiles
    WALL_TILE_1("color_wall_tile_1"),
    WALL_TILE_2("color_wall_tile_2"),
    WALL_TILE_3("color_wall_tile_3"),
    WALL_TILE_4("color_wall_tile_4"),
    WALL_TILE_5("color_wall_tile_5"),
    WALL_TILE_6("color_wall_tile_6"),
    WALL_TILE_7("color_wall_tile_7"),
    WALL_TILE_8("color_wall_tile_8"),
    WALL_TILE_9("color_wall_tile_9"),

    FLOOR_TILE_1("color_floor_tile_1"),
    FLOOR_TILE_2("color_floor_tile_2"),
    FLOOR_TILE_3("color_floor_tile_3"),
    FLOOR_TILE_4("color_floor_tile_4"),
    FLOOR_TILE_5("color_floor_tile_5"),
    FLOOR_TILE_6("color_floor_tile_6"),
    FLOOR_TILE_7("color_floor_tile_7"),
    FLOOR_TILE_8("color_floor_tile_8"),
    FLOOR_TILE_9("color_floor_tile_9"),
    FLOOR_TILE_10("color_floor_tile_10"),
    FLOOR_TILE_11("color_floor_tile_11"),
    FLOOR_TILE_12("color_floor_tile_12"),
    FLOOR_TILE_13("color_floor_tile_13"),
    FLOOR_TILE_14("color_floor_tile_14"),
    FLOOR_TILE_15("color_floor_tile_15"),
    FLOOR_TILE_16("color_floor_tile_16"),
    FLOOR_TILE_17("color_floor_tile_17"),
    FLOOR_TILE_18("color_floor_tile_18");


    private String color;

    EntitiesColor(String path){
        this.color = (String) Main.getInstance().getJsonConfig().get(path);
    }

    public String getColor() {
        return color;
    }

    public boolean isValidColor(int input){
        Color a = new Color(input);
        Color b = new Color(Integer.valueOf(color.substring(1, 3), 16),
                Integer.valueOf(color.substring(3, 5), 16),
                Integer.valueOf(color.substring(5, 7), 16));
        return a.equals(b);
    }

}
