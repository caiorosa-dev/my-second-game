package br.com.pinkstudios.whispering.game;

import br.com.pinkstudios.whispering.Main;

import java.io.IOException;
import java.util.Scanner;

public class Console {

    private Main main;
    private Scanner scan;
    private String command;

    public Console(Main main){
        this.main = main;
        scan = new Scanner(System.in);
    }

    public void start(){
        command = scan.nextLine();
        if(command.isEmpty()) command = scan.nextLine();
        executeCommand(command);
    }

    private void executeCommand(String command){
        if(command.equalsIgnoreCase("showfps") || command.equalsIgnoreCase("fps")){
            if(main.getLoop().isShowFPS()) main.getLoop().setShowFPS(false);
            else main.getLoop().setShowFPS(true);
        }
        if(command.equalsIgnoreCase("exit")){
            try {
                System.in.close();
                return;
            } catch (IOException ignored) { }
        }
        start();
    }

}
