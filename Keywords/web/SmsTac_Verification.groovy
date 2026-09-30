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

public class SmsTac_Verification {
	
	@Keyword
	def SmsTac_Verification_Function()
	{
		// click the sms tac method to approve the transaction
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/button_sms_tac'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked sms tac")
		
		// enter the otp password
		CustomKeywords.'web.Helper_Functions.setTextField'(findTestObject('Web locators/Age/input_smstac_otp_password'), '111111')
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Entered the otp")
		
		// click the continue button after entering the password
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/button_sms_tac_password_continue'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked sms tac otp page continue")
		
		// click the done button in success page 
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/button_done'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked done button")
		
	}
}
