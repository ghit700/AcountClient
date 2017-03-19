package com.nan.acountclient.entity;



import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by wzn on 2017/1/5.
 */
public class User extends RealmObject {
    @PrimaryKey
    private Integer id;
    /**
     * 账号
     */
    private String loginName;
    /**
     * 名字
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 账号头像
     */
    private String accountImg;
    private String createdAt;
    private String objectId;
    private String updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
