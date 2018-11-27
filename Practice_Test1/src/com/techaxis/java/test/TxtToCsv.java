package com.techaxis.java.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TxtToCsv {
		public List<Member> readTxtFileAndGetMembers() throws Exception {
		File file = new File("/Users/sushilpokharel/Desktop//JavaClass/Practice_Test1//Members.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		List<Member> memberList = new ArrayList<Member>();
		int counter = 0;
		String line = "";
		while ((line = br.readLine()) != null) {
			String id = line.substring(0, 12).trim();
			String lName = line.substring(12, 37).trim();  
			String fName = line.substring(37, 62).trim();
			String addr = line.substring(62, 92).trim();
			String city = line.substring(92, 112).trim();
			String state = line.substring(112, 116).trim();
			String zip = line.substring(116, 121).trim();

			Member member = new Member();
			member.setId(id);
			member.setLastName(lName);
			member.setFirstName(fName);
			member.setAddress(addr);
			member.setCity(city);
			member.setState(state);
			member.setZip(zip);
			memberList.add(member);

			++counter;
			//System.out.println(counter);
		}
		br.close();
		return memberList;
	}

	private List<Member> removeDuplicateFromMemberList(List<Member> rawMemberList) {
		List<Member> nonDuplicateMembers = new ArrayList<>();
		for (Member member1 : rawMemberList) {
			if (nonDuplicateMembers.isEmpty()) {
				nonDuplicateMembers.add(member1);
			} else {
				boolean isDuplicateFound = false;
				for (Member member2 : nonDuplicateMembers) {
					if (member1.getId().equals(member2.getId()) && member1.getLastName().equals(member2.getLastName())
							&& member1.getFirstName().equals(member2.getFirstName())
							&& member1.getAddress().equals(member2.getAddress())
							&& member1.getCity().equals(member2.getCity())
							&& member1.getState().equals(member2.getState())
							&& member1.getZip().equals(member2.getZip())) {
						//System.out.println("I m here:" + member1.getLastName().equals(member2.getLastName()));

						//System.out.println("I m here");
						isDuplicateFound = true;
						break;
					}
				}
				if (!isDuplicateFound) {
					nonDuplicateMembers.add(member1);
				}
			}
		} 
		return nonDuplicateMembers;
	}

		private Map<String, List<Member>> getMemeberByState(List<Member> members) {
		Map<String, List<Member>> map = new HashMap<String, List<Member>>();  
		for (Member member : members) {
			String state = member.getState();
			if (!map.keySet().contains(state)) {
				List<Member> memberByState = new ArrayList<>();
				memberByState.add(member);
				map.put(state, memberByState);
			} else {
				
//				List<Member> addedMemberByState = map.get(state);
//				addedMemberByState.add(member);
//				map.put(state, addedMemberByState);
				map.get(state).add(member); // -> List of member
			}
		}
		for (Entry<String, List<Member>> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			for (Member m : entry.getValue()) {
				System.out.println("This is-------------------------- :" + m);
			}
		}
		return map;
	}
	/*private void writeMemberByStateToFile(Map<String, List<Member>> getMemberByStates,   String outputPath,
			String outputFileName) throws IOException {

		for (Entry<String, List<Member>> entry : getMemberByStates.entrySet()) {
			String fileName = outputPath + File.separator + entry.getKey() + "_" + outputFileName;
			FileWriter writer = new FileWriter(new File(fileName));
			System.out.println(entry.getKey());
			for (Member m : entry.getValue()) {
				System.out.println(m);
				writer.write(m.toCSVString() + "\n");
			}
			writer.close();
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	}*/

	public static void main(String[] args) throws IOException {
		TxtToCsv csv = new TxtToCsv(); 
		try {
			List<Member> getRawMembers = csv.readTxtFileAndGetMembers();
			List<Member> getNonDuplicateMember = csv.removeDuplicateFromMemberList(getRawMembers);
			Map<String, List<Member>> getMemberByState = csv.getMemeberByState(getNonDuplicateMember);
			csv.writeMemberByStateToFile(getMemberByState, "/Users/sushilpokharel/Desktop/JavaClass/Practice_Test1/",
					"output.csv");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your file is written");
	}

	private void writeMemberByStateToFile(Map<String, List<Member>> getMemberByState, String filePath, String fileName) throws IOException {
		
		for(Entry <String, List<Member>>  entries :getMemberByState.entrySet()) {
		String file = filePath + File.separator +  entries.getKey() + "_" +  fileName;
		FileWriter fw = new FileWriter(new File (file));
		for( Entry <String, List<Member>> entry:  getMemberByState.entrySet()) {
			System.out.println("Hello i got only key --->>:" + entry.getKey());
			System.out.println("Hello i am iterating the values--->>:" + entry.getValue());
			
			for(Member mm : entry.getValue()) {
				System.out.println(mm);
				fw.write(mm.toCSVString() +"\n");
			}

		}
		fw.close();
	}
		
	}
}
