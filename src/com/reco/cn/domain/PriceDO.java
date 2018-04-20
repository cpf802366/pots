package com.reco.cn.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public class PriceDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //价格ID
    private Integer priceId;
    //款式ID
    private Integer designId;
    //价格
    private Float price;
    //更新时间
    private Date updateDate;
    //更新说明
    private String updateBy;

    /**
     * 设置：价格ID
     */
    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    /**
     * 获取：价格ID
     */
    public Integer getPriceId() {
        return priceId;
    }

    /**
     * 设置：款式ID
     */
    public void setDesignId(Integer designId) {
        this.designId = designId;
    }

    /**
     * 获取：款式ID
     */
    public Integer getDesignId() {
        return designId;
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
     * 设置：更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置：更新说明
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取：更新说明
     */
    public String getUpdateBy() {
        return updateBy;
    }
}
