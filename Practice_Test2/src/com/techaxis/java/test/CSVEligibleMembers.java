package com.techaxis.java.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.techaxis.test.impl.EligibilityImporterImpl;
import com.techaxis.test.impl.MemberExporterImpl;
import com.techaxis.test.impl.MemberImporterImpl;

import sun.rmi.runtime.Log;

public class CSVEligibleMembers extends MemberFileConverter {

	 
	public static void main(String[] args) {
		try {

			CSVEligibleMembers eligibleMembers = new CSVEligibleMembers();
			File inputMemberFile = new File("/Users/sushilpokharel/Desktop//JavaClass/Practice_Test2/Members.txt");
			String outputFilePath = "/Users/sushilpokharel/Desktop//JavaClass/Practice_Test2/";
			File inputEligibilityFile = new File(
					"/Users/sushilpokharel/Desktop/JavaClass/Practice_Test2/EligibileMembers.txt");
			String outputFileName = "output.csv";
			// List<Member> list = null;
			//// eligibleMembers.getExportFile(outputFilePath, state, outputFileName);
			// List<Member> nonduplicatelistedmember =
			// eligibleMembers.getNonDuplicateMembers(list);

			eligibleMembers.convert(inputMemberFile, inputEligibilityFile, outputFilePath, outputFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected MemberExporter getMemberExporter() {
		MemberExporter memberExporter = new MemberExporterImpl();
		return memberExporter;
	}

	@Override
	protected MemberImporter getMemberImporter() {

		return new MemberImporterImpl();
	}

	@Override
	protected EligibilityImporter getEligibilityImporter() {
		EligibilityImporter eligibilityImporter = new EligibilityImporterImpl();
		return eligibilityImporter;
	}

	@Override
	protected List<Member> getValidMembersToExport(List<Member> members, List<EligibilityInfo> eligibilityInfo) {
		List<Member> nonDuplicateMembers = getNonDuplicateMembers(members);
		List<EligibilityInfo> nonDuplicateEligibilityInfo = getNonDuplicateEligibilityInfor(eligibilityInfo);
		List<Member> validMembers = new ArrayList<>();
		for (Member m : nonDuplicateMembers) {
			for (EligibilityInfo e : nonDuplicateEligibilityInfo) {
				if (m.getId().equals(e.getId())) {
					Date currentDate = new Date();
					if (e.getEffectiveFrom().before(currentDate) && e.getEffectiveTo().after(currentDate)) {
						validMembers.add(m);
					}
				}
			}
		}
		// TODO Auto-generated method stub

		// Check every member is found in elelgibityInfo or not
		// If member is found then check if date of eligibilty info is correct comparing
		// with current date
		// If above statement is valid then add the member to valid array list
		// Return valid array list
		return validMembers;
	}

	private List<EligibilityInfo> getNonDuplicateEligibilityInfor(List<EligibilityInfo> eligibilityInfo) {
		// TODO Check if there are duplicate eligibility informations
	// Create new list of eligibility info 
		
		// checkout incoming list data is dulicate or not
		// add non dulicate object to the new list
		// return new list
		List<EligibilityInfo> eligibilityInfoList = new ArrayList<>();
		for(EligibilityInfo nonDuplicateEligilibilityInfo : eligibilityInfo) {
			if(!eligibilityInfoList.isEmpty()) {
				eligibilityInfoList.add(nonDuplicateEligilibilityInfo);
			}else {
				
				boolean duplicateFound = false;
				
				for(EligibilityInfo  eligibility: eligibilityInfoList) {
										
					if(nonDuplicateEligilibilityInfo.getId().equals(eligibility.getId())
						&& 	nonDuplicateEligilibilityInfo.getEffectiveFrom().equals(eligibility.getEffectiveFrom())
						&& 	nonDuplicateEligilibilityInfo.getEffectiveTo().equals(eligibility.getEffectiveTo())
							
							) {
						 duplicateFound = true;
						 break;
					}
				}
				if(!duplicateFound) {
					eligibilityInfoList.add(nonDuplicateEligilibilityInfo);
				}
				
			}
		}
		
		
		
		return eligibilityInfoList;
	}

	@Override
	protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {

		Map<String, List<Member>> splitmember = new HashMap<>();
		for (Member members : validMembers) {
			String state = members.getState();
			if (!splitmember.keySet().contains(state)) {
				List<Member> li = new ArrayList<>();
				li.add(members);
				splitmember.put(state, li);
			} else {
				splitmember.get(state).add(members);
			}
		}
		for (Map.Entry<String, List<Member>> entry : splitmember.entrySet()) {
			entry.getKey();
			for (Member mm : entry.getValue()) {
				//System.out.println(mm);
			}
		}
		return splitmember;
	}

	@Override
	protected File getExportFile(String outputFilePath, String state, String outputFileName) {

		return new File(outputFilePath + File.separator + state + "_" + outputFileName);
	}

	protected List<Member> getNonDuplicateMembers(List<Member> listedmember) {

		List<Member> nonduplicatemembers = new ArrayList<>();

		for (Member allMembers : listedmember) {
			if (nonduplicatemembers.isEmpty()) {
				nonduplicatemembers.add(allMembers);
			} else {
				boolean duplicateFound = false;

				for (Member nondupmembers : nonduplicatemembers) {
					if (allMembers.getId().equals(nondupmembers.getId())
							&& allMembers.getLastName().equals(nondupmembers.getLastName())
							&& allMembers.getFirstName().equals(nondupmembers.getLastName())
							&& allMembers.getAddress().equals(nondupmembers.getAddress())
							&& allMembers.getCity().equals(nondupmembers.getCity())
							&& allMembers.getState().equals(nondupmembers.getState())
							&& allMembers.getZip().equals(nondupmembers.getZip())) {
						duplicateFound = true;
						break;

					}
				}
				if (!duplicateFound) {
					nonduplicatemembers.add(allMembers);
				}
			}
		}

		return nonduplicatemembers;

	}

}
