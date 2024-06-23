package com.kang.oct125.person;

//singleton pattern : only one 객체

public class Myself {
	// 캡슐화 된 멤버변수
	private String name;
	private String address;
	private int age;
	
	// 내부에서 객체 만들기 -> 상수화
	private static final Myself MYSELF = new Myself("kang","구리시",25);
	
	//생성자 - 외부에서 객체 못만들게 잠그기
	private Myself() {
		// TODO Auto-generated constructor stub
	}

	private Myself(String name, String address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
//여기에서 만든 객체 밖에서 쓸 수 있도록
	public static Myself getMyself() {
		return MYSELF;
	}
	
		public void printInfo() {
			System.out.println(name);
			System.out.println(address);
			System.out.println(age);
			
		}
	
}
