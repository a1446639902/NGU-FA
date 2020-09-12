package com.yidu.permission.controller;


import com.yidu.businessParameter.mapper.AccountMapper;
import com.yidu.businessParameter.pojo.AccountPojo;
import com.yidu.permission.pojo.UserInfo;
import com.yidu.permission.service.UserService;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    AccountMapper accountMapper;
    //验证登录
    @RequestMapping("checkLogin")
    public Map<String,Object> checkLogin(String userName, String userPwd, String fundId, HttpServletRequest request){
        System.out.println("userName="+userName+",userPwd="+userPwd+",fundId="+fundId);

        //存放返回状态的map集合
        Map<String, Object> map = new HashMap<>();
        //存放用户账号密码的map集合
        Map<String, String> map2 = new HashMap<>();
        //在集合里面存放账号和密码
        map2.put("userName",userName);
        map2.put("userPwd",userPwd);

        //调用数据库查询是否有该用户
        int i = userService.selectUser1(map2);
        //若存在 返回状态code1  把用户名和基金id放入session中
        //反之 返回状态code0
        if (i>0){
            //通过基金id获取到账户
            AccountPojo accountPojo = accountMapper.selectAccountName(fundId);
            //获取账户id
            String accountId = accountPojo.getAccountId();
            //获取账户名称
            String accountName = accountPojo.getAccountName();
       /*     System.out.println("accountId="+accountId);
            System.out.println("accountName="+accountName);*/
            map.put("code",1);
            HttpSession session = request.getSession(false);
            if (session!=null){
                session=request.getSession();
            }
            session.setAttribute("userName",userName);
            session.setAttribute("userPwd",userPwd);
            session.setAttribute("fundId",fundId);
            session.setAttribute("accountId",accountId);
            session.setAttribute("accountName",accountName);

        }else {
            map.put("code", 0);
        }
        return map;
    }
    //退出登录
    @RequestMapping("logout")
    public Map<String ,Object> logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.removeAttribute("userName");
        session.removeAttribute("fundId");
        Map<String, Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg","已退出，3秒后转跳到登录页面！");
        return map;
    }
}
