package core;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private List<Directory> sonDirectories;

    public Directory(String name){
        this.name = name;
        sonDirectories = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
