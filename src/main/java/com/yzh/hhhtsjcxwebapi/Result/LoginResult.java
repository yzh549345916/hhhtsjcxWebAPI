package com.yzh.hhhtsjcxwebapi.Result;

public class LoginResult {
    //响应码
    private int code;
    private String adminCode;

    public String getAdminCode() {
        return adminCode;
    }

    public LoginResult(int code, String adminCode) {
        this.code = code;
        this.adminCode = adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public LoginResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
