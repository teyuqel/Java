package project;

import java.util.Scanner;
import java.util.Random;

public class LuckyNumber {
	public static int totalgames = 1 ;
	public static int totalguess ;
	public static int bestgame;
	public static int test;
	// Hàm play để thực hiện trò chơi
	public static void play() {
		// Người dùng nhập số 
		System.out.print("Please enter a number: ");
		Scanner sc =  new Scanner(System.in);
		int n= sc.nextInt();
		// Hàm random ra số ngẫu nhiên từ 0 đến 100
		Random random = new Random();
		int x = random.nextInt(100);

		bestgame = test;
		// Tạo biến đếm số lần dự đoán của người chơi
		int count = 1;
		// Vòng lặp để đưa ra lượt chơi
		do {
			if(n>x) {
				System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
				System.out.print("Mời nhập lại số dự đoán của bạn: ");
				n = sc.nextInt();
				count++;
			}
			if(n<x) {
				System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
				System.out.print("Mời nhập lại số dự đoán của bạn: ");
				n = sc.nextInt();
				count++;
			}
			if(n==x) {
				System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + count +" lần dự đoán");
			}
		}while(n>x || n<x);
		totalguess +=count; //Tổng số lần dự đoán của người chơi
		test = count;
		if(bestgame >= count) {
			bestgame = count;
		}
		System.out.println("Bạn có muốn tiếp tục chơi không?");
		System.out.println("1.Có");
		System.out.println("2.Không");
		System.out.print("Nhập lựa chọn của bạn: ");
		int ans = sc.nextInt();
		switch(ans) {
		case 1:
			totalgames++;
			play();
			break;
		case 2:
			if (totalgames == 1) {
				bestgame = count;
			}
			report();
			break;
		}
	}
	// Hàm reprot tổng hợp dữ liệu của người chơi
	public static void report() {
		System.out.println("GAME OVER!");
		System.out.println("Tổng số lần chơi: " + totalgames);
		System.out.println("Tổng số lần dự đoán: " + totalguess);
		System.out.println("Số dự đoán trung bình mỗi lượt: " + (totalguess/totalgames));
		System.out.println("Best game : " + bestgame );
	}
	public static void main(String[] args) {
		play();
	}
}
