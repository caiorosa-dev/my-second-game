package br.com.pinkstudios.whispering.world;

import br.com.pinkstudios.whispering.Main;
import br.com.pinkstudios.whispering.entities.util.Location;
import br.com.pinkstudios.whispering.graphics.sprites.Tiles;
import br.com.pinkstudios.whispering.world.tiles.impl.FloorTile;
import br.com.pinkstudios.whispering.world.tiles.impl.WallTile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class World {

    private static int WIDTH, HEIGHT, FRAME_WIDTH = 360, FRAME_HEIGHT = 180;
    public static final int TILE_SIZE = 16;
    private Tiles defaultTile;

    /*
        Constructor
     */

    public World(String path) {
        try {

            /*
                Load
             */

            FRAME_HEIGHT = Main.getInstance().getFrame().getHEIGHT();
            FRAME_WIDTH = Main.getInstance().getFrame().getWIDTH();

            String tile = (String) Main.getInstance().getJsonConfig().get("default_floor");
            defaultTile = Tiles.valueOf(tile);

            Main main = Main.getInstance();
            BufferedImage map = ImageIO.read(getClass().getResource(path));
            WIDTH = map.getWidth();
            HEIGHT = map.getHeight();

            /*
                Get pixels
             */

            int[] pixels = new int[WIDTH * HEIGHT];
            map.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);

            /*
                Run the pixels of map
             */

            for (int xx = 0; xx < WIDTH; xx++) {
                for (int yy = 0; yy < HEIGHT; yy++) {

                    int currentPixel = pixels[xx + (yy * map.getWidth())];
                    Location loc = new Location(xx*TILE_SIZE, yy*TILE_SIZE);

                    // Default tile
                    main.getTilesList().add(new FloorTile(loc, defaultTile));

                    if(EntitiesColor.PLAYER.isValidColor(currentPixel)){
                        main.getPlayer().setLocation(new Location(xx*TILE_SIZE, yy*TILE_SIZE));
                    }

                    /*
                        Carregamento dos tiles
                     */

                    for (EntitiesColor color : EntitiesColor.values()) {
                        if(color.isValidColor(currentPixel)) {
                            if(color.name().contains("FLOOR")) {
                                main.getTilesList().add(new FloorTile(loc,Tiles.valueOf(color.name())));
                                continue;
                            }
                            if(color.name().contains("WALL")) {
                                main.getTilesList().add(new WallTile(loc,Tiles.valueOf(color.name())));
                            }
                        }
                    }
                }
            }

        } catch(IOException | NullPointerException e){
            e.printStackTrace();
        }
    }

    /*
        Getters
     */

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

}
