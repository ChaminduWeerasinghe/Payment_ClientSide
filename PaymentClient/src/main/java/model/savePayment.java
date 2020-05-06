package model;

public class savePayment 
{
	private String userName;
	private String pass;
	private int ptid;
	private String ptype;
	private double price;
	private String dte;
	
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getpass() {
		return pass;
	}
	public void setpass(String password) {
		this.pass = password;
	}
	public int getPtid() {
		return ptid;
	}
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDte() {
		return dte;
	}
	public void setDte(String dte) {
		this.dte = dte;
	}
	

}
