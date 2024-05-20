package businesscomponents;

import com.cognizant.craft.ReusableLibrary;
import com.cognizant.craft.ScriptHelper;

import pages.EcomAdftPage;

public class EcomAdftComponent extends ReusableLibrary
{
	public EcomAdftComponent(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}

	//Declarations
	EcomAdftPage ecomObj = new EcomAdftPage(scriptHelper);

	public void invokeApplicationEcom() 
	{
		ecomObj.invokeApplicationEcom();
	}
	
	public void selectDeviceEcom() 
	{
		ecomObj.selectDeviceEcom();
	}
	
	public void selectColorCapacityEcom() 
	{
		ecomObj.selectColorCapacityEcom();
	}
	
	public void paymentPlanSelectionEcom() 
	{
		ecomObj.paymentPlanSelectionEcom();
	}

	public void enterCustomerDetailsEcom() 
	{
		ecomObj.enterCustomerDetailsEcom();
	}
	
	public void enterAddressDetailsEcom() 
	{
		ecomObj.enterAddressDetailsEcom();
	}
	
	public void selectDeliveryOptionEcom() 
	{
		ecomObj.selectDeliveryOptionEcom();
	}
	
	public void eligibiltyCheckEcom() 
	{
		ecomObj.eligibiltyCheckEcom();
	}
	
	public void enterBankDetailsEcom() 
	{
		ecomObj.enterBankDetailsEcom();
	}
	
	public void checkoutOrderEcom() 
	{
		ecomObj.checkoutOrderEcom();
	}
	
	public void ecomWarrantyAndDeviceTier() 
	{
		ecomObj.ecomWarrantyAndDeviceTier();
	}	
}
