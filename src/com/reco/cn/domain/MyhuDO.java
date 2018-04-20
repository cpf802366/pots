package com.reco.cn.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author toy
 * @email t_oy@sohu.com
 * @date 2018-04-20 05:00:00
 */
public class MyhuDO implements Serializable {
    public Integer getDesign_Id() {
        return design_Id;
    }

    public void setDesign_Id(Integer design_Id) {
        this.design_Id = design_Id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getArt_Id() {
        return art_Id;
    }

    public void setArt_Id(Integer art_Id) {
        this.art_Id = art_Id;
    }

    public String getDesign_name() {
        return design_name;
    }

    public void setDesign_name(String design_name) {
        this.design_name = design_name;
    }

    public String getDesign_img() {
        return design_img;
    }

    public void setDesign_img(String design_img) {
        this.design_img = design_img;
    }

    public Integer getPot_id() {
        return pot_id;
    }

    public void setPot_id(Integer pot_id) {
        this.pot_id = pot_id;
    }

    public String getJdzh() {
        return jdzh;
    }

    public void setJdzh(String jdzh) {
        this.jdzh = jdzh;
    }

    public String getPo_no() {
        return po_no;
    }

    public void setPo_no(String po_no) {
        this.po_no = po_no;
    }

    public String getPo_dttm_str() {
        return po_dttm_str;
    }

    public void setPo_dttm_str(String po_dttm_str) {
        this.po_dttm_str = po_dttm_str;
    }

    public String getPo_price_str() {
        return po_price_str;
    }

    public void setPo_price_str(String po_price_str) {
        this.po_price_str = po_price_str;
    }

    public Boolean getTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    private static final long serialVersionUID = 1L;

    //款式ID
    private Integer design_Id;
    //作者
    private String author;
    //作者ID
    private Integer art_Id;
    //作品名称
    private String design_name;
    //图片URL
    private String design_img;
    //壶ID
    private Integer pot_id;
    //鉴定证号
    private String jdzh;
    //订单号
    private String po_no;
    //购买时间
    private String po_dttm_str;
    //购买价格
    private String po_price_str;
    //已提货
    private Boolean taken;
    private List<MyhuHisDO> hisDOList;

    public List<MyhuHisDO> getHisDOList() {
        return hisDOList;
    }

    public void setHisDOList(List<MyhuHisDO> hisDOList) {
        this.hisDOList = hisDOList;
    }
}
