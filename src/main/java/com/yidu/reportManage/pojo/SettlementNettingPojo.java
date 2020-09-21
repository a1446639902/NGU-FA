package com.yidu.reportManage.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName SettlementNettingPojo
 * @Description: TODO
 * @Author 硠君
 * @Date create in 10:11 2020/9/19
 * @Version 1.0
 **/
public class SettlementNettingPojo {
    private String name;
    private Double netreceipts ;
    private Double transfer;
    private Double brokerage;
    private Double stamp ;
    private Double management ;
    private Double commission ;
    private Double totalsum ;

    public SettlementNettingPojo() {
    }
    public SettlementNettingPojo(String name, Double netreceipts, Double transfer, Double brokerage, Double stamp,
                                 Double management, Double commission, Double totalsum) {
        this.name = name;
        this.netreceipts = netreceipts;
        this.transfer = transfer;
        this.brokerage = brokerage;
        this.stamp = stamp;
        this.management = management;
        this.commission = commission;
        this.totalsum = totalsum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNetreceipts() {
        return netreceipts;
    }

    public void setNetreceipts(Double netreceipts) {
        this.netreceipts = netreceipts;
    }

    public Double getTransfer() {
        return transfer;
    }

    public void setTransfer(Double transfer) {
        this.transfer = transfer;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    public Double getStamp() {
        return stamp;
    }

    public void setStamp(Double stamp) {
        this.stamp = stamp;
    }

    public Double getManagement() {
        return management;
    }

    public void setManagement(Double management) {
        this.management = management;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(Double totalsum) {
        this.totalsum = totalsum;
    }

    @Override
    public String toString() {
        return "SettlementNettingPojo{" +
                "name='" + name + '\'' +
                ", netreceipts=" + netreceipts +
                ", transfer=" + transfer +
                ", brokerage=" + brokerage +
                ", stamp=" + stamp +
                ", management=" + management +
                ", commission=" + commission +
                ", totalsum=" + totalsum +
                '}';
    }
}
