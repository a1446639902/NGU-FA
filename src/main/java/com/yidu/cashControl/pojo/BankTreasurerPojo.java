package com.yidu.cashControl.pojo;

/**
 * 资金调拨表
 * @Type 实体类
 * @author 黄志豪
 * @version 1.0
 * @time 2020/9/4
 **/
public class BankTreasurerPojo {
    private String bankTreasurerId;             //资金调拨表Id
    private String fundId;                      //基金编号
    private double totalPrice;                  //调拨总数额
    private String accountId;                   //FK 现金账户表Id  account表
    private String accountName;                 //现金账户名称
    private int flag;                           //调拨方向 1代表流入 -1代表流出
    private String dbTime;                      //调拨日期
    private String dateTime;                    //业务日期
    private String businessId;                  //业务标号
    private int allocatingType;                 //调拨类型 1代表存款利息 2代表申购赎回清算款 3代表买卖交易清算款 4代表债券利息 5存款业务 6两费
    private String bankTreasurerDesc;           //备注

    public BankTreasurerPojo() {
    }

    public BankTreasurerPojo(String bankTreasurerId, String fundId, double totalPrice, String accountId, int flag, String dbTime, String dateTime, String businessId, int allocatingType, String bankTreasurerDesc) {
        this.bankTreasurerId = bankTreasurerId;
        this.fundId = fundId;
        this.totalPrice = totalPrice;
        this.accountId = accountId;
        this.flag = flag;
        this.dbTime = dbTime;
        this.dateTime = dateTime;
        this.businessId = businessId;
        this.allocatingType = allocatingType;
        this.bankTreasurerDesc = bankTreasurerDesc;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankTreasurerId() {
        return bankTreasurerId;
    }

    public void setBankTreasurerId(String bankTreasurerId) {
        this.bankTreasurerId = bankTreasurerId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getDbTime() {
        return dbTime;
    }

    public void setDbTime(String dbTime) {
        this.dbTime = dbTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public int getAllocatingType() {
        return allocatingType;
    }

    public void setAllocatingType(int allocatingType) {
        this.allocatingType = allocatingType;
    }

    public String getBankTreasurerDesc() {
        return bankTreasurerDesc;
    }

    public void setBankTreasurerDesc(String bankTreasurerDesc) {
        this.bankTreasurerDesc = bankTreasurerDesc;
    }

    @Override
    public String toString() {
        return "BankTreasurerPojo{" +
                "bankTreasurerId='" + bankTreasurerId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", totalPrice=" + totalPrice +
                ", accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", flag=" + flag +
                ", dbTime='" + dbTime + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", businessId='" + businessId + '\'' +
                ", allocatingType=" + allocatingType +
                ", bankTreasurerDesc='" + bankTreasurerDesc + '\'' +
                '}';
    }
}
