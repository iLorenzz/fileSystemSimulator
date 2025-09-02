package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Directory {
    public static Directory current = null;

    private String directoryName;
    private final Directory father = current;
    private List<Directory> childDirectories;
    private List<File> childFiles;

    public Directory(String name){
        this.directoryName = name;
        childDirectories = new ArrayList<>();
        childFiles = new ArrayList<>();
    }

    public void setName(String name) {
        this.directoryName = name;
    }

    public String getName(){
        return this.directoryName;
    }

    public Directory getFather() {
        return father;
    }

    public void addDirectoryChild(Directory child){
        childDirectories.add(child);
    }

    public void removeDirectoryChild(Directory child){
        childDirectories.remove(child);
    }

    public void addFileChild(File child){
        childFiles.add(child);
    }

    public void removeFileChild(File child){
        childFiles.remove(child);
    }


    public List<Directory> getChildDirectories() {
        return childDirectories;
    }

    public List<File> getChildFiles() {
        return childFiles;
    }

    public static Optional<Directory> findChildDirByName(String dirName){
        Optional<Directory> foundChild = Optional.empty();

        for(Directory dir : current.getChildDirectories()){
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
