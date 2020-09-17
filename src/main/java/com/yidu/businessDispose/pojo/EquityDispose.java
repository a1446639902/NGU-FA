package com.yidu.businessDispose.pojo;

public class EquityDispose {
    private String equityDataId;//权益编号
    private String securitiesName;//证券名称
    private String accountName;//账户名称
    private int equitiesType;//权益类型
    private String equitiesExright;//除权日
    private String receivedDate;//到账日期
    private int securitiesNum;//证券数量
    private int proportion;//比例
    private String settlementAmount;//结算金额
    private int disposeStatus;//处理状态   0.未处理   1.已处理


    public EquityDispose() {
    }

    public EquityDispose(String equityDataId, String securitiesName, String accountName, int equitiesType, String equitiesExright, String receivedDate, int securitiesNum, int proportion, String settlementAmount, int disposeStatus) {
        this.equityDataId = equityDataId;
        this.securitiesName = securitiesName;
        this.accountName = accountName;
        this.equitiesType = equitiesType;
        this.equitiesExright = equitiesExright;
        this.receivedDate = receivedDate;
        this.securitiesNum = securitiesNum;
        this.proportion = proportion;
        this.settlementAmount = settlementAmount;
        this.disposeStatus = disposeStatus;
    }

    public String getEquityDataId() {
        return equityDataId;
    }

    public void setEquityDataId(String equityDataId) {
        this.equityDataId = equityDataId;
    }

    public String getSecuritiesName() {
        return securitiesName;
    }

    public void setSecuritiesName(String securitiesName) {
        this.securitiesName = securitiesName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getEquitiesType() {
        return equitiesType;
    }

    public void setEquitiesType(int equitiesType) {
        this.equitiesType = equitiesType;
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

    public int getSecuritiesNum() {
        return securitiesNum;
    }

    public void setSecuritiesNum(int securitiesNum) {
        this.securitiesNum = securitiesNum;
    }

    public int getProportion() {
        return proportion;
    }

    public void setProportion(int proportion) {
        this.proportion = proportion;
    }

    public String getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(String settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public int getDisposeStatus() {
        return disposeStatus;
    }

    public void setDisposeStatus(int disposeStatus) {
        this.disposeStatus = disposeStatus;
    }

    @Override
    public String toString() {
        return "EquityDispose{" +
                "equityDataId='" + equityDataId + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", equitiesType=" + equitiesType +
                ", equitiesExright='" + equitiesExright + '\'' +
                ", receivedDate='" + receivedDate + '\'' +
                ", securitiesNum=" + securitiesNum +
                ", proportion=" + proportion +
                ", settlementAmount='" + settlementAmount + '\'' +
                ", disposeStatus=" + disposeStatus +
                '}';
    }
}

