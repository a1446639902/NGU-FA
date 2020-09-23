package com.yidu.businessData.service;

import com.yidu.businessData.pojo.DepositPojo;

import java.util.HashMap;

/**
 * 存款业务表
 * @Type 服务层
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/9
 **/
public interface DepositService {
    /**
     * 查询存款业务的方法
     * @param page  当前页码
     * @param limit  每页显示的条数
     * @param businessType   业务类型
     * @param dateEnd       到期日期
     * @return  返回hashMap对象
     */
    public HashMap selectDeposit(int page,int limit,String businessType,String dateEnd);

    /**
     * 新增存款业务的方法
     * @param depositPojo 存款业务的实体类
     * @return 返回值为1代表新增成功  0代表新增失败
     */
    public int insertDeposit(DepositPojo depositPojo);

    /**
     * 修改存款业务的方法
     * @param depositPojo 存款业务的实体类
     * @return 返回值为1代表修改成功  0代表修改失败
     */
    public int updateDeposit(DepositPojo depositPojo);

    /**
     *根据depositId删除存款业务的信息
     * @param depositId  存款Id
     * @return 返回值为1代表删除成功  0代表删除失败
     */
    public int deleteDeposit(String depositId);
}
