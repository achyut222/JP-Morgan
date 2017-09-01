package report;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bo.EntityDetails;
import business.ReportProcess;
import constants.ReportConstants;
import validation.ReportValidation;

public class ReportTransaction {
	

	public static Date covertStingToDate(String strDate)
	{
		Date date = null;
		try {
			date = ReportConstants.INPUT_DATE_FORMAT.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generat ed method stub
		
		List<EntityDetails> entityList = new ArrayList<EntityDetails>();
		
		/**
		 * The Entity Details object contains in below format
		 * 1st parameter- entity name, 2nd parameter -Buy or Sell (B or S),
		 * 3rd parameter - Agreed Fix(double value), 4th parameter - Currency(String)
		 * 5th Parameter - Units(int), 6th parameter - Price per unit(int)
		 * 7th parameter - Instruction Date(String in "DD/MM/YYYY" format) 
		 */
		
		EntityDetails fooEntity = new EntityDetails("foo", 'B', 0.05, "AED", 200,100, covertStingToDate("01/09/2017"));
		ReportValidation.validateReport(fooEntity);
		ReportValidation.validateAndSetEntity(fooEntity);
		
		EntityDetails barEntity = new EntityDetails("bar", 'B', 0.05, "USD", 300, 105.05, covertStingToDate("02/09/2017"));
		ReportValidation.validateReport(barEntity);
		ReportValidation.validateAndSetEntity(barEntity);
		
		EntityDetails inEntity = new EntityDetails("IN", 'S', 0.05, "USD", 250, 104.05, covertStingToDate("01/09/2017"));
		ReportValidation.validateReport(inEntity);
		ReportValidation.validateAndSetEntity(inEntity);
		
		EntityDetails ukEntity = new EntityDetails("UK", 'S', 0.05, "USD", 400, 105.05, covertStingToDate("03/09/2017"));
		ReportValidation.validateReport(ukEntity);
		ReportValidation.validateAndSetEntity(ukEntity);
		
		EntityDetails euEntity = new EntityDetails("EU", 'S', 0.05, "USD", 600, 105.05, covertStingToDate("04/09/2017"));
		ReportValidation.validateReport(euEntity);
		ReportValidation.validateAndSetEntity(euEntity);
		
		entityList.add(fooEntity);
		entityList.add(barEntity);
		entityList.add(inEntity);
		entityList.add(ukEntity);
		entityList.add(euEntity);
		ReportProcess.incomingSettled(entityList);
		
		

	}

}
