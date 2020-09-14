package com.yidu.dayDispose.pojo;


/*
* 资产估值检测估值是否处理实体类
* @author wufeiyun
* @Date 2020-9-12 22：26
*
* */
public class ValuationProcessing {
    private String status;
    private int statusNumber;
    private String dateTime;
    private String statusName;
    public ValuationProcessing() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusNumber() {
        return statusNumber;
    }

    public void setStatusNumber(int statusNumber) {
        this.statusNumber = statusNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "ValuationProcessing{" +
                "status='" + status + '\'' +
                ", statusNumber=" + statusNumber +
                ", dateTime='" + dateTime + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }

    public ValuationProcessing(String status, int statusNumber, String dateTime, String statusName) {
        this.status = status;
        this.statusNumber = statusNumber;
        this.dateTime = dateTime;
        this.statusName = statusName;
    }
}
