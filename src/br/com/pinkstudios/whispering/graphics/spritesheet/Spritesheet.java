package br.com.pinkstudios.whispering.graphics.spritesheet;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spritesheet {

    private BufferedImage spritesheet;

    public Spritesheet(String path){
        try {
            spritesheet = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            System.out.println("An error occurred when trying a get the file '"+path+"'");
        }
    }

     public BufferedImage getSprite(int x, int y,int w,int h){
        return spritesheet.getSubimage(x, y, w, h);
     }

}
