package com.yidu.businessData.pojo.Import;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;

import javax.annotation.Resource;

/**
 * 导入实体
 * @author Tmac
 * @version 1.0
 * @time 2020/9/17  20:58
 **/

/*
1、 Gddm 证券账户
        2、 Gdxm 股东姓名，新交易系统切换后，上交所会将该字段置为空格。请以中国证券登记结算有限责任公司发布的数据为准。
        3、 Bcrq 成交日期，格式为YYYYMMDD
        4 、Cjbh 成交编号
        5 、Gsdm 席位号
        6 、Cjsl 成交数量
        7 、Bcye 本次余额，新交易系统切换后，该字段被置为0。
        8、 zqdm 证券代码C6
        9、 sbsj 申报时间，格式为HHMMSS 、
        10、 cjsj 成交时间，格式为HHMMSS 、
        11、 cjjg 成交价格、
        12 、cjje 成交金额、
        13 、sqbh 会员内部订单号，同申报接口中的reff（字段4：会员内部订单号）。
        14、 bs B
        普通订单，买卖方向：买入
        S 普通订单，买卖方向：卖出
        15、 mjbh 操作员代码
*/
public class TransactionImport {
    private String gddm;//证券账户
    private String gdxm;//股东姓名
    private String Bcrq;//成交日期，格式为YYYYMMDD
    private String Cjbh;//成交编号
    private String Gsdm;//席位号
    private String Cjsl;//成交数量
    private String Bcye;//本次余额，新交易系统切换后，该字段被置为0。
    private String zqdm;//证券代码C6
    private String sbsj;//申报时间，格式为HHMMSS
    private String cjsj;//成交时间，格式为HHMMSS
    private String cjjg;//成交价格
    private String cjje;//成交金额
    private String sqbh;//会员内部订单号，同申报接口中的reff（字段4：会员内部订单号）
    private String bs;//B :普通订单，买卖方向：买入, S: 普通订单，买卖方向：卖出
    private String mjbh;//操作员代码
@Resource
    DbUtil dbUtil;

    public TransactionData getTransactionData(){
        TransactionData data = new TransactionData();
        data.setSecuritiesId(String.valueOf(this.gddm)); //证券账户
        data.setDateTime(String.valueOf(this.Bcrq)); //成交日期，格式为YYYYMMDD
        data.setSeateId(String.valueOf(this.Gsdm)); //席位号

        data.setNum(Double.valueOf(this.Cjsl));  ////成交数量
        data.setSecuritiesId(String.valueOf(this.zqdm)); //证券代码C6
        data.setPrice(Double.valueOf(this.cjjg));//成交价格
        data.setTotalSum(Double.valueOf(this.cjje));//成交金额
     /*   String sqbh = this.sqbh; //会员内部订单号，同申报接口中的reff（字段4：会员内部订单号）
        if (sqbh.equals("")){
            data.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));
        }*/
        String bs = this.bs;
        if (bs.equals("B")){
            data.setTransactionDataMode(1); //买卖方向
        }else if (bs.equals("S")){
            data.setTransactionDataMode(2);
        }
        return data;
    }

    public String getBcrq() {
        return Bcrq;
    }

    public void setBcrq(String bcrq) {
        Bcrq = bcrq;
    }

    public String getCjbh() {
        return Cjbh;
    }

    public void setCjbh(String cjbh) {
        Cjbh = cjbh;
    }

    public String getGsdm() {
        return Gsdm;
    }

    public void setGsdm(String gsdm) {
        Gsdm = gsdm;
    }

    public String getCjsl() {
        return Cjsl;
    }

    public void setCjsl(String cjsl) {
        Cjsl = cjsl;
    }

    public String getBcye() {
        return Bcye;
    }

    public void setBcye(String bcye) {
        Bcye = bcye;
    }

    public String getZqdm() {
        return zqdm;
    }

    public void setZqdm(String zqdm) {
        this.zqdm = zqdm;
    }

    public String getSbsj() {
        return sbsj;
    }

    public void setSbsj(String sbsj) {
        this.sbsj = sbsj;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getCjjg() {
        return cjjg;
    }

    public void setCjjg(String cjjg) {
        this.cjjg = cjjg;
    }

    public String getCjje() {
        return cjje;
    }

    public void setCjje(String cjje) {
        this.cjje = cjje;
    }

    public String getSqbh() {
        return sqbh;
    }

    public void setSqbh(String sqbh) {
        this.sqbh = sqbh;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getMjbh() {
        return mjbh;
    }

    public void setMjbh(String mjbh) {
        this.mjbh = mjbh;
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
