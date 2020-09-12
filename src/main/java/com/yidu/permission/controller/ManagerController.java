package com.yidu.permission.controller;

import com.yidu.permission.pojo.Manager;
import com.yidu.permission.service.ManagerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cai
 */
@RestController
@RequestMapping("manager")
public class ManagerController {
    @Resource
    ManagerService managerService;
    @RequestMapping("selectManager")
    public List<Manager> selectManager(){
        List<Manager> managerList = managerService.selectManager();
        return managerList;
    }
}
