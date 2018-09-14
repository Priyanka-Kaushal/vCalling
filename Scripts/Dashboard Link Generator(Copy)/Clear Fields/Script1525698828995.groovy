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

WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)

sleep(2000)

WebUI.click(findTestObject('Dashboard_Link Generator/linkgeneratorIcon'))

WebUI.delay(2)

WebUI.setText(findTestObject('Dashboard_Link Generator/Input_Name'), GlobalVariable.Name)

WebUI.setText(findTestObject('Dashboard_Link Generator/Input_Email'), GlobalVariable.Email)

WebUI.setText(findTestObject('Dashboard_Link Generator/contact'), GlobalVariable.Mobile_Number)

WebUI.setText(findTestObject('Dashboard_Link Generator/tag'), GlobalVariable.Extra_Tag)

WebUI.click(findTestObject('Dashboard_Link Generator/clearButton'))

WebUI.verifyElementAttributeValue(findTestObject('Dashboard_Link Generator/Input_Name'), 'value', '', 0)

WebUI.verifyElementAttributeValue(findTestObject('Dashboard_Link Generator/Input_Email'), 'value', '', 0)

WebUI.verifyElementAttributeValue(findTestObject('Dashboard_Link Generator/contact'), 'value', '', 0)

WebUI.verifyElementAttributeValue(findTestObject('Dashboard_Link Generator/tag'), 'value', '', 0)
WebUI.delay(1)

WebUI.clickOffset(findTestObject('Object Repository/Dashboard_Link Generator/linkGeneratorScreen'), 100, 100)
