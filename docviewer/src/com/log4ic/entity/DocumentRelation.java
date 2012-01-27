package com.log4ic.entity;

/**
 * @author 张立鑫 IntelligentCode
 * @date: 12-1-23
 * @time: 上午2:55
 */
@Entity
public class DocumentRelation {
    private int id;
    private String fileName;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
