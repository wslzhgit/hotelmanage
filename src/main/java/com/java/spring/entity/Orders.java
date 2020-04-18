package com.java.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Orders {
    /** 主键 */
    private Integer id;

    /** 订单编号 */
    private String orderNum;

    /** 订单总价 */
    private Double orderMoney;

    /** 订单备注 */
    private String remark;

    /** 0未结算，1已结算 */
    private String orderStatus;

    /** 入住信息主键 */
    private Integer iriId;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createDate;

    /** 1显示，0隐藏 */
    private String flag;

    /** 退房时的客人信息时间等等 */
    private String orderOther;

    /** 退房时的各种金额 */
    private String orderPrice;

    //入住信息对象
    private InRoomInfo inRoomInfo;

    //进行订单日期范围查询的属性(不映射到数据库)
    //开始时间
    private Date beginDate;
    //结束时间
    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Integer getIriId() {
        return iriId;
    }

    public void setIriId(Integer iriId) {
        this.iriId = iriId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getOrderOther() {
        return orderOther;
    }

    public void setOrderOther(String orderOther) {
        this.orderOther = orderOther == null ? null : orderOther.trim();
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice == null ? null : orderPrice.trim();
    }

    public InRoomInfo getInRoomInfo() { return inRoomInfo; }

    public void setInRoomInfo(InRoomInfo inRoomInfo) {
        this.inRoomInfo = inRoomInfo;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date begingDate) {
        this.beginDate = begingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}