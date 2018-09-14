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

//filter a valid duration
'click on filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter button POP UP is open'
if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
  println ("open filter POP Up successful")
}else{
  println('filter container not open')
}

'Enter  a duration in the filter'
WebUI.setText(findTestObject('Object Repository/durationFilter/durationFilter'), GlobalVariable.timespent)

'click on inner filter buttom'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//remove duration and filter
'Click on filter Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter POP UP'
if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
  println ("open filter POP Up successful")
}else{
  println('filter container not open')
}
 
'delete the already exist input time spent'
WebUI.sendKeys(findTestObject('Object Repository/durationFilter/durationFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
   
'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))
	
WebUI.delay(5)

//Filter a empty duration
'Enter the space in the time spent filter input'
WebUI.setText(findTestObject('Object Repository/durationFilter/durationFilter'), ' ')

'Click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

//Filter a Alphabet tag in the duration 
'enter the alphabet tag filter'
WebUI.setText(findTestObject('Object Repository/durationFilter/durationFilter'), "ertyui9iu898")

'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

//Remove the duration tag 
'delete the exist data in the time spent filter'
WebUI.sendKeys(findTestObject('Object Repository/durationFilter/durationFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

//filter special characters
'enter the special charector in the filter'
WebUI.setText(findTestObject('Object Repository/durationFilter/durationFilter'), "~#")

'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

//filter invalid duration
'enter the not avaialable tag in the database'
WebUI.setText(findTestObject('Object Repository/durationFilter/durationFilter'), "1111111111111")

'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))


WebUI.verifyElementPresent(findTestObject('Object Repository/LinkLogFilter/noTagAvailable'), 5, FailureHandling.OPTIONAL)