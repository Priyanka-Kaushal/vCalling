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


'Login with valid Email ID'
WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

WebDriver driver = DriverFactory.getWebDriver()

'click on link generator icon'
WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

'Enter the customer name'
WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), Name)

'Enter the customer Id'
WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), Email)

WebUI.sendKeys(findTestObject('Dashboard_Link Generator/contactNumber'), number)

'Enter the Tag'
WebUI.setText(findTestObject('Dashboard_Link Generator/tag'), Tag)

'Click on get link button'
WebUI.click(findTestObject('Dashboard_Link Generator/div_GET LINK'))

getLink = WebUI.getAttribute(findTestObject('Dashboard_Link Generator/input_link-text'), 'value')
println (getLink)

WebUI.click(findTestObject('Dashboard_Link Generator/copyLink'))

'after copy link, validate the validation message'
 if(WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 5, FailureHandling.OPTIONAL)){

		validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))

		WebUI.verifyMatch(validationMessage, GlobalVariable.copy_link, false)

		println('successful')
	}else{

		throw new Error('Alert not found')

	}
	
	WebUI.delay(2)
	
	'validate to open a copy link log in new tab '
	JavascriptExecutor js = ((driver) as JavascriptExecutor)
	
	js.executeScript('window.open();')
	currentWindow =  WebUI.getWindowIndex()
	//Go in to new tab
	WebUI.switchToWindowIndex(currentWindow + 1)
	WebUI.navigateToUrl(getLink)

	int currentTab = WebUI.getWindowIndex()
	WebUI.delay(10)
	
	WebUI.switchToWindowIndex(0)
	
	WebUI.refresh()
	
	WebUI.acceptAlert()
	
	WebUI.delay(8)
