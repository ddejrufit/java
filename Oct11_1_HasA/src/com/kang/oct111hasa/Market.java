package com.kang.oct111hasa;

public class Market {
	String name;
	String adress;
	String buy;
	Dish thing;

	public Market() {
		// TODO Auto-generated constructor stub
	}


	
	public Market(String name, String adress, String buy, Dish thing) {
		super();
		this.name = name;
		this.adress = adress;
		this.buy = buy;
		this.thing = thing;
	}

	public void printinfo() {
		System.out.println("사업체 명:"+name);
		System.out.println("장소 :"+adress);
		System.out.println("구매자 :"+buy);
	
	}
}
