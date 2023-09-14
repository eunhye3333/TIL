package com.baekjoon.class2.example;

import java.util.Scanner;

public class Class2No1085 {
	public void no1085() {
		// 직사각형에서의 탈출
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int width = x < w - x ? x : w - x;
		int height = y < h - y ? y : h - y;
		
		
		if(width <= height) {
			System.out.println(width);
		} else {
			System.out.println(height);
		}
	}
}
