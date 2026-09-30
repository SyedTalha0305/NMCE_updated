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



///Mobile flow

Mobile.comment("Mobile flow is running")

CustomKeywords.'mobile.BrowserStackMobile.connectToBrowserStackApp'()

CustomKeywords.'mobile.Login.PreLogin_function'(USERNAME , PASSWORD)


//Web Flow

Mobile.comment("Web flow is running")

CustomKeywords.'web.Login.LoginFlow'(USERNAME , PASSWORD)

CustomKeywords.'web.term_and_condition.TermsAndCondition'()

CustomKeywords.'web.GuidedTour_Screens.GuidedTour'()

CustomKeywords.'web.Age.Age60_Function'("PARTIAL")

CustomKeywords.'web.Secure_Verification.SecureTac_Verify_Function'()


///Mobile flow for Approval

Mobile.comment("Mobile approval flow is running")

CustomKeywords.'mobile.Mobile_Approval.approval_Function_For_Registration'()


///Web flow for Verification

WebUI.comment("Web Verify flow is running")

CustomKeywords.'web.Login.Session_Remains'()

CustomKeywords.'web.Cancellation_Withdrawals.Cancel_Withdrawals_Function'()