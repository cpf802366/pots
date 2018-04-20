package com.reco.cn.domain;

import java.io.Serializable;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */
public class MemAddrDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private String area;
    //
    private String city;
    //
    private Integer defaultdz;
    //
    private String idcard;
    //
    private String jddz;
    //
    private String name;
    //
    private String phone;
    //
    private String postcode;
    //
    private String province;
    //
    private Integer userid;

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
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取：
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置：
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取：
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置：
     */
    public void setDefaultdz(Integer defaultdz) {
        this.defaultdz = defaultdz;
    }

    /**
     * 获取：
     */
    public Integer getDefaultdz() {
        return defaultdz;
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
    public void setJddz(String jddz) {
        this.jddz = jddz;
    }

    /**
     * 获取：
     */
    public String getJddz() {
        return jddz;
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
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取：
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置：
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取：
     */
    public Integer getUserid() {
        return userid;
    }
}
