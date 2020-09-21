package com.yidu.reportManage.pojo;

/**证券市值变动表
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/20
 **/
public class StatementMarketChangePojo {
    private String securitiesId; //证券ID
    private String securitiesName;//证券名称
    private int securitiesNum;//证券的数量
    private double price; //单位成本
    private double closingPrice;//market表   行情价格
    private double marketChangeValue;//市值变动值   行情价格-单位成本/单位成本
    private double netAssetValue;//资产净值
    private double ratio;//市值占净值比 库存数量*行情价格/资产净值

    public StatementMarketChangePojo() {
    }

    public StatementMarketChangePojo(String securitiesId, String securitiesName, int securitiesNum, double price, double closingPrice, double marketChangeValue, double netAssetValue, double ratio) {
        this.securitiesId = securitiesId;
        this.securitiesName = securitiesName;
        this.securitiesNum = securitiesNum;
        this.price = price;
        this.closingPrice = closingPrice;
        this.marketChangeValue = marketChangeValue;
        this.netAssetValue = netAssetValue;
        this.ratio = ratio;
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

    public int getSecuritiesNum() {
        return securitiesNum;
    }

    public void setSecuritiesNum(int securitiesNum) {
        this.securitiesNum = securitiesNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public double getMarketChangeValue() {
        return marketChangeValue;
    }

    public void setMarketChangeValue(double marketChangeValue) {
        this.marketChangeValue = marketChangeValue;
    }

    public double getNetAssetValue() {
        return netAssetValue;
    }

    public void setNetAssetValue(double netAssetValue) {
        this.netAssetValue = netAssetValue;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "StatementMarketChangePojo{" +
                "securitiesId='" + securitiesId + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", securitiesNum=" + securitiesNum +
                ", price=" + price +
                ", closingPrice=" + closingPrice +
                ", marketChangeValue=" + marketChangeValue +
                ", netAssetValue=" + netAssetValue +
                ", ratio=" + ratio +
                '}';
    }
}
