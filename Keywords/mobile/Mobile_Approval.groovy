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

public class Mobile_Approval {
	
	
	

	
	@Keyword
	def approval_Function_For_Registration ()
	
	{
		
		CustomKeywords.'mobile.Helper_Functions.Mobile_Relaunch_Function'()
		
		Mobile.delay(5) 
		
		CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Pre home Page")
		
		
//		CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(findTestObject('Object Repository/Mobile Locators/Home/back_Btn'))
			
//		CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(findTestObject('Object Repository/Mobile Locators/Home/Eng_Btn'))

		
		CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(findTestObject('Object Repository/Mobile Locators/Home/SecureTac_Home_Btn'))
		
		CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Approved Page")
		
		Mobile.delay(3)
		
		
		TestObject ApproveBtn = findTestObject('Object Repository/Mobile Locators/Home/Secure_approve_Btn')
		
		if (Mobile.waitForElementPresent(ApproveBtn, 10, FailureHandling.STOP_ON_FAILURE)) {
		
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Approve Button is available")
		
			Mobile.delay(1)
			
			Mobile.tapAtPosition(775, 2018)
			
			
			Mobile.comment("Approved button clicked")
			

//			//Assertion
//			TestObject assertMessage =
//				findTestObject('Object Repository/Mobile Locators/Home/Assert_Message')
//			
//			CustomKeywords.'mobile.Helper_Functions.verifyMessage'(assertMessage, 
//			"Your i-Akaun Secure authorisation has been approved")
				
		
		} 
		
		else {
		
			Mobile.comment("Approved button not visible")
		
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Secure Tac Approve Button is not available")
		}
		
		
		
	}
		
		
	
	
	
	
	

}
