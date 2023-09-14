package com.baekjoon.class2.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Class2No1181 {
	public void no1181() {
		// 단어 정렬
		// ArrayList 사용, Comparable 정렬
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int num = Integer.parseInt(br.readLine());
			ArrayList<String> str = new ArrayList<String>();
			
			for(int i = 0; i < num; i++) {
				str.add(br.readLine());
			}
			
			// 익명 객체를 이용하여 Comparator 상속
			Comparator<String> comp1 = new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length() == o2.length()) {
						return o1.compareTo(o2);
					} else {
						return o1.length() - o2.length();
					}
				}
			};
			
			// 위에서 상속받아 재정의한 comp1으로 정렬
			Collections.sort(str, comp1);
			
			// 중복된 단어까지 출력됨
//			for(String s : str) {
//				System.out.println(s);
//			}
			
			System.out.println(str.get(0)); // 아래 반복문에서는 제일 처음 문자열이 출력되지 않기 때문에 먼저 출력해주어야 함
			
			for(int i = 1; i < str.size(); i++) {
				if(!str.get(i).equals(str.get(i-1))) {
					System.out.println(str.get(i));
				}
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
