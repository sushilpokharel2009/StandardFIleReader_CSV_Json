package com.techaxis.java.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.techaxis.test.impl.CSVMemberExporterImpl;
import com.techaxis.test.impl.MemberImporterImpl;
import com.techaxis.test.impl.JsonMemberExporterImpl;

public class CSVMemberExporter extends MemberFileConverter {

	MemberImporterImpl memberImporterImpl;
	// AllMember allmember = new AllMember();
	List<Member> globalMember;

	@Override
	protected MemberExporter getMemberExporter() {
		// TODO Auto-generated method stub
		return new CSVMemberExporterImpl();
	}
	
//	protected MemberJsonExporterImpl getMemberJsonExporter() {
//		return new MemberJsonExporterImpl();
//		
//	}

	@Override
	protected MemberImporter getMemberImporter() {
		// TODO -generated method stub
		MemberImporter importer = new MemberImporterImpl();
		return importer;
	}
	
	

	public static void main(String[] args) throws Exception {

		CSVMemberExporter fileConverter = new CSVMemberExporter();
		File inputFile = new File("/Users/sushilpokharel/Desktop//JavaClass/Practice_Test1/Members.txt");
		String outputFilePath = "/Users/sushilpokharel/Desktop//JavaClass/Practice_Test1/";
		//String outputFilePath1 = "/Users/sushilpokharel/Desktop//JavaClass/Practice_Test1/";
		String outputFileName = "output.csv";
		fileConverter.convert(inputFile, outputFilePath, outputFileName);
		fileConverter.printUniqueZips();
		
		
		
	}

	@Override
	protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
		List<Member> nonDuplicatemember = new ArrayList<>();
		try {
			// File inputFile;
			// List<Member> members = memberImporterImpl.importMembers(inputFile);
			for (Member allmembers1 : membersFromFile) {
				if (nonDuplicatemember.isEmpty()) {
					nonDuplicatemember.add(allmembers1);
				} else {

					boolean duplicateFound = false;

					for (Member mem2 : nonDuplicatemember) {
						if (allmembers1.getId().equals(mem2.getId())
								&& allmembers1.getFirstName().equals(mem2.getFirstName())
								&& allmembers1.getLastName().equals(mem2.getLastName())
								&& allmembers1.getAddress().equals(mem2.getAddress())
								&& allmembers1.getCity().equals(mem2.getCity())
								&& allmembers1.getState().equals(mem2.getState())
								&& allmembers1.getZip().equals(mem2.getZip())) {

							duplicateFound = true;
							break;
						}
					}
					if (!duplicateFound) {
						nonDuplicatemember.add(allmembers1);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		globalMember = nonDuplicatemember;
		return nonDuplicatemember;
	}

	private void printUniqueZips() {
		// TODO -------
		// public HashSetImpl(Collection<? extends E> c)
		/*
		 * Set<Member> common = new HashSet<Member>();
		 * 
		 * if (!collections.isEmpty()) { Iterator<? extends Collection<Member>> iterator
		 * = collections.iterator(); common.addAll(iterator.next());
		 * while(iterator.hasNext()) { common.retainAll(iterator.next()); } }
		 */
		// 0 ram, hari,gita
		// 1 jack, john, harry
		// 2 xys,
		// 3
		Set<String> allUniqueSets = new HashSet<String>();
		System.out.println("I am a unique value:");
		for (Member collection : globalMember) {
			allUniqueSets.add(collection.getZip());
//			Set<Member> unique = new HashSet<Member>();
//			//if (allUniqueSets.isEmpty()) {
//				allUniqueSets.add(unique);
//				for (Member otherCollection : globalMember) {
//					if (collection != otherCollection) {
//						System.out.println("I am a unique value:");
//						System.out.println("I am a unique value:" + unique.remove(otherCollection));
//					}
//				}
		}

		for (String s : allUniqueSets) {

			System.out.println(s);

		}
		// }

	}

	/*private void testCollectionExtends() {
		Collection<Integer> arrlist = new ArrayList<Integer>();

		arrlist.add(1);
		arrlist.add(2);
		arrlist.add(3);
		arrlist.add(4);
		arrlist.add(5);

		ArrayList<Integer> anotherList = new ArrayList<Integer>(arrlist);
		System.out.println(anotherList);

	}*/

	@Override
	protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {

		// List<Member> mapmembers = allmember.getNonDuplicateMembers(validMembers);
		Map<String, List<Member>> newmembers = new HashMap<>();

		for (Member members : validMembers) {
			String state = members.getState();
			if (!newmembers.keySet().contains(state)) {
				List<Member> m = new ArrayList<>();
				m.add(members);
				newmembers.put(state, m);
			} else {
				newmembers.get(state).add(members);
			}

		}
		for (Entry<String, List<Member>> entry : newmembers.entrySet()) {
			System.out.println(entry.getKey());
			for (Member m : entry.getValue()) {
				System.out.println("This is single value :" + m);
			}
		}
		return newmembers;
	}

}
