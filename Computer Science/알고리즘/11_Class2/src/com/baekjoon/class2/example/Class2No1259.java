package com.baekjoon.class2.example;

import java.util.Scanner;

public class Class2No1259 {
	public void no1259() {
		// 팰린드롬수
		// 참고 : 1~9는 모두 팰린드롬수이다
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		while(input != 0) {
			System.out.println(palindrome(input));
			input = sc.nextInt();

		}
	}
	
	public String palindrome(int number) {
		String str = Integer.toString(number);
		int len = str.length();
		String result = "yes";
		
		if(len != 1) {
			for(int i = 0; i < len; i++) {
				if(str.charAt(i) != str.charAt(len - 1 - i)) {
					result = "no";
				}
			}
		}
		
		return result;
	}
}
