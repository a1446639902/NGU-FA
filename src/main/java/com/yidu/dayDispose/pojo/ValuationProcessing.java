package com.yidu.dayDispose.pojo;


/*
* 资产估值检测估值是否处理实体类
* @author wufeiyun
* @Date 2020-9-12 22：26
*
* */
public class ValuationProcessing {
    private String status;
    private String statusName;
    public ValuationProcessing() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public ValuationProcessing(String status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "ValuationProcessing{" +
                "status='" + status + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
