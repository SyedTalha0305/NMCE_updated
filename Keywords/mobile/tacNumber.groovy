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
import io.appium.java_client.AppiumDriver

public class tacNumber {
	@Keyword
	def updateTacNumber(String otp)
	{
		// Enter OTP
		TestObject tacButton = findTestObject('Flexible_Withdrawal/tacNumberPage/press_tac_number_1')
	
		for (int i = 0; i < otp.length(); i++) {
	
			Mobile.waitForElementPresent(tacButton, 10)
			Mobile.tap(tacButton, 0)
		}
		
		//Device linked popup
		boolean isPresent = Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/tacNumberPage/device_linked_messge_popup'),5,FailureHandling.OPTIONAL)
		
		if (isPresent)
		{
		
			Mobile.tap(findTestObject('Flexible_Withdrawal/tacNumberPage/device_linked_messge_popup'),0)
		
			println("New device linked popup handled")
		
		} else {
		
			println("Popup not displayed, continuing execution")
		}
	
	
		// Skip device linked message
		TestObject skipBtn = findTestObject('Flexible_Withdrawal/tacNumberPage/device_linked_message_skip')
	
		Mobile.waitForElementPresent(skipBtn, 10)
		Mobile.tap(skipBtn, 0)
	
		//cooling period okay button
		TestObject coolingOk = findTestObject('Flexible_Withdrawal/tacNumberPage/cooling_period_okey')
		Mobile.waitForElementPresent(coolingOk, 10)
		Mobile.delay(1)   // allow UI to stabilize
		Mobile.tap(findTestObject('Flexible_Withdrawal/tacNumberPage/cooling_period_okey'), 10)
		
		
	}
}
