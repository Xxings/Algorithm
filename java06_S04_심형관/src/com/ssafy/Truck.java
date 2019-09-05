package com.ssafy;

public class Truck extends Car{
	private int ton;
	
	public Truck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Truck(String num, String model, int price, int ton) {
		super(num, model, price);
		// TODO Auto-generated constructor stub
		this.setTon(ton);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()
				+"\t 톤 수 :"+this.getTon();
	}

	private int getTon() {
		return ton;
	}

	private void setTon(int ton) {
		this.ton = ton;
	}
	
}
