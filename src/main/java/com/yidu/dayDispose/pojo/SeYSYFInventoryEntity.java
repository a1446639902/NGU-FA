package com.yidu.dayDispose.pojo;

/**
 * 库存统计证券应收应付实体类
 * @Mr.Zou
 **/
public class SeYSYFInventoryEntity {

    //业务状态  1 流入 -1 流出
    private int flag;
    //总金额
    private double tocal;
    //期初标志 是否从其他系统导入得期初数据 0：不是 1：是
    private int securityPeriodFlag;
    //FK 基金信息表Id      fund表
    private String fundId;
    //FK 证券信息表ID  securities表
    private String securitiesId;


    public SeYSYFInventoryEntity() {
    }

    public SeYSYFInventoryEntity(int flag, double tocal, int securityPeriodFlag, String fundId, String securitiesId) {
        this.flag = flag;
        this.tocal = tocal;
        this.securityPeriodFlag = securityPeriodFlag;
        this.fundId = fundId;
        this.securitiesId = securitiesId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public double getTocal() {
        return tocal;
    }

    public void setTocal(double tocal) {
        this.tocal = tocal;
    }

    public int getSecurityPeriodFlag() {
        return securityPeriodFlag;
    }

    public void setSecurityPeriodFlag(int securityPeriodFlag) {
        this.securityPeriodFlag = securityPeriodFlag;
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

    @Override
    public String toString() {
        return "SeYSYFInventoryEntity{" +
                "flag=" + flag +
                ", tocal=" + tocal +
                ", securityPeriodFlag=" + securityPeriodFlag +
                ", fundId='" + fundId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                '}';
    }
}
