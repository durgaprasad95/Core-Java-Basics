package com.demo.oops;

import java.util.Scanner;

public class View extends Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("LOGIN DETAILS");
		Scanner in = new Scanner(System.in);
		while (in.next() != "end") {
			String uname = in.nextLine();
			String pword = in.next();
			DataBase db=new DataBase();
			db.setUname(uname);
			db.setPword(pword);
			if (c.addDetails(db.getUname(), db.getPword())) {
				System.out.println("The given user is Successfully Logged In....");
			} else
				System.out.println("Uname Already exits.Try another one... ");
		}
		in.close();
		System.out.println(DataBase.db.keySet());
	}

}
