package businesscomponents;

import com.cognizant.craft.ReusableLibrary;
import com.cognizant.craft.ScriptHelper;

import pages.EposAdftPage;

public class EposAdftComponent extends ReusableLibrary
{
	public EposAdftComponent(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}

	//Declarations
	EposAdftPage eposObj = new EposAdftPage(scriptHelper);

	public void invokeApplicationEpos() 
	{
		eposObj.invokeApplicationEpos();
	}
	
	public void selectDeviceEpos() 
	{
		eposObj.selectDeviceEpos();
	}
	
	public void selectColorCapacityEpos() 
	{
		eposObj.selectColorCapacityEpos();
	}
	
	public void paymentPlanSelectionEpos() 
	{
		eposObj.paymentPlanSelectionEpos();
	}

	public void enterCustomerDetailsEpos() 
	{
		eposObj.enterCustomerDetailsEpos();
	}
	
	public void enterAddressDetailsEpos() 
	{
		eposObj.enterAddressDetailsEpos();
	}
	
	public void selectDeliveryOptionEpos() 
	{
		eposObj.selectDeliveryOptionEpos();
	}
	
	public void eligibiltyCheckEpos() 
	{
		eposObj.eligibiltyCheckEpos();
	}
	
	public void enterBankDetailsEpos() 
	{
		eposObj.enterBankDetailsEpos();
	}
	
	public void checkoutOrderEpos() 
	{
		eposObj.checkoutOrderEpos();
	}	
	
	public void eposWarrantyAndDeviceTier() 
	{
		eposObj.eposWarrantyAndDeviceTier();
	}
}
