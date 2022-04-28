package com.springbootfastdfsmysql.mysql.myclass;

public class fileinfo {
    private Integer id;

    private String oldname;

    private String newname;

    private Integer filesize;

    private String filepath;

    public Integer getId() {
        return id;
    }

    public  void setId(Integer id) {
        this.id = id;
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}