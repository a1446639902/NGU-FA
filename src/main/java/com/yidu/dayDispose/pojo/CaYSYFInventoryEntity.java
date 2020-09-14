package com.yidu.dayDispose.pojo;

/**
 *  现金应收应付的Entity  统计完之后的数据
 * @Mr.Zou
 **/
public class CaYSYFInventoryEntity {

    private int serv;//业务类型
    private double toca;//总金额
    private String accountId;//账户信息表ID

    public CaYSYFInventoryEntity() {
    }

    public CaYSYFInventoryEntity(int serv, double toca, String accountId) {
        this.serv = serv;
        this.toca = toca;
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "CaYSYFInventoryMapper{" +
                "serv=" + serv +
                ", toca=" + toca +
                ", accountId='" + accountId + '\'' +
                '}';
    }

    public int getServ() {
        return serv;
    }

    public void setServ(int serv) {
        this.serv = serv;
    }

    public double getToca() {
        return toca;
    }

    public void setToca(double toca) {
        this.toca = toca;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
