package core.directories;

import core.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubDirectory extends Directory { ;
    private final Directory father = current;

    public SubDirectory(String name){
        super(name, new ArrayList<>(), new ArrayList<>());
    }

    public Directory getFather() {
        return father;
    }

    public static SubDirectory currentSubDirectory(){
        return (SubDirectory) current;
    }

    public static Optional<SubDirectory> findChildDirByName(String dirName){
        Optional<SubDirectory> foundChild = Optional.empty();

        for(SubDirectory dir : current.getChildDirectories()){
            if(dir.getName().equals(dirName)){
                foundChild = Optional.of(dir);
            }
        }

        return foundChild;
    }

    public static Optional<File> findChildFileByName(String fileName){
        Optional<File> foundChild = Optional.empty();

        for(File file : current.getChildFiles()){
            if(file.getFileName().equals(fileName)){
                foundChild = Optional.of(file);
            }
        }

        return foundChild;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "directoryName='" + directoryName + '\'' +
                ", father=" + father.getName() +
                '}';
    }
}
