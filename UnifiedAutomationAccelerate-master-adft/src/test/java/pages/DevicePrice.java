package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DevicePrice {

	public static void main(String[] args) throws Exception {
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
		String filePath = "C:\\Users\\tarunvr\\Desktop\\device_price_Tier.xlsx";

		// Open the Excel file using FileInputStream
		FileInputStream fis = new FileInputStream(filePath);

		// Create a workbook object for the Excel file (XSSFWorkbook for .xlsx files)
		Workbook workbook = new XSSFWorkbook(fis);


		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		// Get the first sheet in the workbook (You can specify the sheet index or name)
		Sheet sheet = workbook.getSheetAt(0);
		System.out.println(sheet.getLastRowNum());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ecommerce-pad-test-2.vip.a.itdev.uk.pri.o2.com/shop/phones?cnd=new");
		driver.findElement(By.xpath("//button[contains(text(),'Accept all cookies')]")).click();

		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) { 
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				urval = sheet.getRow(rowIndex).getCell(0).getStringCellValue();
				urval= urval.replace("/", "-");
				/////// To Query and Get the JSON OUtput///////////////////////////
				url ="https://ecommerce-pad-conf-1.vip.a.itdev.uk.pri.o2.com/shop/samsung/iphone-13?&code="+urval+"&device-type=packages";
				driver.get(url);
				Thread.sleep(6000);
				// Execute the JavaScript code and return the result as a JSON string
				String jsonString = (String) js.executeScript("return JSON.stringify(ncPortlets.DeviceDetailsPortlet.initData.deviceDetails);");
				System.out.println(jsonString);
				String jsonPath ;
				String columnName;
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode rootNode=objectMapper.readTree(jsonString);
				JsonNode resultnode;
				JsonNode resultnode1;
				String value2;
				String value3="NA";



				// Create a cell style for green
				CellStyle greenCellStyle = workbook.createCellStyle();
				greenCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				greenCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				// Create a cell style for red
				CellStyle redCellStyle = workbook.createCellStyle();
				redCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
				redCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				jsonPath ="/saleTypes/0/tabs";
				columnName="Sale Type";
				int columnIndex = findColumnIndex(sheet, columnName);
				String Tierval = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
				resultnode = rootNode.at(jsonPath);
				for(int l=0; l<resultnode.size();l++) {
					String jsonPath2 ="/saleTypes/0/tabs/"+l+"/saleType";
					resultnode1 = rootNode.at(jsonPath2);
					value2= resultnode1.asText();
					if(value2.equalsIgnoreCase(Tierval)) {
						Cell cell = row.getCell(columnIndex);
						cell.setCellStyle(greenCellStyle);
						value3="True";
						break;
					}
				}
				if(!value3.equals("True")) {
					Cell cell = row.getCell(columnIndex);
					cell.setCellStyle(redCellStyle);
				}
				//				JsonCompareValue(jsonPath,columnName,jsonString,workbook,sheet,row,rowIndex);

				jsonPath ="/saleTypes/0/tabs/0/totalPrice/originalPrice/amount";
				columnName="New Price  (£) (inc. VAT)";
				JsonCompareValue(jsonPath,columnName,jsonString,workbook,sheet,row,rowIndex);

				jsonPath ="/saleTypes/0/tabs/0/totalPrice/originalPrice/amount";
				columnName="New Price  (£) (inc. VAT)";
				JsonCompareValue(jsonPath,columnName,jsonString,workbook,sheet,row,rowIndex);
				//UPFRont Discount/////
				jsonPath ="/saleTypes/0/tabs/0/upfront/values";
				rootNode = objectMapper.readTree(jsonString);
				resultnode = rootNode.at(jsonPath); 
				int s =  resultnode.size()-1;
				String min  = rootNode.at("/saleTypes/0/tabs/0/upfront/values/0/value").asText();
				System.out.println( "min Upfront cost : " + min);
				String max  = rootNode.at("/saleTypes/0/tabs/0/upfront/values/"+s+"/value").asText();
				System.out.println( "Max Upfront cost : " + max);
				String minupfront1  = "/saleTypes/0/tabs/0/upfront/values/0/value"; 
				String maxupfront1  = "/saleTypes/0/tabs/0/upfront/values/"+s+"/value"; 
				columnName="Min Downpayment/Upfront Payment for New";
				JsonCompareValue(minupfront1,columnName,jsonString,workbook,sheet,row,rowIndex);
				columnName="Max Downpayment/Upfront Payment";
				JsonCompareValue(maxupfront1,columnName,jsonString,workbook,sheet,row,rowIndex);
				//Min and Max Month/////
				jsonPath ="/saleTypes/0/tabs/0/months/values";
				resultnode = rootNode.at(jsonPath); 
				int s1 =  resultnode.size()-1;
				String minmoth  = rootNode.at("/saleTypes/0/tabs/0/months/values/0/value").asText();
				System.out.println( "min months  : " + minmoth);

				String maxmonth  = rootNode.at("/saleTypes/0/tabs/0/months/values/"+s1+"/value").asText();
				System.out.println( "Max months : " + maxmonth);
				String minMonth1 ="/saleTypes/0/tabs/0/months/values/0/value";
				String maxMonth1 ="/saleTypes/0/tabs/0/months/values/"+s1+"/value";
				columnName="Installment Term  Min";
				JsonCompareValue(minMonth1,columnName,jsonString,workbook,sheet,row,rowIndex);
				columnName="Installment Term  Max";
				JsonCompareValue(maxMonth1,columnName,jsonString,workbook,sheet,row,rowIndex);


			}
		}

		// Close the workbook and FileInputStream
		// Write the Excel file
		try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		workbook.close();
		fis.close();
		System.out.println("Done");


	}

	private static void JsonCompareValue(String jsonPath,String columnName,String jsonString,Workbook workbook,Sheet sheet,Row row ,int rowIndex ) {

		JsonNode resultnode;
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode;
		String jsonTier ;
		String Tierval;
		int val;
		try {
			rootNode = objectMapper.readTree(jsonString);
			resultnode = rootNode.at(jsonPath);
			jsonTier  = resultnode.asText();
			System.out.println(jsonTier);
			int columnIndex = findColumnIndex(sheet, columnName);
			System.out.println(columnIndex);
			if (columnName.equals("Sale Type")){
				Tierval = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
			}
			else {
				val = (int) sheet.getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
				Tierval =Integer.toString(val);
			}




			Cell cell = row.getCell(columnIndex);


			// Create a cell style for green
			CellStyle greenCellStyle = workbook.createCellStyle();
			greenCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			greenCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			// Create a cell style for red
			CellStyle redCellStyle = workbook.createCellStyle();
			redCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			redCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			if (jsonTier.contains(Tierval)) {
				System.out.println(jsonTier +" === "+Tierval);
				cell.setCellStyle(greenCellStyle);
			}
			else {
				System.out.println(jsonTier +" not equal "+Tierval);
				cell.setCellStyle(redCellStyle);
			}


		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


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

