package com.example.rapsk.jumpstart.Models;

/**
 * Created by cicct on 8/6/2016.
 */
public class Milestones {

    public int id;
    public String img_url;
    public String vid_url;
    public String desc;

    public Milestones(int id, String img_url, String vid_url, String desc) {
        this.id = id;
        this.img_url = img_url;
        this.vid_url = vid_url;
        this.desc = desc;
    }

    public Milestones() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getVid_url() {
        return vid_url;
    }

    public void setVid_url(String vid_url) {
        this.vid_url = vid_url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
