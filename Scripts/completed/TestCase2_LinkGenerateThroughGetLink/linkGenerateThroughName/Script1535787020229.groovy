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

'Login with valid Email ID'
WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

'click on link generator icon'
WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

String x = CustomKeywords.'newPackage.newKeyword.randomString'(3).toLowerCase()

GlobalVariable.teamMeberName = x

'Enter the customer name'
WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), x)

'click on get link button'
WebUI.click(findTestObject('Dashboard_Link Generator/div_GET LINK'))

'after copy link, validate the validation message'
if (WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 5, FailureHandling.OPTIONAL)) {
	validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))
	WebUI.verifyMatch(validationMessage, GlobalVariable.noInformation, false)
	println('successful')
} else {
	throw new Error('Alert not found')
}