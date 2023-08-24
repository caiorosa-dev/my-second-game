package br.com.pinkstudios.whispering.entities.lived.impl;

import br.com.pinkstudios.whispering.Main;
import br.com.pinkstudios.whispering.entities.lived.LivedEntity;
import br.com.pinkstudios.whispering.entities.util.Direction;
import br.com.pinkstudios.whispering.entities.util.Location;
import br.com.pinkstudios.whispering.graphics.sprites.Animation;
import br.com.pinkstudios.whispering.graphics.sprites.Animations;
import br.com.pinkstudios.whispering.world.Camera;
import br.com.pinkstudios.whispering.world.World;
import br.com.pinkstudios.whispering.world.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Player extends LivedEntity {

    private final int SPEED = 1;
    private final float DASH_MULTIPLIER = 3F;

    private final Direction direction;
    private final Animation[] animations;
    private BufferedImage currentAnimation;
    private boolean canMove = true;

    private boolean shift;
    private boolean dash;
    private int dashFrames;

    /*
        Constructor
     */

    public Player(Location location, int width, int height) {
        super(location, width, height);
        mask.setX(4);
        mask.setY(0);
        mask.setWidth(9);
        mask.setHeight(15);

        direction = new Direction();

        animations = new Animation[18];
        animations[0] = Animations.ENTITY_PLAYER_IDLE.getAnimation();
        animations[1] = Animations.ENTITY_PLAYER_RIGHT.getAnimation();
        animations[2] = Animations.ENTITY_PLAYER_RIGHT_UP.getAnimation();
        animations[3] = Animations.ENTITY_PLAYER_RIGHT_DOWN.getAnimation();
        animations[4] = Animations.ENTITY_PLAYER_LEFT.getAnimation();
        animations[5] = Animations.ENTITY_PLAYER_LEFT_UP.getAnimation();
        animations[6] = Animations.ENTITY_PLAYER_LEFT_DOWN.getAnimation();
        animations[7] = Animations.ENTITY_PLAYER_UP.getAnimation();
        animations[8] = Animations.ENTITY_PLAYER_DOWN.getAnimation();

        animations[9] = Animations.ENTITY_PLAYER_DASH_RIGHT.getAnimation().setStaticInEnd(true);
        animations[10] = Animations.ENTITY_PLAYER_DASH_RIGHT_UP.getAnimation().setStaticInEnd(true);
        animations[11] = Animations.ENTITY_PLAYER_DASH_RIGHT_DOWN.getAnimation().setStaticInEnd(true);
        animations[12] = Animations.ENTITY_PLAYER_DASH_LEFT.getAnimation().setStaticInEnd(true);
        animations[13] = Animations.ENTITY_PLAYER_DASH_LEFT_UP.getAnimation().setStaticInEnd(true);
        animations[14] = Animations.ENTITY_PLAYER_DASH_LEFT_DOWN.getAnimation().setStaticInEnd(true);
        animations[15] = Animations.ENTITY_PLAYER_DASH_UP.getAnimation().setStaticInEnd(true);
        animations[16] = Animations.ENTITY_PLAYER_DASH_DOWN.getAnimation().setStaticInEnd(true);

        animations[17] = Animations.ENTITY_PLAYER_DIE.getAnimation();
    }

    /*
        Methods
     */

    public void update() {
        lastLife = life;
        updateCamera();

        if(life <= 0){
            died = true;
        }

        if(died) {
            diedTicks++;
            if (diedTicks >= 2);
        }

        /*
            Die Animation
         */

        if(shift) {
            if(!direction.isIdle()) {
                dash = true;
                dashFrames++;
                if(dashFrames >= 48) {
                    dashFrames = 0;
                    shift = false;
                    dash = false;
                }
            } else {
                dashFrames = 0;
                shift = false;
                dash = false;
            }
        }

        updateMovement();
    }

    public void updateCamera() {
        int WIDTH = Main.getInstance().getFrame().getWIDTH();
        int HEIGHT = Main.getInstance().getFrame().getHEIGHT();
        Camera.setX(Camera.clamp(getLocation().getX() - (WIDTH / 2), 0, World.getWIDTH() * 16 - WIDTH));
        Camera.setY(Camera.clamp(getLocation().getY() - (HEIGHT / 2), 0, World.getHEIGHT() * 16 - HEIGHT));
    }

    private boolean resetAnimation = false;

    private void updateMovement(){

        float currentMultiplier = 1;
        if (dash) currentMultiplier = DASH_MULTIPLIER;

        // Movement
        int currentAnimationArray = 0;

        if (dash) {
            if (resetAnimation) Arrays.stream(Animations.values()).forEach(Animations::reset);
            resetAnimation = false;

            Location nextLoc = this.getLocation().cloneLocation();

            if(direction.isUp()) {
                currentAnimationArray = 15;
                nextLoc.addY(Math.round(-1*SPEED* currentMultiplier));
            }
            else if(direction.isDown()) {
                currentAnimationArray = 16;
                nextLoc.addY(Math.round(SPEED* currentMultiplier));
            }
            if(direction.isRight()) {
                currentAnimationArray = 9;
                if(direction.isUp()) {
                    currentAnimationArray = 10;
                }
                else if (direction.isDown()) {
                    currentAnimationArray = 11;
                }
                nextLoc.addX(Math.round(SPEED* currentMultiplier));
            }
            else if(direction.isLeft()) {
                currentAnimationArray = 12;
                if(direction.isUp()) {
                    currentAnimationArray = 13;
                }
                if(direction.isDown()) {
                    currentAnimationArray = 14;
                }
                nextLoc.addX(Math.round(-1*SPEED* currentMultiplier));
            }
            if (!collide(nextLoc)) {
                this.setLocation(nextLoc);
            }
        } else if (!direction.isIdle()) {
            resetAnimation = true;
            Location nextLoc = this.getLocation().cloneLocation();

            if(direction.isUp()) {
                currentAnimationArray = 7;
                nextLoc.addY(Math.round(-1*SPEED* currentMultiplier));
            }
            else if(direction.isDown()) {
                currentAnimationArray = 8;
                nextLoc.addY(Math.round(SPEED* currentMultiplier));
            }
            if(direction.isRight()) {
                currentAnimationArray = 1;
                if(direction.isUp()) {
                    currentAnimationArray = 2;
                }
                else if (direction.isDown()) {
                    currentAnimationArray = 3;
                }
                nextLoc.addX(Math.round(SPEED* currentMultiplier));
            }
            else if(direction.isLeft()) {
                currentAnimationArray = 4;
                if(direction.isUp()) {
                    currentAnimationArray = 5;
                }
                if(direction.isDown()) {
                    currentAnimationArray = 6;
                }
                nextLoc.addX(Math.round(-1*SPEED* currentMultiplier));
            }
            if (!collide(nextLoc)) {
                this.setLocation(nextLoc);
            }
        }

        // Animation update
        animations[currentAnimationArray].updateAnimation();
        currentAnimation = animations[currentAnimationArray].getCurrent();
    }

    private boolean collide(Location next) {
        return isCollidingWithTile(next);
    }

    private boolean isCollidingWithTile(Location next) {
        for (Tile tile: Main.getInstance().getTilesList()) {
            if (tile.isCollide() && tile.isColling(direction, next, getMask())) {
                return true;
            }
        }
        return false;
    }

    /*
        Methods
     */

    public void render(Graphics g) {
        g.drawImage(currentAnimation, getLocation().getX() - Camera.getX(), getLocation().getY()  - Camera.getY(), null);
    }

    public Animation[] getAnimations() {
        return animations;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void setShift(boolean shift) {
        this.shift = shift;
    }
}
