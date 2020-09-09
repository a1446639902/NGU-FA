package com.yidu.inventoryManage.pojo;

public class CashClosedPayInventory {
    /**
     *@author wzh
     * date 2020-9-1
     * 现金应收应付库存实体类
     */
    private String cashClosedPayInventoryId;                      //现金应收应付库存编号
    private String businessDate;                //业务日期
    private String cashAccountName;             //现金账户名称
    private String fundId;                       //基金Id
    private int businessType;                   //业务类型  1.管理费 2.托管费  3.存款利息  4.申购赎回费
    private int businessStatus;                 //业务状态 1.流入  -1流出
    private int initialSigns;                   //期初标志 1.是   0.否
    private int totalMoney;                     //总金额

    public CashClosedPayInventory() {
    }

    public CashClosedPayInventory(String cashClosedPayInventoryId, String businessDate, String cashAccountName, String fundId, int businessType, int businessStatus, int initialSigns, int totalMoney) {
        this.cashClosedPayInventoryId = cashClosedPayInventoryId;
        this.businessDate = businessDate;
        this.cashAccountName = cashAccountName;
        this.fundId = fundId;
        this.businessType = businessType;
        this.businessStatus = businessStatus;
        this.initialSigns = initialSigns;
        this.totalMoney = totalMoney;
    }

    public String getCashClosedPayInventoryId() {
        return cashClosedPayInventoryId;
    }

    public void setCashClosedPayInventoryId(String cashClosedPayInventoryId) {
        this.cashClosedPayInventoryId = cashClosedPayInventoryId;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getCashAccountName() {
        return cashAccountName;
    }

    public void setCashAccountName(String cashAccountName) {
        this.cashAccountName = cashAccountName;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public int getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(int businessStatus) {
        this.businessStatus = businessStatus;
    }

    public int getInitialSigns() {
        return initialSigns;
    }

    public void setInitialSigns(int initialSigns) {
        this.initialSigns = initialSigns;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "CashClosedPayInventory{" +
                "cashClosedPayInventoryId='" + cashClosedPayInventoryId + '\'' +
                ", businessDate='" + businessDate + '\'' +
                ", cashAccountName='" + cashAccountName + '\'' +
                ", fundId='" + fundId + '\'' +
                ", businessType=" + businessType +
                ", businessStatus=" + businessStatus +
                ", initialSigns=" + initialSigns +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
