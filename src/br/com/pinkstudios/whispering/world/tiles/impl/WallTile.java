package br.com.pinkstudios.whispering.world.tiles.impl;

import br.com.pinkstudios.whispering.entities.util.Location;
import br.com.pinkstudios.whispering.graphics.sprites.Tiles;
import br.com.pinkstudios.whispering.world.tiles.Tile;

public class WallTile extends Tile {

    public WallTile(Location loc, Tiles tile) {
        super(loc, tile, true);
    }

}
