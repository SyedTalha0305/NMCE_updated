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

public class Secure_Verification {
	
	
	
	@Keyword
	def SecureTac_Verify_Function () {
		
	
		// ========================
		// Secure Tac Verification
		// ========================
		 
		WebUI.comment("Secure Tac Verification page is visible?")
		
		TestObject SecureBtn = findTestObject('Object Repository/Web locators/Registration/button_Approve via i-Akaun Secure')
		
		// Handle optional accept button
		if (WebUI.waitForElementVisible(SecureBtn, 5, FailureHandling.OPTIONAL))
			{
			
			CustomKeywords.'web.Helper_Functions.step_screenshot'("Secure Tac Page")
				
			WebUI.click(SecureBtn)
			
			WebUI.comment("Approve button clicked")
			
		}
		else
		{
			WebUI.comment("Approve button not visible, continue remainig flow")
			
			CustomKeywords.'web.Helper_Functions.step_screenshot'("Secure Tac Page is not available")
			
			
		}
		
	}

	

}
