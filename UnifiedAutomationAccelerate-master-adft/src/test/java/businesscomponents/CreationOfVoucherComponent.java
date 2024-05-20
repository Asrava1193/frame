package businesscomponents;

import com.cognizant.craft.ReusableLibrary;
import com.cognizant.craft.ScriptHelper;

import pages.CsrdAdftPage;
import pages.CreationOfVoucherPage;

public class CreationOfVoucherComponent extends ReusableLibrary
{
	public CreationOfVoucherComponent(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}

	//Declarations
	CsrdAdftPage csrdBF = new CsrdAdftPage(scriptHelper);
	CreationOfVoucherPage csrdBFV = new CreationOfVoucherPage(scriptHelper);

	public void invokeApplicationCSRD() 
	{
		csrdBF.invokeApplicationCSRD();
	}
	
	public void loginToCSRD()
	{
		csrdBF.loginCSRD();
	}
	
	public void voucherManagement()
	{
		csrdBFV.voucherManagement();
	}
	
	public void newDiscountVoucher()
	{
		csrdBFV.newDiscountVoucher();
	}
	
	public void standAloneVoucher()
	{
		csrdBFV.standAloneVoucher();
	}
	
	public void activateVoucher()
	{
		csrdBFV.activateVoucher();
	}
	
	
	
	
}