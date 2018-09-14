//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
//import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//import com.kms.katalon.core.model.FailureHandling as FailureHandling
//import com.kms.katalon.core.testcase.TestCase as TestCase
//import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
//import com.kms.katalon.core.testdata.TestData as TestData
//import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
//import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
//import com.kms.katalon.core.testobject.TestObject as TestObject
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import internal.GlobalVariable as GlobalVariable
//import org.openqa.selenium.By as Selenium
//import org.openqa.selenium.WebDriver as WebDriver
//import org.openqa.selenium.JavascriptExecutor
//import com.kms.katalon.core.webui.driver.DriverFactory
//import org.openqa.selenium.Keys as Keys
//import java.io.IOException as IOException
//import java.util.Properties as Properties
//import java.util.logging.Level as Level
//import java.util.logging.Logger as Logger
//import javax.mail.Folder as Folder
//import javax.mail.Message as Message
//import javax.mail.MessagingException as MessagingException
//import javax.mail.NoSuchProviderException as NoSuchProviderException
//import javax.mail.Session as Session
//import javax.mail.Store as Store
//import javax.mail.Flags as Flags
//import org.openqa.selenium.By as Selenium
//import org.openqa.selenium.WebDriver as WebDriver
//import org.openqa.selenium.By as By
//import org.openqa.selenium.WebElement as WebElement
//import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//import org.openqa.selenium.Keys as Keys
//import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
//import org.openqa.selenium.WebDriver
//
//WebUI.openBrowser('https://www.google.com/')
//WebUI.maximizeWindow()
//WebDriver driver = DriverFactory.getWebDriver()
//
//JavascriptExecutor js = ((driver) as JavascriptExecutor)
//
//ArrayList<Integer> arrayList = new ArrayList<String>();
//
//for(int i = 1; i<=100; i++){
//	js.executeScript('window.open();')
//	currentWindow =  WebUI.getWindowIndex()
//	//Go in to new tab
//	WebUI.switchToWindowIndex(currentWindow + 1)
//	WebUI.navigateToUrl("maildrop.cc")
//	WebUI.setText(findTestObject('Object Repository/newTab/inputbox'), i.toString())
//	WebUI.click(findTestObject('Object Repository/newTab/button'))
////	
////	'previous form filled count'
////	String preLinkOpenCount = driver.findElement(By.xpath("//h3[@id = 'msgnum']")).getText();
////	println ("count :" + preLinkOpenCount)
////	
////	String[] part = preLinkOpenCount.split("\\s");
////	println(part[0]);
////	println(part[1]);
////	
////	previousCountValue = Integer.parseInt(part[0]);
////	
////	println ("prevCountInt :" + previousCountValue)
////	
////	arrayList.add(previousCountValue);
////	
////	println("newArray" +arrayList)
////	
//}
//
//
////Thread.sleep(90000)
////
//////Get the list of window handles
////ArrayList tabs = new ArrayList (driver.getWindowHandles());
////System.out.println(tabs.size());
////
////ArrayList<Integer> arrayListNew = new ArrayList<String>();
//////Use the list of window handles to switch between windows
////for(int j = 1;j<=10; j++){
////	driver.switchTo().window(tabs.get(j));
////	
////	WebUI.click(findTestObject('Object Repository/newTab/refreshButton'))
////    sleep(2000)
////	
////	'After form filled count'
////	String AfterLinkOpenCount = driver.findElement(By.xpath("//h3[@id = 'msgnum']")).getText();
////	
////	String[] text = AfterLinkOpenCount.split("\\s");
////	println(text[0]);
////	println(text[1]);
////	int newCountValue = Integer.parseInt(text[0]);
////
////	println ("afterCountInt :" + newCountValue)
////	
////	arrayListNew.add(newCountValue);
////	
////	println("newArray" +arrayList)
////}
////
////
////ArrayList<Integer> arrayListMailFail = new ArrayList<String>();
////for (int k = 0; k < arrayList.size(); k++) {
////	if(arrayList[k] == arrayListNew[k]){
////		
////		arrayListMailFail.add(k+1);
////		println("they are not equal!!" + arrayListMailFail);
////	}
////
////}
////if(arrayListNew == arrayList+1){
////	println ("success")
////	println("increase by one")
////}
////else{
////	throw new Error("count not increase")
////}