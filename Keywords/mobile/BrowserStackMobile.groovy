package mobile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver
import java.text.SimpleDateFormat
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.remote.DesiredCapabilities

public class BrowserStackMobile {
	
	
	@Keyword
	def connectToBrowserStackApp() {
	
		DesiredCapabilities caps = new DesiredCapabilities()
		
		// Platform
		caps.setCapability("platformName", "Android")
		
//		// App
//		caps.setCapability("appium:app", GlobalVariable.BrowserStack_AppId)
		
		// App
//		caps.setCapability("appium:app", "bs://c3985c1384a726ca85644fc7c25c6fd2a76e2f8a")  // Test1
		
		caps.setCapability("appium:app", "bs://6c74f683cc804055e63a7673709a8db2860db169")  // alpha
		
		
		// Device
		caps.setCapability("appium:deviceName", "Samsung Galaxy S24 Ultra")
		caps.setCapability("appium:platformVersion", "14.0")
		
		// Automation Name
		caps.setCapability("appium:automationName", "UiAutomator2")
		
		// Permissions
		caps.setCapability("appium:autoGrantPermissions", true)
		
		// Stability
		caps.setCapability("appium:newCommandTimeout", 500)
		
		// BrowserStack options
		Map<String, Object> bstackOptions = new HashMap<>()
		
		bstackOptions.put("userName", GlobalVariable.BrowserStack_userName)
		bstackOptions.put("accessKey", GlobalVariable.BrowserStack_accessKey)	
		bstackOptions.put("projectName", "Migrant Worker")
		bstackOptions.put("buildName", "Regression Cases [NMCE]")
		bstackOptions.put("sessionName", "Mobile Automation")
		
		caps.setCapability("bstack:options", bstackOptions)
		
		// Driver
		URL url = new URL("https://hub-cloud.browserstack.com/wd/hub")
		
		AndroidDriver driver = new AndroidDriver(url, caps)
		
		MobileDriverFactory.setDriver(driver)
	
	}

}
