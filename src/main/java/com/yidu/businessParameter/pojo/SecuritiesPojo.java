package com.yidu.businessParameter.pojo;

/**author xbf
 *date 2020-9-1
 * 证券信息实体类
 * @vesion 1.0
 **/
public class SecuritiesPojo {
    private String securitiesId;
    private String securitiesName;
    private int securitiesType;
    private String issueDate;
    private String delayDate;
    private String stockId;
    private int exchange;
    private String securitiesDesc;

    public SecuritiesPojo() {
    }

    public SecuritiesPojo(String securitiesId, String securitiesName, int securitiesType, String issueDate, String delayDate, String stockId, int exchange, String securitiesDesc) {
        this.securitiesId = securitiesId;
        this.securitiesName = securitiesName;
        this.securitiesType = securitiesType;
        this.issueDate = issueDate;
        this.delayDate = delayDate;
        this.stockId = stockId;
        this.exchange = exchange;
        this.securitiesDesc = securitiesDesc;
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

    public int getSecuritiesType() {
        return securitiesType;
    }

    public void setSecuritiesType(int securitiesType) {
        this.securitiesType = securitiesType;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDelayDate() {
        return delayDate;
    }

    public void setDelayDate(String delayDate) {
        this.delayDate = delayDate;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public int getExchange() {
        return exchange;
    }

    public void setExchange(int exchange) {
        this.exchange = exchange;
    }

    public String getSecuritiesDesc() {
        return securitiesDesc;
    }

    public void setSecuritiesDesc(String securitiesDesc) {
        this.securitiesDesc = securitiesDesc;
    }

    @Override
    public String toString() {
        return "SecuritiesPojo{" +
                "securitiesId='" + securitiesId + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", securitiesType=" + securitiesType +
                ", issueDate='" + issueDate + '\'' +
                ", delayDate='" + delayDate + '\'' +
                ", stockId='" + stockId + '\'' +
                ", exchange=" + exchange +
                ", securitiesDesc='" + securitiesDesc + '\'' +
                '}';
    }
}
