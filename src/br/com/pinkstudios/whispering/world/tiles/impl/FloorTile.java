package br.com.pinkstudios.whispering.world.tiles.impl;

import br.com.pinkstudios.whispering.entities.util.Location;
import br.com.pinkstudios.whispering.graphics.sprites.Tiles;
import br.com.pinkstudios.whispering.world.tiles.Tile;

public class FloorTile extends Tile {

    public FloorTile(Location loc, Tiles tile) {
        super(loc, tile, false);
    }

}
