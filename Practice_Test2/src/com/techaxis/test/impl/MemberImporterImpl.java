package com.techaxis.test.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.techaxis.java.test.Member;
import com.techaxis.java.test.MemberImporter;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List<Member> importMembers(File inputFile) throws Exception {

		/*
		 * Implement the missing logic
		 */
		// FileReader fr = new FileReader(inputFile);
		List<Member> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
//			String line = br.readLine();
			String line;
			// Test1
			// Test2
			// Test3
			// Test4
			//

			while ((line = br.readLine()) != null) {
				//System.out.println("Hello:" + line); 
				//line = br.readLine( );
				
				if (!line.trim().isEmpty()) {
					String id = line.substring(0, 12).trim();
					String lastName = line.substring(12, 37).trim();
					String firstName = line.substring(37, 62).trim();
					String address = line.substring(62, 92).trim();
					String city = line.substring(92, 112).trim();
					String state = line.substring(112, 116).trim();
					String zip = line.substring(116, 121).trim();

					Member members = new Member();
					members.setId(id);
					members.setLastName(lastName);
					members.setFirstName(firstName);
					members.setAddress(address);
					members.setCity(city);
					members.setState(state);
					members.setZip(zip);
					list.add(members);
				}
				 //System.out.println("Total size is  :" + list.size());
				 //System.out.println("This is list only :" + list);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Member mem : list) {
			//System.out.println("THis is:" + mem);
		}

		return list;

	}
}
