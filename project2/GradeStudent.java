package project;

import java.util.Scanner;

public class GradeStudent {
	// Hàm hiện thông báo mô tả chương trình 
	public static void begin() {
		System.out.println("This program reads exam/homework scores and reports your overall course grade.");
	}
	//	Hàm tính điểm giữa kỳ
	public static float midTerm() {
		System.out.println("Midterm:");
		System.out.print("Weight (0-100)? ");
		Scanner sc = new Scanner(System.in);
		float n = sc.nextFloat();
		System.out.print("Score earned? ");
		float x = sc.nextFloat();
		System.out.print("Were scores shifted (1=yes, 2=no)? ");
		int y = sc.nextInt();
		float diemGky = 0;
		// Chia 2 trường hợp nếu người dùng đc cộng điểm
		switch(y) {
		case 1:
			System.out.print("Shift amount? ");
			float z = sc.nextFloat();
			float a = x + z;
			// Kiểm tra điểm có vượt quá 100 không
			if(a>=100) {
				a = 100;
				diemGky = (float)(Math.ceil((a/100)*n*100))/100;
				System.out.println("Total points = " +  (int)a + " / 100");
				System.out.println("Weighted score = " + diemGky  + " / " + (int)n);
			}else {
				diemGky = (float)(Math.ceil((a/100)*n*100))/100;
				System.out.println("Total points = " + (int)a + " / 100");
				System.out.println("Weighted score = " + diemGky  + " / " + (int)n);
			}
			break;
		case 2:
			diemGky = (float)(Math.ceil((x/100)*n*100))/100;
			System.out.println("Total points = " + (int)x + " / 100");
			System.out.println("Weighted score = " + diemGky  + " / " + (int)n);
			break;
		}
		return diemGky;
	}
	//	Hàm tính điểm cuối kỳ
	public static float finalTerm() {
		System.out.print("\n");
		System.out.println("Final:");
		System.out.print("Weight (0-100)? ");
		Scanner sc = new Scanner(System.in);
		float n = sc.nextFloat();
		System.out.print("Score earned? ");
		float x = sc.nextFloat();
		System.out.print("Were scores shifted (1=yes, 2=no)? ");
		int y = sc.nextInt();
		float diemCky = 0;
		// Chia 2 trường hợp nếu người dùng đc cộng điểm
		switch(y) {
		case 1:
			System.out.print("Shift amount? ");
			float z = sc.nextFloat();
			float a = x + z;
			// Kiểm tra điểm có vượt quá 100 không
			if(a>=100) {
				a = 100;
				diemCky = (float)(Math.ceil((a/100)*n*100))/100;
				System.out.println("Total points = " +  (int)a + " / 100");
				System.out.println("Weighted score = " + diemCky  + " / " + (int)n);
			}else {
				diemCky = (float)(Math.ceil((a/100)*n*100))/100;
				System.out.println("Total points = " + (int)a + " / 100");
				System.out.println("Weighted score = " + diemCky  + " / " + (int)n);
			}
			break;
		case 2:
			diemCky = (float)(Math.ceil((x/100)*n*100))/100;
			System.out.println("Total points = " + (int)x + " / 100");
			System.out.println("Weighted score = " + diemCky  + " / " + (int)n);
			break;
		}
		return diemCky;
	}
	// Hàm tính điểm phần home work
	public static float homeWork() {
		System.out.print("\n");
		System.out.println("Homework: ");
		System.out.print("Weight (0-100)? ");
		Scanner sc = new Scanner(System.in);
		float n = sc.nextFloat();
		System.out.print("Number of assignments? ");
		int a = sc.nextInt();
		float q = 0, p = 0;
		float diemBtvn;
		// Vòng lặp để người dùng nhập khi có i bài assignment
		for(int i = 1; i <= a; i++) {
			System.out.print("Assignment " + i + " score and max? ");
			float c = sc.nextFloat();
			q += c;
			float d = sc.nextFloat();
			p += d;
		}
		System.out.print("How many sections did you attend? ");
		int e = sc.nextInt();
		int f = e*5;
		// Kiểm tra xem điểm của phần Attend có vượt quá 30 k
		if(f>=30) {
			f = 30;
			System.out.println("Sections points = 30 / 30 ");
		}else {
			System.out.println("Sections points = " + f + " / 30 ");
		}
		float w = q + f;
		float u = p + 30;
		// Kiểm tra điểm assignment có vượt quá 150 không
		if(w >= 150) {
			w = 150;
		}
		if(u >= 150) {
			u = 150;
		}
		diemBtvn = (float)(Math.ceil(((w)/(u))*n*100))/100;
		System.out.println("Total points = " + (int)(w) + " / " + (int)(u) );
		System.out.println("Weighted score = " + diemBtvn + " / " + (int)n);
		return diemBtvn;
	}
	// Hàm report tính toán và hiển thị kết quả GPA 
	public static void report() {
		System.out.print("\n");
		GradeStudent gs = new GradeStudent();
		// Gọi hàm và lấy dữ liệu trả về của các hàm
		float j = gs.midTerm();
		float k = gs.finalTerm();
		float l = gs.homeWork();
		float minGrade = j + k + l;
		System.out.print("\n");
		// Hiển thị điểm tổng kết
		System.out.println("Overall percentage = " + minGrade);
		// Kiểm tra GPA  
		if(minGrade >= 85) {
			System.out.println("Your grade will be at least: 3.0 ");
		}else if(minGrade >= 75 && minGrade < 85) {
			System.out.println("Your grade will be at least: 2.0 ");
		}else if(minGrade >= 60 && minGrade < 75) {
			System.out.println("Your grade will be at least: 1.0 ");
		}else {
			System.out.println("Your grade will be at least: 0.0");
		}
		System.out.println("<< your custom grade message here >> ");
	}
	// Hàm main chỉ gọi 2 hàm , do hàm report đã gọi 3 hàm trên
	public static void main(String[] args) {
		begin();
		report();
	}
}