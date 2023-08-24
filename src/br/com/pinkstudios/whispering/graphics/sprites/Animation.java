package br.com.pinkstudios.whispering.graphics.sprites;

import br.com.pinkstudios.whispering.graphics.spritesheet.Spritesheet;

import java.awt.image.BufferedImage;

public class Animation {

    private final int tileSize = 16;
    private final int maxFrames;
    private final int maxAnimationFrames;
    private BufferedImage[] image;
    private int currentAnimationFrame;
    private int currentFrame = 0;
    private boolean staticInEnd = false;

    public Animation(Spritesheet spritesheet, int loc, int lenght, int animationInterval){
        maxFrames = lenght;
        maxAnimationFrames = animationInterval;
        image = new BufferedImage[lenght];
        for(int i = 0; i < lenght; i++){
            image[i] = spritesheet.getSprite(i*16, loc*16, tileSize, tileSize);
        }
    }

    /*
        Methods
     */

    public void updateAnimation(){
        currentAnimationFrame++;
        if(currentAnimationFrame >= maxAnimationFrames){
            currentAnimationFrame = 0;
            currentFrame++;
            if(currentFrame >= maxFrames){
                currentFrame = 0;
                if (staticInEnd) currentFrame = maxFrames-1;
            }
        }
    }

    /*
        Getters & Setters
     */

    public int getMaxFrames() {
        return maxFrames;
    }

    public BufferedImage getCurrent(){
        BufferedImage buffered = null;
        try{
            buffered = image[currentFrame];
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e){ }
        return buffered;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public Animation setStaticInEnd(boolean staticInEnd) {
        this.staticInEnd = staticInEnd;
        return this;
    }
}
