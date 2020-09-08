package com.yidu.inventoryManage.pojo;

/**
 * 现金库存,现金账户的实体类(多表关联查询)
 * @Mr.Zou
 * date：2020/9/5
 */
public class CashInventoryEntity {

    //现金库存表
    private String cashInventoryId;//现金库存id
    private String fundId;//基金id 来自基金表
    private double cashBlance;//现金余额
    private String accountId;//现金账户id  来自现金账户
    private String dateTime;//统计日期
    private double securitiesNum;//证券数量
    private double securityPeriodFlag;//期初数据
    private String cashInventoryDesc;//备注



    //现金账户
    private String blankCardCode;//账户卡号
    private String accountName;//账户名称

    public CashInventoryEntity() {
    }

    public CashInventoryEntity(String cashInventoryId, String fundId, double cashBlance, String accountId, String dateTime, double securitiesNum, double securityPeriodFlag, String cashInventoryDesc, String blankCardCode, String accountName) {
        this.cashInventoryId = cashInventoryId;
        this.fundId = fundId;
        this.cashBlance = cashBlance;
        this.accountId = accountId;
        this.dateTime = dateTime;
        this.securitiesNum = securitiesNum;
        this.securityPeriodFlag = securityPeriodFlag;
        this.cashInventoryDesc = cashInventoryDesc;
        this.blankCardCode = blankCardCode;
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "CashInventoryEntity{" +
                "cashInventoryId='" + cashInventoryId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", cashBlance=" + cashBlance +
                ", accountId='" + accountId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", securitiesNum=" + securitiesNum +
                ", securityPeriodFlag=" + securityPeriodFlag +
                ", cashInventoryDesc='" + cashInventoryDesc + '\'' +
                ", blankCardCode='" + blankCardCode + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    public String getCashInventoryId() {
        return cashInventoryId;
    }

    public void setCashInventoryId(String cashInventoryId) {
        this.cashInventoryId = cashInventoryId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public double getCashBlance() {
        return cashBlance;
    }

    public void setCashBlance(double cashBlance) {
        this.cashBlance = cashBlance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getSecuritiesNum() {
        return securitiesNum;
    }

    public void setSecuritiesNum(double securitiesNum) {
        this.securitiesNum = securitiesNum;
    }

    public double getSecurityPeriodFlag() {
        return securityPeriodFlag;
    }

    public void setSecurityPeriodFlag(double securityPeriodFlag) {
        this.securityPeriodFlag = securityPeriodFlag;
    }

    public String getCashInventoryDesc() {
        return cashInventoryDesc;
    }

    public void setCashInventoryDesc(String cashInventoryDesc) {
        this.cashInventoryDesc = cashInventoryDesc;
    }

    public String getBlankCardCode() {
        return blankCardCode;
    }

    public void setBlankCardCode(String blankCardCode) {
        this.blankCardCode = blankCardCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
