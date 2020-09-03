package com.yidu.businessData.pojo;

/**
 * @ClassName CashClosePayPojo
 * @Description: TODO
 * @Author 硠君
 * @Date create in 10:04 2020/9/1
 * @Version 1.0
 **/
public class CashClosePayPojo {
    private String cashClosedPayId;     //现金应收应付
    private String fundId;              //基金信息表Id  fund表
    private String accountId;           //账户信息表ID  account表
    private String securitiesId;        //证券信息表ID  securities表
    private int serviceType;            //业务类型 1=“管理费”2=“托管费”3=“存款利息”4=“申购赎回款"        **
    private double amount;              //金额                                                    **
    private String dateTime;            //日期                                                    **
    private int flag;                   //资金流向 1=“流入”-1 =“流出”                               **

    public CashClosePayPojo(){}
    public CashClosePayPojo(String cashClosedPayId, String fundId, String accountId, String securitiesId,
                            int serviceType, double amount, String dateTime, int flag) {
        this.cashClosedPayId = cashClosedPayId;
        this.fundId = fundId;
        this.accountId = accountId;
        this.securitiesId = securitiesId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.flag = flag;
    }

    public String getCashClosedPayId() {
        return cashClosedPayId;
    }
    public void setCashClosedPayId(String cashClosedPayId) {
        this.cashClosedPayId = cashClosedPayId;
    }

    public String getFundId() {
        return fundId;
    }
    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }
    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public int getServiceType() {
        return serviceType;
    }
    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "CashClosePayPojo{" +
                "cashClosedPayId='" + cashClosedPayId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", serviceType=" + serviceType +
                ", amount=" + amount +
                ", dateTime='" + dateTime + '\'' +
                ", flag=" + flag +
                '}';
    }
}
