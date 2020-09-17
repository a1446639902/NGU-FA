package com.yidu.dayDispose.pojo;

/**
 * 净值统计的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time2020-9-8
 **/
public class NetValueOfStatisticalPojo {

    private String valueStatisticsDate; //统计日期
    private int projectId;              //项目编号
    private String projectName;         //项目名称
    private String projectCode;         //项目代码/账户号
    private String quantityint;         //股数
    private String peice;               //行情
    private String cost;                //成本
    private String marketValue;         //市值
    private String valuation;           //估值增值
    private int projectFatherId;        //父项目编号
    private String fundId;              //基金id
    private int count;                  //计数

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "NetValueOfStatisticalPojo{" +
                "valueStatisticsDate='" + valueStatisticsDate + '\'' +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", quantityint='" + quantityint + '\'' +
                ", peice='" + peice + '\'' +
                ", cost='" + cost + '\'' +
                ", marketValue='" + marketValue + '\'' +
                ", valuation='" + valuation + '\'' +
                ", projectFatherId=" + projectFatherId +
                ", fundId='" + fundId + '\'' +
                ", count=" + count +
                '}';
    }

    public void setCount(int count) {
        this.count = count;
    }

    public NetValueOfStatisticalPojo() {
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public NetValueOfStatisticalPojo(String valueStatisticsDate, int projectId, String projectName, String projectCode, String quantityint, String peice, String cost, String marketValue, String valuation, int projectFatherId, String fundId) {
        this.valueStatisticsDate = valueStatisticsDate;
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.quantityint = quantityint;
        this.peice = peice;
        this.cost = cost;
        this.marketValue = marketValue;
        this.valuation = valuation;
        this.projectFatherId = projectFatherId;
        this.fundId = fundId;
    }

    public NetValueOfStatisticalPojo(String valueStatisticsDate, int projectId, String projectName, String projectCode, String quantityint, String peice, String cost, String marketValue, String valuation, int projectFatherId) {
        this.valueStatisticsDate = valueStatisticsDate;
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.quantityint = quantityint;
        this.peice = peice;
        this.cost = cost;
        this.marketValue = marketValue;
        this.valuation = valuation;
        this.projectFatherId = projectFatherId;
    }

    public String getValueStatisticsDate() {
        return valueStatisticsDate;
    }

    public void setValueStatisticsDate(String valueStatisticsDate) {
        this.valueStatisticsDate = valueStatisticsDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getQuantityint() {
        return quantityint;
    }

    public void setQuantityint(String quantityint) {
        this.quantityint = quantityint;
    }

    public String getPeice() {
        return peice;
    }

    public void setPeice(String peice) {
        this.peice = peice;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getValuation() {
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
    }

    public int getProjectFatherId() {
        return projectFatherId;
    }

    public void setProjectFatherId(int projectFatherId) {
        this.projectFatherId = projectFatherId;
    }
}
