package com.yidu.reportManage.pojo;

/**
 * xx类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public class FundInvestmentPlateTablePojo {
    private String value;
    private String name;

    public FundInvestmentPlateTablePojo() {
    }

    public FundInvestmentPlateTablePojo(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return "fundInvestmentPlateTablePojo{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
