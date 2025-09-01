package core;

import io.Input;

import java.util.Objects;

public class ReadCommand {

    public static void readCommand(){
        String fullCommand, operation,
                elementName, elementContent;

        String[] brokenCommand;

        do{
            fullCommand = Input.read();
            brokenCommand = fullCommand.split(" ");

            operation = brokenCommand[0];

            if(brokenCommand.length >= 2) {
                elementName = brokenCommand[1];
            }

            if(brokenCommand.length >= 3){
                elementContent = brokenCommand[2];
            }

        }while(!operation.equals("poweroff"));
    }
}
