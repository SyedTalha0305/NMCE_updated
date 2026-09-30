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

import CustomKeywords
import internal.GlobalVariable

public class term_and_condition {
	
	
	@Keyword
	def TermsAndCondition () {
		
	
		// ========================
		// Term and Condition
		// ========================
		 
		WebUI.comment("Checking terms and condition page is visible?")
		
		TestObject acceptBtn = findTestObject('Web locators/Terms and Condition/button_Accept')
		
		// Handle optional accept button
		if (WebUI.waitForElementVisible(acceptBtn, 5, FailureHandling.OPTIONAL))
			{
			
			CustomKeywords.'web.Helper_Functions.step_screenshot'("Terms and Condition Page")
				
			WebUI.click(acceptBtn)
			
			WebUI.comment("Accept button clicked")
			
		} 
		else
		{
			WebUI.comment("Accept button not visible, continue")
			
			CustomKeywords.'web.Helper_Functions.step_screenshot'("Terms and Condition Page is not available")
		}
		
	}

}
