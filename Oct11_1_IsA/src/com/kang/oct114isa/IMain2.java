package com.kang.oct114isa;

public class IMain2 {
	public static void main(String[] args) {
		// Product << 속성 : name, price / method : 정보출력
		//shoes << 속성 : name, price, size/ method: 정보출력
		//생성자 오버로딩 X
	 Shoes s = new Shoes();
	 s.name = "삼선";
	 s.price = 3000;
	 s.size = 265;
	 s.print();
	 System.out.println("=====================================");
	 
	//Computer << 내컴퓨터, 100000, cpu :i7-1234,ram = 32 GB
	 //				hdd:500 / method : 정보출력
	 Computer c = new Computer();
	 c.name = "내컴퓨터";
	 c.price = 100000;
	 c.cpu = "i7-1234";
	 c.ram = 32;
	 c.hdd = 500;
	 c.print();
	 System.out.println("=====================================");
	 //Laptop << 내 노트북, 200000, 무게 : 1.2, 배터리 : 20%
	 Laptop l = new Laptop();
	 l.name = "내 노트북";
	 l.price = 200000;
	 l.weight = 1.2;
	 l.battery = 20;
	 l.print();
	}
}
