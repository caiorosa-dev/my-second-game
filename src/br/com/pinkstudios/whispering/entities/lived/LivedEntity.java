package br.com.pinkstudios.whispering.entities.lived;

import br.com.pinkstudios.whispering.entities.Entity;
import br.com.pinkstudios.whispering.entities.util.Location;

public abstract class LivedEntity extends Entity {

    protected int life;
    protected int lastLife;
    protected int diedTicks;
    protected boolean died;

    public LivedEntity(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public LivedEntity(Location location, int width, int height) {
        super(location, width, height);
    }

    public boolean isDied() {
        return died;
    }

    public int getLife() {
        return life;
    }

}
