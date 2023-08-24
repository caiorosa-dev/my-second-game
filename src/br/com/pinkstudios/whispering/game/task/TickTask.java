package br.com.pinkstudios.whispering.game.task;

import br.com.pinkstudios.whispering.Main;

public class TickTask implements Runnable {
    private final double UPS = 60;
    private boolean isRunning;
    private boolean showUPS;
    private final Main main;

    private int ticks;

    public TickTask(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double ns = 1000000000 / UPS;
        double delta = 0;
        ticks = 0;
        double timer = System.currentTimeMillis();

        // Loop
        while (isRunning){
            long now = System.nanoTime();
            delta += (now-lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                main.update();
                delta--;
                ticks++;
            }
            if((System.currentTimeMillis() - timer) > 1000){
                if(showUPS) System.out.println("Current UPS: "+ticks);
                ticks = 0;
                timer += 1000;
            }
        }
    }

    public int getTicks() {
        return ticks;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void setShowFPS(boolean showUPS) {
        this.showUPS = showUPS;
    }
}
