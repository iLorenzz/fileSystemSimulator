package core;

import io.Output;

import java.util.Optional;

public final class Operations {
    private Operations() {}

    public static void execute(String operation, String elementName, String elementContent) throws Exception{
        switch(operation){
            case "mkdir":
                mkdir(elementName);
                break;
            case "cd":
                cd(elementName);
                break;
            case "touch":
                touch(elementName);
                break;
            case "poweroff":
                System.exit(0);
            default:
                throw new Exception();
        }
    }

    private static void mkdir(String elementName){
        Directory newDirectory = new Directory(elementName);
        Directory.current.addDirectoryChild(newDirectory);
        Output.write(newDirectory, true);
    }

    private static void cd(String dirName) throws  Exception{
        if(dirName.equals("..")){
            Directory.current = Directory.current.getFather();
            Output.write(Directory.current, true);
            return;
        }

        Optional<Directory> nextDirectory = Directory.findChildDirByName(dirName);

        if(nextDirectory.isPresent()){
            Directory.current = nextDirectory.get();
            Output.write(Directory.current, true);
            return;
        }

        throw new Exception();
    }

    public static void touch(String elementName){

    }
}
