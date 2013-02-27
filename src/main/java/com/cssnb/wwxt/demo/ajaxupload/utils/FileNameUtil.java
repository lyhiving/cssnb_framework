package com.cssnb.wwxt.demo.ajaxupload.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

/**
 * 文件名工具类 生成时间名
 * 
 * @author Administrator
 * 
 */
public class FileNameUtil {

	private List<String> tempRandoms = new ArrayList<String>();

	/**
	 * 
	 * @param fileName
	 * @return 返回文件名
	 */
	public String getNewFileName(String fileName){
		String newName = this.getLongTime() + random(1, 1000) + "." + this.getExt(fileName);
		if(this.tempRandoms.contains(newName)){
			getNewFileName(fileName);
		}else{
			this.tempRandoms.add(newName);
		}
		return newName;
	}
	public int random(int m, int n){/* 建立随机方法，生成的是m到n的整型数据 */
		int rand = 0;
		double temp = Math.random();/* 此方法产生的是0--1的浮点型数据 */
		rand = (int) (temp * (m - n) + n + 1);/* 实现方法要求 */
		return rand;
	}
	/**
	 * 
	 * @return 以精确到毫秒设置文件名
	 */
	public long getLongTime(){
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSSSS");
		df.setTimeZone(TimeZone.getTimeZone("GMT+8:00")); // 设置中国时区，默认为格林威治时区比中国时区少8个小时
		long curTime = Long.parseLong(df.format(new Date()));
		return curTime;
	}
	/**
	 * 返回文件小写后缀
	 * 
	 * @param fileName
	 * @return
	 */
	public String getExt(String fileName){
		int pos = fileName.lastIndexOf(".") + 1;
		String ext = fileName.substring(pos).toLowerCase();
		return ext;
	}
	public String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public Long getDate14(){
		return Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString());
	}
	public Long getDate8(){
		return Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()).toString());
	}
	public Long Calendar2Long(Calendar calendar, int length){
		String format = length == 8 ? "yyyyMMdd" : "yyyyMMddHHmmss";
		return Long.valueOf(new SimpleDateFormat(format).format(calendar.getTime()).toString());
	}
}
