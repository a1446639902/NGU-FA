package com.yidu.businessData.pojo;

/*
  @type:控制层
 *@author wufeiyun
 * time 2020-9-2 15:36
  version 1.0
 * */

public class MarketData {
private String marketId;  //行情ID
private String securitiesId;    //证券名称
private String dateTime;  //录入证券的日期
private double openPrice;
private double closingPrice;
private String marketDesc;  //行情数据的其他信息

    public MarketData() {
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getMarketDesc() {
        return marketDesc;
    }

    public void setMarketDesc(String marketDesc) {
        this.marketDesc = marketDesc;
    }

    public String getSecuritiesName() {
        return securitiesId;
    }

    public void setSecuritiesName(String securitiesName) {
        this.securitiesId = securitiesName;
    }

    public MarketData(String marketId, String securitiesId, String dateTime, double openPrice, double closingPrice, String marketDesc) {
        this.marketId = marketId;
        this.securitiesId = securitiesId;
        this.dateTime = dateTime;
        this.openPrice = openPrice;
        this.closingPrice = closingPrice;
        this.marketDesc = marketDesc;
    }

    @Override
    public String toString() {
        return "MarketData{" +
                "marketId='" + marketId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", openPrice=" + openPrice +
                ", closingPrice=" + closingPrice +
                ", marketDesc='" + marketDesc + '\'' +
                '}';
    }
}
