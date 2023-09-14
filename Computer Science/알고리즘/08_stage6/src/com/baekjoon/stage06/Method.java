package com.baekjoon.stage06;

import java.util.Scanner;

public class Method {
	public void no15596() {
		// ���� N���� ��
		// �Լ� �ۼ��Ͽ� Ǯ��
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���� �Է� : ");
		int n = sc.nextInt();
		int[] a = new int[n];
		System.out.println("���� �Է�");
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
		// �Ѽ�
		// 1 ~ 99�� ��� ���� ������
		// ex. 31�� ������ -2�� ����
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڿ��� �Է� : ");
		int n = sc.nextInt();
		
		System.out.println("�Ѽ��� ���� : " + hansu(n));
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
