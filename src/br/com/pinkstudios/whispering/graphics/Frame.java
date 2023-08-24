package br.com.pinkstudios.whispering.graphics;

import br.com.pinkstudios.whispering.Main;
import br.com.pinkstudios.whispering.listeners.GameKeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Frame extends Canvas {

    private final String TITLE = "Whispering Dungeons | Alpha 1.0";
    private int WIDTH = 360;
    private int HEIGHT = 180;
    private int SCALE = 3;
    private JFrame frame;
    private Main main;

    /*
        Constructor
     */

    public Frame(Main main){
        this.main = main;
        frame = new JFrame(TITLE);
        Dimension dimension = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
        addKeyListener(new GameKeyListener(main));
        setPreferredSize(dimension);
        initFrame();
    }

    /*
        Methods
     */

    public void initFrame(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        frame.add(this);
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource("/especial/window_icon.png"));
        }catch(IOException e) { }
        frame.setIconImage(img);
        frame.setResizable(false);
        frame.pack();
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setAutoRequestFocus(true);
        if(Boolean.parseBoolean((String) main.getJsonConfig().get("full_screen"))){
            device.setFullScreenWindow(frame);
        }
    }

    /*
        Getters
     */

    public JFrame getFrame() {
        return frame;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getSCALE() {
        return SCALE;
    }

    public int getWIDTH() {
        return WIDTH;
    }

}
