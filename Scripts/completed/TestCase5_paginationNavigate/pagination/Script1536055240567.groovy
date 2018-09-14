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
import com.kms.katalon.core.webui.keyword.builtin.getCSSValueKeyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

'Login with valid User ID  '
WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)
WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()
//WebUI.delay(5)

'get link log count in the link log section'
linkLog = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div"))
println('linklogCount :' + linkLog.size())

sizeStore = linkLog.size();

'get link generator state count'
linkGeneratorCount = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]")).getText();
println(linkGeneratorCount)

linkGeneratorCount = Integer.parseInt(linkGeneratorCount.split(" ")[0]);
println(linkGeneratorCount);

if(WebUI.verifyElementPresent(findTestObject('Object Repository/pagi/paginationFooter'), 2)){
	//active navigation button
	cssValue = WebUI.getCSSValue(findTestObject('pagi/div_pagination-icon next-icn'),'background')
	println(cssValue)
	
	
	String words=cssValue.split("\"")[1];//splits the string based on string
	System.out.println(words);
	String word2=words.split("/")[3];
	System.out.println(word2);
   
	//inactive navigation button
	inActiveCssValue = WebUI.getCSSValue(findTestObject('pagi/div_pagination-icon'),'background')
	println(inActiveCssValue)
	 
	String notActivatedCss =inActiveCssValue.split("\"")[1];//splits the string based on string
	System.out.println(notActivatedCss);
	String cssNotActive = notActivatedCss.split("/")[3];
	System.out.println(cssNotActive);
	 
	if(linkGeneratorCount > sizeStore-2){
		 compare = true;
		 
		 while (compare) {
			 linkGeneratorCount++;
			 WebUI.click(findTestObject('pagi/div_pagination-icon next-icn'))
			 //active navigation button
			 cssValue = WebUI.getCSSValue(findTestObject('pagi/div_pagination-icon next-icn'),'background')
			 println(cssValue)
			 
			WebUI.delay(5)
			 
		      words=cssValue.split("\"")[1];//splits the string based on string
			 System.out.println(words);
			  word2=words.split("/")[3];
			 System.out.println(word2);
			 
			 compare = cssNotActive != word2;
			 println(compare)
	
		 WebUI.verifyElementPresent(findTestObject('pagi/div_pagination-icon'), 3)
	   }
	  }
     }
	 
'validate the paginaion'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/pagi/div_pagination-icon'), 5, FailureHandling.OPTIONAL)) {
	println('successful')
} else {
	throw new Error('inactive pagination not found')
}

	 
	
	