package com.heitian.ssm.model;

import java.util.Date;

/**
 * Created by root on 17-3-22.
 */
public class Tag {
    private int id;
    private String tag;
    private int times;
    private Date recentDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Date getRecentDate() {
        return recentDate;
    }

    public void setRecentDate(Date recentDate) {
        this.recentDate = recentDate;
    }
}
