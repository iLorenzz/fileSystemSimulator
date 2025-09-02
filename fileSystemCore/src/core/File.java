package core;

import core.directories.SubDirectory;

public class File {
    private String fileName;
    private String content;
    private final SubDirectory father;

    public File(String fileName, SubDirectory father){
        this.fileName = fileName;
        this.father = father;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                ", father=" + father +
                '}';
    }
}
