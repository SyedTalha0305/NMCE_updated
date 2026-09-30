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

public class Trust_Device {

	
	@Keyword
	def TrustDevice () {
		
	
		// ========================
		// Term and Condition
		// ========================
		 
		WebUI.comment("Trust Device page is visible?")
		
		TestObject Trusttbn = findTestObject('Object Repository/Mobile Locators/Login/Trust Continue Button')
		
		
		// Handle optional accept button
		
		
		if (Mobile.waitForElementPresent(Trusttbn, 5, FailureHandling.OPTIONAL))
			
			{
			
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Trust Device Page is visible")
				
			CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(Trusttbn)
			
			WebUI.comment("Continue button clicked")
			
		}
		else
		{
			WebUI.comment("Trust button is not visible, continue")
			
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Trust Button Page is not available")
			
		}
		
	}
	
	
}
