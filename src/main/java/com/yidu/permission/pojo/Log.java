package com.yidu.permission.pojo;

import java.io.Serializable;

public class Log implements Serializable {
    private Integer logId;

    private String time;

    private String host;

    private String method;

    private String uri;

    private String userName;

    private String message;


    private static final long serialVersionUID = 1L;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", time='" + time + '\'' +
                ", host='" + host + '\'' +
                ", method='" + method + '\'' +
                ", message='" + message + '\'' +
                ", uri='" + uri + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}