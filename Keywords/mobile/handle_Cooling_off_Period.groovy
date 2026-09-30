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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.android.AndroidDriver

import CustomKeywords
import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

public class handle_Cooling_off_Period {
	
	@Keyword
	def handleCoolingOffPeriod(String PASSWORD , int coolingTimeInSeconds = 63) {
	
		TestObject SkipButton = 
	    findTestObject('Object Repository/Mobile Locators/Cooling off period/Skip')	
	
		TestObject okButton = 
		findTestObject('Object Repository/Mobile Locators/Cooling off period/OkayButton')
		
	
		if (Mobile.waitForElementPresent(SkipButton, 5)) {
	
			// Screenshot
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
				"Skip screen"
			)
	
			Mobile.comment("Cooling off screen detected")
	
			Mobile.tap(SkipButton, 5)
	
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
				"Cooling off period screen"
			)
	
			// Click OK
			Mobile.tap(okButton, 5)
	
			Mobile.comment("App moved to background")
	
			// Cooling wait
			Mobile.delay(coolingTimeInSeconds)
	
			// Reopen app safely
			AndroidDriver driver = MobileDriverFactory.getDriver()
	
			Map<String, Object> args = new HashMap<>()
	
			args.put(
				"intent",
				"com.epf.mip.uat/com.epf.mip.MainActivity"
			)
	
			driver.executeScript(
				"mobile: startActivity",
				args
			)
	
			Mobile.delay(5)
	
			Mobile.comment("App reopened")
			
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
				"Pre Login Home Page"
			)
			
			//
			
			CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Mobile Locators/Cooling off period/login banner btn')
			)
	
			// Screenshot
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
				"Enter Password"
			)
	
			// Enter password
			CustomKeywords.'mobile.Helper_Functions.setTextField'(
				findTestObject('Object Repository/Mobile Locators/Cooling off period/Update_Password'),
				PASSWORD
			)
			
			// Continue
			CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
				findTestObject('Object Repository/Mobile Locators/Cooling off period/Login Button')
				)
	
			Mobile.comment("Re-login completed")
		}
		else {
	
			Mobile.comment("No cooling off screen detected")
		}
	}
	
	@Keyword
	def handle_Optional_Popup_Function() {
		
		
		// ========================
		// Optional Pop up Function
		// ========================
		 
		WebUI.comment("Checking Confirm Optional popup is visible?")
		
		TestObject ConfirmBtn = findTestObject('Object Repository/Mobile Locators/Login/Confirm_Optional_Btn')
		
		// Handle optional Confirm button
		
		
		if (Mobile.waitForElementPresent(ConfirmBtn, 5, FailureHandling.OPTIONAL))
			
			{
			
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Confirm Optional Popup")
				
			CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(ConfirmBtn)
			
			WebUI.comment("Confirm button clicked")
			
		}
		else
		{
			WebUI.comment("Confirm button not visible, continue")
			
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Confirm button is not available")
			
		}
			
	}
	
	

	
//	@Keyword
//	def PreLogin_handleCoolingOffPeriod(int coolingTimeInSeconds = 63) {
//	
//		TestObject skipButton =
//				findTestObject('Object Repository/Mobile Locators/Cooling off period/Skip')
//	
//		TestObject okButton =
//				findTestObject('Object Repository/Mobile Locators/Cooling off period/OkayButton')
//	
//		// Verify Cooling-Off Screen
//		if (!Mobile.waitForElementPresent(skipButton, 5, FailureHandling.OPTIONAL)) {
//	
//			Mobile.comment("No cooling off screen detected")
//			return
//		}
//	
//		// Skip Screen
//		CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
//				"Skip screen"
//		)
//	
//		Mobile.comment("Cooling off screen detected")
//		Mobile.tap(skipButton, 5)
//	
//		CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
//				"Cooling off period screen"
//		)
//	
//		// Handle Guided Tour
//		try {
//	
//			CustomKeywords.'mobile.Guided_Tour.GuidedTour'()
//			Mobile.comment("Guided Tour handled")
//	
//		} catch (Exception e) {
//	
//			Mobile.comment("Guided Tour not available")
//		}
//	
//		// Handle Logout
//		try {
//	
//			CustomKeywords.'mobile.handle_Cooling_off_Period.Logout'()
//			Mobile.comment("Logout handled")
//	
//		} catch (Exception e) {
//	
//			Mobile.comment("Logout not available")
//		}
//	
//		// Handle OK Button
//		if (!Mobile.waitForElementPresent(okButton, 5, FailureHandling.OPTIONAL)) {
//	
//			Mobile.comment("OK button not found")
//			return
//		}
//	
//		Mobile.tap(okButton, 5)
//	
//		Mobile.comment(
//				"Cooling-off period started. Waiting ${coolingTimeInSeconds} seconds..."
//		)
//	
//		Mobile.delay(coolingTimeInSeconds)
//	
//		Mobile.comment("Cooling-off period completed")
//	}
//	
	
	
	@Keyword
	def PreLogin_handleCoolingOffPeriod(int coolingTimeInSeconds = 63) {
	
		TestObject skipButton =
			findTestObject('Object Repository/Mobile Locators/Cooling off period/Skip')
	
		TestObject okButton =
			findTestObject('Object Repository/Mobile Locators/Cooling off period/OkayButton')
	
		// Check if Cooling-Off screen exists
		if (Mobile.waitForElementPresent(skipButton, 5, FailureHandling.OPTIONAL)) {
	
			Mobile.comment("Cooling off screen detected")
	
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
				"Skip screen"
			)
	
			Mobile.tap(skipButton, 5)
	
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
				"Cooling off period screen"
			)
	
			if (Mobile.waitForElementPresent(okButton, 5, FailureHandling.OPTIONAL)) {
	
				Mobile.tap(okButton, 5)
	
				Mobile.comment(
					"Cooling-off period started. Waiting ${coolingTimeInSeconds} seconds..."
				)
	
				Mobile.delay(coolingTimeInSeconds)
	
				Mobile.comment("Cooling-off period completed")
			}
	
			// Stop here. Do NOT run Guided Tour or Logout
			return
		}
	
		// Cooling-Off screen not found
		Mobile.comment("No cooling off screen detected")
	
		
		
		CustomKeywords.'mobile.Guided_Tour.GuidedTour'()
		CustomKeywords.'mobile.handle_Cooling_off_Period.Logout'()
		
		
		
	}
	
	@Keyword
	def Logout() {
	
		TestObject LogoutButton =
		findTestObject('Object Repository/Mobile Locators/Home/Logout_Btn')
			
	
		if (Mobile.waitForElementPresent(LogoutButton, 5)) {
	
			// Screenshot
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
				"Logout Screen"
			)
			
			CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(LogoutButton)
	
			CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(findTestObject('Object Repository/Mobile Locators/Home/Yes_Btn_Logout'))
			
			CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(findTestObject('Object Repository/Mobile Locators/Home/Quit_Btn_Logout'))
			
			
			
		}
		
		else {
	
			Mobile.comment("No Logout screen detected")
		}
	}
	
	
	
	
	
	
}
