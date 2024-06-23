package com.kang.oct311mbd.main;

import java.util.Date;

// db 테이블 만들면 항상 짝꿍으로 JavaBean만들기!!

public class Air {
	// 멤버변수(Memver Variable), 속성 -> DB필드와 똑같이
	private int sa_no;
	private Date sa_msrdt; // import java.util.Date;
	private String sa_msrste_nm;
	private int sa_pm10;
	private int sa_pm25;
	private double sa_o3;
	private String saa_idex_nm;
	
	public Air() {
		// TODO Auto-generated constructor stub
	}
	public Air(int sa_no, Date sa_msrdt, String sa_msrste_nm, int sa_pm10, int sa_pm25, double sa_o3,
			String saa_idex_nm) {
		super();
		this.sa_no = sa_no;
		this.sa_msrdt = sa_msrdt;
		this.sa_msrste_nm = sa_msrste_nm;
		this.sa_pm10 = sa_pm10;
		this.sa_pm25 = sa_pm25;
		this.sa_o3 = sa_o3;
		this.saa_idex_nm = saa_idex_nm;
	}

	public int getSa_no() {
		return sa_no;
	}

	public void setSa_no(int sa_no) {
		this.sa_no = sa_no;
	}

	public Date getSa_msrdt() {
		return sa_msrdt;
	}

	public void setSa_msrdt(Date sa_msrdt) {
		this.sa_msrdt = sa_msrdt;
	}

	public String getSa_msrste_nm() {
		return sa_msrste_nm;
	}

	public void setSa_msrste_nm(String sa_msrste_nm) {
		this.sa_msrste_nm = sa_msrste_nm;
	}

	public int getSa_pm10() {
		return sa_pm10;
	}

	public void setSa_pm10(int sa_pm10) {
		this.sa_pm10 = sa_pm10;
	}

	public int getSa_pm25() {
		return sa_pm25;
	}

	public void setSa_pm25(int sa_pm25) {
		this.sa_pm25 = sa_pm25;
	}

	public double getSa_o3() {
		return sa_o3;
	}

	public void setSa_o3(double sa_o3) {
		this.sa_o3 = sa_o3;
	}

	public String getSaa_idex_nm() {
		return saa_idex_nm;
	}

	public void setSaa_idex_nm(String saa_idex_nm) {
		this.saa_idex_nm = saa_idex_nm;
	}
	
	
}
