package com.baekjoon.stage01;

import java.util.Scanner;

public class Operation {
	public void no2588() {
		// ���� : https://www.acmicpc.net/problem/2588
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �ڸ� �ڿ��� 1 �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�� �ڸ� �ڿ��� 2 �Է� : ");
		int num2 = sc.nextInt();
		
		System.out.println(num1 * ((num2 % 100) % 10));
		System.out.println(num1 * ((num2 % 100) / 10));
		System.out.println(num1 * (num2 / 100));
		System.out.println(num1 * num2);
	}
}
