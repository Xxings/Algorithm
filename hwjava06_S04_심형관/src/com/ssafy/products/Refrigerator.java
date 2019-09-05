package com.ssafy.products;

public class Refrigerator extends Product{
	private int colume; 	// 용량
	
	
	
	public Refrigerator(int no, String name, int price, int quantity, int colume) {
		super(no, name, price, quantity);
		this.setColume(colume);
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		result += 
				"용    량\t : "+this.getColume()+"\n";
		return result;
	}

	public int getColume() {
		return colume;
	}

	public void setColume(int colume) {
		this.colume = colume;
	}
	
	
}
