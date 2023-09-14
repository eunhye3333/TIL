package com.baekjoon.stage03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ForStatement {
	public void no2739() {
		// ������
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		int dan = sc.nextInt();
		
		if(dan >= 1 && dan <= 9) {
			for(int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d%n", dan, i, dan*i);
			}
		}
	}
	
	public void no10950() {
		// A+B - 3
		Scanner sc = new Scanner(System.in);
		System.out.print("�׽�Ʈ ���̽� ������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		int[] aArr = new int[num];
		int[] bArr = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("a�� b�� �Է����ּ��� : ");
			aArr[i] = sc.nextInt();
			bArr[i] = sc.nextInt();
		}
		
		System.out.println();
		
		for(int i = 0; i < num; i++) {
			System.out.println(aArr[i] + bArr[i]);
		}
	}
	
	public void no8393() {
		// ��
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int n = sc.nextInt();
		// �ݺ��� ���
		int sum = 0;
		
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		// �ݺ��� ������� �ʱ�
//		System.out.println(n * (n+1) / 2);
	}
	
	public void no15552() {
		// ���� A+B
		// ���� ���
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
			
			System.out.print("�׽�Ʈ ���̽� ������ �Է��ϼ��� : ");
			int tc = Integer.parseInt(br.readLine());
			StringTokenizer st;
			
			for(int i = 0; i < tc; i++) {
				st = new StringTokenizer(br.readLine());
				bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
			}
			bw.flush();
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void no2741() {
		// N ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڿ����� �Է��ϼ��� : ");
		int n = sc.nextInt();
		
		if(n >= 1 && n <= 100000) {
			for(int i = 1; i <= n; i++) {
				System.out.println(i);
			}
		}
	}
	
	public void no2742() {
		// ���� N
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڿ����� �Է��ϼ��� : ");
		int n = sc.nextInt();
		
		for(; n > 0; n--) {
			System.out.println(n);
		}
	}
	
	public void no11021() {
		// A+B - 7
		Scanner sc = new Scanner(System.in);
		System.out.print("�׽�Ʈ ���̽� ������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		int[] aArr = new int[num];
		int[] bArr = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("a�� b�� �Է����ּ��� : ");
			aArr[i] = sc.nextInt();
			bArr[i] = sc.nextInt();
		}
		
		System.out.println();
		
		for(int i = 0; i < num; i++) {
			System.out.printf("Case #%d: %d%n", i+1, aArr[i]+bArr[i]);
		}
	}
	
	public void no11022() {
		// A+B - 8
		Scanner sc = new Scanner(System.in);
		System.out.print("�׽�Ʈ ���̽� ������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		int[] aArr = new int[num];
		int[] bArr = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("a�� b�� �Է����ּ��� : ");
			aArr[i] = sc.nextInt();
			bArr[i] = sc.nextInt();
		}
		
		System.out.println();
		
		for(int i = 0; i < num; i++) {
			System.out.printf("Case #%d: %d + %d = %d%n", i+1, aArr[i], bArr[i], aArr[i]+bArr[i]);
		}
	}
	
	public void no2438() {
		// �� ��� - 1
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ���� �Է��ϼ��� : ");
		int n = sc.nextInt();
		
		if (n >= 1 && n <= 100) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
	
	public void no2439() {
		// �� ��� - 2
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ���� �Է��ϼ��� : ");
		int n = sc.nextInt();
		
		if (n >= 1 && n <= 100) {
			for(int i = 1; i <= n; i++) {
				for(int j = n; j > 0; j--) {
					if (j <= i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
	
	public void no10871() {
		// X���� ���� ��
		Scanner sc = new Scanner(System.in);
		System.out.print("N�� X�� �Է��ϼ��� (����� ����) : ");
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.print("������ �Է��ϼ��� : ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			if(arr[i] < x) {
				System.out.print(arr[i] + " ");
			}
		}
		
	}
}
