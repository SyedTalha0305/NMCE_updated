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

public class Guided_Tour {
	
	
	@Keyword
	def GuidedTour() {
	
		// ========================
		// Guided Tour
		// ========================
	
		TestObject guidedTourBtn = 
		
		findTestObject('Object Repository/Mobile Locators/Home/Guided Tour Next and Done Button')
		
	
		// Check if Guided Tour is available
		if (Mobile.waitForElementPresent(guidedTourBtn, 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Guided Tour Started")
	
			CustomKeywords.'mobile.Helper_Functions.clickMultiple'(guidedTourBtn, 5)
	
			CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Guided Tour Ended")
	
			Mobile.comment("Guided Tour completed successfully")
	
		} else {
	
			Mobile.comment("Guided Tour not displayed. Continuing normal flow.")
	
			
		}
	}
	
}
