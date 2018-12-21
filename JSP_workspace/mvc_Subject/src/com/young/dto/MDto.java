package com.young.dto;

public class MDto {

	String name;
	String birth;
	String gender;
	String phone;
	String front_num;
	String mid_num;
	String last_num;

	public MDto(String name, String birth, String gender, String front_num, String mid_num,	String last_num, String phone) {
		super();
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.front_num = front_num;
		this.mid_num = mid_num;
		this.last_num = last_num;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFront_num() {
		return front_num;
	}


	public void setFront_num(String front_num) {
		this.front_num = front_num;
	}


	public String getMid_num() {
		return mid_num;
	}


	public void setMid_num(String mid_num) {
		this.mid_num = mid_num;
	}


	public String getLast_num() {
		return last_num;
	}


	public void setLast_num(String last_num) {
		this.last_num = last_num;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "MDto [name=" + name + ", birth=" + birth + ", gender=" + gender + ", phone=" + phone + "]";
	}


	
}
