package com.yidu.permission.pojo;

/**
 * 管理人实体类
 */
public class Manager {
    private String managerId;           //管理人Id
    private String managerName;         //管理人名称
    private String managerAddress;     //管理人地址
    private String managerCompany;     //所在公司
    private String managerPhone;       //管理人电话
    private double managerFee;       //管理费率
    private String managerDesc;       //备注

    public Manager() {
    }

    public Manager(String managerId, String managerName, String managerAddress, String managerCompany, String managerPhone, double managerFee, String managerDesc) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerAddress = managerAddress;
        this.managerCompany = managerCompany;
        this.managerPhone = managerPhone;
        this.managerFee = managerFee;
        this.managerDesc = managerDesc;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerAddress() {
        return managerAddress;
    }

    public void setManagerAddress(String managerAddress) {
        this.managerAddress = managerAddress;
    }

    public String getManagerCompany() {
        return managerCompany;
    }

    public void setManagerCompany(String managerCompany) {
        this.managerCompany = managerCompany;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public double getManagerFee() {
        return managerFee;
    }

    public void setManagerFee(double managerFee) {
        this.managerFee = managerFee;
    }

    public String getManagerDesc() {
        return managerDesc;
    }

    public void setManagerDesc(String managerDesc) {
        this.managerDesc = managerDesc;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerAddress='" + managerAddress + '\'' +
                ", managerCompany='" + managerCompany + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerFee='" + managerFee + '\'' +
                ", managerDesc='" + managerDesc + '\'' +
                '}';
    }
}
