package com.reco.cn.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */
public class ArtDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //姓名
    private String name;
    //
    private String idcard;
    //头像
    private String img;
    //简介
    private String resume;
    //代表作
    private String works;
    //籍贯
    private String origin;
    //联系电话
    private String phone;
    //职称
    private String title;
    //发证机构
    private String title_By;
    //职称证书编号
    private String titleNo;
    //职称更新日期
    private Date titleUpdate;
    //
    private Boolean zhuanli;
    //
    private Boolean banquan;
    //
    private Boolean cxsj;
    //
    private Boolean mingjia;
    //是否专家
    private Boolean isExp;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取：
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置：头像
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取：头像
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置：简介
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * 获取：简介
     */
    public String getResume() {
        return resume;
    }

    /**
     * 设置：代表作
     */
    public void setWorks(String works) {
        this.works = works;
    }

    /**
     * 获取：代表作
     */
    public String getWorks() {
        return works;
    }

    /**
     * 设置：籍贯
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 获取：籍贯
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 设置：联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：职称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：职称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置：发证机构
     */
    public void setTitle_By(String title_By) {
        this.title_By = title_By;
    }

    /**
     * 获取：发证机构
     */
    public String getTitle_By() {
        return title_By;
    }

    /**
     * 设置：职称证书编号
     */
    public void setTitleNo(String titleNo) {
        this.titleNo = titleNo;
    }

    /**
     * 获取：职称证书编号
     */
    public String getTitleNo() {
        return titleNo;
    }

    /**
     * 设置：职称更新日期
     */
    public void setTitleUpdate(Date titleUpdate) {
        this.titleUpdate = titleUpdate;
    }

    /**
     * 获取：职称更新日期
     */
    public Date getTitleUpdate() {
        return titleUpdate;
    }

    /**
     * 设置：
     */
    public void setZhuanli(Boolean zhuanli) {
        this.zhuanli = zhuanli;
    }

    /**
     * 获取：
     */
    public Boolean getZhuanli() {
        return zhuanli;
    }

    /**
     * 设置：
     */
    public void setBanquan(Boolean banquan) {
        this.banquan = banquan;
    }

    /**
     * 获取：
     */
    public Boolean getBanquan() {
        return banquan;
    }

    /**
     * 设置：
     */
    public void setCxsj(Boolean cxsj) {
        this.cxsj = cxsj;
    }

    /**
     * 获取：
     */
    public Boolean getCxsj() {
        return cxsj;
    }

    /**
     * 设置：
     */
    public void setMingjia(Boolean mingjia) {
        this.mingjia = mingjia;
    }

    /**
     * 获取：
     */
    public Boolean getMingjia() {
        return mingjia;
    }

    /**
     * 设置：是否专家
     */
    public void setIsExp(Boolean isExp) {
        this.isExp = isExp;
    }

    /**
     * 获取：是否专家
     */
    public Boolean getIsExp() {
        return isExp;
    }
}
