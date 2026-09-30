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

public class resultValidation {
	
	@Keyword
	def validateSuccessMessage(TestObject to,String expectedMessage)
	{
		
		// To validate the expected message with actual message
		Mobile.verifyElementText(to, expectedMessage)
		
		//Scroll and click the done button
		CustomKeywords.'mobile.common.scrollToElementAndClick'(findTestObject('Flexible_Withdrawal/resultPage/resultPageDone'))
	}
	
	@Keyword
	def validateErrorMessage(TestObject to,String expectedMessage)
	{
		// To validate the expected message with actual message
		String actualMessage = Mobile.getText(to, 5)
		
		assert actualMessage.contains(expectedMessage)
		
		//Scroll and click the ok button
		CustomKeywords.'mobile.common.scrollToElementAndClick'(findTestObject('Flexible_Withdrawal/resultPage/errorMessageOk'))
	}
}
