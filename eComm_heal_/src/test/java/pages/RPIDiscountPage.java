package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import com.cognizant.craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.VMOReusableLibrary;

public class RPIDiscountPage extends VMOReusableLibrary
{
	public RPIDiscountPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	//******************locators********************
	 
	 private static final By listIcon = By.xpath("//a[@value='Navigation']");
	 private static final By productManagement = By.xpath("//span[text()='Product Management']"); 
	 private static final By plmManagement = By.xpath("//span[text()='PLM Management']");
	 private static final By others = By.xpath("//span[@class='imgTriangle']");
	 private static final By newDiscountTemplate = By.xpath("//li[@id='id_tab_17']//following::a[text()='New Discounts Template']");
	 private static final By externalId = By.xpath("//div[text()='External ID']/following::input[1]"); 
	 private static final By offeringCatalog = By.xpath("//span[text()='Offering Catalog']");	
	 private static final By discounts = By.xpath("//li[@id='id_tab_15']//following::a[text()='Discounts']");
	 private static final By discountNameFilter = By.xpath("(//span[text()='Discount Name']//parent::span//parent::div[1]//following::div//child::img[@aria-label='Sorting and Filtering for Discount Name column'])[1]"); 
	 private static final By contains = By.xpath("//input[@class='gwt-TextBox nc-field-text-input']");
	 private static final By apply = By.xpath("//button[text()='Apply']");

	 
	//declarations
	VMOReusableLibrary Vmor = new VMOReusableLibrary(scriptHelper);

	
	//***************** Actions **********************
	
	//Clicking on PLM Management
	public void plmManagement()
	{
		clickByJse(listIcon ,"listIcon","Y");
		pause(5);
		mouseHover(productManagement ,"productManagement" ,"Y");
		pause(5);
		clickByJse(plmManagement ,"plm" ,"Y");
	}
	
	//Searching in New Discount Template
	public void newDiscountTemplate()
	{
		switchToTab(1);
		pause(5);
		clickByJse(others ,"other" , "Y");
		pause(5);
		clickByJse(newDiscountTemplate ,"Newdiscount","Y");
		pause(5);
		enterText(externalId, "externalId", dataTable.getData("RPI_Discount","externalId"), "Y");
		pause(5);
		driver.findElement(externalId).sendKeys(Keys.ENTER);
		//clickByJse(searchButton ,"searchButton" ,"Y");
		pause(5);
		By discountName = By.xpath("//div[text()='"+dataTable.getData("RPI_Discount", "discountName")+"']");
		scrollIntoView(discountName);
		if(r_getText(discountName).contains(dataTable.getData("RPI_Discount", "discountName")))
		{
			report.updateTestLog("Discount Name","Discount Name is correct "+r_getText(discountName), Status.PASS);
		}
		else
		{	
			report.updateTestLog("Discount Name","Discount Name is incorrect "+r_getText(discountName), Status.FAIL);
		}
		pause(5);
		By discountAmount = By.xpath("//div[text()='"+dataTable.getData("RPI_Discount", "discountAmount")+"']");
		scrollIntoView(discountAmount);
		if(r_getText(discountAmount).contains(dataTable.getData("RPI_Discount", "discountAmount")))
		{
			report.updateTestLog("Discount Name","Discount Name is correct "+r_getText(discountAmount), Status.PASS);
		}
		else
		{	
			report.updateTestLog("Discount Name","Discount Name is incorrect "+r_getText(discountAmount), Status.FAIL);
		}
		
	}
			
	//Clicking on offering catalogue
	public void offeringCatalogue()
	{
		clickByJse(listIcon ,"listIcon","N");
		pause(5);
		mouseHover(productManagement ,"productManagement" ,"Y");
		pause(5);
		clickByJse(offeringCatalog , "offeringCatalogue" ,"Y");
		pause(5);
				
	}
	
	//Searching in Discounts Template
	public void discountTemplate()
	{
		clickByJse( others , "others", "Y");
		pause(5);
		clickByJse( discounts , "discounts", "Y");
		pause(5);
		clickByJse(discountNameFilter ,"filter" , "N");
		pause(5);
		enterText(contains , "contains", dataTable.getData("RPI_Discount","discountName") ,"Y") ;
		pause(5);
		hoverAndClickElement(apply,apply ,5);
		pause(5);
		By legacyTriffId  = By.xpath("//div[text()='"+dataTable.getData("RPI_Discount","legacyID")+"']");
		scrollIntoView(legacyTriffId);
		pause(5);
		if(r_getText(legacyTriffId).contains(dataTable.getData("RPI_Discount", "legacyID")))
		{
			report.updateTestLog("Legacy ID","Legacy ID is correct "+r_getText(legacyTriffId), Status.PASS);
		}
		else
		{	
			report.updateTestLog("Legacy ID","Legacy ID is incorrect "+r_getText(legacyTriffId), Status.FAIL);
		}
		
	}
	
	
	 
	 
}


	