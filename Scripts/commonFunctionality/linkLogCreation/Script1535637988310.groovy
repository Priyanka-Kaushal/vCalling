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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//create a customer with full information
WebDriver driver = DriverFactory.getWebDriver()
WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

String x = CustomKeywords.'newPackage.newKeyword.randomString'(3).toLowerCase()

GlobalVariable.teamMeberName = x

'Enter the customer name'
WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), x)

'Enter the customer Id'
WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(10) +
	'@gmail.com')

'Enter the customer number'
String number = CustomKeywords.'phoneNumbers.contactNumbers.randomString'(9)

GlobalVariable.Mobile_Number = number

WebUI.setText(findTestObject('Dashboard_Link Generator/contactNumber'), number + '1')

'Enter the Tag'
WebUI.setText(findTestObject('Dashboard_Link Generator/tag'), GlobalVariable.Extra_Tag)

'Click on get link button'
WebUI.click(findTestObject('Dashboard_Link Generator/div_GET LINK'))