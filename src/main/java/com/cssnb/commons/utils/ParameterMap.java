package com.cssnb.commons.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ParameterMap {

	/**
	 * 查询参数列表
	 * @作者: 卜繁晟
	 * @创时: 2013-1-31 下午4:02:14
	 */
	private static Map getParameterMap(Map pMap){
		Map map = new HashMap();
		Object[] tempKey = pMap.keySet().toArray(), temp;
		for(int i = 0; i < tempKey.length; i++){
			temp = ((Object[]) pMap.get(tempKey[i]));
			if(temp.length > 0 && temp[0] != null && !"".equals(tempKey)){
				try{
					for(int j = 0; j < temp.length; j++){
						temp[j] = new String(temp[j].toString().getBytes("ISO-8859-1"), "UTF-8");
					}
				}catch(UnsupportedEncodingException e){
					e.printStackTrace();
				}
			}
			map.put(tempKey[i], temp != null ? (temp.length > 1 ? temp : temp[0]) : temp);
		}
		return map;
	}
	/**
	 * 是否需要转码
	 * @作者: 卜繁晟
	 * @创时: 2013-3-27 下午4:07:46
	 */
	private static Map getParameterMap(Map pMap, boolean convert){
		Map map = new HashMap();
		Object[] tempKey = pMap.keySet().toArray(), temp;
		for(int i = 0; i < tempKey.length; i++){
			temp = ((Object[]) pMap.get(tempKey[i]));
			if(temp.length > 0 && temp[0] != null && !"".equals(tempKey)){
				try{
					if(convert){
						for(int j = 0; j < temp.length; j++){
							temp[j] = new String(temp[j].toString().getBytes("GBK"), "ISO-8859-1");
						}
					}
				}catch(UnsupportedEncodingException e){
					e.printStackTrace();
				}
			}
			map.put(tempKey[i], temp != null ? (temp.length > 1 ? temp : temp[0]) : temp);
		}
		return map;
	}
	/**
	 * 查询参数列表
	 * @作者: 卜繁晟
	 * @创时: 2013-1-15 下午2:51:45
	 */
	public static Map getParameterMap(HttpServletRequest request){
		return getParameterMap(request.getParameterMap());
	}
	/**
	 * 是否转码
	 * @作者: 卜繁晟
	 * @创时: 2013-3-27 下午4:10:02
	 */
	public static Map getParameterMap(HttpServletRequest request, boolean convert){
		return getParameterMap(request.getParameterMap(), convert);
	}
}