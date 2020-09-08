package com.yidu.systemManage.pojo;

/**
 * 角色的实体类
 * @author kangshao
 * @version 1.0
 * @Type:角色的实体类
 * @time:2020-9-1 22:23
 **/
public class RolePojo {
    private int roleId;
    private String roleName;
    private String roleDesc;
    private int status;
    private String statusString; //通过status的状态进行赋值，并传递给前端显示

    public RolePojo() {
    }

    public RolePojo(int roleId, String roleName, String roleDesc, int status, String statusString) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.status = status;
        this.statusString = statusString;
    }

    @Override
    public String toString() {
        return "RolePojo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", status=" + status +
                ", statusString='" + statusString + '\'' +
                '}';
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }
}
