package com.reco.cn.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public class PurchaseDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer po_id;
    //
    private String po_no;
    //壶ID
    private Integer pot_id;
    //款式ID
    private Integer design_id;
    //
    private Date po_dttm;
    //
    private Integer order_state;
    //
    private Integer seller_id;
    //
    private Integer buyer_id;
    //
    private String buyer_name;
    //
    private Float price;
    //
    private String delivery_addr;
    //
    private Boolean taken;
    //
    private String express_company;
    //
    private String express_no;
    //
    private String remark;
    //对应销售单ID，多个，拼接
    private String so_ids;

    public Integer getPo_id() {
        return po_id;
    }

    public void setPo_id(Integer po_id) {
        this.po_id = po_id;
    }

    public String getPo_no() {
        return po_no;
    }

    public void setPo_no(String po_no) {
        this.po_no = po_no;
    }

    public Integer getPot_id() {
        return pot_id;
    }

    public void setPot_id(Integer pot_id) {
        this.pot_id = pot_id;
    }

    public Integer getDesign_id() {
        return design_id;
    }

    public void setDesign_id(Integer design_id) {
        this.design_id = design_id;
    }

    public Date getPo_dttm() {
        return po_dttm;
    }

    public void setPo_dttm(Date po_dttm) {
        this.po_dttm = po_dttm;
    }

    public Integer getOrder_state() {
        return order_state;
    }

    public void setOrder_state(Integer order_state) {
        this.order_state = order_state;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDelivery_addr() {
        return delivery_addr;
    }

    public void setDelivery_addr(String delivery_addr) {
        this.delivery_addr = delivery_addr;
    }

    public Boolean getTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    public String getExpress_company() {
        return express_company;
    }

    public void setExpress_company(String express_company) {
        this.express_company = express_company;
    }

    public String getExpress_no() {
        return express_no;
    }

    public void setExpress_no(String express_no) {
        this.express_no = express_no;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSo_ids() {
        return so_ids;
    }

    public void setSo_ids(String so_ids) {
        this.so_ids = so_ids;
    }
}
