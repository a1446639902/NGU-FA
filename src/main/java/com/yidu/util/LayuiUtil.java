package com.yidu.util;

import java.util.HashMap;
import java.util.List;

public class LayuiUtil extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;
	
	private LayuiUtil () {
	}
	public static <T> LayuiUtil layuiUtils(Integer count, List<T> data){
		LayuiUtil r = new LayuiUtil();
		r.put("code", 0);
		r.put("msg", "");
		r.put("count", count);
		r.put("data", data);
		return r;
	}
}