package br.com.pinkstudios.whispering.entities.util;

public class Location {

    /*
        Constructor
     */

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
        Getters & Setters
     */

    public int getX() {
        return x;
    }

    public void addX(int amount){
        x+=amount;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void addY(int amount){
        y+=amount;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Location cloneLocation() {
        return new Location(this.x, this.y);
    }

}
