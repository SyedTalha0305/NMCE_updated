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

public class Logout {
	
	@Keyword
	def LogoutFlow()
	{
		
		// click log out in home page
		WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight)', null)
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Logout/button_logout'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked the log out")
		
		//click logout okay button
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Logout/button_logout_okay'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked the log out okay button")
	}
}
