package com.ssafy;

public class Bus extends Car{
	private int seat;	//좌석수

	public Bus(String num, String model, int price, int seat) {
		super(num,model,price);
		this.setSeat(seat);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()
				+"\t 좌석 수 : "+this.getSeat();
	}

	private int getSeat() {
		return seat;
	}

	private void setSeat(int seat) {
		this.seat = seat;
	}
	
	
}
