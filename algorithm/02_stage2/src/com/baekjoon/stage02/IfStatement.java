package com.baekjoon.stage02;

import java.util.Scanner;

public class IfStatement {
	public void no1330() {
		// 두 수 비교하기
		Scanner sc = new Scanner(System.in);
		System.out.print("A, B 입력 : ");
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		
		if (a >= -10000 && a <= 10000 && b >= -10000 && b <= 10000) {
			if(a > b) {
				System.out.println(">");
			} else if (a < b){
				System.out.println("<");
			} else {
				System.out.println("==");
			}
		}
	}
	
	public void no9498() {
		// 시험 성적
		Scanner sc = new Scanner(System.in);
		System.out.print("시험 성적 입력 : ");
		int grade = sc.nextInt();
		if(grade >= 0 && grade <= 100) {
			if(grade >= 90 && grade <= 100) {
				System.out.println("A");
			} else if(grade >= 80 && grade < 90) {
				System.out.println("B");
			} else if(grade >= 70 && grade < 80) {
				System.out.println("C");
			} else if(grade >= 60 && grade < 70) {
				System.out.println("D");
			} else {
				System.out.println("F");
			}
		}
	}
	
	public void no2753() {
		// 윤년 
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = sc.nextInt();
		
		if (year >= 1 && year <= 4000) {
			if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
				System.out.println("1"); // 윤년
			} else {
				System.out.println("0"); // 윤년이 아님
			}
		}
	}
	
	public void no14681() {
		// 사분면 고르기
		Scanner sc = new Scanner(System.in);
		System.out.print("x 입력 : ");
		int x = sc.nextInt();
		System.out.print("y 입력 : ");
		int y = sc.nextInt();
		
		if (x >= -1000 && x <= 1000 && y >= -1000 && y <= 1000) {
			if (x != 0 && y != 0) {
				if (x > 0 && y > 0) {
					System.out.println("1");
				} else if (x < 0 && y > 0) {
					System.out.println("2");
				} else if (x < 0 && y < 0) {
					System.out.println("3");
				} else if (x > 0 && y < 0) {
					System.out.println("4");
				}
			}
		}
	}
	
	public void no2884() {
		// 알람 시계
		Scanner sc = new Scanner(System.in);
		System.out.print("시간 입력 : ");
		int h = sc.nextInt();
		System.out.print("분 입력 : ");
		int m = sc.nextInt();
		
		if(h >= 0 && h <= 23 && m >= 0 && m <= 59) {
			if (m >= 45) {
				m -= 45;
				System.out.printf("%d %d", h, m);
			} else if (m < 45 && h != 0) {
				h--;
				m = m + 60 - 45;
				System.out.printf("%d %d", h, m);
			} else {
				h = 23;
				m = m + 60 - 45;
				System.out.printf("%d %d", h, m);
			}
		}
	}
}
