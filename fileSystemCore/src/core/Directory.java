package core;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String directoryName;
    private List<Directory> sonDirectories;

    public Directory(String name){
        this.directoryName = name;
        sonDirectories = new ArrayList<>();
    }

    public void setName(String name) {
        this.directoryName = name;
    }

    public String getName(){
        return this.directoryName;
    }
}
