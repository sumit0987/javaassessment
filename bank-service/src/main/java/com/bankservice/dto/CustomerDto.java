package com.bankservice.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerDto {
	
	private String name;
	private String gender;
	private int age;
	private String panno;
	private Long aadharno;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	public Long getAadharno() {
		return aadharno;
	}
	public void setAadharno(Long aadharno) {
		this.aadharno = aadharno;
	}
	
	public CustomerDto() {
		
	}
	public CustomerDto(String name, String gender, int age, String panno, Long aadharno) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.panno = panno;
		this.aadharno = aadharno;
	}
	
	
	
}
