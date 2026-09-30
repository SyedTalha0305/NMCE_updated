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
import internal.GlobalVariable
import org.openqa.selenium.WebDriver

import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import java.time.Duration
import java.util.Random

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper





public class Helper_Functions {
	
	// ========================
	// Helpers
	// ========================
	
	
	/////Screen short function
	
	@Keyword
	def step_screenshot(String message) {
		WebUI.comment(message)
		
		WebUI.delay(1)
		
		WebUI.takeScreenshot()
	}
	
	
	/////Click on visibility Function
	
   @Keyword
    def clickWhenVisible(TestObject obj, int timeout = 6) {
    if (WebUI.waitForElementVisible(obj, timeout, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(obj, timeout)
        WebUI.click(obj)
	
    }
	}
	
	/////Set text field function
	
	@Keyword
	def setTextField(TestObject obj, String value) {
		if (WebUI.waitForElementVisible(obj, 5, FailureHandling.OPTIONAL)) {
		
			WebUI.setText(obj, value)
		}
	}
	
	////Click multiple time function
	
	@Keyword
	def clickMultiple(TestObject obj, int times) {
		for (int i = 0; i < times; i++) {
			clickWhenVisible(obj)
		}
	}
	
	
   //Dropdown function
	
	@Keyword
	def selectDropdownOption(TestObject dropdown, TestObject option) {
	
		// Click dropdown
		WebUI.waitForElementClickable(dropdown, 10)
		WebUI.click(dropdown)
	
		// Click option
		WebUI.waitForElementClickable(option, 10)
		WebUI.click(option)
	
		WebUI.takeScreenshot()
	}
	
	
	//Click and Set Text
	
	@Keyword
	def ClickAndSetText(TestObject obj, String value) {
	
		if (WebUI.waitForElementClickable(obj, 10, FailureHandling.OPTIONAL)) {
	
			WebUI.scrollToElement(obj, 5)
			WebUI.click(obj)
			WebUI.clearText(obj)
			WebUI.setText(obj, value)
		}
	}
	
	//verify assertion
	
	@Keyword
	def verifyMessage(
		TestObject messageObject,
		String expectedMessage,
		String screenshotDescription = expectedMessage
	) {

		boolean isMessageDisplayed =
			WebUI.waitForElementVisible(
				messageObject,
				10,
				FailureHandling.STOP_ON_FAILURE
			)

		assert isMessageDisplayed :
			"Expected message not displayed: ${expectedMessage}"

		String actualMessage =
			WebUI.getText(messageObject).trim()

		assert actualMessage == expectedMessage.trim() :
			"Expected: '${expectedMessage}'\nActual: '${actualMessage}'"

		step_screenshot(screenshotDescription)
	}

	
	
	
	
	}









