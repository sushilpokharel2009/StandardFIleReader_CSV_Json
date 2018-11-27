package com.student.java.test;

public class Main {

	public static void main(String[] args) {
		
		  Students student1 = new Students(1, "Ram", "Thapa", "first", "five", 55.40f);
		  Students student2 = new Students(1, "Ram", "Thapa", "first", "five", 55.40f);
		  Students student3 = new Students(1, "Ram", "Thapa", "first", "five", 55.40f);
		  Students student4 = new Students(1, "Ram", "Thapa", "first", "five", 55.40f);
		  Students student5 = new Students(1, "Ram", "Thapa", "first", "five", 55.40f);
		  Students student6 = new Students(1, "Ram", "Thapa", "first", "five", 55.40f);
		  
		  System.out.println("Student one : " + student1.getId() + " " + student1.getFirstName() + " " + student1.getLastName() + " "+ student1.getGrade() + " " + student1.getRank() + " "+ student1.getMarks());
		  System.out.println("Student two : " + student2);
		  System.out.println("Student three : " + student3);
		  System.out.println("Student four : " + student4);
		  System.out.println("Student five : " + student5);
		  System.out.println("Student six : " + student6);
		  
		  System.out.println("-------------Another print out------------------");
		 

		Students s1 = new Students();
		s1.setId(22);
		s1.setFirstName("Ram");
		s1.setLastName("Thapa");
		s1.setGrade("Five");
		s1.setMarks(55.30f);
		s1.setRank("2nd");
		System.out.println("Id :" + s1.getId() + " " + "FirstName is: " + s1.getFirstName() + " " + "LastName is : "
				+ s1.getLastName() + " " + "Grade is : " + s1.getGrade() + " " + "Marks is : " + s1.getMarks() + " "
				+ "Rank is : " + s1.getRank());
	}

}
