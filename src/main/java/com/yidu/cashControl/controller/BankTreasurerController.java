package com.yidu.cashControl.controller;

import com.yidu.cashControl.pojo.BankTreasurerPojo;
import com.yidu.cashControl.service.BankTreasurerService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 资金调拨表
 * @Type 控制层
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/7
 **/
@RestController
@RequestMapping("/bankTreasurer")
public class BankTreasurerController {
    @Resource
    BankTreasurerService bankTreasurerService;


    /**
     * 查询资金调拨表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param dbTime 调拨日期
     * @param allocatingType 调拨类型 1代表存款利息 2代表申购赎回清算款 3代表买卖交易清算款 4代表债券利息 5存款业务 6两费
     * @param flag 调拨方向 1代表流入 -1代表流出
     * @return 返回hashMap对象
     */
    @NGULog(message="查询资金调拨表")
    @RequestMapping("/selectBankTreasurer")
    public HashMap selectBankTreasurer(int page,int limit,String dbTime,String allocatingType,String flag){
        //调用服务层的查询方法
        HashMap bankTreasurerMap = bankTreasurerService.selectBankTreasurer(page, limit,dbTime,allocatingType,flag);
        //获取bankTreasurerMap中的p_count，p_cursor的值，进行强转
        int count = (int) bankTreasurerMap.get("p_count");
        List<BankTreasurerPojo> bankTreasurerList= (List<BankTreasurerPojo>) bankTreasurerMap.get("p_cursor");
        //返回前端页面格式数据（"msg","code","count","data"）
        HashMap hashMap = new HashMap();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",bankTreasurerList);
        hashMap.put("count",count);
        return hashMap;
    }

    /**
     * 新增资金调拨表的方法
     * @param bankTreasurerPojo 资金调拨表实体类
     * @param request request请求对象
     * @return 返回 1新增成功 0 新增失败
     */
    @NGULog(message="新增资金调拨表")
    @RequestMapping("/insertBankTreasurer")
    public int insertBankTreasurer(BankTreasurerPojo bankTreasurerPojo, HttpServletRequest request){
       //工具类获取fundId
        String fundId = GetFundIdUtil.getFundId(request);
        bankTreasurerPojo.setFundId(fundId);
        return bankTreasurerService.insertBankTreasurer(bankTreasurerPojo);
    }

    /**
     * 修改资金调拨表的方法
     * @param bankTreasurerPojo 资金调拨表实体类
     * @return 返回 1修改成功 0 修改失败
     */
    @NGULog(message="修改资金调拨表")
    @RequestMapping("/updateBankTreasurer")
    public int updateBankTreasurer(BankTreasurerPojo bankTreasurerPojo){
        return bankTreasurerService.updateBankTreasurer(bankTreasurerPojo);
    }

    /**
     * 根据资金调拨表Id删除资金调拨表的方法
     * @param bankTreasurerIds 资金调拨表Id
     * @return 返回 1删除成功 0 删除失败
     */
    @NGULog(message="删除资金调拨表")
    @RequestMapping("/deleteBankTreasurer")
    public int deleteBankTreasurer(String bankTreasurerIds){
        return bankTreasurerService.deleteBankTreasurer(bankTreasurerIds);
    }
}
