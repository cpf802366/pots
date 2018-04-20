package com.reco.cn.domain;

import java.io.Serializable;

/**
 * @author toy
 * @email t_oy@sohu.com
 * @date 2018-04-20 05:00:00
 */
public class MyhuHisDO implements Serializable {
    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
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

    private static final long serialVersionUID = 1L;

    /**
     * 持壶人
     */
    private String owner_name;
    /**
     * 持壶日期
     */
    private String po_dttm_str;
    /**
     * 价格，单位万元
     */
    private String po_price_str;
}