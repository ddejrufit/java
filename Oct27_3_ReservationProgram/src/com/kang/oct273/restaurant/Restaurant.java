package com.kang.oct273.restaurant;

// DB 테이블과 짝꿍인 Javabean(POJO, DTO) 항상 만들기!!!

public class Restaurant {
	private String r_location;
	private String r_owner;
	private int r_seat;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String r_location, String r_owner, int r_seat) {
		super();
		this.r_location = r_location;
		this.r_owner = r_owner;
		this.r_seat = r_seat;
	}

	public String getR_location() {
		return r_location;
	}

	public void setR_location(String r_location) {
		this.r_location = r_location;
	}

	public String getR_owner() {
		return r_owner;
	}

	public void setR_owner(String r_owner) {
		this.r_owner = r_owner;
	}

	public int getR_seat() {
		return r_seat;
	}

	public void setR_seat(int r_seat) {
		this.r_seat = r_seat;
	}
	
}
