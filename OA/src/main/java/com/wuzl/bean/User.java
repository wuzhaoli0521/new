package com.wuzl.bean;

import java.sql.Timestamp;

public class User {
    private int id;
    private String workid;
    private String name;
    private int age;
    private String sex;
    private Timestamp birthdays;
    private String phone;
    private String email;
    private String home;
    private Timestamp jointime;

    public User(String workid, String name, int age, String sex, Timestamp birthdays, String phone, String email, String home, Timestamp jointime) {
        this.workid = workid;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthdays = birthdays;
        this.phone = phone;
        this.email = email;
        this.home = home;
        this.jointime = jointime;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
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

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Timestamp getJointime() {
        return jointime;
    }

    public void setJointime(Timestamp jointime) {
        this.jointime = jointime;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getBirthdays() {
        return birthdays;
    }

    public void setBirthdays(Timestamp birthdays) {
        this.birthdays = birthdays;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthdays='" + birthdays + '\'' +
                '}';
    }
}
