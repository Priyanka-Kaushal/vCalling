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
import com.sun.org.apache.bcel.internal.generic.NEW
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.thoughtworks.selenium.Selenium as Selenium
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
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

'previous pulic link generated count'
String actualCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")).getText();
previousCountValue = Integer.parseInt(actualCount);
println("count :" + previousCountValue)

'previous pulic customers link count'
String actualLinkCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]")).getText();
previousLinkOpenCountValue = Integer.parseInt(actualLinkCount);
println("count :" + previousLinkOpenCountValue)

"previous pulic link views count"
String actualViewCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")).getText();
previousLinkOpenViewCountValue = Integer.parseInt(actualViewCount);
println("count :" + previousLinkOpenViewCountValue)

WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

WebUI.click(findTestObject('Object Repository/Public Links/publicLinkTab'))

WebUI.delay(3)
'Enter a Tag'
String x = (CustomKeywords.'newPackage.newKeyword.randomString'(3)).toLowerCase()

GlobalVariable.teamMeberName = x

WebUI.setText(findTestObject('Object Repository/Public Links/PubLinkWithTag'), x+'a')

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


//start watch
long start = System.currentTimeMillis();
println("start browser time :" + start)
 
//WebUI.setText(findTestObject('Object Repository/PublicCustomer/callOnlyCustName'), " ")


int currentTab = WebUI.getWindowIndex()

String nameUser = (CustomKeywords.
    'newPackage.newKeyword.randomString'(3)).toLowerCase()

GlobalVariable.teamMeberName = nameUser
WebUI.setText(findTestObject('Object Repository/publicLinkGenerator/name'), nameUser)

WebUI.setText(findTestObject('Object Repository/PublicCustomer/callOnlyCustName'), nameUser)

WebUI.click(findTestObject('Object Repository/PublicCustomer/callOnlyNextButton'))

WebUI.setText(findTestObject('Object Repository/PublicCustomer/callOnlyEmail'), CustomKeywords.'newPackage.newKeyword.randomString'(10)+'@gmail.com')

WebUI.click(findTestObject('PublicCustomer/doneButton'))

WebUI.click(findTestObject('Object Repository/timeSpentOnlink/stepInsideButton'))
WebUI.delay(9)

WebUI.switchToWindowIndex(0)
WebUI.refresh()
WebUI.acceptAlert()

WebUI.click(findTestObject('Object Repository/Stats/statsTab'))
WebUI.delay(20)

'After public link generate count'
String increaseCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")).getText();
println("countForms :" + increaseCount)
//To convert actual value string to Integer value.
int newCountValue = Integer.parseInt(increaseCount);

if (newCountValue == previousCountValue + 1) {
    println("success")
} else {
    throw new Error("count not increase")
}

'After public link open count'
String increaseOpenLinkCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]")).getText();
println("countForms :" + increaseOpenLinkCount)
//To convert actual value string to Integer value.
int newCountopenLinkValue = Integer.parseInt(increaseOpenLinkCount);

if (newCountopenLinkValue == previousLinkOpenCountValue + 1) {
	println("success")
} else {
	throw new Error("count not increase")
}

'After public link view count'
String increaseViewCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")).getText();
println("countForms :" + increaseViewCount)

//To convert actual value string to Integer value.
int newViewCountValue = Integer.parseInt(increaseViewCount);

if (newViewCountValue == previousLinkOpenViewCountValue + 1) {
	println("success")
} else {
	throw new Error("count not increase")
}