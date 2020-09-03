package com.yidu.businessParameter.pojo;

/**author xbf
 *date 2020-9-1
 * 股票板块实体类
 * @vesion1.0
 **/
public class StockPojo {
    private String stockId;
    private String stockParentId;
    private String stockName;
    private String stockDesc;

    public StockPojo() {
    }

    public StockPojo(String stockId, String stockParentId, String stockName, String stockDesc) {
        this.stockId = stockId;
        this.stockParentId = stockParentId;
        this.stockName = stockName;
        this.stockDesc = stockDesc;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStockParentId() {
        return stockParentId;
    }

    public void setStockParentId(String stockParentId) {
        this.stockParentId = stockParentId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockDesc() {
        return stockDesc;
    }

    public void setStockDesc(String stockDesc) {
        this.stockDesc = stockDesc;
    }

    @Override
    public String toString() {
        return "StockPojo{" +
                "stockId='" + stockId + '\'' +
                ", stockParentId='" + stockParentId + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockDesc='" + stockDesc + '\'' +
                '}';
    }
}
