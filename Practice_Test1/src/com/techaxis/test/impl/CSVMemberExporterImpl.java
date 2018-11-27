package com.techaxis.test.impl;

import java.io.IOException;
import java.io.Writer;

import com.techaxis.java.test.Member;
import com.techaxis.java.test.MemberExporter;

public class CSVMemberExporterImpl implements MemberExporter {

	@Override
	public void writeMember( Member member, Writer writer ) throws IOException {
//		String str = "IL, MN, OK, NY"; 
//        String[] arrOfStr = str.split("_"); 
//  
//        for (String a : arrOfStr) 
//            System.out.println(a); 
		
		
		writer.write( member.toCSVString() +"\n");
	}

}
