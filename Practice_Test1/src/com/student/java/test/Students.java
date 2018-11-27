package com.student.java.test;

import java.util.List;

public class Students {
	private int id;
	private String firstName;
	private String lastName;
	private String rank;
	private String grade;
	private float marks;
	
	public Students() {
		
	}
	
	public Students(int id, String firstName, String lastName, String rank, String grade, float marks) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rank = rank;
		this.grade = grade;
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "My Student record [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rank=" + rank
				+ ", grade=" + grade + ", marks=" + marks + "]";
	}

	
	
	
	

}
