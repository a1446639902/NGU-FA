package com.yidu.dayDispose.pojo;

/**
 * 证券统计之现金库存统计完数据的实体类
 * @Mr.Zou
 **/
public class CaInventoryEntity {


    private Double sumCa;


    public CaInventoryEntity() {
    }

    @Override
    public String toString() {
        return "CaInventoryMapper{" +
                "sumCa=" + sumCa +
                '}';
    }

    public CaInventoryEntity(Double sumCa) {
        this.sumCa = sumCa;
    }

    public Double getSumCa() {
        return sumCa;
    }

    public void setSumCa(Double sumCa) {
        this.sumCa = sumCa;
    }
}
