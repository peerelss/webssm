package com.heitian.ssm.model;

/**
 * Created by root on 17-3-23.
 */
public class TumblrDomain {
    private int id;
    private String name;
    private String tag;
    private int level;

    public TumblrDomain() {
    }

    public TumblrDomain(String name, String tag, int level) {
        this.name = name;
        this.tag = tag;
        this.level = level;
    }

    public TumblrDomain(int id, String name, String tag, int level) {
        this.id = id;
        this.name = name;
        this.tag = tag;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "TumblrDomain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", level=" + level +
                '}';
    }
}
