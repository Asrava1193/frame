
package testscripts;

import org.testng.annotations.Test;

import com.cognizant.craft.DriverScript;
import com.cognizant.craft.TestConfigurations;
import com.cognizant.framework.selenium.SeleniumTestParameters;

public class EcommTestScenario extends TestConfigurations {

		@Test(dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
		public void TestForPhonePlan(SeleniumTestParameters testParameters) {

			testParameters.setCurrentTestDescription("Test for login with valid user credentials");

			DriverScript driverScript = new DriverScript(testParameters);
			driverScript.driveTestExecution();

			tearDownTestRunner(testParameters, driverScript);
		}
}