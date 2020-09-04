package com.yidu.systemManage.pojo;

/**
 * 用户的实体类
 * date:2020.9.1 11:12
 * @author xbf
 * @version 1.1
 */
public class UserInfoPojo {
    private int userId;
    private String userName;
    private String userPwd;
    private String roleId;
    private int status;
    private String userInfoDesc;

    public UserInfoPojo() {
    }

    public UserInfoPojo(int userId, String userName, String userPwd, String roleId, int status, String userInfoDesc) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.roleId = roleId;
        this.status = status;
        this.userInfoDesc = userInfoDesc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
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
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", roleId='" + roleId + '\'' +
                ", status=" + status +
                ", userInfoDesc='" + userInfoDesc + '\'' +
                '}';
    }
}
