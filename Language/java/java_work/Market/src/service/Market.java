package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Customer;
import dto.Person;
import dto.Product;
import dto.Seller;

public class Market implements Serializable{

	private Seller master;
	private String marketName;

	private boolean masterLoginState = false;

	private long income = 0;
	private long outcome = 0;

	private Map<Integer,Product> productList = new HashMap<>();
	private List<Customer> connectingUser = new ArrayList<>();

	public Market(Seller master, String marketName) {
		this.master = master;
		this.marketName = marketName;
	}

	public Seller getMaster() {
		return master;
	}

	public void setMaster(Seller master) {
		this.master = master;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public boolean isMasterLoginState() {
		return masterLoginState;
	}

	public void setMasterLoginState(boolean loginState) {
		this.masterLoginState = loginState;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public long getOutcome() {
		return outcome;
	}

	public void setOutcome(long outcome) {
		this.outcome = outcome;
	}

	public Map<Integer,Product> getProductList() {
		return productList;
	}

	public void setProductList(Map<Integer,Product> productList) {
		this.productList = productList;
	}

	public List<Customer> getConnectingUser() {
		return connectingUser;
	}

	public void setConnectingUser(List<Customer> connectingUser) {
		this.connectingUser = connectingUser;
	}

	
	
	

}
