package org.eacan.server.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-8-19
 * 类描述: 日志工具类
 * 版本:
 */
public class LogUtil {
    private final static String LOG_HOME = "loghome";

    static {
        try {
            Properties properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("log4j.properties"));
            PropertyConfigurator.configure(properties);
            String loghome = properties.getProperty(LOG_HOME);
            if (StringUtils.isNotEmpty(loghome)){
                System.setProperty(LOG_HOME, StringUtils.trim(loghome));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static Logger instance = null;

    public static Logger getDefaultInstance(){
        if (instance == null) {
            synchronized (LogUtil.class){
                if (instance == null){
                    instance = Logger.getLogger("LOGGER");
                }
            }
        }
        return instance;
    }

    /**
     *
     * @param clazz
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Logger getInstance(Class clazz){
        if (clazz == null)
            return null;
        return Logger.getLogger(clazz);
    }

    /**
     *
     * @param className
     * @return
     */
    public static Logger getInstance(String className){
        if (className == null)
            return null;
        return Logger.getLogger(className);
    }
}
