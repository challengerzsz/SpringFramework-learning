package com.bsb.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Hall {
    private int id;
    private String hallName;
    private String comment;
    private int seatCount;
    private int status;
    private String onShowMovie;
    private Date createTime;
    private Date updateTime;

    public Hall() {
    }

    public Hall(Integer id, String hallName, String comment, Integer seatCount, Integer status, String onShowMovie, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.hallName = hallName;
        this.comment = comment;
        this.seatCount = seatCount;
        this.status = status;
        this.onShowMovie = onShowMovie;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOnShowMovie() {
        return onShowMovie;
    }

    public void setOnShowMovie(String onShowMovie) {
        this.onShowMovie = onShowMovie;
    }
}
