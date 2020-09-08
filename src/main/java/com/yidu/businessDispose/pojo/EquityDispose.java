package com.yidu.businessDispose.pojo;

public class EquityDispose {
    private  String equityDataId;               //权益数据编号
    private String securitiesName;              //证券名称
    private String accountName;                   //账户名称
    private int equitiesType;                  //权益类型
    private String equitiesExright;            //除权日期
    private  int securitiesNum;                 //证券数量
    private int proportion;                     //比例

    public EquityDispose() {
    }

    public EquityDispose(String equityDataId, String securitiesName, String accountName, int equitiesType, String equitiesExright, int securitiesNum, int proportion) {
        this.equityDataId = equityDataId;
        this.securitiesName = securitiesName;
        this.accountName = accountName;
        this.equitiesType = equitiesType;
        this.equitiesExright = equitiesExright;
        this.securitiesNum = securitiesNum;
        this.proportion = proportion;
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

    @Override
    public String toString() {
        return "EquityDispose{" +
                "equityDataId='" + equityDataId + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", equitiesType=" + equitiesType +
                ", equitiesExright='" + equitiesExright + '\'' +
                ", securitiesNum=" + securitiesNum +
                ", proportion=" + proportion +
                '}';
    }
}

