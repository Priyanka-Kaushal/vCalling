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
import org.openqa.selenium.By as Selenium
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor


WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

WebUI.click(findTestObject('Object Repository/Public Links/publicLinkTab'))

'Enter a Tag'
String x = (CustomKeywords.'newPackage.newKeyword.randomString'(3)).toLowerCase()

GlobalVariable.teamMeberName = x
WebUI.setText(findTestObject('Object Repository/Public Links/PubLinkWithTag'), x+'a')


WebUI.click(findTestObject('Object Repository/Public Links/checkBoxPubLink'))

'click on public get link button'
WebUI.click(findTestObject('Object Repository/Public Links/GetLink'))

getLink = WebUI.getAttribute(findTestObject('Dashboard_Link Generator/input_link-text'), 'value')
println (getLink)

WebUI.click(findTestObject('Dashboard_Link Generator/copyLink'))

WebUI.delay(2)

'validate to open a copy link log in new tab '
JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')
currentWindow =  WebUI.getWindowIndex()
//Go in to new tab
WebUI.switchToWindowIndex(currentWindow + 1)
WebUI.navigateToUrl(getLink)

WebUI.setText(findTestObject('Object Repository/PublicCustomer/callOnlyCustName'), " ")

WebUI.click(findTestObject('Object Repository/PublicCustomer/callOnlyNextButton'))

'Enter the customer number'
String number = (CustomKeywords.'phoneNumbers.contactNumbers.randomString'(9))

GlobalVariable.Mobile_Number = number
WebUI.setText(findTestObject('Object Repository/PublicCustomer/customerNumber'), number+1)

WebUI.click(findTestObject('Object Repository/PublicCustomer/doneButtonCallOnly'))

int currentTab = WebUI.getWindowIndex()
WebUI.delay(10)

WebUI.switchToWindowIndex(0)

WebUI.refresh()

WebUI.acceptAlert()