package model;




public class Payment 
{
	
	private int ptid;
	private String ptype;
	private double price;
	private String dte;
	
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
