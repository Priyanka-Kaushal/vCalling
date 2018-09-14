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
import javax.mail.Flags as Flags

WebUI.openBrowser('')

WebUI.maximizeWindow()

'open a link through global varaiable'
WebUI.navigateToUrl(GlobalVariable.URL)

'enter the email id through global variable'
WebUI.setText(findTestObject('Object Repository/Login/UserId'), GlobalVariable.Email)

//WebUI.delay(4)
'click on GET OTP Button'
WebUI.click(findTestObject('Object Repository/Login/div_GET OTP'))
//WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('Object Repository/Login/div_SUBMIT'), 50)

if (WebUI.verifyElementNotPresent(findTestObject('Login/div_SUBMIT'), 5, FailureHandling.OPTIONAL)) {
    throw new Error('Took too long to load the page to enter the OTP')
}

sleep(5000)

String OTP = getOTP()

if (OTP.equals('unavailable')) {
    println('OTP unavailable')
} else {
    WebUI.setText(findTestObject('Object Repository/Login/OtpInput'), OTP)
}

String getOTP() {
    String host = 'imap.gmail.com'

    String msg

    String msgSub

    String OTP = 'unavailable'

    Properties props = new Properties()

    props.setProperty('mail.imap.ssl.enable', 'true')

    Session session = Session.getInstance(props)

    Store store

    try {
        store = session.getStore('imap')

        store.connect(host, GlobalVariable.Email, GlobalVariable.Password)

        Folder emailFolder = store.getFolder('INBOX')

        emailFolder.open(Folder.READ_WRITE)

        Message[] messages = emailFolder.getMessages()

        int n = messages.length

        Message message = messages[(n - 1)]

        msgSub = message.getSubject()

        if (msgSub.equals('OTP to Sign In')) {
            msg = message.getContent().toString()

            '7, bcoz 5 characters of OTP and \'\\n\' at the end, which is \'Enter\' and hence we haven\'t used \'Submit\' button click'
            OTP = msg.substring(msg.length() - 7)

            message.setFlag(Flags.Flag.DELETED, true)
        }
        
        emailFolder.close(true)

        store.close()
    }
    catch (NoSuchProviderException ex) {
        println('NSPE : ' + ex)
    } 
    catch (MessagingException ex) {
        println('ME : ' + ex)
    } 
    catch (IOException ex) {
        println('IO : ' + ex)
    } 
    
    return OTP
}

'validate the dashboard'
WebUI.verifyElementPresent(findTestObject('Object Repository/Login/afterOpenDisplay'), 30, FailureHandling.STOP_ON_FAILURE)
