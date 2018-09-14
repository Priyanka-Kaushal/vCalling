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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
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
	
	WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))
	
	String x = (CustomKeywords.'newPackage.newKeyword.randomString'(3)).toLowerCase()
	
	GlobalVariable.teamMeberName = x
	
	WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), x)
	
	WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(10)+'@gmail.com')

	String number = (CustomKeywords.'phoneNumbers.contactNumbers.randomString'(9))
	
	GlobalVariable.Mobile_Number = number
	
	WebUI.setText(findTestObject('Dashboard_Link Generator/contactNumber'), number+'1')
	
	WebUI.click(findTestObject('Dashboard_Link Generator/div_GET LINK'))

	getLink = WebUI.getAttribute(findTestObject('Dashboard_Link Generator/shortLinkUrlCopy'), 'value')
	println (getLink)

	WebUI.delay(2)
	WebUI.click(findTestObject('Dashboard_Link Generator/shortLinkCOpy'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Dashboard_Link Generator/linkCopyShort'))
	if(WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 5, FailureHandling.OPTIONAL)){
		
			validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))
		
			WebUI.verifyMatch(validationMessage, GlobalVariable.shortLinkCopied, false)
		
			println('successful')
		}else{
		
			throw new Error('Alert not found')
		
		}
		
		WebUI.delay(5)
		
		List<WebElement> linkUserName = driver.findElements(By.className("text-link-log"));
		int previousCountValue = 0;
		for (int i = 0; i < linkUserName.size(); i++) {
			
			//System.out.println("Admin Console: "+linkUserName.get(i).getText());
		
			String linkLogmembername = linkUserName.get(i).getText();
		
		 if(linkLogmembername.equals(GlobalVariable.teamMeberName)){
		   System.out.println("Admin Console: "+ linkLogmembername);
		 }
		}

		JavascriptExecutor js = ((driver) as JavascriptExecutor)
		
		js.executeScript('window.open();')
		currentWindow =  WebUI.getWindowIndex()
		//Go in to new tab
		WebUI.switchToWindowIndex(currentWindow + 1)
		WebUI.navigateToUrl(getLink)
	
		int currentTab = WebUI.getWindowIndex()
		
