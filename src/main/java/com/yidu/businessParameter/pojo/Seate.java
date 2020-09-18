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
    private String seateTypeString;
    private double seateRate;//佣金费 年利率？/100
    private String brokersId;//券商编号  Fk  券商编号id  来自券商信息表（brokers）
    private String brokersName;//券商名称    来自券商信息表（brokers）
    private int seateAddress;//1=上海  2=深圳
    private String seateAddressString;
    private String seateDesc;//备注
    public Seate(){}

    public Seate(String seateId, String seateName, int seateType, String seateTypeString, double seateRate, String brokersId, String brokersName, int seateAddress, String seateAddressString, String seateDesc) {
        this.seateId = seateId;
        this.seateName = seateName;
        this.seateType = seateType;
        this.seateTypeString = seateTypeString;
        this.seateRate = seateRate;
        this.brokersId = brokersId;
        this.brokersName = brokersName;
        this.seateAddress = seateAddress;
        this.seateAddressString = seateAddressString;
        this.seateDesc = seateDesc;
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

    public String getSeateTypeString() {
        return seateTypeString;
    }

    public void setSeateTypeString(String seateTypeString) {
        this.seateTypeString = seateTypeString;
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

    public String getBrokersName() {
        return brokersName;
    }

    public void setBrokersName(String brokersName) {
        this.brokersName = brokersName;
    }

    public int getSeateAddress() {
        return seateAddress;
    }

    public void setSeateAddress(int seateAddress) {
        this.seateAddress = seateAddress;
    }

    public String getSeateAddressString() {
        return seateAddressString;
    }

    public void setSeateAddressString(String seateAddressString) {
        this.seateAddressString = seateAddressString;
    }

    public String getSeateDesc() {
        return seateDesc;
    }

    public void setSeateDesc(String seateDesc) {
        this.seateDesc = seateDesc;
    }

    @Override
    public String toString() {
        return "Seate{" +
                "seateId='" + seateId + '\'' +
                ", seateName='" + seateName + '\'' +
                ", seateType=" + seateType +
                ", seateTypeString='" + seateTypeString + '\'' +
                ", seateRate=" + seateRate +
                ", brokersId='" + brokersId + '\'' +
                ", brokersName='" + brokersName + '\'' +
                ", seateAddress=" + seateAddress +
                ", seateAddressString='" + seateAddressString + '\'' +
                ", seateDesc='" + seateDesc + '\'' +
                '}';
    }
}
