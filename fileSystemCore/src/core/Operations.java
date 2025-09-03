package core;

import core.directories.Directory;
import core.directories.Root;
import core.directories.SubDirectory;
import io.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class Operations {
    private Operations() {}

    public static void execute(String operation, String elementName, String elementContent, Root root) throws Exception{
        switch(operation){
            case "mkdir":
                mkdir(elementName);
                break;
            case "cd":
                cd(elementName, root);
                break;
            case "touch":
                touch(elementName);
                break;
            case "write":
                writeFile(elementName, elementContent);
                break;
            case "ls":
                ls();
                break;
            case "cat":
                cat(elementName);
                break;
            case "rm":
                rm(elementName);
                break;
            case "pwd":
                pwd();
                break;
            case "poweroff":
                System.exit(0);
            default:
                throw new Exception();
        }
    }

    private static void mkdir(String elementName) throws Exception{
        SubDirectory current = Objects.requireNonNull(SubDirectory.currentSubDirectory());

        if(current.childDirectoryAlreadyExists(elementName)){
            throw new Exception();
        }

        SubDirectory newSubDirectory = new SubDirectory(elementName);
        current.addDirectoryChild(newSubDirectory);
        //Output.write(newSubDirectory, true);
    }

    private static void cd(String dirName, Root root) throws  Exception{
        SubDirectory current = SubDirectory.currentSubDirectory();

        if(current == null){
            return;
        }

        if(dirName.equals("..")){
            if(current.getFather().getClass().isAssignableFrom(Root.class)){
                Directory.setCurrentDirectory(root);
                return;
            }

            SubDirectory.setCurrentDirectory(Objects.requireNonNull(SubDirectory.currentSubDirectory()).getFather());
            //Output.write(SubDirectory.currentSubDirectory(), true);
            return;
        }

        Optional<SubDirectory> nextDirectory = SubDirectory.findChildDirByName(dirName);

        if(nextDirectory.isPresent()){
            SubDirectory.setCurrentDirectory(nextDirectory.get());
            //Output.write(Directory.current, true);
            return;
        }

        throw new Exception();
    }

    private static void touch(String elementName) throws Exception{
        SubDirectory current = Objects.requireNonNull(SubDirectory.currentSubDirectory());

        if(current.childFileAlreadyExists(elementName)){
            throw new Exception();
        }

        current.addFileChild(new File(elementName, SubDirectory.currentSubDirectory()));
    }

    private static void writeFile(String elementName, String content) throws Exception{
        Optional<File> file = SubDirectory.findChildFileByName(elementName);
        String formatedContent = "";

        if(content == null || !content.startsWith("\"") || !content.endsWith("\"")){
            throw  new Exception();
        }

        if(content.length() >= 2){
            formatedContent = content.substring(1, content.length() - 1);
        }

        if(file.isPresent()){
            file.get().setContent(formatedContent);
            //Output.write(file.get(), true);
            return;
        }

        throw new Exception();
    }

    private static void ls(){
        for(SubDirectory dir : Objects.requireNonNull(SubDirectory.currentSubDirectory()).getChildDirectories()){
            Output.write(dir.getName() + " ");
        }

        for(File file : Objects.requireNonNull(SubDirectory.currentSubDirectory()).getChildFiles()){
            Output.write(file.getFileName() + " ");
        }

        Output.writeNewLine();
    }

    private static void cat(String elementName) throws Exception{
        Optional<File> file = SubDirectory.findChildFileByName(elementName);

        if(file.isPresent()){
            Output.write(file.get().getContent(), true);
            return;
        }

        throw new Exception();
    }

    private static void rm(String elementName) throws Exception{
        Optional<File> file = SubDirectory.findChildFileByName(elementName);

        if(file.isPresent()){
            Objects.requireNonNull(SubDirectory.currentSubDirectory()).removeFileChild(file.get());
            return;
        }

        Optional<SubDirectory> dir = SubDirectory.findChildDirByName(elementName);
        if(dir.isPresent()){
            if(!dir.get().getChildDirectories().isEmpty() || !dir.get().getChildFiles().isEmpty()){
                throw new Exception();
            }
            Objects.requireNonNull(SubDirectory.currentSubDirectory()).removeDirectoryChild(dir.get());
            return;
        }

        throw new Exception();
    }

    public static void pwd(){
        SubDirectory current = SubDirectory.currentSubDirectory();
        List<String> allDirectoriesNamePath = new ArrayList<>();

        if(current == null){
            Output.write("/", true);
            return;
        }

        while(true){
            allDirectoriesNamePath.add(current.getName());

            if(current.getFather().getClass().isAssignableFrom(Root.class)){
                break;
            }

            current = (SubDirectory) current.getFather();
        }

        String path = allDirectoriesNamePath
                .stream()
                .reduce("", (dir, accum) -> "/"+accum+dir);

        Output.write(path, true);
    }

}
