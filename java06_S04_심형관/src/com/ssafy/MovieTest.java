package com.ssafy;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		MovieMgr mgr = new MovieMgr();
		Scanner sc = new Scanner(System.in);
		Movie[] dataset;
		
		int input = 0;
		boolean flagExit = false;
		while (!flagExit) {
			System.out.println("<<< 영화 관리 프로그램 >>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			
			do {
				System.out.printf("원하는 번호를 선택하세요. ");
				String comm = sc.next();
				try {
					input = Integer.valueOf(comm);
					break;
				}
				catch (Exception e) {
					System.out.printf("잘못된 입력입니다. | ");
				}
			}while(true);
			
			String input_data;
			
			System.out.println();
			switch (input) {
			case 1:
				System.out.println(">># 샘플 값을 입력합니다.<<");
				mgr.add(new Movie("Title_ABC","Directior_ABC",5,"comedy","summary111111111"));
				mgr.add(new Movie("Title_ACD","Directior_ABC",10,"action","summary222222222"));
				mgr.add(new Movie("Title_BER","Directior_CA",3,"comedy","summary33333333"));
				mgr.add(new Movie("Title_AOF","Directior_EE",10,"horror","summary4444444"));
				mgr.add(new Movie("Title5_GLO","Directior_GG",20,"impression","summary55555"));
				System.out.println("------------------------------------------------");
				System.out.printf("현재 상영 중인 영화 개수 : %d \n",mgr.getSize());
				System.out.println("------------------------------------------------");
				break;
			case 2:
				System.out.println("------------------------------------------------");
				System.out.printf("현재 상영 중인 영화 개수 : %d \n",mgr.getSize());
				System.out.println("------------------------------------------------");
				print(mgr.search());
				break;
			case 3:
				System.out.printf("검색할 타이틀 검색 :");
				input_data = sc.next();
				System.out.println("------------------------------------------------");
				print(mgr.search(input_data));
				System.out.println("------------------------------------------------");
				break;
			case 4:
				System.out.printf("검색할 장르 검색 :");
				input_data = sc.next();
				System.out.println("------------------------------------------------");
				print(mgr.searchGenre(input_data));
				System.out.println("------------------------------------------------");
				break;
			case 5:
				System.out.printf("삭제할 타이틀(전체네임입력) :");
				input_data = sc.next();
				mgr.delete(input_data);
				System.out.println("------------------------------------------------");
				System.out.printf("현재 상영 중인 영화 개수 : %d \n",mgr.getSize());
				System.out.println("------------------------------------------------");
				break;
			case 0:
				flagExit = true;
				break;
			default:
				System.out.println("------------------------------------------------");
				System.out.println("잘못된 입력값");
				System.out.println("------------------------------------------------");
			}	// end of Switch
		}	// end of while
	}	// end of main

	private static void print(Movie[] search) {
		// TODO Auto-generated method stub
		for(Movie data : search) {
			if(data == null) { continue; }
			System.out.println(data.toString());
		}
		System.out.println();
	}
}
