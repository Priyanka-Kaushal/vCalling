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

// filter the empty tag and empty duration
WebUI.click(findTestObject('Object Repository/callLogs/refreshButton'))
WebUI.delay(6)
'Click on filer Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))
'validate filter POP UP is open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
	println("open filter POP Up successful")
} else {
	println('filter container not open')
}

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))
WebUI.delay(5)
WebUI.clickOffset(findTestObject('Object Repository/callLogs/filterScreen'), 100, 200)

//Filter a valid duration with empty tag
'Click on filer Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))
'validate filter POP UP is open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
	println("open filter POP Up successful")
} else {
	println('filter container not open')
}

'Enter  a time spent in the filter'
WebUI.setText(findTestObject('Object Repository/durationFilter/durationFilter'), GlobalVariable.timespent)

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//-----------

'Click on filer Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter POP UP is open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
	println("open filter POP Up successful")
} else {
	println('filter container not open')
}

WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), ' ')

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(3)
//----------------

'Click on filer Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter POP UP is open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
	println("open filter POP Up successful")
} else {
	println('filter container not open')
}

WebUI.setText(findTestObject('Object Repository/durationFilter/durationFilter'), '9090000')

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(3)
WebUI.verifyElementPresent(findTestObject('Object Repository/LinkLogFilter/noTagAvailable'), 5, FailureHandling.OPTIONAL)