package com.ssafy.products;

public class SmartPhone extends Product {
	private String vender;
	private String model;	// 모델명

	public SmartPhone(int no, String name, int price, int quantity) {
		// TODO Auto-generated constructor stub
		super(no,name, price, quantity);
	}
	public SmartPhone(int no, String name, int price, int quantity, String vender, String model) {
		this(no, name, price, quantity);
		this.vender = vender;
		this.model = model;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		result += String.format(" 벤더명 : %5s", this.vender);
		result += String.format(" | 모델명 : %5s", this.model);
		return result;
	}
	
	
}
