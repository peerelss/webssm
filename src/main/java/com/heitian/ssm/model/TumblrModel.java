package com.heitian.ssm.model;

/**
 * Created by root on 17-3-6.
 */
public class TumblrModel {
    private Long id;
    private String name;
    private String tags;
    private String level;
    public TumblrModel(){

    }
    public TumblrModel(String name, String tags, String level) {
        this.name = name;
        this.tags = tags;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
