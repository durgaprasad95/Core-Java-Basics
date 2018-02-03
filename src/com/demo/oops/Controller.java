package com.demo.oops;

public class Controller extends DataBase implements Methods {

	protected static Controller c = new Controller();

	public boolean addDetails(String uname, String pword) {
		if (db.containsKey(uname))
			return false;
		else {
			db.put(uname, pword);
			return true;
		}
	}

	public boolean deleteDetails(String uname) {
		if (db.containsKey(uname)) {
			db.remove(uname);
			return true;
		} else {
			return false;
		}
	}
}
