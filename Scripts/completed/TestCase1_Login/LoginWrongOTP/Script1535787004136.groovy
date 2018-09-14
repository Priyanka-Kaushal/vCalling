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

'open the URL'
WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

'Eneter the valid email id'
WebUI.setText(findTestObject('Object Repository/Login/UserId'), 'priyankakaushal2308@gmail.com')

'click on GET OTP button'
WebUI.click(findTestObject('Object Repository/Login/div_GET OTP'))

'enter the wrong OTP'
WebUI.setText(findTestObject('Object Repository/Login/OtpInput'), 'f19608')

'click on submit button'
WebUI.click(findTestObject('Object Repository/Login/div_SUBMIT'))

'validate the Retry button'
WebUI.verifyElementText(findTestObject('Login/span_Retry'), 'Resend OTP')

'validate the inactive OTP button'
WebUI.verifyElementPresent(findTestObject('Login/InactiveOTP'), 30)

WebUI.click(findTestObject('Login/span_Retry'))


