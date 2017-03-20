package com.jxh.constant;
/**
 * 配置常量管理
 * @author jingxiaohu
 *
 */
public final class MyConstant {
	/**
	 * 服务器访问域名
	 */
	public static String domain = "app.qc-wbo.com";
	
	public static final  String BaseSavePath = "/home/data/file";
	public static final String SYSTEM_CHARACTER = "UTF-8"; 
	/**
	 * 系统通用加密代码串
	 */
	public static final String SYSTEM_KEY = "!*#@()@dfgdfgFasdafaaJ*asddas499NHIJ)file";
	/**
	 * 访问根地址
	 */
	public final static String BASE_URL = "http://"+domain+"/file/";
	/**
	 * 文件存放的根地址
	 */
	public final static String BASE_DIR = "/data/file/"+domain+"/ROOT";
	/**
	 * 用户头像存放路径
	 */
	public static String USER_AVATAR = "img/avatar";
	/**
	 * 用户行驶证存放路径
	 */
	public static String USER_LIENCE = "img/lience";
	/**
	 * 用户消息图片路径
	 */
	public static String USER_MSG = "img/msg";
    /**
     * 用户消息图片高
     */
	public final static int MSG_HIGHT = 800;
    /**
     * 用户消息图片宽
     */
	public final static int MSG_WIDTH = 480;
	/**
	 * 广告图片存放路径
	 */
	public static String IMG_ADVER = "img/adver";
    /**
     * 头像高
     */
	public final static int AVATAR_HIGHT = 120;
    /**
     * 头像宽
     */
	public final static int AVATAR_WIDTH = 120;
	
    /**
     * 行驶证高
     */
	public final static int LIENCE_HIGHT = 800;
    /**
     * 行驶证宽
     */
	public final static int LIENCE_WIDTH = 800;
	
}
