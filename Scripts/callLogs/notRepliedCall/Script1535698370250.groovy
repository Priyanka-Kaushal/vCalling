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

'Login with valid User ID  '
WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.callTestCase(findTestCase('commonFunctionality/linkLogCreation'), null)

'Copy Link through get Link button'
getLink = WebUI.getAttribute(findTestObject('Dashboard_Link Generator/input_link-text'), 'value')

println(getLink)

WebUI.click(findTestObject('Dashboard_Link Generator/copyLink'))

'after copy link, validate the validation message'
if (WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 5, FailureHandling.OPTIONAL)) {
    validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))

    WebUI.verifyMatch(validationMessage, GlobalVariable.copy_link, false)

    println('successful')
} else {
    throw new Error('Alert not found')
}

'validate the customer details open'
List<WebElement> linkUserName = driver.findElements(By.className('text-link-log'))

int previousCountValue = 0

for (int i = 0; i < linkUserName.size(); i++) {
    System.out.println('Admin Console: ' + linkUserName.get(i).getText())

    String linkLogmembername = linkUserName.get(i).getText()

    if (linkLogmembername.equals(GlobalVariable.teamMeberName)) {
        System.out.println('Admin Console: ' + linkLogmembername)

        linkUserName.get(i).click()
    }
}

WebUI.clickOffset(findTestObject('Object Repository/customerDetailsEdit/customerDetailScreen'), 100, 200)

'validate to open a copy link log in new tab '
JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')

currentWindow = WebUI.getWindowIndex()

//Go in to new tab
WebUI.switchToWindowIndex(currentWindow + 1)
WebUI.navigateToUrl(getLink)

int currentTab = WebUI.getWindowIndex()

WebUI.click(findTestObject('Object Repository/callLogs/callingButton'))
WebUI.delay(5)

WebUI.switchToWindowIndex(0)
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/callLogs/declineButton'))

WebUI.click(findTestObject('Object Repository/callLogs/callLogsSideBarButton'))
WebUI.delay(6)

WebUI.click(findTestObject('Object Repository/callLogs/notRepliedCall'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/callLogs/refreshButton'))
WebUI.delay(6)

'validate the call details'
List<WebElement> userName = driver.findElements(By.className('text-call-log'))

int previousCountCall = 0

for (int i = 0; i < userName.size(); i++) {
	System.out.println('Admin Console: ' + userName.get(i).getText())
	String callLogmembername = userName.get(i).getText()
	if (callLogmembername.equals(GlobalVariable.teamMeberName)) {
      System.out.println('Admin Console: ' + callLogmembername)
	  userName.get(i).click()
	}
}

WebUI.clickOffset(findTestObject('Object Repository/customerDetailsEdit/customerDetailScreen'), 100, 200)
WebUI.delay(3)

WebUI.callTestCase(findTestCase('commonFunctionality/pagination'), null)

'filter tag end to end test cases '
WebUI.callTestCase(findTestCase('commonFunctionality/TagsFilter'), null)
WebUI.delay(2)
