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

'Login with valid User ID  '
WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

String x = CustomKeywords.'newPackage.newKeyword.randomString'(3).toLowerCase()

GlobalVariable.teamMeberName = x

'Enter the customer name'
WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), x)

'Enter the customer Id'
WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(10) +
	'@gmail.com')

'Enter the Tag'
WebUI.setText(findTestObject('Dashboard_Link Generator/tag'), GlobalVariable.Extra_Tag)

'Click on get link button'
WebUI.click(findTestObject('Dashboard_Link Generator/div_GET LINK'))

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
 System.out.println("new Admin :" + linkLogmembername)
 if (linkLogmembername.equals(GlobalVariable.teamMeberName)) {
		System.out.println('Admin Console: ' + linkLogmembername)

		linkUserName.get(i).click()
	}
}

if(WebUI.verifyElementPresent(findTestObject('Object Repository/linkLog/customerProfileDetails'), 5, FailureHandling.OPTIONAL)){
	println ("open link log successful")
}else{
   println('link log container not open')
}

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Notes/addNotesCustomerDetails'), 2)){
	WebUI.click(findTestObject('Object Repository/Notes/addNotesCustomerDetails'))
	println('successful')
 }else{
	throw new Error('Add note button does not found')
 }
	
WebUI.setText(findTestObject('Object Repository/Notes/notesInputBox'), "Mass media campaigns are widely used to expose high proportions of large populations to messages through routine uses of existing media, such as television, radio, and newspapers.")

'verify save button is present then clickon save button'
if(WebUI.verifyElementPresent(findTestObject('Object Repository/Notes/clearNotes'), 2)){
	WebUI.click(findTestObject('Object Repository/Notes/clearNotes'))
	println('successful')
 }else{
	throw new Error('Add note button does not found')
 }

'verify that validation alert is displayed '
if(WebUI.verifyElementPresent(findTestObject('Object Repository/Notes/notesInputBox'), 5)){
  validationMessage = WebUI.getText(findTestObject('Object Repository/Notes/notesInputBox'))
  WebUI.verifyMatch(validationMessage, GlobalVariable.blankNotesBox, false)
  println('successful')
}else{
  throw new Error('Alert not found')
}
  
WebUI.clickOffset(findTestObject('Object Repository/customerDetailsEdit/customerDetailScreen'), 100, 200)

WebUI.click(findTestObject('Object Repository/customerDetailsEdit/refreshButton'))
