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

public class PreLoginSetups {
	
	@Keyword
	def handlePreLogin(String nickname)
	{

		//skip intro page
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/preLoginPage/skip'),10)
		Mobile.tap(findTestObject('Flexible_Withdrawal/preLoginPage/skip'),10)
		
		//Enter Nick name
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/preLoginPage/nickname'),10)
		Mobile.setText(findTestObject('Flexible_Withdrawal/preLoginPage/nickname'),nickname,10)
		Mobile.pressBack()
		
		//Agree and Proceed
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/preLoginPage/Agree and proceed button'),10)
		Mobile.tap(findTestObject('Flexible_Withdrawal/preLoginPage/Agree and proceed button'),10)
		
//		// language handle
//		TestObject languageicon = findTestObject('Flexible_Withdrawal/preLoginPage/language')
//		String language = Mobile.getText(languageicon, 5)
//		
//		if(language == 'BM')
//		{
//			Mobile.tap(languageicon, 5)
//		}
		
		// Login Button
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/preLoginPage/login_button_in_preloginpage'),10)
		Mobile.tap(findTestObject('Flexible_Withdrawal/preLoginPage/login_button_in_preloginpage'),10)
		
		// Continue Button
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/preLoginPage/continue_button'),10)
		Mobile.tap(findTestObject('Flexible_Withdrawal/preLoginPage/continue_button'),10)
	}
}
