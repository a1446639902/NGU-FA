package com.yidu.cashControl.service.impl;

import com.yidu.cashControl.mapper.BankTreasurerMapper;
import com.yidu.cashControl.pojo.BankTreasurerPojo;
import com.yidu.cashControl.service.BankTreasurerService;
import com.yidu.util.DateTimeUtil;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 资金调拨表
 * @Type 服务层的实现类
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/7
 **/
@Transactional
@Service
public class BankTreasurerServiceImpl implements BankTreasurerService {
    @Resource
    BankTreasurerMapper bankTreasurerMapper;
    @Resource
    DbUtil dbUtil;

    /**
     * 查询资金调拨表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param dbTime 调拨日期
     * @param allocatingType 调拨类型 1代表存款利息 2代表申购赎回清算款 3代表买卖交易清算款 4代表债券利息 5存款业务 6两费
     * @param flag 调拨方向 1代表流入 -1代表流出
     * @return  返回hashMap对象
     */
    @Override
    public HashMap selectBankTreasurer(int page, int limit,String dbTime,String allocatingType,String flag) {
        //搜索表名条件select * from bankTreasurer bt join  account a on bt.accountId = a.accountId) ";
        String p_tableName=" (select * from bankTreasurer bt join  account a on bt.accountId = a.accountId) ";
        StringBuffer stringBuffer = new StringBuffer();
        //判断dbTime，allocatingType，flag是否为空，不为空，则添加查询条件
        if(dbTime!=null && !dbTime.equals("")){
            stringBuffer.append(" and dbTime='"+dbTime+"'");
        }
        if (allocatingType!=null && !allocatingType.equals("")){
            stringBuffer.append(" and allocatingType="+allocatingType);
        }
        if(flag!=null && !flag.equals("")){
            int i = Integer.parseInt(flag);
            stringBuffer.append((" and flag=")+i);
        }
        //创建hashMap，调用存储过程,(p_tableName,p_condition,p_pageSize,p_page,p_count,p_cursor)
        HashMap bankTreasurerMap = new HashMap();
        bankTreasurerMap.put("p_tableName", p_tableName);
        bankTreasurerMap.put("p_condition",stringBuffer.toString());
        bankTreasurerMap.put("p_pageSize",limit);
        bankTreasurerMap.put("p_page",page);
        bankTreasurerMap.put("p_count",0);
        bankTreasurerMap.put("p_cursor",null);
        bankTreasurerMapper.selectBankTreasurer(bankTreasurerMap);
        return bankTreasurerMap;
    }

    /**
     * 新增资金调拨表的方法
     * @param bankTreasurerPojo 资金调拨表实体类
     * @return 返回 1新增成功 0 新增失败
     */
    @Override
    public int insertBankTreasurer(BankTreasurerPojo bankTreasurerPojo) {
        //给BankTreasurerId赋值
        bankTreasurerPojo.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
        return bankTreasurerMapper.insertBankTreasurer(bankTreasurerPojo);
    }

    /**
     * 修改资金调拨表的方法
     * @param bankTreasurerPojo 资金调拨表实体类
     * @return 返回 1修改成功 0 修改失败
     */
    @Override
    public int updateBankTreasurer(BankTreasurerPojo bankTreasurerPojo) {
        return bankTreasurerMapper.updateBankTreasurer(bankTreasurerPojo);
    }

    /**
     * 根据资金调拨表Id删除资金调拨表的方法
     * @param bankTreasurerIds 资金调拨表Id
     * @return 返回 1删除成功 0 删除失败
     */
    @Override
    public int deleteBankTreasurer(String bankTreasurerIds) {
        //判断bankTreasurerIds是否为空，不为空 进行切割 装入集合
        if(bankTreasurerIds!=null && !bankTreasurerIds.equals("")) {
            ArrayList bankTreasurerList = new ArrayList<>();
            String[] arrBankTreasurerId = bankTreasurerIds.split(",");
            for (String bankTreasurerId : arrBankTreasurerId) {
                bankTreasurerList.add(bankTreasurerId);
                System.out.println(bankTreasurerId);
            }
            return bankTreasurerMapper.deleteBankTreasurer(bankTreasurerList);
        }
        else return 0;

    }

    /**
     * 根据businessId删除资金调拨表的方法
     * @param businessId 业务编号
     * @return 返回 1删除成功 0 删除失败
     */
    @Override
    public int deleteBankTreasurerByBusinessId(String businessId) {
        return bankTreasurerMapper.deleteBankTreasurerByBusinessId(businessId);
    }


}
