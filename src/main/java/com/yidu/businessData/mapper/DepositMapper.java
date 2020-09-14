package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.DepositPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * 存款业务表
 * @Type dao层
 * @author 黄志豪
 * @version 1.0
 * @time 2020/9/7
 **/
@Mapper
public interface DepositMapper {
    /**
     * 查询存款业务的方法
     * @param hashMap  hashMap对象
     */
    public void  selectDeposit(HashMap hashMap);

    /**
     * 新增存款业务的方法
     * @param depositPojo 存款业务的实体类
     * @return  1代表新增成功  0代表新增失败
     */
    public int insertDeposit(DepositPojo depositPojo);

    /**
     * 修改存款业务的方法
     * @param depositPojo 存款业务的实体类
     * @return 1代表修改成功 0代表修改失败
     */
    public int updateDeposit(DepositPojo depositPojo);

    /**
     * 根据存款id删除存款业务的方法
     * @param depositId  存款id
     * @return 1代表删除成功 0代表删除失败
     */
    public int deleteDeposit(String depositId);
}
