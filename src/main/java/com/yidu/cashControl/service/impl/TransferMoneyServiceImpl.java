package com.yidu.cashControl.service.impl;

import com.yidu.cashControl.mapper.TransferMoneyMapper;
import com.yidu.cashControl.pojo.TransferMoneyPojo;
import com.yidu.cashControl.service.TransferMoneyService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 划款指令表
 * @author 黄志豪
 * @version 1.0
 * @Type 服务层的实现类
 * @time 2020/9/10
 **/
@Transactional
@Service
public class TransferMoneyServiceImpl implements TransferMoneyService {
    @Resource
    TransferMoneyMapper transferMoneyMapper;
    @Resource
    DbUtil dbUtil;

    /**
     * 查询划款指令表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param crossSectionDate 划款时间
     * @return 返回hashMap对象
     */
    @Override
    public HashMap selectTransferMoney(int page, int limit,String crossSectionDate) {
        HashMap<Object, Object> transferMoneyMap = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();
        //判断crossSectionDate是否为空，不为空，则添加查询条件
        if(crossSectionDate!=null && !crossSectionDate.equals("")){
            stringBuffer.append(" and crossSectionDate='"+crossSectionDate+"'");
        }
        //创建hashMap，调用存储过程,(p_tableName,p_condition,p_pageSize,p_page,p_count,p_cursor)
        String p_tableName=" (select transferMoney.*,account.blankCardCode outBlankCardCode, (select blankCardCode from account where accountId=transferMoney.inAccountId) inBlankCardCode from transferMoney join account on transferMoney.outAccount = account.accountId)";
        transferMoneyMap.put("p_tableName",p_tableName);
        transferMoneyMap.put("p_condition",stringBuffer.toString());
        transferMoneyMap.put("p_pageSize",limit);
        transferMoneyMap.put("p_page",page);
        transferMoneyMap.put("p_count",0);
        transferMoneyMap.put("p_cursor",null);
        transferMoneyMapper.selectTransferMoney(transferMoneyMap);
        return transferMoneyMap;

    }

    /**
     * 新增划款指令表的方法
     * @param transferMoneyPojo 划款指令表的实体类
     * @return 返回 1新增成功 0新增失败
     */
    @Override
    public int insertTransferMoney(TransferMoneyPojo transferMoneyPojo) {
        transferMoneyPojo.setTransferMoneyId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TM));
        return transferMoneyMapper.insertTransferMoney(transferMoneyPojo);
    }

    /**
     * 修改划款指令表的方法
     * @param transferMoneyPojo 划款指令表的实体类
     * @return 返回 1修改成功 0修改失败
     */
    @Override
    public int updateTransferMoney(TransferMoneyPojo transferMoneyPojo) {
        return transferMoneyMapper.updateTransferMoney(transferMoneyPojo);
    }

    /**
     * 删除划款指令表的方法
     * @param transferMoneyIds 划款指令表ID
     * @return 返回 1删除成功 0删除失败
     */
    @Override
    public int deleteTransferMoney(String transferMoneyIds) {
        //判断transferMoneyIds是否为空 不为空则进行切割 装入数组
        if(transferMoneyIds!=null && !transferMoneyIds.equals("")) {
            String[] split = transferMoneyIds.split(",");
            ArrayList transferMoneyIdList = new ArrayList<>();
            for (String transferMoneyId : split) {
                transferMoneyIdList.add(transferMoneyId);
            }
            return transferMoneyMapper.deleteTransferMoney(transferMoneyIdList);
        }
        return 0;
    }
}
