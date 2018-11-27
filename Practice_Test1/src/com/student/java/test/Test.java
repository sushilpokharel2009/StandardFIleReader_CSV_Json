package com.student.java.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Test {

	private List<Students> getStudents() {

		List<Students> li = new ArrayList<>();

		Students s = new Students();
		s.setId(1);
		s.setFirstName("Shusil");
		s.setLastName("Pokheral");
		s.setGrade("A+");
		s.setMarks(90.0f);
		s.setRank("First");

		li.add(s);

		Students s1 = new Students();
		s.setId(2);
		s.setFirstName("Shusil");
		s.setLastName("Pokheral");
		s.setGrade("A+");
		s.setMarks(90.0f);
		s.setRank("First");
		for (Students students : li) {

			s.getId();
			s.getFirstName();
			s.getLastName();
			s.getGrade();
			s.getMarks();
			s.getRank();
		}

		return li;
	}

	// First In First Out -> List's Data Structure
	// Collection Frameworks
	// List, Set, Map,

	private List<Students> getOnlyTenStudents(List<Students> totalStudents, Students student) {

//		List<Students> limitedStudentOnly = new ArrayList<Students>();
//
//		for (Students getTenOnly : totalStudents) {
//			if (limitedStudentOnly.size() <= 10) {
//				limitedStudentOnly.add(getTenOnly);
//			} else {
//				limitedStudentOnly.remove(0);
//				limitedStudentOnly.add(getTenOnly);
////				for(Students deleteStudents : limitedStudentOnly) {
////					limitedStudentOnly.remove(0);
////					deleteStudents.addLast(getTenOnly);
////				}
//			}
//		}
		if (totalStudents.size() < 10) {
			totalStudents.add(student);
		} else {
			totalStudents.remove(0);
			totalStudents.add(student);
		}
		return totalStudents;

	}

	public static void main(String args[]) {

		Students student1 = new Students(1, "Ram", "Thapa", "first", "five", 55.40f);
		Students student2 = new Students(2, "Shyam", "Thapa", "first", "five", 55.40f);
		Students student3 = new Students(3, "Hari", "Thapa", "first", "five", 55.40f);
		Students student4 = new Students(4, "Kris", "Thapa", "first", "five", 55.40f);
		Students student5 = new Students(5, "Manan", "Thapa", "first", "five", 55.40f);
		Students student6 = new Students(6, "Abid", "Thapa", "first", "five", 55.40f);
		Students student7 = new Students(7, "Durga", "Thapa", "first", "five", 55.40f);
		Students student8 = new Students(8, "Sachin", "Thapa", "first", "five", 55.40f);
		Students student9 = new Students(9, "Kamal", "Thapa", "first", "five", 55.40f);
		Students student10 = new Students(10, "Rana", "Thapa", "first", "five", 55.40f);
		Test t1 = new Test();
		// List<Students> st = t1.getStudents();
		List<Students> studentList = new ArrayList<>();

		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
		studentList.add(student6);
		studentList.add(student7);
		studentList.add(student8);
		studentList.add(student9);
		studentList.add(student10);
		for (Students s : studentList) {
			System.out.println(s);
		}
		System.out.println("-----------------------");

		Students student11 = new Students(11, "Test", "Thapa", "first", "five", 55.40f);
		studentList = t1.getOnlyTenStudents(studentList, student11);
		for (Students s : studentList) {
			System.out.println(s);
		}
		System.out.println("-----------------------");
		
		Students student12 = new Students(12, "RamTest", "Thapa", "first", "five", 55.40f);
		studentList = t1.getOnlyTenStudents(studentList, student12);
		for (Students s : studentList) {
			System.out.println(s);
		}

		/*
		 * System.out.println("Student one : " + student1.getId() + " " +
		 * student1.getFirstName() + " " + student1.getLastName() + " "+
		 * student1.getGrade() + " " + student1.getRank() + " "+ student1.getMarks());
		 * System.out.println("Student two : " + student2.getId() + " " +
		 * student2.getFirstName() + " " + student2.getLastName() + " "+
		 * student2.getGrade() + " " + student2.getRank() + " "+ student2.getMarks());
		 * System.out.println("Student three : " + student3.getId() + " " +
		 * student3.getFirstName() + " " + student3.getLastName() + " "+
		 * student3.getGrade() + " " + student3.getRank() + " "+ student3.getMarks());
		 * System.out.println("Student four : " + student4.getId() + " " +
		 * student4.getFirstName() + " " + student4.getLastName() + " "+
		 * student4.getGrade() + " " + student4.getRank() + " "+ student4.getMarks());
		 * System.out.println("Student five : " + student5.getId() + " " +
		 * student5.getFirstName() + " " + student5.getLastName() + " "+
		 * student5.getGrade() + " " + student5.getRank() + " "+ student5.getMarks());
		 * System.out.println("Student six : " + student6.getId() + " " +
		 * student6.getFirstName() + " " + student6.getLastName() + " "+
		 * student6.getGrade() + " " + student6.getRank() + " "+ student6.getMarks());
		 * System.out.println("Student seven : " + student7.getId() + " " +
		 * student7.getFirstName() + " " + student7.getLastName() + " "+
		 * student7.getGrade() + " " + student7.getRank() + " "+ student7.getMarks());
		 * System.out.println("Student eight : " + student8.getId() + " " +
		 * student8.getFirstName() + " " + student8.getLastName() + " "+
		 * student8.getGrade() + " " + student8.getRank() + " "+ student8.getMarks());
		 * System.out.println("Student nine : " + student9.getId() + " " +
		 * student9.getFirstName() + " " + student9.getLastName() + " "+
		 * student9.getGrade() + " " + student9.getRank() + " "+ student9.getMarks());
		 * System.out.println("Student ten : " + student10.getId() + " " +
		 * student10.getFirstName() + " " + student10.getLastName() + " "+
		 * student10.getGrade() + " " + student10.getRank() + " "+
		 * student10.getMarks());
		 */

		// Students s1 = new Students();

	}
}
