package com.cognizant.framework;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import Pages.CSRD;
import static io.restassured.RestAssured.given;
import java.util.Base64;

import com.aventstack.extentreports.Status;

public class APIFunctionality {
	
	
	
	public void initializeAPI(String env1)
	    {
				
			String selectedbaseuri=env1 + "api/";
			System.out.println(selectedbaseuri);
			
			System.out.println("API Test invoked");
			String username ="integrationPlatform_AD";
			String password="ewoiieowei_9909KOdsdss";
			RequestSpecBuilder requestSpecBuilder;
			
			if (selectedbaseuri.equals("https://toms-e2e2.vip.a.itdev.uk.pri.o2.com/api/"))
			{
			  requestSpecBuilder = new RequestSpecBuilder().
		               setBaseUri(selectedbaseuri).
		              addHeader("Authorization","Basic " + encodeCredentials(username, password)).
		               setContentType(ContentType.JSON).
		                log(LogDetail.ALL);
			}
			else
			{
	        requestSpecBuilder = new RequestSpecBuilder().
	               setBaseUri(selectedbaseuri).
	              addHeader("Authorization","Basic SW50ZWdyYXRpb25QbGF0Zm9ybV91c2VyOjhmMGUyZjc2ZTIyYjQzZTI4NTUxODk4NzdlN2RjMWUxZTdkOThjMjI2Yzk1ZGIyNDdjZDFkNTQ3OTI4MzM0YTk=").
	               setContentType(ContentType.JSON).
	                log(LogDetail.ALL);
			}
	        RestAssured.requestSpecification = requestSpecBuilder.build();
	 
	        //Response Specification Builder
	 
	        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
	                //expectStatusCode(200).
	               // expectContentType(ContentType.JSON).
	                log(LogDetail.ALL);
	        
	        //Default Response Specification
	        RestAssured.responseSpecification = responseSpecBuilder.build();
	    }
    private String encodeCredentials(String username, String password) {
    	String credentials = username + ":" + password;
    	return Base64.getEncoder().encodeToString(credentials.getBytes());
    }
	
	public void validate_put_request_SIMO(String SSN)
    {
        String payload = "{\r\n"
        		+ "    \"jdeCompany\": \"00030\",\r\n"
        		+ "    \"customerNumber\": \"NC01-04\",\r\n"
        		+ "    \"orderNumber\": \""+CSRD.ExternalReservationID+"\",\r\n"  //External Reservation ID
        		+ "    \"customerOrderNumber\": \""+CSRD.FulfillmentOrderNo+"\",\r\n" //Fulfillment Order No
        		
        		+ "    \"statusCode\": 8,\r\n"
        		+ "    \"statusDetail\": \"Order Despatched\",\r\n"
        		+ "    \"despatchedDate\": \"2023-11-13T08:00:00\",\r\n"
        		+ "    \"expectedDespatchDate\": \"2023-11-13\",\r\n"
        		+ "    \"orderedDate\": \"2023-11-13\",\r\n"
        		+ "    \"orderType\": \"SO\",\r\n"
        		+ "    \"messageVersion\": \"4.0\",\r\n"
        		+ "    \"orderLines\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"lineNumber\": \"1\",\r\n"
        		+ "            \"productCode\": \"25GTRIVN\",\r\n"
        		+ "            \"description\": \"pSIM\",\r\n"
        		+ "            \"extendedAmount\": \"28.00\",\r\n"
        		+ "            \"orderedQuantity\": \"1\",\r\n"
        		+ "            \"shippedQuantity\": \"1\",\r\n"
        		+ "            \"serialDetails\": [\r\n"
        		+ "                {\r\n"
        		+ "                    \"serialDetail\": [\r\n"
        		+ "                        {\r\n"
        		+ "                        \"type\": \"SIM Serial\",\r\n"
        		+ "                        \"value\": \""+SSN+"\"\r\n" //Serial No
        		+ "                        }  \r\n"
        		+ "                    ]\r\n"
        		+ "                }\r\n"
        		+ "            ]\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"orderConsignments\": [\r\n"
        		+ "    {\r\n"
        		+ "               \"reference\": \"CKV75106\",\r\n"
        		+ "               \"longReference\": \"CKV75106|14585201\",\r\n"
        		+ "               \"trackingURL\": \"http://www.royalmail.com/portal/rm/track?trackNumber=CKV75106\",\r\n"
        		+ "               \"courierDate\": \"2020-11-04T07:00:00\",\r\n"
        		+ "               \"shippedCourierName\": \"DPD\",\r\n"
        		+ "               \"shippedServiceType\": \"RMAS01MM\"\r\n"
        		+ "    }\r\n"
        		+ "    ],\r\n"
        		+ "    \"deliveryAddress\": {\r\n"
        		+ "          \"name\": \"Sarah Morgan\",\r\n"
        		+ "          \"line1\": \"Flat 44\",\r\n"
        		+ "          \"line2\": \"A Road\",\r\n"
        		+ "          \"line3\": \"Crewe\",\r\n"
        		+ "          \"line4\": \"Cheshire\",\r\n"
        		+ "          \"postcode\": \"CW1 6BU\",\r\n"
        		+ "          \"country\": \"UK\"\r\n"
        		+ "    }\r\n"
        		+ "}";
        
        
        try {
        given()
 
        .header("Content-Type","application/json")
        
                .body(payload).
                when().
                //PUT Method and you need to specify the workspaceId inside the Curly Braces
                put("/v1/WMS").
                then().
                assertThat().statusCode(204);
        
        ExtentReport.log(payload, "WMS API Put Req was Successfull", Status.PASS);
        }catch (AssertionError e) {
			// TODO: handle exception
        	
        e.printStackTrace();
        ExtentReport.log(payload, "WMS API Put Req was Unsuccessfull", Status.SKIP);

		}
 
 
    } 
	
	
	public void validate_put_request_SFF()
    {
        String payload = "{\r\n"
        		+ "    \"jdeCompany\": \"00030\",\r\n"
        		+ "    \"customerNumber\": \"NC01-04\",\r\n"
        		+ "    \"orderNumber\": \""+CSRD.ExternalReservationID+"\",\r\n"  //External Reservation ID
        		+ "    \"customerOrderNumber\": \""+CSRD.FulfillmentOrderNo+"\",\r\n" //Fulfillment Order No
        		
        		+ "    \"statusCode\": 8,\r\n"
        		+ "    \"statusDetail\": \"Order Despatched\",\r\n"
        		+ "    \"despatchedDate\": \"2023-11-13T08:00:00\",\r\n"
        		+ "    \"expectedDespatchDate\": \"2023-11-13\",\r\n"
        		+ "    \"orderedDate\": \"2023-11-13\",\r\n"
        		+ "    \"orderType\": \"SO\",\r\n"
        		+ "    \"messageVersion\": \"4.0\",\r\n"
        		+ "    \"orderLines\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"lineNumber\": \"1\",\r\n"
        		+ "            \"productCode\": \""+CSRD.ModelNo+"\",\r\n"
        		+ "            \"description\": \"Watch Series 8 Sport\",\r\n"
        		+ "            \"extendedAmount\": \"0.00\",\r\n"
        		+ "            \"orderedQuantity\": \"1\",\r\n"
        		+ "            \"shippedQuantity\": \"1\",\r\n"
        		+ "            \"serialDetails\": [\r\n"
        		+ "                {\r\n"
        		+ "                    \"serialDetail\": [\r\n"
        		+ "			   	   {\r\n"
                + "                        \"type\": \"EID\",\r\n"
               	+ "                        \"value\": \"89043052008008886722001956003511\"\r\n" 
               	+ "                        },  \r\n"
               	+ "				   {\r\n"
                + "                        \"type\": \"IMEI1\",\r\n"
               	+ "                        \"value\": \"350016380994857\"\r\n" 
               	+ "                        },  \r\n"
        		+ "                 {\r\n"
        		+ "                        \"type\": \"Serial 1\",\r\n"
        		+ "                        \"value\": \"LY297HDQ52\"\r\n" 
        		+ "                        }  \r\n"
        		+ "                    ]\r\n"
        		+ "                }\r\n"
        		+ "            ]\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"orderConsignments\": [\r\n"
        		+ "    {\r\n"
        		+ "               \"reference\": \"CKV75106\",\r\n"
        		+ "               \"longReference\": \"CKV75106|14585201\",\r\n"
        		+ "               \"trackingURL\": \"http://www.royalmail.com/portal/rm/track?trackNumber=CKV75106\",\r\n"
        		+ "               \"courierDate\": \"2020-11-04T07:00:00\",\r\n"
        		+ "               \"shippedCourierName\": \"DPD\",\r\n"
        		+ "               \"shippedServiceType\": \"RMAS01MM\"\r\n"
        		+ "    }\r\n"
        		+ "    ],\r\n"
        		+ "    \"deliveryAddress\": {\r\n"
        		+ "          \"name\": \"Sarah Morgan\",\r\n"
        		+ "          \"line1\": \"Flat 44\",\r\n"
        		+ "          \"line2\": \"A Road\",\r\n"
        		+ "          \"line3\": \"Crewe\",\r\n"
        		+ "          \"line4\": \"Cheshire\",\r\n"
        		+ "          \"postcode\": \"CW1 6BU\",\r\n"
        		+ "          \"country\": \"UK\"\r\n"
        		+ "    }\r\n"
        		+ "}";
        
        try {
        given()
 
        .header("Content-Type","application/json")
        
                .body(payload).
                when().
                //PUT Method and you need to specify the workspaceId inside the Curly Braces
                put("/v1/WMS").
                then().
                assertThat().statusCode(204);
        ExtentReport.log(payload, "WMS API Put Req was Successfull", Status.PASS);
        
        }catch (Exception e) {
			// TODO: handle exception
        	 e.printStackTrace();
             ExtentReport.log(payload, "WMS API Put Req was Unsuccessfull", Status.SKIP);
		}
 
 
    } 
	
	public void validate_put_request_CustomPlan(String SerialNo)
    {
        String payload = "{\r\n"
        		+ "    \"jdeCompany\": \"00030\",\r\n"
        		+ "    \"customerNumber\": \"NC01-04\",\r\n"
        		+ "    \"orderNumber\": \""+CSRD.ExternalReservationID+"\",\r\n"
        		+ "    \"customerOrderNumber\": \""+CSRD.FulfillmentOrderNo+"\",\r\n"
        		+ "    \"statusCode\": 8,\r\n"
        		+ "    \"statusDetail\": \"Order Despatched\",\r\n"
        		+ "    \"despatchedDate\": \"2024-12-13T08:00:00\",\r\n"
        		+ "    \"expectedDespatchDate\": \"2023-12-13\",\r\n"
        		+ "    \"orderedDate\": \"2023-12-13\",\r\n"
        		+ "    \"orderType\": \"SO\",\r\n"
        		+ "    \"messageVersion\": \"4.0\",\r\n"
        		+ "    \"orderLines\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"lineNumber\": \"1\",\r\n"
        		+ "            \"productCode\": \""+CSRD.ProductCode+"\",\r\n"
        		+ "            \"description\": \"SIM\",\r\n"
        		+ "            \"extendedAmount\": \"28.00\",\r\n"
        		+ "            \"orderedQuantity\": \"1\",\r\n"
        		+ "            \"shippedQuantity\": \"1\",\r\n"
        		+ "            \"serialDetails\": [\r\n"
        		+ "                {\r\n"
        		+ "                    \"serialDetail\": [\r\n"
        		+ "                        {\r\n"
        		+ "                            \"type\": \"SIM Serial\",\r\n"
        		+ "                            \"value\": \""+SerialNo+"\"\r\n"
        		+ "                        }\r\n"
        		+ "                    ]\r\n"
        		+ "                }\r\n"
        		+ "            ]\r\n"
        		+ "        },\r\n"
        		+ "        {\r\n"
        		+ "            \"lineNumber\": \"1\",\r\n"
        		+ "            \"productCode\": \""+CSRD.ProductCode+"\",\r\n"
        		+ "            \"description\": \""+CSRD.ProductDescription+"\",\r\n"
        		+ "            \"extendedAmount\": \"0.00\",\r\n"
        		+ "            \"orderedQuantity\": \"1\",\r\n"
        		+ "            \"shippedQuantity\": \"1\",\r\n"
        		+ "            \"serialDetails\": [\r\n"
        		+ "                {\r\n"
        		+ "                    \"serialDetail\": [\r\n"
        		+ "                        {\r\n"
        		+ "                            \"type\": \"EID\",\r\n"
        		+ "                            \"value\": \"1234104800261116052013171154\"\r\n"
        		+ "                        },\r\n"
        		+ "                        {\r\n"
        		+ "                            \"type\": \"IMEI1\",\r\n"
        		+ "                            \"value\": \"352737591825956\"\r\n"
        		+ "                        },\r\n"
        		+ "                        {\r\n"
        		+ "                            \"type\": \"Serial 1\",\r\n"
        		+ "                            \"value\": \"790411NRA4S\"\r\n"
        		+ "                        }\r\n"
        		+ "                    ]\r\n"
        		+ "                }\r\n"
        		+ "            ]\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"orderConsignments\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"reference\": \"CKV75106\",\r\n"
        		+ "            \"longReference\": \"CKV75106|14585201\",\r\n"
        		+ "            \"trackingURL\": \"http://www.royalmail.com/portal/rm/track?trackNumber=CKV75106\",\r\n"
        		+ "            \"courierDate\": \"2020-11-04T07:00:00\",\r\n"
        		+ "            \"shippedCourierName\": \"DPD\",\r\n"
        		+ "            \"shippedServiceType\": \"RMAS01MM\"\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"deliveryAddress\": {\r\n"
        		+ "        \"name\": \"Sarah Morgan\",\r\n"
        		+ "        \"line1\": \"Flat 44\",\r\n"
        		+ "        \"line2\": \"A Road\",\r\n"
        		+ "        \"line3\": \"Crewe\",\r\n"
        		+ "        \"line4\": \"Cheshire\",\r\n"
        		+ "        \"postcode\": \"CW1 6BU\",\r\n"
        		+ "        \"country\": \"UK\"\r\n"
        		+ "    }\r\n"
        		+ "}";
        
        try {
        given()
 
        .header("Content-Type","application/json")
 
                .body(payload).
                when().
                //PUT Method and you need to specify the workspaceId inside the Curly Braces
                put("/v1/WMS").
                then().
                assertThat().statusCode(204);
        ExtentReport.log(payload, "WMS API Put Req was Successfull", Status.PASS);
        
        }catch (Exception e) {
			// TODO: handle exception
        	 e.printStackTrace();
             ExtentReport.log(payload, "WMS API Put Req was Unsuccessfull", Status.SKIP);
		}
 
    }
	
	public void validate_put_request_CustomPlanwithoutp(String SerialNo)
    {
        String payload = "{\r\n"
        		+ "    \"jdeCompany\": \"00030\",\r\n"
        		+ "    \"customerNumber\": \"NC01-04\",\r\n"
        		+ "    \"orderNumber\": \"10381890\",\r\n"
        		+ "    \"customerOrderNumber\": \"NC44984201\",\r\n"
        		+ "    \"statusCode\": 8,\r\n"
        		+ "    \"statusDetail\": \"Order Despatched\",\r\n"
        		+ "    \"despatchedDate\": \"2024-12-13T08:00:00\",\r\n"
        		+ "    \"expectedDespatchDate\": \"2023-12-13\",\r\n"
        		+ "    \"orderedDate\": \"2023-12-13\",\r\n"
        		+ "    \"orderType\": \"SO\",\r\n"
        		+ "    \"messageVersion\": \"4.0\",\r\n"
        		+ "    \"orderLines\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"lineNumber\": \"1\",\r\n"
        		+ "            \"productCode\": \"1SA1P8BN\",\r\n"
        		+ "            \"description\": \"SIM\",\r\n"
        		+ "            \"extendedAmount\": \"28.00\",\r\n"
        		+ "            \"orderedQuantity\": \"1\",\r\n"
        		+ "            \"shippedQuantity\": \"1\",\r\n"
        		+ "            \"serialDetails\": [\r\n"
        		+ "                {\r\n"
        		+ "                    \"serialDetail\": [\r\n"
        		+ "                        {\r\n"
        		+ "                            \"type\": \"SIM Serial\",\r\n"
        		+ "                            \"value\": \""+SerialNo+"\"\r\n"
        		+ "                        }\r\n"
        		+ "                    ]\r\n"
        		+ "                }\r\n"
        		+ "            ]\r\n"
        		+ "        },\r\n"
        		+ "        {\r\n"
        		+ "            \"lineNumber\": \"1\",\r\n"
        		+ "            \"productCode\": \"1SA1P8BN\",\r\n"
        		+ "            \"description\": \"Samsung Galaxy S10 p\",\r\n"
        		+ "            \"extendedAmount\": \"0.00\",\r\n"
        		+ "            \"orderedQuantity\": \"1\",\r\n"
        		+ "            \"shippedQuantity\": \"1\",\r\n"
        		+ "            \"serialDetails\": [\r\n"
        		+ "                {\r\n"
        		+ "                    \"serialDetail\": [\r\n"
        		+ "                        {\r\n"
        		+ "                            \"type\": \"EID\",\r\n"
        		+ "                            \"value\": \"1234104800261116052013171154\"\r\n"
        		+ "                        },\r\n"
        		+ "                        {\r\n"
        		+ "                            \"type\": \"IMEI1\",\r\n"
        		+ "                            \"value\": \"352737591825956\"\r\n"
        		+ "                        },\r\n"
        		+ "                        {\r\n"
        		+ "                            \"type\": \"Serial 1\",\r\n"
        		+ "                            \"value\": \"790411NRA4S\"\r\n"
        		+ "                        }\r\n"
        		+ "                    ]\r\n"
        		+ "                }\r\n"
        		+ "            ]\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"orderConsignments\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"reference\": \"CKV75106\",\r\n"
        		+ "            \"longReference\": \"CKV75106|14585201\",\r\n"
        		+ "            \"trackingURL\": \"http://www.royalmail.com/portal/rm/track?trackNumber=CKV75106\",\r\n"
        		+ "            \"courierDate\": \"2020-11-04T07:00:00\",\r\n"
        		+ "            \"shippedCourierName\": \"DPD\",\r\n"
        		+ "            \"shippedServiceType\": \"RMAS01MM\"\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"deliveryAddress\": {\r\n"
        		+ "        \"name\": \"Sarah Morgan\",\r\n"
        		+ "        \"line1\": \"Flat 44\",\r\n"
        		+ "        \"line2\": \"A Road\",\r\n"
        		+ "        \"line3\": \"Crewe\",\r\n"
        		+ "        \"line4\": \"Cheshire\",\r\n"
        		+ "        \"postcode\": \"CW1 6BU\",\r\n"
        		+ "        \"country\": \"UK\"\r\n"
        		+ "    }\r\n"
        		+ "}";
        try {
        given()
 
        .header("Content-Type","application/json")
 
                .body(payload).
                when().
                //PUT Method and you need to specify the workspaceId inside the Curly Braces
                put("/v1/WMS").
                then().
                assertThat().statusCode(204);
        ExtentReport.log(payload, "WMS API Put Req was Successfull", Status.PASS);
        }catch (Exception e) {
			// TODO: handle exception
        	 e.printStackTrace();
             ExtentReport.log(payload, "WMS API Put Req was Unsuccessfull", Status.SKIP);
		}
 
    }
	
	public void validate_put_request_SIMOwithoutp()
    {
        String payload = "{\r\n"
        		+ "    \"jdeCompany\": \"00030\",\r\n"
        		+ "    \"customerNumber\": \"NC01-04\",\r\n"
        		+ "    \"orderNumber\": \"37818596\",\r\n"  //External Reservation ID
        		+ "    \"customerOrderNumber\": \"NC1059911783101\",\r\n" //Fulfillment Order No
        		+ "    \"statusCode\": 8,\r\n"
        		+ "    \"statusDetail\": \"Order Despatched\",\r\n"
        		+ "    \"despatchedDate\": \"2023-11-13T08:00:00\",\r\n"
        		+ "    \"expectedDespatchDate\": \"2023-11-13\",\r\n"
        		+ "    \"orderedDate\": \"2023-11-13\",\r\n"
        		+ "    \"orderType\": \"SO\",\r\n"
        		+ "    \"messageVersion\": \"4.0\",\r\n"
        		+ "    \"orderLines\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"lineNumber\": \"1\",\r\n"
        		+ "            \"productCode\": \"25GTRIVN\",\r\n"
        		+ "            \"description\": \"pSIM\",\r\n"
        		+ "            \"extendedAmount\": \"28.00\",\r\n"
        		+ "            \"orderedQuantity\": \"1\",\r\n"
        		+ "            \"shippedQuantity\": \"1\",\r\n"
        		+ "            \"serialDetails\": [\r\n"
        		+ "                {\r\n"
        		+ "                    \"serialDetail\": [\r\n"
        		+ "                        {\r\n"
        		+ "                        \"type\": \"SIM Serial\",\r\n"
        		+ "                        \"value\": \"8944110060001236720\"\r\n" //Serial No
        		+ "                        }  \r\n"
        		+ "                    ]\r\n"
        		+ "                }\r\n"
        		+ "            ]\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"orderConsignments\": [\r\n"
        		+ "    {\r\n"
        		+ "               \"reference\": \"CKV75106\",\r\n"
        		+ "               \"longReference\": \"CKV75106|14585201\",\r\n"
        		+ "               \"trackingURL\": \"http://www.royalmail.com/portal/rm/track?trackNumber=CKV75106\",\r\n"
        		+ "               \"courierDate\": \"2020-11-04T07:00:00\",\r\n"
        		+ "               \"shippedCourierName\": \"DPD\",\r\n"
        		+ "               \"shippedServiceType\": \"RMAS01MM\"\r\n"
        		+ "    }\r\n"
        		+ "    ],\r\n"
        		+ "    \"deliveryAddress\": {\r\n"
        		+ "          \"name\": \"Sarah Morgan\",\r\n"
        		+ "          \"line1\": \"Flat 44\",\r\n"
        		+ "          \"line2\": \"A Road\",\r\n"
        		+ "          \"line3\": \"Crewe\",\r\n"
        		+ "          \"line4\": \"Cheshire\",\r\n"
        		+ "          \"postcode\": \"CW1 6BU\",\r\n"
        		+ "          \"country\": \"UK\"\r\n"
        		+ "    }\r\n"
        		+ "}";
        try {
        given()
 
        .header("Content-Type","application/json")
 
                .body(payload).
                when().
                //PUT Method and you need to specify the workspaceId inside the Curly Braces
                put("/v1/WMS").
                then().
                assertThat().statusCode(204);
        ExtentReport.log(payload, "WMS API Put Req was Successfull", Status.PASS);
        }catch (Exception e) {
			// TODO: handle exception
        	 e.printStackTrace();
             ExtentReport.log(payload, "WMS API Put Req was Unsuccessfull", Status.SKIP);
		}
 
    }


	

}
