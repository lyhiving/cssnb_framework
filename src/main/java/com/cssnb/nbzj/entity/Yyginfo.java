package com.cssnb.nbzj.entity;

import java.sql.Timestamp;

public class Yyginfo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer yginfoId=0;
	private String yginfoTitle;
	private String yginfoType;
	private String yginfoFs;
	private String yginfoMemo;
	private String yginfoFiles;
	private Timestamp yginfoKssj;
	private Timestamp yginfoJzsj;
	private String yginfoState;
	private String yginfoCzy;
	private Timestamp yginfoTjsj;
	private String yginfoDw;

	public String getYginfoDw() {
		return yginfoDw;
	}
	public void setYginfoDw(String yginfoDw) {
		this.yginfoDw = yginfoDw;
	}
	public Integer getYginfoId() {
		return yginfoId;
	}
	public void setYginfoId(Integer yginfoId) {
		this.yginfoId = yginfoId;
	}
	public String getYginfoTitle() {
		return yginfoTitle;
	}
	public void setYginfoTitle(String yginfoTitle) {
		this.yginfoTitle = yginfoTitle;
	}
	public String getYginfoType() {
		return yginfoType;
	}
	public void setYginfoType(String yginfoType) {
		this.yginfoType = yginfoType;
	}
	public String getYginfoFs() {
		return yginfoFs;
	}
	public void setYginfoFs(String yginfoFs) {
		this.yginfoFs = yginfoFs;
	}
	public String getYginfoMemo() {
		return yginfoMemo;
	}
	public void setYginfoMemo(String yginfoMemo) {
		this.yginfoMemo = yginfoMemo;
	}
	public String getYginfoFiles() {
		return yginfoFiles;
	}
	public void setYginfoFiles(String yginfoFiles) {
		this.yginfoFiles = yginfoFiles;
	}
	public Timestamp getYginfoKssj() {
		return yginfoKssj;
	}
	public void setYginfoKssj(Timestamp yginfoKssj) {
		this.yginfoKssj = yginfoKssj;
	}
	public Timestamp getYginfoJzsj() {
		return yginfoJzsj;
	}
	public void setYginfoJzsj(Timestamp yginfoJzsj) {
		this.yginfoJzsj = yginfoJzsj;
	}
	public String getYginfoState() {
		return yginfoState;
	}
	public void setYginfoState(String yginfoState) {
		this.yginfoState = yginfoState;
	}
	public String getYginfoCzy() {
		return yginfoCzy;
	}
	public void setYginfoCzy(String yginfoCzy) {
		this.yginfoCzy = yginfoCzy;
	}
	public Timestamp getYginfoTjsj() {
		return yginfoTjsj;
	}
	public void setYginfoTjsj(Timestamp yginfoTjsj) {
		this.yginfoTjsj = yginfoTjsj;
	}

}
