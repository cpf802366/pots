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
    private Integer pot_id;
    //壶主ID
    private Integer owner_id;
    //壶主姓名
    private String owner_name;
    //价格
    private Float price;
    //已取
    private Boolean taken;
    //订单ID
    private Integer order_id;
    //更新日期
    private Date update_date;

    public Integer getPot_id() {
        return pot_id;
    }

    public void setPot_id(Integer pot_id) {
        this.pot_id = pot_id;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
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
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }
}
