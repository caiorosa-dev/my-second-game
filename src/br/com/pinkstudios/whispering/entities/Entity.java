package br.com.pinkstudios.whispering.entities;

import br.com.pinkstudios.whispering.entities.util.Direction;
import br.com.pinkstudios.whispering.entities.util.Location;
import br.com.pinkstudios.whispering.entities.util.Mask;

import java.awt.*;

public abstract class Entity {

    /*
        Constructors
     */

    private Location location;
    private int width;
    private int height;

    protected Mask mask;

    public Entity(int x, int y, int width, int height) {
        this.location = new Location(x, y);
        this.width = width;
        this.height = height;
        mask = new Mask(0,0,width,height);
    }

    public Entity(Location location, int width, int height) {
        this.location = location;
        this.width = width;
        this.height = height;
        mask = new Mask(0,0,width,height);
    }

    /*
        Methods
     */

    public abstract void update();

    public abstract void render(Graphics g);

    public boolean isColliding(Entity collide){
        Rectangle thisMask = new Rectangle(getLocation().getX() + mask.getX(),getLocation().getY() + mask.getY(),mask.getWidth(),mask.getHeight());
        Rectangle collideMask = new Rectangle(collide.getLocation().getX() + collide.mask.getX(),collide.getLocation().getY() + collide.mask.getY(),collide.mask.getWidth(),collide.mask.getHeight());
        return thisMask.intersects(collideMask);
    }

    public boolean isColling(Direction direction, Location loc, Mask mask) {
        Rectangle thisMask = new Rectangle(getLocation().getX() + mask.getX(),getLocation().getY() + mask.getY(),mask.getWidth(),mask.getHeight());
        Rectangle collideMask = new Rectangle(loc.getX() + mask.getX(),loc.getY() + mask.getY(), mask.getWidth(), mask.getHeight());
        if (direction.isRight()) {
            collideMask = new Rectangle(loc.getX() + mask.getX()*2,loc.getY() + mask.getY(), mask.getWidth(), mask.getHeight());
        }
        if (direction.isLeft()) {
            collideMask = new Rectangle(loc.getX(),loc.getY(), mask.getWidth(), mask.getHeight());
        }
        return thisMask.intersects(collideMask);
    }

    /*
        Getters & Setters
     */

    public void setMask(int x, int y, int width, int height){
        mask.setX(x);
        mask.setY(y);
        mask.setWidth(width);
        mask.setHeight(height);
    }

    public Mask getMask() {
        return mask;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
