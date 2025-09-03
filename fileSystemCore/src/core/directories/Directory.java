package core.directories;

import core.File;

import java.util.List;
import java.util.Optional;

public abstract class Directory {
    protected String directoryName;
    protected List<SubDirectory> childDirectories;
    protected List<File> childFiles;
    protected static Directory current = null;

    public Directory(String directoryName, List<SubDirectory> childDirectories, List<File> childFiles) {
        this.directoryName = directoryName;
        this.childDirectories = childDirectories;
        this.childFiles = childFiles;
    }

    public void setName(String name) {
        this.directoryName = name;
    }

    public String getName(){
        return this.directoryName;
    }

    public void addDirectoryChild(SubDirectory child){
        childDirectories.add(child);
    }

    public void removeDirectoryChild(SubDirectory child){
        childDirectories.remove(child);
    }

    public void addFileChild(File child){
        childFiles.add(child);
    }

    public void removeFileChild(File child){
        childFiles.remove(child);
    }

    public List<SubDirectory> getChildDirectories() {
        return childDirectories;
    }

    public List<File> getChildFiles() {
        return childFiles;
    }

    public static void setCurrentDirectory(Directory dir){
        current = dir;
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

    public boolean childDirectoryAlreadyExists(String dirName){
        Optional<SubDirectory> foundChild = findChildDirByName(dirName);

        return foundChild.isPresent();
    }

    public boolean childFileAlreadyExists(String fileName){
        Optional<File> foundChild = findChildFileByName(fileName);

        return foundChild.isPresent();
    }
}
