package com.yidu.businessParameter.service.Impl;


import com.yidu.businessParameter.mapper.FundMapper;
import com.yidu.businessParameter.pojo.Fund;
import com.yidu.businessParameter.service.FundService;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 基金参数
 * @Type:服务层的实现类
 * @author Tmac
 * @time 2020/9/1  9:12
 * @version   1.1
 **/
@Service
public class FundServiceImpl implements FundService {
    @Resource
    FundMapper fundMapper;


    @Override
    public HashMap selectFund(int page,int limit) {
        HashMap fundMap = new HashMap();
        fundMap.put("p_tableName",SysTableNameListUtil.F);
        fundMap.put("p_condition","");
        fundMap.put("p_pageSize",limit);
        fundMap.put("p_page",page);
        fundMap.put("p_count",0);
        fundMap.put("p_cursor",null);
        fundMapper.selectFund(fundMap);
        return fundMap;
    }

    @Override
    public int insertFund(Fund fund) {
        return fundMapper.insertFund(fund);
    }

    @Override
    public int deleteFund(String fundId) {
        //定义一个数组接收编号，切割字符串
        String[] split = fundId.split(",");
        //定义一个整型集合
        List<String> fundIdList = new ArrayList<String>();
        //循环数组
        for (String id : split) {
            //将数组循环的值添加到集合中，强转为整型
            fundIdList.add(id);
        }
        return fundMapper.deleteFund(fundIdList);
    }

    @Override
    public int updateFund(Fund fund) {
        return fundMapper.updateFund(fund);
    }
}
