package com.yidu.inventoryManage.pojo;

import com.yidu.businessParameter.pojo.AccountPojo;
import com.yidu.businessParameter.pojo.Fund;
import com.yidu.businessParameter.pojo.SecuritiesPojo;

/**
 * @type 证券库存
 * @author wufeiyun
 * @date 2020-9-7 10:08
 *@证券库存实体类
 */

public class SecuritiesInventory {
    private String securitiesInventoryId; //PK 证券库存ID
    private String dateTime;  //证券日期
    private String securitiesId; //证券信息表ID
    private String fundId;  //基金表ID
    private String accountId; //    账户id
    private int securityPeriodFlag; //是否从其他系统导入的期初数据
    private int securitiesNum;  //证券的数量
    private double price;
    private double total;  //总金额
    private String securitiesInventoryDesc;   //备注
    private AccountPojo accountPojo;
    private SecuritiesPojo securitiesPojo;
    private String flag;
    private String fundName;
    private String accountName;
    private String securitiesName;
    public SecuritiesInventory() {
    }

    public String getSecuritiesInventoryId() {
        return securitiesInventoryId;
    }

    public void setSecuritiesInventoryId(String securitiesInventoryId) {
        this.securitiesInventoryId = securitiesInventoryId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public int getSecurityPeriodFlag() {
        return securityPeriodFlag;
    }

    public void setSecurityPeriodFlag(int securityPeriodFlag) {
        this.securityPeriodFlag = securityPeriodFlag;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getSecuritiesInventoryDesc() {
        return securitiesInventoryDesc;
    }

    public void setSecuritiesInventoryDesc(String securitiesInventoryDesc) {
        this.securitiesInventoryDesc = securitiesInventoryDesc;
    }

    public SecuritiesPojo getSecuritiesPojo() {
        return securitiesPojo;
    }

    public void setSecuritiesPojo(SecuritiesPojo securitiesPojo) {
        this.securitiesPojo = securitiesPojo;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public AccountPojo getAccountPojo() {
        return accountPojo;
    }

    public void setAccountPojo(AccountPojo accountPojo) {
        this.accountPojo = accountPojo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSecuritiesName() {
        return securitiesName;
    }

    public void setSecuritiesName(String securitiesName) {
        this.securitiesName = securitiesName;
    }

    public SecuritiesInventory(String securitiesInventoryId, String dateTime, String securitiesId, String fundId, String accountId, int securityPeriodFlag, int securitiesNum, double price, double total, String securitiesInventoryDesc, AccountPojo accountPojo, SecuritiesPojo securitiesPojo, String flag, String fundName, String accountName, String securitiesName) {
        this.securitiesInventoryId = securitiesInventoryId;
        this.dateTime = dateTime;
        this.securitiesId = securitiesId;
        this.fundId = fundId;
        this.accountId = accountId;
        this.securityPeriodFlag = securityPeriodFlag;
        this.securitiesNum = securitiesNum;
        this.price = price;
        this.total = total;
        this.securitiesInventoryDesc = securitiesInventoryDesc;
        this.accountPojo = accountPojo;
        this.securitiesPojo = securitiesPojo;
        this.flag = flag;
        this.fundName = fundName;
        this.accountName = accountName;
        this.securitiesName = securitiesName;
    }

    @Override
    public String toString() {
        return "SecuritiesInventory{" +
                "securitiesInventoryId='" + securitiesInventoryId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", securityPeriodFlag=" + securityPeriodFlag +
                ", securitiesNum=" + securitiesNum +
                ", price=" + price +
                ", total=" + total +
                ", securitiesInventoryDesc='" + securitiesInventoryDesc + '\'' +
                ", accountPojo=" + accountPojo +
                ", securitiesPojo=" + securitiesPojo +
                ", flag='" + flag + '\'' +
                ", fundName='" + fundName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                '}';
    }
}
