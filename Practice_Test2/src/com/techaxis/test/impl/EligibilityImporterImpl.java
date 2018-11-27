package com.techaxis.test.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.techaxis.java.test.EligibilityImporter;
import com.techaxis.java.test.EligibilityInfo;
import com.techaxis.java.test.Member;
import com.techaxis.java.test.MemberImporter;

public class EligibilityImporterImpl implements EligibilityImporter {

	protected static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	protected static String PIPE_DELIMITER = "\\|";
	private static final String REGEX = "^[a-z0-9_-]{3,15}((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})$";

	/*
	 * private String getCurrentDate() {
	 * 
	 * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); Date date = new
	 * Date(); String currentDate = "dateFormat.format(date))";
	 * 
	 * System.out.println("Hello, today's data is :" + dateFormat.format(date));
	 * 
	 * return currentDate;
	 * 
	 * }
	 */

	@Override
	public List<EligibilityInfo> importEligibilities(File eligibilityFile) {

		List<EligibilityInfo> eligibilityInfos = new ArrayList<>();

		try {
			// int dateReader;
//				101396885|2013-10-22|2014-12-25
//				727344064|20121022|2016-12-25
//				222743521|2013-10-22|2014-12-25 
			// File writer
			BufferedReader reader = new BufferedReader(new FileReader(eligibilityFile));

			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					// 156376760|2013-10-22|2014-12-25 976554502|2013-10-22|2014-12-25
					String[] dataArray = line.split(PIPE_DELIMITER);
					if (dataArray.length == 3) {
						addEligibilityInfos(dataArray, eligibilityInfos, line);
					} else {
						System.out.println("Data is not valid: " + line);
						String[] lineArray = line.split(" ");
						String line1 = lineArray[0];
						String line2 = lineArray[1];
						String[] dataArray1 = line1.split(PIPE_DELIMITER);
						String[] dataArray2 = line2.split(PIPE_DELIMITER);
						addEligibilityInfos(dataArray1, eligibilityInfos, line);
						addEligibilityInfos(dataArray2, eligibilityInfos, line);
					}
					// System.out.println("Here we are:" + eligibilityInfos.toString());
					// System.out.println("How many members:" + eligibilityInfos.size());

				}

			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Here  we are:" + eligibilityInfos);
		// System.out.println("Here we are:" + eligibilityInfos.toString());
		System.out.println("How many members:" + eligibilityInfos.size());
		return eligibilityInfos;

	}

	private void addEligibilityInfos(String[] dataArray, List<EligibilityInfo> x, String line) {
		String id = dataArray[0].trim();
		String dateFromStr = dataArray[1].trim();
		String dateToStr = dataArray[2].trim();

		EligibilityInfo info = new EligibilityInfo();

		info.setId(id);
		try {
			info.setEffectiveFrom(DATE_FORMAT.parse(dateFromStr));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Data is not valid: " + line);
			// Or write this line to Corrupted_file List
			return;
		}
		try {
			info.setEffectiveTo(DATE_FORMAT.parse(dateToStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Data is not valid: " + line);
			info.setEffectiveTo(new Date());
		}

		x.add(info);

	}

}
