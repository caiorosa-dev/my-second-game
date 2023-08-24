package br.com.pinkstudios.whispering.game;

import br.com.pinkstudios.whispering.Main;
import br.com.pinkstudios.whispering.game.task.TickTask;

public class Loop implements Runnable {

    private final double FPS = 60;
    private boolean isRunning;
    private boolean showFPS;

    private Thread mainThread;
    private Thread updateThread;
    private TickTask tickTask;

    private int frames;

    private Main main;

    public Loop(Main main){
        this.main = main;
    }

    /*
        Methods
     */

    public synchronized void initLoop(){
        tickTask = new TickTask(main);

        updateThread = new Thread(tickTask);
        mainThread = new Thread(this);

        updateThread.start();
        tickTask.setRunning(true);

        mainThread.start();
        isRunning = true;
    }

    public synchronized void stopLoop(){
        isRunning = false;
        tickTask.setRunning(false);
        try {
            updateThread.join();
            mainThread.join();
        } catch (InterruptedException e) { e.printStackTrace(); }
    }

    /*
        Game
     */

    public void update(){
        main.update();
    }

    public void render(){
        main.render();
    }

    public void run() {
        long lastTime = System.nanoTime();
        double ns = 1000000000 / FPS;
        double delta = 0;
        frames = 0;
        double timer = System.currentTimeMillis();

        // Loop
        while (isRunning){
            long now = System.nanoTime();
            delta += (now-lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                render();
                delta--;
                frames++;
            }
            if((System.currentTimeMillis() - timer) > 1000){
                if(showFPS) System.out.println("Current FPS: "+frames);
                frames = 0;
                timer += 1000;
            }
        }

        // Stop
        stopLoop();
    }

    /*
        Getters
     */

    public boolean isShowFPS() {
        return showFPS;
    }

    public void setShowFPS(boolean showFPS) {
        this.showFPS = showFPS;
    }
}
