package com.techaxis.java.test;

import org.json.JSONException;
import org.json.JSONObject;

public class Member {

	private String id;
	private String address;
	private String city;
	private String firstName;
	private String lastName;
	private String state;
	private String zip;
	private float monthlySalary;

	public float getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(float monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public Member() {

	}

	public Member(String id, String address, String city, String firstName, String lastName, String state, String zip) {
		this.id = id;
		this.address = address;
		this.city = city;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.zip = zip;
	}

	public String toCSVString() {
		// TODO
		// Use StringBuilder-> TODO
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(Util.DELIMITER_COMMA);

		sb.append(this.firstName);
		sb.append(Util.DELIMITER_COMMA);

		sb.append(this.lastName);
		sb.append(Util.DELIMITER_COMMA);

		sb.append(this.address);
		sb.append(Util.DELIMITER_COMMA);

		sb.append(this.city);
		sb.append(Util.DELIMITER_COMMA);

		/*
		 * sb.append(this.state); sb.append(Util.DELIMITER_COMMA);
		 */

		sb.append(this.zip);
		return sb.toString();

		// return this.id + "," + this.lastName + "," + this.firstName + "," + this.city
		// + "," + this.zip;
	}

	public String toJSONString() {
		StringBuilder sb1 = new StringBuilder();
		// sb1.append("{").append(entry.getKey()).append(":\").append(v).append("}");
		sb1.append(Util.DELIMITER_CURLEYBRACES_START);

		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append("id").append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COLON);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(this.id);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COMMA);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append("firstName");
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COLON);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(this.firstName);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COMMA);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append("lastName");
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COLON);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(this.lastName);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COMMA);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append("city");
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COLON);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(this.city);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COMMA);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append("state");
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COLON);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(this.state);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COMMA);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append("zip");
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_COLON);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(this.zip);
		sb1.append(Util.DELIMITER_INVERTEDCOMMA);
		sb1.append(Util.DELIMITER_CULEYBRACES_CLOSE);

//		JSONObject obj = new JSONObject();
//		obj.put("lastnNme", this.lastName);
//		obj.put("firstName", this.firstName);
//		obj.put("address", this.address);
//		obj.put("city", this.city);
//		obj.put("zip", this.zip);
//		obj.put("state", this.state);
//TODO Use simple StringBuilder to generate json data
		return sb1.toString();
	}

	public String toJSONString1() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("lastnNme", this.lastName);
			obj.put("firstName", this.firstName);
			obj.put("address", this.address);
			obj.put("city", this.city);
			obj.put("zip", this.zip);
			obj.put("state", this.state);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj.toString();
	}

	public String toCSVString(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public float getTaxDeducedSalary() {
		return this.monthlySalary - 250;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", address=" + address + ", city=" + city + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", state=" + state + ", zip=" + zip + "]";
	}

}
