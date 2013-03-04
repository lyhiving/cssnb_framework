package com.cssnb.admin.aop.model;

import java.io.Serializable;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5346611738619579006L;
	public static final String USER_ENABLED="1";
	private int yhid;
	private String yhm;	//用户登陆账户
	private String yhmm;	//用户登录密码
	private String yhmc;	//用户登录名称
	
	private String bmid;		//用户所属部门ID
	private String zt;		//状态
	private String yhip;		//登录ip
	private String lastlogintime;	//上次登录时间
	private String yhdh;		//电话
	private String email;		//电子邮件
	private String bz;		//备注
	private String fw;//前台后台
	private String dlip;//登录ip地址
	private String zmk;//子模块传值
	public String getZmk() {
		return zmk;
	}
	public void setZmk(String zmk) {
		this.zmk = zmk;
	}
	public String getDlip() {
		return dlip;
	}
	public void setDlip(String dlip) {
		this.dlip = dlip;
	}
	public String getFw() {
		return fw;
	}
	public void setFw(String fw) {
		this.fw = fw;
	}
	public int getYhid() {
		return yhid;
	}
	public void setYhid(int yhid) {
		this.yhid = yhid;
	}
	public String getYhm() {
		return yhm;
	}
	public void setYhm(String yhm) {
		this.yhm = yhm;
	}
	public String getYhmm() {
		return yhmm;
	}
	public void setYhmm(String yhmm) {
		this.yhmm = yhmm;
	}
	public String getBmid() {
		return bmid;
	}
	public void setBmid(String bmid) {
		this.bmid = bmid;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getYhip() {
		return yhip;
	}
	public void setYhip(String yhip) {
		this.yhip = yhip;
	}
	public String getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public String getYhdh() {
		return yhdh;
	}
	public void setYhdh(String yhdh) {
		this.yhdh = yhdh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getYhmc() {
		return yhmc;
	}
	public void setYhmc(String yhmc) {
		this.yhmc = yhmc;
	}
}

