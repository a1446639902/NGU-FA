package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.MarketData;
import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.TransactionDataService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.DbUtil;
import com.yidu.util.GetFundIdUtil;
import com.yidu.util.SysTableNameListUtil;
import com.yidu.util.marketDateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易数据表
 * @Type:控制层
 * @author Tmac
 * @time 2020/9/1  15:06
 * @version   1.0
 **/
@RestController
@RequestMapping("/TransactionData")
public class TransactionDataController {
    @Resource
    TransactionDataService transactionDataService;

    @Resource
    DbUtil dbUtil;
    @NGULog(message = "查询交易数据表")
    @RequestMapping("/selectTransactionData")
    public HashMap selectTransactionData(int page,int limit,String dateTime,String securitiesName){
        //调用service方法传值
        HashMap hashMap = transactionDataService.selectTransactionData(page, limit, dateTime, securitiesName);
        //通过hashMap获取p_count总条数
        int count = (int) hashMap.get("p_count");
        //通过hashMap获取p_cursor游标数据返回集合,强转下类型
        List<TransactionData> transactionDataList = (List<TransactionData>) hashMap.get("p_cursor");
        //创建一个HashMap
        HashMap tranMap = new HashMap();
        //给状态码赋值count,code,msg,data
        tranMap.put("count",count);
        tranMap.put("code",0);
        tranMap.put("msg","");
        tranMap.put("data",transactionDataList);
        return tranMap;
    }
    @NGULog(message = "添加交易数据表")
    @RequestMapping("/insertTransactionData")
    public int insertTransactionData(TransactionData transactionData, HttpServletRequest request){
        //通过工具类自动获取TransactionDataId交易编号ID进行赋值
        transactionData.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));
        //通过工具类给fundId基金id进行赋值
        transactionData.setFundId(GetFundIdUtil.getFundId(request));
        //通过TransactionDataMode类型给交易标识符进行赋值 (1是买入,-1是流出) (2是卖出，1是流入)
        if (transactionData.getTransactionDataMode()==1){
            transactionData.setFlag(-1);
        }else if (transactionData.getTransactionDataMode()==2 || transactionData.getTransactionDataMode()==3 || transactionData.getTransactionDataMode()==4){
            transactionData.setFlag(1);
        }
        return transactionDataService.insertTransactionData(transactionData);
    }
    @NGULog(message = "删除交易数据表")
    @RequestMapping("/deleteTransactionData")
    public int deleteTransactionData(String transactionDataId){
        return transactionDataService.deleteTransactionData(transactionDataId);
    }
    @NGULog(message = "批量删除交易数据表")
    @RequestMapping("/deleteTransactionDataTwo")
    public int deleteTransactionDataTwo(String transactionDataId) {
        return transactionDataService.deleteTransactionDataTwo(transactionDataId);
    }
    @NGULog(message = "修改交易数据表")
    @RequestMapping("/updateTransactionData")
    public int updateTransactionData(TransactionData transactionData){
        return transactionDataService.updateTransactionData(transactionData);
    }
    @NGULog(message = "交易数据导入")
    @RequestMapping("upload")
    @ResponseBody
    //创建一个数据导入的方法(参数 MultipartFile file)
    public Map<String, Object> uploadMarket(MultipartFile file) throws IOException {
        //new一个hashmap返回一个map
        Map<String,Object> map = new HashMap<>();
        //通过marketDateUtil工具类，获取相对应的实体类集合getList(反射实体类，根据参数file获取流，index：0)返回一个集合进行遍历
        //传入对象的泛型，输入流对象，和哪个工作表，直接获取指定的实体类集合对象，获取集合对象之后就进行相对应的数据库操作
        List<TransactionData> list = marketDateUtil.getList(TransactionData.class, file.getInputStream(), 0);
        System.out.println(list);
        for (TransactionData transactionData : list) {
            if(transactionData.getSecuritiesId()!=null) {
              //获取交易数据id进行赋值
                transactionData.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));
                transactionDataService.insertTransactionData(transactionData);
            }
        }
        return map;

    }
}
