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
import com.thoughtworks.selenium.Selenium as Selenium
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariables
import org.openqa.selenium.By as Selenium
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver

WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('Object Repository/Stats/statsTab'))

'previous outbound Link generated count'
String actualCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]")).getText();
previousCountValue = Integer.parseInt(actualCount);
println("count :" + previousCountValue)


String linkOpenACtual = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]")).getText();
previousLinkOpenValue = Integer.parseInt(linkOpenACtual);
println("count :" + previousLinkOpenValue)

'create a link log'
WebUI.callTestCase(findTestCase('commonFunctionality/linkLogCreation'), null)

getLink = WebUI.getAttribute(findTestObject('Dashboard_Link Generator/input_link-text'), 'value')
println(getLink)

WebUI.click(findTestObject('Dashboard_Link Generator/copyLink'))

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')
currentWindow = WebUI.getWindowIndex()
//Go in to new tab
WebUI.switchToWindowIndex(currentWindow + 1)
WebUI.navigateToUrl(getLink)

int currentTab = WebUI.getWindowIndex()

WebUI.click(findTestObject('Object Repository/timeSpentOnlink/stepInsideButton'))
WebUI.delay(9)
WebUI.switchToWindowIndex(0)

WebUI.delay(1)

WebUI.refresh()
WebUI.acceptAlert()

WebUI.click(findTestObject('Object Repository/Stats/statsTab'))
WebUI.delay(20)


'After form filled count'
String increaseCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]")).getText();
println("countForms :" + increaseCount)
//To convert actual value string to Integer value.
int newCountValue = Integer.parseInt(increaseCount);

if (newCountValue == previousCountValue + 1) {
    println("success")
} else {
    throw new Error("count not increase")
}

'After form filled count'
String increaseLinkOpenCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]")).getText();
println("countForms :" + increaseLinkOpenCount)
//To convert actual value string to Integer value.
int newLinkOpenCountValue = Integer.parseInt(increaseLinkOpenCount);

if (newLinkOpenCountValue == previousLinkOpenValue + 1) {
    println("success")
} else {
    throw new Error("count not increase")
}