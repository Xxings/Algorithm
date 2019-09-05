package com.ssafy;

public class Car {
	String num;
	protected String getNum() {
		return num;
	}
	protected void setNum(String num) {
		this.num = num;
	}
	protected String getModel() {
		return model;
	}
	protected void setModel(String model) {
		this.model = model;
	}
	protected int getPrice() {
		return price;
	}
	protected void setPrice(int price) {
		this.price = price;
	}
	String model;
	int price;
	
	Car(){
		
	}
	/**
	 * 차량 추가
	 * @param num
	 * @param model
	 * @param price
	 */
	public Car(String num, String model, int price) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("차량번호 : "+getNum());
		sb.append("\t 차량모델명 : "+getModel());
		sb.append("\t 가격 :"+getPrice());
		return sb.toString();
	}
}
