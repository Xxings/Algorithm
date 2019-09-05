package com.ssafy.products;

class Product {
	private int no;				//제품번호
	private String name;		//제품명
	private int price;			//가격정보
	private int quantity;		//재고수량
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	protected Product(int no, String name, int price, int quantity) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format(" 제품번호 : %2s |", no));
		sb.append(String.format(" 제 품 명 : %5s |", name));
		sb.append(String.format(" 가격정보 : %,10d |", price));
		sb.append(String.format(" 재고수량 : %5s |", quantity));
		
		return sb.toString();
	}
}
