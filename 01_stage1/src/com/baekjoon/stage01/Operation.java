package com.baekjoon.stage01;

import java.util.Scanner;

public class Operation {
	public void no2588() {
		// 곱셈 : https://www.acmicpc.net/problem/2588
		Scanner sc = new Scanner(System.in);
		System.out.print("세 자리 자연수 1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("세 자리 자연수 2 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.println(num1 * ((num2 % 100) % 10));
		System.out.println(num1 * ((num2 % 100) / 10));
		System.out.println(num1 * (num2 / 100));
		System.out.println(num1 * num2);
	}
}
