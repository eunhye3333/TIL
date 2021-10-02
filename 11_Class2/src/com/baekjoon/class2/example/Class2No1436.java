package com.baekjoon.class2.example;

import java.util.Scanner;

public class Class2No1436 {
	public void no1436() {
		// ¿µÈ­°¨µ¶ ¼ò
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int count = 1;
		int title = 666;
		while(count != num) {
			title++;
			String str = Integer.toString(title);
			if(str.contains("666")) {
				count++;
			}
		}
		
		System.out.println(title);
	}
}
