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
			System.out.println("A, B를 입력하세요.");
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
		// 사칙연산
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("A, B를 입력하세요.");
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
		// 나머지
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("A, B, C를 입력하세요.");
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
		// 아스키코드
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("글자 입력 : ");
			char ch = br.readLine().charAt(0);

			System.out.println((int)ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no2845() {
		// 파티가 끝나고 난 뒤
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("사람의 수와 넓이를 입력하세요.");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
			
			System.out.println("참가자의 수를 입력하세요.");
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
		// 나는 행복합니다
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("정수 입력");
			
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
		// 엄청난 부자
		System.out.println("돈과 생명체 수 입력");

		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();

		System.out.println("생명체 하나에게 돌아가는 돈의 양 : " + n.divide(m));
		System.out.println("남는 돈 : " + n.remainder(m));

		
	}
	
}
