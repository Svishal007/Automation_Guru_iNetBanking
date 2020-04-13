package com.iNetBankingGuru.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./ConfigurationsGuru/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
		}
		}
	

	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getuserName() {
		String userName= pro.getProperty("userName");
		return userName;
	}
	public String getPassword() {
		String pwd= pro.getProperty("passWord");
		return pwd;
	}
	public String getChromePath() {
		String chromePath= pro.getProperty("chrompath");
		return chromePath;
	}
	public String getIEPath() {
		String IEPath= pro.getProperty("IEpath");
		return IEPath;
	}
	public String getFireFoxPath() {
		String FireFoxPath= pro.getProperty("chrompath");
		return FireFoxPath;
	}
}
