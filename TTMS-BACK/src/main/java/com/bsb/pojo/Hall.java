package com.bsb.pojo;

import java.util.Date;

public class Hall {
    private int id;
    private String hall_name;
    private String comment;
    private int seat_count;
    private int hall_row;
    private int hall_column;
    private int status;
    private String on_show_movie;
    private Date create_time;
    private Date update_time;

    public Hall() {
    }


    public Hall(int id, String hall_name, String comment, int seat_count, int hall_row, int hall_column, int status, String on_show_movie, Date create_time, Date update_time) {
        this.id = id;
        this.hall_name = hall_name;
        this.comment = comment;
        this.seat_count = seat_count;
        this.hall_row = hall_row;
        this.hall_column = hall_column;
        this.status = status;
        this.on_show_movie = on_show_movie;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHall_name() {
        return hall_name;
    }

    public void setHall_name(String hall_name) {
        this.hall_name = hall_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSeat_count() {
        return seat_count;
    }

    public void setSeat_count(int seat_count) {
        this.seat_count = seat_count;
    }

    public int getHall_row() {
        return hall_row;
    }

    public void setHall_row(int hall_row) {
        this.hall_row = hall_row;
    }

    public int getHall_column() {
        return hall_column;
    }

    public void setHall_column(int hall_column) {
        this.hall_column = hall_column;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOn_show_movie() {
        return on_show_movie;
    }

    public void setOn_show_movie(String on_show_movie) {
        this.on_show_movie = on_show_movie;
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
