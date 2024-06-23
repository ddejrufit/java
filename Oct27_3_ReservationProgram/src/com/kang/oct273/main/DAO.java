package com.kang.oct273.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.kang.db.manager.KangDBManager;
import com.kang.oct273.restaurant.Restaurant;
import com.kang.reservation.Reservation;
// Model의 다른말 : DAO(DAO라는 말을 더 많이 사용)
// DAO / DTO
//		MVC 패턴
//		DAO (Data Access Object)
//			: Model 중에서도 DB관련한 작업을 전담하는 클래스
//		DTO (Data Transfer/Temporary Object)
//			: DAO의 작업결과를 표현해주는 클래스

//	Oracle DB + DB연결 : Ojdbc8.jar, DBManager.jar

// java.util.Date	- 주력(Spring에서 이걸 원함)
// java.sql.Date 	- JDBC에서는 이걸 원함

//java.util.Date로 받아온 날짜를 -> java.sql.Date로 바꿔야
//		: new Date(클래스명.get날짜관련멤버변수명().getTime());

// java.sql.Date -> java.util.Date : 알아서 바꿔줌(신경안써도 됨)
public class DAO {

	// 1. 예약하기
	public static String book(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KangDBManager.connect();

			String sql = "insert into oct27_reservation values(" + " oct27_reservation_seq.nextval," + " ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);

			// parameter로 가져온 하리보 껍질포장 뜯어서 r_name부분 가져오겠다
			pstmt.setString(1, rsv.getR_name());
			pstmt.setDate(2, new Date(rsv.getR_time().getTime()));
			pstmt.setString(3, rsv.getR_phone());
			pstmt.setString(4, rsv.getR_location());

			if (pstmt.executeUpdate() == 1) {
				return "예약성공"; // Controller 거쳐서 View로 보내줘야 하기 때문
			}
			return "";// Java문법상 필요해서 억지로 넣은 것!
		} catch (Exception e) {
			e.printStackTrace();
			return "예약실패";
		} finally {
			KangDBManager.close(con, pstmt, null);
		}
	}

	// 2. 매장등록 -c(insert)
	public static String registerRst(Restaurant rst) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KangDBManager.connect();
			String sql = "insert into oct27_restaurant " + "values( ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rst.getR_location());
			pstmt.setString(2, rst.getR_owner());
			pstmt.setInt(3, rst.getR_seat());

			if (pstmt.executeUpdate() == 1) {
				return "매장 등록 성공";
			}
			return "";

		} catch (Exception e) {
			e.printStackTrace();
			return "매장 등록 실패";
		} finally {
			KangDBManager.close(con, pstmt, null);
		}
	}

	// 3. 전체 예약 확인
	public static ArrayList<Reservation> getAllReserve() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KangDBManager.connect();
			String sql = "select * from oct27_reservation order by r_no";
			pstmt = con.prepareStatement(sql);
			
			// rs : select문을 수행한 결과
			rs = pstmt.executeQuery(); // select문 이외의 나머지 C,U,D > executeUpdate()
			
			// rs에 담긴 결과를 javabean에 하나 하나 넣어서 javabean을 채워넣을
			// 빈 ArrayList 만들기
			ArrayList<Reservation>rsvs = new ArrayList<Reservation>();
			// 빈 ArrayList를 채울 빈 javabean 객체 하나 꺼내두기
			Reservation r = null;
			
			while (rs.next()) {
				 r = new Reservation(); // javabean 객체 하나 꺼내두기
				 r.setR_no(rs.getInt("r_no")); // DB 필드명
				 r.setR_name(rs.getString("r_name"));
				 r.setR_time(rs.getDate("r_time"));
				 r.setR_phone(rs.getString("r_phone"));
				 r.setR_location(rs.getString("R_R_LOCATION"));//javabean완성되면
				 rsvs.add(r); // ArrayList에 지금 만든 javabean 하나 넣어주기
				 
			}
		    return rsvs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			// 괄호 안의 변수는 method 만들 때 넣었던 parameter자리 순서 그대로
			KangDBManager.close(con, pstmt, rs);
		}
	}
	
	/*
	public static ArrayList<Reservation> wholeRsv() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = KangDBManager.connect();
			String sql = "select*from oct27_reservation ";
			pstmt = con.prepareStatement(sql);
			// sql문을 통해 나온 데이터는 모두 rs
			rs = pstmt.executeQuery();

			// rs에 있는 결과를 ArrayList
			// ArrayList : 자바빈 한줄 한줄 모아놓은 것 (낱개포장 모아놓은 큰 통)
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			Reservation r = null; // 낱개포장
			while (rs.next()) {// 반복문으로 낱개 포장 뜯어서 rs값 채우기
				r = new Reservation();
				r.setR_no(rs.getInt("r_no")); // DB필드명 그대로
				r.setR_name(rs.getString("r_name"));
				r.setR_time(rs.getTimestamp("r_time"));
				r.setR_phone(rs.getString("r_phone"));
				r.setR_location(rs.getString("r_location"));
				rsvs.add(r);// rs값 다 채우면 낱개 포장 arrayList에 담기
			}
			return rsvs; // 낱개포장 다 담은 큰통을 return
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KangDBManager.close(con, pstmt, rs);
		}

	}*/

	// 4. 전체 매장 확인 (지점명 오름차순정렬)
	public static ArrayList<Restaurant> getAllRestaurant() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = KangDBManager.connect();
			String sql = "select*from oct27_restaurant order by r_location";
			pstmt = con.prepareStatement(sql);
			// sql문을 통해 나온 데이터는 모두 rs
			rs = pstmt.executeQuery();

			// rs에 있는 결과를 ArrayList
			// ArrayList : 자바빈 한줄 한줄 모아놓은 것 (낱개포장 모아놓은 큰 통)
			ArrayList<Restaurant> rsts = new ArrayList<Restaurant>();
			Restaurant r = null; // 낱개포장
			while (rs.next()) {// 반복문으로 낱개 포장 뜯어서 rs값 채우기
				r = new Restaurant();
				r.setR_location(rs.getString("r_location")); // DB필드명 그대로
				r.setR_owner(rs.getString("r_owner"));
				r.setR_seat(rs.getInt("r_seat"));
				rsts.add(r);// rs값 다 채우면 낱개 포장 arrayList에 담기
			}
			return rsts; // 낱개포장 다 담은 큰통을 return
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KangDBManager.close(con, pstmt, rs);
		}

	}

	// 5. 매장찾기 (입력한 좌석 수 이상을 가지고 있는 매장, 지점명 오름차순) - R(select)
	public static ArrayList<Restaurant> searchRestaurant(Restaurant rst) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con = KangDBManager.connect();
			String sql = "select*from oct27_restaurant "
					+ "where r_seat >= 50 order by r_location";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rst.getR_seat());// parameter로 가지고 온 javavbean의 seat
			rs = pstmt.executeQuery();
			
			ArrayList<Restaurant> rsts = new ArrayList<Restaurant>();
			Restaurant r = null;
			/*while (rs.next()) {
				r = new Restaurant();
				r.setR_location(rs.getString("r_location"));
				r.setR_owner(rs.getString("r_owner"));
				r.setR_seat(rs.getInt("r_seat"));
				rsts.add(r);
			}*/
			while (rs.next()) {
				rsts.add(new Restaurant(rs.getString("r_location"), rs.getString("r_owner"), rs.getInt("r_seat")));
			}
			return rsts;
		} catch (Exception e) {
			e.printStackTrace();
		return null;
		}finally {
			KangDBManager.close(con, pstmt, rs);
		}
	}
	
	
	/*public static String sr(int a) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = KangDBManager.connect();
			String sql = "select * from oct27_restaurant where r_seat >= ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, a);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("===========================");
				System.out.println(rs.getString("r_location"));
				System.out.println(rs.getString("r_owner"));
				System.out.println(rs.getInt("r_seat"));
				System.out.println("===========================");
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			KangDBManager.close(con, pstmt, rs);
		}
		return null;

	}
*/


	// 6. 예약자 이름으로 예약찾기, 예약 번호 순 정렬
	
	public static ArrayList<Reservation> searchReserver(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con = KangDBManager.connect();
			String sql = "select * from oct27_reservation "
					+ "where r_name like '%'||?||'%' "
					+ "order by r_no;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getR_name());
			rs = pstmt.executeQuery();
			
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			while (rs.next()) {
				rsvs.add(new Reservation(rs.getInt("r_no"), rs.getString("r_name"), rs.getDate("r_time"), rs.getString("r_phone"), rs.getString("r_location")));
			}
			return rsvs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KangDBManager.close(con, pstmt, rs);
		}
	}
	
	
	/*public static String findRsv(String b) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KangDBManager.connect();
			String sql = "select * from oct27_reservation where r_name in ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, b);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				while (rs.next()) {
					System.out.println("===========================");
					System.out.println(rs.getInt("r_no"));
					System.out.println(rs.getString("r_name"));
					System.out.println(rs.getTimestamp("r_time"));
					System.out.println(rs.getString("r_phone"));
					System.out.println(rs.getString("r_location"));
					System.out.println("===========================");
				}
			}else {
				System.out.println("해당 예약자 없음");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			KangDBManager.close(con, pstmt, rs);
		}
		return b;
	}
*/
	
	
	
	// 7. 예약 정보 수정
	public static String updateReserve(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			con = KangDBManager.connect();
			String sql = "update oct27_reservation "
					+ "set r_phone = ? "
					+ "where r_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getR_phone());
			pstmt.setInt(2, rsv.getR_no());
			
			if (pstmt.executeUpdate()==1) {
				return "예약 수정 성공";
				
			}
			return "예약정보 없음"; // sql문에는 문제가 X, 적용될 데이터가 없다는 뜻!
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 수정 실패";
		}finally {
			KangDBManager.close(con, pstmt, null);
		}
	}
	
	
	/*public static String renum(int c, String d) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = KangDBManager.connect();

			String sql = "update oct27_reservation" + "	set r_phone  = ?" + "	where r_no = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, d);
			pstmt.setInt(2, c);

			if (pstmt.executeUpdate() >= 1) {
				System.out.println("전화번호를 수정했습니다.");
			} else {
				System.out.println("해당예약자 없음");
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			KangDBManager.close(con, pstmt, null);
		}
		return d;
	}
*/
	// 8. 예약 취소(예약번호로)
	public static String deleteReserve(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			con = KangDBManager.connect();
			String sql = "delete oct27_reservation "
					+ "where r_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rsv.getR_no());
			
			if (pstmt.executeUpdate()==1) {
				return "예약 삭제 성공";
				
			}
			return "예약정보 없음";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 삭제 실패";
		}finally {
			KangDBManager.close(con, pstmt, null);
		}
	}
	
	
	
	/*
	public static String deRSV(int f) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KangDBManager.connect();

			String sql = "delete from oct27_reservation " + "where r_no = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, f);

			if (pstmt.executeUpdate() >= 1) {// '%무%'객체가 여러개일수 있어 1줄 보다 많은 줄 바뀔수 있음 !
				System.out.println("예약이 삭제되었습니다.");
			} else {
				System.out.println("해당예약 없음");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			KangDBManager.close(con, pstmt, null);
		}
		return null;

	}*/
}
