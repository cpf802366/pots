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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    public String getSoNo() {
        return soNo;
    }

    public void setSoNo(String soNo) {
        this.soNo = soNo;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getPotId() {
        return potId;
    }

    public void setPotId(Integer potId) {
        this.potId = potId;
    }

    public Integer getDesignId() {
        return designId;
    }

    public void setDesignId(Integer designId) {
        this.designId = designId;
    }

    public Date getSellDttm() {
        return sellDttm;
    }

    public void setSellDttm(Date sellDttm) {
        this.sellDttm = sellDttm;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSellMode() {
        return sellMode;
    }

    public void setSellMode(Integer sellMode) {
        this.sellMode = sellMode;
    }

    public Date getCompleteDttm() {
        return completeDttm;
    }

    public void setCompleteDttm(Date completeDttm) {
        this.completeDttm = completeDttm;
    }

    public String getPoIds() {

        return poIds;
    }

    public void setPoIds(String poIds) {
        this.poIds = poIds;
    }

    //采购单ID，多个，拼接
    private String poIds;


}
