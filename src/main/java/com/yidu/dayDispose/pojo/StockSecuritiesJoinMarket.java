package com.yidu.dayDispose.pojo;

public class StockSecuritiesJoinMarket {
    private String fundId;
    private String securitiesId;
    private Double tootaIPrice;
    private int securityPeriodFlag;
    private String dateTime;
    public StockSecuritiesJoinMarket() {
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public Double getTootaIPrice() {
        return tootaIPrice;
    }

    public void setTootaIPrice(Double tootaIPrice) {
        this.tootaIPrice = tootaIPrice;
    }

    public int getSecurityPeriodFlag() {
        return securityPeriodFlag;
    }

    public void setSecurityPeriodFlag(int securityPeriodFlag) {
        this.securityPeriodFlag = securityPeriodFlag;
    }

    public StockSecuritiesJoinMarket(String fundId, String securitiesId, Double tootaIPrice, int securityPeriodFlag, String dateTime) {
        this.fundId = fundId;
        this.securitiesId = securitiesId;
        this.tootaIPrice = tootaIPrice;
        this.securityPeriodFlag = securityPeriodFlag;
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "StockSecuritiesJoinMarket{" +
                "fundId='" + fundId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", tootaIPrice=" + tootaIPrice +
                ", securityPeriodFlag=" + securityPeriodFlag +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
