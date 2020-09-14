package com.yidu.dayDispose.pojo;

/**
 * 库存统计的TA库存统计信息保存实体类
 *date:2020/9/11
 * @Mr.Zou
 **/
public class TaInventoryEntityTwo {

    private Double total;//ta金额
    private Double num;//ta数量
    private String fundId;//基金ID

    public TaInventoryEntityTwo() {
    }

    public TaInventoryEntityTwo(Double total, Double numl, String fundId) {
        this.total = total;
        this.num = numl;
        this.fundId = fundId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getNuml() {
        return num;
    }

    public void setNuml(Double numl) {
        this.num = numl;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Override
    public String toString() {
        return "TaInventoryEntity{" +
                "total=" + total +
                ", numl=" + num +
                ", fundId='" + fundId + '\'' +
                '}';
    }
}
