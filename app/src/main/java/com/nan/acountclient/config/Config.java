package com.nan.acountclient.config;

/**
 * Created by wzn on 2016/11/28.
 */

public class Config {

    /**
     * 类的源包名
     */
    public final static String entity_package_path = "com.nan.acountclient.entity";
    /**
     * 数据库名字
     */
    public final static String db_name = "ACCOUNT_CLIENT_DB";
    /**
     * 数据库版本号
     */
    public final static int db_version = 1;
    /**
     * 是否显示log(小于0不显示)
     */
    public final static int LOGLEVEL = 1;
    /**
     * baseapi
     */
    public final static String BASE_API = "https://api.bmob.cn/1/classes";
    /**
     * 连接超时
     */
    public final static long networkTimeout = 10;
    public final static String app_id="df82286e794b8372837820348f10366a";
    public final static String rest_api_key="5136a69253734c0929301c084a9eca4e";
}
