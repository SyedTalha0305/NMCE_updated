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

public class Cancellation_Withdrawals {
	
	@Keyword
	def Cancel_Withdrawals_Function()
	{
		// click the withdrawal menu
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/span_Pengeluaran'))

		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked withdrawal menu")
		
		// click the withdrawal records option
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/div_withdrawal_records'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked withdrawal records")
		
		//click the withdrwal record which need to cancel
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/record'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked the record")
		
		//click the cancel withdrwal button
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/button_cancel_withdrawal'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked the cancel withdrawal button")
		
		// click okay
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/button_cancel_withdrawal_okay'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked the cancel withdrawal okay button")
		
		// click ok to navigate main page
		CustomKeywords.'web.Helper_Functions.clickWhenVisible'(findTestObject('Web locators/Age/button_success_page_okay'))
		
		CustomKeywords.'web.Helper_Functions.step_screenshot'("clicked okay in success page of cancel withdrawal")


	}
}
