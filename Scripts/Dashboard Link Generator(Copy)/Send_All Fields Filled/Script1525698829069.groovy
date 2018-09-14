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
import javax.mail.Flags as Flags

WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

sleep(2000)
WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

WebUI.delay(2)

WebUI.setText(findTestObject('Dashboard_Link Generator/Input_Name'), GlobalVariable.Name)

WebUI.setText(findTestObject('Dashboard_Link Generator/Input_Email'), GlobalVariable.Email)

WebUI.setText(findTestObject('Dashboard_Link Generator/contact'), GlobalVariable.Mobile_Number)

WebUI.setText(findTestObject('Dashboard_Link Generator/tag'), GlobalVariable.Extra_Tag)

if (WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/checkbox_phone '), 1, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Dashboard_Link Generator/checkbox_phone '))
}

if (WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/checkbox_mail'), 1, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Dashboard_Link Generator/checkbox_mail'))
}

WebUI.delay(2)

WebUI.click(findTestObject('Dashboard_Link Generator/sendButtonActive '))

//if(WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 5)){
//	validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))
//	
//		WebUI.verifyMatch(validationMessage, GlobalVariable.validation_email_sms_send, false)
//	
//		println('successful')
//}else{
//   throw new Error('Alert not found')
//}
sleep(2000)

String Link = getLink()

if (Link.equals('unavailable')) {
    println('Link unavailable')
} else {
    WebUI.callTestCase(findTestCase('other/Utils/Open New Tab'), [('path') : getLink()], FailureHandling.CONTINUE_ON_FAILURE)

    int currentTab = WebUI.getWindowIndex()

    WebUI.switchToWindowIndex(currentTab + 1)

//    WebUI.callTestCase(findTestCase('Dashboard Link Generator(Copy)/zGet Link_Communication/zPage_Caller/Calling'), [:], 
//        FailureHandling.CONTINUE_ON_FAILURE)

//    WebUI.callTestCase(findTestCase('Dashboard Link Generator(Copy)/zGet Link_Communication/Perform Call'), [('currentTab') : currentTab
//            , ('called') : true, ('doOtherThingsToo') : false], FailureHandling.CONTINUE_ON_FAILURE)
}

String getLink() {
    String host = 'imap.gmail.com'

    String msg

    String msgSub

    String[] s

    String link = 'unavailable'

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

        if (msgSub.equals('From MahindraSYouV')) {
            msg = message.getContent().toString()

            s = msg.substring(msg.indexOf('http')).split(' ')

            link = (s[0])

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
    
    return link
}

