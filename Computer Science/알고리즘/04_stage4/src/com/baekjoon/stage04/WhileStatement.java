package com.baekjoon.stage04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WhileStatement {
	public void no10952() {
		// A+B - 5
		Scanner sc = new Scanner(System.in);
		int[] aArr = {0};
		int[] bArr = {0};
	
		int i = 0;
		
		while(true) {
			aArr = Arrays.copyOf(aArr, i+1);
			bArr = Arrays.copyOf(bArr, i+1);
			System.out.print("a와 b를 입력하세요 : ");
			
			aArr[i] = sc.nextInt();
			bArr[i] = sc.nextInt();
			
			if(aArr[i] == 0 && bArr[i] == 0) {
				break;
			}
			i++;
		}
		System.out.println();
		
		for(int j = 0; j < i; j++) {
			System.out.println(aArr[j] + bArr[j]);
		}
	}
	
	public void no10951() {
		// A+B - 4
		// EOF 판단 
		// ctrl + z를 입력하면 EOF 발생
		
		System.out.println("정수 입력");
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			String str = "";
			
			while((str = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(str);
				int sum = 0;
				while(st.hasMoreTokens()) {
					sum += Integer.parseInt(st.nextToken());
				}
				list.add(sum);
			}
			
			System.out.println("덧셈 결과");
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void no1110() {
		// 더하기 사이클
		Scanner sc = new Scanner(System.in);
		System.out.print("0보다 크거나 같고, 99보다 작거나 같은 정수 입력 : ");
		int n = sc.nextInt();
		int ten = 0;
		int one = 0;
		if(n < 10) {
			ten = 0; 
			one = n;
		} else {
			ten = n / 10;
			one = n % 10;
		}
		
		int count = 0;
		int sum = 0;
		int newNum = 0;
		
		while(true) {
			sum = ten + one;
			if(sum < 10) {
				newNum = 10 * one + sum;
			} else {
				newNum = (10 * one) + (sum % 10);
			}
			ten = newNum / 10;
			one = newNum % 10;
			count++;
			if (newNum == n) {
				break;
			}
		}
		System.out.println("사이클 길이 : " + count);	
	}
	
	
}
