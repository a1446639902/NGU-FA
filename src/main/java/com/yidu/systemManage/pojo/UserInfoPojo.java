package com.yidu.systemManage.pojo;

/**
 * 用户的实体类
 * date:2020.9.1 11:12
 * @author xbf
 * @version 1.1
 */
public class UserInfoPojo {
    private String userId;
    private String userName;
    private String userPwd;
    private int roleId;
    private int status;
    private String userInfoDesc;

    public UserInfoPojo() {
    }

    public UserInfoPojo(String userId, String userName, String userPwd, int roleId, int status, String userInfoDesc) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.roleId = roleId;
        this.status = status;
        this.userInfoDesc = userInfoDesc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserInfoDesc() {
        return userInfoDesc;
    }

    public void setUserInfoDesc(String userInfoDesc) {
        this.userInfoDesc = userInfoDesc;
    }

    @Override
    public String toString() {
        return "UserInfoPojo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", roleId=" + roleId +
                ", status=" + status +
                ", userInfoDesc='" + userInfoDesc + '\'' +
                '}';
    }
}
