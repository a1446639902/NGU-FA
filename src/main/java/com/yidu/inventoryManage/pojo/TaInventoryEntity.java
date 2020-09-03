package com.yidu.inventoryManage.pojo;

/**
 * Ta库存的实体类
 * @Mr.Zou
 * date：2020/9/2
 */
public class TaInventoryEntity {

   String taInventoryId;// TA库存Id
   String fundId;// 基金Id来自基金表
   double tanum;// Ta数量
   double tatotal;// 现金余额
   String dateTime;// 统计日期
   double securityPeriodFlag;// 是否从其他系统导入的期初数据  0：不是  1：是
   String taInventorydesc;// 备注
   String fundName;// 基金名称

   public TaInventoryEntity() {
   }

   public TaInventoryEntity(String taInventoryId, String fundId, double tanum, double tatotal, String dateTime, double securityPeriodFlag, String taInventorydesc, String fundName) {
      this.taInventoryId = taInventoryId;
      this.fundId = fundId;
      this.tanum = tanum;
      this.tatotal = tatotal;
      this.dateTime = dateTime;
      this.securityPeriodFlag = securityPeriodFlag;
      this.taInventorydesc = taInventorydesc;
      this.fundName = fundName;
   }

   @Override
   public String toString() {
      return "TaInventoryEntity{" +
              "taInventoryId='" + taInventoryId + '\'' +
              ", fundId='" + fundId + '\'' +
              ", tanum=" + tanum +
              ", tatotal=" + tatotal +
              ", dateTime='" + dateTime + '\'' +
              ", securityPeriodFlag=" + securityPeriodFlag +
              ", taInventorydesc='" + taInventorydesc + '\'' +
              ", fundName='" + fundName + '\'' +
              '}';
   }

   public String getTaInventoryId() {
      return taInventoryId;
   }

   public void setTaInventoryId(String taInventoryId) {
      this.taInventoryId = taInventoryId;
   }

   public String getFundId() {
      return fundId;
   }

   public void setFundId(String fundId) {
      this.fundId = fundId;
   }

   public double getTanum() {
      return tanum;
   }

   public void setTanum(double tanum) {
      this.tanum = tanum;
   }

   public double getTatotal() {
      return tatotal;
   }

   public void setTatotal(double tatotal) {
      this.tatotal = tatotal;
   }

   public String getDateTime() {
      return dateTime;
   }

   public void setDateTime(String dateTime) {
      this.dateTime = dateTime;
   }

   public double getSecurityPeriodFlag() {
      return securityPeriodFlag;
   }

   public void setSecurityPeriodFlag(double securityPeriodFlag) {
      this.securityPeriodFlag = securityPeriodFlag;
   }

   public String getTaInventorydesc() {
      return taInventorydesc;
   }

   public void setTaInventorydesc(String taInventorydesc) {
      this.taInventorydesc = taInventorydesc;
   }

   public String getFundName() {
      return fundName;
   }

   public void setFundName(String fundName) {
      this.fundName = fundName;
   }
}
