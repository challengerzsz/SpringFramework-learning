package com.bsb.pojo;

import java.util.Date;

public class User {
    //Account的类型
    private int id;
    private String adminName;
    private String password;
    private Integer userType;
    private String email;
    private String phone;
    private String question;
    private String answer;
    private Date createTime;
    private Date update_time;

    public User(int id, String adminName, String password, Integer userType, String email, String phone, String question, String answer, Date createTime, Date update_time) {
        this.id = id;
        this.adminName = adminName;
        this.password = password;
        this.userType = userType;
        this.email = email;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.createTime = createTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}