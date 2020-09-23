package com.yidu.cashControl.controller;

import com.yidu.cashControl.pojo.TransferMoneyPojo;
import com.yidu.cashControl.service.TransferMoneyService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 划款指令表
 * @Type 控制层
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/11
 **/
@RestController
@RequestMapping("/transferMoney")
public class TransferMoneyController {
    @Resource
    TransferMoneyService transferMoneyService;

    /**
     * 查询划款指令表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param crossSectionDate 划款时间
     * @return 返回hashMap对象
     */
    @NGULog(message="查询划款指令表")
    @RequestMapping("/selectTransferMoney")
    public HashMap selectTransferMoney(int page,int limit,String crossSectionDate){
        //调用服务层的查询方法
        HashMap transferMoneyMap = transferMoneyService.selectTransferMoney(page, limit,crossSectionDate);
        //通过p_count，p_cursor获取值，进行强转
        int count = (int) transferMoneyMap.get("p_count");
        ArrayList<TransferMoneyPojo> transferMoneyList = (ArrayList<TransferMoneyPojo>) transferMoneyMap.get("p_cursor");
        //返回前端页面格式数据（"msg","code","count","data"）
        HashMap hashMap = new HashMap<>();
        hashMap.put("msg","");
        hashMap.put("code",0);
        hashMap.put("count",count);
        hashMap.put("data",transferMoneyList);
        return hashMap;
    }

    /**
     * 新增划款指令表的方法
     * @param transferMoneyPojo 划款指令表的实体类
     * @param request request请求对象
     * @return 返回 1新增成功 0新增失败
     */
    @NGULog(message="新增划款指令表")
    @RequestMapping("/insertTransferMoney")
    public int insertTransferMoney(TransferMoneyPojo transferMoneyPojo,HttpServletRequest request){
        //工具类获取fundId,给实体类进行赋值
        String fundId = GetFundIdUtil.getFundId(request);
        transferMoneyPojo.setFoundId(fundId);
        return transferMoneyService.insertTransferMoney(transferMoneyPojo);
    }

    /**
     * 修改划款指令表的方法
     * @param transferMoneyPojo 划款指令表的实体类
     * @return 返回 1修改成功 0修改失败
     */
    @NGULog(message="修改划款指令表")
    @RequestMapping("/updateTransferMoney")
    public int updateTransferMoney(TransferMoneyPojo transferMoneyPojo){
        return transferMoneyService.updateTransferMoney(transferMoneyPojo);
    }

    /**
     * 删除划款指令表的方法
     * @param transferMoneyIds 划款指令表ID
     * @return 返回 1删除成功 0删除失败
     */
    @NGULog(message="删除划款指令表")
    @RequestMapping("/deleteTransferMoney")
    public int deleteTransferMoney(String transferMoneyIds){
        return transferMoneyService.deleteTransferMoney(transferMoneyIds);
    }



}
