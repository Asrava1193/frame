package com.cognizant.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Pages.CSRD;

public class ExcelData {

	public String path = System.getProperty("user.dir") + "\\CSRD.xlsx";
	public static String VG = null;
	public static String VGSelected = null;
	public static String Username = null;
	public static String Password = null;
	public static String email = null;
	public static String Postcode = null;
	public static String BuildingNumber = null;
	public String CSRD_DcChannelName = null;
	public String CSRD_campaignName = null;
	public static String SerialNo1 = null;
	public static String SerialNo2 = null;
	public static String SerialNo2Sim = null;
	public static String phone1 = null;
	public static String phone2 = null;
	public static String watch = null;
	public static String AllowanceBundle = null;
	public static String CustomPlanAllowanceBundle = null;
	public static String simPlanEnv1 = null;
	public static String simPlanEnv2 = null;
	public static String simPlanEnv3 = null;
	public static String sim2PlanEnv1 = null;
	public static String sim2PlanEnv2 = null;
	public static String sim2PlanEnv3 = null;
	public static String smartKeyboard = null;
	public static String spendcap1 = null;
	public static String spendcap2 = null;
	

	public void readinputdata(int curriteration, int iteration) throws IOException, Exception {
		FileInputStream fs = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet datasheet = workbook.getSheet("General_Data");
		System.out.println("Please enter the data to be created for(VGC/VG10/VG11/VG14/VG26):");
		 VGSelected = Main.testcasename;
		 System.out.println(VGSelected);

		for (int i = 1; i <= datasheet.getLastRowNum(); i++) {
			Row row = datasheet.getRow(i);
			String vgvalue = row.getCell(0).getStringCellValue().trim();
			if (VGSelected.equals(vgvalue)) {
				int noofiterations = i + iteration;
				for (int j = i; j <= noofiterations; j++) {
					int Subiteration = (int) datasheet.getRow(j).getCell(2).getNumericCellValue();
					if (Subiteration == curriteration) {
						Row subiterationrow = datasheet.getRow(j);
						VG = subiterationrow.getCell(0).getStringCellValue();
						System.out.println("Data selected for VG:" + VG + " and Subiteration is:" + Subiteration);
						email = subiterationrow.getCell(4).getStringCellValue();
						System.out.println(email);
						Username = subiterationrow.getCell(9).getStringCellValue();
						System.out.println(Username);
						Password = subiterationrow.getCell(10).getStringCellValue();
						System.out.println(Password);
						Postcode = subiterationrow.getCell(7).getStringCellValue();
						System.out.println(Postcode);
						BuildingNumber = subiterationrow.getCell(8).getStringCellValue();
						System.out.println(BuildingNumber);
						CSRD_DcChannelName = subiterationrow.getCell(15).getStringCellValue();
						CSRD_campaignName = subiterationrow.getCell(16).getStringCellValue();
						SerialNo1 = subiterationrow.getCell(20).getStringCellValue();
						System.out.println("Serial No 1:" + SerialNo1);
						SerialNo2 = subiterationrow.getCell(21).getStringCellValue();
						System.out.println("Serial No 2:" + SerialNo2);
						phone1 = subiterationrow.getCell(22).getStringCellValue();
						System.out.println("Phone1:" + phone1);
						phone2 = subiterationrow.getCell(23).getStringCellValue();
						System.out.println("Phone2:" + phone2);
						watch = subiterationrow.getCell(24).getStringCellValue();
						System.out.println("Watch:" + watch);
						AllowanceBundle = subiterationrow.getCell(25).getStringCellValue();
						System.out.println("Allowance Bundle:" + AllowanceBundle);
						CustomPlanAllowanceBundle = subiterationrow.getCell(11).getStringCellValue();
						System.out.println(CustomPlanAllowanceBundle);
						simPlanEnv1 = subiterationrow.getCell(26).getStringCellValue();
						System.out.println("Sim Plan in env1:" + simPlanEnv1);
						simPlanEnv2 = subiterationrow.getCell(27).getStringCellValue();
						System.out.println("Sim Plan in env2:" + simPlanEnv2);
						simPlanEnv3 = subiterationrow.getCell(28).getStringCellValue();
						System.out.println("Sim Plan in env3:" + simPlanEnv3);
						sim2PlanEnv1 = subiterationrow.getCell(26).getStringCellValue();
						System.out.println("Sim 2 Plan in env1:" + sim2PlanEnv1);
						sim2PlanEnv2 = subiterationrow.getCell(27).getStringCellValue();
						System.out.println("Sim 2 Plan in env2:" + sim2PlanEnv2);
						sim2PlanEnv3 = subiterationrow.getCell(28).getStringCellValue();
						System.out.println("Sim 2 Plan in env3:" + sim2PlanEnv3);
						smartKeyboard = subiterationrow.getCell(3).getStringCellValue();
						System.out.println("Keyboard:" + smartKeyboard);
						spendcap1=subiterationrow.getCell(5).getStringCellValue();
			    		spendcap2=subiterationrow.getCell(6).getStringCellValue();
			    		System.out.println(spendcap1+" "+spendcap2);
					}
					break;
				}
			} else {
				continue;
			}
		}
		workbook.close();
	}

	public void Writeoutputdata() throws IOException, Exception {
		CSRD csrd1 = new CSRD();
		String currentDirectory = System.getProperty("user.dir");
		String folderPath = currentDirectory + File.separator + "testDataOutput";
		String outputFilePath = folderPath + File.separator + "output_file.xlsx";
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		XSSFWorkbook workbook;
		XSSFSheet datasheet;
		// Check if output file exists
		File outputFile = new File(outputFilePath);
		boolean fileExists = outputFile.exists();

		if (fileExists) {
			// If file exists, open the workbook and get the existing sheet
			FileInputStream fis = new FileInputStream(outputFile);
			workbook = new XSSFWorkbook(fis);
			datasheet = workbook.getSheet("Output Data");
		} else {
			// If file doesn't exist, create a new workbook and sheet
			workbook = new XSSFWorkbook();
			datasheet = workbook.createSheet("Output Data");
			// Create header row
			XSSFRow rowhead = datasheet.createRow(0);
			rowhead.createCell(0).setCellValue("CreatedVG");
			rowhead.createCell(1).setCellValue("Url");
			rowhead.createCell(2).setCellValue("Username");
			rowhead.createCell(3).setCellValue("Password");
			rowhead.createCell(4).setCellValue("Email address");
			rowhead.createCell(5).setCellValue("First name");
			rowhead.createCell(6).setCellValue("Last name");
			rowhead.createCell(7).setCellValue("Post code");
			rowhead.createCell(8).setCellValue("Order ID");
			rowhead.createCell(9).setCellValue("External Resevation ID");
			rowhead.createCell(10).setCellValue("Fullfillment ID");
			
		}
		// Find the last row index
		int lastRowNum = datasheet.getLastRowNum();
		// Create a new row
		XSSFRow newRow = datasheet.createRow(lastRowNum + 1);
		newRow.createCell(0).setCellValue(VGSelected);
		newRow.createCell(1).setCellValue(csrd1.getCurrenturl());
		newRow.createCell(2).setCellValue(Username);
		newRow.createCell(3).setCellValue(Password);
		newRow.createCell(4).setCellValue(csrd1.storeEmail);
		newRow.createCell(5).setCellValue(csrd1.firstName);
		newRow.createCell(6).setCellValue(csrd1.lastName);
		newRow.createCell(7).setCellValue(Postcode);
		newRow.createCell(8).setCellValue(csrd1.OrderID);
		newRow.createCell(9).setCellValue(csrd1.ExternalReservationID);
		newRow.createCell(10).setCellValue(csrd1.FulfillmentOrderNo);
		// Write the workbook to the output file
		FileOutputStream fos = new FileOutputStream(outputFile);
		workbook.write(fos);
		workbook.close();
		fos.close();
	}
}