//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
//import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//import com.kms.katalon.core.model.FailureHandling as FailureHandling
//import com.kms.katalon.core.testcase.TestCase as TestCase
//import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
//import com.kms.katalon.core.testdata.TestData as TestData
//import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
//import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
//import com.kms.katalon.core.testobject.TestObject as TestObject
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import internal.GlobalVariable as GlobalVariable
//
//WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)
//
//WebUI.delay(2)
//
//WebUI.click(findTestObject('AddTeamMemberDashboard/div_TEAM MEMBERS'))
//
//WebUI.click(findTestObject('AddTeamMemberDashboard/addTeamMem'))
//
//String x = CustomKeywords.'newPackage.newKeyword.randomString'(3).toLowerCase()
//
//GlobalVariable.teamMeberName = x
//
////validation message check for name
//WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), x)
//
//WebUI.click(findTestObject('Object Repository/AddTeamMemberDashboard/AddTeamMember'))
//
//if(WebUI.verifyElementPresent(findTestObject('Object Repository/AddTeamMemberDashboard/validationNameEmail'), 5, FailureHandling.OPTIONAL)){
//	
//		validationMessage = WebUI.getText(findTestObject('Object Repository/AddTeamMemberDashboard/validationNameEmail'))
//	
//		WebUI.verifyMatch(validationMessage, GlobalVariable.validationNameEmail, false)
//	
//		println('successful')
//	}else{
//		throw new Error('Alert not found')
//	}
//	
////validation message check for name and email
//WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(10) +
//	'@gmail.com')
//
//WebUI.click(findTestObject('Object Repository/AddTeamMemberDashboard/AddTeamMember'))
//
//if(WebUI.verifyElementPresent(findTestObject('Object Repository/AddTeamMemberDashboard/validationNameEmail'), 5, FailureHandling.OPTIONAL)){
//	
//		validationMessage = WebUI.getText(findTestObject('Object Repository/AddTeamMemberDashboard/validationNameEmail'))
//	
//		WebUI.verifyMatch(validationMessage, GlobalVariable.validationNameEmail, false)
//	
//		println('successful')
//	}else{
//		throw new Error('Alert not found')
//}
//
////check validation message for inavlid email id
//	WebUI.delay(5)
//	
//	WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(10) +
//		'.gmail@com')
//	
//	WebUI.click(findTestObject('Object Repository/AddTeamMemberDashboard/AddTeamMember'))
//	
//	if(WebUI.verifyElementPresent(findTestObject('Object Repository/AddTeamMemberDashboard/validationNameEmail'), 5, FailureHandling.OPTIONAL)){
//		
//			validationMessage = WebUI.getText(findTestObject('Object Repository/AddTeamMemberDashboard/validationNameEmail'))
//		
//			WebUI.verifyMatch(validationMessage, GlobalVariable.invalidEmail, false)
//		
//			println('successful')
//		}else{
//			throw new Error('Alert not found')
//	}
//		
////check validation for invalid number
//
////		WebUI.setText(findTestObject('AddTeamMemberDashboard/contactNumber'), '123989999')
////		
////		WebUI.delay(2)
////		
////		WebUI.click(findTestObject('Object Repository/AddTeamMemberDashboard/AddTeamMember'))
////		
////		if(WebUI.verifyElementPresent(findTestObject('Object Repository/AddTeamMemberDashboard/validationNameEmail'), 5, FailureHandling.OPTIONAL)){
////			
////				validationMessage = WebUI.getText(findTestObject('Object Repository/AddTeamMemberDashboard/validationNameEmail'))
////			
////				WebUI.verifyMatch(validationMessage, GlobalVariable.invalidEmail, false)
////			
////				println('successful')
////			}else{
////				throw new Error('Alert not found')
////		}
//			
////check with all valid details 
