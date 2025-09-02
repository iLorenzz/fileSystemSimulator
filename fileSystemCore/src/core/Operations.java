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
            case "write":
                writeFile(elementName, elementContent);
                break;
            case "poweroff":
                System.exit(0);
            default:
                throw new Exception();
        }
    }

    private static void mkdir(String elementName){
        //TODO: verify if already exists a directory with this name
        Directory newDirectory = new Directory(elementName);
        Directory.current.addDirectoryChild(newDirectory);
        Output.write(newDirectory, true);
    }

    private static void cd(String dirName) throws  Exception{
        //TODO: verify if already exists a directory with this name
        if(dirName.equals("..")){
            Directory.current = Directory.current.getFather();
            Output.write(Directory.current, true);
            return;
        }

        Optional<Directory> nextDirectory = Directory.findChildDirByName(dirName);

        if(nextDirectory.isPresent()){
            Directory.current = nextDirectory.get();
            //Output.write(Directory.current, true);
            return;
        }

        throw new Exception();
    }

    public static void touch(String elementName) throws Exception{
        //TODO: verify if already exists a file with this name
        Directory.current.addFileChild(new File(elementName, Directory.current));
    }

    public static void writeFile(String elementName, String content) throws Exception{
        //TODO: verify if already exists a file with this name
        Optional<File> file = Directory.findChildFileByName(elementName);
        String formatedContent = "";

        if(content == null || !content.startsWith("\"") || !content.endsWith("\"")){
            throw  new Exception();
        }

        if(content.length() >= 2){
            formatedContent = content.substring(1, content.length() - 1);
        }

        if(file.isPresent()){
            file.get().setContent(formatedContent);
            Output.write(file.get(), true);
            return;
        }

        throw new Exception();
    }

}
