package core.directories;

import core.File;

import java.util.List;

public abstract class Directory {
    protected String directoryName;
    protected List<SubDirectory> childDirectories;
    protected List<File> childFiles;
    public static Directory current = null;

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
}
