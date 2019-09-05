package com.ssafy.products;

public interface IProductMgr {
	Boolean input(Product obj);
	
	String search(OPTION opt);
	String search(OPTION opt,String data);
	String search(OPTION opt, TYPE type);
	String search(OPTION opt,TYPE type, String data);
	
	Boolean edit(String no, String price);
	Boolean delete(String data);
	
}
