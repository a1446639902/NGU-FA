package com.yidu.dayDispose.pojo;

/**
 *  现金应收应付的Entity  统计完之后的数据
 * @Mr.Zou
 **/
public class CaYSYFInventoryEntity {

    private int serv;//业务类型
    private double toca;//总金额
    private String accountId;//账户信息表ID
    private int fla;//状态

    public CaYSYFInventoryEntity() {
    }

    public CaYSYFInventoryEntity(int serv, double toca, String accountId, int fla) {
        this.serv = serv;
        this.toca = toca;
        this.accountId = accountId;
        this.fla = fla;
    }

    @Override
    public String toString() {
        return "CaYSYFInventoryEntity{" +
                "serv=" + serv +
                ", toca=" + toca +
                ", accountId='" + accountId + '\'' +
                ", fla=" + fla +
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

    public int getFla() {
        return fla;
    }

    public void setFla(int fla) {
        this.fla = fla;
    }
}
