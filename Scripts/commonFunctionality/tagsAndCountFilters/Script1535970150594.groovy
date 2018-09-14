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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver


//filter a valid tag and valid count
'click on filter bbutton'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter pop up open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
    println("open filter POP Up successful")
} else {
    println('filter container not open')
}

'filter tag'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), GlobalVariable.tag)

'Filter Open link count'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.linkOpenCount)

'click on inner Filter Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//filter a valid count invalid tag

WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {

    println("open filter POP Up successful")

} else {

    println('filter container not open')

}

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), "hjkjlk;l")

WebUI.sendKeys(findTestObject('LinkLogFilter/openLinkCount'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))

WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), '0')

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.clickOffset(findTestObject('Object Repository/filter/filterScreen'), 100, 200)

//filter a invalid count and valid tag

WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
    println("open filter POP Up successful")
} else {
    println('filter container not open')
}

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
WebUI.delay(3)

WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), GlobalVariable.tag)

WebUI.delay(3)

'Open link count displayed'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), "2222666")

WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//Filter a valid count and numeric tag
'click on filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter pop up open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
    println("open filter POP Up successful")
} else {
    println('filter container not open')
}

'filter tag'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), "212321")

'Filter Open link count'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.linkOpenCount)

'click on inner Filter Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.delay(5)

//Filter a alpha characters count and valid tag

'click on filter bbutton'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter pop up open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
    println("open filter POP Up successful")
} else {
    println('filter container not open')
}

WebUI.sendKeys(findTestObject('Object Repository/LinkLogFilter/TagFilter'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
'filter tag'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), GlobalVariable.tag)

WebUI.sendKeys(findTestObject('LinkLogFilter/openLinkCount'), Keys.chord(Keys.CONTROL + "a", Keys.DELETE))
'Filter Open link count'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), "aadads")

'click on inner Filter Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))
WebUI.clickOffset(findTestObject('Object Repository/filter/filterScreen'), 100, 200)
WebUI.delay(5)

//Filter a special characters in count and  and numeric tag
'click on filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter pop up open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
    println("open filter POP Up successful")
} else {
    println('filter container not open')
}

'filter tag'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), GlobalVariable.tag)

'Filter Open link count'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), "###~")

'click on inner Filter Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.clickOffset(findTestObject('Object Repository/filter/filterScreen'), 100, 200)

WebUI.delay(5)

//Filter a special characters tag and valid count
'click on filter button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/FilterButton'))

'validate filter pop up open'
if (WebUI.verifyElementPresent(findTestObject('filter/filterContainer'), 5, FailureHandling.OPTIONAL)) {
    println("open filter POP Up successful")
} else {
    println('filter container not open')
}

'filter tag'
WebUI.setText(findTestObject('Object Repository/LinkLogFilter/TagFilter'), ";'#")

'Filter Open link count'
WebUI.setText(findTestObject('LinkLogFilter/openLinkCount'), GlobalVariable.linkOpenCount)

'click on inner Filter Button'
WebUI.click(findTestObject('Object Repository/LinkLogFilter/innerFilterButton'))

WebUI.clickOffset(findTestObject('Object Repository/filter/filterScreen'), 100, 200)

WebUI.delay(5)