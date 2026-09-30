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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions

import java.time.Duration
import java.util.Random


public class Captcha_Handling {
	
	
//	@Keyword
//	def solveSliderCaptcha(TestObject sliderObject) {
//	
//		WebDriver driver = DriverFactory.getWebDriver()
//	
//		WebElement slider =
//				WebUiCommonHelper.findWebElement(sliderObject, 10)
//	
//		// slider container width
//		WebElement track =
//				slider.findElement(By.xpath("./ancestor::*[1]"))
//	
//		int trackWidth = track.getSize().getWidth()
//		int sliderWidth = slider.getSize().getWidth()
//	
//		// dynamic max move
//		int maxOffset = trackWidth - sliderWidth - 5
//	
//		println("Track Width: " + trackWidth)
//		println("Slider Width: " + sliderWidth)
//		println("Max Offset: " + maxOffset)
//	
//		Actions actions = new Actions(driver)
//	
//		// hold slider
//		actions.clickAndHold(slider).perform()
//	
//		Random random = new Random()
//	
//		int moved = 0
//	
//		while (moved < maxOffset) {
//	
//			// random human-like step
//			int step = random.nextInt(7) + 3
//	
//			if (moved + step > maxOffset) {
//				step = maxOffset - moved
//			}
//	
//			// IMPORTANT:
//			// recreate Actions every loop
//			new Actions(driver)
//					.moveByOffset(step, random.nextInt(3) - 1)
//					.pause(Duration.ofMillis(random.nextInt(120) + 80))
//					.perform()
//	
//			moved += step
//	
//			println("Moved: " + moved)
//	
//			WebUI.delay(1)
//	
//			// ✅ STOP immediately if solved
//			if (isCaptchaSolved()) {
//	
//				println("Captcha solved at offset: " + moved)
//	
//				new Actions(driver).release().perform()
//	
//				return
//			}
//		}
//	
//		// release at end
//		new Actions(driver).release().perform()
//	
//		WebUI.delay(2)
//	}
	
	
		@Keyword
		def solveSliderCaptcha(TestObject sliderObject, int totalOffset = 260) {
	
			WebDriver driver = DriverFactory.getWebDriver()
	
			WebElement slider = WebUiCommonHelper.findWebElement(sliderObject, 10)
	
			Actions actions = new Actions(driver)
	
			WebUI.delay(1)
	
			// Click and hold
			actions.clickAndHold(slider).perform()
	
			Random random = new Random()
	
			int moved = 0
	
			while (moved < totalOffset) {
	
				int step = random.nextInt(8) + 5
				int yMove = random.nextInt(3) - 1
	
				if (moved + step > totalOffset) {
					step = totalOffset - moved
				}
	
				actions.moveByOffset(step, yMove)
					   .pause(Duration.ofMillis(random.nextInt(120) + 80))
					   .perform()
	
				moved += step
			}
	
			// Small human correction
			actions.moveByOffset(-3, 0)
				   .pause(Duration.ofMillis(150))
				   .perform()
	
			actions.release().perform()
	
			WebUI.delay(3)
		}
		
		
	

}
