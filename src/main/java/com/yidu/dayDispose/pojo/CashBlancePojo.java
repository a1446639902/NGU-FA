package com.yidu.dayDispose.pojo;

/**
 * 现金账户和id,银行卡号的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public class CashBlancePojo {
    private String accountName;
    private String blankCardCode;
    private int cashBlance;

    public CashBlancePojo() {
    }

    @Override
    public String toString() {
        return "CashBlancePojo{" +
                "accountName='" + accountName + '\'' +
                ", blankCardCode='" + blankCardCode + '\'' +
                ", cashBlance=" + cashBlance +
                '}';
    }

    public CashBlancePojo(String accountName, String blankCardCode, int cashBlance) {
        this.accountName = accountName;
        this.blankCardCode = blankCardCode;
        this.cashBlance = cashBlance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBlankCardCode() {
        return blankCardCode;
    }

    public void setBlankCardCode(String blankCardCode) {
        this.blankCardCode = blankCardCode;
    }

    public int getCashBlance() {
        return cashBlance;
    }

    public void setCashBlance(int cashBlance) {
        this.cashBlance = cashBlance;
    }
}
