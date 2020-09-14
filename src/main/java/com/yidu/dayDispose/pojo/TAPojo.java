package com.yidu.dayDispose.pojo;

/**
 * ta库存数量的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public class TAPojo {
    private Double TaNum;

    public TAPojo(Double taNum) {
        TaNum = taNum;
    }

    public Double getTaNum() {
        return TaNum;
    }

    public void setTaNum(Double taNum) {
        TaNum = taNum;
    }

    @Override
    public String toString() {
        return "TAPojo{" +
                "TaNum=" + TaNum +
                '}';
    }
}

