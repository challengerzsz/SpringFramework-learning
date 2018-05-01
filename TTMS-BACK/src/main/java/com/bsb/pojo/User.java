package com.bsb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class User implements Serializable {
//    private static final long serialVersionUID = 6977402643848375753L;

    //Account的类型
    private int id;
    private String username;
    private String password;
    private int usertype;
    private String email;
    private String phone;
    private String question;
    private String answer;
    @JsonIgnore
    private Date create_time;
    @JsonIgnore
    private Date update_time;


    public User(Integer id, String username, String password, Integer usertype, String email, String phone, String question, String answer, Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.email = email;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public User() {

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

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
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
}
