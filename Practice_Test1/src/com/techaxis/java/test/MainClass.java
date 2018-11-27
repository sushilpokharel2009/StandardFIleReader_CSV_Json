package com.techaxis.java.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MainClass {
	
	
	public static void main(String[] args) throws IOException {
		// converter.readfile();
		// -- read each line
		// -- To extract each fields data use String's substring method.
		// -- Create the pojo Member class
		// -- Set those values to members
		// -- Print these members.(syso)
		// coverter.check_duplicate();

		File file = new File("/Users/sushilpokharel/Desktop//JavaClass/Practice_Test1//Members.txt"); 
				
		BufferedReader br = new BufferedReader(new FileReader(file));
		//String columnFile = "";
		ArrayList<String> records = new ArrayList<String>();
		String line;

		try {
			while ((line = br.readLine()) != null) {

				System.out.println("ID: " + line.substring(0, 12).trim());
				System.out.println("Ln: " + line.substring(12, 25));
				System.out.println("Fn: " + line.substring(25, 50).trim());
				System.out.println("Addr: " + line.substring(50, 80).trim());
				System.out.println("City: " + line.substring(80, 100).trim());
				System.out.println("Zip: " + line.substring(104, 109).trim());
				// id (12) last name(25) first name(25) address(30) city(20) state(4) zip(5)

			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String element = "";
		File file1 = new File("/Users/sushilpokharel/Desktop//JavaClass/Practice_Test1/write.csv");
				
		FileWriter writer = new FileWriter(file1);
		Iterator<String> itr = records.iterator();
		while (itr.hasNext()) {
				String it = itr.next();
			
				writer.write(element);
			

		}
	
		System.out.println("Your file has been written");
		
		

	}
	
}
