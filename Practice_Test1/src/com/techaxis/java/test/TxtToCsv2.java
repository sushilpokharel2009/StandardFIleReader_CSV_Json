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

public class TxtToCsv2 {
	// POJO Class , Entity Class -> Data table..
	// ORM (Object Relational Mapping)
	public List<Member> readTxtFileAndGetMembers() throws Exception {
		File file = new File("/Users/sushilpokharel/Desktop//JavaClass/Practice_Test1//Members.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));
		// ArrayList<Member> records = new ArrayList<Member>();
		List<Member> memberList = new ArrayList<Member>();

		int counter = 0;

		String line = "";
		while ((line = br.readLine()) != null) {

//			System.out.println("ID: " + line.substring(0, 12).trim());
//			System.out.println("Ln: " + line.substring(12, 37).trim());
//			System.out.println("Fn: " + line.substring(37, 62).trim());
//			System.out.println("Addr: " + line.substring(62, 92).trim());
//			System.out.println("City: " + line.substring(92, 112).trim());
//			System.out.println("State: " + line.substring(112, 116).trim());
//			System.out.println("Zip: " + line.substring(116, 121).trim());
			String id = line.substring(0, 12).trim();
			String lName = line.substring(12, 37).trim();
			String fName = line.substring(37, 62).trim();
			String addr = line.substring(62, 92).trim();
			String city = line.substring(92, 112).trim();
			String state = line.substring(112, 116).trim();
			String zip = line.substring(116, 121).trim();
// select from member , Memember.class
			Member member = new Member();
			member.setId(id);

			member.setLastName(lName);
			member.setFirstName(fName);
			member.setAddress(addr);
			member.setCity(city);
			member.setState(state);
			member.setZip(zip);
			// member.setMonthlySalary(2000.00f);
			// member.getTaxDeducedSalary();
			memberList.add(member);

			++counter;
			System.out.println(counter);
			if (counter <= 10) {
				// increase salary to 10%
			} else if (counter <= 20) {
				// increase 20%
			}

		}

		System.out.println("Member List size: " + memberList.size());
		for (Member member : memberList) {
			/*
			 * System.out.println(member); System.out.println(member.getId());
			 * System.out.println(member.getLastName());
			 * System.out.println(member.getFirstName());
			 * System.out.println(member.getAddress());
			 * System.out.println(member.getCity()); System.out.println(member.getState());
			 * System.out.println(member.getZip());
			 */
		}
		br.close();

		return memberList;
	}

	// -----------------------remove
	// methods--------------------------------------------

	// Sita, Ram, JOhn, Ram, Sita
	// Sita, Ram, John
	private List<Member> removeDuplicateFromMemberList(List<Member> rawMemberList) {
		// Member1: Member [id=354642886, address=621 JOUBERT ST, city=HENNING,
		// firstName=AMBERLY, lastName=HUSTED, state=NY, zip=56551]

		List<Member> nonDuplicateMembers = new ArrayList<>();

		for (Member member1 : rawMemberList) {
			// System.out.println("Member1: " +member1);
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
						System.out.println("I m here:" + member1.getLastName().equals(member2.getLastName()));
//							
//							&& member1.getFirstName() == member2.getFirstName()
//							&& member1.getAddress() == member2.getAddress() && member1.getCity() == member2.getCity()
//							&& member1.getState() == member2.getState() && member1.getZip() == member2.getZip()) {
						System.out.println("I m here");
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

	// ------------------------OR-------------------------------------

	/*
	 * private List<?> removeDuplicates(ArrayList<?> al) { for (int i = 0; i <=
	 * al.size(); i++) { for (int j = i + 1; j < al.size(); j++) { if
	 * (al.get(i).equals(al.get(j))) { al.remove(j); j--; } } } return al; }
	 */

	// --------------------OR-----------------------------------

	/*
	 * private List<?> removeDuplicates(ArrayList<?> al) { for (int i = 0; i <
	 * al.size(); i++) { for (int j = i + 1; j < al.size(); j++) { if (((File)
	 * al.get(i)).getName().equals(((File) al.get(j)).getName())) { al.remove(j);
	 * 
	 * j--; } } } return al;
	 * 
	 * }
	 */
	// ------------------------OR------------------------
	private List<Member> remove(Member memberList) {
		List<Member> primes = new ArrayList<Member>();
		Member mem = new Member();
		String id = null;
		mem.setId(mem.getId());
		String lName = null;
		mem.setLastName(lName);
		String fName = null;
		mem.setFirstName(fName);
		String addr = null;
		mem.setAddress(addr);
		String city = null;
		mem.setCity(city);
		String state = null;
		mem.setState(state);
		String zip = null;
		mem.setZip(zip);
		primes.add(mem);
		System.out.println("list of members : " + primes);

		Set<Member> primesWithoutDuplicates = new LinkedHashSet<Member>(primes);
		primes.clear();
		primes.addAll(primesWithoutDuplicates);
		System.out.println("list of primes without duplicates : " + primes);

		return primes;

	}

	// ----------------------------OR----------------------

	/*
	 * private List<?> removeDup(ArrayList<?> al) {
	 * 
	 * List<Member> list = new ArrayList<Member>(); Member member = new Member();
	 * list.add(member);
	 * 
	 * Set<Member> set = new LinkedHashSet<Member>(list); System.out.println(set);
	 * return list; }
	 */

//	-----------------OR-------------------------------

	/*
	 * private Member removeDUplicateValues() {
	 * 
	 * List<Member> li = new ArrayList<Member>();
	 * 
	 * Member member = new Member();
	 * 
	 * String id = member.setId(id); String lName = member.setLastName(lName);
	 * String fName = member.setFirstName(fName); String addr =
	 * member.setAddress(addr); String city = member.setCity(city); String state =
	 * member.setState(state); String zip = member.setZip(zip); li.add(member);
	 * 
	 * 
	 * 
	 * for (Member members : li) {
	 * 
	 * members.getId(id); members.getFirstName(lName); members.getLastName(fName);
	 * members.getAddress(addr); members.getCity(city); members.getState(state);
	 * members.getZip(zip);
	 * 
	 * }
	 * 
	 * return member;
	 * 
	 * }
	 */

	private void writeToCsv() throws IOException {

		try {
			File file1 = new File("/Users/sushilpokharel/Desktop//JavaClass/Practice_Test1/write.csv");
			FileWriter writer = new FileWriter(file1);
			ArrayList<Member> records = null;
			Iterator<Member> itr = records.iterator();
			while (itr.hasNext()) {
				writer.write(System.getProperty("line.separator"));
			}
			writer.close();
		} catch (IOException e) {
		}
	}

	private Map<String, List<Member>> getMemeberByState(List<Member> members) {
		Member membr = new Member();
		Map<String, List<Member>> map = new HashMap<String, List<Member>>();
		// map.put("MN", list of member of MN State);
		// map.put("NY", List of members of NY state);
		// create of map
		// for each members
		// get state value
		// check in the map if it contains that state value as key
		// if map doesnot contains state value then put new key and new list of that
		// member
		// else get list of member using that key and append the member to that list
		// return the map
		// Members<String, List<Members>> mmm = map.get(members);
		// ram, MN
		// sita, NY
		// Hari, MN
		// John, NY
		// map.put(1,ram)
		// map.get(1) -> ram
		// map.put(1,hari)

		// MN, (ram, MN)
		// (Hari,MN)
		// NY, (site,NY)
		// (JOhn, NY)
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
				System.out.println(m);
			}
		}

		/*map.put("state", members);
		map.put("NY", members);
		if (map.containsKey("NY")) {
			System.out.println("Hello : " + map.get(membr));
		}
*/
		/*
		 * if(map.containsKey(members)) { System.out.println("I got : " +
		 * map.get(members)); }
		 */

		List<Member> stateWiseMember = new ArrayList<>();

		String searchKey = "NY";
		for (String keys : map.keySet()) {
			if (map.containsKey(keys)) {

				System.out.println("Found total: " + stateWiseMember.addAll(members));
				// System.out.println("Found total: " + stateWiseMember.get(100));
				// System.out.println("Found total: " + stateWiseMember.getClass().getName());

			}
		}
		return map;
	}

	public static void main(String[] args) throws IOException {

		TxtToCsv2 csv = new TxtToCsv2();
		try {
			List<Member> getRawMembers = csv.readTxtFileAndGetMembers();
			List<Member> getNonDuplicateMember = csv.removeDuplicateFromMemberList(getRawMembers);
			Map<String, List<Member>> getMemberByState = csv.getMemeberByState(getNonDuplicateMember);
			csv.writeMemberByStateToFile(getMemberByState, "/Users/sushilpokharel/Desktop/JavaClass/Practice_Test1/",
					"output.csv");
			for (Member m : getNonDuplicateMember) {
				System.out.println(m);
			}
			System.out.println(getRawMembers.size());
			System.out.println(getNonDuplicateMember.size());

//			String a = "Ram";
//			String b = "Ram";
//			String c = "Ram";
//			String d = "Ram";
//			if (a == b && c.equals(d)) {
//			}

//			ArrayList<?> al = null;
//			List<?> m3 = (List<Member>) csv.removeDup(al);
//			System.out.println(m3);
//			System.out.println(getNonDuplicateMember.size());
//			System.out.println(getNonDuplicateMember);

			Member memberList = null;
			List<Member> mm = csv.remove(memberList);
			System.out.println(mm);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// csv.writeToCsv();

		ArrayList<?> al = null;
		// csv.removeDuplicates(al);

		System.out.println("Your file is written");
// \\  /
	}

	private void writeMemberByStateToFile(Map<String, List<Member>> getMemberByState, String outputPath,
			String outputFileName) throws IOException {

		for (Entry<String, List<Member>> entry : getMemberByState.entrySet()) {
			String fileName = outputPath + File.separator + entry.getKey() + "_" + outputFileName;
			FileWriter writer = new FileWriter(new File(fileName));
			System.out.println(entry.getKey());
			for (Member m : entry.getValue()) {
				System.out.println(m);
				writer.write(m.toCSVString() +"\n");
			}
			writer.close();
		}
	}

}
