package businesscomponents;

import com.cognizant.craft.ReusableLibrary;
import com.cognizant.craft.ScriptHelper;

import pages.CsrdAdftPage;

public class CsrdAdftComponent extends ReusableLibrary
{
	public CsrdAdftComponent(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}

	//Declarations
	CsrdAdftPage csrdBF = new CsrdAdftPage(scriptHelper);

	public void invokeApplicationCSRD() 
	{
		csrdBF.invokeApplicationCSRD();
	}
	
	public void loginToCSRD()
	{
		csrdBF.loginCSRD();
	}
	
	public void enteringMail() 
	{
		csrdBF.enteringMail();
	}
	
	public void residentialAccountPage() 
	{
		csrdBF.residentialAccountPage();
	}
	
	public void createBillingAccount() 
	{
		csrdBF.createBillingAccount();
	}

	public void placingOrder() 
	{
		csrdBF.placingOrder();
	}
	
	public void validateDevicePrice() 
	{
		csrdBF.validateDevicePrice();
	}
	
	public void validateAllowanceAndCCA() 
	{
		csrdBF.validateAllowanceAndCCA();
	}
	
	public void validateDeviceTier() 
	{
		csrdBF.validateDeviceTier();
	}
	
	public void validateInsuranceUpfrontDiscountWarranty() 
	{
		csrdBF.validateInsuranceUpfrontDiscountWarranty();
	}
	
	public void eligibiltyCheck() 
	{
		csrdBF.eligibiltyCheck();
	}
	
	public void interactionDescription() 
	{
		csrdBF.interactionDescription();
	}
	
	public void creditCheckPayments() 
	{
		csrdBF.creditCheckPayments();
	}
	
	public void checkoutOrder() 
	{
		csrdBF.checkoutOrder();
	}
}
