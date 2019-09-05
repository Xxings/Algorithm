package com.ssafy.products;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr mgr = new ProductMgr();
		
		int cnt = 1;
		System.out.println("\n===1. 상품정보 입력 기능===");
		mgr.input(new TV(cnt++, "삼성", 3_300_000, 5, 67, "A"));
		mgr.input(new Refrigerator(cnt++, "사성", 30_000, 2, 10));
		mgr.input(new TV(cnt++, "엘지", 2_150_000, 1, 77, "A"));
		mgr.input(new Refrigerator(cnt++, "삼성일까", 770_000, 2, 350));
		mgr.input(new TV(cnt++, "오성", 300_000, 2, 67, "A"));
		mgr.input(new Refrigerator(cnt++, "엘지", 2_570_000, 3, 400));
		mgr.input(new TV(cnt++, "엘지", 1_300_000, 2, 37, "A"));
		mgr.input(new Refrigerator(cnt++, "엘지", 1_570_000, 4, 700));
		mgr.input(new TV(cnt++, "육성", 7_300_000, 1, 57, "A"));
		mgr.input(new Refrigerator(cnt++, "삼성아님", 370_000, 1, 70));
		mgr.input(new SmartPhone(cnt++, "삼성아님", 370_000, 1, "벤더1", "삼성"));
		
		System.out.println("\n===2. 상품정보 전체검색 기능===");
		System.out.println(mgr.search(OPTION.ALL));
//		System.out.println(mgr.search(OPTION.ALL," "));

		System.out.println("\n===3. no 검색 기능===");
		System.out.println(mgr.search(OPTION.NO,"1"));

		System.out.println("\n===4. NAME 검색 기능===");
		System.out.println(mgr.search(OPTION.NAME,"삼"));
		
		System.out.println("\n===5. TV만 검색 기능===");
		System.out.println(mgr.search(OPTION.TYPE,TYPE.TV));
		
		System.out.println("\n===6. Refrigerator만 검색 기능===");
		System.out.println(mgr.search(OPTION.TYPE,TYPE.REFRIGERATOR));
		
		System.out.println("\n===7. 냉장고 상세 검색 기능===");
		System.out.println(mgr.search(OPTION.TYPE,TYPE.REFRIGERATOR, "400"));
		
		System.out.println("\n===8. TV 상세 검색 기능===");
		System.out.println(mgr.search(OPTION.TYPE,TYPE.TV, "50"));
		
		System.out.println("\n===9. 상품번호 | 가격 변경===");
		System.out.println(mgr.edit("1", "10000"));
		System.out.println(mgr.search(OPTION.NO,"1"));

		System.out.println("\n===10. 상품번호 | 삭제===");
		System.out.println(mgr.delete("1"));
		System.out.println(mgr.search(OPTION.NO,"1"));
		
		System.out.println("\n===11. 전체 재고 상품 금액의 합계===");
		System.out.println(mgr.search(OPTION.SUM));
		System.out.println();
		
		System.out.println("############## 숙제 6 ##############");
		System.out.println("\n===1. 파라메터로 전달받아 각 재고금액 리턴===");
		System.out.println(">TV");
		System.out.println(mgr.search(OPTION.LIST, TYPE.TV));
		System.out.println(">냉장고");
		System.out.println(mgr.search(OPTION.LIST, TYPE.REFRIGERATOR));
		System.out.println(">휴대폰");
		System.out.println(mgr.search(OPTION.LIST, TYPE.SMARTPHONE));
		System.out.println();

		System.out.println("\n===2. 파라메터로 전달받아 각 재고량 리턴===");
		System.out.println(">TV");
		System.out.println(mgr.search(OPTION.LIST, TYPE.TV_STOCK));
		System.out.println(">냉장고");
		System.out.println(mgr.search(OPTION.LIST, TYPE.REFRIGERATOR_STOCK));
		System.out.println(">휴대폰");
		System.out.println(mgr.search(OPTION.LIST, TYPE.SMARTPHONE_STOCK));
		System.out.println();

		System.out.println("\n===3. TV 재고의 평균 인치를 리턴===");
		System.out.println(">TV");
		System.out.println(mgr.search(OPTION.AVG, TYPE.TV_INCH));
		
		System.out.println("\n===4. 냉장고의 리터 합계를 리턴===");
		System.out.println(mgr.search(OPTION.SUM, TYPE.REFRIGERATOR_COLUMN));
		
		System.out.println("\n===5. 스마트폰의 재고 수량의 합을 리턴===");
		System.out.println(mgr.search(OPTION.SUM, TYPE.SMARTPHONE_STOCK));

		System.out.println("\n===6. 상품명 / 금액 검색 ");
		System.out.println(mgr.detailSearch("삼",5000));

		
	} //end of main
}
