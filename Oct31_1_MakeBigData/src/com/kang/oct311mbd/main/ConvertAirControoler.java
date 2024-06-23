package com.kang.oct311mbd.main;

import java.util.ArrayList;

// 아까 하던 GetAirController와는 기능이 다른 Controller

public class ConvertAirControoler {
	public static void main(String[] args) {
		ArrayList<Air> airs = AirDAO.getMyAir();
		AirDAO.writeToFile(airs);
		System.out.println("complete");
		
		/*for (Air a : airs) {
			System.out.println(a.getSa_no());
			System.out.println(a.getSa_pm10());
			System.out.println(a.getSaa_idex_nm());
			System.out.println("-------------------");
			
		}*/
	}
}
