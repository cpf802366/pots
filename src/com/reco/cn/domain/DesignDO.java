package com.reco.cn.domain;

import java.io.Serializable;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public class DesignDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //款式ID
    private Integer design_id;
    //作者
    private String author;
    //作者ID
    private Integer art_id;
    //作品名称
    private String name;
    //鉴定证号
    private String jdzh;
    //作品图片
    private String productimg;
    //
    private Boolean isdbz;
    //库存数量
    private Integer kucun;
    //泥料
    private String niliao;
    //当前价格
    private Float price;
    //容量
    private String rongliang;
    //
    private String xiangqing;
    //
    private String authorproductimage;
    //
    private String authoryz;
    //
    private String authorcr;
    //
    private String authorqm;
    //
    private String productsm;
    //
    private String authorzw;
    //
    private String cs;
    //
    private String fbimage;
    //
    private String fdimage;
    //
    private String fgimage;
    //
    private String finshdate;
    //
    private String flimage;
    //
    private String fsimage;
    //
    private String fzimage;
    //
    private String gg_h;
    //
    private String gg_kj;
    //
    private String gg_len;
    //
    private String gg_w;
    //
    private String gy;
    //
    private String pm;
    //
    private String zx;
    //
    private String sm360;
    //
    private Integer jiami;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDesign_id() {
        return design_id;
    }

    public void setDesign_id(Integer design_id) {
        this.design_id = design_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getArt_id() {
        return art_id;
    }

    public void setArt_id(Integer art_id) {
        this.art_id = art_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJdzh() {
        return jdzh;
    }

    public void setJdzh(String jdzh) {
        this.jdzh = jdzh;
    }

    public String getProductimg() {
        return productimg;
    }

    public void setProductimg(String productimg) {
        this.productimg = productimg;
    }

    public Boolean getIsdbz() {
        return isdbz;
    }

    public void setIsdbz(Boolean isdbz) {
        this.isdbz = isdbz;
    }

    public Integer getKucun() {
        return kucun;
    }

    public void setKucun(Integer kucun) {
        this.kucun = kucun;
    }

    public String getNiliao() {
        return niliao;
    }

    public void setNiliao(String niliao) {
        this.niliao = niliao;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getRongliang() {
        return rongliang;
    }

    public void setRongliang(String rongliang) {
        this.rongliang = rongliang;
    }

    public String getXiangqing() {
        return xiangqing;
    }

    public void setXiangqing(String xiangqing) {
        this.xiangqing = xiangqing;
    }

    public String getAuthorproductimage() {
        return authorproductimage;
    }

    public void setAuthorproductimage(String authorproductimage) {
        this.authorproductimage = authorproductimage;
    }

    public String getAuthoryz() {
        return authoryz;
    }

    public void setAuthoryz(String authoryz) {
        this.authoryz = authoryz;
    }

    public String getAuthorcr() {
        return authorcr;
    }

    public void setAuthorcr(String authorcr) {
        this.authorcr = authorcr;
    }

    public String getAuthorqm() {
        return authorqm;
    }

    public void setAuthorqm(String authorqm) {
        this.authorqm = authorqm;
    }

    public String getProductsm() {
        return productsm;
    }

    public void setProductsm(String productsm) {
        this.productsm = productsm;
    }

    public String getAuthorzw() {
        return authorzw;
    }

    public void setAuthorzw(String authorzw) {
        this.authorzw = authorzw;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public String getFbimage() {
        return fbimage;
    }

    public void setFbimage(String fbimage) {
        this.fbimage = fbimage;
    }

    public String getFdimage() {
        return fdimage;
    }

    public void setFdimage(String fdimage) {
        this.fdimage = fdimage;
    }

    public String getFgimage() {
        return fgimage;
    }

    public void setFgimage(String fgimage) {
        this.fgimage = fgimage;
    }

    public String getFinshdate() {
        return finshdate;
    }

    public void setFinshdate(String finshdate) {
        this.finshdate = finshdate;
    }

    public String getFlimage() {
        return flimage;
    }

    public void setFlimage(String flimage) {
        this.flimage = flimage;
    }

    public String getFsimage() {
        return fsimage;
    }

    public void setFsimage(String fsimage) {
        this.fsimage = fsimage;
    }

    public String getFzimage() {
        return fzimage;
    }

    public void setFzimage(String fzimage) {
        this.fzimage = fzimage;
    }

    public String getGg_h() {
        return gg_h;
    }

    public void setGg_h(String gg_h) {
        this.gg_h = gg_h;
    }

    public String getGg_kj() {
        return gg_kj;
    }

    public void setGg_kj(String gg_kj) {
        this.gg_kj = gg_kj;
    }

    public String getGg_len() {
        return gg_len;
    }

    public void setGg_len(String gg_len) {
        this.gg_len = gg_len;
    }

    public String getGg_w() {
        return gg_w;
    }

    public void setGg_w(String gg_w) {
        this.gg_w = gg_w;
    }

    public String getGy() {
        return gy;
    }

    public void setGy(String gy) {
        this.gy = gy;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getZx() {
        return zx;
    }

    public void setZx(String zx) {
        this.zx = zx;
    }

    public String getSm360() {
        return sm360;
    }

    public void setSm360(String sm360) {
        this.sm360 = sm360;
    }

    public Integer getJiami() {
        return jiami;
    }

    public void setJiami(Integer jiami) {
        this.jiami = jiami;
    }
}
