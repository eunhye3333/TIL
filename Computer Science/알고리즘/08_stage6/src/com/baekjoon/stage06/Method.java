package com.baekjoon.stage06;

import java.util.Scanner;

public class Method {
	public void no15596() {
		// 정수 N개의 합
		// 함수 작성하여 풀기
		Scanner sc = new Scanner(System.in);
		System.out.print("정수의 개수 입력 : ");
		int n = sc.nextInt();
		int[] a = new int[n];
		System.out.println("정수 입력");
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(sum(a));
	}

	public long sum(int[] a) {
		// no15596
		long sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
			
		return sum;
	}
	
	public void no1065() {
		// 한수
		// 1 ~ 99는 모두 등차 수열임
		// ex. 31은 공차가 -2인 수열
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 입력 : ");
		int n = sc.nextInt();
		
		System.out.println("한수의 개수 : " + hansu(n));
	}
	
	public int hansu(int n) {
		// no1065
		int count = 0;
		
		for(int i = 1; i <= n; i++) {
			String num = Integer.toString(i);
			int[] arr = new int[num.length() - 1]; 
			for(int j = 0; j < arr.length; j++) {
				arr[j] = Character.getNumericValue(num.charAt(j + 1)) - Character.getNumericValue(num.charAt(j));
			}
			
			boolean flag = false;
			
			for(int k = 1; k < arr.length; k++) {
				if(arr[k] != arr[k-1]) {
					flag = true;
				}
			}
			
			if(!flag) {
				count++;
			}
		}
		
		return count;
	}
}
