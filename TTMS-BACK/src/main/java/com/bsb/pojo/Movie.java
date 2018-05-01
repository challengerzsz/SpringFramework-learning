package com.bsb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Timestamp;
import java.util.Date;

@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class Movie {

    private int id;
    private String name;
    private String type;
    private String lang;
    private String comment;
    private String image;
    private String duration;
    private double price;
    private int status;
    @JsonIgnore
    private Date create_time;
    @JsonIgnore
    private Date update_time;

    public Movie() {}

    public Movie(Integer id, String name, String type, String lang, String comment, String image, String duration, Double price, Integer status, Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.lang = lang;
        this.comment = comment;
        this.image = image;
        this.duration = duration;
        this.price = price;
        this.status = status;
        this.create_time = create_time;
        this.update_time = update_time;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
