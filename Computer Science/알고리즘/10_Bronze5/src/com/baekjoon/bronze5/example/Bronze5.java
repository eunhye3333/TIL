package com.baekjoon.bronze5.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Calendar;
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
	
	public void no2914() {
		// 저작권
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int i = sc.nextInt();
		
		System.out.println(a * (i-1) + 1);
	}
	
	public void no3003() {
		// 킹, 퀸, 룩, 비숍, 나이트, 폰
		int king = 1;
		int queen = 1;
		int rook = 2;
		int bishop = 2;
		int knight = 2;
		int pawn = 8;
		
		Scanner sc = new Scanner(System.in);
		king -= sc.nextInt();
		queen -= sc.nextInt();
		rook -= sc.nextInt();
		bishop -= sc.nextInt();
		knight -= sc.nextInt();
		pawn -= sc.nextInt();
		
		System.out.printf("%d %d %d %d %d %d", king, queen, rook, bishop, knight, pawn);
	}
	
	public void no3046() {
		// R2
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int s = sc.nextInt();
		
		System.out.println(2 * s - r1);
	}
	
	public void no5337() {
		// 웰컴
		System.out.println(".  .   .");
		System.out.println("|  | _ | _. _ ._ _  _");
		System.out.println("|/\\|(/.|(_.(_)[ | )(/.");
	}
	
	public void no5338() {
		// 마이크로소프트 로고
		System.out.println("       _.-;;-._");
		System.out.println("\'-..-\'|   ||   |");
		System.out.println("\'-..-\'|_.-;;-._|");
		System.out.println("\'-..-\'|   ||   |");
		System.out.println("\'-..-\'|_.-''-._|");
	}
	
	public void no5339() {
		// 콜센터
		System.out.println("     /~\\");
		System.out.println("    ( oo|");
		System.out.println("    _\\=/_");
		System.out.println("   /  _  \\");
		System.out.println("  //|/.\\|\\\\");
		System.out.println(" ||  \\ /  ||");
		System.out.println("============");
		System.out.println("|          |");
		System.out.println("|          |");
		System.out.println("|          |");
	}
	
	public void no5522() {
		// 카드 게임
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			sum += sc.nextInt();
		}
		
		System.out.println(sum);
	}
	
	public void no5554() {
		// 심부름 가는 길
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			sum += sc.nextInt();
		}
		
		System.out.println(sum / 60);
		System.out.println(sum % 60);
	}
	
	public void no6749() {
		// Next in line
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println(m + (m - y));
	}
	
	public void no7287() {
		// 등록
		System.out.println("73");
		System.out.println("eunhye_3");	
	}
	
	public void no8370() {
		// Plane
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int k1 = sc.nextInt();
		int n2 = sc.nextInt();
		int k2 = sc.nextInt();
		
		System.out.println(n1 * k1 + n2 * k2);
	}
	
	public void no8437() {
		// Julka
		// 두 소녀가 가지고 있는 사과 개수와 Klaudia가 얼마나 더 가지고 있는지 입력받은 후 각자 가진 사과 수 출력
		Scanner sc = new Scanner(System.in);
		BigInteger sum = sc.nextBigInteger();
		BigInteger more = sc.nextBigInteger();
		BigInteger half = sum.subtract(more).divide(BigInteger.valueOf(2));
		
		System.out.println(half.add(more));
		System.out.println(half);
		
	}
	
	public void no9653() {
		// 스타워즈 로고
		System.out.println("    8888888888  888    88888");
		System.out.println("   88     88   88 88   88  88");
		System.out.println("    8888  88  88   88  88888");
		System.out.println("       88 88 888888888 88   88");
		System.out.println("88888888  88 88     88 88    888888");
		System.out.println();
		System.out.println("88  88  88   888    88888    888888");
		System.out.println("88  88  88  88 88   88  88  88");
		System.out.println("88 8888 88 88   88  88888    8888");
		System.out.println(" 888  888 888888888 88  88      88");
		System.out.println("  88  88  88     88 88   88888888");
	}
	
	public void no9654() {
		// 나부함대 데이터
		System.out.println("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE");
		System.out.println("N2 Bomber      Heavy Fighter  Limited    21        ");
		System.out.println("J-Type 327     Light Combat   Unlimited  1         ");
		System.out.println("NX Cruiser     Medium Fighter Limited    18        ");
		System.out.println("N1 Starfighter Medium Fighter Unlimited  25        ");
		System.out.println("Royal Cruiser  Light Combat   Limited    4         ");
	}
	
	public void no10699() {
		// 오늘 날짜
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		
		String m = "";
		String d = "";
		if(month < 10) {
			m = "0" + month;
		} else {
			m = Integer.toString(month);
		}
		
		if(day < 10) {
			d = "0" + day;
		} else {
			d = Integer.toString(day);
		}
		System.out.println(year + "-" + m + "-" + d);
	}
	
	public void no10757() {
		// 큰 수 A+B
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
	}
	
	public void no10926() {
		// ??!
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		System.out.println(id + "??!");
	}
	
	public void no11283() {
		// 한글 2
		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);
		System.out.println(ch - 44031);
	}
	
	public void no11382() {
		// 꼬마 정민
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger c = sc.nextBigInteger();
		
		System.out.println(a.add(b).add(c));
	}
	
	public void no15727() {
		// 조별과제를 하려는데 조장이 사라졌다
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		if(l % 5 == 0) {
			System.out.println(l/5);
		} else {
			System.out.println(l/5 + 1);
		}
	}
	
	public void no15894() {
		// 수학은 체육과목 입니다
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(n * 4);
	}
	
	public void no16430() {
		// 제리와 톰
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.print((b - a) + " " + b);
	}
	
	public void no17256() {
		// 달달함이 넘쳐 흘러
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			StringTokenizer a = new StringTokenizer(br.readLine());
			StringTokenizer c = new StringTokenizer(br.readLine());
			
			int[] aa = new int[3];
			int[] cc = new int[3];
			int[] result = new int[3];
			
			for(int i = 0; i < 3; i++) {
				aa[i] = Integer.parseInt(a.nextToken());
				cc[i] = Integer.parseInt(c.nextToken());
			}
			
			System.out.print(cc[0]- aa[2]);
			System.out.print(" ");
			System.out.print(cc[1] / aa[1]);
			System.out.print(" ");
			System.out.print(cc[2] - aa[0]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no17496() {
		// 스타후르츠
		Scanner sc = new Scanner(System.in);
		int summer = sc.nextInt();
		int grow = sc.nextInt();
		int area = sc.nextInt();
		int cost = sc.nextInt();
		
		System.out.println((summer - 1) / grow * area * cost);
	}
	
	public void no20492() {
		// 세금
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		System.out.println((int)(money * (1 - 0.22)));
		System.out.println((int)(money*0.8 + money*0.2*(1 - 0.22)));
	}
}
