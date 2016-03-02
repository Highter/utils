package com.yjw.utils.string;

/**
 *0002:字符串工具类
 *@author Higher
 *@date 12:27:52 AM,Mar 1, 2016
 *@vesion v1.0
 *@see yjwsmileatlife@126.com
 *@ref http://my.oschina.net/u/1453975/blog/529521
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

	/**
	 * 注意：为了继承 org.apache.commons.lang3.StringUtils，需要在pom.xml文件中引入
	 *
	<dependency>
		<groupId>org.apache.commons</groupId>
		<artifactId>commons-lang3</artifactId>
		<version>${commons-lang3-version}</version>
	</dependency>
	 *
	 */
	
	/**
	 * 00020001:一次性判断多个或单个对象为空。
	 * @author Higher
	 * @param objects
	 * @return 只要有一个元素为Blank，则返回true
	 */
	public static boolean isBlank(Object...objects){
		Boolean result = false;
		for(Object object:objects){
			if(object==null || "".equals(object.toString().trim())
					|| "null".equals(object.toString().trim())
					|| "[null]".equals(object.toString().trim())
					|| "[]".equals(object.toString().trim())){
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 00020002:一次性判断多个或单个对象不为空。
	 * @author Higher
	 * @param objects
	 * @return 只要有一个元素不为Blank，则返回true
	 */
	public static boolean isNotBlank(Object...objects){
		return !isBlank(objects);
	}
	
	/**
	 * 00020003:处理空对象类型返回字符串类型
	 * @param obj
	 * @return
	 */
	public static String checkNullToConvert(Object obj){
		return StringUtils.isBlank(obj) ? "":obj.toString();
	}
	
	/**
	 * 00020004:判断一个字符串在数组中存在几个
	 * @param baseStr
	 * @param strings
	 * @return 
	 */
	public static int indexOf(String baseStr,String[] strings){
		if(null == baseStr || null == strings || 0==strings.length){
			return 0;
		}
		int i = 0;
		for(String str:strings){
			boolean result = baseStr.equals(str);
			i = result ? ++i : i;
		}
		return i;
	}
	
	/**
	 * 00020005:替换字符串
	 * @param str
	 * @param nowStr
	 * @param replaceStr
	 * @return
	 */
	public static String replaceString(String str,String nowStr,String replaceStr){
		nowStr = StringUtils.isBlank(nowStr) ? "" : nowStr;
		replaceStr = StringUtils.isBlank(replaceStr) ? "" : replaceStr;
		if(StringUtils.isNotBlank(str)){
			return str.replaceAll(nowStr, replaceStr);
		}
		return "";
	}
	
	 /**
     * 00020006:判断一个字符串是否为JSONObject,是返回JSONObject,不是返回null
     * @param args
     * @return
     */
    public static net.sf.json.JSONObject isJSONObject(Object args) {
        net.sf.json.JSONObject result = null ;
         
        if(args instanceof net.sf.json.JSONObject){
            return (net.sf.json.JSONObject)args;
        }
         
        if(isBlank(args)){
            return result ;
        }
        try {
            return net.sf.json.JSONObject.fromObject(args);
        } catch (Exception e) {
            return result ;
        }
    }
	
	public static void main(String[] args) {
		//测试00020001:一次性判断多个或单个对象为空
		String strNull = "nullStr";
		String strNotNull = "notNullStr";
		System.out.println("00020001:"+isBlank(strNull,strNotNull));
		
		//测试00020002:一次性判断多个或单个对象不为空
		System.out.println("00020002:"+isNotBlank(strNull,strNotNull));
		
		//测试 00020003:处理空对象类型返回字符串类型
		String str003 = "Hello world";
		System.out.println("00020003:"+checkNullToConvert(str003));
		
		//测试00020004:判断一个字符串在数组中存在几个
		String[] strings004 = new String[]{"H","e","l","l","o","w","o","r","l","d"};
		System.out.println("00020004:"+indexOf("l",strings004));
		
		//测试00020005:替换字符串
		String str0005 = "Hello world";
		String nowStr005 = "l";
		String replaceStr005 = "i";
		System.out.println("00020005:"+replaceString(str0005, nowStr005, replaceStr005));
		
		//测试00020006:判断一个字符串是否为JSONObject,是返回JSONObject,不是返回null
		String arg0006 = "{'userName': 'yjw','password': '123456','email': 'yjwsmileatlife@126.com'}";
		System.out.println("00020006:"+isJSONObject(arg0006));
	}
}
