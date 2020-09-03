package com.yidu.inventoryManage.pojo;

public class CashClosedPayInventory {
    /**
     *@author wzh
     * date 2020-9-1
     * 现金应收应付库存实体类
     */
    private String crcsId;                      //现金应收应付库存编号
    private String businessDate;                //业务日期
    private String cashAccountName;             //现金账户名称
    private int businessType;                   //业务类型  1.管理费 2.托管费  3.存款利息  4.申购赎回费
    private int businessStatus;                 //业务状态 1.流入  -1流出
    private int initialSigns;                   //期初标志 1.是   0.否
    private int totalMoney;                     //总金额

    public CashClosedPayInventory() {
    }

    public CashClosedPayInventory(String crcsId, String businessDate, String cashAccountName, int businessType, int businessStatus, int initialSigns, int totalMoney) {
        this.crcsId = crcsId;
        this.businessDate = businessDate;
        this.cashAccountName = cashAccountName;
        this.businessType = businessType;
        this.businessStatus = businessStatus;
        this.initialSigns = initialSigns;
        this.totalMoney = totalMoney;
    }

    public String getCrcsId() {
        return crcsId;
    }

    public void setCrcsId(String crcsId) {
        this.crcsId = crcsId;
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
                "crcsId='" + crcsId + '\'' +
                ", businessDate='" + businessDate + '\'' +
                ", cashAccountName='" + cashAccountName + '\'' +
                ", businessType=" + businessType +
                ", businessStatus=" + businessStatus +
                ", initialSigns=" + initialSigns +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
