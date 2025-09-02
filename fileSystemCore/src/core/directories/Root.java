package core.directories;

import java.util.ArrayList;

public class Root extends Directory{
    public Root(){
        super("/", new ArrayList<>(), new ArrayList<>());
    }
}
