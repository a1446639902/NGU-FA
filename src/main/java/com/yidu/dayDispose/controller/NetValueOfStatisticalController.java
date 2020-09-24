package com.yidu.dayDispose.controller;

import com.yidu.dayDispose.pojo.*;
import com.yidu.dayDispose.service.NetValueOfStatisticalService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 净值统计的控制类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@RestController
@RequestMapping("/netValueOfStatistical")
public class NetValueOfStatisticalController {
    @Resource
    NetValueOfStatisticalService netValueOfStatisticalService;

    @NGULog(message = "基金净值统计功能")
    @RequestMapping("/selectNetValueOfStatisticalController")
    @ResponseBody
    public Map<String, Object> selectNetValueOfStatisticalController(String time, HttpServletRequest request) {
        Double zhaiQuanLiXi = 0.00;
        Double xianJinLiXi = 0.00;
        Double statisticalService = 0.00;
        Double AdministrativeFee = 0.00;
        Double trusteeFee = 0.00;
        Double statisticalServices = 0.00;
        int zhaiQuan = 0;
        int guPiao = 0;
        //设置保留小数,每三位用逗号隔开
        DecimalFormat df = new DecimalFormat("#,###.00");

        //查询其他表格净值统计需要的数据
        System.out.println("从页面传递过来的时间是" + time);
        //先删后增
        int i1 = netValueOfStatisticalService.deleteNetValueOfStatisticalToDay(time);
        System.out.println("删除的当日的行数为" + i1);
        List<SelectAllMsgPojo> selectAllMsgList = netValueOfStatisticalService.selectAllMsg(time);
        System.out.println("查询其他表格净值统计需要的数据是" + selectAllMsgList);
        //创建实体类用于传递参数
        NetValueOfStatisticalPojo netValueOfStatisticalPojo = new NetValueOfStatisticalPojo();
        //通过工具类获得fundId(基金id)
        String fundId = GetFundIdUtil.getFundId(request);
        //设置基金id
        netValueOfStatisticalPojo.setFundId(fundId);
        //创建树形结构一级结构
        int i = 0;
        CountPojo countPojo = new CountPojo();
        int count = countPojo.getIntCount();
        System.out.println("count计数的条数·" + count);
        //统计日期
        netValueOfStatisticalPojo.setValueStatisticsDate(time);
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);
        //获得项目编号
        int projectId = netValueOfStatisticalPojo.getProjectId();
        //项目名称
        netValueOfStatisticalPojo.setProjectName("证券");
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(0);
        int j = netValueOfStatisticalService.insertTree(netValueOfStatisticalPojo);
        System.out.println("创建的树形一级结构数量为" + j);

        //创建树形结构二级结构-股票
        //统计日期
        netValueOfStatisticalPojo.setValueStatisticsDate(time);
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);
        //项目名称
        netValueOfStatisticalPojo.setProjectName("股票");
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(projectId);
        int k = netValueOfStatisticalService.insertTree(netValueOfStatisticalPojo);
        System.out.println("创建的树形二级结构股票数量为" + k);

        //拿到股票数据增加进净值统计表
        Double guPiaoShiZhis = 0.00;
        Double guPiaos = 0.00;
        for (SelectAllMsgPojo value : selectAllMsgList) {
            System.out.println("查询出来的股票的信息" + value);
            int valuation = value.getSecuritiesNum() * value.getClosingPrice() - value.getTotal();
            System.out.println("估值增值的价格是" + valuation);
            String Strvaluation = valuation + "";
            //统计日期
            netValueOfStatisticalPojo.setValueStatisticsDate(time);
            //项目编号
            netValueOfStatisticalPojo.setProjectId(++count);
            //项目名称
            netValueOfStatisticalPojo.setProjectName(value.getSecuritiesName());
            //项目代码/账户号
            netValueOfStatisticalPojo.setProjectCode((value.getSecuritiesId()));
            //持有数量
            //设置保留小数，每三位用逗号隔开
            String format14 = df.format(value.getSecuritiesNum());
            netValueOfStatisticalPojo.setQuantityint(format14);
            //行情
            //设置保留小数，每三位用逗号隔开
            String format15 = df.format(value.getClosingPrice());
            netValueOfStatisticalPojo.setPeice(format15);
            //成本
            //设置保留小数，每三位用逗号隔开
            String format16 = df.format(value.getTotal());
            netValueOfStatisticalPojo.setCost(format16);
            //市值
            //设置保留小数，每三位用逗号隔开
            String format17 = df.format(value.getSecuritiesNum() * value.getClosingPrice());
            netValueOfStatisticalPojo.setMarketValue(format17);
            double guPiaoShiZhi = (value.getSecuritiesNum() * value.getClosingPrice());
            guPiaoShiZhis += guPiaoShiZhi;
            //估值增值
            guPiao = Integer.parseInt(Strvaluation);
            //设置保留小数，每三位用逗号隔开
            String format18 = df.format(guPiao);
            netValueOfStatisticalPojo.setValuation(format18);
            guPiaos += guPiao;
            //父项目编号
            netValueOfStatisticalPojo.setProjectFatherId(2);
            System.out.println(netValueOfStatisticalPojo);
            i = netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);
        }
        System.out.println("拿到数据增加进净值统计表的条数为" + i);

        //创建树形结构二级结构-债券
        //统计日期
        netValueOfStatisticalPojo.setValueStatisticsDate(time);
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);
        //项目名称
        netValueOfStatisticalPojo.setProjectName("债券");
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(projectId);
        int d = netValueOfStatisticalService.insertTree(netValueOfStatisticalPojo);
        System.out.println("创建的树形二级结构债券数量为" + d);

        //查询证券中债券的数据
        List<SelectAllMsgDemoOnePojo> netValueOfStatisticalPojoList2 = netValueOfStatisticalService.selectAllMsgTwo(time);
        System.out.println("查询出来的债券的信息" + netValueOfStatisticalPojoList2);
        int countDemoOne = count;
        //拿到债券数据增加进净值统计表
        int zhaiQuanShiZhis = 0;
        int zhaiQuans = 0;
        for (SelectAllMsgDemoOnePojo value : netValueOfStatisticalPojoList2) {
            int valuation = value.getSecuritiesNum() * value.getClosingPrice() - value.getTotal();
            System.out.println("估值增值的价格是" + valuation);
            String Strvaluation = valuation + "";
            //项目编号
            netValueOfStatisticalPojo.setProjectId(++count);
            //项目名称
            netValueOfStatisticalPojo.setProjectName(value.getBondName());
            //项目代码/账户号
            netValueOfStatisticalPojo.setProjectCode((value.getSecuritiesId()));
            //持有数量
            //设置保留小数，每三位用逗号隔开
            String format9 = df.format(value.getSecuritiesNum());
            netValueOfStatisticalPojo.setQuantityint(format9);
            //行情
            //设置保留小数，每三位用逗号隔开
            String format10 = df.format(value.getClosingPrice());
            netValueOfStatisticalPojo.setPeice(format10);
            //成本
            //设置保留小数，每三位用逗号隔开
            String format11 = df.format(value.getTotal());
            netValueOfStatisticalPojo.setCost(format11);
            //市值
            //设置保留小数，每三位用逗号隔开
            double sum = value.getSecuritiesNum() * value.getClosingPrice();
            String format12 = df.format(sum);
            netValueOfStatisticalPojo.setMarketValue(format12);
            int zhaiQuanShiZhi = (value.getSecuritiesNum() * value.getClosingPrice());
            zhaiQuanShiZhis += zhaiQuanShiZhi;
            //估值增值
            zhaiQuan = Integer.parseInt(Strvaluation);
            //设置保留小数，每三位用逗号隔开
            String format13 = df.format(zhaiQuan);
            netValueOfStatisticalPojo.setValuation(format13);
            zhaiQuans += zhaiQuan;
            //父项目编号
            netValueOfStatisticalPojo.setProjectFatherId(countDemoOne);
            System.out.println(netValueOfStatisticalPojo);
            netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);
        }

        //创建树形结构二级结构-现金
        //统计日期
        netValueOfStatisticalPojo.setValueStatisticsDate(time);             //时间
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);                    //id
        //项目名称
        netValueOfStatisticalPojo.setProjectName("现金");                   //名称
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(0);                    //父id
        d = netValueOfStatisticalService.insertTree(netValueOfStatisticalPojo);
        System.out.println("创建的树形二级结构债券数量为" + d);

        //查询现金的数据
        List<CashBlancePojo> netValueOfStatisticalPojoList3 = netValueOfStatisticalService.selectCashBlance(time);
        System.out.println("查询出来的现金的信息" + netValueOfStatisticalPojoList3);
        int countDemoTwo = count;
        int countDemoThere = 0;
        int p = 0;
        //拿到现金数据增加进净值统计表
        int cashBlances = 0;
        Double xianJinLiXis = 0.00;
        for (CashBlancePojo value : netValueOfStatisticalPojoList3) {
            //项目编号
            netValueOfStatisticalPojo.setProjectId(++count);
            //项目名称
            netValueOfStatisticalPojo.setProjectName(value.getAccountName());
            //项目代码/账户号
            netValueOfStatisticalPojo.setProjectCode((value.getBlankCardCode()));
            //市值
            //利息(估值增值)
            //设置保留小数，每三位用逗号隔开
            String format8 = df.format(value.getCashBlance());
            netValueOfStatisticalPojo.setMarketValue(format8);
            int cashBlance = value.getCashBlance();
            cashBlances += cashBlance;
            //估值增值
            netValueOfStatisticalPojo.setValuation("");
            //持有数量
            netValueOfStatisticalPojo.setQuantityint("");
            //行情
            netValueOfStatisticalPojo.setPeice("");
            //成本
            netValueOfStatisticalPojo.setCost("");
            //父项目编号
            netValueOfStatisticalPojo.setProjectFatherId(countDemoTwo);
            System.out.println(netValueOfStatisticalPojo);
            p = netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);

            //通过银行卡号查询利息，返回所有银行卡利息的集合
            List<ServiceTypePojo> AmountList = netValueOfStatisticalService.selectAmount(time,netValueOfStatisticalPojo.getProjectCode());
            System.out.println("所有利息的集合是" + AmountList);
            //将利息插入净值统计的数据中
            countDemoThere = count;

            for (ServiceTypePojo Amount : AmountList) {
                //项目编号
                netValueOfStatisticalPojo.setProjectId(++count);
                //利息(估值增值)
                //设置保留小数，每三位用逗号隔开
                String format7 = df.format(Amount.getAmount());
                netValueOfStatisticalPojo.setMarketValue(format7);
                System.out.println("计算出的利息是" + Amount.getAmount() + "");
                //计算利息总和
                xianJinLiXi = Amount.getAmount();
                xianJinLiXis += xianJinLiXi;
                //父项目编号
                netValueOfStatisticalPojo.setProjectFatherId(countDemoThere);
                //项目名称
                netValueOfStatisticalPojo.setProjectName("利息");
                //银行卡号
                netValueOfStatisticalPojo.setProjectCode(Amount.getBlankCardCode());
                System.out.println("查询利息的银行卡号id是" + Amount.getBlankCardCode());
                //持有数量
                netValueOfStatisticalPojo.setQuantityint("");
                //行情
                netValueOfStatisticalPojo.setPeice("");
                //成本
                netValueOfStatisticalPojo.setCost("");
                netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);
                System.out.println("计算利息的对象为" + netValueOfStatisticalPojo);
            }
        }
        //查询债券利息
        List<NetFinalPojo> selectNetBondInterestList = netValueOfStatisticalService.selectNetBondInterest(time);
        int zhaiQuanLiXis = 0;
        for (NetFinalPojo value0 : selectNetBondInterestList) {
            //利息(估值增值)
            netValueOfStatisticalPojo.setMarketValue(value0.getTotalMoney() + "");
            zhaiQuanLiXi = value0.getTotalPrice();
            zhaiQuanLiXis += zhaiQuanLiXi;
        }
        //项目名称
        netValueOfStatisticalPojo.setProjectName("债券利息");
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(countDemoThere);
        //项目代码/账户号
        netValueOfStatisticalPojo.setProjectCode("");
        //将债权利息整合成为一条数据
        //设置保留小数，每三位用逗号隔开
        String format6 = df.format(zhaiQuanLiXis);
        netValueOfStatisticalPojo.setMarketValue(format6);
        netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);
        //查询托管费
        List<NetFinalPojo> trusteeFeeList = netValueOfStatisticalService.selectTrusteeFee(time);
        System.out.println("查询托管费"+trusteeFeeList);
        for (NetFinalPojo value1 : trusteeFeeList) {
            //项目名称
            netValueOfStatisticalPojo.setProjectName("托管费");
            //项目编号
            netValueOfStatisticalPojo.setProjectId(++count);
            //父项目编号
            netValueOfStatisticalPojo.setProjectFatherId(countDemoThere);
            //利息(估值增值)
            //设置保留小数，每三位用逗号隔开
            String format5 = df.format(value1.getTotalMoney());
            netValueOfStatisticalPojo.setMarketValue(format5);
            trusteeFee = value1.getTotalMoney();
            netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);
        }

        //查询管理费
        List<NetFinalPojo> administrativeFeeList = netValueOfStatisticalService.selectAdministrativeFee(time);
        for (NetFinalPojo value2 : administrativeFeeList) {
            //项目名称
            netValueOfStatisticalPojo.setProjectName("管理费");
            //项目编号
            netValueOfStatisticalPojo.setProjectId(++count);
            //父项目编号
            netValueOfStatisticalPojo.setProjectFatherId(countDemoThere);
            //利息(估值增值)
            //设置保留小数，每三位用逗号隔开
            String format4 = df.format(value2.getTotalMoney());
            netValueOfStatisticalPojo.setMarketValue(format4);
            AdministrativeFee = value2.getTotalMoney();
            netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);
        }

        //查询证券清算款
        List<SecuritiesClearingAccountPojo> securitiesClearingAccountList = netValueOfStatisticalService.securitiesClearingAccount(time);
        for (SecuritiesClearingAccountPojo value3 : securitiesClearingAccountList) {
            //利息(估值增值)
            netValueOfStatisticalPojo.setMarketValue(value3.getTotalPrice() + "");
            statisticalService = value3.getTotalPrice();
            //计算出证券清算款的总和
            statisticalServices += statisticalService;
            System.out.println("证券清算款" + value3.getTotalPrice() + "");
            System.out.println("证券清算款总和" + statisticalServices);
        }
        //项目名称
        netValueOfStatisticalPojo.setProjectName("证券清算款");
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(countDemoThere);
        //计算出证券清算款的总和传递给实体类增加进数据库
        //设置保留小数，每三位用逗号隔开
        String format4 = df.format(statisticalServices);
        netValueOfStatisticalPojo.setMarketValue(format4);
        netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);
        //创建树形结构二级结构-合计
        netValueOfStatisticalPojo.setValueStatisticsDate(time);             //时间
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);                    //id
        //项目名称
        netValueOfStatisticalPojo.setProjectName("合计");                   //名称
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(0);                    //父id
        d = netValueOfStatisticalService.insertTree(netValueOfStatisticalPojo);
        System.out.println("创建的树形二级结构债券合计为" + d);

        //估值增值
        int countDemoForm = count;
        Double sum = (zhaiQuans + guPiaos);
        //项目名称
        netValueOfStatisticalPojo.setProjectName("估值增值");
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(countDemoForm);
        //利息(估值增值)
        //设置保留小数，每三位用逗号隔开
        String format3 = df.format(sum);
        netValueOfStatisticalPojo.setMarketValue(format3);
        netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);


        //负债
        Double sum1 = (statisticalServices + (AdministrativeFee) + (trusteeFee));
        //项目名称
        netValueOfStatisticalPojo.setProjectName("负债");
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(countDemoForm);
        //利息(估值增值)
        //设置保留小数，每三位用逗号隔开
        String format2 = df.format(sum1);
        netValueOfStatisticalPojo.setMarketValue(format2);
        netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);

        //资产净值
        Double allSum = sum - sum1 + zhaiQuanShiZhis + guPiaoShiZhis + cashBlances + zhaiQuanLiXis  + xianJinLiXis ;
        //项目名称
        netValueOfStatisticalPojo.setProjectName("资产净值");
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(countDemoForm);
        //利息(估值增值)
        //设置保留小数，每三位用逗号隔开
        String format1 = df.format(allSum);
        System.out.println("估值增值"+format1);
        netValueOfStatisticalPojo.setMarketValue(format1);
        netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);

        //TA库存统计(单位资产净值)
        Double TANum = netValueOfStatisticalService.selectTA(time);
        //项目名称
        netValueOfStatisticalPojo.setProjectName("基金单位资产净值");
        System.out.println(netValueOfStatisticalPojo.getProjectName());
        //项目编号
        netValueOfStatisticalPojo.setProjectId(++count);
        //父项目编号
        netValueOfStatisticalPojo.setProjectFatherId(countDemoForm);
        //利息(估值增值)
        double finall = allSum / TANum;
        String formatDemoOne = String.format("%.2f", finall);
        System.out.println("估值增值"+formatDemoOne);
        netValueOfStatisticalPojo.setMarketValue(formatDemoOne);
        System.out.println(allSum / TANum);
        netValueOfStatisticalService.insertNetValueOfStatistical(netValueOfStatisticalPojo);
        countPojo.setIntCount(count);

        //查询插入的数据
        System.out.println("从界面接收到的时间数据是" + time);
        List<NetValueOfStatisticalPojo> NetValueOfStatisticalList = netValueOfStatisticalService.selectNetValueOfStatistical(time);
        Map<String, Object> map = new HashMap();
        //响应头
        map.put("msg", "");
        map.put("code", 0);
        map.put("count", 10);
        map.put("data", NetValueOfStatisticalList);
        System.out.println("查询出来的基金统计的结果集合是" + map);
        return map;
    }
}
