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

public class GuidedTour_Screens {
	

	
	
	@Keyword
	def GuidedTour() {
	
		// ========================
		// Guided Tour
		// ========================
	
		TestObject nextBtn = findTestObject('Object Repository/Web locators/Guided Tour/button_Next')
		TestObject doneBtn = findTestObject('Object Repository/Web locators/Guided Tour/button_Done')
	
		// Check if Guided Tour is available
		if (WebUI.waitForElementVisible(nextBtn, 5, FailureHandling.OPTIONAL)) {
	
			CustomKeywords.'web.Helper_Functions.step_screenshot'("Guided Tour screen")
	
			// Click Next button until Done button appears
			for (int i = 0; i < 3; i++) {
	
				if (WebUI.waitForElementVisible(nextBtn, 2, FailureHandling.OPTIONAL)) {
					WebUI.click(nextBtn)
					WebUI.delay(1)
				} else {
					break
				}
			}
	
			// Click Done button
			if (WebUI.waitForElementVisible(doneBtn, 5, FailureHandling.OPTIONAL)) {
	
				CustomKeywords.'web.Helper_Functions.step_screenshot'("Guided Tour finished")
	
				WebUI.click(doneBtn)
			}
	
		} else {
	
			WebUI.comment("Guided Tour is not displayed. Continue with other flow.")
	
	
		}
	}
	
	
	
	
	
	
	
	

}
