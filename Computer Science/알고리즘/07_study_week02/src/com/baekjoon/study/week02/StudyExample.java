package com.baekjoon.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudyExample {
	public void no1000() {
		// A+B
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("A, B�� �Է��ϼ���.");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sum = 0;
			while(st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			System.out.println(sum);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void no10869() {
		// ��Ģ����
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("A, B�� �Է��ϼ���.");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] num = new int[2];
			int i = 0;
			while(st.hasMoreTokens()) {
				num[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			
			System.out.println(num[0] + num[1]);
			System.out.println(num[0] - num[1]);
			System.out.println(num[0] * num[1]);
			System.out.println(num[0] / num[1]);
			System.out.println(num[0] % num[1]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void no10430() {
		// ������
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("A, B, C�� �Է��ϼ���.");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] num = new int[3];
			int i = 0;
			while(st.hasMoreTokens()) {
				num[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			
			System.out.println((num[0] + num[1]) % num[2]);
			System.out.println((num[0] % num[2] + num[1] % num[2]) % num[2]);
			System.out.println((num[0] * num[1]) % num[2]);
			System.out.println(((num[0] % num[2]) * (num[1] % num[2])) % num[2]);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no11654() {
		// �ƽ�Ű�ڵ�
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("���� �Է� : ");
			char ch = br.readLine().charAt(0);

			System.out.println((int)ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no2845() {
		// ��Ƽ�� ������ �� ��
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("����� ���� ���̸� �Է��ϼ���.");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
			
			System.out.println("�������� ���� �Է��ϼ���.");
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int[] gap = new int[5];
			int i = 0;
			
			while(st2.hasMoreTokens()) {
				gap[i] = Integer.parseInt(st2.nextToken());
				System.out.print(gap[i] - people);
				i++;
				if(i < 5) {
					System.out.print(" ");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no14652() {
		// ���� �ູ�մϴ�
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("���� �Է�");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
//			int count = -1;
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < m; j++) {
//					count++;
//					if(count == k) {
//						System.out.println(i + " " + j);
//					}
//				}
//			}
			
			System.out.println((k / m) + " " + (k % m));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no1271() {
		// ��û�� ����
		System.out.println("���� ����ü �� �Է�");

		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();

		System.out.println("����ü �ϳ����� ���ư��� ���� �� : " + n.divide(m));
		System.out.println("���� �� : " + n.remainder(m));

		
	}
	
}
