import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys





CustomKeywords.'mobile.Browserstack.connectToBrowserStackApp'("Verify Undetermined Resident Status (Resident Q) can withdraw amount exceeding RM3,000")
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Application Connected Successfully via BrowserStack")

CustomKeywords.'mobile.PreLoginSetups.handlePreLogin'("Testing")
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Pre-Login Setup Completed")

CustomKeywords.'mobile.LogInPage.login'(USERNAME, PASSWORD)
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("User Logged In Successfully")

CustomKeywords.'mobile.tacNumber.updateTacNumber'('111111')
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("TAC Number Updated")

CustomKeywords.'mobile.common.waitUptoCoolingPeriodAndRelogin'(PASSWORD)
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Cooling Period Completed and User Re-Logged In")

CustomKeywords.'mobile.withdrawal.clickFlexibleIcon'()
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Flexible Withdrawal Module Opened")

CustomKeywords.'mobile.withdrawal.enterAmountAndContinue'("500000")
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Withdrawal Amount Entered - RM500000")

CustomKeywords.'mobile.withdrawal.fillBankDetails'(
	findTestObject('Flexible_Withdrawal/bankDetailsPage/uobBank'),
	'24880149891'
)
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Bank Details Entered")

CustomKeywords.'mobile.withdrawal.confirmationPage'()
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Withdrawal Confirmation Page Displayed")

CustomKeywords.'mobile.withdrawal.declarationPage'()
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Declaration Accepted")

CustomKeywords.'mobile.withdrawal.handleAuthorisationMethod'('secureTac')
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Secure TAC Authorisation Completed")

CustomKeywords.'mobile.withdrawal.handleAuthenticationMethod'('CIJ')
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("CIJ Authentication Completed")

CustomKeywords.'mobile.resultValidation.validateSuccessMessage'(
	findTestObject('Flexible_Withdrawal/resultPage/successfullMessage'),
	"Pengeluaran anda telah dihantar"
)
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Withdrawal Submission Successful")

CustomKeywords.'mobile.cancelWithdrawalFlow.cancelSubmittedWithdrawal'()
CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Submitted Withdrawal Cancelled Successfully")