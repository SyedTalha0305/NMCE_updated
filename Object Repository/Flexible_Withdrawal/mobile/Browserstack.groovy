package mobile

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
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import java.text.SimpleDateFormat
import com.kms.katalon.core.configuration.RunConfiguration


public class Browserstack {
	@Keyword
	def connectToBrowserStackApp(String sessionName) {

		DesiredCapabilities caps = new DesiredCapabilities()

		// Platform
		caps.setCapability("platformName", "Android")

		//		// App
		//		caps.setCapability("appium:app", GlobalVariable.BrowserStack_AppId)

		// App
		caps.setCapability("appium:app", "bs://8805e5be1afe945a9c25d89e2ea1bb1f65481652")
		//caps.setCapability("appium:app", "bs://688f977497fb2bcab95b90864d025c2eb7e2d31e")
		//caps.setCapability("appium:app", "bs://2c1517a1c61bc1ddcd823397a2ae1777cd3ed254")
		
		// Device
		caps.setCapability("appium:deviceName", "Samsung Galaxy S24 Ultra")
		caps.setCapability("appium:platformVersion", "14.0")

		//		// Enable camera injection
		//		caps.setCapability("browserstack.enableCameraImageInjection", true)
		//
		//		// Upload passport image
		//		caps.setCapability("browserstack.uploadMedia", [
		//			"media://passport_passport_image"
		//		])

		// Automation Name
		caps.setCapability("appium:automationName", "UiAutomator2")

		// Permissions
		caps.setCapability("appium:autoGrantPermissions", true)

		// Stability
		caps.setCapability("appium:newCommandTimeout", 40)

		// BrowserStack options
		Map<String, Object> bstackOptions = new HashMap<>()

		bstackOptions.put("userName", GlobalVariable.Username)
		bstackOptions.put("accessKey", GlobalVariable.Accesskey)
		
		String projectName = "Migrant Worker"
		def dateFormat = new SimpleDateFormat("yyyyMMdd_hhmm_a")
		String timestamp = dateFormat.format(new Date())
		
		bstackOptions.put("projectName", projectName)
		//bstackOptions.put("buildName", "${projectName} Regression - ${timestamp}")
		bstackOptions.put("buildName", "[Regression] NMCE FA Withdrawal (>3K)")
		bstackOptions.put("sessionName", sessionName)
		//bstackOptions.put("sessionName", RunConfiguration.getExecutionSourceName())


		caps.setCapability("bstack:options", bstackOptions)

		// Driver
		URL url = new URL("https://hub-cloud.browserstack.com/wd/hub")

		AndroidDriver driver = new AndroidDriver(url, caps)

		MobileDriverFactory.setDriver(driver)
	}
}
