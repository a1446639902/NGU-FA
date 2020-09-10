package com.yidu.permission.pojo;

/**
 * 托管人实体类
 */
public class Trustee {
    private String trusteeId;       //托管人id
    private String trusteeName;     //托管人名字
    private String trusteeAddress;  //托管人地址
    private String trusteeCompany;  //托管公司
    private String trusteePhone;    //电话
    private double trusteeFee;     //托管费率
    private String trusteeDesc;    //备注

    public Trustee() {
    }

    public Trustee(String trusteeId, String trusteeName, String trusteeAddress, String trusteeCompany, String trusteePhone, double trusteeFee, String trusteeDesc) {
        this.trusteeId = trusteeId;
        this.trusteeName = trusteeName;
        this.trusteeAddress = trusteeAddress;
        this.trusteeCompany = trusteeCompany;
        this.trusteePhone = trusteePhone;
        this.trusteeFee = trusteeFee;
        this.trusteeDesc = trusteeDesc;
    }

    public String getTrusteeId() {
        return trusteeId;
    }

    public void setTrusteeId(String trusteeId) {
        this.trusteeId = trusteeId;
    }

    public String getTrusteeName() {
        return trusteeName;
    }

    public void setTrusteeName(String trusteeName) {
        this.trusteeName = trusteeName;
    }

    public String getTrusteeAddress() {
        return trusteeAddress;
    }

    public void setTrusteeAddress(String trusteeAddress) {
        this.trusteeAddress = trusteeAddress;
    }

    public String getTrusteeCompany() {
        return trusteeCompany;
    }

    public void setTrusteeCompany(String trusteeCompany) {
        this.trusteeCompany = trusteeCompany;
    }

    public String getTrusteePhone() {
        return trusteePhone;
    }

    public void setTrusteePhone(String trusteePhone) {
        this.trusteePhone = trusteePhone;
    }

    public double getTrusteeFee() {
        return trusteeFee;
    }

    public void setTrusteeFee(double trusteeFee) {
        this.trusteeFee = trusteeFee;
    }

    public String getTrusteeDesc() {
        return trusteeDesc;
    }

    public void setTrusteeDesc(String trusteeDesc) {
        this.trusteeDesc = trusteeDesc;
    }

    @Override
    public String toString() {
        return "Trustee{" +
                "trusteeId='" + trusteeId + '\'' +
                ", trusteeName='" + trusteeName + '\'' +
                ", trusteeAddress='" + trusteeAddress + '\'' +
                ", trusteeCompany='" + trusteeCompany + '\'' +
                ", trusteePhone='" + trusteePhone + '\'' +
                ", trusteeFee=" + trusteeFee +
                ", trusteeDesc='" + trusteeDesc + '\'' +
                '}';
    }
}
