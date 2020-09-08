package com.yidu.permission.controller;

import com.yidu.util.GetFundIdUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("page")
public class ViewController {
//    @RequestMapping("userDemo")
//    public String userDemo(){
//        return "userInfoTable";
//    }
//    @RequestMapping("addUserDemo")
//    public String addUserDemo(){
//        return "page/userDemo/addUserDemo1";
//    }
//    @RequestMapping("updateUserDemo")
//    public String updateUserDemo(){
//        return "userDemo/updateUserDemo1";
//    }

    @RequestMapping("*")
    public String getPage(HttpServletRequest req){
        String uri = req.getRequestURI();
        int length = uri.length();
        String reqUri = uri.substring(6, length);
        return reqUri;
    }

}
