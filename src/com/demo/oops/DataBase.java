package com.demo.oops;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
	private String uname;
	private String pword;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public  static Map <String,String> db=new HashMap<>();
}
