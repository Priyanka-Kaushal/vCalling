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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('Object Repository/Stats/statsTab'))

'previous time after form filled'
String currentTime = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[3]/div[1]")).getText();
//previousCountValue = Integer.parseInt(actualTime);
println("count :" + currentTime)
varX = currentTime.split(' ')
String Hours = varX[0].replace("H", "")

varY = currentTime.split(' ')
String Minutes = varY[1].replace("M", "")

currentTimehours = Integer.parseInt(Hours)
println(currentTimehours)

currentTimeMin = Integer.parseInt(Minutes)
println(currentTimeMin)

WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

WebUI.click(findTestObject('Object Repository/Public Links/publicLinkTab'))

WebUI.delay(3)
'Enter a Tag'
String x = (CustomKeywords.
    'newPackage.newKeyword.randomString'(3)).toLowerCase()

GlobalVariable.teamMeberName = x

WebUI.setText(findTestObject('Object Repository/Public Links/PubLinkWithTag'), x + 'a')

'click on public get link button'
WebUI.click(findTestObject('Object Repository/Public Links/GetLink'))

getLink = WebUI.getAttribute(findTestObject('Dashboard_Link Generator/input_link-text'), 'value')
println(getLink)

WebUI.click(findTestObject('Dashboard_Link Generator/copyLink'))

WebUI.delay(2)

'validate to open a copy link log in new tab '
JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')
currentWindow = WebUI.getWindowIndex()
//Go in to new tab
WebUI.switchToWindowIndex(currentWindow + 1)
WebUI.navigateToUrl(getLink)

//WebUI.setText(findTestObject('Object Repository/PublicCustomer/callOnlyCustName'), " ")


//int currentTab = WebUI.getWindowIndex()

String nameUser = (CustomKeywords.
    'newPackage.newKeyword.randomString'(3)).toLowerCase()

GlobalVariable.teamMeberName = nameUser
WebUI.sendKeys(findTestObject('Object Repository/publicLinkGenerator/name'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
WebUI.setText(findTestObject('Object Repository/publicLinkGenerator/name'), nameUser)

WebUI.sendKeys(findTestObject('Object Repository/PublicCustomer/callOnlyCustName'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
WebUI.setText(findTestObject('Object Repository/PublicCustomer/callOnlyCustName'), nameUser)

WebUI.click(findTestObject('Object Repository/PublicCustomer/callOnlyNextButton'))

WebUI.setText(findTestObject('Object Repository/PublicCustomer/callOnlyEmail'), CustomKeywords.
    'newPackage.newKeyword.randomString'(10) + '@gmail.com')

WebUI.click(findTestObject('PublicCustomer/doneButton'))

//WebUI.click(findTestObject('Object Repository/timeSpentOnlink/stepInsideButton'))
//WebUI.delay(9)

int currentTab = WebUI.getWindowIndex()

//start watch
long start = System.currentTimeMillis();
println("start browser time :" + start)

WebUI.click(findTestObject('Object Repository/timeSpentOnlink/stepInsideButton'))
WebUI.delay(36)

List < WebElement > mediaTour = driver.findElements(By.className('media-none'))

println('media size ' + mediaTour.size())

for (int i = 0; i < mediaTour.size() + 1; i++) {
    WebUI.click(findTestObject('Object Repository/timeSpentOnlink/rightNavigationButton'))
    WebUI.delay(6)
}

for (int i = mediaTour.size() + 1; i > 0; i--) {
    WebUI.click(findTestObject('Object Repository/timeSpentOnlink/leftNavigationBuutton'))
    WebUI.delay(6)
}

WebUI.click(findTestObject('Object Repository/timeSpentOnlink/backButtonMediatour'))

//stop watch
long finish = System.currentTimeMillis();
println("close browser time :" + finish);
long totalTime = finish - start;
println("totaltime:" + totalTime)

int milliseconds = 1000;

int timeActualSeconds = (totalTime / milliseconds);
println("milliseconds conevrt into sec :" + timeActualSeconds)

int mod = 60;
int S = timeActualSeconds % 60;
println("Actual time" + S)

long Min = (timeActualSeconds) / 60;
print("Min :" + Min)

Hours = timeActualSeconds / 3600;
println("hours" + Hours)

timeSpentOnBrowser = String.format("%H %dM %dS", Hours, Min, S)
println("total time spent on browser:" + timeSpentOnBrowser)

WebUI.switchToWindowIndex(0)

WebUI.delay(1)

WebUI.refresh()
WebUI.acceptAlert()
WebUI.click(findTestObject('Object Repository/Stats/statsTab'))
WebUI.delay(20)

'After form filled count'
String increaseTime = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[3]/div[1]")).getText();
println("countForms :" + increaseTime)

varX1 = increaseTime.split(' ')
Hours = varX[0].replace("H", "")

varY1 = increaseTime.split(' ')
Minutes = varY[1].replace("M", "")

currentTimeHour = Integer.parseInt(Hours)
println(currentTimeHour)

currentTimeMin = Integer.parseInt(Minutes)
println(currentTimeMin)

WebUI.delay(3)