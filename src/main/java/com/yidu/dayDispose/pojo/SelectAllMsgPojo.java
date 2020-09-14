package com.yidu.dayDispose.pojo;

/**
 * 查询其他表字段的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public class SelectAllMsgPojo {
    private String  valueStatisticsDate;        //统计日期
    private String projectCode;                 //项目代码/账户号
    private String securitiesName;              //项目名称
    private String securitiesId;                //项目id
    private int securitiesNum;                  //持有数量
    private String marketValue;                 //市值
    private int total;                          //成本总价
    private int closingPrice;                   //闭市价格
    private int projectFatherId;                //父项目编号
    private String valuation;                   //估值增值

    public SelectAllMsgPojo() {
    }

    @Override
    public String toString() {
        return "SelectAllMsgPojo{" +
                "valueStatisticsDate='" + valueStatisticsDate + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", securitiesNum=" + securitiesNum +
                ", marketValue='" + marketValue + '\'' +
                ", total=" + total +
                ", closingPrice=" + closingPrice +
                ", projectFatherId=" + projectFatherId +
                ", valuation='" + valuation + '\'' +
                '}';
    }

    public String getValuation() {
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
    }

    public String getValueStatisticsDate() {
        return valueStatisticsDate;
    }

    public void setValueStatisticsDate(String valueStatisticsDate) {
        this.valueStatisticsDate = valueStatisticsDate;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public int getProjectFatherId() {
        return projectFatherId;
    }

    public void setProjectFatherId(int projectFatherId) {
        this.projectFatherId = projectFatherId;
    }

    public SelectAllMsgPojo(String securitiesName, String securitiesId, int securitiesNum, int total, int closingPrice) {
        this.securitiesName = securitiesName;
        this.securitiesId = securitiesId;
        this.securitiesNum = securitiesNum;
        this.total = total;
        this.closingPrice = closingPrice;
    }

    public String getSecuritiesName() {
        return securitiesName;
    }

    public void setSecuritiesName(String securitiesName) {
        this.securitiesName = securitiesName;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
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
}
