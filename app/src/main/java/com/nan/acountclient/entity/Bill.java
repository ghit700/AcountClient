package com.nan.acountclient.entity;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 账单
 * Created by wzn on 2017/3/12.
 */

public class Bill extends RealmObject {
    @PrimaryKey
    private Integer id;
    /**
     * 备注
     */
    private String remark;
    /**
     * 标签id
     */
    private int tagId;
    /**
     * 金额
     */
    private double money;
    /**
     * 图片
     */
    private String imgUrl;
    /**
     * 创建者
     */
    private int creator;
    /**
     * 类型（0支出，1收入）
     */
    private int type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
