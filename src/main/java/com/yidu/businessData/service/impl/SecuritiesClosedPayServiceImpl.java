package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.SecuritiesClosedPayMapper;
import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 证券应收应付表
 * @author 戴言露
 * @version 1.0
 * @Type 服务层实现类
 * @time 2020/9/12
 **/
@Transactional
@Service
public class SecuritiesClosedPayServiceImpl implements SecuritiesClosedPayService {
    @Resource
    SecuritiesClosedPayMapper securitiesClosedPayMapper;
    @Resource
    DbUtil dbUtil;

    /**
     * 查询证券应收应付表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param dateTime 日期
     * @param serviceType 业务类型 1=清算款 2=估值增值 3=债券利息
     * @return 返回hashMap对象
     */
    @Override
    public HashMap selectSecuritiesClosedPay(int page,int limit,String dateTime,String serviceType) {
        StringBuffer stringBuffer = new StringBuffer();
        if(dateTime!=null && !dateTime.equals("")){
            stringBuffer.append(" and dateTime='"+dateTime+"'");

        }
        if(serviceType!=null && !serviceType.equals("")){
            int i = Integer.parseInt(serviceType);
            stringBuffer.append(" and serviceType="+i);
        }
        //构造调用存储过程hashMap（"p_tableName",select * from securitiesClosedPay scp join ACCOUNT a on scp.ACCOUNTID=a.ACCOUNTID join securities st on scp.securitiesId=st.securitiesId )");
        HashMap securitiesClosedPayMap = new HashMap<>();
        securitiesClosedPayMap.put("p_tableName"," (select * from securitiesClosedPay scp join ACCOUNT a on scp.ACCOUNTID=a.ACCOUNTID join securities st on scp.securitiesId=st.securitiesId )");
        //hashMap的键的参数（"p_condition","p_pageSize","p_page","p_count","p_cursor"）
        securitiesClosedPayMap.put("p_condition",stringBuffer.toString());
        securitiesClosedPayMap.put("p_pageSize",limit);
        securitiesClosedPayMap.put("p_page",page);
        securitiesClosedPayMap.put("p_count",0);
        securitiesClosedPayMap.put("p_cursor",null);
        securitiesClosedPayMapper.selectSecuritiesClosedPay(securitiesClosedPayMap);
        return securitiesClosedPayMap;
    }

    /**
     * 新增证券应收应付表的方法
     * @param securitiesClosedPayPojo 证券应收应付表实体类
     * @return 返回 1新增成功 0新增失败
     */
    @Override
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo) {
        securitiesClosedPayPojo.setSecuritiesClosedPayId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCP));
        return securitiesClosedPayMapper.insertSecuritiesClosedPay(securitiesClosedPayPojo);
    }

    /**
     * 修改证券应收应付表的方法
     * @param securitiesClosedPayPojo 证券应收应付表实体类
     * @return 返回 1修改成功 0修改失败
     */
    @Override
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo) {
        return securitiesClosedPayMapper.updateSecuritiesClosedPay(securitiesClosedPayPojo);
    }

    /**
     * 根据证券应收应付Id删除证券应收应付表的方法
     * @param securitiesClosedPayIds 证券应收应付Id
     * @return 返回 1删除成功 0删除失败
     */
    @Override
    public int deleteSecuritiesClosedPay(String securitiesClosedPayIds) {
        //对securitiesClosedPayIds进行切割，在装入List
        if (securitiesClosedPayIds != null && !securitiesClosedPayIds.equals("")) {
            String[] split = securitiesClosedPayIds.split(",");
            ArrayList securitiesClosedPayIdList = new ArrayList<>();
            for (String securitiesClosedPayId : split) {
                securitiesClosedPayIdList.add(securitiesClosedPayId);
            }
            return securitiesClosedPayMapper.deleteSecuritiesClosedPay(securitiesClosedPayIdList);
        }
        return 0;
    }

    /**
     * 根据证securitiesClosedPay实体类删除证券应收应付表的方法
     * @param securitiesClosedPayPojo  securitiesClosedPay实体类
     * @return 返回 1删除成功 0删除失败
     */
    @Override
    public int deleteSecuritiesClosedPayByPojo(SecuritiesClosedPayPojo securitiesClosedPayPojo) {
        return securitiesClosedPayMapper.deleteSecuritiesClosedPayByPojo(securitiesClosedPayPojo);
    }

    /**
     * 根据Map查询证券应收应付表的方法
     * @param map map对象
     * @return 返回String类型
     */
    @Override
    public String selectSecuritiesClosedPayId(Map map) {
        return securitiesClosedPayMapper.selectSecuritiesClosedPayId(map);
    }
}
