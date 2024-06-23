package com.kang.oct273.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.kang.oct273.restaurant.Restaurant;
import com.kang.reservation.Reservation;

// 식당예약프로그램 - MVC 패턴 + JDBC(DB활용)
//		1. 예약하기
//		2. 매장등록
//		3. 전체 예약 확인
// 	 	4. 전체 매장 조회
// 		5. 매장찾기
//		6. 예약찾기
//		7. 예약정보수정
//		8. 예약취소
//		9. 프로그램 종료

//		[MVC패턴 생각해서!!]
//		콘솔에 찍히게
//		계속 반복해서 나오다가
//		9번 누르면 반복문 종료되게
public class Controller {
	public static void main(String[] args) {
		int menu = 0;
		String result = null;
		Reservation rsv = null;// Reservayion으로 return 받은 경우 사용
		Restaurant rst = null;// Restaurant으로 return 받은 경우 사용!
		ArrayList<Reservation> rsvResult = null;	
		ArrayList<Restaurant> rstResult = null;	
		
	
		
		
		System.out.println("<<예약 프로그램>>");
		while (true) {
			try {
				menu = View.showMainMenu();

				if (menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else if (menu == 1) {
					rsv = View.showRsvMenu();// DAO로 이동
					result = DAO.book(rsv);// View로 이동
					View.printResult(result);
				} else if (menu == 2) {
					rst = View.showRstMenu();
					result = DAO.registerRst(rst);
					View.printResult(result);

				} else if (menu == 3) {
					rsvResult = DAO.getAllReserve();
					View.showRsvResult(rsvResult);
					
/*					rsvResult = DAO.wholeRsv();
					View.showRsvResult(rsvResult);*/
					
					
					
					
				} else if (menu ==4) {
					// 4 번 누른 후에 콘솔에서 내가 따로 입력할 게 없음
					// DB에 저장되어있는 정보 전체 추력 -> DAO에서 select문 -> View
					rstResult = DAO.getAllRestaurant();
					View.showRstResult(rstResult);
				}else if (menu == 5) {
					rst = View.showSearchRst();
					rstResult = DAO.searchRestaurant(rst);
					View.showRstResult(rstResult);
					/*a = View.surchRst();
					result =DAO.sr(a)*/;
					
				}else if (menu == 6) {
					rsv = View.showSearchRsv();
					rsvResult = DAO.searchReserver(rsv);
					View.showRsvResult(rsvResult);
					
				/*	b = View.rsvName();
					result = DAO.findRsv(b);*/
					
				}else if (menu == 7) {
					// 전체 예약내역 먼저 보여주고 - menu 3번 받아다 쓰기
					rsvResult = DAO.getAllReserve();
					View.showRsvResult(rsvResult);
					// 예약번호, 변경할 연락처 받아서 
					rsv = View.showUpdaterrsv();
					
					// DB에 적용
					result = DAO.updateReserve(rsv);
					
					// 적용결과 보여주고
					View.printResult(result);
					
					
					// 전체 예약내역 한번더 보여주기 (확인용)
					rsvResult = DAO.getAllReserve();
					View.showRsvResult(rsvResult);
					
					
					
					/*c = View.reRsv();
					d = View.reRsv2();
					result = DAO.renum(c,d);
					*/
				}else if (menu == 8) {
					// 전체 예약내역 먼저 보여주고 - menu 3번 받아다 쓰기
					rsvResult = DAO.getAllReserve();
					View.showRsvResult(rsvResult);
					// 예약번호, 삭제할 연락처 받아서 
					rsv = View.deletersv();
					// DB에 적용
					result = DAO.deleteReserve(rsv);
					// 적용결과 보여주고
					View.printResult(result);
					// 전체 예약내역 한번더 보여주기 (확인용)
					rsvResult = DAO.getAllReserve();
					View.showRsvResult(rsvResult);
					
					/*
					f = View.deleteRsv();
					result = DAO.deRSV(f);
					*/
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
