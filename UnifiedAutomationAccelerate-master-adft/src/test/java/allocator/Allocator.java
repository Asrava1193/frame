package allocator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONObject;
import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cognizant.framework.ExcelDataAccessforxlsm;
import com.cognizant.framework.FrameworkParameters;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.Settings;
import com.cognizant.framework.Util;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.MobileExecutionPlatform;
import com.cognizant.framework.selenium.ResultSummaryManager;
import com.cognizant.framework.selenium.SeleniumTestParameters;
import com.cognizant.framework.selenium.ToolName;

/**
 * Class to manage the batch execution of test scripts within the framework
 * 
 * @author Cognizant
 */
public class Allocator {
	private FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
	private Properties properties;
	private Properties mobileProperties;
	private ResultSummaryManager resultSummaryManager = ResultSummaryManager.getInstance();

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;
	private static KlovReporter klovReporter = new KlovReporter();

	/**
	 * The entry point of the test batch execution <br>
	 * Exits with a value of 0 if the test passes and 1 if the test fails
	 * 
	 * @param args
	 *            Command line arguments to the Allocator (Not applicable)
	 */
	public static void main(String[] args) {
		Allocator allocator = new Allocator();
		allocator.driveBatchExecution();
		//identityGETMethodCustomer();
	}

	public static String tokenGenPOSTMethod() {
		String jksFilePath = "C:\\Users\\thirums\\openssl-0.9.8k_X64\\bin\\key.jks";
		String jksPassword = "test123";
		String requestUrl = "https://sapim.ref.o2.co.uk/api/token";
		String accessToken = "";

		try {
			// Load the JKS file
			FileInputStream fis = new FileInputStream(jksFilePath);
			KeyStore keyStore = KeyStore.getInstance("JKS");
			keyStore.load(fis, jksPassword.toCharArray());
			fis.close();

			// Initialize KeyManagerFactory with the JKS file
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(keyStore, jksPassword.toCharArray());

			// Create SSL context with the JKS file and a custom TrustManager
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(kmf.getKeyManagers(), new TrustManager[]{trustManager}, new SecureRandom());

			// Set the default SSL context
			SSLContext.setDefault(sslContext);

			// Create a URL object
			URL url = new URL(requestUrl);

			// Open a connection
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			
			String reqBody = "grant_type=client_credentials& client_assertion_type=urn%3Aietf%3Aparams%3Aoauth%3Aclient-assertion-type%3Ajwt-bearer";
			//String basicAuth = new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			
			connection.setRequestMethod("POST");			
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("X-REQUESTING-USER", "SYSTEM");
			connection.setRequestProperty("X-CLIENT-TRANSACTION-ID", "d157648e-g7c4-yyxx-b25b-61e18d371032");
			connection.setRequestProperty ("Authorization", "Basic YWNjZWxlcmF0ZS10ZXN0LWF1dG9tYXRpb246cGEkJFcwckBkcmVmIyNA");
			connection.setDoOutput(true);
				
			 OutputStream os = connection.getOutputStream();
			 os.write(reqBody.getBytes());
			 os.flush();
			 os.close();
			 			
			// Send the request and get the response
			int responseCode = connection.getResponseCode();
			
			System.out.println("Code : " + responseCode);

			// Read the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Print the response
			System.out.println("Response: " + response.toString());
			
			JSONObject jsResponse = new JSONObject(response.toString());			
			System.out.println("Access Token is : " + jsResponse.getString("access_token"));
			accessToken = jsResponse.getString("access_token");			
			
			// Close the connection
			connection.disconnect();
			
			return accessToken;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
		
	}

	public static void identityGETMethodCustomer() {
		String jksFilePath = "C:\\Users\\thirums\\openssl-0.9.8k_X64\\bin\\key.jks";
		String jksPassword = "test123";
		String requestUrl = "https://sapim.ref.o2.co.uk/tuk/ref/apic/identity/v2/identity/identity-details?identifier=email&identifier_value=odoneq@mailto.plus";
		String accessToken = "";
		accessToken = tokenGenPOSTMethod();

		try {
			// Load the JKS file
			FileInputStream fis = new FileInputStream(jksFilePath);
			KeyStore keyStore = KeyStore.getInstance("JKS");
			keyStore.load(fis, jksPassword.toCharArray());
			fis.close();

			//Initialize KeyManagerFactory with the JKS file
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(keyStore, jksPassword.toCharArray());

			// Create SSL context with the JKS file and a custom TrustManager
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(kmf.getKeyManagers(), new TrustManager[]{trustManager}, new SecureRandom());

			// Set the default SSL context
			SSLContext.setDefault(sslContext);

			// Create a URL object
			URL url = new URL(requestUrl);

			// Open a connection
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			
			//String reqBody = "grant_type=client_credentials& client_assertion_type=urn%3Aietf%3Aparams%3Aoauth%3Aclient-assertion-type%3Ajwt-bearer";
			//String basicAuth = new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			
			connection.setRequestMethod("GET");			
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("X-IBM-CLIENT-ID", "18ea98153440c951e81f60c52aad90a4");
			connection.setRequestProperty("Accept", "application/json, application/*+json");			
			connection.setRequestProperty("X-REQUESTING-USER", "SYSTEM");
			connection.setRequestProperty("Host", "sapim.ref.o2.co.uk");
			connection.setRequestProperty("Content-Length", "0");
			connection.setRequestProperty("X-CLIENT-TRANSACTION-ID", "1909a7b5-7770-478a-9783-fefcb67ec7ab");
			connection.setRequestProperty("X-IBM-CLIENT-SECRET", "feebd760fb15ddc298bf0aca883770ea");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty ("Authorization", "Bearer " + accessToken);
			connection.setDoOutput(true);
				
			 //OutputStream os = connection.getOutputStream();
			 //os.write(reqBody.getBytes());
			 //os.flush();
			 //os.close();
			 			
			// Send the request and get the response
			int responseCode = connection.getResponseCode();
			
			System.out.println("Code : " + responseCode);

			// Read the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Print the response
			System.out.println("Response: " + response.toString());
			
			JSONObject jsResponse = new JSONObject(response.toString());			
			System.out.println("Customer Details are : " + jsResponse.getString("customer_contact_id"));
			accessToken = jsResponse.getString("customer_contact_id");	
			
			// Close the connection
			connection.disconnect();		
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void dcpPOSTmethodTransaction() {
		
	}
	
	// Custom TrustManager to bypass certificate verification
	private static X509TrustManager trustManager = new X509TrustManager() {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() 
		{
			return null;
		}
		public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType){}
		public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType){}
	};

	private void driveBatchExecution() {
		resultSummaryManager.setRelativePath();
		properties = Settings.getInstance();
		mobileProperties = Settings.getMobilePropertiesInstance();
		String runConfiguration;
		if (System.getProperty("RunConfiguration") != null) {
			runConfiguration = System.getProperty("RunConfiguration");
		} else {
			runConfiguration = properties.getProperty("RunConfiguration");
		}
		resultSummaryManager.initializeTestBatch(runConfiguration);

		int nThreads = Integer.parseInt(properties.getProperty("NumberOfThreads"));
		resultSummaryManager.initializeSummaryReport(nThreads);

		resultSummaryManager.setupErrorLog();

		generateExtentReports();

		int testBatchStatus = executeTestBatch(nThreads);

		resultSummaryManager.wrapUp(false);

		if (Boolean.parseBoolean(properties.getProperty("GenerateKlov"))) {
			extentReport.attachReporter(klovReporter);
		}

		extentReport.flush();

		resultSummaryManager.launchResultSummary();

		System.exit(testBatchStatus);
	}

	private int executeTestBatch(int nThreads) {
		List<SeleniumTestParameters> testInstancesToRun = getRunInfo(frameworkParameters.getRunConfiguration());
		ExecutorService parallelExecutor = Executors.newFixedThreadPool(nThreads);
		ParallelRunner testRunner = null;

		for (int currentTestInstance = 0; currentTestInstance < testInstancesToRun.size(); currentTestInstance++) {
			testRunner = new ParallelRunner(testInstancesToRun.get(currentTestInstance));
			parallelExecutor.execute(testRunner);

			if (frameworkParameters.getStopExecution()) {
				break;
			}
		}

		parallelExecutor.shutdown();
		while (!parallelExecutor.isTerminated()) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (testRunner == null) {
			return 0; // All tests flagged as "No" in the Run Manager
		} else {
			return testRunner.getTestBatchStatus();
		}
	}

	private List<SeleniumTestParameters> getRunInfo(String sheetName) {

		ExcelDataAccessforxlsm runManagerAccess = new ExcelDataAccessforxlsm(
				frameworkParameters.getRelativePath() + Util.getFileSeparator() + "src" + Util.getFileSeparator()
						+ "test" + Util.getFileSeparator() + "resources",
				"Run Manager");
		runManagerAccess.setDatasheetName(sheetName);

		runManagerAccess.setDatasheetName(sheetName);
		List<SeleniumTestParameters> testInstancesToRun = new ArrayList<SeleniumTestParameters>();
		String[] keys = { "Execute", "TestScenario", "TestCase", "TestInstance", "Description", "IterationMode",
				"StartIteration", "EndIteration", "TestConfigurationID" };
		List<Map<String, String>> values = runManagerAccess.getValues(keys);

		for (int currentTestInstance = 0; currentTestInstance < values.size(); currentTestInstance++) {

			Map<String, String> row = values.get(currentTestInstance);
			String executeFlag = row.get("Execute");

			if (executeFlag.equalsIgnoreCase("Yes")) {
				String currentScenario = row.get("TestScenario");
				String currentTestcase = row.get("TestCase");
				SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
				testParameters.setCurrentTestDescription(row.get("Description"));
				testParameters.setCurrentTestInstance("Instance" + row.get("TestInstance"));
				testParameters.setExtentReport(extentReport);
				testParameters.setExtentTest(extentTest);

				String iterationMode = row.get("IterationMode");
				if (!iterationMode.equals("")) {
					testParameters.setIterationMode(IterationOptions.valueOf(iterationMode));
				} else {
					testParameters.setIterationMode(IterationOptions.RUN_ALL_ITERATIONS);
				}

				String startIteration = row.get("StartIteration");
				if (!startIteration.equals("")) {
					testParameters.setStartIteration(Integer.parseInt(startIteration));
				}
				String endIteration = row.get("EndIteration");
				if (!endIteration.equals("")) {
					testParameters.setEndIteration(Integer.parseInt(endIteration));
				}
				String testConfig = row.get("TestConfigurationID");
				if (!"".equals(testConfig)) {
					getTestConfigValues(runManagerAccess, "TestConfigurations", testConfig, testParameters);
				}

				testInstancesToRun.add(testParameters);
				runManagerAccess.setDatasheetName(sheetName);
			}
		}
		return testInstancesToRun;
	}

	private void getTestConfigValues(ExcelDataAccessforxlsm runManagerAccess, String sheetName, String testConfigName,
			SeleniumTestParameters testParameters) {

		runManagerAccess.setDatasheetName(sheetName);
		int rowNum = runManagerAccess.getRowNum(testConfigName, 0, 1);

		String[] keys = { "TestConfigurationID", "ExecutionMode", "ToolName", "MobileExecutionPlatform",
				"MobileOSVersion", "DeviceName", "Browser", "BrowserVersion", "Platform", "PlatformVersion",
				"SeeTestPort" };
		Map<String, String> values = runManagerAccess.getValuesForSpecificRow(keys, rowNum);

		String executionMode = values.get("ExecutionMode");
		if (!"".equals(executionMode)) {
			testParameters.setExecutionMode(ExecutionMode.valueOf(executionMode));
		} else {
			testParameters.setExecutionMode(ExecutionMode.valueOf(properties.getProperty("DefaultExecutionMode")));
		}

		String toolName = values.get("ToolName");
		if (!"".equals(toolName)) {
			testParameters.setMobileToolName(ToolName.valueOf(toolName));
		} else {
			testParameters.setMobileToolName(ToolName.valueOf(mobileProperties.getProperty("DefaultMobileToolName")));
		}

		String executionPlatform = values.get("MobileExecutionPlatform");
		if (!"".equals(executionPlatform)) {
			testParameters.setMobileExecutionPlatform(MobileExecutionPlatform.valueOf(executionPlatform));
		} else {
			testParameters.setMobileExecutionPlatform(
					MobileExecutionPlatform.valueOf(mobileProperties.getProperty("DefaultMobileExecutionPlatform")));
		}

		String mobileOSVersion = values.get("MobileOSVersion");
		if (!"".equals(mobileOSVersion)) {
			testParameters.setmobileOSVersion(mobileOSVersion);
		}

		String deviceName = values.get("DeviceName");
		if (!"".equals(deviceName)) {
			testParameters.setDeviceName(deviceName);
		}

		String browser = values.get("Browser");
		if (!"".equals(browser)) {
			testParameters.setBrowser(Browser.valueOf(browser));
		} else {
			testParameters.setBrowser(Browser.valueOf(properties.getProperty("DefaultBrowser")));
		}

		String browserVersion = values.get("BrowserVersion");
		if (!"".equals(browserVersion)) {
			testParameters.setBrowserVersion(browserVersion);
		}

		String platform = values.get("Platform");
		if (!"".equals(platform)) {
			testParameters.setPlatform(Platform.valueOf(platform));
		} else {
			testParameters.setPlatform(Platform.valueOf(properties.getProperty("DefaultPlatform")));
		}

		String seeTestPort = values.get("SeeTestPort");
		if (!"".equals(seeTestPort)) {
			testParameters.setSeeTestPort(seeTestPort);
		} else {
			testParameters.setSeeTestPort(mobileProperties.getProperty("SeeTestDefaultPort"));
		}

		String platformVersion = values.get("PlatformVersion");
		if (!"".equals(platformVersion)) {
			testParameters.setPlatformVersion(platformVersion);
		}
	}

	private void generateExtentReports() {
		integrateWithKlov();
		htmlReporter = new ExtentHtmlReporter(resultSummaryManager.getReportPath() + Util.getFileSeparator()
				+ "Extent Result" + Util.getFileSeparator() + "ExtentReport.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Project Name", properties.getProperty("ProjectName"));
		extentReport.setSystemInfo("Framework", "CRAFT Maven");
		extentReport.setSystemInfo("Framework Version", "3.2");
		extentReport.setSystemInfo("Author", "Cognizant");

		htmlReporter.config().setDocumentTitle("CRAFT Extent Report");
		htmlReporter.config().setReportName("Extent Report for CRAFT");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	private void integrateWithKlov() {
		String dbHost = properties.getProperty("DBHost");
		String dbPort = properties.getProperty("DBPort");
		if (Boolean.parseBoolean(properties.getProperty("GenerateKlov"))) {
			klovReporter.initMongoDbConnection(dbHost, Integer.valueOf(dbPort));
			klovReporter.setProjectName(properties.getProperty("GenerateKlov"));
			klovReporter.setReportName("CRAFT Reports");
			klovReporter.setKlovUrl(properties.getProperty("KlovURL"));
		}
	}

}