package web

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory

import CustomKeywords
import internal.GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

public class Login {
	
	
	
	public static WebDriver savedWebDriver
	
	@Keyword
	def BrowserStack_Sessions() {

		System.setProperty("webdriver.remote.enableTracing", "false")

		DesiredCapabilities caps = new DesiredCapabilities()

		caps.setCapability("browserName", "Chrome")
		caps.setCapability("browserVersion", "latest")

		Map<String, Object> bstackOptions = new HashMap<>()

		// Platform
		bstackOptions.put("os", "Windows")
		bstackOptions.put("osVersion", "11")

		// BrowserStack Credentials
		bstackOptions.put("userName", "syedtalhaghayas_0WAaH9")
		bstackOptions.put("accessKey", "XQsW5razqszt28Nf4rsm")
		
		// Project Details
		bstackOptions.put("projectName", "SecureTac")
		bstackOptions.put("buildName", "Regression Cases [SecureTac]")
		bstackOptions.put("sessionName", "Web Automation")

		// Debugging
		bstackOptions.put("debug", true)
		bstackOptions.put("networkLogs", true)
		bstackOptions.put("consoleLogs", "info")

//      Enable ONLY if alpha is an internal/private environment
//		bstackOptions.put("local", true)

		caps.setCapability("bstack:options", bstackOptions)

		WebDriver driver = new RemoteWebDriver(
				new URL("https://hub.browserstack.com/wd/hub"),
				caps
		)

		DriverFactory.changeWebDriver(driver)

		// Maximize browser
		driver.manage().window().maximize()
	}
	
	
	//Function only for BrowserStack run
	
//	@Keyword
//	def LoginFlow(String USERNAME, String PASSWORD) {
//	
//		// Create BrowserStack session
//		BrowserStack_Sessions()
//	
//		// Open application inside BrowserStack browser
//		WebUI.navigateToUrl(GlobalVariable.URL)
//	
//		// Wait for the page to fully load (timeout: 12 seconds)
//		WebUI.waitForPageLoad(10)
//		
//	//	Click on Bahasa Melayu (BM) language button (or relevant option)
//		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
//			findTestObject('Object Repository/Web locators/Login/button_BM')
//		)
//		
//		CustomKeywords.'web.Helper_Functions.step_screenshot'("Language")
//		
//		// Wait for the page to reload after language selection
//		WebUI.waitForPageLoad(4)
//		
//		CustomKeywords.'web.Helper_Functions.step_screenshot'("Before Login")
//		
//		// Enter username into the username input field
//		WebUI.setText(findTestObject('Web locators/Login/input_Next_userId'), USERNAME)
//		
//		
//		// Click on the "Log in" button after entering username
//		WebUI.click(findTestObject('Web locators/Login/button_Log in'))
//		
//		CustomKeywords.'web.Helper_Functions.step_screenshot'("Insert passowrd")
//		
//		// Confirm identity by clicking "Yes, That's Me"
//		WebUI.click(findTestObject('Web locators/Login/button_Yes, Thats Me'))
//		
//		// Enter password into the password input field
//		WebUI.setText(findTestObject('Web locators/Login/input_EN_userPassword'), PASSWORD)
//		
//		CustomKeywords.'web.Helper_Functions.step_screenshot'("Password inserted")
//		
//		// Click on the password field (optional: may be used to trigger UI events)
//		WebUI.click(findTestObject('Web locators/Login/input_EN_userPassword'))
//		
//		CustomKeywords.'web.Helper_Functions.step_screenshot'("click continue button")
//		
//		// Click on the "Continue" button to proceed after entering credentials
//		WebUI.click(findTestObject('Object Repository/Web locators/Login/button_Continue'))
//		
//		CustomKeywords.'web.Helper_Functions.step_screenshot'("User login Successfully")
//	}
	
	
	
	//Function for local run
	
	@Keyword
	def LoginFlow (String USERNAME, String PASSWORD)  {
		
		// Open a new browser instance
		WebUI.openBrowser('')
		
		// Maximize the browser window for better visibility
		WebUI.maximizeWindow()
		
//      WebUI.setViewPortSize(1920, 1080)
		
		// Navigate to the target URL stored in Global Variables
		WebUI.navigateToUrl(GlobalVariable.URL)
		
		// Wait for the page to fully load (timeout: 12 seconds)
		WebUI.waitForPageLoad(10)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Before Login")
		
//		// Click on Bahasa Melayu (BM) language button (or relevant option)
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Login/button_BM')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Language")
		
		// Wait for the page to reload after language selection
		WebUI.waitForPageLoad(5)
		
		// Enter username into the username input field
		WebUI.setText(findTestObject('Web locators/Login/input_Next_userId'), USERNAME)
		
		// Click on the "Log in" button after entering username
		WebUI.click(findTestObject('Web locators/Login/button_Log in'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Insert passowrd")
		
		// Confirm identity by clicking "Yes, That's Me"
		WebUI.click(findTestObject('Web locators/Login/button_Yes, Thats Me'))
		
		// Enter password into the password input field
		WebUI.setText(findTestObject('Web locators/Login/input_EN_userPassword'), PASSWORD)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Password inserted")
		
		// Click on the password field (optional: may be used to trigger UI events)
		WebUI.click(findTestObject('Web locators/Login/input_EN_userPassword'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("click continue button")
		
		// Click on the "Continue" button to proceed after entering credentials
		WebUI.click(findTestObject('Object Repository/Web locators/Login/button_Continue'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("User login Successfully")
		

		
	}
	
	
	@Keyword
	def SaveSession() {

		savedWebDriver = DriverFactory.getWebDriver()

		WebUI.comment("Web session saved successfully")
		println("Saved Driver: " + savedWebDriver)
	}

	@Keyword
	def Session_Remains() {

		// Use saved driver if available
		if (savedWebDriver != null) {

			DriverFactory.changeWebDriver(savedWebDriver)

			WebUI.comment("Saved web session restored successfully")

		} else {

			// Fallback to current driver if browser is still alive
			WebDriver currentDriver = DriverFactory.getWebDriver()

			if (currentDriver != null) {

				DriverFactory.changeWebDriver(currentDriver)

				WebUI.comment("Using existing web session")
				
				WebUI.delay(4)
				
				CustomKeywords.'web.Helper_Functions.step_screenshot'("Success PAge")
				
				// click the done button in success page
				CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/button_done'))
				
				CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked done button")
				
	

			} else {

				WebUI.comment("No web session available")
				return
			}
		}

		try {
			WebUI.switchToWindowIndex(0)
		} catch (Exception e) {
			WebUI.comment("Unable to switch window: " + e.getMessage())
		}
		
		
//		CustomKeywords.'web.Helper_Functions.verifyMessage'(
//			findTestObject('Object Repository/Web locators/Home/div_Your withdrawal was successfully submitted'),
//			"successfully")
		
		
		
	}
	
	
	
}
