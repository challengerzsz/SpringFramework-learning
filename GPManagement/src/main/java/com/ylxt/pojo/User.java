package com.ylxt.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class User {

    private Integer id;
    private String number;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer type;
    private Date create_time;
    private Date update_time;

    public User(Integer id, String number, String username, String password, String phone, String email, Integer type, Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.number = number;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(Integer type) {
        this.type = type;
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
