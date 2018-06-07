package com.reco.cn.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public class OwnerDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //壶ID
    private Integer potId;
    //壶主ID
    private Integer ownerId;
    //壶主姓名
    private String ownerName;
    //价格
    private Float price;
    //已取
    private Boolean taken;
    //订单ID
    private Integer orderId;
    //更新日期
    private Date updateDate;

    public Integer getPot_id() {
        return potId;
    }

    public void setPot_id(Integer pot_id) {
        this.potId = pot_id;
    }

    public Integer getOwner_id() {
        return ownerId;
    }

    public void setOwner_id(Integer owner_id) {
        this.ownerId = owner_id;
    }

    public String getOwner_name() {
        return ownerName;
    }

    public void setOwner_name(String owner_name) {
        this.ownerName = owner_name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    public Integer getOrder_id() {
        return orderId;
    }

    public void setOrder_id(Integer order_id) {
        this.orderId = order_id;
    }

    public Date getUpdate_date() {
        return updateDate;
    }

    public void setUpdate_date(Date update_date) {
        this.updateDate = update_date;
    }
}
