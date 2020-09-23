package com.yidu.inventoryManage.controller;

import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import com.yidu.inventoryManage.service.SecuritiesClosedPayInventoryService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 证券应收应付库存
 * @author 黄志豪
 * @version 1.0
 * @Type 控制层
 * @time 2020/9/13
 **/
@RestController
public class SecuritiesClosedPayInventoryController {
    @Resource
    SecuritiesClosedPayInventoryService securitiesClosedPayInventoryService;

    /**
     * 查询证券应收应付的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param securitiesType 证券应收应付类型 1=估值款 2=证券清算款 3=债券利息
     * @param dateTime 业务日期
     * @return 返回hashMap对象
     */
    @NGULog(message="查询证券应收应付库存")
    @RequestMapping("/selectSecuritiesClosedPayInventory")
    public HashMap selectSecuritiesClosedPayInventory(int page,int limit,String securitiesType,String dateTime){
       //调用服务层的查询方法
        HashMap scpiMap = securitiesClosedPayInventoryService.selectSecuritiesClosedPayInventory(page, limit,securitiesType,dateTime);
        //获取scpiMap中的p_count，p_cursor的值，进行强转
        int count = (int) scpiMap.get("p_count");
        ArrayList<SecuritiesClosedPayInventoryPojo> securitiesClosedPayList = (ArrayList<SecuritiesClosedPayInventoryPojo>) scpiMap.get("p_cursor");
        //返回前端页面格式数据（"msg","code","count","data"）
        HashMap hashMap = new HashMap<>();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",count);
        hashMap.put("data",securitiesClosedPayList);
        return hashMap;
    }

    /**
     * 新增证券应收应付的方法
     * @param securitiesClosedPayInventoryPojo 证券应收应付的实体类
     * @param request request请求对象
     * @return 返回 1新增成功 0新增失败
     */
    @NGULog(message="新增证券应收应付库存")
    @RequestMapping("/insertSecuritiesClosedPayInventory")
    public int insertSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo, HttpServletRequest request){
        //工具类获得fundId，在给实体类赋值
        String fundId = GetFundIdUtil.getFundId(request);
        securitiesClosedPayInventoryPojo.setFundId(fundId);
        return securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
    }

    /**
     * 修改证券应收应付的方法
     * @param securitiesClosedPayInventoryPojo 证券应收应付的实体类
     * @return 返回 1修改成功 0修改失败
     */
    @NGULog(message="修改证券应收应付库存")
    @RequestMapping("/updateSecuritiesClosedPayInventory")
    public int updateSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo){

        return securitiesClosedPayInventoryService.updateSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
    }

    /**
     * 删除证券应收应付的方法
     * @param securitiesClosedPayInventoryIds 证券应收应付Id
     * @return 返回 1删除成功 0删除失败
     */
    @NGULog(message="删除证券应收应付库存")
    @RequestMapping("/deleteSecuritiesClosedPayInventory")
    public int deleteSecuritiesClosedPayInventory(String securitiesClosedPayInventoryIds){

        return securitiesClosedPayInventoryService.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventoryIds);
    }
}
