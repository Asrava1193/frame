package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.core.io.FileUrlResource;
//import org.seleniumhq.jetty7.util.ajax.JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TechSpecificValidation {

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tarunvr\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver;

		int r=1 ;
		String urval;
		String url ;
		HashMap<String,String>jsondata = new HashMap<>();
		// Create a new instance of the ChromeDriver
		driver    = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;


		// Specify the path to your Excel file
		String filePath = "C:\\Users\\tarunvr\\Desktop\\eComm_SVOS_Apple_Pencil_USBC.xlsx";

		// Open the Excel file using FileInputStream
		FileInputStream fis = new FileInputStream(filePath);

		// Create a workbook object for the Excel file (XSSFWorkbook for .xlsx files)
		Workbook workbook = new XSSFWorkbook(fis);

		// Get the first sheet in the workbook (You can specify the sheet index or name)
		Sheet sheet = workbook.getSheetAt(0);
		System.out.println(sheet.getLastRowNum());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ecommerce-pad-test-1.vip.a.itdev.uk.pri.o2.com/shop/phones?cnd=new");
		driver.findElement(By.xpath("//button[contains(text(),'Accept all cookies')]")).click();
		// Iterate through all the rows in the sheet
		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) { 
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				urval = sheet.getRow(rowIndex).getCell(0).getStringCellValue();
				urval= urval.replace("/", "-");
				/////// To Query and Get the JSON OUtput///////////////////////////
				url ="https://ecommerce-pad-conf-1.vip.a.itdev.uk.pri.o2.com/shop/samsung/iphone-13?&code="+urval;
				driver.get(url);
				//				WebElement techSpecs=driver.findElement(By.xpath("//button[@aria-label='See tech specs']"));
				//				js.executeScript("arguments[0].scrollIntoView(true);", techSpecs);
				//				techSpecs.click();
				//				TakesScreenshot ts=((TakesScreenshot)driver);
				//				File scr=ts.getScreenshotAs(OutputType.FILE);
				//				File des=new File("C:\\Users\\tarunvr\\Desktop\\New Repo\\UnifiedAutomationAccelerate\\techSpecs.png");
				//				FileUtils.copyFile(scr, des);
				Thread.sleep(6000);


				// Execute the JavaScript code and return the result as a JSON string
				String jsonString = (String) js.executeScript("return JSON.stringify(ncPortlets.DeviceDetailsPortlet.initData.deviceDetails);");
				System.out.println(jsonString);
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode rootNode = objectMapper.readTree(jsonString);
				JsonNode resultnode;
				JsonNode resultnode1;
				JsonNode resultnode2;
				JsonNode resultnode3;
				JsonNode resultnode4;
				JsonNode resultnode5;
				String jsonPath;
				String jsonPath2;
				String jsonPath3;
				String jsonPath4;
				String jsonPath5;
				String value1;
				String columnheadnew;

				jsonPath ="/specificationGroups";
				resultnode = rootNode.at(jsonPath);

				for(int l=0; l<resultnode.size();l++) {
					jsonPath2 ="/specificationGroups/"+l+"/specifications";
					resultnode2 = rootNode.at(jsonPath2);
					for(int l1=0; l1<resultnode2.size();l1++) {  
						jsonPath3 ="/specificationGroups/"+l+"/specifications/"+l1+"/name";
						resultnode3 = rootNode.at(jsonPath3);
						String jsonname  = resultnode3.asText();
						jsonPath4 ="/specificationGroups/"+l+"/specifications/"+l1+"/value";
						resultnode4 = rootNode.at(jsonPath4);
						String jsonvalue  = resultnode4.asText();

						jsondata.put(jsonname, jsonvalue);
					}

				}

				//brand
				jsonPath5 ="/brand";
				resultnode5 = rootNode.at(jsonPath5);
				String Brand= resultnode5.asText();
				jsondata.put("Brand", Brand);
				///////////////////////////////////////////////////////////////////////////////  
				// Iterate through all the cells in the row
				for (int columnIndex = 1; columnIndex < row.getLastCellNum(); columnIndex++) {
					Cell cell = row.getCell(columnIndex);
					// Create a cell style for green
					CellStyle greenCellStyle = workbook.createCellStyle();
					greenCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					greenCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					// Create a cell style for red
					CellStyle redCellStyle = workbook.createCellStyle();
					redCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
					redCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					if (cell != null) {
						String columnhead = sheet.getRow(0).getCell(columnIndex).getStringCellValue();
						// System.out.println(cell.getStringCellValue());
						if(columnhead.contains("(eComm)")) {
							//String [] arrhead = columnhead.split("(eComm)");
							columnheadnew =columnhead.replace("(eComm)", "").trim();
						}
						else {
							columnheadnew =columnhead.trim();
						}
						if (columnhead.contains("Data Connectivity")) {
							columnheadnew ="Network Technology";
						}
						if (columnhead.contains("Type of display")) {
							columnheadnew ="Type of Display";
						}
						if (columnhead.contains("Dual Sim")) {
							columnheadnew ="Dual SIM";
						}
						if (columnhead.contains("Sim Type (Nano etc)")) {
							columnheadnew ="SIM Type (Nano etc)";
						}
						String colval = jsondata.get(columnheadnew);
						System.out.println(cell.getStringCellValue());


						if (colval != null) {
							if (colval.equalsIgnoreCase(cell.getStringCellValue())){
								System.out.println(colval +" === "+cell.getStringCellValue());
								cell.setCellStyle(greenCellStyle);
							}
							else {
								System.out.println(cell.getStringCellValue() +" is getting displayed in the application");
								cell.setCellStyle(redCellStyle);
							}
						}
						else {
							System.out.println(columnheadnew + " is not getting displayed in the JSON"); 
						}

					}
					else {
						String cellval = sheet.getRow(0).getCell(columnIndex).getStringCellValue();
						System.out.println(cellval +" is empty");

						if(cellval.contains("(eComm)")) {
							//String [] arrhead = columnhead.split("(eComm)");
							columnheadnew =cellval.replace("(eComm)", "").trim();
						}
						else {
							columnheadnew =cellval.trim();
						}

						if (cellval.contains("Data Connectivity")) {
							columnheadnew ="Network Technology";
						}
						if (cellval.contains("Type of display")) {
							columnheadnew ="Type of Display";
						}
						if (cellval.contains("Dual Sim")) {
							columnheadnew ="Dual SIM";
						}
						if (cellval.contains("Sim Type (Nano etc)")) {
							columnheadnew ="SIM Type (Nano etc)";
						}
						String colval = jsondata.get(columnheadnew);

						if (colval != null) {	
							Cell cell1 = row.createCell(columnIndex);
							cell1.setCellValue(colval+" is displayed in the Application");
							System.out.println(cell1.getStringCellValue() +" is getting displayed in the application");
							cell1.setCellStyle(redCellStyle);

						}
						else {
							System.out.println(cellval + " is not getting displayed in the JSON"); 
						}

					}
				}
			}
		}


		// Close the workbook and FileInputStream
		// Write the Excel file
		try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
			workbook.write(outputStream);
		}

		workbook.close();
		fis.close();
		System.out.println("Done");
	}

}
