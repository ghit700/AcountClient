package com.nan.acountclient.entity;

import com.nan.acountclient.components.db.annotation.Column;
import com.nan.acountclient.components.db.annotation.Table;

/**
 * Created by wzn on 2017/1/5.
 */
@Table("user")
public class User {
    @Column("id")
    private long id;
    /**
     * 账号
     */
    @Column("login_name")
    private String loginName;
    /**
     * 名字
     */
    @Column("name")
    private String name;
    /**
     * 密码
     */
    @Column("password")
    private String password;
    /**
     * 邮箱
     */
    @Column("mail")
    private String mail;
    /**
     * 账号头像
     */
    @Column("account_img")
    private String accountImg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getAccountImg() {
        return accountImg;
    }

    public void setAccountImg(String accountImg) {
        this.accountImg = accountImg;
    }
}