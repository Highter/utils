package com.yjw.utils.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 0006:配置文件工具类
 * @author Administrator
 * @date 下午3:49:55,2016年7月11日
 * @vesion 1.0
 * @see yjwsmileatlife@126.com
 */

public class PropertiesUtils {

	
	/**
	 * 0006001：获取文件的 Properties 对象
	 * @param fileName
	 * @return 
	 */
	public static Properties getProperty(String fileName){
		Properties props = null;
		try {
			props = PropertiesLoaderUtils.loadAllProperties(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
	
	/**
	 * 0006002：根据 文件名、key 获取value值
	 * @param name
	 * @param fileName
	 * @return
	 */
	public static String getPropertyValue(String name,String fileName){
		String result = null;
		Properties props;
		try {
			props = PropertiesLoaderUtils.loadAllProperties(fileName);
			result = props.getProperty(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 0006003：获取文件的 Properties 对象
	 * @param url
	 * @return
	 */
	public static Properties loadProperties(String url){
		Properties properties = null;
		try {
			properties = new Properties();
			InputStream in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(url);
			properties.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static void main(String[] args) {
		Properties pro = loadProperties("test.properties");
		
		//key值
		String key = "testUrl";
		String testUrl = pro.getProperty(key);
		System.out.println(key+"---"+testUrl);
	}
	
}
