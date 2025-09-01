package core;

public class File {
    private String fileName;
    private String content;
    private Directory father;

    public File(String fileName, String content){
        this.fileName = fileName;
        this.content = content;
    }
}
