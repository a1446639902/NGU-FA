package com.yidu.businessData.pojo;

public class EquityData {
    /**
     *@author wzh
     *date 2020-9-1
     * 权益数据设置表实体类
     */
    private String equityId;//权益ID（隐藏字段）
    private String dateTime;//业务日期
    private int securityId;//证券Id
    private String securityName;//证券名称
    private String equitiesRecord;//权益登记日
    private String equitiesExright;//权益除权日
    private String receivedDate;//到账日期
    private int equitiesType;//权益类型  1.送股   2.分红
    private int proportion;//比例
    private int disposeStatus;//处理状态   0.未处理   1.已处理

    public EquityData() {
    }

    public EquityData(String equityId, String dateTime, int securityId, String securityName, String equitiesRecord, String equitiesExright, String receivedDate, int equitiesType, int proportion, int disposeStatus) {
        this.equityId = equityId;
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

    public String getEquityId() {
        return equityId;
    }

    public void setEquityId(String equityId) {
        this.equityId = equityId;
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

    public int getDisposeStatus() {
        return disposeStatus;
    }

    public void setDisposeStatus(int disposeStatus) {
        this.disposeStatus = disposeStatus;
    }

    @Override
    public String toString() {
        return "EquityData{" +
                "equityId='" + equityId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", securityId=" + securityId +
                ", securityName='" + securityName + '\'' +
                ", equitiesRecord='" + equitiesRecord + '\'' +
                ", equitiesExright='" + equitiesExright + '\'' +
                ", receivedDate='" + receivedDate + '\'' +
                ", equitiesType=" + equitiesType +
                ", proportion=" + proportion +
                ", disposeStatus=" + disposeStatus +
                '}';
    }
}
