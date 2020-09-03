package com.yidu.inventoryManage.pojo;

/**
 * @name 戴言露
 * @data 2020/9/1 am
 * 证券应收应付库存表
 */

public class SecuritiesClosedPayInventory {
    private String nsrcsId;         //证券存库Id 主键
    private String datetime;        //业务日期
    private String fundId;          //基金信息表Id
    private int securitiesId;       //证券信息表ID
    private int securitiesType;     //证券应收应付类型 1=估值款 2=证券清算款 3=债券利息
    private int flag;               //业务日期
    private double tootaIPrice;     //总金额
    private String desc;            //备注
    private int securityPeriodFlag; //期初标志 是否从其他系统导入得期初数据 0：不是 1：是
    public SecuritiesClosedPayInventory(){}

    public SecuritiesClosedPayInventory(String nsrcsId, String datetime, String fundId, int securitiesId, int securitiesType, int flag, double tootaIPrice, String desc, int securityPeriodFlag) {
        this.nsrcsId = nsrcsId;
        this.datetime = datetime;
        this.fundId = fundId;
        this.securitiesId = securitiesId;
        this.securitiesType = securitiesType;
        this.flag = flag;
        this.tootaIPrice = tootaIPrice;
        this.desc = desc;
        this.securityPeriodFlag = securityPeriodFlag;
    }

    public String getNsrcsId() {
        return nsrcsId;
    }

    public void setNsrcsId(String nsrcsId) {
        this.nsrcsId = nsrcsId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public int getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(int securitiesId) {
        this.securitiesId = securitiesId;
    }

    public int getSecuritiesType() {
        return securitiesType;
    }

    public void setSecuritiesType(int securitiesType) {
        this.securitiesType = securitiesType;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public double getTootaIPrice() {
        return tootaIPrice;
    }

    public void setTootaIPrice(double tootaIPrice) {
        this.tootaIPrice = tootaIPrice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSecurityPeriodFlag() {
        return securityPeriodFlag;
    }

    public void setSecurityPeriodFlag(int securityPeriodFlag) {
        this.securityPeriodFlag = securityPeriodFlag;
    }

    @Override
    public String toString() {
        return "SecuritiesClosedPayInventory{" +
                "nsrcsId='" + nsrcsId + '\'' +
                ", datetime='" + datetime + '\'' +
                ", fundId='" + fundId + '\'' +
                ", securitiesId=" + securitiesId +
                ", securitiesType=" + securitiesType +
                ", flag=" + flag +
                ", tootaIPrice=" + tootaIPrice +
                ", desc='" + desc + '\'' +
                ", securityPeriodFlag=" + securityPeriodFlag +
                '}';
    }
}
