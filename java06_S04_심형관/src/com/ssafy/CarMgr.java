package com.ssafy;

public class CarMgr {
	private static CarMgr mgr = new CarMgr();
	private Car[] cars = new Car[100];
	private int index;

	public CarMgr CarMgr() {
		// TODO Auto-generated constructor stub
		this.index = 0;
		return mgr;
	}

	/**
	 * 차량정보를 저장하는 배열
	 * 
	 * @param c
	 */
	public void add(Car c) {
		cars[index] = c;
		index++;
	}

	/**
	 * 현재 저장된 모든 차량 정보 리턴
	 * 
	 * @return
	 */
	public Car[] search() {
		
		return cars;
	}

	/**
	 * 파라메터로 전달된 번호와 같은 차량 정보를 리턴
	 * 
	 * @param num
	 * @return
	 */
	public Car search(String num) {
		Car result = new Car();
		
		for(Car data : cars) {
			if(data.getNum().equals(num)) {
				result = data;
				break;
			}
		}
		
		return result;
	}

	Car[] search(int price) {
		Car[] result = new Car[100];
		int idx = 0;
		for(Car data : cars) {
			if(data == null) { continue; }
			else if(data.getPrice()<price) { result[idx++] = data;}
		}
		return result;
	}

	void update(String num, int price) {
		for (int i = 0; i < this.index; i++) {
			Car data = cars[i];
			if(data == null) { continue; }
			else if(data.getNum().equals(num))
			{ 
				data.setPrice(price);
			}
		}
	}

	void delete(String num) {
		for (int i = 0; i < this.index; i++) {
			Car data = cars[i];
			if(data == null) { continue; }
			else if(data.getNum().equals(num))
			{ 
				data = null;
			}
		}
	}

	int size() {
		int result=0;

		for(Car data : cars) {
			if(data == null) {  }
			else { result++; }
		}
		return result;
	}

	int totalPrice() {
		int result=0;

		for(Car data : cars) {
			if(data == null) {  }
			else { result+=data.getPrice(); }
		}
		return result;
	}
}
