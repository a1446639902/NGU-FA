package com.yidu.dayDispose.pojo;

/**
 * 债券的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public class SelectAllMsgDemoOnePojo {
    private String securitiesId;
    private String bondName;
    private int securitiesNum;
    private int total;
    private int closingPrice;

    public SelectAllMsgDemoOnePojo() {
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public int getSecuritiesNum() {
        return securitiesNum;
    }

    public void setSecuritiesNum(int securitiesNum) {
        this.securitiesNum = securitiesNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(int closingPrice) {
        this.closingPrice = closingPrice;
    }

    @Override
    public String toString() {
        return "SelectAllMsgDemoOnePojo{" +
                "securitiesId='" + securitiesId + '\'' +
                ", bondName='" + bondName + '\'' +
                ", securitiesNum=" + securitiesNum +
                ", total=" + total +
                ", closingPrice=" + closingPrice +
                '}';
    }

    public SelectAllMsgDemoOnePojo(String securitiesId, String bondName, int securitiesNum, int total, int closingPrice) {
        this.securitiesId = securitiesId;
        this.bondName = bondName;
        this.securitiesNum = securitiesNum;
        this.total = total;
        this.closingPrice = closingPrice;
    }
}
