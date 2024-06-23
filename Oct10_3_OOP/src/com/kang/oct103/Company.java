package com.kang.oct103;

public class Company {
	String name;
	String location;
	int employee;

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String name, String location, int employee) {
		super();
		this.name = name;
		this.location = location;
		this.employee = employee;
	}

	public void printInfo() {
		System.out.println("============================");
		System.out.println("회사이름 : " + name);
		System.out.println("지역 : " + location);
		System.out.println("직원수 : " + employee);
		System.out.println("============================");
	}

}
