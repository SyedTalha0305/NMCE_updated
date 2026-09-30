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

import CustomKeywords
import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

public class common {
	
	@Keyword
	def waitUptoCoolingPeriodAndRelogin(String password)
	{
		AppiumDriver driver = MobileDriverFactory.getDriver()
		
		for (int i = 0; i < 7; i++) {
			Mobile.delay(10)
			driver.getPageSource()
		}
		driver.activateApp("com.epf.mip.uat")
		
	
		// Login screen
		TestObject withdrawalMenu = findTestObject('Flexible_Withdrawal/homePage/withdrawalMenu')
	
		Mobile.waitForElementPresent(withdrawalMenu, 20)
		Mobile.tap(withdrawalMenu, 0)
		
//		Mobile.delay(20)
	
		TestObject passwordField = findTestObject('Flexible_Withdrawal/loginPage/undefinedPassword')
	
		Mobile.waitForElementPresent(passwordField, 20)
		Mobile.setText(passwordField, password, 0)
	
		Mobile.pressBack()
	
//		Mobile.delay(25)
	
		TestObject continueBtn = findTestObject('Flexible_Withdrawal/loginPage/undefined_password_continue')
	
		Mobile.waitForElementPresent(continueBtn, 10)
		Mobile.tap(continueBtn, 0)
		Mobile.delay(2)
		
		//Check terms and conditions is available or not. If it is visible, click continue button otherwise proceed to next step.
		boolean termsAndCondition = Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/loginPage/termAndConditions'),5,FailureHandling.OPTIONAL)
		
		if (termsAndCondition)
		{
		
			Mobile.tap(findTestObject('Flexible_Withdrawal/loginPage/termAndConditions'),0)
		
			println("popup handled")
		
		} else {
		
			println("Popup not displayed, continuing execution")
		}
		
		//Check withdrawal menu popup is available or not. If it is visible, click continue button otherwise proceed to next step.
		boolean withdrawalMenuPopup = Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/homePage/withdrawalMenu_Popup'),5,FailureHandling.OPTIONAL)
		
		if (withdrawalMenuPopup)
		{
		
			Mobile.tap(findTestObject('Flexible_Withdrawal/homePage/withdrawalMenu_Popup'),0)
		
			println("popup handled")
		
		} else {
		
			println("Popup not displayed, continuing execution")
		}
		
		CustomKeywords.'mobile.homePage.guidedTour'()
		
	}
	
	@Keyword
	def scrollToElementAndClick(TestObject to)
	{
		int width = Mobile.getDeviceWidth()
		int height = Mobile.getDeviceHeight()
		
		int startX = width / 2
		int startY = (int)(height * 0.8)
		int endY   = (int)(height * 0.3)
		
		for (int i = 0; i < 10; i++)
		{
			if (Mobile.waitForElementPresent(to, 2, FailureHandling.OPTIONAL))
			{
				//Mobile.delay(3)
				Mobile.tap(to, 10)
				break
			}
		
			Mobile.swipe(startX, startY, startX, endY)
			Mobile.delay(1)
		}

	}
	
	@Keyword
	def scrollToElementAndClickOnceEnabled(TestObject to)
	{
		int width = Mobile.getDeviceWidth()
		int height = Mobile.getDeviceHeight()
	
		int startX = width / 2
		int startY = (int)(height * 0.8)
		int endY   = (int)(height * 0.3)
		
		for (int i = 0; i < 10; i++)
		{
			boolean isPresent = Mobile.verifyElementExist(to, 1, FailureHandling.OPTIONAL)
		
			if (isPresent)
			{
				// check enabled state
				String enabled = Mobile.getAttribute(to, 'enabled', 1)
		
				if (enabled == 'true')
				{
					Mobile.tap(to, 10)
					break
				}
			}
			
			Mobile.swipe(startX, startY, startX, endY)
			Mobile.delay(1)
		}
	}
}
