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
		List<Member> memberList = new ArrayList<>();
		// String inputFile1 =
		// "/‎⁨⁨Users⁩/⁨sushilpokharel⁩/⁨Desktop⁩/JavaClass/Practice_test1/Members.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));) {

			String st;
			//st ="";
			//st;
			while ((st = br.readLine()) != null) {
				System.out.println(st);
				String id = st.substring(0, 12).trim();
				String lName = st.substring(12, 37).trim();
				String fName = st.substring(37, 62).trim();
				String addr = st.substring(62, 92).trim();
				String city = st.substring(92, 112).trim();
				String state = st.substring(112, 116).trim();
				String zip = st.substring(116, 121).trim();

				Member member = new Member();
				member.setId(id);
				member.setLastName(lName);
				member.setFirstName(fName);
				member.setAddress(addr);
				member.setCity(city);
				member.setState(state);
				member.setZip(zip);
				memberList.add(member);

			}
			// br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String a="";
		if(a.equals("b")) {
			//to
		}
		return memberList;

	}

}
