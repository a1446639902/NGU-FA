package com.yidu.dayDispose.pojo;

/**
 * Created with IntelliJ IDEA.
 * 收益支付实体类
 * @ClassName IncomePaymentPojo
 * @Description: TODO
 * @Author 硠君
 * @Date create in 8:52 2020/9/9
 * @Version 1.0
 **/
public class IncomePaymentPojo {
    private String cashClosedPayInventoryId;    //现金应收应付库存编号
    private int businessType;                   //业务类型
    private Double totalMoney;                  //总金额
    private int businessStatus;                 //业务状态
    private String businessDate;                //业务日期

    private int deposit;                        //存款类型  account表
    private String accountId;                   //现金账户  account表
    private String accountName;                 //现金账户名称    account表

    private String securitiesClosedPayInventoryId;   //证券存库Id
    private int securitiesType;                 //证券应收应付类型=3
/*    private String dateTime   ;                 //业务日期
    private Double totalPrice;                  //总金额
    private int flag;                           //业务状态*/
    private String securitiesId;                //证券编号
    private String securitiesName;              //证券名称

    public IncomePaymentPojo(){}
    //现金应收应付
    public IncomePaymentPojo(String cashClosedPayInventoryId, int businessType, Double totalMoney, int businessStatus,
                             String businessDate, int deposit, String accountId, String accountName) {
        this.cashClosedPayInventoryId = cashClosedPayInventoryId;
        this.businessType = businessType;
        this.totalMoney = totalMoney;
        this.businessStatus = businessStatus;
        this.businessDate = businessDate;
        this.deposit = deposit;
        this.accountId = accountId;
        this.accountName = accountName;
    }
    //证券应收应付
    public IncomePaymentPojo(Double totalMoney, int businessStatus, String businessDate, String accountId, String accountName,
                             String securitiesClosedPayInventoryId, int securitiesType, String securitiesId, String securitiesName) {
        this.totalMoney = totalMoney;
        this.businessStatus = businessStatus;
        this.businessDate = businessDate;
        this.accountId = accountId;
        this.accountName = accountName;
        this.securitiesClosedPayInventoryId = securitiesClosedPayInventoryId;
        this.securitiesType = securitiesType;
        this.securitiesId = securitiesId;
        this.securitiesName = securitiesName;
    }
    //两费
    public IncomePaymentPojo(String cashClosedPayInventoryId, int businessType, Double totalMoney, int businessStatus, String businessDate, String accountId, String accountName) {
        this.cashClosedPayInventoryId = cashClosedPayInventoryId;
        this.businessType = businessType;
        this.totalMoney = totalMoney;
        this.businessStatus = businessStatus;
        this.businessDate = businessDate;
        this.accountId = accountId;
        this.accountName = accountName;
    }

    public String getCashClosedPayInventoryId() {
        return cashClosedPayInventoryId;
    }
    public void setCashClosedPayInventoryId(String cashClosedPayInventoryId) {
        this.cashClosedPayInventoryId = cashClosedPayInventoryId;
    }

    public int getBusinessType() {
        return businessType;
    }
    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getBusinessStatus() {
        return businessStatus;
    }
    public void setBusinessStatus(int businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getBusinessDate() {
        return businessDate;
    }
    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public int getDeposit() {
        return deposit;
    }
    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSecuritiesClosedPayInventoryId() {
        return securitiesClosedPayInventoryId;
    }
    public void setSecuritiesClosedPayInventoryId(String securitiesClosedPayInventoryId) {
        this.securitiesClosedPayInventoryId = securitiesClosedPayInventoryId;
    }

    public int getSecuritiesType() {
        return securitiesType;
    }
    public void setSecuritiesType(int securitiesType) {
        this.securitiesType = securitiesType;
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

    @Override
    public String toString() {
        return "IncomePaymentPojo{" +
                "cashClosedPayInventoryId='" + cashClosedPayInventoryId + '\'' +
                ", businessType=" + businessType +
                ", totalMoney=" + totalMoney +
                ", businessStatus=" + businessStatus +
                ", businessDate='" + businessDate + '\'' +
                ", deposit=" + deposit +
                ", accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", securitiesClosedPayInventoryId='" + securitiesClosedPayInventoryId + '\'' +
                ", securitiesType=" + securitiesType +
                ", securitiesId='" + securitiesId + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                '}';
    }
}
