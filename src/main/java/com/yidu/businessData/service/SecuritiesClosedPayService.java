package com.yidu.businessData.service;

import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 证券应收应付表
 * @author 戴言露
 * @version 1.0
 * @Type 服务层
 * @time 2020/9/12
 **/
public interface SecuritiesClosedPayService {
    /**
     * 查询证券应收应付表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param dateTime 日期
     * @param serviceType 业务类型 1=清算款 2=估值增值 3=债券利息
     * @return 返回hashMap对象
     */
    public HashMap selectSecuritiesClosedPay(int page,int limit,String dateTime,String serviceType);

    /**
     * 新增证券应收应付表的方法
     * @param SecuritiesClosedPayPojo 证券应收应付表实体类
     * @return 返回 1新增成功 0新增失败
     */
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo SecuritiesClosedPayPojo);

    /**
     * 修改证券应收应付表的方法
     * @param securitiesClosedPayPojo 证券应收应付表实体类
     * @return 返回 1修改成功 0修改失败
     */
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo);

    /**
     * 根据证券应收应付Id删除证券应收应付表的方法
     * @param securitiesClosedPayIds 证券应收应付Id
     * @return 返回 1删除成功 0删除失败
     */
    public int deleteSecuritiesClosedPay(String securitiesClosedPayIds);

    /**
     * 根据证securitiesClosedPay实体类删除证券应收应付表的方法
     * @param securitiesClosedPayPojo  securitiesClosedPay实体类
     * @return 返回 1删除成功 0删除失败
     */
    public int deleteSecuritiesClosedPayByPojo(SecuritiesClosedPayPojo securitiesClosedPayPojo);

    /**
     * 根据Map查询证券应收应付表的方法
     * @param map map对象
     * @return 返回String类型
     */
    public String selectSecuritiesClosedPayId(Map map);
}