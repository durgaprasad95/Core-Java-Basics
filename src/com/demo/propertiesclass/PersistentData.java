package com.demo.propertiesclass;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

public class PersistentData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		Scanner in = new Scanner(System.in);
		loadingFile(prop);

		int t = 2;
		while (--t > 0) {
			prop.setProperty(in.next(), in.next());
			if (prop.containsKey("m")) {
				prop.remove("m");
				System.out.println("Username Cannot be m");
				System.exit(1);
			}

		}
		in.close();
		StoringFile(prop);
		prop.forEach((k, v) -> System.out.println(prop.getProperty((String) k)));
	}

	private static void loadingFile(Properties prop) {
		try (InputStream bw = Files
				.newInputStream(Paths.get("C://Users//DURGA PRASAD//Documents//pro languages//java//file.xml"))) {
			prop.loadFromXML(bw);
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
	}

	private static void StoringFile(Properties prop) {
		try (OutputStream bw = Files
				.newOutputStream(Paths.get("C://Users//DURGA PRASAD//Documents//pro languages//java//file.xml"))) {
			prop.storeToXML(bw, "DATA BASE");
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
	}
}
