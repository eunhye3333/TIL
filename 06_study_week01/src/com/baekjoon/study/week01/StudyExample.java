package com.baekjoon.study.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudyExample {
	public void no1008() {
		// A/B
		Scanner sc = new Scanner(System.in);
		System.out.print("A : ");
		int a = sc.nextInt();
		System.out.print("B : ");
		int b = sc.nextInt();
		
		System.out.println("A / B : " + (double)a / b);
	}
	
	public void no4673() {
		// 셀프 넘버
		String[] strNum = new String[10000];
		int[] num = new int[10000];
		
		for(int i = 0; i < strNum.length; i++) {
			strNum[i] = Integer.toString(i+1);
			num[i] += i+1;
			for(int j = 0; j < strNum[i].length(); j++) {
				num[i] += Character.getNumericValue(strNum[i].charAt(j));
			}
		}
		
		for(int i = 1; i <= 10000; i++) {
			boolean flag = true;
			for(int j = 0; j < num.length; j++) {
				if(num[j] == i) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println(i);
			}
		}
	}
	
	public void no1157() {
		// 단어 공부
		Scanner sc = new Scanner(System.in);
		System.out.print("단어 입력 : ");
		String str = sc.nextLine().toUpperCase();
		char[] ch = {str.charAt(0)};
		
		
		for(int i = 0; i < str.length(); i++) {
			boolean flag = true;
			for(int j = 0; j < ch.length; j++) {
				if(ch[j] == str.charAt(i)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				ch = Arrays.copyOf(ch, ch.length+1);
				ch[ch.length-1] = str.charAt(i);
			}
		}
		
		int[] count = new int[ch.length];
		int max = 0;
		
		for(int i = 0; i < ch.length; i++) {
			for(int j = 0; j < str.length(); j++) {
				if(ch[i] == str.charAt(j)) {
					count[i]++;
				}
			}
			if(max < count[i]) {
				max = count[i];
			}
		}
		
		int dup = 0;
		int result = 0;
		for(int i = 0; i < count.length; i++) {
			if(max == count[i]) {
				dup++;
				result = i;
			}
		}
		
		if(dup > 1) {
			System.out.println("?");
		} else {
			System.out.println("가장 많이 사용된 알파벳 : " + ch[result]);
		}
	}
	
	public void no1152() {
		// 단어의 개수
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("문자열 입력 : ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = 0;
			while(st.hasMoreTokens()) {
				st.nextToken();
				count++;
			}
			
			System.out.println("단어의 개수 : " + count);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void no2839() {
		// 설탕 배달
		Scanner sc = new Scanner(System.in);
		System.out.print("배달해야 할 설탕의 무게 : ");

	}
	
	public void no1978() {
		// 소수 찾기
		Scanner sc = new Scanner(System.in);
		System.out.print("수의 개수 : ");
		int num = sc.nextInt();
		int primeNum = 0;
		
		for(int i = 0; i < num; i++) {
			int inputNum = sc.nextInt();
			int count = 0;
			for(int j = 1; j <= inputNum; j++) {
				if(inputNum % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				primeNum++;
			}
		}
		System.out.println("소수의 개수 : " + primeNum);
	}
	
	public void no10872() {
		// 팩토리얼
		Scanner sc = new Scanner(System.in);
		System.out.print("N을 입력하세요 : ");
		int n = sc.nextInt();
		int result = 1;
		if(n != 0) {
			for(int i = 1; i <= n; i++) {
				result *= i;
			}
		} 
		System.out.println(result);
	}
	
	public void no2231() {
		// 분해합
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int result = 0;
		
		for(int i = 1; i <= 1000000; i++) {
			String strNum = Integer.toString(i);
			int sum = i;
			for(int j = 0; j < strNum.length(); j++) {
				sum += Character.getNumericValue(strNum.charAt(j));
			}
			if(sum == num) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
	
	public void no2750() {
		// 수 정렬하기
		Scanner sc = new Scanner(System.in);
		System.out.print("수의 개수 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print("정수 입력 : ");
			arr[i] = sc.nextInt();
		}
		
		int[] copyArr = new int[num];
		int key = 0;
		for(int i = 0; i < arr.length; i++) {
			key = arr[i];
			for(int j = i+1; j < arr.length; j++) {
				if(key > arr[j]) {
					copyArr[i] = arr[j];
					copyArr[j] = arr[i];
				} else {
					copyArr[i] = arr[i];
					copyArr[j] = arr[j];
					break;
				}
				
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(copyArr[i]);
		}
	}
	
}
