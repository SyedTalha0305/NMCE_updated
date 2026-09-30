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

import internal.GlobalVariable

public class LogInPage {
	@Keyword
	def login(String USERNAME, String PASSWORD)
	{
	
		// Enter Username and click continue
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/loginPage/user_name_field'),10)
		Mobile.setText(findTestObject('Flexible_Withdrawal/loginPage/user_name_field'),USERNAME,10)
		Mobile.pressBack()
		Mobile.tap(findTestObject('Flexible_Withdrawal/loginPage/user_name_continue'),10)
		
		//click the "Yes that's me" popup
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/loginPage/yes_thats_me_button'),5)
		Mobile.tap(findTestObject('Flexible_Withdrawal/loginPage/yes_thats_me_button'),10)
		
		//Enter password and click continue
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/loginPage/password_field'),10)
		Mobile.setText(findTestObject('Flexible_Withdrawal/loginPage/password_field'),PASSWORD,10)
		Mobile.pressBack()
		Mobile.tap(findTestObject('Flexible_Withdrawal/loginPage/password_continue'),10)
		
		//Check terms and conditions is available or not. If it is visible, click continue button otherwise proceed to next step.
		boolean termsAndCondition = Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/loginPage/termAndConditions'),5,FailureHandling.OPTIONAL)
		
		if (termsAndCondition)
		{
		
			Mobile.tap(findTestObject('Flexible_Withdrawal/loginPage/termAndConditions'),0)
		
			println("New device detected popup handled")
		
		} else {
		
			println("Popup not displayed, continuing execution")
		}
		
		
		
		//Check new device detected screen is available or not. If it is visible, click continue button otherwise proceed to net step.
		boolean isPresent = Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/loginPage/new_device_detected_continue'),5,FailureHandling.OPTIONAL)
		
		if (isPresent)
		{
		
			Mobile.tap(findTestObject('Flexible_Withdrawal/loginPage/new_device_detected_continue'),0)
		
			println("New device detected popup handled")
		
		} else {
		
			println("Popup not displayed, continuing execution")
		}
		
		
		
	}
}
