package com.ssafy.products;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductMgr implements IProductMgr, Serializable {
	private static ProductMgr mgr = new ProductMgr();
	private static ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Product> objDataSets;

	public ProductMgr ProductMgr() {
		// TODO Auto-generated constructor stub
		return mgr;
	}

	@Override
	public Boolean input(Product obj) {
		// TODO Auto-generated method stub
		products.add(obj);
		// +add : 예외처리
		return true;
	}

	@Override
	public String search(OPTION opt) {
		String result = "";
		// TODO Auto-generated method stub
		switch (opt) {
		case ALL:
			result = this.toString(searchAll());
			break;
		case SUM:
			result = viewAllSum();
			break;
		default:
			result = "에러";
			break;
		}
		return result;
	}

	@Override
	public String search(OPTION opt, String data) {
		String result = "";
		switch (opt) {
		case NO:
			result = this.toString(searchNo(data));
			break;
		case NAME:
			result = this.toString(searchName(data));
			break;

		default:
			search(opt);
			break;
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public String search(OPTION opt, TYPE type) {
		// TODO Auto-generated method stub
		String result = "";
		switch (opt) {
		case TYPE:
			switch (type) {
			case TV:
				result = this.toString(searchTV());
				break;
			case REFRIGERATOR:
				result = this.toString(searchRefrigerator());
				break;

			case SMARTPHONE:
				result = this.toString(searchSmartPhone());
				break;

			default:
				result = "잘못된 입력값";
				break;
			}
			break;
		case AVG:
			switch (type) {
			case TV_INCH:
				result = viewInchAvg(searchTV());
				break;
			default:
				System.out.println("잘못된 입력값");
			}
			break;
		case SUM:
			switch (type) {
			case TV:
				result = viewAllSum(searchTV());
				break;
			case REFRIGERATOR:
				result = viewAllSum(searchRefrigerator());
				break;

			case SMARTPHONE:
				result = viewAllSum(searchSmartPhone());
				break;

			case SMARTPHONE_STOCK:
				result = addStock(searchSmartPhone());
				break;

			case REFRIGERATOR_COLUMN:
				result = viewColumnSum(searchRefrigerator());
				break;
			default:
				result = "잘못된 입력값";
				break;
			}
			break;
		case LIST:
			switch (type) {
			case TV:
				result = viewList(searchTV());
				break;

			case TV_STOCK:
				result = viewStock(searchTV());
				break;

			case REFRIGERATOR:
				result = viewList(searchRefrigerator());
				break;

			case REFRIGERATOR_STOCK:
				result = viewStock(searchRefrigerator());
				break;

			case SMARTPHONE:
				result = viewList(searchSmartPhone());
				break;

			case SMARTPHONE_STOCK:
				result = viewStock(searchSmartPhone());
				break;
				
			case REFRIGERATOR_COLUMN:
				result = viewColumnSum(searchRefrigerator());
				break;
			default:
				result = "잘못된 입력값";
				break;
			}
			break;
		default:
			result = "잘못된 입력값";
			break;
		}
		return result;
	}

	private String addStock(ArrayList<Product> datasets) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Long result = 0L;
		for (int i = 0; i < datasets.size(); i++) {
			result += (long) products.get(i).getQuantity();
		}
		sb.append(result);
		return sb.toString();
	}

	private String viewInchAvg(ArrayList<Product> datasets) {
		// TODO Auto-generated method stub
		Double result = 0.0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < datasets.size(); i++) {
			result += Double.valueOf(((TV) datasets.get(i)).getInch());
		}
		result /= (double)datasets.size();
		sb.append(String.format("%f", result));
		return sb.toString();
	}

	private String viewStock(ArrayList<Product> datasets) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Long result = 0L;
		String name = "";
		for (int i = 0; i < datasets.size(); i++) {
			name = products.get(i).getName();
			result = (long) products.get(i).getQuantity();
			sb.append(String.format("- 제품명 : %-10s | 재고량 : %,d \n", name, result));
		}
		return sb.toString();
	}

	private String viewList(ArrayList<Product> datasets) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Long result = 0L;
		String name = "";
		for (int i = 0; i < datasets.size(); i++) {
			name = products.get(i).getName();
			result = Long.valueOf(products.get(i).getPrice()) * Long.valueOf(products.get(i).getQuantity());
			sb.append(String.format("- 제품명 : %-10s | 금액 : %,d \n", name, result));
		}
		return sb.toString();
	}

	private String viewColumnSum(ArrayList<Product> datasets) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < datasets.size(); i++) {
			result += Long.valueOf(((Refrigerator) datasets.get(i)).getColume());
		}
		sb.append(String.format("%,d", result));
		return sb.toString();
	}

	@Override
	public String search(OPTION opt, TYPE type, String data) {
		// TODO Auto-generated method stub
		String result = "";
		switch (opt) {
		case TYPE:
			switch (type) {
			case TV:
				result = this.toString(searchTV(data));
				break;
			case REFRIGERATOR:
				result = this.toString(searchRefrigerator(data));
				break;

			default:
				result = "잘못된 입력값";
				break;
			}
			break;

		default:
			result = "잘못된 입력값";
			break;
		}
		return result;
	}

	private String viewAllSum() {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < products.size(); i++) {
			result += Long.valueOf(products.get(i).getPrice()) * Long.valueOf(products.get(i).getQuantity());
		}
		sb.append(String.format("%,d", result));
		return sb.toString();
	}

	private String viewAllSum(ArrayList<Product> datasets) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < datasets.size(); i++) {
			result += Long.valueOf(datasets.get(i).getPrice()) * Long.valueOf(datasets.get(i).getQuantity());
		}
		sb.append(String.format("%,d", result));
		return sb.toString();
	}

	private ArrayList<Product> searchAll() {
		// TODO Auto-generated method stub

		objDataSets = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			objDataSets.add(products.get(i));
		}
		return objDataSets;
	}

	private ArrayList<Product> searchName(String data) {
		objDataSets = new ArrayList<>();

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().contains(data)) {
				objDataSets.add(products.get(i));
			}
		}
		return objDataSets;
	}

	private ArrayList<Product> searchNo(String data) {
		objDataSets = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getNo() == Integer.valueOf(data)) {
				objDataSets.add(products.get(i));
			}
		}
		return objDataSets;
	}

	private ArrayList<Product> searchRefrigerator() {
		// TODO Auto-generated method stub
		objDataSets = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator) {
				objDataSets.add(products.get(i));
			}
		}
		return objDataSets;
	}

	private ArrayList<Product> searchSmartPhone() {
		// TODO Auto-generated method stub
		objDataSets = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof SmartPhone) {
				objDataSets.add(products.get(i));
			}
		}
		return objDataSets;
	}

	private ArrayList<Product> searchTV() {
		// TODO Auto-generated method stub
		objDataSets = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof TV) {
				objDataSets.add(products.get(i));
			}
		}
		return objDataSets;
	}

	private ArrayList<Product> searchRefrigerator(String data) {
		// TODO Auto-generated method stub
		objDataSets = new ArrayList<>();
		Product obj;
		for (int i = 0; i < products.size(); i++) {
			obj = products.get(i);
			if (obj instanceof Refrigerator) {
				obj = (Refrigerator) obj;
				if (((Refrigerator) obj).getColume() >= Integer.valueOf(data)) {
					objDataSets.add(obj);
				}
			}
		}
		return objDataSets;
	}

	private ArrayList<Product> searchTV(String data) {
		// TODO Auto-generated method stub
		objDataSets = new ArrayList<>();
		Product obj;
		for (int i = 0; i < products.size(); i++) {
			obj = products.get(i);
			if (obj instanceof TV) {
				obj = (TV) obj;
				if (((TV) obj).getInch() >= Integer.valueOf(data)) {
					objDataSets.add(obj);
				}
			}
		}
		return objDataSets;
	}

	@Override
	public Boolean edit(String no, String price) {
		// TODO Auto-generated method stub
		Product obj;
		Boolean flag = false;
		for (int i = 0; i < products.size(); i++) {
			obj = products.get(i);
			if (obj.getNo() == Integer.valueOf(no)) {
				obj.setPrice(Integer.valueOf(price));
				flag = true;
				// +add : 예외처리
				break;
			}
		}
		return flag;
	}

	@Override
	public Boolean delete(String no) {
		// TODO Auto-generated method stub
		Product obj;
		Boolean flag = false;
		for (int i = 0; i < products.size(); i++) {
			obj = products.get(i);
			if (obj.getNo() == Integer.valueOf(no)) {
				products.remove(i);
				flag = true;
				// +add : 예외처리
				break;
			}
		}
		return flag;
	}

	private String toString(ArrayList<Product> sets) {
		StringBuilder sb = new StringBuilder();
		for (Product data : sets) {
			sb.append(data.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	private String toString(ArrayList<Product> sets, OPTION opt) {
		Long result = 0L;
		switch (opt) {
		case ALL:
			break;
		case AVG:
			for (Product data : sets) {
				result += Long.valueOf(data.getPrice());
			}
			result /= Long.valueOf(sets.size());
			break;
		case SUM:
			for (Product data : sets) {
				result += Long.valueOf(data.getPrice());
			}
			break;
		default:
			break;
		}

		return result + "";
	}

	public String detailSearch(String str, int value) {
		// TODO Auto-generated method stub
		objDataSets = searchName(str);
		
		return toString(objDataSets);
	}

}
