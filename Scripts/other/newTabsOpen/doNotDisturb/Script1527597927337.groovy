//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
//import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//import com.kms.katalon.core.model.FailureHandling as FailureHandling
//import com.kms.katalon.core.testcase.TestCase as TestCase
//import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
//import com.kms.katalon.core.testdata.TestData as TestData
//import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
//import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
//import com.kms.katalon.core.testobject.TestObject as TestObject
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import internal.GlobalVariable as GlobalVariable
//import org.openqa.selenium.By as Selenium
//import org.openqa.selenium.WebDriver as WebDriver
//import org.openqa.selenium.JavascriptExecutor
//import com.kms.katalon.core.webui.driver.DriverFactory
//
//
//WebUI.openBrowser('https://www.google.com/')
//WebUI.maximizeWindow()
//
//WebUI.navigateToUrl("maildrop.cc")
//
//WebUI.setText(findTestObject('Object Repository/newTab/inputbox'), "1")
//
//WebUI.click(findTestObject('Object Repository/newTab/button'))
//
//WebDriver driver = DriverFactory.getWebDriver()
//
//JavascriptExecutor js = ((driver) as JavascriptExecutor)
//
//int i,n;
//n=235;
//for(i = 2; i<=n; i++){
//	js.executeScript('window.open();')
//	currentWindow =  WebUI.getWindowIndex()
//	//Go in to new tab
//	WebUI.switchToWindowIndex(currentWindow + 1)
//	WebUI.navigateToUrl("maildrop.cc")
//	WebUI.setText(findTestObject('Object Repository/newTab/inputbox'), i.toString())
//	WebUI.click(findTestObject('Object Repository/newTab/button'))
//}
//
