package com.yidu.systemManage.controller;

import com.yidu.systemManage.pojo.FunctionPojo;
import com.yidu.systemManage.service.FunctionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能的控制类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@RestController
@RequestMapping("/fuction")
public class FunctionController {
    @Resource
    FunctionService functionService;

    //查询功能
    @RequestMapping("/selectFuction")
    public Map<String,Object> selectFuction(){
        HashMap hashMap = functionService.selectFunction();
        Map<String,Object> functionMap = new HashMap();
        //响应头
        functionMap.put("msg","");
        functionMap.put("code",0);

        //需要传递的游标变量
        functionMap.put("data", hashMap.get("p_cursor"));
        ArrayList cursorList = (ArrayList) hashMap.get("p_cursor");
        System.out.println("现在要输出游标变量"+cursorList);
        return functionMap;
    }

    //修改功能
    @RequestMapping("updateFuction")
    public int updateFuction(FunctionPojo functionPojo){
       return functionService.updateFuction(functionPojo);
    }
}
