package com.yidu.inventoryManage.pojo;

/**
 *  证券应收应付的实体类
 * @Mr.Zou
 **/

public class SeInventoryPayEntity {

    //证券存库Id 主键
    private String securitiesClosedPayInventoryId;
    //业务日期
    private String dateTime;
    //FK 基金信息表Id      fund表
    private String fundId;

    //FK 证券信息表ID  securities表
    private String securitiesId;

    //证券应收应付类型 1=估值款 2=证券清算款 3=债券利息
    private double securitiesType;

    //业务状态 1流入，-1流出
    private double flag;


    //总金额

    private Double totalPrice;
    //备注
    private String securitiesClosedPayDesc;


    //期初标志 是否从其他系统导入得期初数据 0：不是 1：是

    private int securityPeriodFlag;

    public SeInventoryPayEntity() {
    }

    public SeInventoryPayEntity(String securitiesClosedPayInventoryId, String dateTime, String fundId, String securitiesId, double securitiesType, double flag, Double totalPrice, String securitiesClosedPayDesc, int securityPeriodFlag) {
        this.securitiesClosedPayInventoryId = securitiesClosedPayInventoryId;
        this.dateTime = dateTime;
        this.fundId = fundId;
        this.securitiesId = securitiesId;
        this.securitiesType = securitiesType;
        this.flag = flag;
        this.totalPrice = totalPrice;
        this.securitiesClosedPayDesc = securitiesClosedPayDesc;
        this.securityPeriodFlag = securityPeriodFlag;
    }

    @Override
    public String toString() {
        return "SeInventoryPayEntity{" +
                "securitiesClosedPayInventoryId='" + securitiesClosedPayInventoryId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", fundId='" + fundId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", securitiesType=" + securitiesType +
                ", flag=" + flag +
                ", totalPrice=" + totalPrice +
                ", securitiesClosedPayDesc='" + securitiesClosedPayDesc + '\'' +
                ", securityPeriodFlag=" + securityPeriodFlag +
                '}';
    }

    public String getSecuritiesClosedPayInventoryId() {
        return securitiesClosedPayInventoryId;
    }

    public void setSecuritiesClosedPayInventoryId(String securitiesClosedPayInventoryId) {
        this.securitiesClosedPayInventoryId = securitiesClosedPayInventoryId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public double getSecuritiesType() {
        return securitiesType;
    }

    public void setSecuritiesType(double securitiesType) {
        this.securitiesType = securitiesType;
    }

    public double getFlag() {
        return flag;
    }

    public void setFlag(double flag) {
        this.flag = flag;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSecuritiesClosedPayDesc() {
        return securitiesClosedPayDesc;
    }

    public void setSecuritiesClosedPayDesc(String securitiesClosedPayDesc) {
        this.securitiesClosedPayDesc = securitiesClosedPayDesc;
    }

    public int getSecurityPeriodFlag() {
        return securityPeriodFlag;
    }

    public void setSecurityPeriodFlag(int securityPeriodFlag) {
        this.securityPeriodFlag = securityPeriodFlag;
    }
}
