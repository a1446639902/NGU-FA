package com.yidu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取基金Id的工具类
 * @author cai
 */

public class GetFundIdUtil {
    /**
     * 获取fundId的方法
     * @param request
     * @return
     */
    public static String getFundId(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session==null){
            session=request.getSession();
        }
        String fundId = (String) session.getAttribute("fundId");
        return fundId;
    }
}
