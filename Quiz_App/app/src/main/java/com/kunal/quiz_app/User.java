package com.kunal.quiz_app;

public class User {
    private String userId;
    private String userName;
    private String userLastName;
    private String userCourse;
    private String userModule;
    private String userPhoneNumber;

    public User(){

    }

    public User(String userId, String userName, String userLastName, String userCourse, String userModule, String userPhoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userCourse = userCourse;
        this.userModule = userModule;
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserCourse() {
        return userCourse;
    }

    public void setUserCourse(String userCourse) {
        this.userCourse = userCourse;
    }

    public String getUserModule() {
        return userModule;
    }

    public void setUserModule(String userModule) {
        this.userModule = userModule;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
}
