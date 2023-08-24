package br.com.pinkstudios.whispering.entities;

import br.com.pinkstudios.whispering.entities.util.Location;

public abstract class StaticEntity extends Entity {
    public StaticEntity(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public StaticEntity(Location location, int width, int height) {
        super(location, width, height);
    }

    @Override
    public void update() { }
}
