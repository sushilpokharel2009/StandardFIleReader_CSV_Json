package com.techaxis.java.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class MemberFileConverter {

	// NOTE: Do not modify this class

	protected abstract MemberExporter getMemberExporter();

	protected abstract MemberImporter getMemberImporter();

	protected abstract EligibilityImporter getEligibilityImporter();

	protected abstract List<Member> getValidMembersToExport(List<Member> members,
			List<EligibilityInfo> eligibilityInfo);

	protected abstract Map<String, List<Member>> splitMembersByState(List<Member> validMembers);

	protected abstract File getExportFile(String outputFilePath, String state, String outputFileName);

	public void convert(File inputMemberFile, File inputEligibilityFile, String outputFilePath, String outputFileName)
			throws Exception {

		// Read :

		MemberImporter memberImporter = getMemberImporter();
		List<Member> membersFromFile = memberImporter.importMembers(inputMemberFile);

		EligibilityImporter eligibilityImporter = getEligibilityImporter();
		List<EligibilityInfo> eligibilityInfo = eligibilityImporter.importEligibilities(inputEligibilityFile);

		// Filter :

		// Date date = null;
		List<Member> validMembers = getValidMembersToExport(membersFromFile, eligibilityInfo);
		Map<String, List<Member>> membersFilteredByState = splitMembersByState(validMembers);

		// Export :

		MemberExporter exporter = getMemberExporter();
		for (Map.Entry<String, List<Member>> map : membersFilteredByState.entrySet()) {

			String state = map.getKey();
			List<Member> membersPerState = map.getValue();

			File outputFile = getExportFile(outputFilePath, state, outputFileName);

			writeValidMembers(outputFile, exporter, membersPerState);

		}

	}

	private void writeValidMembers(File outputFile, MemberExporter exporter, List<Member> validMembers)
			throws IOException {
		Writer writer = new FileWriter(outputFile);

		for (Member member : validMembers) {
			exporter.writeMember(member, writer);
		}

		writer.flush();
		writer.close();
	}

}
