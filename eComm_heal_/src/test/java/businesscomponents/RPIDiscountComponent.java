package businesscomponents;

import com.cognizant.craft.ReusableLibrary;
import com.cognizant.craft.ScriptHelper;

import pages.CsrdAdftPage;
import pages.RPIDiscountPage;

public class RPIDiscountComponent extends ReusableLibrary
{
	public RPIDiscountComponent(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}

	//Declarations
	CsrdAdftPage csrdBF = new CsrdAdftPage(scriptHelper);
	RPIDiscountPage csrdBFR = new RPIDiscountPage(scriptHelper);

	public void invokeApplicationCSRD() 
	{
		csrdBF.invokeApplicationCSRD();
	}
	
	public void loginToCSRD()
	{
		csrdBF.loginCSRD();
	}
	
	public void clickPlmManagement()
	{
		csrdBFR.plmManagement();
	}
	
	public void newDiscountTemplate()
	{
		csrdBFR.newDiscountTemplate();
	}
	
	public void offeringCatalogue()
	{
		csrdBFR.offeringCatalogue();
	}
	
	public void discountTemplate()
	{
		csrdBFR.discountTemplate();
	}
	
		
}