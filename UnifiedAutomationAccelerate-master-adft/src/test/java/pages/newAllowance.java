package pages;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class newAllowance{

               public static void main(String[] args) throws Exception {
                              System.setProperty("webdriver.chrome.driver", "C:\\Users\\tarunvr\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
                              WebDriver driver;
                              String urval;
                              String url ;
                              driver    = new ChromeDriver();
                              driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                              driver.manage().window().maximize();
                              driver.get("https://ecommerce-pad-conf-1.vip.a.itdev.uk.pri.o2.com/shop/phones?cnd=new");
                              driver.findElement(By.xpath("//button[contains(text(),'Accept all cookies')]")).click();
                              JavascriptExecutor js = (JavascriptExecutor) driver;
                              String filePath = "C:\\Users\\tarunvr\\Desktop\\AllowanceLoader.xlsx";
                              FileInputStream fis = new FileInputStream(filePath);
                              Workbook workbook = new XSSFWorkbook(fis);
                              Sheet sheet = workbook.getSheetAt(0);
                              for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                                             Row row = sheet.getRow(rowIndex);
                                             if (row != null) {
                                                            urval = sheet.getRow(rowIndex).getCell(0).getStringCellValue();
                                                            urval= urval.replace("/", "-");
                                                            url ="https://ecommerce-pad-conf-1.vip.a.itdev.uk.pri.o2.com/shop/samsung/iphone-13?&code="+urval+"&device-type=packages";
                                                            driver.get(url);
                                                            String jsonString = (String) js.executeScript("return JSON.stringify(ncPortlets.DeviceDetailsPortlet.initData.deviceDetails);");
                                                            System.out.println(jsonString);
                                                            ObjectMapper objectMapper = new ObjectMapper();
                                                            JsonNode rootNode = objectMapper.readTree(jsonString);
                                                            JsonNode resultnode1;
                                                            JsonNode resultnode2;
                                                            JsonNode resultnode3;
                                                            String jsonPath1;
                                                            String jsonPath2;
                                                            String jsonPath3;
                                                            String columnName1;
                                                            String columnName2;
                                                            columnName1="Allowance Bundle";
                                                            columnName2="Price";
                                                            int columnIndex1 = findColumnIndex(sheet, columnName1);
                                                            int columnIndex2 = findColumnIndex(sheet, columnName2);
                                                            String Allw_1=sheet.getRow(rowIndex).getCell(columnIndex1).getStringCellValue();
                                                            String price=sheet.getRow(rowIndex).getCell(columnIndex2).getStringCellValue();
                                                            Cell cell1 = row.getCell(columnIndex1);
                                                            Cell cell2 = row.getCell(columnIndex2);

                                                            CellStyle greenCellStyle = workbook.createCellStyle();
                                                            greenCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                                                            greenCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                                                            CellStyle redCellStyle = workbook.createCellStyle();
                                                            redCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                                                            redCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                                            //                                                         jsonPath1 ="/tariffCardDetails/tariffCards/"+(rowIndex-1)+"/allowances/data/name";
                                                            //                                                         jsonPath2="/tariffCardDetails/tariffCards/"+(rowIndex-1)+"/airtimeMrc";
                                                            String value3="NA";
                                                            jsonPath1="/tariffCardDetails/tariffCards";
                                                            resultnode1=rootNode.at(jsonPath1);
                                                            for(int i=0; i<resultnode1.size();i++) {
                                                                           jsonPath2="/tariffCardDetails/tariffCards/"+i+"/allowances/data/name";
                                                                           resultnode2=rootNode.at(jsonPath2);
                                                                           String value=resultnode2.asText();
                                                                           //price
                                                                           if(Allw_1.equalsIgnoreCase(value)) {
                                                                                          value3="true";
                                                                                          jsonPath3="/tariffCardDetails/tariffCards/"+i+"/airtimeMrc";
                                                                                          resultnode3=rootNode.at(jsonPath3);
                                                                                          String value1=resultnode3.asText();
                                                                                          if(price.equalsIgnoreCase(value1)) {
                                                                                                         cell2.setCellStyle(greenCellStyle);
                                                                                                         break;
                                                                                          }
                                                                                          else {
                                                                                                         cell2.setCellStyle(redCellStyle);
                                                                                                         break;
                                                                                          }
                                                                           }

                                                            }
                                                            if(value3.equalsIgnoreCase("true")) {
                                                                           cell1.setCellStyle(greenCellStyle);
                                                            }
                                                            else {
                                                                           cell1.setCellStyle(redCellStyle);
                                                            }

                                             }
                              }
                              try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                                             workbook.write(outputStream);
                              } catch (FileNotFoundException e) {
                                             e.printStackTrace();
                              } catch (IOException e) {
                                             e.printStackTrace();
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

                              return -1;
               }
}
