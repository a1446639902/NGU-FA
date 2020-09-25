package com.yidu.reportManage.controller;

import com.yidu.dayDispose.pojo.NetValueOfStatisticalPojo;
import com.yidu.permission.aspect.NGULog;
import com.yidu.reportManage.pojo.FundInvestmentPlateTablePojo;
import com.yidu.reportManage.service.FundPortfolioStatementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基金组合投资表控制类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@RestController
@RequestMapping("/select")
public class FundPortfolioStatementController {
    @Resource
    FundPortfolioStatementService fundPortfolioStatementService;

    @NGULog(message = "查看基金组合投资表")
    @RequestMapping("/selectGuPiao")
    public Map<String, Object> selectGuPiao(String dateTimes) {
        //设置小数保留位数
        DecimalFormat df = new DecimalFormat("0.0000");

        System.out.println("从页面拿到的时间是" + dateTimes);
        if (dateTimes == null) {
            dateTimes = "2020-09-10";
        }
        //查询当日值产净值
        List<NetValueOfStatisticalPojo> jingzhiList = fundPortfolioStatementService.selectZiChanJingZhi(dateTimes);
        String ziChanJingZhi = "";
        for (NetValueOfStatisticalPojo value : jingzhiList) {
            ziChanJingZhi = value.getMarketValue();
            System.out.println("查询当日值产净值" + ziChanJingZhi);
        }
        double doubleZiChanJingZhi = Double.parseDouble(ziChanJingZhi);
        System.out.println("查询当日值产净值" + doubleZiChanJingZhi);
        //查询债券
        //查询债券的总成本
        Double zhaiQuanAll = 0.00;
        List<NetValueOfStatisticalPojo> ZhaiQuanList = fundPortfolioStatementService.selectZhaiQuan(dateTimes);
        for (NetValueOfStatisticalPojo value : ZhaiQuanList) {
            String cost = value.getCost();
            double zhaiQuan = Double.parseDouble(cost);
            zhaiQuanAll += zhaiQuan;
        }
        //查询股票
        //查询债券的总成本
        Double guPiaoAll = 0.00;
        List<NetValueOfStatisticalPojo> GuPiaoList = fundPortfolioStatementService.selectGuPiao(dateTimes);
        for (NetValueOfStatisticalPojo value : GuPiaoList) {
            String cost = value.getCost();
            double guPiao = Double.parseDouble(cost);
            guPiaoAll += guPiao;
        }
        //合并查询出来的两个集合
        for (NetValueOfStatisticalPojo value : GuPiaoList) {
            ZhaiQuanList.add(value);
        }

        //设置所占比列
        for (NetValueOfStatisticalPojo value : ZhaiQuanList) {
            //获得成本
            String cost = value.getCost();
            double doubleCost = Double.parseDouble(cost);
            //获得市值
            String marketValue = value.getMarketValue();
            double doubleMarketValue = Double.parseDouble(marketValue);
            //设置成本占净值的百分比
            value.setChengBenBaiFenBi(df.format((doubleCost / doubleZiChanJingZhi) * 100));
            //设置市值占净值的百分比
            value.setShiZhiBaiFenBi(df.format((doubleMarketValue / doubleZiChanJingZhi) * 100));
        }
        //新建一个NetValueOfStatisticalPojo对象，用于储存资产类合计的参数
        NetValueOfStatisticalPojo netValueOfStatisticalPojo = new NetValueOfStatisticalPojo();
        //设置ProjectName
        netValueOfStatisticalPojo.setProjectName("股票投资合计");
        //设置MarketValue
        netValueOfStatisticalPojo.setMarketValue(guPiaoAll + "");

        //新建一个NetValueOfStatisticalPojo对象，用于储存资产类合计的参数
        NetValueOfStatisticalPojo netValueOfStatisticalPojoDemoOne = new NetValueOfStatisticalPojo();
        //设置ProjectName
        netValueOfStatisticalPojoDemoOne.setProjectName("债券投资合计");
        //设置MarketValue
        netValueOfStatisticalPojoDemoOne.setMarketValue(zhaiQuanAll + "");

        //新建一个NetValueOfStatisticalPojo对象，用于储存资产类合计的参数
        NetValueOfStatisticalPojo netValueOfStatisticalPojoDemoTwo = new NetValueOfStatisticalPojo();
        //设置ProjectName
        netValueOfStatisticalPojoDemoTwo.setProjectName("证券投资合计");
        //设置MarketValue
        netValueOfStatisticalPojoDemoTwo.setMarketValue((zhaiQuanAll + guPiaoAll) + "");

        //查询负债
        List<NetValueOfStatisticalPojo> fuZhaiList = fundPortfolioStatementService.selectFuZhai(dateTimes);
        String fuZhai = "";
        for (NetValueOfStatisticalPojo value : fuZhaiList) {
             fuZhai = value.getMarketValue();
        }
        //资产类合计
        DecimalFormat dnf = new DecimalFormat("#.00");
        Double All = Double.parseDouble(fuZhai) + doubleZiChanJingZhi;
        String format = dnf.format(All);
        //新建一个NetValueOfStatisticalPojo对象，用于储存资产类合计的参数
        NetValueOfStatisticalPojo netValueOfStatisticalPojoDemoFive = new NetValueOfStatisticalPojo();
        //设置ProjectName
        netValueOfStatisticalPojoDemoFive.setProjectName("资产类合计");
        //设置MarketValue
        netValueOfStatisticalPojoDemoFive.setMarketValue(format);

        //新建一个NetValueOfStatisticalPojo对象，用于负债的参数
        NetValueOfStatisticalPojo netValueOfStatisticalPojoDemoThere = new NetValueOfStatisticalPojo();
        //设置ProjectName
        netValueOfStatisticalPojoDemoThere.setProjectName("负债");
        //设置MarketValue
        netValueOfStatisticalPojoDemoThere.setMarketValue(fuZhai);

        //基金净值
        //新建一个NetValueOfStatisticalPojo对象，用于基金净值的参数
        NetValueOfStatisticalPojo netValueOfStatisticalPojoDemoSix = new NetValueOfStatisticalPojo();
        //设置ProjectName
        netValueOfStatisticalPojoDemoSix.setProjectName("基金净值");
        //设置MarketValue
        String format1 = dnf.format(doubleZiChanJingZhi);
        netValueOfStatisticalPojoDemoSix.setMarketValue(format1);

        //将赋值完毕的对象放入集合中
        ZhaiQuanList.add(netValueOfStatisticalPojo);
        ZhaiQuanList.add(netValueOfStatisticalPojoDemoOne);
        ZhaiQuanList.add(netValueOfStatisticalPojoDemoTwo);
        ZhaiQuanList.add(netValueOfStatisticalPojoDemoFive);
        ZhaiQuanList.add(netValueOfStatisticalPojoDemoThere);
        ZhaiQuanList.add(netValueOfStatisticalPojoDemoSix);

        Map<String, Object> map = new HashMap();
        //资产合计
        //响应头
        map.put("msg", "");
        map.put("code", 0);
        map.put("count", 10);
        map.put("data", ZhaiQuanList);
        System.out.println(ZhaiQuanList);
        return map;
    }

    @NGULog(message = "查看基金组合板块表(饼状图)")
    @RequestMapping("/selectRound")
    public List selectRound(String myDate) {
        System.out.println("从页面接收到的时间是" + myDate);
        if (myDate == null || myDate == ""){
            myDate = "2020-09-10";
        }
        System.out.println("时间是" + myDate);
        ArrayList arrayList = new ArrayList();
        List<NetValueOfStatisticalPojo> zhaiQuanList = fundPortfolioStatementService.selectZhaiQuan(myDate);
        List<NetValueOfStatisticalPojo> guPiaoList = fundPortfolioStatementService.selectGuPiao(myDate);
        for (NetValueOfStatisticalPojo value : guPiaoList) {
            zhaiQuanList.add(value);
        }
        for (NetValueOfStatisticalPojo value : zhaiQuanList) {
            FundInvestmentPlateTablePojo fundInvestmentPlateTablePojo = new FundInvestmentPlateTablePojo();
            fundInvestmentPlateTablePojo.setName(value.getProjectName());
            fundInvestmentPlateTablePojo.setValue(value.getMarketValue());
            arrayList.add(fundInvestmentPlateTablePojo);
        }
        System.out.println("饼状图要用的集合是" + arrayList);
        return arrayList;
    }
}
