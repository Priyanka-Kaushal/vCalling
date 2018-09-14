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

WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)
WebDriver driver = DriverFactory.getWebDriver()
WebUI.delay(2)

WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

WebUI.delay(2)
String x = (CustomKeywords.'newPackage.newKeyword.randomString'(3)).toLowerCase()

GlobalVariable.teamMeberName = x

String number = (CustomKeywords.'phoneNumbers.contactNumbers.randomString'(8))

GlobalVariable.Mobile_Number = number

WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), x)

WebUI.delay(5)

WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(10)+'@gmail.com')

WebUI.setText(findTestObject('Dashboard_Link Generator/contactNumber'), number)

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/div_GET LINK'), 30)

WebUI.click(findTestObject('Dashboard_Link Generator/div_GET LINK'))

WebUI.delay(4)

getLink = WebUI.getAttribute(findTestObject('Dashboard_Link Generator/input_link-text'), 'value')
println (getLink)

WebUI.click(findTestObject('Dashboard_Link Generator/copyLink'))
WebUI.delay(2)

List<WebElement> linkUserName = driver.findElements(By.className("link-log-cell"));
int previousTime = 0;
	for (int i = 0; i < linkUserName.size(); i++) {
		System.out.println("Admin Console: "+linkUserName.get(i).getText());
		String linkLogmembername = linkUserName.get(i).getText();
		if(linkLogmembername.equals(GlobalVariable.teamMeberName)){
			System.out.println("Admin ConsoleName: " + "successful");
			String previousTime1 = driver.findElement(By.xpath("//div[@class = 'link-log']/div[@class = 'link-log-cell'][5]")).getText();
			System.out.println("timeActual : " + previousTime1);
			WebUI.delay(2)
		}
	}
	
	'open a browser through linkGenrator'
	JavascriptExecutor js = ((driver) as JavascriptExecutor)
	
	js.executeScript('window.open();')
	currentWindow =  WebUI.getWindowIndex()
	//Go in to new tab
	WebUI.switchToWindowIndex(currentWindow + 1)
	WebUI.navigateToUrl(getLink)
	
	//start watch
	long start = System.currentTimeMillis();
	println("start browser time :" + start)
     
	WebUI.click(findTestObject('Object Repository/timeSpentOnlink/stepInsideButton'))
	WebUI.delay(32)
	DriverFactory.getWebDriver()
	
		List<WebElement> mediaTour = driver.findElements(By.className('media-none'))
	
		println('media size ' + mediaTour.size())
	
		for (int i = 0; i < mediaTour.size() + 1; i++) {
			WebUI.click(findTestObject('Object Repository/timeSpentOnlink/rightNavigationButton'))
			WebUI.delay(1)
		}
	
		for (int i = mediaTour.size()+1; i > 0; i--) {
			WebUI.click(findTestObject('Object Repository/timeSpentOnlink/leftNavigationBuutton'))
			WebUI.delay(1)
		}
		
	
		WebUI.click(findTestObject('Object Repository/timeSpentOnlink/backButtonMediatour'))
		
	//stop watch
	long finish = System.currentTimeMillis();
	println("close browser time :" + finish);
	
	WebUI.closeWindowIndex(1)
	
    long totalTime = finish - start;
	println ("totaltime:" + totalTime)
	
	//1000 milliseconds=1 second 
	//60000 milliseconds = 1 minute
	int milliseconds = 1000;
	
	int timeActualSeconds =(totalTime/milliseconds);
	println ("milliseconds conevrt into sec :" + timeActualSeconds)
	
	int mod = 60;
	int S = timeActualSeconds%60;
	println ("Actual time" + S)
	
	long Min =(timeActualSeconds)/60;
	timeSpentOnBrowser = String.format("%dM %dS", Min, S)
	println ("total time spent on browser:"+ timeSpentOnBrowser)
	
    
	WebUI.switchToWindowIndex(0)
	
	WebUI.delay(2)
	
	WebUI.refresh()
	WebUI.acceptAlert()
	
	WebUI.delay(20)
	
	List<WebElement> linkUser = driver.findElements(By.className("link-log-cell"));
	println("Admin Console: "+ linkUser);
	  for (int i = 0; i < linkUser.size(); i++) {
		System.out.println(linkUser.get(i).getText());
		String linkLogmembername = linkUser.get(i).getText();
		if(linkLogmembername.equals(GlobalVariable.teamMeberName)){
		  println(GlobalVariable.teamMeberName)
		  WebUI.delay(3)
		  currentTime =  driver.findElement(By.xpath("//div[@class = 'link-log']/div[@class = 'link-log-cell'][5]")).getText();
		  println("currentTime :" + currentTime)
		 
		  varX = currentTime.split(' ')
		  String Minutes = varX[0].replace("M","")
		  
		  varY = currentTime.split(' ')
		  String Seconds = varY[1].replace("S","")
		  
		  currentTimeMin = Integer.parseInt(Minutes)
		  println("currentTimeMin :" + currentTimeMin)
		  
		  currentTimeSec = Integer.parseInt(Seconds)
		  println ("currentTimeSec :" + currentTimeSec)
		  
             WebUI.delay(3)
//			 if(currentTimeMin-Min <= 1){
//				 println("Increased success Minutes!!");
//			 }
//			 else{
//				 throw new Error('Alert not found minutes')
//			 }
//			 
//			 int secondsNew = S-currentTimeSec;
//			 println ("printin sec :" + secondsNew)
//			 
//			 if(secondsNew >= 4 && secondsNew <= 10){
//				 println("Increased success Seconds!!");
//			 }
//			 else{
//				 throw new Error('Alert not found seconds')
//			 }
		}
	 }
	  
	  