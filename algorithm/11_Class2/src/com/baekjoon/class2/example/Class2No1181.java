package com.baekjoon.class2.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Class2No1181 {
	public void no1181() {
		// �ܾ� ����
		// ArrayList ���, Comparable ����
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int num = Integer.parseInt(br.readLine());
			ArrayList<String> str = new ArrayList<String>();
			
			for(int i = 0; i < num; i++) {
				str.add(br.readLine());
			}
			
			// �͸� ��ü�� �̿��Ͽ� Comparator ���
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
			
			// ������ ��ӹ޾� �������� comp1���� ����
			Collections.sort(str, comp1);
			
			// �ߺ��� �ܾ���� ��µ�
//			for(String s : str) {
//				System.out.println(s);
//			}
			
			System.out.println(str.get(0)); // �Ʒ� �ݺ��������� ���� ó�� ���ڿ��� ��µ��� �ʱ� ������ ���� ������־�� ��
			
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
