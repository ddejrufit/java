import java.util.Iterator;

// 초시계
// 일자 시 분 초
// 1초마다 콘솔에 찍히는 값이 증가
// ex] [DAY01] 00:00:01 <- 실행후 1초뒤 콘솔에 찍히게
// ex] [DAY01] 00:00:02 <- 실행후 2초뒤 콘솔에 찍히게

//Thread.sleep(mill)

public class RMain4 {
	public static void main(String[] args) throws InterruptedException {
		for (int day = 1; day < 32; day++) {

			for (int hour = 0; hour < 24; hour++) {
				for (int minute = 0; minute < 60; minute++) {
					for (int second = 0; second < 60; second++) {
						System.out.printf("[DAY%02d]%02d:%02d:%02d\r\n",day,hour, minute, second);
						Thread.sleep(1000);
					}
				}
			}
		}

//		for (int a = 0; a <= 9; a++) {
//			for (int b = 0; b <= 9; b++) {
//				for (int c = 0; c <= 2; c++) {
//					for (int d = 0; d <= 3; d++) {
//						for (int e = 0; e <= 5; e++) {
//							for (int f = 0; f <= 9; f++) {
//								for (int g = 0; g <= 5; g++) {
//									for (int i = 0; i <= 9; i++) {
//										System.out.printf("\r\n[DAY%d%d] %d%d:%d%d:%d%d", a, b, c, d, e, f, g, i);
//										Thread.sleep(1000);
//											
//									}
//
//								}
//							}
//						}
//					}
//				}
//			}
//		}
	}
}