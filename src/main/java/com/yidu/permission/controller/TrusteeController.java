package com.yidu.permission.controller;


import com.yidu.permission.pojo.Trustee;
import com.yidu.permission.service.TrusteeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cai
 */
@RestController
@RequestMapping("trustee")
public class TrusteeController {
    @Resource
    TrusteeService trusteeService;
    @RequestMapping("selectTrustee")
    public List<Trustee> selectTrustee(){
        List<Trustee> trusteeList = trusteeService.selectTrustee();
        return trusteeList;
    }
}
