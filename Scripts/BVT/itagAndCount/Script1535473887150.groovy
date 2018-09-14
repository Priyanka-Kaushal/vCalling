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
import org.openqa.selenium.Keys as Keys
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

for(int i=0; i<=1;i++){
WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))
WebDriver driver = DriverFactory.getWebDriver()

String x = (CustomKeywords.'newPackage.newKeyword.randomString'(3)).toLowerCase()
GlobalVariable.teamMeberName = x

'Enter the customer name'
WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), x)

'Enter the customer Id'
WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(10)+'@gmail.com')

'Enter the customer number'
String number = (CustomKeywords.'phoneNumbers.contactNumbers.randomString'(9))

GlobalVariable.Mobile_Number = number

WebUI.setText(findTestObject('Dashboard_Link Generator/contactNumber'), number+'1')

'Enter the Tag'
WebUI.setText(findTestObject('Dashboard_Link Generator/tag'), GlobalVariable.Extra_Tag)

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
	
}

//-----------------------------------------------
'click on filter bbutton'
  WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))
 
  'validate filter pop up open'
 if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
   println ("open filter POP Up successful")
}else{
   println('filter container not open')
}
	
'filter tag'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), GlobalVariable.tag)

'Filter Open link count'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.linkOpenCount)
	 
'click on inner Filter Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//-----------------------------------------

WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
	
 println ("open filter POP Up successful")

   }else{

 println('filter container not open')

   }

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
   
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), '0')
   
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//-----------------------------------------

WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
  println ("open filter POP Up successful")
}else{
  println('filter container not open')
}

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
WebUI.delay(3)

WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), GlobalVariable.tag)

WebUI.delay(3)

'Open link count displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), "2222")
   
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)