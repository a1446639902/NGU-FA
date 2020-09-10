package com.yidu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取session里面数据的工具类
 * @author cai
 */
public class GetAccountUtil {
    /**
     * 获取accountId的方法
     * @param request
     * @return
     */
    public static String getAccountId(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session==null){
            session=request.getSession();
        }
        String accountId = (String) session.getAttribute("accountId");
        return accountId;
    }
    /**
     * 获取accountName的方法
     * @param request
     * @return
     */
    public static String getAccountName(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session==null){
            session=request.getSession();
        }
        String accountName = (String) session.getAttribute("accountName");
        return accountName;
    }
}
