package core;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String directoryName;
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
}
