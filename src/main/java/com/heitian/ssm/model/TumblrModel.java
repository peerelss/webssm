package com.heitian.ssm.model;

/**
 * Created by root on 17-3-6.
 */
public class TumblrModel {
    private int id=0;
    private String name="unknown";
    private String tags="unknown";
    private String level="0";
    public TumblrModel(){

    }
    public TumblrModel(String name, String tags, String level) {
        this.name = name;
        this.tags = tags;
        this.level = level;
    }

    public TumblrModel(int id, String name, String tags, String level) {
        this.id = id;
        this.name = name;
        this.tags = tags;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "TumblrModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags='" + tags + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
