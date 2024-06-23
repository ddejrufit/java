package com.kang.ocy132.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateMain2 {
	public static void main(String[] args) {
		String[] location = TimeZone.getAvailableIDs();
		for (int i = 0; i < location.length; i++) {
			System.out.println(location[i]);
		}
		System.out.println("======================");
		TimeZone time = null;
		Date date = new Date(); // 현재시간 날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm;ss(z Z)");

		time = TimeZone.getTimeZone("Asia/Seoul");
		sdf.setTimeZone(time);
		System.out.println(time.getDisplayName() + ":" + sdf.format(date));
		
		time = TimeZone.getTimeZone("JST");
		sdf.setTimeZone(time);
		System.out.println(time.getDisplayName() + ":" + sdf.format(date));
		
		time = TimeZone.getTimeZone("Pacific/Honolulu");
		sdf.setTimeZone(time);
		System.out.println(time.getDisplayName()+":"+sdf.format(date));
	}
}
