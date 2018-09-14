import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')
'Open the URL'
WebUI.navigateToUrl(GlobalVariable.URL)
'enter the invalid email id'
WebUI.setText(findTestObject('Login/userId'), 'abc')
'click on GET OTP button'
WebUI.click(findTestObject('Object Repository/Login/div_GET OTP'))
'validate retry button is displayed'
WebUI.waitForElementPresent(findTestObject('Login/span_Retry'), 30)
'validate the retry button is present'
WebUI.verifyElementText(findTestObject('Login/span_Retry'), 'Retry')
'validate the inactive OTP button'
WebUI.verifyElementPresent(findTestObject('Login/InactiveOTP'), 30)
'click on the Retry button'
WebUI.click(findTestObject('Login/span_Retry'))
'after click on retry button then validate the empty email input box'
WebUI.verifyMatch(WebUI.getText(findTestObject('Login/userId')).toString(), '', false)

WebUI.closeBrowser()