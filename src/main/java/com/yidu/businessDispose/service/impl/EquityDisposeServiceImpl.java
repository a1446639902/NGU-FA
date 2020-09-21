package com.yidu.businessDispose.service.impl;

import com.yidu.businessData.mapper.TransactionDataMapper;
import com.yidu.businessData.pojo.EquityData;
import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.EquityDataService;
import com.yidu.businessDispose.mapper.EquityDisposeMapper;
import com.yidu.businessDispose.pojo.EquityDispose;
import com.yidu.businessDispose.service.EquityDisposeService;
import com.yidu.util.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EquityDisposeServiceImpl implements EquityDisposeService {
    @Resource
    DbUtil dbUtil;
    @Resource
    EquityDisposeMapper equityDisposeMapper;
    @Resource
    TransactionDataMapper transactionDataMapper;
    @Resource
    EquityDataService equityDataService;
    @Override
    public Map<String, Object> selectEquityDispose(String pageSize, String page, String equitiesType, String equitiesExright,String disposeStatus) {
        //创建一个结果集Map用于存放两个结果变量
        Map<String, Object> resultMap = new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize = 0;
        //判断v_pageSize是否为空
        if (pageSize != null && !pageSize.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_pageSize=Integer.parseInt(pageSize);
        }
        //定义一个分页页码变量
        int v_page = 0;
        //判断传入的page是否为null/空
        if (page != null && !page.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_page=Integer.parseInt(page);
        }

        //条件搜索
        int v_equitiesType = 0;
        StringBuffer sqlWhere=new StringBuffer();
        if(equitiesExright != null && !equitiesExright.equals("")){
            sqlWhere.append("AND equitiesExright LIKE  '%"+equitiesExright+"%'");
        }
        if (equitiesType != null && !equitiesType.equals("")){
            v_equitiesType=Integer.parseInt(equitiesType);
            sqlWhere.append("AND equitiesType LIKE  '%"+v_equitiesType+"%'");
        }
        int v_disposeStatus = 0;
        if (disposeStatus != null && !disposeStatus.equals("")){
            v_disposeStatus = Integer.parseInt(disposeStatus);
            sqlWhere.append("AND disposeStatus LIKE  '%"+v_disposeStatus+"%'");
        }
        //获取权益数据的信息
        Map<String, Object> equityDataMap = equityDataService.selectEquityData("100", "1", null, null);
        List<EquityData> equityDataList1 = (List<EquityData>) equityDataMap.get("equityDataList");
        System.out.println("所有的权益信息="+equityDataList1);
        //多表查询
        String p_tableName="";
        List<EquityDispose> equityDisposeList = new ArrayList<>();
        //接收返回总条数
        int v_count =0;
        for (v_count = 0; v_count < equityDataList1.size(); v_count++) {
            p_tableName = "(select decode(qysj.EQUITIESTYPE,2,((SECURITIESNUM*qysj.PROPORTION)/100),0) settlementAmount,SECURITIESID,qysj.SECURITIESNAME,qysj.EQUITYDATAID,qysj.EQUITIESTYPE,qysj.EQUITIESEXRIGHT,qysj.RECEIVEDDATE,qysj.PROPORTION,qysj.DISPOSESTATUS,qysj.SECURITYID,zjkc.SECURITIESNUM\n" +
                    "from (select * from SECURITIESINVENTORY where dateTime=to_char(to_date('"+equityDataList1.get(v_count).getEquitiesExright()+"','yyyy-MM-dd')-1,'yyyy-MM-dd')) zjkc\n" +
                    "full join\n" +
                    "(select PROPORTION,SECURITYID,EQUITYDATAID,EQUITIESTYPE,EQUITIESEXRIGHT,DISPOSESTATUS,RECEIVEDDATE,s.SECURITIESNAME\n" +
                    "from (select * from EQUITYDATA where equityDataId='"+equityDataList1.get(v_count).getEquityDataId()+"') equityData join (select * from SECURITIES) s\n" +
                    "on equityData.SECURITYID=s.SECURITIESID) qysj\n" +
                    "on qysj.SECURITYID=zjkc.SECURITIESID)";
            //创建一个Map，用于存储过程的调用传值
            Map<String,Object> map = new HashMap<>();
            //传入存储过程需要的查询的表名
            map.put("p_tableName",p_tableName);
            //传入查询条件
            map.put("p_condition",sqlWhere.toString());
            //传入分页显示条数
            map.put("p_pageSize",v_pageSize);
            //传入分页页码
            map.put("p_page",v_page);
            //创建out参数，返回数据总条数
            map.put("p_count",0);
            //创建out游标变量，返回查询数据
            map.put("p_cursor",null);
            //调用Mapper执行查询
            equityDisposeMapper.selectEquityDispose(map);
            //接收返回数据
            List<EquityDispose> equityDisposeList1 = (List<EquityDispose>) map.get("p_cursor");
            for (EquityDispose equityDispose : equityDisposeList1) {
                equityDisposeList.add(equityDispose);
            }
        }

        //将结果放入结果集Map
        resultMap.put("equityDisposeList",equityDisposeList);
        resultMap.put("count",v_count);
        System.out.println("所有的权益处理信息="+resultMap.get("equityDisposeList"));
        //返回结果集Map
        return resultMap;

    }

    @Override
    public int updateEquityDispose(String equityDisPose, HttpServletRequest request) {
        List<EquityDispose> equityDisposeList = JsonUtil.jsonToArrayList(equityDisPose, EquityDispose.class);
        for (EquityDispose equityDispose2 : equityDisposeList) {
            //new 一个交易数据的实体类对象
            TransactionData transactionData = new TransactionData();
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+transactionData);
            //参数赋值
            transactionData.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));//交易数据ID
            transactionData.setDateTime(equityDispose2.getEquitiesExright());//业务日期
            transactionData.setNum(1000.0);//交易数量
            transactionData.setPrice(12.0);//交易单价
            transactionData.setTotalSum(1200.00);//交易总金额
            transactionData.setNetReceipts(12000.0);//实收金额
            transactionData.setSettlementDate(equityDispose2.getReceivedDate());//到账日期
            transactionData.setAccountName(equityDispose2.getAccountName());//账户名称
            transactionData.setSecuritiesName(equityDispose2.getSecuritiesName());//证券名称
            transactionData.setBrokersName("长城证券");//券商名称
//            transactionData.setBrokersName("长城证券");
            String fundId= GetFundIdUtil.getFundId(request);
            transactionData.setFundId(fundId);//基金代码
            transactionData.setFundName("华宝高端制造股票型证券投资基金");//基金名称
            transactionData.setSecuritiesId("600031");//证券ID
            transactionData.setBrokersId("10050000");//券商ID
            transactionData.setSeateId("10050000001");//席位ID
            transactionData.setSeateName(null);//席位名称
            String AccountId = GetAccountUtil.getAccountId(request);
            transactionData.setAccountId(AccountId);//账户ID
            transactionData.setBlankName("中国建设银行");//银行名称
            transactionData.setFlag(1);//交易标识
            transactionData.setCommission(0.0);//佣金费用
            transactionData.setTransfer(0.0);//过户费（交易所）
            transactionData.setBrokerage(0.0);//经手费（交易所）
            transactionData.setStamp(0.0);//印花税（上交国家的税）
            transactionData.setManagement(0.0);//征管费（上交国家的税）
            transactionData.setSecurity(0.0);//证券利息
            transactionData.setTransactionDataDesc("");//备注
            transactionData.setTransactionDataMode(equityDispose2.getEquitiesType());//交易方式
            transactionData.setStatus(equityDispose2.getDisposeStatus());//处理状态
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+transactionData);

            int disposeStatus = equityDispose2.getDisposeStatus();
            String equityDataId = equityDispose2.getEquityDataId();
            if (disposeStatus==0){
                equityDisposeMapper.updateEquityDispose(equityDataId,1);
                transactionDataMapper.insertTransactionData(transactionData);
            }
        }
        return 1;
    }

    @Override
    public int updateEquityDisposeTwo(String equityDispose) {
        List<EquityDispose> equityDisposes = JsonUtil.jsonToArrayList(equityDispose, EquityDispose.class);
        for (EquityDispose equityDispose2 : equityDisposes) {
            int disposeStatus = equityDispose2.getDisposeStatus();
            String equityDataId = equityDispose2.getEquityDataId();
            System.out.println(disposeStatus);
            if (disposeStatus==1){
                equityDisposeMapper.updateEquityDisposeTwo(equityDataId,0);
                transactionDataMapper.deleteTransactionData(equityDataId);
            }
        }
        return 1;
    }
}

