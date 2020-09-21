package com.yidu.dayDispose.pojo;

/**
 * 记录条数的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public class CountPojo {
    private int intCount=0;

    public CountPojo(int intCount) {
        this.intCount = intCount;
    }

    public CountPojo() {
    }

    public int getIntCount() {
        return intCount;
    }

    public void setIntCount(int intCount) {
        this.intCount = intCount;
    }

    @Override
    public String toString() {
        return "CountPojo{" +
                "intCount=" + intCount +
                '}';
    }
}
