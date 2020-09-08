package com.yidu.permission.pojo;

/**
 * 菜单栏实体类
 */
public class SystemMenu {

    private int functionId;     //功能ID
    private int parentId;       //父功能ID
    private String  title;      //功能含义
    private String  src;        //引用地址
    private String  icon;       //图标
    private String  target;     //打开方式

    public SystemMenu() {
    }

    public SystemMenu(int functionId, int parentId, String title, String src, String icon, String target) {
        this.functionId = functionId;
        this.parentId = parentId;
        this.title = title;
        this.src = src;
        this.icon = icon;
        this.target = target;
    }

    public int getFunctionId() {
        return functionId;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "SystemMenu{" +
                "functionId=" + functionId +
                ", parentId=" + parentId +
                ", title='" + title + '\'' +
                ", src='" + src + '\'' +
                ", icon='" + icon + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
