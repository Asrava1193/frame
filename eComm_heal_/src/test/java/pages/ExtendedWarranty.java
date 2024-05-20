package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.seleniumhq.jetty7.util.ajax.JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;

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


public class ExtendedWarranty {

	public static void main(String[] args) throws IOException, Exception {
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
		String filePath = "C:\\Users\\tarunvr\\Desktop\\ExtendedWarranty.xlsx";

		// Open the Excel file using FileInputStream
		FileInputStream fis = new FileInputStream(filePath);

		// Create a workbook object for the Excel file (XSSFWorkbook for .xlsx files)
		Workbook workbook = new XSSFWorkbook(fis);

		// Get the first sheet in the workbook (You can specify the sheet index or name)
		Sheet sheet = workbook.getSheetAt(0);
		System.out.println(sheet.getLastRowNum());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ecommerce-pad-test-2.vip.a.itdev.uk.pri.o2.com/shop/phones?cnd=new");
		driver.findElement(By.xpath("//button[contains(text(),'Accept all cookies')]")).click();
		// Iterate through all the rows in the sheet
		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) { 
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				urval = sheet.getRow(rowIndex).getCell(0).getStringCellValue();
				urval= urval.replace("/", "-");
				/////// To Query and Get the JSON OUtput///////////////////////////
				url ="https://ecommerce-pad-test-2.vip.a.itdev.uk.pri.o2.com/shop/samsung/iphone-13?&code="+urval+"&device-type=packages";
				driver.get(url);
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
				String columnName;
				columnName="Allowance Bundle";
				int allowance =findColumnIndex(sheet,columnName);
				columnName="Warranty";
				int warranty =findColumnIndex(sheet,columnName); 
				jsonPath ="/tariffCardDetails/tariffCards";
				resultnode = rootNode.at(jsonPath);

				for(int l=0; l<resultnode.size();l++) {
					jsonPath ="/tariffCardDetails/tariffCards/"+l+"/allowances/data/name";
					resultnode1 = rootNode.at(jsonPath);
					value1= resultnode1.asText();
					String allowanceBundle  =sheet.getRow(rowIndex).getCell(allowance).getStringCellValue();
					if(value1.equalsIgnoreCase(allowanceBundle)){
						jsonPath2 ="/tariffCardDetails/tariffCards/"+l+"/offers/3/title";
						resultnode2 = rootNode.at(jsonPath2);
						String value2= resultnode2.asText();
						Cell cell1 = row.createCell(warranty);
						cell1.setCellValue(value2);
						break;


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


	private static int findColumnIndex(Sheet sheet, String columnName) {
		Row headerRow = sheet.getRow(0); // Assuming column names are in the first row

		if (headerRow != null) {
			for (int columnIndex = 0; columnIndex < headerRow.getLastCellNum(); columnIndex++) {
				Cell cell = headerRow.getCell(columnIndex);
				if (cell != null) {

					String cellValue = cell.getStringCellValue();
					if (cellValue.equals(columnName)) {
						return columnIndex;
					}    
				}
			}
		}

		return -1; // Column not found
	}


}
