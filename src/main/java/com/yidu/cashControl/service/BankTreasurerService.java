package com.yidu.cashControl.service;

import com.yidu.cashControl.pojo.BankTreasurerPojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 资金调拨表
 * @Type 服务层
 * @author 黄志豪
 * @version 1.0
 * @time 2020/9/4
 **/
public interface BankTreasurerService {
    /**
     * 查询资金调拨表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param dbTime 调拨日期
     * @param allocatingType 调拨类型 1代表存款利息 2代表申购赎回清算款 3代表买卖交易清算款 4代表债券利息 5存款业务 6两费
     * @param flag 调拨方向 1代表流入 -1代表流出
     * @return 返回hashMap对象
     */
    public HashMap selectBankTreasurer(int page,int limit,String dbTime,String allocatingType,String flag);

    /**
     * 新增资金调拨表的方法
     * @param bankTreasurerPojo 资金调拨表实体类
     * @return 返回 1新增成功 0 新增失败
     */
    public int insertBankTreasurer(BankTreasurerPojo bankTreasurerPojo);

    /**
     * 修改资金调拨表的方法
     * @param bankTreasurerPojo 资金调拨表实体类
     * @return 返回 1修改成功 0 修改失败
     */
    public int updateBankTreasurer(BankTreasurerPojo bankTreasurerPojo);

    /**
     * 根据资金调拨表Id删除资金调拨表的方法
     * @param bankTreasurerIds 资金调拨表Id
     * @return 返回 1删除成功 0 删除失败
     */
    public int deleteBankTreasurer(String bankTreasurerIds);

    /**
     *根据businessId删除资金调拨表的方法
     * @param businessId 业务编号
     * @return  返回 1删除成功 0 删除失败
     */
    public int deleteBankTreasurerByBusinessId(String businessId);
}
