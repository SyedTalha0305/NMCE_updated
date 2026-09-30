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

import internal.GlobalVariable
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import com.kms.katalon.core.webui.driver.DriverFactory

public class BrowserStack_Web_Config {
	
	
	@Keyword
	def startBrowserStackSession() {
	

		println("Step 1")
	
		MutableCapabilities caps = new MutableCapabilities()
	
		println("Step 2")
		
		println("Selenium Version = " +
			org.openqa.selenium.BuildInfo.class.package.implementationVersion)
		
		try {
			Class clazz = Class.forName(
				"io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk"
			)
		
			println("FOUND: " + clazz.getName())
		}
		catch (Throwable e) {
			println("NOT FOUND")
			e.printStackTrace()
		}
	
		caps.setCapability("browserName", "Chrome")
		caps.setCapability("browserVersion", "latest")
	
		println("Step 3")
	
		Map<String, Object> bstackOptions = new HashMap<>()
		bstackOptions.put("os", "Windows")
		bstackOptions.put("osVersion", "11")
		bstackOptions.put("projectName", "Secure TAC Web")
		bstackOptions.put("buildName", "Build 1")
		bstackOptions.put("sessionName", "Login Test")
	
		caps.setCapability("bstack:options", bstackOptions)
	
		println("Step 4")
	
		WebDriver driver = new RemoteWebDriver(
			new URL("https://hub-cloud.browserstack.com/wd/hub"),
			caps
		)
	
		println("Step 5")
	
//		DriverFactory.changeWebDriver(driver)
	
		println("Step 6")
	}
	

}
