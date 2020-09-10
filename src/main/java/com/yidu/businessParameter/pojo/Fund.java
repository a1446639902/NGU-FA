package com.yidu.businessParameter.pojo;

/**
 * 基金参数
 * @Type:实体类
 * @author Tmac
 * @time 2020/9/1  8:52
 * @version   1.1
 **/
public class Fund {
  /*  fundId	varchar2(50)	PK  基金代码 (每个基金都有唯一的代码)
    fundName	Varchar2(50)	基金名称
    fundType	number(1)	1代表开放式基金 2代表封闭式基金
    managerId	varchar2(50)	Fk  管理人id  来自管理人表
    trusteeBlank	Varchar2(50)	FK  托管人id  来自托管人表
    initNetWorth	Number(14,2)	初始净值
    sizeOfThe	Number(14,2)	基金规模
    managerRate	Number(10,4)	管理人费率 年利率  ?/100
    hostingRate	Number(10,4)	托管人费率  年利率  ?/100
    provisionDays	Number(1)	1=360天；2=365天；3=366天
    setUpDate	date	基金成立时间
    fundDesc	varchar2(100)	备注
    accountId  	varchar2(50)	FK 账户信息表*/

    private String fundId;	            //PK  基金代码 (每个基金都有唯一的代码)
    private String fundName;		//基金名称
    private int fundType;           //1代表开放式基金 2代表封闭式基金
    private String managerId;		//Fk  管理人id  来自管理人表
    private String trusteeBlank;	//FK  托管人id  来自托管人表
    private Double initNetWorth;	//初始净值
    private Double  sizeOfThe;		//基金规模
    private Double  managerRate;	//管理人费率 年利率  ?/100
    private Double hostingRate;		//托管人费率  年利率  ?/100
    private int provisionDays;		//1=360天；2=365天；3=366天
    private String setUpDate;       //基金成立时间
    private String fundDesc;	    //备注
    private String  accountId;      //FK 账户信息表

    public Fund() {
    }


    public Fund(String fundId, String fundName, int fundType, String managerId, String trusteeBlank, Double initNetWorth, Double sizeOfThe, Double managerRate, Double hostingRate, int provisionDays, String setUpDate, String fundDesc, String accountId) {
        this.fundId = fundId;
        this.fundName = fundName;
        this.fundType = fundType;
        this.managerId = managerId;
        this.trusteeBlank = trusteeBlank;
        this.initNetWorth = initNetWorth;
        this.sizeOfThe = sizeOfThe;
        this.managerRate = managerRate;
        this.hostingRate = hostingRate;
        this.provisionDays = provisionDays;
        this.setUpDate = setUpDate;
        this.fundDesc = fundDesc;
        this.accountId = accountId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public int getFundType() {
        return fundType;
    }

    public void setFundType(int fundType) {
        this.fundType = fundType;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getTrusteeBlank() {
        return trusteeBlank;
    }

    public void setTrusteeBlank(String trusteeBlank) {
        this.trusteeBlank = trusteeBlank;
    }

    public Double getInitNetWorth() {
        return initNetWorth;
    }

    public void setInitNetWorth(Double initNetWorth) {
        this.initNetWorth = initNetWorth;
    }

    public Double getSizeOfThe() {
        return sizeOfThe;
    }

    public void setSizeOfThe(Double sizeOfThe) {
        this.sizeOfThe = sizeOfThe;
    }

    public Double getManagerRate() {
        return managerRate;
    }

    public void setManagerRate(Double managerRate) {
        this.managerRate = managerRate;
    }

    public Double getHostingRate() {
        return hostingRate;
    }

    public void setHostingRate(Double hostingRate) {
        this.hostingRate = hostingRate;
    }

    public int getProvisionDays() {
        return provisionDays;
    }

    public void setProvisionDays(int provisionDays) {
        this.provisionDays = provisionDays;
    }

    public String getSetUpDate() {
        return setUpDate;
    }

    public void setSetUpDate(String setUpDate) {
        this.setUpDate = setUpDate;
    }

    public String getFundDesc() {
        return fundDesc;
    }

    public void setFundDesc(String fundDesc) {
        this.fundDesc = fundDesc;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "fundId='" + fundId + '\'' +
                ", fundName='" + fundName + '\'' +
                ", fundType=" + fundType +
                ", managerId='" + managerId + '\'' +
                ", trusteeBlank='" + trusteeBlank + '\'' +
                ", initNetWorth=" + initNetWorth +
                ", sizeOfThe=" + sizeOfThe +
                ", managerRate=" + managerRate +
                ", hostingRate=" + hostingRate +
                ", provisionDays=" + provisionDays +
                ", setUpDate='" + setUpDate + '\'' +
                ", fundDesc='" + fundDesc + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
