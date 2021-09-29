package com.baekjoon.bronze5.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bronze5 {
	public void no1550() {
		// 16진수
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("16진수 입력 : ");
			int hex = Integer.parseInt(br.readLine(), 16);
			System.out.println(hex);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no2338() {
		// 긴자리 계산
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
	}
	
	public void no2475() {
		// 검증수
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				sum += (int)Math.pow(num, 2);
			}
			System.out.println(sum % 10);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no2558() {
		// A+B - 2
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a+b);
	}
}
