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

/**划款指令表
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/10
 **/
@Transactional
@Service
public class TransferMoneyServiceImpl implements TransferMoneyService {
    @Resource
    TransferMoneyMapper transferMoneyMapper;
    @Resource
    DbUtil dbUtil;
    @Override
    public HashMap selectTransferMoney(int page, int limit,String crossSectionDate) {
        HashMap<Object, Object> transferMoneyMap = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();
        if(crossSectionDate!=null && !crossSectionDate.equals("")){
            stringBuffer.append(" and crossSectionDate='"+crossSectionDate+"'");
        }
        String p_tableName=" (select transferMoney.*,account.blankCardCode outBlankCardCode, (select blankCardCode from account where accountId=transferMoney.inAccountId) inBlankCardCode from transferMoney join account on transferMoney.outAccount = account.accountId)";
        transferMoneyMap.put("p_tableName",p_tableName);
        transferMoneyMap.put("p_condition",stringBuffer.toString());
        transferMoneyMap.put("p_pageSize",limit);
        transferMoneyMap.put("p_page",page);
        transferMoneyMap.put("p_count",0);
        transferMoneyMap.put("p_cursor",null);
        transferMoneyMapper.selectTransferMoney(transferMoneyMap);
        System.out.println(transferMoneyMap.get("p_cursor"));
        return transferMoneyMap;

    }

    @Override
    public int insertTransferMoney(TransferMoneyPojo transferMoneyPojo) {
        transferMoneyPojo.setTransferMoneyId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TM));
        return transferMoneyMapper.insertTransferMoney(transferMoneyPojo);
    }

    @Override
    public int updateTransferMoney(TransferMoneyPojo transferMoneyPojo) {
        return transferMoneyMapper.updateTransferMoney(transferMoneyPojo);
    }
    @Override
    public int deleteTransferMoney(String transferMoneyIds) {
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
