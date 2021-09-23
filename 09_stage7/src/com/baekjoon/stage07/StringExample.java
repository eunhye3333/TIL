package com.baekjoon.stage07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringExample {
	public void no11720() {
		// 숫자의 합	
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("개수 입력 : ");
			int num = Integer.parseInt(br.readLine());
			System.out.print("숫자 입력 : ");
			String str = br.readLine();
			
			if(num == str.length()) {
				int sum = 0;
				for(int i = 0; i < str.length(); i++) {
					sum += Character.getNumericValue(str.charAt(i));
				}
				System.out.println("합계 : " + sum);
			} else {
				System.out.println("숫자의 개수를 잘못 입력하였습니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no10809() {
		// 알파벳 찾기
//		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
//			System.out.print("단어 입력 : ");
//			String word = br.readLine();
//			int[] alphabet = new int[26];
//			Arrays.fill(alphabet, -1);
//			
//			for(int i = 0; i < word.length(); i++) {
//				for(int j = 0; j < alphabet.length; j++) {
//					if(word.charAt(i) == 'a' + j && alphabet[j] == -1) {
//						alphabet[j] = i;
//						break;
//					}
//				}
//			}
//			
//			for(int i = 0; i < alphabet.length; i++) {
//				if(i == alphabet.length -1) {
//					System.out.print(alphabet[i]);
//				} else {
//					System.out.print(alphabet[i] + " ");
//				}
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// for문 한 번만 사용하여 구현
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("단어 입력 : ");
			String word = br.readLine();
			int[] alphabet = new int[26];
			Arrays.fill(alphabet, -1);
			
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if(alphabet[c -'a'] == -1) {
					alphabet[c -'a'] = i;
				}
			}
			
			for(int i = 0; i < alphabet.length; i++) {
				if(i == alphabet.length -1) {
					System.out.print(alphabet[i]);
				} else {
					System.out.print(alphabet[i] + " ");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no2675() {
		// 문자열 반복
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("테스트케이스 개수 입력 : ");
			int tc = Integer.parseInt(br.readLine());
			StringTokenizer[] st = new StringTokenizer[tc];
			
			System.out.println("각 테스트케이스 입력");
			for(int i = 0; i < tc; i++) {
				st[i] = new StringTokenizer(br.readLine());
			}
			
			for(int i = 0; i < st.length; i++) {
				int r = Integer.parseInt(st[i].nextToken());
				String str = st[i].nextToken();
				for(int j = 0; j < str.length(); j++) {
					for(int k = 0; k < r; k++) {
						System.out.print(str.charAt(j));
					}
				}
				System.out.println();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no2908() {
		// 상수
		System.out.println("숫자 입력");
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());;
			int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());;
			
			if(a > b) {
				System.out.println(a);
			} else if(a < b) {
				System.out.println(b);
			} else {
				System.out.println("두 수는 같습니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no5622() {
		// 다이얼 
		System.out.print("문자열 입력 : ");
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			String str = br.readLine();
			int time = 0;
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(ch == 'Z') {
					ch = 'X';
				} else if(ch >= 'S') {
					ch--;
				}
				time += (ch - 'A') / 3 + 1 + 2;
			}
			System.out.println("최소 시간 : " + time);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no2941() {
		// 크로아티아 알파벳
		System.out.print("문자열 입력 : ");
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			String str = br.readLine();
			
			int len = str.length();
			int count = 0;
			for(int i = 0; i < len; i++) {
				char ch = str.charAt(i);
				if(ch == 'c' && i < len - 1) {
					if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
						i++;
					}
				}
				
				if(ch == 'd' && i < len - 1) {
					if(str.charAt(i + 1) == '-') {
						i++;
					} else if(str.charAt(i + 1) == 'z' && i < len - 2) {
						if(str.charAt(i + 2) == '=') {
							i += 2;
						}
					}
				}
				
				if(ch == 'l' && i < len - 1) {
					if(str.charAt(i + 1) == 'j') {
						i++;
					}
				}
				
				if(ch == 'n' && i < len - 1) {
					if(str.charAt(i + 1) == 'j') {
						i++;
					}
				}
				
				if(ch == 's' && i < len - 1) {
					if(str.charAt(i + 1) == '=') {
						i++;
					}
				}
				
				if(ch == 'z' && i < len - 1) {
					if(str.charAt(i + 1) == '=') {
						i++;
					}
				}
				count++;
			}
			
			System.out.println("알파벳 개수 : " + count);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void no1316() {
		// 그룹 단어 체커
		// 함수 생성 후 풀이
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("개수 입력 : ");
			int num = Integer.parseInt(br.readLine());
			int count = num;

			System.out.println("문자 입력");
			
			for(int i = 0; i < num; i++) {
	
				
			}
			System.out.println("그룹 단어 개수 : " + count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
