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
import java.io.IOException as IOException
import java.util.Properties as Properties
import java.util.logging.Level as Level
import java.util.logging.Logger as Logger
import javax.mail.Folder as Folder
import javax.mail.Message as Message
import javax.mail.MessagingException as MessagingException
import javax.mail.NoSuchProviderException as NoSuchProviderException
import javax.mail.Session as Session
import javax.mail.Store as Store
import org.junit.After
import javax.mail.Flags as Flags
import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.By as Selenium
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

WebUI.click(findTestObject('Dashboard_Link Generator/div_send-link-button'))

String nameEmail = (CustomKeywords.'newPackage.newKeyword.randomString'(3)).toLowerCase()

GlobalVariable.teamMeberName = nameEmail

String number = (CustomKeywords.'phoneNumbers.contactNumbers.randomString'(8))

GlobalVariable.Mobile_Number = number

WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), nameEmail)

WebUI.delay(5)

WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(10)+'@gmail.com')
WebUI.setText(findTestObject('Dashboard_Link Generator/contactNumber'), number)
sleep(2000)
WebUI.setText(findTestObject('Dashboard_Link Generator/tags'), nameEmail)
'Email Phone - CPhone CEmail'

'Case 1: yyyy'

if (WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/checkbox_phone '), 1, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Dashboard_Link Generator/checkbox_phone '))
}

if (WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/checkbox_mail'), 1, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Dashboard_Link Generator/checkbox_mail'))
}

WebUI.click(findTestObject('Dashboard_Link Generator/sendButtonActive '))
//WebUI.click(findTestObject('Dashboard_Link Generator/sendButtonNotActive'))

if(WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 5, FailureHandling.OPTIONAL)){
	validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))
	
		WebUI.verifyMatch(validationMessage, GlobalVariable.validation_email_sms_send, false)
	
		println('successful')
}else{
   throw new Error('Alert not found')
}

WebUI.delay(5);

def driver = DriverFactory.getWebDriver()

DriverFactory.getWebDriver()


List<WebElement> linkUserName = driver.findElements(By.className("text-link-log"));

try {
	for (int i = 0; i < linkUserName.size(); i++) {
		System.out.println(linkUserName.get(i).getText());
		System.out.println(GlobalVariable.Mobile_Number);
		String linkLogmembername = linkUserName.get(i).getText();
		if(linkLogmembername.equals(GlobalVariable.teamMeberName)){
			System.out.println("link log Available");
			linkUserName.get(i).click();
		}
	   }
	   
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	println('SERE : ' + ex)
}

WebUI.clickOffset(findTestObject('Object Repository/Dashboard_Link Generator/userDetailScreen'), 100, 100)

'case 2: email/phone and mail checkBox selected'
WebUI.click(findTestObject('Dashboard_Link Generator/div_send-link-button'))

WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), nameEmail+1)

WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(8)+'@gmail.com')
WebUI.setText(findTestObject('Dashboard_Link Generator/contactNumber'), number+'1')
sleep(2000)
WebUI.setText(findTestObject('Dashboard_Link Generator/tags'), nameEmail)
if (WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/checkbox_mail'), 1, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Dashboard_Link Generator/checkbox_mail'))
}

WebUI.click(findTestObject('Dashboard_Link Generator/sendButtonActive '))

if(WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 3)){
	validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))
	
			WebUI.verifyMatch(validationMessage, GlobalVariable.validation_mail_send, false)
	
		println('successful')
	}else{
	   throw new Error('Alert not found')
	}

	
	WebUI.delay(5)


'case 3:email/phone and phone checkBox selected'

WebUI.click(findTestObject('Dashboard_Link Generator/div_send-link-button'))

WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), nameEmail+1)

WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(7)+'@gmail.com')
WebUI.setText(findTestObject('Dashboard_Link Generator/contactNumber'), number+'1')

    if (WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/checkbox_phone '), 1, FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Dashboard_Link Generator/checkbox_phone '))
	}

WebUI.click(findTestObject('Dashboard_Link Generator/sendButtonActive '))


  if(WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 5, FailureHandling.OPTIONAL)){
	  validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))
	
	  WebUI.verifyMatch(validationMessage, GlobalVariable.validation_phone_smsSend, false)
	
	  println('successful')
  }else{
     throw new Error('Alert not found')
  }

WebUI.delay(5)
'Case 4:checkBox not selected'

WebUI.click(findTestObject('Dashboard_Link Generator/div_send-link-button'))

WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), nameEmail+1)

WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(6)+'@gmail.com')
WebUI.setText(findTestObject('Dashboard_Link Generator/contactNumber'), number+'1')

sleep(2000)

WebUI.click(findTestObject('Dashboard_Link Generator/sendButtonNotActive'))
   if(WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 3)){
	   validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))
	
		WebUI.verifyMatch(validationMessage, GlobalVariable.validation_checkboxNotSelected, false)
	
		println('successful')
   }else{
        throw new Error('Alert not found')
   }
WebUI.delay(2)

WebUI.clickOffset(findTestObject('Dashboard_Link Generator/linkGeneratorScreen'), 100, 100)

