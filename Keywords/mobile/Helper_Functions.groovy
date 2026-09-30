package mobile
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory


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
import io.appium.java_client.android.AndroidDriver

public class Helper_Functions {
	
	// ========================
	// Helpers
	// ========================
	
	
	
	////Mobile Relaunch Function
	
	@Keyword
	def Mobile_Relaunch_Function() {
		
		
		// Reopen app safely
		AndroidDriver driver = MobileDriverFactory.getDriver()

		Map<String, Object> args = new HashMap<>()

		args.put(
			"intent",
			"com.epf.mip.uat/com.epf.mip.MainActivity"
		)

		driver.executeScript(
			"mobile: startActivity",
			args
		)

		Mobile.delay(5)

		Mobile.comment("App reopened")
		
		CustomKeywords.'mobile.Helper_Functions.step_screenshot'(
			"Pre Login Home Page")
		
		
	}
	
	

	
	/////Screen short function
	
	@Keyword
    def step_screenshot(String message) {
	Mobile.comment(message)
	Mobile.delay(1)
	Mobile.takeScreenshot()
    }
	
	
	/////Set Textfield
	
	@Keyword
	def setTextField(TestObject obj, String value, int timeout = 10) {

		if (Mobile.waitForElementPresent(obj, timeout)) {

			Mobile.tap(obj, timeout)

			Mobile.clearText(obj, timeout)

			Mobile.setText(obj, value, timeout)

			Mobile.delay(2)

			// First attempt
			Mobile.hideKeyboard()

			Mobile.delay(1)

			// Force close keyboard using Android back
			Mobile.pressBack()

			Mobile.delay(3)

		} else {

			KeywordUtil.markFailedAndStop("❌ Element not found: " + obj)
		}
	}
		
	
	/////Click on visibility Function
	
	@Keyword
	def clickWhenVisible(TestObject obj, int timeout = 10) {

		if (Mobile.waitForElementPresent(obj, timeout)) {

			Mobile.tap(obj, timeout)

		} else {

			KeywordUtil.markFailedAndStop("❌ Element not found: " + obj)
		}
	}

	
	
	////Click multiple time function
	
	@Keyword
	def clickMultiple(TestObject obj, int times) {
		for (int i = 0; i < times; i++) {
			Mobile.tap(obj, 3)
			Mobile.delay(1)
		}
		
		
	}
	
    ///Scroll Element
	
	@Keyword
	def scrollToTextValue(String text) {
	
		Mobile.scrollToText(text)
		Mobile.delay(3)
	}
	
	
	///Scroll Down Function
	
	@Keyword
	def selectDropdown(TestObject dropdownObj, String optionText, int timeout = 10) {

		if (Mobile.waitForElementPresent(dropdownObj, timeout)) {

			// Open dropdown
			Mobile.tap(dropdownObj, timeout)

			Mobile.delay(1)

			// Scroll to option text
			Mobile.scrollToText(optionText)

			Mobile.delay(1)

			// Tap option
			TestObject optionObj = new TestObject()

			optionObj.addProperty(
				"text",
				com.kms.katalon.core.testobject.ConditionType.EQUALS,
				optionText
			)

			Mobile.tap(optionObj, timeout)

		} else {

			KeywordUtil.markFailedAndStop(
				"❌ Dropdown not found: " + dropdownObj
			)
		}
	}
	

	///Scroll Element
	
	
	@Keyword
	def scrollAndClick(TestObject obj, int maxScrolls = 7, int timeout = 5) {

		boolean found = false

		for (int i = 0; i < maxScrolls; i++) {

			if (Mobile.waitForElementPresent(obj, 2)) {

				found = true
				break
			}

			// Vertical swipe
			Mobile.swipe(500, 1600, 500, 500)

			Mobile.delay(1)
		}

		if (found) {

	CustomKeywords.'mobile.Helper_Functions.clickWhenVisible'(obj)

		} 
		else {

			KeywordUtil.markFailedAndStop(
				"❌ Element not found after scrolling: " + obj
			)
		}
	}
	
	
	
@Keyword
def verifyMessage(
	TestObject messageObject,
	String expectedMessage,
	String screenshotDescription = expectedMessage
) {

	boolean isMessageDisplayed =
		Mobile.waitForElementPresent(messageObject, 10, FailureHandling.STOP_ON_FAILURE)

	assert isMessageDisplayed :
		"Expected message not displayed: ${expectedMessage}"

	String actualMessage =
		Mobile.getText(messageObject, 10)

	assert actualMessage.trim() == expectedMessage.trim() :
		"Expected: '${expectedMessage}'\nActual: '${actualMessage}'"

	step_screenshot(screenshotDescription)
}
	
	
	
	

}
