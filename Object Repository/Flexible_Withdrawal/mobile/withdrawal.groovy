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

public class withdrawal {

	@Keyword
	def clickFlexibleIcon() {
		// Click the flexible icon in withdrawal page
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/withdrawal_page/flexibleIcon'),10)
		Mobile.tap(findTestObject('Flexible_Withdrawal/withdrawal_page/flexibleIcon'),10)

		if(Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/resultPage/errorMessage'), 10)) {

			//CustomKeywords.'mobile.resultValidation.validateErrorMessage'(findTestObject('Flexible_Withdrawal/resultPage/errorMessage'),"Sorry, you are not eligible for e-Pengeluaran")
			CustomKeywords.'mobile.resultValidation.validateErrorMessage'(findTestObject('Flexible_Withdrawal/resultPage/errorMessage'),"Anda tidak layak untuk Pengeluaran Akaun Fleksibel")
			Mobile.tap(findTestObject('Flexible_Withdrawal/resultPage/errorMessageOk'),5,FailureHandling.OPTIONAL)
			return
		}

		//scroll to the withdrawal now button and click.
		CustomKeywords.'mobile.common.scrollToElementAndClick'(findTestObject('Flexible_Withdrawal/withdrawal_page/flexible_withdrawal_now_button'))

		//Setting aside the savings popup before withdrwal
		boolean isPresent = Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/withdrawal_page/setting_aside_savings_popup'),5,FailureHandling.OPTIONAL)

		if (isPresent) {

			Mobile.tap(findTestObject('Flexible_Withdrawal/withdrawal_page/setting_aside_savings_popup'),0)

			println("Setting aside savings popup handled")
		} else {

			println("Popup not displayed, continuing execution")
		}
	}


	@Keyword
	def enterAmountAndContinue(String amount) {
		// Enter the amount
		Mobile.setText(findTestObject('Flexible_Withdrawal/withdrawalAmountPage/amountField'), amount, 10)
		Mobile.pressBack()

		// Once enter the amount click continue
		Mobile.tap(findTestObject('Flexible_Withdrawal/withdrawalAmountPage/amountFieldContinue'), 5)
	}

	@Keyword
	def fillBankDetails(TestObject bankName, String accountNumber) {
		// Click the add new bank option
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/bankDetailsPage/addNewBank'), 5)
		Mobile.tap(findTestObject('Flexible_Withdrawal/bankDetailsPage/addNewBank'), 5)

		// click the bank dropdown
		Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/bankDetailsPage/bankSelectionDropdown'), 5)
		Mobile.tap(findTestObject('Flexible_Withdrawal/bankDetailsPage/bankSelectionDropdown'), 5)

		//Select the bank name
		//Mobile.tap(bankName, 5)
		CustomKeywords.'mobile.common.scrollToElementAndClick'(bankName)

		// Enter the account number
		Mobile.setText(findTestObject('Flexible_Withdrawal/bankDetailsPage/uobAccountNumber'), accountNumber , 0)
		Mobile.pressBack()

		// Click Continue in the bank page
		Mobile.tap(findTestObject('Flexible_Withdrawal/bankDetailsPage/bankPageContinue'), 0)
	}

	@Keyword
	def confirmationPage() {
		// Check the confirmation page and continue
		CustomKeywords.'mobile.common.scrollToElementAndClick'(findTestObject('Flexible_Withdrawal/confirmationPage/confirmationPageContinue'))
	}

	@Keyword
	def declarationPage() {
		//check and accept the declaration page
		CustomKeywords.'mobile.common.scrollToElementAndClickOnceEnabled'(findTestObject('Flexible_Withdrawal/declarationPage/declarationPageAccept'))
	}

	@Keyword
	def handleAuthorisationMethod(String method) {
		if(method == 'secureTac') {
			//click the approve via i Akaun secure tac
			if(Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/authorisationPage/approveViaSecureTac'), 5,FailureHandling.OPTIONAL))
			{
				Mobile.tap(findTestObject('Flexible_Withdrawal/authorisationPage/approveViaSecureTac'), 5)
			}
			else
			{
				println("secure tac or sms tac selection page disabled")
			}
			
			//e-Kyc self verification popup before withdrwal
			boolean isPresent = Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/authorisationPage/eKycVerificationPopup'),5,FailureHandling.OPTIONAL)

			if (isPresent) {

				Mobile.tap(findTestObject('Flexible_Withdrawal/authorisationPage/eKycVerificationPopup'),0)

				println("e-Kyc self verification popup handled")
			} else {

				println("Popup not displayed, continuing execution")
			}
		}
	}

	@Keyword
	def handleAuthenticationMethod(String method) {
		if(method == 'self') {
			// select self authentication method to proceed
			Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/authenticatonMethodsPage/selfAuthenticationMethod'), 5)
			Mobile.tap(findTestObject('Flexible_Withdrawal/authenticatonMethodsPage/selfAuthenticationMethod'), 5)

			//approve the secure authorisation
			Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/authorisationPage/approveSecureAuthorisation'), 5)
			Mobile.tap(findTestObject('Flexible_Withdrawal/authorisationPage/approveSecureAuthorisation'), 5)
		}
		else if(method == 'CIJ') {
			TestObject thumbPrint = findTestObject('Flexible_Withdrawal/authenticatonMethodsPage/thumbPrintMethod')

			if(Mobile.waitForElementPresent(thumbPrint, 10,FailureHandling.OPTIONAL))
			{
				Mobile.tap(thumbPrint, 10)
			}
	
			Mobile.delay(3)
			
			// RE-FETCH object fresh (prevents stale reference)
			TestObject approveBtn = findTestObject('Flexible_Withdrawal/authorisationPage/approveSecureAuthorisation')
			int retry = 3
			for (int i = 0; i < retry; i++) {
				try {
					//Mobile.tap(approveBtn, 10)
					Mobile.tapAtPosition(775, 2018)
					return
				}
				catch (Exception e) {
					println("Retry due to stale element: " + i)
					Mobile.delay(2)
				}
			}
		}
		else {
			println("Please use the valid authentication method - self or CIJ")
		}
	}

	@Keyword
	def clickWithdrawalCard() {
		CustomKeywords.'mobile.common.scrollToElementAndClick'(findTestObject('Flexible_Withdrawal/withdrawal_page/withdrawalCard'))

		if(Mobile.waitForElementPresent(findTestObject('Flexible_Withdrawal/withdrawal_page/error_message_code_H'), 10)) {

			//CustomKeywords.'mobile.resultValidation.validateErrorMessage'(findTestObject('Flexible_Withdrawal/resultPage/errorMessage'),"Sorry, you are not eligible for e-Pengeluaran")
			CustomKeywords.'mobile.resultValidation.validateErrorMessage'(findTestObject('Flexible_Withdrawal/withdrawal_page/error_message_code_H'),"Maaf, anda tidak layak untuk e-Pengeluaran")
			Mobile.tap(findTestObject('Flexible_Withdrawal/withdrawal_page/error_message_code_H_okay_button'),5,FailureHandling.OPTIONAL)
			return
		}
	}
}
