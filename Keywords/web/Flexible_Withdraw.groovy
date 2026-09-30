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

public class Flexible_Withdraw {
	
	
	
	
	@Keyword
	def Flexible_Withdraw_Function() {
		
	
		
		// ========================
		// Flexible Withdrawal Flow
		// ========================
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Flexible Withdrawal Landing Screen")
		
		
		// ========================
		// Navigate to Withdrawal Section
		// ========================
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Education/span_Withdrawal')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Withdrawal Menu Opened")
		
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Education/button_Done')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Guided Tour Closed")
		
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Education/div_Withdraw')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Withdraw Section Opened")
		
		
		// ========================
		// Select Flexible Withdrawal
		// ========================
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/div_Akaun Fleksibel')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Flexible Withdrawal Option Selected")
		
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/button_Withdraw Now')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Withdraw Now Button Clicked")
		
		
		// ========================
		// Acknowledgement Popup
		// ========================
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/button_Okay')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Acknowledgement Popup Accepted")
		
		
		// ========================
		// Select Withdrawal Amount
		// ========================
		
//		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
//			findTestObject('Object Repository/Web locators/Flexible Withdraw/div_50')
//		)
		
		CustomKeywords.'web.Helper_Functions.ClickAndSetText'(
		findTestObject('Object Repository/Web locators/Flexible Withdraw/input_RM_appliedAmount'), "6000")
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Withdrawal Amount Selected")
		
		
		// ========================
		// Continue Withdrawal Process
		// ========================
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/button_Continue')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Continued After Amount Selection")
		
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/button_Done')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Withdrawal Information Acknowledged")
		
		
		// ========================
		// Use Another Bank Account
		// ========================
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/button_Withdrawal account')
		)
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/Existing Account_Object')
		)
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/button_Use Another Bank Account')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Use Another Bank Account Selected")
		
		
		// ========================
		// Enter Bank Details
		// ========================
			
		CustomKeywords.'web.Helper_Functions.selectDropdownOption'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/div_Select Bank'),
			findTestObject('Object Repository/Web locators/Flexible Withdraw/mat-option_UOB (M) BHD')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Bank Selected - UOB (M) BHD")
		
		String BankAcc = "34580020718"
		
		Mobile.comment("Bank Account: " + BankAcc)
		
		CustomKeywords.'web.Helper_Functions.ClickAndSetText'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/input_Select Your Bank_bankAccountNo'),
			BankAcc
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Bank Account Number Entered")
		
		
		// ========================
		// Confirm Bank Details
		// ========================
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/button_Continue (1)')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Continued After Bank Details")
		
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/button_Continue_1')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Withdrawal Confirmation Continued")
		
		
		// ========================
		// Final Submission
		// ========================
		
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Web locators/Flexible Withdraw/button_Continue_2')
		)
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("Flexible Withdrawal Successfully Submitted")
		

}

	
	
	

}
