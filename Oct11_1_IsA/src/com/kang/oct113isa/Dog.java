package com.kang.oct113isa;

public class Dog extends Animal{//Animal의 기능을 받아옴
	String where;
	//Animal 안에 Dog가 [상속]되어 있다
	//		상속 : inheritance
	//		확장 : extends
	
	//		상속 : 단순히 그 기능만 가져오는 것
	//		확장 : 상속받은 기능 + 강아지만의 기능 추가해서 확장
	public Dog() {
		// TODO Auto-generated constructor stub
	}
	
	public Dog(String sort, int age, String where) {
		super(sort, age);
		this.where = where;
	}

	//@XXX : annotation >> 어떤 기능을 자동으로 연결해준다 >> Spring때 다시
	@Override//override : 상속받은 method의 기능을 추가 및 편집
		public void printInfo() {
			// TODO Auto-generated method stub
		// override를 사용하려면 상속받은 class의 method명과 같아야
			super.printInfo();//상위클래스.printInfo();
			System.out.println(where);
		}
	
	// vs
	//		overloading
	//			method 만들 때 그 기능 자체가 같다면
	//			method 명은 같게, parameter는 다르
	
}
