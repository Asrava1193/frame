package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
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


public class DeviceTier {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tarunvr\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver;

		int r=1 ;
		String urval;
		String url ;
		// HashMap<String,String>jsondata = new HashMap<>();
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
		driver.get("https://ecommerce-pad-test-2.vip.a.itdev.uk.pri.o2.com/shop/phones?cnd=new");
		driver.findElement(By.xpath("//button[contains(text(),'Accept all cookies')]")).click();
		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) { 
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				urval = sheet.getRow(rowIndex).getCell(0).getStringCellValue();
				urval= urval.replace("/", "-");
				/////// To Query and Get the JSON OUtput///////////////////////////
				url ="https://ecommerce-pad-test-2.vip.a.itdev.uk.pri.o2.com/shop/samsung/iphone-13?&code="+urval+"&device-type=packages";
				driver.navigate().to(url);
				Thread.sleep(6000);

				// Execute the JavaScript code and return the result as a JSON string
				String jsonString = (String) js.executeScript("return JSON.stringify(ncPortlets.DeviceDetailsPortlet.initData.deviceDetails);");
				System.out.println(jsonString);

				String jsonPath ="/saleTypes/0/tabs/0/data/values/0/customPlanCode";
				String columnName="Tier";
				JsonCompareValue(jsonPath,columnName,jsonString,workbook,sheet,row,rowIndex);



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
		try {
			rootNode = objectMapper.readTree(jsonString);
			resultnode = rootNode.at(jsonPath);
			jsonTier  = resultnode.asText();
			System.out.println(jsonTier);
			int columnIndex = findColumnIndex(sheet, columnName);
			System.out.println(columnIndex);

			String Tierval = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();


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
