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
    private Integer so_id;
    //销售单号
    private String so_no;
    //卖家ID
    private Integer seller_id;
    //
    private Integer pot_id;
    //
    private Integer design_id;
    //上架时间
    private Date sell_dttm;
    //价格
    private Float price;
    //转让方式
    private Integer sell_mode;
    //成交时间
    private Date complete_dttm;
    //采购单ID，多个，拼接
    private String po_ids;

    public Integer getSo_id() {
        return so_id;
    }

    public void setSo_id(Integer so_id) {
        this.so_id = so_id;
    }

    public String getSo_no() {
        return so_no;
    }

    public void setSo_no(String so_no) {
        this.so_no = so_no;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
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

    public Date getSell_dttm() {
        return sell_dttm;
    }

    public void setSell_dttm(Date sell_dttm) {
        this.sell_dttm = sell_dttm;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSell_mode() {
        return sell_mode;
    }

    public void setSell_mode(Integer sell_mode) {
        this.sell_mode = sell_mode;
    }

    public Date getComplete_dttm() {
        return complete_dttm;
    }

    public void setComplete_dttm(Date complete_dttm) {
        this.complete_dttm = complete_dttm;
    }

    public String getPo_ids() {
        return po_ids;
    }

    public void setPo_ids(String po_ids) {
        this.po_ids = po_ids;
    }
}
