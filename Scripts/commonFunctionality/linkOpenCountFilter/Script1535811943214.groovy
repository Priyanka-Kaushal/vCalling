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

//filter count
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
	
 println ("open filter POP Up successful")

   }else{

 println('filter container not open')

   }
  
'Open link count displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.linkOpenCount)
   
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)
//--------------------------------------------------------
'click on filter button '
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate the filter pop up is open'
if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
println ("open filter POP Up successful")
}else{
println('filter container not open')
}
 
//filter empty count
'empty filter'
WebUI.sendKeys(findTestObject('LinkLogFilter/openLinkCount'), Keys.chord(Keys.BACK_SPACE))

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//Filter a empty space
'eneter the space in the filter'
WebUI.sendKeys(findTestObject('LinkLogFilter/openLinkCount'),' ')

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

//enter a alpha characters
'enter the alpha tag filter after filter'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), "ertyui")

'validate the no link logs present'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

//Enter a Special charecters
WebUI.sendKeys(findTestObject('LinkLogFilter/openLinkCount'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

'enter the special charector in the filter'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), "~#")

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

//enter a invalid data
'enter the not avaialable tag in the database'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), "1111111111111")
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

'validate the no link logs present after filter'
WebUI.verifyElementPresent(findTestObject('Object Repository/LinkLogFilter/noTagAvailable'), 5, FailureHandling.OPTIONAL)