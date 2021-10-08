package com.yjl.mvc.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class President {

    // 字符串长度：[3,6]
    @Size(min = 3, max = 6)

    // 字符串必须满足Email格式
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "President{" +
                "email='" + email + '\'' +
                '}';
    }

    public President(String email) {
        this.email = email;
    }

    public President() {
    }
}
