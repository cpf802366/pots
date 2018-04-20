package com.reco.cn.domain;

import java.io.Serializable;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */
public class MemDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private String address;
    //
    private String brithday;
    //
    private String email;
    //
    private Integer fuage;
    //
    private String idcard;
    //
    private String img;
    //
    private String name;
    //
    private String nickname;
    //
    private String password;
    //
    private String phone;
    //
    private String postcode;
    //
    private String qq;
    //
    private Integer sex;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：
     */
    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    /**
     * 获取：
     */
    public String getBrithday() {
        return brithday;
    }

    /**
     * 设置：
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：
     */
    public void setFuage(Integer fuage) {
        this.fuage = fuage;
    }

    /**
     * 获取：
     */
    public Integer getFuage() {
        return fuage;
    }

    /**
     * 设置：
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取：
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置：
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取：
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取：
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置：
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * 获取：
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置：
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取：
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置：
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取：
     */
    public Integer getSex() {
        return sex;
    }
}
