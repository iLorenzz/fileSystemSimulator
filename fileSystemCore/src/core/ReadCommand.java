package core;

import io.Input;
import io.Output;

public class ReadCommand {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void start(){
        Directory root = new Directory("/");
        Directory.current = root;
        Directory home = new Directory("home");

        root.addDirectoryChild(home);
        Directory.current = home;

        do{
            String fullCommand = Input.read();
            readCommand(fullCommand);
        }while(true);
    }

    public static void readCommand(String fullCommand){
        String operation;
        String elementName = "" ;
        String elementContent = "";

        String[] brokenCommand;
        brokenCommand = fullCommand.split(" ");

        operation = brokenCommand[0];

        if(brokenCommand.length >= 2) {
            elementName = brokenCommand[1];
        }

        if(brokenCommand.length >= 3){
            elementContent = brokenCommand[2];
        }

        try {
            Operations.execute(operation, elementName, elementContent);
        } catch (Exception e) {
            Output.write(e.fillInStackTrace());
        }
    }
}
