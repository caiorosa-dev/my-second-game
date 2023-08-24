package br.com.pinkstudios.whispering.listeners;

import br.com.pinkstudios.whispering.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

    private final Main main;

    public GameKeyListener(Main main){
        this.main = main;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            main.getPlayer().getDirection().setUp(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            main.getPlayer().getDirection().setDown(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            main.getPlayer().getDirection().setLeft(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            main.getPlayer().getDirection().setRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            main.getPlayer().setShift(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_F11) {
            Main.toggleFullScreen();
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            main.getPlayer().getDirection().setUp(false);
            main.getPlayer().getAnimations()[0].setCurrentFrame(0);
            main.getPlayer().getAnimations()[3].setCurrentFrame(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            main.getPlayer().getDirection().setDown(false);
            main.getPlayer().getAnimations()[0].setCurrentFrame(0);
            main.getPlayer().getAnimations()[4].setCurrentFrame(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            main.getPlayer().getDirection().setLeft(false);
            main.getPlayer().getAnimations()[0].setCurrentFrame(0);
            main.getPlayer().getAnimations()[2].setCurrentFrame(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            main.getPlayer().getDirection().setRight(false);
            main.getPlayer().getAnimations()[0].setCurrentFrame(0);
            main.getPlayer().getAnimations()[1].setCurrentFrame(0);
        }
    }
}
