package com.ssafy.products;

public class TV extends Product{
	
	private int inch;		//인치
	private String display;		//디스플레이 타입
	
	
	public TV(int no, String name, int price, int quantity, int inch, String display) {
		super(no, name, price, quantity);
		this.setInch(inch);
		this.setDisplay(display);
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		result += 
				"인     치\t : "+this.getInch()+"\n"
				+"타     입\t : "+this.getDisplay()+"\n";
		return result;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
}
