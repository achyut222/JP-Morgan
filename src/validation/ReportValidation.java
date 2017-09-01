package validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import bo.EntityDetails;
import constants.ReportConstants;

public class ReportValidation {
	
	
	public static EntityDetails validateAndSetEntity(EntityDetails entityTran)
	{
		entityTran = setSettlementDate(entityTran);
		entityTran = setTradeAmount(entityTran);
		return entityTran;
	}
	
	private static EntityDetails setTradeAmount(EntityDetails entityTran)
	{
		entityTran.setTradeAmount(entityTran.getUnits()*entityTran.getPricePerUnit()*entityTran.getAgreedFix());
		return entityTran;
	}
	
	private static EntityDetails setSettlementDate(EntityDetails entityTran)
	{
		if(entityTran.getIstructionDate()==null)
		{
			entityTran.setIstructionDate(new Date());
		}
		
			
		Calendar cal = Calendar.getInstance();
        cal.setTime(entityTran.getIstructionDate());
     	
		if(ReportConstants.CURRENCY_AED.equals(entityTran.getCurrency().trim())||ReportConstants.CURRENCY_SAR.equals(entityTran.getCurrency().trim()))
		{
				if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY)
		        {
		        	cal.add(Calendar.DATE, 2);
		        }
				else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
				{
					cal.add(Calendar.DATE, 1);
				}
		}
		else
		{
			if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
	        {
	        	cal.add(Calendar.DATE, 2);
	        }
			else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
			{
				cal.add(Calendar.DATE, 1);
			}
		}
		
		entityTran.setSettlementDate(cal.getTime());
		return entityTran;
	}	

	public static void validateReport(EntityDetails details)
	{
		
	}

}
