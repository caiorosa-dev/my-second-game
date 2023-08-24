package br.com.pinkstudios.whispering.world.tiles;

import br.com.pinkstudios.whispering.entities.StaticEntity;
import br.com.pinkstudios.whispering.entities.util.Location;
import br.com.pinkstudios.whispering.graphics.sprites.Tiles;
import br.com.pinkstudios.whispering.world.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile extends StaticEntity {

	private final BufferedImage sprite;
	private final boolean collide;

	public Tile(Location location, Tiles tile, boolean collide) {
		super(location, 16, 16);
		sprite = tile.getSprite();
		this.collide = collide;
	}

	public void render(Graphics g) {
		g.drawImage(sprite, getLocation().getX() - Camera.getX(), getLocation().getY() - Camera.getY(), null);
	}

	public boolean isCollide() {
		return collide;
	}
}
