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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


'click on filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter button POP UP is open'
if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
  println ("open filter POP Up successful")
}else{
  println('filter container not open')
}

'Enter  a time spent in the filter'		  
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), GlobalVariable.timespent)

'click on inner filter buttom'	 
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//filter empty time spent
'Enter the lik log filter Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'Click on filter button'
if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
  println ("open filter POP Up successful")
}else{
  println('filter container not open')
}
 
'delete the already exist input time spent'
WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
   
'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))
	
WebUI.delay(5)

//Filter a space in the time spent 
'Enter the space in the time spent filter input'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), ' ')

'Click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

//Filter a alphabet in the time spent
'enter the alphabet tag filter'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), "ertyui9iu898")

'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

//Filter a special characters
'delete the exist data in the time spent filter'
WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

'enter the special charector in the filter'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), "~#")

'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

//Filter a invalid value
'enter the not avaialable tag in the database'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), "1111111111111")

'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.verifyElementPresent(findTestObject('Object Repository/LinkLogFilter/noTagAvailable'), 5, FailureHandling.OPTIONAL)

//Filter a invalid value
'click on filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter button POP UP is open'
if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
  println ("open filter POP Up successful")
}else{
  println('filter container not open')
}

'enter the not avaialable tag in the database'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), "accc")

'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))


'after alpha numeric value enter, validate the validation message'
 if(WebUI.verifyElementPresent(findTestObject('Dashboard_Link Generator/validation'), 5, FailureHandling.OPTIONAL)){

  validationMessage = WebUI.getText(findTestObject('Dashboard_Link Generator/validation'))

  WebUI.verifyMatch(validationMessage, GlobalVariable.alphabetValidation, false)

  println('successful')
}else{

	throw new Error('Alert not found')

}

//WebUI.clickOffset(findTestObject('Object Repository/customerDetailsEdit/customerDetailScreen'), 100, 200)
