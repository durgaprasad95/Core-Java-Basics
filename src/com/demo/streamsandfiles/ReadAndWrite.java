package com.demo.streamsandfiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doTryCatchFinally();
		doCloseThing();
	}

	// CAUTION
	// WORKS WITH TET FILES IN THE MENTIONED DIRECTORY
	public static void doTryCatchFinally() {
		char[] buff = new char[13];
		int length;
		try (BufferedReader reader = new BufferedReader(
				new FileReader("C://Users//DURGA PRASAD//Documents//pro languages//java//file.txt"));
				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C://Users//DURGA PRASAD//Documents//pro languages//java//file1.txt"))) {
			while ((length = reader.read(buff)) >= 0) {
				System.out.println("length: " + length);
				for (int i = 0; i < length; i++) {
					writer.write(buff[i]);
					writer.newLine();
				}
			}
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
	}

	public static void doCloseThing() {
		try (MyAutoCloseable ac = new MyAutoCloseable()) {
			ac.saySomething();
		} catch (IOException e) {
			System.out.println(e.getMessage() + " and " + e.getClass().getSimpleName());
		}
	}
}
