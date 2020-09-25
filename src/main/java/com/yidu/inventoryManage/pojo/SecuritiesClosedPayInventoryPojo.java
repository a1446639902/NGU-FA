package com.yidu.inventoryManage.pojo;

/**
 * 证券应收应付库存
 * @author 戴言露
 * @version 1.0
 * @Type 实体类
 * @time 2020/9/13
 **/
public class SecuritiesClosedPayInventoryPojo {
    private String securitiesClosedPayInventoryId;  //证券存库Id 主键
    private String dateTime;                        //业务日期
    private String fundId;                          //FK 基金信息表Id      fund表
    private String securitiesId;                    //FK 证券信息表ID  securities表--
    private String securitiesName;                  // 证券名称
    private int securitiesType;                     //证券应收应付类型 1=估值款 2=证券清算款 3=债券利息
    private int flag;                               //业务状态 1流入，-1流出--
    private double totalPrice;                      //总金额
    private String securitiesClosedPayDesc;         //备注
    private int securityPeriodFlag;                 //期初标志 是否从其他系统导入得期初数据 0：不是 1：是

    public SecuritiesClosedPayInventoryPojo() {
    }

    public SecuritiesClosedPayInventoryPojo(String securitiesClosedPayInventoryId, String dateTime, String fundId, String securitiesId, String securitiesName, int securitiesType, int flag, double totalPrice, String securitiesClosedPayDesc, int securityPeriodFlag) {
        this.securitiesClosedPayInventoryId = securitiesClosedPayInventoryId;
        this.dateTime = dateTime;
        this.fundId = fundId;
        this.securitiesId = securitiesId;
        this.securitiesName = securitiesName;
        this.securitiesType = securitiesType;
        this.flag = flag;
        this.totalPrice = totalPrice;
        this.securitiesClosedPayDesc = securitiesClosedPayDesc;
        this.securityPeriodFlag = securityPeriodFlag;
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

    public String getSecuritiesName() {
        return securitiesName;
    }

    public void setSecuritiesName(String securitiesName) {
        this.securitiesName = securitiesName;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
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

    @Override
    public String toString() {
        return "securitiesClosedPayInventoryPojo{" +
                "securitiesClosedPayInventoryId='" + securitiesClosedPayInventoryId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", fundId='" + fundId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", securitiesType=" + securitiesType +
                ", flag=" + flag +
                ", totalPrice=" + totalPrice +
                ", securitiesClosedPayDesc='" + securitiesClosedPayDesc + '\'' +
                ", securityPeriodFlag=" + securityPeriodFlag +
                '}';
    }
}
