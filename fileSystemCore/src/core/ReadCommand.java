package core;

import core.directories.Directory;
import core.directories.Root;
import core.directories.SubDirectory;
import io.Input;
import io.Output;

public class ReadCommand {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void start(){
        Root root = setupDefaultDirectories();

        do{
            String fullCommand = Input.read();
            readCommand(fullCommand, root);
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
            Output.write(e.fillInStackTrace());
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
}
