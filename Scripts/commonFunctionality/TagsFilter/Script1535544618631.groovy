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

//filter a valid tag
'Click on filer Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter POP UP is open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
    println('open filter POP Up successful')
} else {
    println('filter container not open')
}

'Enter the tag and filter'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), GlobalVariable.tag)

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(20)

'download CSV After Tag filter'
WebUI.click(findTestObject('Object Repository/callLogs/downLoadCsv'))

//Remove the tag and filter
'Click on filer Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter POP UP is open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
    println('open filter POP Up successful')
} else {
    println('filter container not open')
}

'filter tag is removed'
WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + 'a', Keys.DELETE))

'click on inner filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//filter space tag
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), ' ')

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(3)

//filter a special charectors
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), '~"#')

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(3)

//Filter a numeric value in tags
'enter the not avaialable tag in the database'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), '898')

'click on filter inner button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

'Validate not available link log'
WebUI.verifyElementPresent(findTestObject('Object Repository/LinkLogFilter/noTagAvailable'), 5, FailureHandling.OPTIONAL)

WebUI.delay(5)

//Filter the invalid tag
'Click on filer Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'enter the not avaialable tag in the database'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), 'ertyui9iu898')

'click on filter inner button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

'Validate not available link log'
WebUI.verifyElementPresent(findTestObject('Object Repository/LinkLogFilter/noTagAvailable'), 5, FailureHandling.OPTIONAL)

