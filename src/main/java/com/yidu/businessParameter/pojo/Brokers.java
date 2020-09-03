package com.yidu.businessParameter.pojo;

/**
 * @name 戴言露
 * @data 2020/9/1 am
 * 券商信息表
 */
public class Brokers {
    private String brokersId;            //券商编号 主键
    private String brokersName;          //券商名称
    private String brokersInstructions;  //说明
    private String brokersDesc;                 //备注
    public Brokers(){}

    public Brokers(String brokersId, String brokersName, String brokersInstructions, String brokersDesc) {
        this.brokersId = brokersId;
        this.brokersName = brokersName;
        this.brokersInstructions = brokersInstructions;
        this.brokersDesc = brokersDesc;
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

    public String getBrokersInstructions() {
        return brokersInstructions;
    }

    public void setBrokersInstructions(String brokersInstructions) {
        this.brokersInstructions = brokersInstructions;
    }

    public String getBrokersDesc() {
        return brokersDesc;
    }

    public void setBrokersDesc(String brokersDesc) {
        this.brokersDesc = brokersDesc;
    }

    @Override
    public String toString() {
        return "Brokers{" +
                "brokersId='" + brokersId + '\'' +
                ", brokersName='" + brokersName + '\'' +
                ", brokersInstructions='" + brokersInstructions + '\'' +
                ", desc='" + brokersDesc + '\'' +
                '}';
    }
}
