package com.kevin.mybatis.model;

import java.sql.Timestamp;

/**
 * Created by root on 17-3-23.
 */
public class TumblrTag {
    private int id;
    private String name;
    private int times;
    private Timestamp recentTime;

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

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Timestamp getRecentTime() {
        return recentTime;
    }

    public void setRecentTime(Timestamp recentTime) {
        this.recentTime = recentTime;
    }

    @Override
    public String toString() {
        return "TumblrTag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", times=" + times +
                ", recentTime=" + recentTime +
                '}';
    }
}
