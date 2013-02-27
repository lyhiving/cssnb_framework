/**
 * 
 */
package com.cssnb.commons.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-21上午9:50:17
 * 类说明：
 * 
 */
public class CssStringUtils {

	/**
	 * 返回驼峰法命名的字符串
	 * @param src 源字符串
	 * @return 
	 * ex:aaa -> Aaa,aaa_sss_fff -> AaaSssFff
	 */
	public static String toCamelString(String src){
	    if (src == null || src.length() == 0) {       
	    	return "";
	    }
	    String[] strs = src.toLowerCase().split("_");
	    String dest = "";
	    for (String str1 : strs) {
			str1 = StringUtils.capitalize(str1);
			dest+=str1;
		}
	    return dest;
	}
	
	public static void main(String[] args) {
		String a = "aaaa_sss_fff";
		System.out.println(CssStringUtils.toCamelString(a));
	}
}
