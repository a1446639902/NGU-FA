package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.SecuritiesClosedPayMapper;
import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/12
 **/
@Service
public class SecuritiesClosedPayServiceImpl implements SecuritiesClosedPayService {
    @Resource
    SecuritiesClosedPayMapper securitiesClosedPayMapper;
    @Resource
    DbUtil dbUtil;
    @Override
    public HashMap selectSecuritiesClosedPay(int page,int limit,String dateTime) {
        StringBuffer stringBuffer = new StringBuffer();
        if(dateTime!=null && !dateTime.equals("")){
            stringBuffer.append(" and dateTime='"+dateTime+"'");
        }
        HashMap securitiesClosedPayMap = new HashMap<>();
        securitiesClosedPayMap.put("p_tableName"," (select * from securitiesClosedPay scp join ACCOUNT a on scp.ACCOUNTID=a.ACCOUNTID join securities st on scp.securitiesId=st.securitiesId )");
        securitiesClosedPayMap.put("p_condition",stringBuffer.toString());
        securitiesClosedPayMap.put("p_pageSize",limit);
        securitiesClosedPayMap.put("p_page",page);
        securitiesClosedPayMap.put("p_count",0);
        securitiesClosedPayMap.put("p_cursor",null);
        securitiesClosedPayMapper.selectSecuritiesClosedPay(securitiesClosedPayMap);
        return securitiesClosedPayMap;
    }

    @Override
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo) {
        securitiesClosedPayPojo.setSecuritiesClosedPayId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCP));
        return securitiesClosedPayMapper.insertSecuritiesClosedPay(securitiesClosedPayPojo);
    }

    @Override
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo) {
        return securitiesClosedPayMapper.updateSecuritiesClosedPay(securitiesClosedPayPojo);
    }

    @Override
    public int deleteSecuritiesClosedPay(String securitiesClosedPayIds) {
        String[] split = securitiesClosedPayIds.split(",");
        ArrayList securitiesClosedPayIdList = new ArrayList<>();
        for (String securitiesClosedPayId : split) {
            securitiesClosedPayIdList.add(securitiesClosedPayId);
        }
        return securitiesClosedPayMapper.deleteSecuritiesClosedPay(securitiesClosedPayIdList);
    }

    @Override
    public int deleteSecuritiesClosedPayByPojo(SecuritiesClosedPayPojo securitiesClosedPayPojo) {
        return securitiesClosedPayMapper.deleteSecuritiesClosedPayByPojo(securitiesClosedPayPojo);
    }

    @Override
    public String selectSecuritiesClosedPayId(Map map) {
        return securitiesClosedPayMapper.selectSecuritiesClosedPayId(map);
    }
}
