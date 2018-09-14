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
WebUI.delay(2)

WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

WebUI.delay(2)
String x = (CustomKeywords.
    'newPackage.newKeyword.randomString'(3)).toLowerCase()

GlobalVariable.teamMeberName = x

String number = (CustomKeywords.
    'phoneNumbers.contactNumbers.randomString'(8))

GlobalVariable.Mobile_Number = number

WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), x)

WebUI.delay(5)

WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.
    'newPackage.newKeyword.randomString'(10) + '@gmail.com')

WebUI.setText(findTestObject('Dashboard_Link Generator/contactNumber'), number)

WebUI.click(findTestObject('Dashboard_Link Generator/div_GET LINK'))

WebUI.delay(4)

WebElement TxtBoxContent = driver.findElement(By.xpath("//div[@class = 'copy-link-screen']/div[@class = 'copy-link-container']/input[@id = 'link-text']"));
getLink = TxtBoxContent.getAttribute("value");
print("TxtBoxContent URL" + getLink)

WebUI.delay(2)
WebUI.click(findTestObject('Dashboard_Link Generator/copyLink'))
WebUI.delay(2)

List < WebElement > linkUserName = driver.findElements(By.className("text-call-log"));
int previousTime = 0;
for (int i = 0; i < linkUserName.size(); i++) {
    System.out.println("Admin Console: " + linkUserName.get(i).getText());
    String linkLogmembername = linkUserName.get(i).getText();
    if (linkLogmembername.equals(GlobalVariable.teamMeberName)) {
        System.out.println("Admin Console: ");
        String previousTime1 = driver.findElement(By.xpath("//div[@class = 'call-log']/div[@class = 'call-log-cell'][5]")).getText();
        System.out.println("timeActual : " + previousTime1);
        WebUI.delay(2)
    }
}

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')
currentWindow = WebUI.getWindowIndex()
//Go in to new tab
WebUI.switchToWindowIndex(currentWindow + 1)
WebUI.navigateToUrl(getLink)
WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Object Repository/timeSpentOnlink/stepInsideButton'))

WebUI.delay(10)

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

WebUI.delay(2)

WebUI.refresh()
WebUI.acceptAlert()

WebUI.delay(20)

List < WebElement > linkUser = driver.findElements(By.className("text-call-log"));
println("Admin Console: " + "Comparing Start: ");
try {
    for (int i = 0; i < linkUser.size(); i++) {
        System.out.println(linkUser.get(i).getText());
        String linkLogmembername = linkUser.get(i).getText();
        if (linkLogmembername.equals(GlobalVariable.teamMeberName)) {
            println(GlobalVariable.teamMeberName)
            WebUI.delay(2)
            currentTime = driver.findElement(By.xpath("//div[@class = 'call-log']/div[@class = 'call-log-cell'][5]")).getText();
            println("currentTime :" + currentTime)

            varX = currentTime.split(' ')
            String varY = varX[1].replace("S", "")

            currentTimeInt = Integer.parseInt(varY)

            if (currentTimeInt - previousTime > 4 && currentTimeInt - previousTime <= 10) {
                println("Increased success!!");
            } else {
                throw new Error('Alert not found')
            }
        }
    }
} catch (org.openqa.selenium.StaleElementReferenceException ex) {
    println("SERE" + ex)
}