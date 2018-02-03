package com.demo.streamsandfiles;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable {

	public void saySomething() throws IOException {
		System.out.println("Say something");
	}

	// NO NEED TO CALL CLOSE METHOD EXPLICITLY
	// THIS IS WHAT "AutoCloseable INERFACE" MEANT FOR...
	@Override
	public void close() throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("closing");
	}

}
