/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.admin.aop.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取IP、MAC地址
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-6
 */
public class InetHelper {

	/**
	 * 获取当前操作系统名称.
	 * @return 操作系统名称，例如:windows,Linux,Unix等.
	 */
	public static String getOsName(){
		return System.getProperty("os.name").toLowerCase();
	}
	public static String getLocalMACAddress(){
		String address = "";
		String os = getOsName();
		if(os.startsWith("Windows")){
			try{
				String command = "cmd.exe /c ipconfig /all";
				Process p = Runtime.getRuntime().exec(command);
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while((line = br.readLine()) != null){
					if(line.indexOf("Physical Address") > 0){
						int index = line.indexOf(":");
						index += 2;
						address = line.substring(index);
						break;
					}
				}
				br.close();
				return address.trim();
			}catch(IOException e){}
		}else if(os.startsWith("Linux")){
			String command = "/bin/sh -c ifconfig -a";
			Process p;
			try{
				p = Runtime.getRuntime().exec(command);
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while((line = br.readLine()) != null){
					if(line.indexOf("HWaddr") > 0){
						int index = line.indexOf("HWaddr") + "HWaddr".length();
						address = line.substring(index);
						break;
					}
				}
				br.close();
			}catch(IOException e){}
		}
		address = address.trim();
		return address;
	}
	/**
	 * 获取Unix网卡的mac地址.
	 * @return mac地址
	 */
	public static String getUnixMACAddress(){
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try{
			/**
			 * Unix下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息
			 */
			process = Runtime.getRuntime().exec("ifconfig eth0");
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while((line = bufferedReader.readLine()) != null){
				/**
				 * 寻找标示字符串[hwaddr]
				 */
				index = line.toLowerCase().indexOf("hwaddr");
				/**
				 * 找到了
				 */
				if(index != -1){
					/**
					 * 取出mac地址并去除2边空格
					 */
					mac = line.substring(index + "hwaddr".length() + 1).trim();
					break;
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(bufferedReader != null){
					bufferedReader.close();
				}
			}catch(IOException e1){
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}
		return mac;
	}
	/**
	 * 获取Linux网卡的mac地址.
	 * @return mac地址
	 */
	public static String getLinuxMacAddress(){
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try{
			/**
			 * linux下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息
			 */
			process = Runtime.getRuntime().exec("ifconfig eth0");
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while((line = bufferedReader.readLine()) != null){
				index = line.toLowerCase().indexOf("硬件地址");
				/**
				 * 找到了
				 */
				if(index != -1){
					/**
					 * 取出mac地址并去除2边空格
					 */
					mac = line.substring(index + 4).trim();
					break;
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(bufferedReader != null){
					bufferedReader.close();
				}
			}catch(IOException e1){
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}
		return mac;
	}
	/**
	 * 获取widnows网卡的mac地址.
	 * @return mac地址
	 */
	public static String getWindowsMacAddress(){
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try{
			/**
			 * windows下的命令，显示信息中包含有mac地址信息
			 */
			process = Runtime.getRuntime().exec("ipconfig /all");
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while((line = bufferedReader.readLine()) != null){
				/**
				 * 寻找标示字符串[physical address]
				 */
				index = line.toLowerCase().indexOf("physical address");
				if(index != -1){
					index = line.indexOf(":");
					if(index != -1){
						/**
						 * 取出mac地址并去除2边空格
						 */
						mac = line.substring(index + 1).trim();
					}
					break;
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(bufferedReader != null){
					bufferedReader.close();
				}
			}catch(IOException e1){
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}
		return mac;
	}
	/**
	 * ip校验
	 * @param ip
	 * @return 格式是否正确
	 */
	public boolean isIpAddress(String ip){
		String regex = "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(ip);
		return m.matches();
	}
	/**
	 * 获取IP地址
	 * @param request
	 * @return ip 地址
	 */
	public String getIpAddress(HttpServletRequest request){
		String ip = request.getHeader("X-Forwarded-For");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("Proxy-Client-IP");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("WL-Proxy-Client-IP");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("HTTP_CLIENT_IP");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getRemoteAddr();
		return ip;
	}
	/**
	 * 获取MAC地址（支持win7）
	 * @作者: 卜繁晟
	 * @创时: 2013-1-6 上午10:22:27
	 */
	public static String getMacAddress(InetAddress ipAddr) throws Exception{
		// 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
		byte[] mac = NetworkInterface.getByInetAddress(ipAddr).getHardwareAddress();
		// 下面代码是把mac地址拼装成String
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < mac.length; i++){
			if(i != 0){
				sb.append("-");
			}
			// mac[i] & 0xFF 是为了把byte转化为正整数
			String s = Integer.toHexString(mac[i] & 0xFF);
			sb.append(s.length() == 1 ? 0 + s : s);
		}
		// 把字符串所有小写字母改为大写成为正规的mac地址并返回
		return sb.toString().toUpperCase();
	}
	/**
	 * 获取MAC地址（支持win7）
	 * @作者: 卜繁晟
	 * @创时: 2013-1-6 上午10:22:27
	 */
	public static String getMacAddress(HttpServletRequest request) throws Exception{
		// 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
		byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getByName(request.getRemoteHost())).getHardwareAddress();
		// 下面代码是把mac地址拼装成String
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < mac.length; i++){
			if(i != 0){
				sb.append("-");
			}
			// mac[i] & 0xFF 是为了把byte转化为正整数
			String s = Integer.toHexString(mac[i] & 0xFF);
			sb.append(s.length() == 1 ? 0 + s : s);
		}
		// 把字符串所有小写字母改为大写成为正规的mac地址并返回
		return sb.toString().toUpperCase();
	}
	/**
	 * 测试用的main方法.
	 * @param argc 运行参数.
	 */
	public static void main(String[] argc) throws Exception{
		InetAddress ipAddr = InetAddress.getLocalHost();// 获取本地IP对象
		//System.out.println("MAC地址：" + getMacAddress(ipAddr));
	}
}
