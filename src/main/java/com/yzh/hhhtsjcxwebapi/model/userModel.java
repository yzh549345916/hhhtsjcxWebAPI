package com.yzh.hhhtsjcxwebapi.model;

import java.util.Date;

public class userModel {
    private String userID;
    private String userName;
    private String userPassWord;
    private String Admin_Code;
    private String userIP;
    private Integer userLevel;
    private Integer userType;
    private Date ExpirationTime;
    public userModel() {
    }

    public userModel(String userID, String userName, String userPassWord, String admin_Code, String userIP, Integer userLevel, Integer userType, Date expirationTime) {
        this.userID = userID;
        this.userName = userName;
        this.userPassWord = userPassWord;
        Admin_Code = admin_Code;
        this.userIP = userIP;
        this.userLevel = userLevel;
        this.userType = userType;
        ExpirationTime = expirationTime;
    }

    public Date getExpirationTime() {
        return ExpirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        ExpirationTime = expirationTime;
    }

    public userModel(String userID, String userName, String userPassWord, String admin_Code, String userIP, Integer userLevel, Integer userType) {
        this.userID = userID;
        this.userName = userName;
        this.userPassWord = userPassWord;
        Admin_Code = admin_Code;
        this.userIP = userIP;
        this.userLevel = userLevel;
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getAdmin_Code() {
        return Admin_Code;
    }

    public void setAdmin_Code(String admin_Code) {
        Admin_Code = admin_Code;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
