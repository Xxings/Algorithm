package com.ssafy;

import java.util.Arrays;

public class CarTest {

	public static void main(String[] args) {
		CarMgr mgr;
		mgr = new CarMgr();
		Car[] dataSet;

		int cnt = 1;
		System.out.println("### 1. 파라메터로 전달된 차량 정보 배열 저장 ###");
		mgr.add(new Car(String.valueOf(cnt++), "솔리드Pro", 5_000_000));
		mgr.add(new Bus(String.valueOf(cnt++), "버스 1111", 7_000_000,30));
		mgr.add(new Car(String.valueOf(cnt++), "골든 코튼", 7_000_000));
		mgr.add(new Truck(String.valueOf(cnt++), "트럭 1111", 3_020_000,5));
		mgr.add(new Car(String.valueOf(cnt++), "스팅 레이", 3_000_000));
		mgr.add(new Truck(String.valueOf(cnt++), "트럭2222", 5_500_000,8));
		mgr.add(new Bus(String.valueOf(cnt++), "버스 2222", 7_000_000,50));

		System.out.println();
		System.out.println("### 2. 모든 Car 정보를 검색하기 위한 search) ###");
//		System.out.println(mgr.search());
		dataSet = mgr.search();
		for (Car data : dataSet) {
			if (data == null) {	continue; }
			System.out.println(data.toString());
		}

		System.out.println();
		System.out.println("### 3. 차량 번호로 검색할 수 있는 search ###");
		System.out.println(mgr.search("3").toString());
		
		System.out.println();
		System.out.println("### 4. 지정된 가격보다 작은 차량 정보 검색기능 search ###");
		dataSet = mgr.search(6_000_000);
		for (Car data : dataSet) {
			if (data == null) {	continue; }
			System.out.println(data.toString());
		}
		
		System.out.println();
		System.out.println("### 5. 차량 검색 후 가격 수정 ###");
		mgr.update("3", 1);
		
		
		System.out.println();
		System.out.println("### 6. 차량 삭제를 위한 delete(num) ###");
		mgr.delete("2");
		dataSet = mgr.search();
		for (Car data : dataSet) {
			if (data == null) {	continue; }
			System.out.println(data.toString());
		}
		
		System.out.println();
		System.out.println("### 7. 저장된 차량 수량을 구하는 size() ###");
		System.out.println("현재 저장 대수 :" + mgr.size());
		
		System.out.println();
		System.out.println("### 8. 저장된 차량 금액의 합 구하기 ###");
		System.out.println("금액 합 :" + mgr.totalPrice());
		
		
		
		
		
		
	} // end of main
} // end of class
