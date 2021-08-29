package com.baekjoon.stage05;

import java.util.Arrays;
import java.util.Scanner;

public class Array1D {
	public void no10818() {
		// �ּ�, �ִ�
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		int[] iArr = new int[num];
		
		System.out.print("������ ����� �����Ͽ� �Է��ϼ��� : ");
		for(int i = 0; i < num; i++) {
			iArr[i] = sc.nextInt();
		}
		
		int max = iArr[0];
		int min = iArr[0];
		
		for(int i = 1; i < num; i++) {
			if(min > iArr[i]) {
				min = iArr[i];
			}
			
			if(max < iArr[i]) {
				max = iArr[i];
			}
		}
		
		System.out.println("�ּҰ� : " + min);
		System.out.println("�ִ밪 : " + max);
//		System.out.println(min + " " + max);
		
	}
	
	public void no2562() {
		// �ִ�
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int max = 1;
		int index = 0;
		
		for(int i = 0; i < 9; i++) {
			System.out.print("�ڿ����� �Է��ϼ��� : ");
			arr[i] = sc.nextInt();
			if(arr[i] > max) {
				max = arr[i];
				index = i + 1;
			}
		}
		
		System.out.println();
		
		System.out.println("�ִ밪�� " + max + "�̸�, " + index + "��° �����Դϴ�.");
	}
	
	public void no2577() {
		// ������ ����
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڿ��� A�� �Է��ϼ��� : ");
		int numA = sc.nextInt();
		System.out.print("�ڿ��� B�� �Է��ϼ��� : ");
		int numB = sc.nextInt();
		System.out.print("�ڿ��� C�� �Է��ϼ��� : ");
		int numC = sc.nextInt();
		
		String result = Integer.toString(numA*numB*numC);
		
		int[] count = new int[10];
		
		for(int i = 0; i < result.length(); i++) {
			for	(int j = 0; j < 10; j++) {
				if (Character.getNumericValue(result.charAt(i)) == j) {
					// Character.getNumericValue() : ���� ������ char�� int�� ����ȯ���ִ� �޼ҵ�
					count[j]++;
				}
			}
			
		}
		
		System.out.println();
		
		for(int i = 0; i < count.length; i++) {
			System.out.println(i + "�� ���� : " + count[i]);
		}
	}
	
	public void no3052() {
		// ������
		Scanner sc = new Scanner(System.in);
		int[] result = new int[10];
		for(int i = 0; i < 10; i++) {
			System.out.print("������ �Է��ϼ��� : ");
			result[i] = sc.nextInt() % 42;
		}
		
		int[] copyArr = {result[0]};
		
		for(int i = 1; i < result.length; i++) {
			boolean flag = false;
			for(int j = 0; j < copyArr.length; j++) {
				if(result[i] == copyArr[j]) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				copyArr = Arrays.copyOf(copyArr, copyArr.length + 1);
				copyArr[copyArr.length - 1] = result[i];
			}
		}
		
		System.out.println("���� �ٸ� ������ ���� : " + copyArr.length);
		
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
	}
	
	public void no1546() {
		// ���
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		int[] score = new int[num];
		
		int max = 0;
		
		for(int i = 0; i < score.length; i++) {
			System.out.print("������ �Է��ϼ��� : ");
			score[i] = sc.nextInt();
			if(score[i] > max) {
				max = score[i];
			}
		}
		
		
		double[] editScore = new double[num];
		double sum = 0;
		
		for(int i = 0; i < editScore.length; i++) {
			editScore[i] = (double)score[i] / max * 100;
			sum += editScore[i];
		}
		
		System.out.println("���ο� ��� ���� : " + sum / num);
	}
	
	public void no8958() {
		// OX ����
		Scanner sc = new Scanner(System.in);
		System.out.print("�׽�Ʈ ���̽� ������ �Է��ϼ��� : ");
		int num = Integer.parseInt(sc.nextLine());
		String[] oxCase = new String[num];
		int[] score = new int[num];
		
		for(int i = 0; i < oxCase.length; i++) {
			System.out.print("OX �Է� : ");
			oxCase[i] = sc.nextLine();
			int count = 0;
			for(int j = 0; j < oxCase[i].length(); j++) {
				if(oxCase[i].charAt(j) == 'O') {
					count++;
					score[i] += count;
				} else {
					count = 0;
				}
			}
		}
		
		for(int i = 0; i < score.length; i++) {
			System.out.println((i + 1) + "�� ���̽��� ���� : " + score[i]);
		}
		
	}
	
	public void no4344() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�׽�Ʈ ���̽� ���� : ");
		int num = sc.nextInt();
		int[] studentNum = new int[num];
		double[] avg = new double[num];
		
		
		for(int i = 0; i < studentNum.length; i++) {
			System.out.print("�л� �� : ");
			studentNum[i] = sc.nextInt();
			int[] studentScore = new int[studentNum[i]];
			
			System.out.print("���� �Է� : ");
			for(int j = 0; j < studentScore.length; j++) {
				studentScore[j] = sc.nextInt();
				avg[i] += studentScore[j];
			}
			avg[i] = avg[i] / studentNum[i];
			int count = 0;
			
			for(int k = 0; k < studentScore.length; k++) {
				if(avg[i] < studentScore[k]) {
					count++;
				}
			}
			avg[i] = 100.0 / studentNum[i] * count;
		}
		
		for(int i = 0; i < avg.length; i++) {
			System.out.printf("����� �Ѵ� �л� ���� : %.3f%%%n", avg[i]);
		}
	}
	
}
