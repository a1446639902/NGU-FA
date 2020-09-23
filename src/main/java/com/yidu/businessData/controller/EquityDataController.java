package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.EquityData;
import com.yidu.businessData.pojo.MarketData;
import com.yidu.businessData.service.EquityDataService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.DateTimeUtil;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import com.yidu.util.marketDateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@author wzh
 *date 2020-9-21
 * 权益数据设置控制层
 */

@RestController
public class EquityDataController {
    /**
     * 调用权益数据的服务层Service
     */
    @Resource
    EquityDataService equityDataService;
    /**
     * 调用工具类
     */
    @Resource
    DbUtil dbUtil;

    /**
     * 权益数据新增方法
     * @param equityData
     * @return
     */
    @NGULog(message = "权益数据新增方法")
    @RequestMapping("insertEquityData")
    public int insertEquityData(EquityData equityData) {
        //调用工具类自动增长列
        equityData.setEquityDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.ED));
        //日期格式
        equityData.setDateTime(DateTimeUtil.getSystemDateTime("yyyy-MM-dd"));
        int i = equityDataService.insertEquityData(equityData);
        return i;
    }

    /**
     * 权益数据删除方法
     * @param equityDataId
     * @return
     */
    @NGULog(message = "权益数据删除方法")
    @RequestMapping("deleteEquityData")
    public int deleteEquityData(String equityDataId) {
        int i = equityDataService.deleteEquityData(equityDataId);
        return i;
    }

    /**
     * 权益数据修改方法
     * @param equityData
     * @return
     */
    @NGULog(message = "权益数据修改方法")
    @RequestMapping("updateEquityData")
    public int updateEquityData(EquityData equityData) {
        System.out.println(equityData);
        int i = equityDataService.updateEquityData(equityData);
        return i;
    }

    /**
     * 权益数据查询方法
     * @param page
     * @param limit
     * @param equitiesType
     * @param equitiesExright
     * @return
     */
    @NGULog(message = "权益数据查询方法")
    @RequestMapping("selectEquityData")
    public Map<String, Object> selectEquityData(String page, String limit,String equitiesType,String equitiesExright) {
        System.out.println(equitiesType);
        System.out.println(equitiesExright);
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = equityDataService.selectEquityData(limit, page,equitiesType,equitiesExright);
        List<EquityData> equityDataList = (List<EquityData>) map.get("equityDataList");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> equityDataMap = new HashMap<>();
        equityDataMap.put("code", 0);
        equityDataMap.put("msg", "");
        equityDataMap.put("count", count);
        equityDataMap.put("data", equityDataList);
        //返回数据
        return equityDataMap;
    }

    /**
     * 权益数据导入
     * @param file
     * @return
     * @throws IOException
     */
    @NGULog(message = "权益数据导入")
    @RequestMapping("QuanYiShuju")
    @ResponseBody
    public Map<String, Object> uploadMarket(MultipartFile file) throws IOException {
        Map<String,Object> map = new HashMap<>();
        List<EquityData> list1 = marketDateUtil.getList(EquityData.class,file.getInputStream(),0);
        for (EquityData equityData : list1) {
            if (equityData.getSecurityId() != null) {
                equityData.setEquityDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.ED));
                equityData.setDateTime("2020-09-22");
                equityData.setEquitiesType(1);
                equityData.setProportion(5);
                equityDataService.insertEquityData(equityData);

            }
        }
        return map;

    }

}
