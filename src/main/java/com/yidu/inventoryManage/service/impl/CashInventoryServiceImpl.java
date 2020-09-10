package com.yidu.inventoryManage.service.impl;

import com.yidu.inventoryManage.mapper.CashInventoryMapper;
import com.yidu.inventoryManage.pojo.CashInventoryEntity;
import com.yidu.inventoryManage.service.CashInventoryService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 现金库存的service层接口实现类
 * @Mr.Zou
 * date:2020/9/5
 */
@Service
@Transactional
public class CashInventoryServiceImpl implements CashInventoryService {

    @Resource
    private CashInventoryMapper cashInventoryMapper;
    @Resource
    DbUtil dbUtil;

    /**
     * 分页查询所有现金库存的方法
     * @param pageSize  当前查询页数
     * @param page  分页数据条目数
     * @return  查询的结果集Map
     */
    @Override
    public Map<String, Object> selectCashInventory(String pageSize, String page, String accountId, String dateTime) {
        //创建一个结果集Map用于存放两个结果变量
        Map<String,Object> resultMap=new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize=10;
        //判断传入的pageSize是否为null/空
        if (pageSize!=null && !pageSize.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_pageSize=Integer.parseInt(pageSize);
        }
        //定义一个分页页码变量
        int v_page=1;
        //判断传入的page是否为null/空
        if (page!=null && !page.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_page=Integer.parseInt(page);
        }
        //输出测试
        String sql="";

        System.out.println("我是service，我获得的accountID："+accountId);
        System.out.println("我是service，我获得的数据dateTime："+dateTime);
        //现金账户
        if(accountId!=null && !accountId.equals("")){

            sql=sql+" and accountName ='"+accountId+"'";
        }

        //日期
        if(dateTime!=null && !dateTime.equals("")){
            sql=sql+" and dateTime='"+dateTime+"'";
        }


        //创建一个Map，用于存储过程的调用传值
        Map<String,Object> map=new HashMap<>();
        String p_tableName="( select cashInventoryId,blankCardCode,accountName,cashBlance,dateTime,cashInventoryDesc"+
                " from " + SysTableNameListUtil.CI+" c join "+SysTableNameListUtil.A +" a on c.accountId=a.accountId)";

        System.out.println("打印sql语句："+sql);
        System.out.println(p_tableName);
        //传入存储过程需要查询的表名
        map.put("p_tableName",p_tableName);
        //传入查询条件
        map.put("p_condition",sql);
        //传入分页显示条数
        map.put("p_pageSize",v_pageSize);
        //传入分页页码
        map.put("p_page",v_page);
        //创建out参数，返回数据总条数
        map.put("p_count",0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor",null);
        //调用Mapper执行查询
        cashInventoryMapper.selectCashInventory(map);

        //接收返回数据
        List<CashInventoryEntity> cashInventoryList= (List<CashInventoryEntity>) map.get("p_cursor");
        System.out.println("我是service，我查询的值为："+cashInventoryList);

        //接收返回总条数
        int v_count= (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("cashInventoryEntity",cashInventoryList);
        resultMap.put("count",v_count);
        //返回结果集Map
        return resultMap;
    }


    /**
     * 删除
     * @param userId
     */
    @Override
    public void deleteCashInventor(String userId) {
        cashInventoryMapper.deleteCashInventor(userId);
    }


    /**
     * 新增的service
     */
    @Override
    public void insertCashInventory(CashInventoryEntity cashInventoryEntity) {

                //现金库存id(从现金库存获得)
                 cashInventoryEntity.setCashInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.CI));
                 System.out.println("现金库存Id为："+cashInventoryEntity.getCashInventoryId());
                //基金id 来自（基金表）
                    cashInventoryEntity.setFundId("289289289");
                    System.out.println("基金id为："+cashInventoryEntity.getFundId());
                //现金余额
                     System.out.println("现金余额为："+cashInventoryEntity.getCashBlance());
                // 现金账户id  （来自现金账户）
                    cashInventoryEntity.setAccountId("1176040487");
                     System.out.println("现金账户id为："+cashInventoryEntity.getAccountId());
                 //统计日期
                    System.out.println("统计时间："+cashInventoryEntity.getDateTime());
                // 证券数量 (从证券库存获得)
                    cashInventoryEntity.setSecuritiesNum(1000);
                     System.out.println("证券数量为："+cashInventoryEntity.getSecuritiesNum());
                //期初数据 1为是期初数据
                    cashInventoryEntity.setSecurityPeriodFlag(1);
                    System.out.println("期初数据为："+cashInventoryEntity.getSecurityPeriodFlag());
                 //备注
                    System.out.println("备注为："+cashInventoryEntity.getCashInventoryDesc());

                    cashInventoryMapper.insertCashInventory(cashInventoryEntity);

    }

    /**
     * 批量删除的方法
     * @param cashInventoryId
     */
    @Override
    public void deleteMoreCashInventory(String cashInventoryId) {
        String[] split = cashInventoryId.split(",");

        String deleteId;
        for (String id : split) {
//           deleteId=Integer.parseInt(id);
            //循环获得的批量删除id
            cashInventoryMapper.deleteCashInventor(id);
        }


    }

    /**
     * 修改的方法
     * @param cashInventoryEntity
     */
    @Override
    public void updateCashInventory(CashInventoryEntity cashInventoryEntity) {

        double cashBlance = cashInventoryEntity.getCashBlance();

        String cashInventoryDesc = cashInventoryEntity.getCashInventoryDesc();

        String cashInventoryId = cashInventoryEntity.getCashInventoryId();

        cashInventoryMapper.updateCashInventory(cashBlance,cashInventoryDesc,cashInventoryId);

    }
}
