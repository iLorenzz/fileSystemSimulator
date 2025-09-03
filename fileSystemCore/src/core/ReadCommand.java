package core;

import core.directories.Directory;
import core.directories.Root;
import core.directories.SubDirectory;
import io.Input;
import io.Output;

import java.util.Objects;

public class ReadCommand {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void start(){
        Root root = setupDefaultDirectories();

        Output.write("/"+Objects.requireNonNull(SubDirectory.currentSubDirectory()).getName() + ":" + " ");
        SubDirectory current = SubDirectory.currentSubDirectory();

        do{
            String fullCommand = Input.read();
            readCommand(fullCommand, root);

            current = SubDirectory.currentSubDirectory();
            if(current == null){
                Output.write("/: ");
                continue;
            }

            Output.write("/"+current.getName() + ":" + " ");
        }while(true);
    }

    public static void readCommand(String fullCommand, Root root){
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
            for(int i = 2; i < brokenCommand.length; i++){
                if(i != brokenCommand.length - 1)
                    elementContent = elementContent.concat(brokenCommand[i] + " ");

                if(i == brokenCommand.length - 1)
                    elementContent = elementContent.concat(brokenCommand[i]);
            }
        }

        try {
            Operations.execute(operation, elementName, elementContent, root);
        } catch (Exception e) {
            Output.write(e.getMessage(), true);
        }
    }

    public static Root setupDefaultDirectories(){
        Root root = new Root();
        SubDirectory.setCurrentDirectory(root);

        SubDirectory home = new SubDirectory("home");
        root.addDirectoryChild(home);
        SubDirectory.setCurrentDirectory(home);

        Output.write(home.getFather(), true);

        return root;
    }

    /*public static String newUser(){
        String
    }*/
}
