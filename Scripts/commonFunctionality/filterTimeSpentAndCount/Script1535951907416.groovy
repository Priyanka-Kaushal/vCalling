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
import org.openqa.selenium.By as Selenium
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor


//Filter a valid count and valid time spent
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate a filter button'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {

    println("open filter POP Up successful")

} else {

    println('filter container not open')

}

//WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

'Open link count displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.linkOpenCount)


//WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), GlobalVariable.timespent)

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)


//filter a alpha charectors in count and valid time spent

WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {

    println("open filter POP Up successful")

} else {

    println('filter container not open')

}

'Open link count displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.tag)

WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), GlobalVariable.linkOpenCount)

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

WebUI.clickOffset(findTestObject('Object Repository/filter/filterScreen'), 100, 200)

//Filter a valid count and invalid time spent
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter button is open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {

    println("open filter POP Up successful")

} else {

    println('filter container not open')

}

WebUI.sendKeys(findTestObject('LinkLogFilter/openLinkCount'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
'Open link count displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.timespent)

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), "899999999999999999")

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

'Validate not available link log'
WebUI.verifyElementPresent(findTestObject('Object Repository/LinkLogFilter/noTagAvailable'), 5, FailureHandling.OPTIONAL)

//Filter a valid count and special charectors

WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter button is open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {

    println("open filter POP Up successful")

} else {

    println('filter container not open')

}

WebUI.sendKeys(findTestObject('LinkLogFilter/openLinkCount'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
'Open link count displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.timespent)

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), "'@-")

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))
WebUI.clickOffset(findTestObject('Object Repository/filter/filterScreen'), 100, 200)


//Filter a valid count and alpha charectors
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate a filter button'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {

    println("open filter POP Up successful")

} else {

    println('filter container not open')

}

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

'Open link count displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.timespent)


WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), "ashjjk")

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.clickOffset(findTestObject('Object Repository/filter/filterScreen'), 100, 200)


//Filter a invalid count and alpha charectors
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate a filter button'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {

    println("open filter POP Up successful")

} else {

    println('filter container not open')

}

//WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

'Open link count displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), "189899")


//WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), GlobalVariable.timespent)

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))


//Filter a alpha charectors count and valid time spent
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate a filter button'
if(WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)){
	
 println ("open filter POP Up successful")

   }else{

 println('filter container not open')

   }

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

'enter a special charectors displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), "kkkj")

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

WebUI.setText(findTestObject('Object Repository/LinkLogFilter/timeSpentFilter'), GlobalVariable.timespent)

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.clickOffset(findTestObject('Object Repository/filter/filterScreen'), 100, 200)