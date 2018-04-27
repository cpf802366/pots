package com.reco.cn.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-25 22:49:24
 */
public class PriceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//价格ID
	private Integer priceid;
	//款式ID
	private Integer designid;
	//价格
	private Float price;
	//更新时间
	private Date updatedate;
	//更新类型，采购/调价
	private String updatetype;
	//更新信息，采购时放采购单ID
	private String updateinfo;

	/**
	 * 设置：价格ID
	 */
	public void setPriceid(Integer priceid) {
		this.priceid = priceid;
	}
	/**
	 * 获取：价格ID
	 */
	public Integer getPriceid() {
		return priceid;
	}
	/**
	 * 设置：款式ID
	 */
	public void setDesignid(Integer designid) {
		this.designid = designid;
	}
	/**
	 * 获取：款式ID
	 */
	public Integer getDesignid() {
		return designid;
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
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：更新类型，采购/调价
	 */
	public void setUpdatetype(String updatetype) {
		this.updatetype = updatetype;
	}
	/**
	 * 获取：更新类型，采购/调价
	 */
	public String getUpdatetype() {
		return updatetype;
	}
	/**
	 * 设置：更新信息，采购时放采购单ID
	 */
	public void setUpdateinfo(String updateinfo) {
		this.updateinfo = updateinfo;
	}
	/**
	 * 获取：更新信息，采购时放采购单ID
	 */
	public String getUpdateinfo() {
		return updateinfo;
	}
}
