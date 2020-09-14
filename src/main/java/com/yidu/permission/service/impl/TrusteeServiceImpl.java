package com.yidu.permission.service.impl;

import com.yidu.permission.mapper.TrusteeMapper;
import com.yidu.permission.pojo.Trustee;
import com.yidu.permission.service.TrusteeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cai
 */
@Service
@Transactional
public class TrusteeServiceImpl implements TrusteeService {
    @Resource
    TrusteeMapper trusteeMapper;
    @Override
    public List<Trustee> selectTrustee() {
        List<Trustee> trusteeList = trusteeMapper.selectTrustee();
        return trusteeList;
    }
}
