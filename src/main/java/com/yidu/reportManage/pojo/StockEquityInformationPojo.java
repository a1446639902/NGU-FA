package com.yidu.reportManage.pojo;

/**股票权益信息报表
 *author xbf
 * 2020-9-18
 **/
public class StockEquityInformationPojo {
    private String securitiesId;
    private String securitiesName;
    private String issueDate;
    private String quantityint;
    private String marketValue;

    public StockEquityInformationPojo() {
    }

    public StockEquityInformationPojo(String securitiesId, String securitiesName, String issueDate, String quantityint, String marketValue) {
        this.securitiesId = securitiesId;
        this.securitiesName = securitiesName;
        this.issueDate = issueDate;
        this.quantityint = quantityint;
        this.marketValue = marketValue;
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

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getQuantityint() {
        return quantityint;
    }

    public void setQuantityint(String quantityint) {
        this.quantityint = quantityint;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "StockEquityInformationPojo{" +
                "securitiesId='" + securitiesId + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", quantityint='" + quantityint + '\'' +
                ", marketValue='" + marketValue + '\'' +
                '}';
    }
}
