package com.cssnb.wwxt.demo.ajaxupload.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 * Spring文件上传类整理
 * @author 卜繁晟
 * @version 1.x
 * @data 2011年9月9日
 */
@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public class UploadUtils {

	FileNameUtil fnu = new FileNameUtil();
	private String filePath = "/resources/upload"; // 根据不同项目给分配不同的上传文件夹
	private String limit = "mp3;gif;jpg;png"; // 允许上传的文件格式(e.g:mp3;gif;jpg)

	/**
	 * <p>
	 * <b>这个不能用，他用的是apache的FileUpload</b>
	 * 功能描述：使用fileupload components 上传多个文件
	 * </p>
	 */
	public List<Map> UploadFilesByFileupload(HttpServletRequest request){
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		List<Map> resultList = new ArrayList<Map>();
		if(!isMultipart){ return resultList; }
		String userfilepath = request.getRealPath("upload");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(2 * 1024 * 1024);// 2MB
		factory.setRepository(new File(userfilepath));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(50 * 1024 * 1024);// 50MB
		try{
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item : items){
				if(item.isFormField()){
					// 普通表单
				}else{
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					// 如果文件域没有填写内容，或者填写的文件不存在
					if("".equals(fileName) || item.getSize() == 0){
						continue;
					}
					String date = "/" + fnu.getDate8() + "/";
					String extName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
					String newfilename = fnu.getUUID() + "." + extName;
					File uploadedFile = new File(userfilepath + date + newfilename);
					if(!uploadedFile.exists()){// 如果要写入的文件或目录不存在，那么试着创建要写入的目录，以便写入文件
						uploadedFile.getParentFile().mkdirs();
					}
					item.write(uploadedFile);
					Map tmpfile = new HashMap<String, String>();
					tmpfile.put("fieldname", fieldName);
					tmpfile.put("filename", fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length()));
					tmpfile.put("extname", extName);
					tmpfile.put("filepath", "/upload" + date + newfilename);
					resultList.add(tmpfile);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultList;
	}
	/**
	 * 批量上传
	 * @作者: 卜繁晟
	 * @创时: 2013-2-9 下午5:04:24
	 */
	public List<Map> upload(HttpServletRequest request, List<FileItem> items){
		String userfilepath = "";
		List<Map> resultList = new ArrayList<Map>();
		try{
			for(FileItem item : items){
				if(item.isFormField()){
					// 普通表单
				}else{
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					// 如果文件域没有填写内容，或者填写的文件不存在
					if("".equals(fileName) || item.getSize() == 0){
						continue;
					}
					String date = "/" + fnu.getDate8() + "/";
					String extName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
					String newfilename = fnu.getUUID() + "." + extName;
					File uploadedFile = new File(userfilepath + date + newfilename);
					if(!uploadedFile.exists()){// 如果要写入的文件或目录不存在，那么试着创建要写入的目录，以便写入文件
						uploadedFile.getParentFile().mkdirs();
					}
					item.write(uploadedFile);
					Map tmpfile = new HashMap<String, String>();
					tmpfile.put("fieldname", fieldName);
					tmpfile.put("filename", fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length()));
					tmpfile.put("extname", extName);
					tmpfile.put("filepath", "/upload" + date + newfilename);
					resultList.add(tmpfile);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultList;
	}
	public Map upload(HttpServletRequest request, FileItem item){
		Map mapList = new HashMap();
		try{
			if(item.isFormField()){
				// 普通表单
			}else{
				String fieldName = item.getFieldName();
				String fileName = item.getName();
				// 如果文件域没有填写内容，或者填写的文件不存在
				if("".equals(fileName) || item.getSize() == 0){ return mapList; }
				String userfilepath = request.getRealPath("upload");
				String date = "/" + fnu.getDate8() + "/";
				String extName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
				String newfilename = fnu.getUUID() + "." + extName;
				File uploadedFile = new File(userfilepath + date + newfilename);
				if(!uploadedFile.exists()){// 如果要写入的文件或目录不存在，那么试着创建要写入的目录，以便写入文件
					uploadedFile.getParentFile().mkdirs();
				}
				item.write(uploadedFile);
				mapList.put("fieldname", fieldName);
				mapList.put("filename", fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length()));
				mapList.put("extname", extName);
				mapList.put("filepath", userfilepath + date + newfilename);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mapList;
	}
	/**
	 * 批量上传文件
	 * 参数：request
	 * @作者: 卜繁晟
	 * @创时: 2013-2-9 下午4:55:30
	 */
	public List<Map> upload(HttpServletRequest request) throws IOException{
		if(request == null){return null;}
		String fieldName, fileName = null, filePath = getFolder(request);
		List<Map> fileList = new ArrayList<Map>();
		CommonsMultipartFile cFile = null;
		File uploadedFile = null;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map map = multipartRequest.getFileMap();
		
		for(int i = 0; i < map.size(); i++){
			Object[] keys = map.keySet().toArray();
			if(keys.length > 0){
				// 页面表单的name值
				fieldName = keys[i].toString();
				cFile = (CommonsMultipartFile) multipartRequest.getFile(fieldName);
				if(cFile != null){
					fileName = getFileName(cFile.getOriginalFilename());
					uploadedFile = new File(filePath + fileName);
				}
			}
			// 如果要写入的文件或目录不存在，那么试着创建要写入的目录，以便写入文件
			File dic = new File(filePath);
			boolean fileExists = dic.exists();
			if(!fileExists){
				fileExists = dic.mkdirs();
			}
			// 如果创建成功, 执行
			if(fileExists){
				Map fileMap = new HashMap();
				FileCopyUtils.copy(cFile.getBytes(), uploadedFile);
				fileMap.put("filePath", filePath);
				fileMap.put("fileName", fileName);
				fileMap.put("serverPath", getServerPath(request, filePath) + fileName);
				fileList.add(fileMap);
			}
		}
		return fileList;
	}
	private String getFileName(String fileName){
		return fnu.getNewFileName(fileName);
	}
	private String getServerPath(HttpServletRequest request, String filePath){
		String path = filePath.replace("\\", "/");
		String contextPath = request.getContextPath().substring(1);
		if(filePath.contains(contextPath)){
			path = "/" + filePath.substring(filePath.indexOf(contextPath));
		}
		return path;
	}
	private String getFolder(HttpServletRequest request){
		return request.getSession().getServletContext().getRealPath(this.filePath).replace("\\", "/") + "/" + fnu.getDate8() + "/";
	}
}