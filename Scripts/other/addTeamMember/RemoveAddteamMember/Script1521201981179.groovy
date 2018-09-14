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
//import com.thoughtworks.selenium.Selenium
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import internal.GlobalVariable as GlobalVariable
//import org.openqa.selenium.By as Selenium
//import org.openqa.selenium.WebDriver as WebDriver
//import org.openqa.selenium.By as By
//
//import org.openqa.selenium.WebElement as WebElement
//
//import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//
//
//WebUI.callTestCase(findTestCase('BVT/aSimple_Login'), null)
//
//WebUI.delay(2)
//
//WebUI.click(findTestObject('AddTeamMemberDashboard/div_TEAM MEMBERS'))
//
//
//WebUI.click(findTestObject('AddTeamMemberDashboard/addTeamMem'))
//
//String x = (CustomKeywords.'newPackage.newKeyword.randomString'(3)).toLowerCase()
//
//GlobalVariable.teamMeberName = x
//
//WebUI.setText(findTestObject('AddTeamMemberDashboard/name'), x)
//
//WebUI.delay(5)
//
//WebUI.setText(findTestObject('AddTeamMemberDashboard/email'), CustomKeywords.'newPackage.newKeyword.randomString'(10)+'@gmail.com')
//
//
//WebUI.setText(findTestObject('AddTeamMemberDashboard/contactNumber'), '8989898989')
//
//WebUI.click(findTestObject('AddTeamMemberDashboard/add-team-member-checkbox'))
//
//WebUI.click(findTestObject('AddTeamMemberDashboard/AddTeamMemberSave'))
//
//WebUI.delay(4)
//
//def driver = DriverFactory.getWebDriver()
//
//DriverFactory.getWebDriver()
//
////xpathArray = driver.findElements(By.xpath("//div[@class='card-team-member']/div[@class='name-team-member']"))
//List<WebElement> actmenu = driver.findElements(By.className("name-team-member"));
//   
//   try {
//	   for (int i = 0; i < actmenu.size(); i++) {
//		   System.out.println(actmenu.get(i).getText());
//		   System.out.println(GlobalVariable.teamMeberName);
//		   String membername = actmenu.get(i).getText();
//		   if(membername.equals(GlobalVariable.teamMeberName)){
//			   System.out.println("Available");
//			   actmenu.get(i).click();
//		   }		   
//		  }
//		  
//   }
//   catch(org.openqa.selenium.StaleElementReferenceException ex)
//   {
//	   println('SERE : ' + ex)
//   }
//   
//WebUI.delay(2)
//
//WebUI.click(findTestObject('AddTeamMemberDashboard/div_Remove'))
//
//WebUI.click(findTestObject('AddTeamMemberDashboard/div_YES'))
//
////List<WebElement> cssProperty = driver.findElements(By.className("name-team-member"));
////String color = cssProperty.getCssValue("background-color");
////
//////System.out.println("Color of a button before mouse hover: "	+ cssProperty);
//////try {
////	for (int i = 0; i < cssProperty.size(); i++) {
////		System.out.println(cssProperty.get(i).getText());
////		System.out.println(cssProperty.get(i).getCssValue("background"));
////		System.out.println(GlobalVariable.teamMeberName);
////		String card = cssProperty.get(i).getText();
//////		if(card.equals(GlobalVariable.teamMeberName)){
//////			System.out.println("Available");
//////		}
////	   }
////	   
//////}
////catch(org.openqa.selenium.StaleElementReferenceException ex)
////{
////	println('SERE : ' + ex)
////}
//
