package com.cssnb.commons.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharsetUtils {

	/**
	 * 页面GBK请求转码-eclipse查看为乱码，但保证到数据库为中文
	 * @Description:
	 * @Author(svn): BuFanSheng
	 * @Created Date: 2012-2-24
	 * @param map
	 * @return
	 */
	public static Map getGbkToUtf8Map(Map map){
		Object[] keys = map.keySet().toArray();
		try{
			for(int i = 0; i < map.size(); i++){
				String param = (String) map.get(keys[i]);
				param = new String((new String(param.toString().getBytes("ISO-8859-1"), "UTF-8")).getBytes("GB2312"), "ISO-8859-1");
				map.put(keys[i], param);
			}
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * Oracle中文库GBK页面中文显示
	 * @Description: Oracle中文库，转换到GBK页面中文能正常显示
	 * @Author: 卜繁晟
	 * @Created Date: 2012-4-20
	 * @param list
	 * @return
	 */
	public static List getGbkTo8859_1List(List list){
		List new_list = new ArrayList();
		Map map;
		try{
			for(int i = 0; i < list.size(); i++){
				map = (Map) list.get(i);
				Object[] keys = map.keySet().toArray();
				for(int j = 0; j < map.size(); j++){
					Object param = map.get(keys[j]);
					if(param != null){
						param = new String(param.toString().getBytes("GBK"), "ISO-8859-1");
						map.put(keys[j], param);
					}
				}
				new_list.add(map);
			}
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return new_list;
	}
	/**
	 * List转码
	 * @Description: 
	 * @Author: 卜繁晟
	 * @Created Date: 2012-4-27
	 * @param list 数据集合
	 * @param oldEncoding OldEncoding
	 * @param newEncoding NewEncoding
	 * @return
	 */
	public static List getEncodingList(List list, String oldEncoding, String newEncoding){
		List new_list = new ArrayList();
		Map new_map;
		try{
			for(int i = 0; i < list.size(); i++){
				new_map = (Map) list.get(i);
				Object[] keys = new_map.keySet().toArray();
				for(int j = 0; j < new_map.size(); j++){
					Object param = new_map.get(keys[j]);
					if(param != null){
						param = new String(param.toString().getBytes(oldEncoding), newEncoding);
						new_map.put(keys[j], param);
					}else{
						new_map.put(keys[j], null);
					}
				}
				new_list.add(new_map);
			}
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return new_list;
	}
	/**
	 * Map转码
	 * @Description: 
	 * @Author: 卜繁晟
	 * @Created Date: 2012-4-27
	 * @param map 数据集
	 * @param oldEncoding OldEncoding
	 * @param newEncoding NewEncoding
	 * @return
	 */
	public static Map getEncodingMap(Map map, String oldEncoding, String newEncoding){
		Map new_map = new HashMap();
		try{
			Object[] keys = map.keySet().toArray();
			for(int j = 0; j < map.size(); j++){
				Object param = map.get(keys[j]);
				if(param != null){
					param = new String(param.toString().getBytes(oldEncoding), newEncoding);
					new_map.put(keys[j], param);
				}else{
					new_map.put(keys[j], null);
				}
			}
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return new_map;
	}
	/**
	 * 字符串转码
	 * @Description: 字符串转码
	 * @Author: 卜繁晟
	 * @Created Date: 2012-4-27
	 * @param str 将要转换的字符串
	 * @param oldEncoding OldEncoding
	 * @param newEncoding NewEncoding
	 * @return
	 */
	public static String getEncodingString(String str, String oldEncoding, String newEncoding){
		String new_str = "";
		try{
			new_str = new String(str.getBytes(oldEncoding), newEncoding);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return new_str;
	}
	/**
	 * @Author: 卜繁晟
	 * @Created Date: 2012-9-29 下午12:37:12
	 */
	public static Object getEncodingObject(Object object, String oldEncoding, String newEncoding){
		Object new_obj = null;
		try{
			if(object != null){
				new_obj = new String(object.toString().getBytes(oldEncoding), newEncoding);
			}
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return new_obj;
	}
}
