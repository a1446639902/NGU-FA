package com.yidu.businessData.pojo.Import;

import com.yidu.businessData.pojo.TransactionData;

/**
 * 导入实体
 * @author Tmac
 * @version 1.0
 * @time 2020/9/17  20:58
 **/
public class TransactionImport {
    private String gddm;//证券账户
    private String gdxm;//股东姓名

    public TransactionData getTransactionData(){
        TransactionData data = new TransactionData();
        data.setSecuritiesId(this.gddm);

        return data;
    }

    public String getGddm() {
        return gddm;
    }

    public void setGddm(String gddm) {
        this.gddm = gddm;
    }

    public String getGdxm() {
        return gdxm;
    }

    public void setGdxm(String gdxm) {
        this.gdxm = gdxm;
    }
}
