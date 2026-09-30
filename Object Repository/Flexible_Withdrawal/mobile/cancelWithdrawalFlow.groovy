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

public class cancelWithdrawalFlow {
	
	@Keyword
	def cancelSubmittedWithdrawal()
	{
		Mobile.delay(5)
		//scroll and click the withdrawal records option in withdawal page
		CustomKeywords.'mobile.common.scrollToElementAndClick'(findTestObject('Flexible_Withdrawal/withdrawal_page/withdrawalRecords'))
		
//		//click the submitted record
//		Mobile.tap(findTestObject('Flexible_Withdrawal/withdrawalRecordPage/record'), 10)
		
		TestObject record = findTestObject('Flexible_Withdrawal/withdrawalRecordPage/record')
		
		Mobile.waitForElementPresent(record, 15)
		
		Mobile.verifyElementExist(record, 10)
		
		Mobile.tap(record, 10)
		
		//click the cancel withdrawal option
		CustomKeywords.'mobile.common.scrollToElementAndClick'(findTestObject('Flexible_Withdrawal/withdrawalRecordPage/cancelWithdrawalButton'))
		
		//Cancel application popup handle
		boolean isPresent = Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/withdrawalRecordPage/cancelApplicationPopup'),5,FailureHandling.OPTIONAL)
		
		if (isPresent)
		{
		
			Mobile.tap(findTestObject('Flexible_Withdrawal/withdrawalRecordPage/cancelApplicationPopup'),0)
		
			println("Setting aside savings popup handled")
		
		} else {
		
			println("Popup not displayed, continuing execution")
		}
		
		//click done
		CustomKeywords.'mobile.common.scrollToElementAndClick'(findTestObject('Flexible_Withdrawal/withdrawalRecordPage/cancelConfirmationDone'))
	}
}
