package com.yidu.permission.service.impl;


import com.yidu.permission.mapper.DateManageMapper;
import com.yidu.permission.service.DateManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DateManageServiceImpl implements DateManageService {

	@Resource
	DateManageMapper dateManageMapper;

	@Override
	public int insertDate(String strList) {
		try {
			String[] dateList = strList.split(",");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < dateList.length; i++) {
				list.add(dateList[i]);
			}
			dateManageMapper.deleteDate(list);
			dateManageMapper.insertDate(list);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<String> selectDate(String date) {
		date=date==null?"":date;
		System.err.println("err:"+date);
		return dateManageMapper.selectDate("%"+date+"%");
	}

	
}
