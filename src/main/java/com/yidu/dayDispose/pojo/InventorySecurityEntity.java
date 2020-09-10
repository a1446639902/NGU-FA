package com.yidu.dayDispose.pojo;

/**
 * 用于保存库存统计后证券库存的数据
 * @Mr.Zou
 **/
public class InventorySecurityEntity {

    private String securitiesId;//证券库存表ID，引用证券编号securitiesId，证券名securitiesName
    private int todayNum;//结算完的证券数量
    private double todayTotal;//结算完的证券总金额
    private double unitPrice;//结算完的证券单价

    public InventorySecurityEntity() {
    }

    public InventorySecurityEntity(String securitiesId, int todayNum, double todayTotal, double unitPrice) {
        this.securitiesId = securitiesId;
        this.todayNum = todayNum;
        this.todayTotal = todayTotal;
        this.unitPrice = unitPrice;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public int getTodayNum() {
        return todayNum;
    }

    public void setTodayNum(int todayNum) {
        this.todayNum = todayNum;
    }

    public double getTodayTotal() {
        return todayTotal;
    }

    public void setTodayTotal(double todayTotal) {
        this.todayTotal = todayTotal;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "InventorySecurityEntity{" +
                "securitiesId='" + securitiesId + '\'' +
                ", todayNum=" + todayNum +
                ", todayTotal=" + todayTotal +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
