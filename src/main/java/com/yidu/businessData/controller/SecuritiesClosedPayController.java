package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 证券应收应付表
 * @author 戴言露
 * @version 1.0
 * @Type 控制层
 * @time 2020/9/12
 **/
@RestController
@RequestMapping("/securitiesClosedPay")
public class SecuritiesClosedPayController {
    @Resource
    SecuritiesClosedPayService securitiesClosedPayService;

    /**
     * 查询证券应收应付表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param dateTime 日期
     * @param serviceType 业务类型 1=清算款 2=估值增值 3=债券利息
     * @return 返回hashMap对象
     */
    @NGULog(message="查询证券应收应付表")
    @RequestMapping("/selectSecuritiesClosedPay")
    public HashMap selectSecuritiesClosedPay(int page,int limit,String dateTime,String serviceType){
        System.out.println("xinzeng========================");
        System.out.println(dateTime);
        HashMap securitiesClosedPayMap = securitiesClosedPayService.selectSecuritiesClosedPay(page, limit,dateTime,serviceType);
        int count = (int) securitiesClosedPayMap.get("p_count");
        ArrayList<SecuritiesClosedPayPojo> securitiesClosedPayList = (ArrayList<SecuritiesClosedPayPojo>) securitiesClosedPayMap.get("p_cursor");
        HashMap hashMap = new HashMap<>();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",count);
        hashMap.put("data",securitiesClosedPayList);
        return hashMap;
    }

    /**
     * 新增证券应收应付表的方法
     * @param securitiesClosedPayPojo 证券应收应付表实体类
     * @param request request请求对象
     * @return 返回 1新增成功 0新增失败
     */
    @NGULog(message="新增证券应收应付表")
    @RequestMapping("/insertSecuritiesClosedPay")
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo, HttpServletRequest request){
        String fundId = GetFundIdUtil.getFundId(request);
        securitiesClosedPayPojo.setFundId(fundId);
        System.out.println(securitiesClosedPayPojo);
        return securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPayPojo);

    }

    /**
     * 修改证券应收应付表的方法
     * @param securitiesClosedPayPojo 证券应收应付表实体类
     * @return 返回 1修改成功 0修改失败
     */
    @NGULog(message="修改证券应收应付表")
    @RequestMapping("/updateSecuritiesClosedPay")
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo){
        System.out.println(securitiesClosedPayPojo);
        System.out.println("-------------------------------------");
        return securitiesClosedPayService.updateSecuritiesClosedPay(securitiesClosedPayPojo);
    }

    /**
     * 根据证券应收应付Id删除证券应收应付表的方法
     * @param securitiesClosedPayIds 证券应收应付Id
     * @return 返回 1删除成功 0删除失败
     */
    @NGULog(message="删除证券应收应付表")
    @RequestMapping("/deleteSecuritiesClosedPay")
    public int deleteSecuritiesClosedPay(String securitiesClosedPayIds){
        System.out.println("==============");
        System.out.println(securitiesClosedPayIds);
        return securitiesClosedPayService.deleteSecuritiesClosedPay(securitiesClosedPayIds);
    }
}
