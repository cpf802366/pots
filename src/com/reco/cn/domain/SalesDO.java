package com.reco.cn.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public class SalesDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //销售订单ID
    private Integer soId;
    //销售单号
    private String soNo;
    //卖家ID
    private Integer sellerId;
    //
    private Integer potId;
    //
    private Integer designId;
    //上架时间
    private Date sellDttm;
    //价格
    private Float price;
    //转让方式
    private Integer sellMode;
    //成交时间
    private Date completeDttm;
    //采购单ID，多个，拼接
    private String poIds;

    /**
     * 设置：销售订单ID
     */
    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    /**
     * 获取：销售订单ID
     */
    public Integer getSoId() {
        return soId;
    }

    /**
     * 设置：销售单号
     */
    public void setSoNo(String soNo) {
        this.soNo = soNo;
    }

    /**
     * 获取：销售单号
     */
    public String getSoNo() {
        return soNo;
    }

    /**
     * 设置：卖家ID
     */
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取：卖家ID
     */
    public Integer getSellerId() {
        return sellerId;
    }

    /**
     * 设置：
     */
    public void setPotId(Integer potId) {
        this.potId = potId;
    }

    /**
     * 获取：
     */
    public Integer getPotId() {
        return potId;
    }

    /**
     * 设置：
     */
    public void setDesignId(Integer designId) {
        this.designId = designId;
    }

    /**
     * 获取：
     */
    public Integer getDesignId() {
        return designId;
    }

    /**
     * 设置：上架时间
     */
    public void setSellDttm(Date sellDttm) {
        this.sellDttm = sellDttm;
    }

    /**
     * 获取：上架时间
     */
    public Date getSellDttm() {
        return sellDttm;
    }

    /**
     * 设置：价格
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * 获取：价格
     */
    public Float getPrice() {
        return price;
    }

    /**
     * 设置：转让方式
     */
    public void setSellMode(Integer sellMode) {
        this.sellMode = sellMode;
    }

    /**
     * 获取：转让方式
     */
    public Integer getSellMode() {
        return sellMode;
    }

    /**
     * 设置：成交时间
     */
    public void setCompleteDttm(Date completeDttm) {
        this.completeDttm = completeDttm;
    }

    /**
     * 获取：成交时间
     */
    public Date getCompleteDttm() {
        return completeDttm;
    }

    /**
     * 设置：采购单ID，多个，拼接
     */
    public void setPoIds(String poIds) {
        this.poIds = poIds;
    }

    /**
     * 获取：采购单ID，多个，拼接
     */
    public String getPoIds() {
        return poIds;
    }
}
