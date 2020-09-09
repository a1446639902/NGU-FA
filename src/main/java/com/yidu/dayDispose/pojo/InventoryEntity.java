package com.yidu.dayDispose.pojo;

/**
 * 库存统计的实体类
 * @Mr.Zou
 * date:2020/9/9
 **/
public class InventoryEntity {

    private int invId;//根据此id来确定统计的库存
    private String inventoryName;//库存名称
    private String inventoryId;//库存Id
    private String inventoryOperator;//操作员
    private String inventoryDate;//统计日期
    private int inventoryData;//已统计数据
    private String inventoryStatis;//统计结果  未统计不显示 统计完将状态修改为已统计

    public InventoryEntity() {
    }

    public InventoryEntity(int invId, String inventoryName, String inventoryId, String inventoryOperator, String inventoryDate, int inventoryData, String inventoryStatis) {
        this.invId = invId;
        this.inventoryName = inventoryName;
        this.inventoryId = inventoryId;
        this.inventoryOperator = inventoryOperator;
        this.inventoryDate = inventoryDate;
        this.inventoryData = inventoryData;
        this.inventoryStatis = inventoryStatis;
    }

    @Override
    public String toString() {
        return "InventoryEntity{" +
                "invId=" + invId +
                ", inventoryName='" + inventoryName + '\'' +
                ", inventoryId='" + inventoryId + '\'' +
                ", inventoryOperator='" + inventoryOperator + '\'' +
                ", inventoryDate='" + inventoryDate + '\'' +
                ", inventoryData=" + inventoryData +
                ", inventoryStatis='" + inventoryStatis + '\'' +
                '}';
    }

    public int getInvId() {
        return invId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryOperator() {
        return inventoryOperator;
    }

    public void setInventoryOperator(String inventoryOperator) {
        this.inventoryOperator = inventoryOperator;
    }

    public String getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(String inventoryDate) {
        this.inventoryDate = inventoryDate;
    }

    public int getInventoryData() {
        return inventoryData;
    }

    public void setInventoryData(int inventoryData) {
        this.inventoryData = inventoryData;
    }

    public String getInventoryStatis() {
        return inventoryStatis;
    }

    public void setInventoryStatis(String inventoryStatis) {
        this.inventoryStatis = inventoryStatis;
    }
}
