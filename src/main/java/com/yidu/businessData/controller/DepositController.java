package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.DepositPojo;
import com.yidu.businessData.service.DepositService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 存款业务表
 * @Type 控制层
 * @author 黄志豪
 * @version 1.2
 * @time 2020/9/9
 **/
@RestController
@RequestMapping("/deposit")
public class DepositController {
    @Resource
    DepositService depositService;

    /**
     * 查询存款业务表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param businessType  业务类型 1代表定期三天 2代表七天 3代表活期
     * @param dateEnd  到期日期
     * @return  返回hashMap对象
     */
    @NGULog(message="查询存款业务表")
    @RequestMapping("/selectDeposit")
    public HashMap selectDeposit(int page,int limit,String businessType,String dateEnd){
        System.out.println(page+limit);
        System.out.println(businessType);
        System.out.println(dateEnd);
        HashMap depositMap = depositService.selectDeposit(page, limit, businessType, dateEnd);
        int count = (int) depositMap.get("p_count");
        List<DepositPojo> depositPojoList = (List<DepositPojo>) depositMap.get("p_cursor");
        //返回前端页面格式数据（"msg","code","count","data"）
        HashMap hashMap = new HashMap<>();
        hashMap.put("msg","");
        hashMap.put("code",0);
        hashMap.put("count",count);
        hashMap.put("data",depositPojoList);
        return hashMap;
    }

    /**
     * 新增存款业务表的方法
     * @param depositPojo 存款业务表实体类
     * @param request   request请求对象
     * @return  返回值为1代表新增成功  0代表新增失败
     */
    @NGULog(message="新增存款业务表")
    @RequestMapping("/insertDeposit")
    public int insertDeposit(DepositPojo depositPojo, HttpServletRequest request){
        System.out.println("存款业务的新增===========");
        String fundId = GetFundIdUtil.getFundId(request);
        System.out.println(fundId);
        depositPojo.setFundId(fundId);
        return depositService.insertDeposit(depositPojo);
    }

    /**
     * 修改存款业务的方法
     * @param depositPojo 存款业务表实体类
     * @return 返回值为1代表修改成功  0代表修改失败
     */
    @NGULog(message="修改存款业务表")
    @RequestMapping("/updateDeposit")
    public int updateDeposit(DepositPojo depositPojo){
        System.out.println("修改=========================");
        System.out.println(depositPojo);
        return depositService.updateDeposit(depositPojo);
    }

    /**
     * 删除存款业务的方法
     * @param depositId 存款Id
     * @return 返回值为1代表删除成功  0代表删除失败
     */
    @NGULog(message="删除存款业务表")
    @RequestMapping("/deleteDeposit")
    public int deleteDeposit(String depositId){
        System.out.println("删除==========================");
        System.out.println("depositId="+depositId);
        return depositService.deleteDeposit(depositId);
    }
}
