package bo;

import java.util.Date;

public class EntityDetails implements Comparable<EntityDetails>{

	private String entityName;
	private char buyOrSell;
	private double agreedFix;
	private String currency;
	private Date istructionDate;
	private Date settlementDate;
	private int units;
	private double pricePerUnit;
	private double tradeAmount;
	
	public EntityDetails(String entityName, char buyOrSell, double agreedFix, String currency, int units, double pricePerUnit, Date instructionDate)
	{
		this.entityName=entityName;
		this.buyOrSell=buyOrSell;
		this.agreedFix = agreedFix;
		this.currency = currency;
		this.units=units;
		this.pricePerUnit = pricePerUnit;
		this.istructionDate = instructionDate;
	}
	
	public  EntityDetails()
	{
		
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public char getBuyOrSell() {
		return buyOrSell;
	}

	public void setBuyOrSell(char buyOrSell) {
		this.buyOrSell = buyOrSell;
	}

	public double getAgreedFix() {
		return agreedFix;
	}

	public void setAgreedFix(double agreedFix) {
		this.agreedFix = agreedFix;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getIstructionDate() {
		return istructionDate;
	}

	public void setIstructionDate(Date istructionDate) {
		this.istructionDate = istructionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	
	public double getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(double tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	@Override
	public String toString()
	{
		return entityName+" "+buyOrSell+" ";
	}

	@Override
	public int compareTo(EntityDetails obj) {
		if(obj.getTradeAmount()>this.getTradeAmount())
		{
			return 1;
		}
		else
		{
			return -1;
		}
		//return (int)obj.getTradeAmount() - (int)this.getTradeAmount();
	}
	
	
	
	
}
