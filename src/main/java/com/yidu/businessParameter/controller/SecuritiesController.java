package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.SecuritiesPojo;
import com.yidu.businessParameter.service.SecuritiesService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;

/**
 * 证券信息的控制类
 * date:2020.9.3
 * @author xbf
 * @version 1.1
 */
@RestController
public class SecuritiesController {
    @Resource
    SecuritiesService securitiesService;

    //添加
    @RequestMapping(value = "/insertSecurities",method = {RequestMethod.GET,RequestMethod.POST})
    public int insertSecurities(@ModelAttribute SecuritiesPojo securitiesPojo){
        int i = securitiesService.insertSecurities(securitiesPojo);
        return i;
    }

  /*  @RequestMapping("/insertSecurities")
    public void insertSecurities(){
        SecuritiesPojo securitiesPojo=new SecuritiesPojo("600990","天美集团",1,"20200822","20200823","003",1,"好汽油石化造");
        securitiesService.insertSecurities(securitiesPojo);
    }*/

    //修改
    @RequestMapping("/updateSecurities")
    public int updateUser(SecuritiesPojo securitiesPojo){
        return securitiesService.updateSecurities(securitiesPojo);
    }

  /*  @RequestMapping("/updateSecurities")
    public void updateSecurities(){
        SecuritiesPojo securitiesPojo=new SecuritiesPojo("600990","阿里巴巴集团",1,"20200822","20200823","003",1,"好汽油石化造");
        securitiesService.updateSecurities(securitiesPojo);
    }*/

    //删除
  /*  @RequestMapping("/deleteSecurities")
    public void deleteUser(){
         return securitiesService.deleteSecurities(1);
    }*/

    @RequestMapping("/deleteSecurities")
    public int deleteSecurities(String securitiesId){
        return securitiesService.deleteSecurities(securitiesId);
    }

    //查询
    @RequestMapping("/selectSecurities")
    public HashMap selectSecurities(int page,int limit,String securitiesId,String securitiesName){
        HashMap hashMap=securitiesService.selectSecurities(page,limit,securitiesId,securitiesName);
        int count=(int)hashMap.get("p_count");
        List<SecuritiesPojo> securitiesPojoList = (List<SecuritiesPojo>) hashMap.get("p_cursor");
        HashMap securitiesMap=new HashMap();
        securitiesMap.put("count",count);
        securitiesMap.put("code",0);
        securitiesMap.put("msg","");
        securitiesMap.put("data",securitiesPojoList);
        return securitiesMap;
    }

/*@RequestMapping("/selectSecurities")
        public List<SecuritiesPojo>selectSecurities(){
        List<SecuritiesPojo>securitiesPojoList=securitiesService.selectSecurities();
        System.out.println(securitiesPojoList);
        return securitiesPojoList;
    }*/


}
