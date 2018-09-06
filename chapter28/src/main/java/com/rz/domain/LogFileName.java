package com.rz.domain;

import org.apache.commons.lang.StringUtils;

/**
 * 不同的业务类型输出日志到不同的文件
 * @author 18217
 */
public enum LogFileName {
	

    //配置到logback-spring.xml中的logger name="vipUser"
    XJK_USER("xjkUser"), //小金库用户
    BAITIAO_USER("baitiaoUser"); // 白条用户

    private String logFileName;

    LogFileName(String fileName) {
        this.logFileName = fileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public static LogFileName getAwardTypeEnum(String value) {
        LogFileName[] arr = values();
        for (LogFileName item : arr) {
            if (null != item && StringUtils.isNotBlank(item.logFileName)) {
                return item;
            }
        }
        return null;
    }

}
