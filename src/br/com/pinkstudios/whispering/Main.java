package br.com.pinkstudios.whispering;

import br.com.pinkstudios.whispering.entities.Entity;
import br.com.pinkstudios.whispering.entities.lived.LivedEntity;
import br.com.pinkstudios.whispering.entities.lived.impl.Player;
import br.com.pinkstudios.whispering.entities.util.Location;
import br.com.pinkstudios.whispering.game.Console;
import br.com.pinkstudios.whispering.game.Loop;
import br.com.pinkstudios.whispering.graphics.Frame;
import br.com.pinkstudios.whispering.graphics.sprites.Animations;
import br.com.pinkstudios.whispering.graphics.spritesheet.Spritesheets;
import br.com.pinkstudios.whispering.world.World;
import br.com.pinkstudios.whispering.world.tiles.Tile;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    /*
        Instances
     */

    private static Main instance;
    private Loop loop;
    private Console console;

    // Graphics
    private Frame frame;
    private BufferedImage image;

    // Entities
    private List<Entity> entityList;
    private List<LivedEntity> livedEntitiesList;
    private List<Tile> tilesList;
    private Player player;

    // World
    private World world;
    private JSONObject jsonConfig;

    /*
        Main
     */

    public static void main(String[] args) {
        instance = new Main();
        instance.loadAll(instance);
    }

    /*
        Methods
     */

    private void loadAll(Main main){
        loop = new Loop(main);
        console = new Console(main);
        loadConfig();
        frame = new Frame(main);
        frame.requestFocus();
        player = new Player(new Location(0, 0), 14, 16);
        entityList = new ArrayList<>();
        livedEntitiesList = new ArrayList<>();
        tilesList = new ArrayList<>();
        loadLists();
        image = new BufferedImage(frame.getWIDTH(), frame.getHEIGHT(), BufferedImage.TYPE_INT_RGB);
        Spritesheets.load();
        Animations.load();
        world = new World("/maps/levels/level_1.png");
        start();
    }

    private void loadConfig(){
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream("config.json");
            InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            JSONParser parser = new JSONParser();
            jsonConfig = (JSONObject) parser.parse(reader);
            reader.close();
        } catch (IOException | NullPointerException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void loadLists(){
        livedEntitiesList.add(player);
    }

    public static void toggleFullScreen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        Frame frame = Main.getInstance().getFrame();
        if(device.getFullScreenWindow() != null) {
            device.setFullScreenWindow(null);
            frame.getFrame().setVisible(true);
            return;
        }
        device.setFullScreenWindow(frame.getFrame());
    }

    /*
       Loop
     */

    private void start(){
        loop.initLoop();
        console.start();
    }

    public void update(){

        // Update world
        for(Tile tile : tilesList) {
            tile.update();
        }

        // Update entities
        for(Entity ent : entityList){
            ent.update();
        }

        // Update lived entities
        for(LivedEntity ent : livedEntitiesList){
            ent.update();
        }

    }

    // Render
    public void renderGraphics(Graphics g){

        // Render world
        for(Tile tile : tilesList) {
            tile.render(g);
        }

        // Render entities
        for(Entity ent : entityList){
            ent.render(g);
        }

        // Render lived entities
        for(LivedEntity ent : livedEntitiesList){
            ent.render(g);
        }

    }

    public void renderGraphicsWithoutScale(Graphics g){
    }

    public void render(){

        // Buffer Strategy
        BufferStrategy bs = frame.getBufferStrategy();
        if(bs == null){
            frame.createBufferStrategy(3);
            return;
        }

        // Background & Game
        Graphics g = image.getGraphics();
        g.setColor(new Color(56, 59, 64));
        g.fillRect(0, 0 , frame.getWIDTH(), frame.getHEIGHT());
        renderGraphics(g);

        // Graphics
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0 , frame.getWidth(), frame.getHeight(), null);
        renderGraphicsWithoutScale(g);

        // Show
        bs.show();
    }

    /*
        Getters
     */

    public Loop getLoop() {
        return loop;
    }

    public Frame getFrame() {
        return frame;
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    public List<Tile> getTilesList() {
        return tilesList;
    }

    public List<LivedEntity> getLivedEntitiesList() {
        return livedEntitiesList;
    }

    public static Main getInstance() {
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public JSONObject getJsonConfig() {
        return jsonConfig;
    }

    public World getWorld() {
        return world;
    }
}
