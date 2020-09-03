package com.yidu.businessData.pojo;

public class EquityData {
    /**
     *@author wzh
     *date 2020-9-1
     * 权益数据设置表实体类
     */
    private String dateTime;                    //业务日期
    private int securityId;                     //证券ID
    private String securityName;                //证券名称
    private String equitiesRecord;              //权益登记日 除权日-1day
    private String equitiesExright;             //权益除权日 yyyy-MM-dd
    private String receivedDate;                //到账日期 除权日+2day
    private int equitiesType;                   //权益类型  1.送股  2.分红
    private int proportion;                     //比例   单位为%来计算
    private String disposeStatus;               //处理状态处理状态分为已处理和未处理与权益处理的已结算和未结算相对应（0未处理 1已处理）

    public EquityData() {
    }

    public EquityData(String dateTime, int securityId, String securityName, String equitiesRecord, String equitiesExright, String receivedDate, int equitiesType, int proportion, String disposeStatus) {
        this.dateTime = dateTime;
        this.securityId = securityId;
        this.securityName = securityName;
        this.equitiesRecord = equitiesRecord;
        this.equitiesExright = equitiesExright;
        this.receivedDate = receivedDate;
        this.equitiesType = equitiesType;
        this.proportion = proportion;
        this.disposeStatus = disposeStatus;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getSecurityId() {
        return securityId;
    }

    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getEquitiesRecord() {
        return equitiesRecord;
    }

    public void setEquitiesRecord(String equitiesRecord) {
        this.equitiesRecord = equitiesRecord;
    }

    public String getEquitiesExright() {
        return equitiesExright;
    }

    public void setEquitiesExright(String equitiesExright) {
        this.equitiesExright = equitiesExright;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public int getEquitiesType() {
        return equitiesType;
    }

    public void setEquitiesType(int equitiesType) {
        this.equitiesType = equitiesType;
    }

    public int getProportion() {
        return proportion;
    }

    public void setProportion(int proportion) {
        this.proportion = proportion;
    }

    public String getDisposeStatus() {
        return disposeStatus;
    }

    public void setDisposeStatus(String disposeStatus) {
        this.disposeStatus = disposeStatus;
    }

    @Override
    public String toString() {
        return "EquityData{" +
                "dateTime='" + dateTime + '\'' +
                ", securityId=" + securityId +
                ", securityName='" + securityName + '\'' +
                ", equitiesRecord='" + equitiesRecord + '\'' +
                ", equitiesExright='" + equitiesExright + '\'' +
                ", receivedDate='" + receivedDate + '\'' +
                ", equitiesType=" + equitiesType +
                ", proportion=" + proportion +
                ", disposeStatus='" + disposeStatus + '\'' +
                '}';
    }
}
