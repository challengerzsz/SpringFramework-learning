package com.bsb.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    //Account的类型
    private int id;
    private String userName;
    private String password;
    private int userType;
    private String email;
    private String phone;
    private String question;
    private String answer;
    private Date create_time;
    private Date update_time;

    public User() { }

    public User(Integer id, String userName, String password, Integer userType, String email, String phone, String question, String answer, Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.email = email;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.create_time = create_time;
        this.update_time = update_time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}