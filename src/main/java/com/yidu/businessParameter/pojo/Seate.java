package com.yidu.businessParameter.pojo;

/**
 * @name 戴言露
 * @data 2020/9/1 am
 * 交易席位表
 */
public class Seate {
    private String seateId;	 //席位编号
    private String seateName;//席位名称
    private int seateType;   //席位类型
    private double seateRate;//佣金费率 年利率？/100
    private String brokersId;//券商编号  Fk  券商编号id  来自券商信息表（brokers）
    private int seateAddress;//1=上海  2=深圳
    private String desc;     //备注
    public Seate(){}

    public Seate(String seateId, String seateName, int seateType, double seateRate, String brokersId, int seateAddress, String desc) {
        this.seateId = seateId;
        this.seateName = seateName;
        this.seateType = seateType;
        this.seateRate = seateRate;
        this.brokersId = brokersId;
        this.seateAddress = seateAddress;
        this.desc = desc;
    }

    public String getSeateId() {
        return seateId;
    }

    public void setSeateId(String seateId) {
        this.seateId = seateId;
    }

    public String getSeateName() {
        return seateName;
    }

    public void setSeateName(String seateName) {
        this.seateName = seateName;
    }

    public int getSeateType() {
        return seateType;
    }

    public void setSeateType(int seateType) {
        this.seateType = seateType;
    }

    public double getSeateRate() {
        return seateRate;
    }

    public void setSeateRate(double seateRate) {
        this.seateRate = seateRate;
    }

    public String getBrokersId() {
        return brokersId;
    }

    public void setBrokersId(String brokersId) {
        this.brokersId = brokersId;
    }

    public int getSeateAddress() {
        return seateAddress;
    }

    public void setSeateAddress(int seateAddress) {
        this.seateAddress = seateAddress;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Seate{" +
                "seateId='" + seateId + '\'' +
                ", seateName='" + seateName + '\'' +
                ", seateType=" + seateType +
                ", seateRate=" + seateRate +
                ", brokersId='" + brokersId + '\'' +
                ", seateAddress=" + seateAddress +
                ", desc='" + desc + '\'' +
                '}';
    }
}
