package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bo.EntityDetails;
import constants.ReportConstants;
import interfaces.Settled;

public class ReportProcess {
	
	public static void incomingSettled(List<EntityDetails> entityDetailsList)
	{
		Collections.sort(entityDetailsList);
		List<EntityDetails> usdIncommingSet = new ArrayList<EntityDetails>();
		List<EntityDetails> usdOutgingSet = new ArrayList<EntityDetails>();
		
		Settled incoming = (entityList) ->{
			for(EntityDetails entityDetails : entityList)
			{
				if(ReportConstants.BUY == entityDetails.getBuyOrSell() && ReportConstants.CURRENCY_USD.equals(entityDetails.getCurrency()))
				{
					usdIncommingSet.add(entityDetails);
				}
				else if(ReportConstants.SELL == entityDetails.getBuyOrSell() && ReportConstants.CURRENCY_USD.equals(entityDetails.getCurrency()))
				{
					usdOutgingSet.add(entityDetails);
				}
			}
		};
		incoming.settle(entityDetailsList);
		displayIncomingUSDReports(usdIncommingSet);
		displayOutgoingUSDReports(usdOutgingSet);
		displayReports(entityDetailsList);
	}
	
	public static void displayIncomingUSDReports(List<EntityDetails> incomingUSDList)
	{
		System.out.println("-----------Incoming USD Trading---------");
		System.out.println("Entity"+ "||"+"Buy/Sell"+"||"+"Agreed Fix"+"||"+"Currency"+"||"+"Instructon Date"+"||"+"Settlement Date"+"||"+"Units"+"||"+"Price per Amount"+ "||"+"Trade Amount");
		for(EntityDetails details:incomingUSDList)
		{
			System.out.println(formatMessage(details));
		}
	}
	
	public static void displayOutgoingUSDReports(List<EntityDetails> outgoingUSDList)
	{
		System.out.println("-----------Outgoing USD Trading---------");
		System.out.println("Entity"+ "||"+"Buy/Sell"+"||"+"Agreed Fix"+"||"+"Currency"+"||"+"Instructon Date"+"||"+"Settlement Date"+"||"+"Units"+"||"+"Price per Amount"+ "||"+"Trade Amount");
		for(EntityDetails details:outgoingUSDList)
		{
			System.out.println(formatMessage(details));
		}
	}
	
	public static void displayReports(List<EntityDetails> fullList)
	{
		System.out.println("-----------Full Trade reports---------");
		System.out.println("Entity"+ "||"+"Buy/Sell"+"||"+"Agreed Fix"+"||"+"Currency"+"||"+"Instructon Date"+"||"+"Settlement Date"+"||"+"Units"+"||"+"Price per Amount"+ "||"+"Trade Amount");
		for(EntityDetails details:fullList)
		{
			System.out.println(formatMessage(details));

		}
	}
	
	private static StringBuilder formatMessage(EntityDetails details)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(details.getEntityName()+"   ||  "+details.getBuyOrSell()+"     ||  "+details.getAgreedFix()+"    || ");
		sb.append(details.getCurrency()+"    || "+ReportConstants.DATE_FORMAT.format(details.getIstructionDate())+"   ||"+ReportConstants.DATE_FORMAT.format(details.getSettlementDate())+"    || ");
		sb.append(details.getUnits()+" || "+details.getPricePerUnit()+"         || "+details.getTradeAmount());
		return sb;
	}

}
