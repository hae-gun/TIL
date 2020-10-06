package transaction;

import java.util.Date;

public class Transaction {
	int acno;
	String pname;
	String company;
	int money;
	Date tday;
	
	public Transaction(int acno, String pname, String company, int money) {
		this.acno = acno;
		this.pname = pname;
		this.company = company;
		this.money = money;
	}

	public Transaction(int acno, String pname, String company, int money, Date tday) {
		this.acno = acno;
		this.pname = pname;
		this.company = company;
		this.money = money;
		this.tday = tday;
	}

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Date getTday() {
		return tday;
	}

	public void setTday(Date tday) {
		this.tday = tday;
	}

	@Override
	public String toString() {
		return "Transaction [acno=" + acno + ", pname=" + pname + ", company=" + company + ", money=" + money
				+ ", tday=" + tday + "]";
	}
	
	
	
}
