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
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import CustomKeywords
import internal.GlobalVariable

public class Login {
	
	
	
	@Keyword
	def Login_function (String USERNAME, String PASSWORD)
	
	{
		
		/// =========================
		/// Login Flow
		/// =========================
		
		// Capture initial screen after app launch/login landing
		CustomKeywords.'mobile.Helper_Functions.step_screenshot'("After Login")
		
		// Select BM language option
		Mobile.tap(
			findTestObject('Object Repository/Mobile Locators/Login/BM'),
			02
		)
		
		// Skip onboarding/tutorial screen
		Mobile.tap(
			findTestObject('Object Repository/Mobile Locators/Login/Skip'),
			02
		)
		
		// Capture nickname entry screen
		CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Enter nickname")
		
		// Enter user nickname
		CustomKeywords.'mobile.Helper_Functions.setTextField'(
			findTestObject('Object Repository/Mobile Locators/Login/nickname'),
			"Syed"
		)
		
		// Accept terms and proceed
		CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Mobile Locators/Login/Agree and Proceed btn'),
			3
		)
		
		// Capture login landing flow
		CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Login flow")
		
		// Tap login banner
		CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Mobile Locators/Login/LoginNow_Banner'),
			1
		)
		
		// Continue to login form
		CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Mobile Locators/Login/Cont_Btn'),
			1
		)
		
		// Capture username entry screen
		CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Enter username")
		
		// Enter application username
		CustomKeywords.'mobile.Helper_Functions.setTextField'(
			findTestObject('Object Repository/Mobile Locators/Login/User_Id textfield'),
			USERNAME
		)
		
		// Continue after entering username
		CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Mobile Locators/Login/Username_Cont_Btn'),
			1
		)
		
		// Wait for identity verification screen
		Mobile.delay(5)
		
		// Confirm user identity
		CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Mobile Locators/Login/Thats me btn'),
			1
		)
		
		// Capture password entry screen
		CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Enter Password")
		
		// Enter application password
		CustomKeywords.'mobile.Helper_Functions.setTextField'(
			findTestObject('Object Repository/Mobile Locators/Login/Password'),
			PASSWORD
		)
		
		// Continue after entering password
		CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
			findTestObject('Object Repository/Mobile Locators/Login/Password_Cont_Btn'),
			3
		)
		
		// Accept terms and conditions flow
		CustomKeywords.'mobile.Term_And_Condition.TermsAndCondition'()
		
		// Trust current device flow
		CustomKeywords.'mobile.Trust_Device.TrustDevice'()
		
		// Capture TAC verification screen
		CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Click Tac Button")
		
		// Tap TAC button multiple times for verification/OTP flow
		CustomKeywords.'mobile.Helper_Functions.clickMultiple'(
			findTestObject('Object Repository/Mobile Locators/Login/TAC Btn'),
			6
		)
		
		//Checking confirm option button
		
		CustomKeywords.'mobile.handle_Cooling_off_Period.handle_Optional_Popup_Function'()
		
		//Cooling off Period function
		CustomKeywords.'mobile.handle_Cooling_off_Period.handleCoolingOffPeriod'(63 , PASSWORD )
		
		
		
		/// =========================
		/// Login Flow - Registered Device
		/// =========================
		
//		// Continue after device recognition/confirmation prompt
//		
//		 CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
//		 	findTestObject('Object Repository/Mobile Locators/Login/Confirm_Btn'),
//		 	2
//		 )
//		
//		// Proceed with linked device continuation flow
//		 CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
//		 	findTestObject('Object Repository/Mobile Locators/Login/Linked Continue'),
//		 	2
//		 )
//		
//		// Create 6-digit application PIN
//		 CustomKeywords.'mobile.Helper_Functions.clickMultiple'(
//		 	findTestObject('Object Repository/Mobile Locators/Login/Create Pin'),
//		 	6
//		 )
//		
//		// Confirm previously created PIN
//		 CustomKeywords.'mobile.Helper_Functions.clickMultiple'(
//		 	findTestObject('Object Repository/Mobile Locators/Login/Confirm Create Pin'),
//		 	6
//		 )


 }
 
 
 @Keyword
 def PreLogin_function (String USERNAME, String PASSWORD)
 
 {
	 
	 /// =========================
	 /// Pre Login Flow
	 /// =========================
	 
	
	 // Capture initial screen after app launch/login landing
	 CustomKeywords.'mobile.Helper_Functions.step_screenshot'("After Login")
	 
	 // Select BM language option
	 Mobile.tap(
		 findTestObject('Object Repository/Mobile Locators/Login/BM'),
		 02
	 )
	 
	 // Skip onboarding/tutorial screen
	 Mobile.tap(
		 findTestObject('Object Repository/Mobile Locators/Login/Skip'),
		 02
	 )
	 
	 // Capture nickname entry screen
	 CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Enter nickname")
	 
	 // Enter user nickname
	 CustomKeywords.'mobile.Helper_Functions.setTextField'(
		 findTestObject('Object Repository/Mobile Locators/Login/nickname'),
		 "Syed"
	 )
	 
	 // Accept terms and proceed
	 CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
		 findTestObject('Object Repository/Mobile Locators/Login/Agree and Proceed btn'),
		 3
	 )
	 
	 // Capture login landing flow
	 CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Login flow")
	 
	 // Tap login banner
	 CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
		 findTestObject('Object Repository/Mobile Locators/Login/LoginNow_Banner'),
		 1
	 )
	 
	 // Continue to login form
	 CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
		 findTestObject('Object Repository/Mobile Locators/Login/Cont_Btn'),
		 1
	 )
	 
	 // Capture username entry screen
	 CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Enter username")
	 
	 // Enter application username
	 CustomKeywords.'mobile.Helper_Functions.setTextField'(
		 findTestObject('Object Repository/Mobile Locators/Login/User_Id textfield'),
		 USERNAME
	 )
	 
	 // Continue after entering username
	 CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
		 findTestObject('Object Repository/Mobile Locators/Login/Username_Cont_Btn'),
		 1
	 )
	 
	 // Wait for identity verification screen
	 Mobile.delay(5)
	 
	 // Confirm user identity
	 CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
		 findTestObject('Object Repository/Mobile Locators/Login/Thats me btn'),
		 1
	 )
	 
	 // Capture password entry screen
	 CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Enter Password")
	 
	 // Enter application password
	 CustomKeywords.'mobile.Helper_Functions.setTextField'(
		 findTestObject('Object Repository/Mobile Locators/Login/Password'),
		 PASSWORD
	 )
	 
	 // Continue after entering password
	 CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(
		 findTestObject('Object Repository/Mobile Locators/Login/Password_Cont_Btn'),
		 3
	 )
	 
	 // Accept terms and conditions flow
	 CustomKeywords.'mobile.Term_And_Condition.TermsAndCondition'()
	 
	 // Trust current device flow
	 CustomKeywords.'mobile.Trust_Device.TrustDevice'()
	 
	 // Capture TAC verification screen
	 CustomKeywords.'mobile.Helper_Functions.step_screenshot'("Click Tac Button")
	 
	 // Tap TAC button multiple times for verification/OTP flow
	 CustomKeywords.'mobile.Helper_Functions.clickMultiple'(
		 findTestObject('Object Repository/Mobile Locators/Login/TAC Btn'),
		 6
	 )
	 
	 //Checking confirm option button
	 CustomKeywords.'mobile.handle_Cooling_off_Period.handle_Optional_Popup_Function'()
	 
	 //Cooling off Period function
	 CustomKeywords.'mobile.handle_Cooling_off_Period.PreLogin_handleCoolingOffPeriod'()
	 
	 

  }
	 
	 

 }

	
	
	


