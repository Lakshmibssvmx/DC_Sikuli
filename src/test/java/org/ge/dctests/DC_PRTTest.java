package org.ge.dctests;

import java.io.IOException;
import org.ge.dclibrary.AppServices;
import org.ge.dclibrary.BaseLib;
import org.ge.dclibrary.GenericLib;
import org.ge.pageobjects.DC_DispatchConsolePage;
import org.ge.pageobjects.DC_SalesforcePage;
import org.ge.pageobjects.DC_ServiceMaxSetupPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;

@Test
public class DC_PRTTest extends BaseLib
{
	//WebDriver driver=null;
	Alert alert = null;
	Actions actions = null;
	Select selList = null;
	Screen scn = null;
	DC_SalesforcePage dc_salesforPage = null;
	DC_ServiceMaxSetupPage dc_servicemaxsetupPage = null;
	DC_DispatchConsolePage dc_dispatchconsolePage = null;
	AppServices appServices = null;
	Pattern pattern =null;
	String sTestCaseID=null;
	String sTeam=null;	String sTech=null; String sStreet=null; String sCity=null; String sState=null;	String sZip=null; String sCountry=null;
	String sWorkOrderID=null; String sFromDate = null; String sToDate =null; String sTechName = null; String sStartDate = null; String sEndDate = null;
	String sStartTime = null;String sEndTime = null; String sWOJsonData = null; String sWOName=null; String sTechZip = null; String sTechStreet = null;
	String sTerritoryName = null; String sParentName = null;
	
	@BeforeClass()
	public void login() throws InterruptedException, IOException
	{		
		dc_salesforPage = new DC_SalesforcePage(driver);
		dc_servicemaxsetupPage = new DC_ServiceMaxSetupPage(driver);
		dc_dispatchconsolePage = new DC_DispatchConsolePage();
		dc_salesforPage.login(GenericLib.getCongigValue(GenericLib.sConfigFile, "USERNAME"), GenericLib.getCongigValue(GenericLib.sConfigFile, "PASSWORD"));
		dc_salesforPage.sParentWnd=driver.getWindowHandle();
		appServices = new AppServices();
		appServices.getAccessToken();
		//dc_dispatchconsolePage = new DC_DispatchConsolePage();
	}
	
	@AfterClass
	public void logout()
	{
		//logout
	}
	
	@AfterMethod
	public void baseStateHome() throws Exception
	{
		driver.switchTo().window(dc_salesforPage.sParentWnd);
		dc_salesforPage.navigatehome();
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=1, enabled=true, description="RS_3807: Creating a Service Team from Service Org",groups= {"PRT","Regression"})
	public void createTeam() throws Exception
	{
		sTestCaseID="RS_3807";
		sTeam=GenericLib.getExcelData(sTestCaseID, "Team"); sStreet = GenericLib.getExcelData(sTestCaseID, "Street");sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
		
		try {
			
		dc_servicemaxsetupPage.navigateTeamTechnicianMngmt();
		dc_servicemaxsetupPage.createTeam(sTeam, sStreet, sCity, sState, sZip, sCountry,true, dc_salesforPage);
		
		}
		catch(Exception e)
		{
			NXGReports.addStep(sTestCaseID+": Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		
	}
	
	@Test(priority=2, enabled=true, description="RS_3808: Creating a Technician from Service Org")
	public void createTech() throws Exception
	{	sTestCaseID="RS_3808";
		sTeam=GenericLib.getExcelData(sTestCaseID, "Team"); sTech=GenericLib.getExcelData(sTestCaseID, "Tech"); sStreet = GenericLib.getExcelData(sTestCaseID, "Street");sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
	
		try 
		{
			dc_servicemaxsetupPage.navigateTeamTechnicianMngmt();
			dc_servicemaxsetupPage.searchTeam(sTeam,sTech, sStreet, sCity, sState, sZip, sCountry,true,true, dc_salesforPage);
			dc_servicemaxsetupPage.createTechnician(sTech, sStreet, sCity, sState, sZip, sCountry,true, dc_salesforPage);
		}
		catch(Exception e)
		{
			NXGReports.addStep(sTestCaseID+": Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	@Test(priority=3, enabled=true, description="RS_3809: Providing dispatcher access to a Service Team")
	public void addDispatcherforTeam() throws Exception
	{	sTestCaseID="RS_3809";
		sTeam=GenericLib.getExcelData(sTestCaseID, "Team"); sTech=GenericLib.getExcelData(sTestCaseID, "Tech"); sStreet = GenericLib.getExcelData(sTestCaseID, "Street");sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
		
	try {
			dc_servicemaxsetupPage.navigateTeamTechnicianMngmt();
			dc_servicemaxsetupPage.searchTeam(sTeam,sTech, sStreet, sCity, sState, sZip, sCountry,true,true,dc_salesforPage);
			dc_servicemaxsetupPage.searchTech(sTeam,sTech, sStreet, sCity, sState, sZip, sCountry, true,true,dc_salesforPage);
			
			dc_servicemaxsetupPage.getEleTeamRdBtn(sTeam).click();
			Thread.sleep(GenericLib.iLowSleep);
			dc_servicemaxsetupPage.addDispatcher();
			dc_salesforPage.navigatehome();
			dc_salesforPage.naviagateDC();
			Thread.sleep(GenericLib.iVHighSleep);
			Thread.sleep(30000);
			scn = new Screen();
			NXGReports.addStep("Starting DC", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sExpandAllLnk));
			Thread.sleep(GenericLib.iMedSleep);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sMysoreTeamTxt))!=null),"Team is not displayed in the DC");
			NXGReports.addStep("Created team  is successfully displayed in DC", LogAs.PASSED,null);
			System.out.println("Team");
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sChamundiHillTechTxt))!=null),"Created technician is not displayed in the DC");
			NXGReports.addStep("Created technician  is successfully displayed in DC", LogAs.PASSED,null);
			System.out.println("Technician");
		}
	catch(Exception e)
	{
		NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	finally 
	{	try {
		if(dc_salesforPage.sDCWnd!=null) {
		driver.switchTo().window(dc_salesforPage.sDCWnd).close();}
		driver.switchTo().window(dc_salesforPage.sParentWnd);
	}catch(Exception e) {}
	}
	}
	
	@Test(priority=4, enabled=true, description="RS_3803: Creating a New Service Territory from Service org")
	public void createTerritory() throws Exception
	{
		sTestCaseID="RS_3803";
		sTerritoryName=GenericLib.getExcelData(sTestCaseID, "TerritoryName"); sParentName=null;
	try {	
		dc_servicemaxsetupPage.navigateTerritoryMngmt();
		dc_servicemaxsetupPage.SearchAddTerritory(sTerritoryName, sParentName);		
		}
	catch(Exception e){
		NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	}	
	@Test(priority=5, enabled=true, description="RS_3804: Creating a Child Service Territory from Service Org")
	public void createChildTerritory() throws Exception
	{
		sTestCaseID="RS_3804";	
		sTerritoryName=GenericLib.getExcelData(sTestCaseID, "TerritoryName"); sParentName=GenericLib.getExcelData(sTestCaseID, "ParentName");
		try {	
			dc_servicemaxsetupPage.navigateTerritoryMngmt();
			dc_servicemaxsetupPage.SearchAddTerritory(sParentName, null);	
			dc_servicemaxsetupPage.getEleTerritoryRdBtn(sParentName).click();
			dc_servicemaxsetupPage.SearchAddTerritory(sTerritoryName, sParentName);		
			}
		catch(Exception e){
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		}
		
	@Test(priority=6, enabled=true, description="RS_3806: Providing dispatcher access to a Territory")
	public void addDispatcherforTerritory() throws Exception
	{	sTestCaseID="RS_3806";
		sTerritoryName=GenericLib.getExcelData(sTestCaseID, "TerritoryName"); sParentName=GenericLib.getExcelData(sTestCaseID, "ParentName");
	
	try {	
			dc_servicemaxsetupPage.navigateTerritoryMngmt();
			dc_servicemaxsetupPage.SearchAddTerritory(sParentName, null);	
			dc_servicemaxsetupPage.getEleTerritoryRdBtn(sParentName).click();
			dc_servicemaxsetupPage.addDispatcher();
			
			dc_servicemaxsetupPage.SearchAddTerritory(sTerritoryName, sParentName);		
			dc_servicemaxsetupPage.getEleTerritoryRdBtn(sTerritoryName).click();
			
			Thread.sleep(GenericLib.iLowSleep);
			dc_servicemaxsetupPage.addDispatcher();
			dc_salesforPage.navigatehome();
			dc_salesforPage.naviagateDC();
			scn = new Screen();
			NXGReports.addStep("Starting DC", LogAs.PASSED,null);
			try{scn.click(new Pattern(dc_dispatchconsolePage.sServiceTeamViewLst));}
			catch(Exception e) {scn.click(new Pattern(dc_dispatchconsolePage.sServiceTeamViewTxt));}
			scn.click(new Pattern(dc_dispatchconsolePage.sTerritoryViewLst));
			scn.click(new Pattern(dc_dispatchconsolePage.sExpandAllLnk));
			Thread.sleep(GenericLib.iMedSleep);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sKarnatakaTerrTxt))!=null),"Territory is not displayed in the DC");
			NXGReports.addStep("Territory  is successfully displayed in DC", LogAs.PASSED,null);
			System.out.println("Territory  is successfully displayed in DC");
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sMangaloreTerrTxt))!=null),"Child Territory is not displayed in the DC");
			NXGReports.addStep("Child Territory  is successfully displayed in DC", LogAs.PASSED,null);
			System.out.println("Child Territory");	
		}
	catch(Exception e)
	{
		NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	finally 
	{	try {
		if(dc_salesforPage.sDCWnd!=null) {
		driver.switchTo().window(dc_salesforPage.sDCWnd).close();}
		driver.switchTo().window(dc_salesforPage.sParentWnd);}catch(Exception e) {}
		
	}
	}
	
	
	@Test(priority=7, enabled=true, description="RS_3709: Adding Territory coverage to a territory")
	public void createTerritoryCoverage() throws Exception
	{
		sTestCaseID="RS_3709";	
		 sParentName=GenericLib.getExcelData(sTestCaseID, "ParentName");
		 sCountry=GenericLib.getExcelData(sTestCaseID, "Country");
		try {	
			dc_servicemaxsetupPage.navigateTerritoryMngmt();
			dc_servicemaxsetupPage.SearchAddTerritory(sParentName, null);	
			dc_servicemaxsetupPage.getEleTerritoryRdBtn(sParentName).click();
			dc_servicemaxsetupPage.getEleAddCoverageBtn().click();
			selList = new Select(dc_servicemaxsetupPage.getEleTerrCoverageLst());
			selList.selectByValue("Country");
			dc_servicemaxsetupPage.getEleTerrCoverageTxtFld().sendKeys(sCountry);
			
			dc_servicemaxsetupPage.getEleSaveBtn().click();
			Assert.assertTrue(dc_servicemaxsetupPage.getEleSuccessTxt().isDisplayed(), "Territory coverage is not added to territory");
			NXGReports.addStep("Territory coverage is successfully added to Territory", LogAs.PASSED,null);
		
			
			}
		catch(Exception e){
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		
		}
	
	@Test(priority=8, enabled=true, description="RS_3709A_RS_3720: Verify creating Territory and adding Territory coverage/Verify the functionality of Service org - Service team and technician creation ")
	public void createTerritoryAddCoverage() throws Exception
	{
		sTestCaseID="RS_3709A";	
		sState=GenericLib.getExcelData(sTestCaseID, "State");
		sTerritoryName=GenericLib.getExcelData(sTestCaseID, "TerritoryName"); sParentName=GenericLib.getExcelData(sTestCaseID, "ParentName");
		try {	
			dc_servicemaxsetupPage.navigateTerritoryMngmt();
			dc_servicemaxsetupPage.SearchAddTerritory(sParentName, null);	
			dc_servicemaxsetupPage.getEleTerritoryRdBtn(sParentName).click();
			dc_servicemaxsetupPage.getEleAddCoverageBtn().click();
			selList = new Select(dc_servicemaxsetupPage.getEleTerrCoverageLst());
			selList.selectByValue("State");
			dc_servicemaxsetupPage.getEleTerrCoverageTxtFld().sendKeys(sState);
			dc_servicemaxsetupPage.getEleSaveBtn().click();
			Assert.assertTrue(dc_servicemaxsetupPage.getEleSuccessTxt().isDisplayed(), "Territory coverage is not added to territory");
			NXGReports.addStep("Territory coverage is successfully added to Territory", LogAs.PASSED,null);
		
			dc_servicemaxsetupPage.addDispatcher();
			dc_servicemaxsetupPage.SearchAddTerritory(sTerritoryName, sParentName);		
			dc_servicemaxsetupPage.getEleTerritoryRdBtn(sTerritoryName).click();
			Thread.sleep(GenericLib.iLowSleep);
			dc_servicemaxsetupPage.addDispatcher();
			
			dc_salesforPage.navigatehome();
			dc_salesforPage.naviagateDC();
			
			scn = new Screen();
			NXGReports.addStep("Launching DC", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sServiceTeamViewLst));
			scn.click(new Pattern(dc_dispatchconsolePage.sTerritoryViewTxt));
			scn.click(new Pattern(dc_dispatchconsolePage.sExpandAllLnk));
			Thread.sleep(GenericLib.iMedSleep);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sChennaiTerrLst))!=null),"Territory is not expanded in DC");
			NXGReports.addStep("Territory is expanded and displayed in DC", LogAs.PASSED,null);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sKarnatakaTerrLst))!=null),"Territory is not expanded in DC");
			NXGReports.addStep("Territory is expanded and displayed in DC", LogAs.PASSED,null);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sExpandedTerrLst))!=null),"Multiple Territories are not expanded in DC");
			NXGReports.addStep("Multiple Territories are expanded and displayed in DC", LogAs.PASSED,null);
		
			scn.click(new Pattern(dc_dispatchconsolePage.sCollapseAllLnk));
			Thread.sleep(GenericLib.iMedSleep);
			Assert.assertTrue(((scn.exists(new Pattern(dc_dispatchconsolePage.sChennaiTerrCollapseImg))!=null)||((scn.exists(new Pattern(dc_dispatchconsolePage.sKarnatakaTerrCollapseImg))!=null))),"Territories are not collapsed in DC");
			NXGReports.addStep("Territories are collapsed in DC", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sTerritoryViewLst));
			scn.click(new Pattern(dc_dispatchconsolePage.sServiceTeamViewTxt));
			Thread.sleep(GenericLib.iMedSleep);
			scn.click(new Pattern(dc_dispatchconsolePage.sExpandAllLnk));
			Thread.sleep(GenericLib.iMedSleep);
			Assert.assertTrue(((scn.exists(new Pattern(dc_dispatchconsolePage.sMysoreTeamLst))!=null)),"Teams are not expanded in DC");
			NXGReports.addStep("Teams are expanded in DC", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sCollapseAllLnk));
			Thread.sleep(GenericLib.iMedSleep);
			Assert.assertTrue(((scn.exists(new Pattern(dc_dispatchconsolePage.sMysoreTeamCollapseImg))!=null)),"Teams are not expanded in DC");
			NXGReports.addStep("Teams are collapsed in DC", LogAs.PASSED,null);
			}
		catch(Exception e){
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		finally 
		{	try {
			if(dc_salesforPage.sDCWnd!=null) {
			driver.switchTo().window(dc_salesforPage.sDCWnd).close();}
			driver.switchTo().window(dc_salesforPage.sParentWnd);}catch(Exception e) {}
			
		}
		}
	
	
	@Test(priority=9, enabled=true, description="RS_3731: Event Subject rules ")
	public void dcEventSubjectRule() throws Exception
	{
		sTestCaseID="RS_3731";	
		sWOJsonData="{\"SVMXC__City__c\":\"Delhi\",\"SVMXC__Zip__c\":\"110003\",\"SVMXC__Country__c\":\"India\",\"SVMXC__State__c\":\"Haryana\"}";
		
		sTeam=GenericLib.getExcelData(sTestCaseID, "Team");  sStreet = GenericLib.getExcelData(sTestCaseID, "Street"); sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
		sTech=GenericLib.getExcelData(sTestCaseID, "Tech"); sTechZip = GenericLib.getExcelData(sTestCaseID, "TechZip"); sTechStreet=GenericLib.getExcelData(sTestCaseID, "Tech_street");
		sFromDate = GenericLib.getExcelData(sTestCaseID, "FromDate"); sToDate =GenericLib.getExcelData(sTestCaseID, "ToDate"); sTechName = GenericLib.getExcelData(sTestCaseID, "TechName"); sStartDate = GenericLib.getExcelData(sTestCaseID, "StartDate"); sEndDate = GenericLib.getExcelData(sTestCaseID, "EndDate");
		sStartTime = GenericLib.getExcelData(sTestCaseID, "StartTime"); sEndTime = GenericLib.getExcelData(sTestCaseID, "EndTime");
		
		try 
		{	
			sWorkOrderID=appServices.getWOORecordID(sWOJsonData);
			sWOName =appServices.getWOName(sWorkOrderID);
		
			dc_servicemaxsetupPage.navigateTeamTechnicianMngmt();
			dc_servicemaxsetupPage.searchTeam(sTeam,sTech, sStreet, sCity, sState, sZip, sCountry,true,true,dc_salesforPage);
			dc_servicemaxsetupPage.searchTech(sTeam,sTech, sTechStreet, sCity, sState, sTechZip, sCountry, true,true,dc_salesforPage);
			dc_servicemaxsetupPage.getEleTeamRdBtn(sTeam).click();
			Thread.sleep(GenericLib.iLowSleep);
			dc_servicemaxsetupPage.addDispatcher();
			dc_salesforPage.navigatehome();

			dc_servicemaxsetupPage.navigateServiceMaxSetup();
			dc_servicemaxsetupPage.getEleDispatchManagementBtn().click();
			Thread.sleep(GenericLib.iLowSleep);
			NXGReports.addStep("Navigation to Dispatch Management module", LogAs.PASSED,null);
			dc_servicemaxsetupPage.createEventSubjectRule();
			
			dc_salesforPage.navigatehome();
			dc_salesforPage.naviagateDC();
			scn = new Screen();
			dc_dispatchconsolePage.gridfilterSearch(scn, "W", sWOName);
			dc_dispatchconsolePage.setGanttCalender(scn, sFromDate, sToDate);
			dc_dispatchconsolePage.searchTechnician(scn, sTechName, dc_dispatchconsolePage.sKarolBaghTechTxt);
		
			if(scn.exists(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn))!=null)
			{scn.click(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn));	}
			Thread.sleep(GenericLib.iMedSleep);
			dc_dispatchconsolePage.dragDropWO(scn, dc_dispatchconsolePage.sEventTimeImg);
			dc_dispatchconsolePage.createEvent(scn, sStartDate, sStartTime, sEndDate, sEndTime);
		
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sAssignedTxt))!=null), "Event is not assigend to technician");
			NXGReports.addStep("Event is created and assigned to Technician", LogAs.PASSED,null);
			
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sWOEventTxt))!=null), "Event is not displayed on the gantt");
			NXGReports.addStep("Created event is displayed on the gantt", LogAs.PASSED,null);
			
			scn.doubleClick(new Pattern(dc_dispatchconsolePage.sWOEventTxt));
			Thread.sleep(5000);
			
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sEventSubjectTxt))!=null), "Event Subject is not displayed on the edit event window");
			NXGReports.addStep("Event Subject text is displayed on the edit window", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sSaveBtn));
			
		}
		catch(Exception e){
		NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
		}
		finally 
		{	try {
			if(dc_salesforPage.sDCWnd!=null) {
			driver.switchTo().window(dc_salesforPage.sDCWnd).close();}
			driver.switchTo().window(dc_salesforPage.sParentWnd);}catch(Exception e) {}
			
		}
	}
	
	@Test(priority=10, enabled=true, description="RS_3730: Verify Event Hover rules functionality")
	public void dcEventHoverRule() throws Exception
	{
		sTestCaseID="RS_3730";	
		sWOJsonData="{\"SVMXC__City__c\":\"Delhi\",\"SVMXC__Zip__c\":\"110003\",\"SVMXC__Country__c\":\"India\",\"SVMXC__State__c\":\"Haryana\"}";
		
		sTeam=GenericLib.getExcelData(sTestCaseID, "Team");  sStreet = GenericLib.getExcelData(sTestCaseID, "Street"); sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
		sTech=GenericLib.getExcelData(sTestCaseID, "Tech"); sTechZip = GenericLib.getExcelData(sTestCaseID, "TechZip"); sTechStreet=GenericLib.getExcelData(sTestCaseID, "Tech_street");
		sFromDate = GenericLib.getExcelData(sTestCaseID, "FromDate"); sToDate =GenericLib.getExcelData(sTestCaseID, "ToDate"); sTechName = GenericLib.getExcelData(sTestCaseID, "TechName"); sStartDate = GenericLib.getExcelData(sTestCaseID, "StartDate"); sEndDate = GenericLib.getExcelData(sTestCaseID, "EndDate");
		sStartTime = GenericLib.getExcelData(sTestCaseID, "StartTime"); sEndTime = GenericLib.getExcelData(sTestCaseID, "EndTime");
		
		try 
		{	
			sWorkOrderID=appServices.getWOORecordID(sWOJsonData);
			sWOName =appServices.getWOName(sWorkOrderID);
			
			dc_servicemaxsetupPage.navigateTeamTechnicianMngmt();
			dc_servicemaxsetupPage.searchTeam(sTeam,sTech, sStreet, sCity, sState, sZip, sCountry,true,true,dc_salesforPage);
			dc_servicemaxsetupPage.searchTech(sTeam,sTech, sTechStreet, sCity, sState, sTechZip, sCountry, true,true,dc_salesforPage);
			dc_servicemaxsetupPage.getEleTeamRdBtn(sTeam).click();
			Thread.sleep(GenericLib.iLowSleep);
			dc_servicemaxsetupPage.addDispatcher();
			dc_salesforPage.navigatehome();
				
			dc_servicemaxsetupPage.navigateServiceMaxSetup();
			dc_servicemaxsetupPage.getEleDispatchManagementBtn().click();
			Thread.sleep(GenericLib.iLowSleep);
			NXGReports.addStep("Navigation to Dispatch Management module", LogAs.PASSED,null);
			dc_servicemaxsetupPage.createEventHoverRule();	
			dc_salesforPage.navigatehome();
			dc_salesforPage.naviagateDC();
			scn = new Screen();
			dc_dispatchconsolePage.gridfilterSearch(scn, "W", sWOName);
			dc_dispatchconsolePage.setGanttCalender(scn, sFromDate, sToDate);
			dc_dispatchconsolePage.searchTechnician(scn, sTechName, dc_dispatchconsolePage.sKarolBaghTechTxt);
		
			if(scn.exists(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn))!=null)
			{scn.click(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn));	}
			Thread.sleep(GenericLib.iMedSleep);
			dc_dispatchconsolePage.dragDropWO(scn, dc_dispatchconsolePage.sEventTimeImg);
			dc_dispatchconsolePage.createEvent(scn, sStartDate, sStartTime, sEndDate, sEndTime);
		
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sAssignedTxt))!=null), "Event is not assigend to technician");
			NXGReports.addStep("Event is created and assigned to Technician", LogAs.PASSED,null);
			
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sWOEventTxt))!=null), "Event is not displayed on the gantt");
			NXGReports.addStep("Created event is displayed on the gantt", LogAs.PASSED,null);
			scn.mouseMove(new Pattern(dc_dispatchconsolePage.sWOEventTxt));
			Assert.assertTrue(((scn.exists(new Pattern(dc_dispatchconsolePage.sEventDetailsTxt))!=null)),"Event details popup on event hover is not displayed");
			NXGReports.addStep("Event details popup for the event is displayed", LogAs.PASSED,null);
			Assert.assertTrue(((scn.exists(new Pattern(dc_dispatchconsolePage.sEventDetailsIcn))!=null)),"Event details icons on event hover is not displayed ");
			NXGReports.addStep("Event details icon is displayed", LogAs.PASSED,null);
			Assert.assertTrue(((scn.exists(new Pattern(dc_dispatchconsolePage.sEventHoverRulesTxt))!=null)),"Event hover rules in not displayed on the event details popup");
			NXGReports.addStep("Event hover rules are displayed on the event details popup", LogAs.PASSED,null);
		}
		catch(Exception e){
		NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
		}
		finally 
		{	try {
			if(dc_salesforPage.sDCWnd!=null) {
			driver.switchTo().window(dc_salesforPage.sDCWnd).close();}
			driver.switchTo().window(dc_salesforPage.sParentWnd);}catch(Exception e) {}
			
		}
	}
	

	@Test(priority=11, enabled=true, description="RS_3732: Event Field updates")
	public void dcEventFieldUpdatesRule() throws Exception
	{
		sTestCaseID="RS_3732";	
		sWOJsonData="{\"SVMXC__City__c\":\"Delhi\",\"SVMXC__Zip__c\":\"110003\",\"SVMXC__Country__c\":\"India\",\"SVMXC__State__c\":\"Haryana\"}";
		
		sTeam=GenericLib.getExcelData(sTestCaseID, "Team");  sStreet = GenericLib.getExcelData(sTestCaseID, "Street"); sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
		sTech=GenericLib.getExcelData(sTestCaseID, "Tech"); sTechZip = GenericLib.getExcelData(sTestCaseID, "TechZip"); sTechStreet=GenericLib.getExcelData(sTestCaseID, "Tech_street");
		sFromDate = GenericLib.getExcelData(sTestCaseID, "FromDate"); sToDate =GenericLib.getExcelData(sTestCaseID, "ToDate"); sTechName = GenericLib.getExcelData(sTestCaseID, "TechName"); sStartDate = GenericLib.getExcelData(sTestCaseID, "StartDate"); sEndDate = GenericLib.getExcelData(sTestCaseID, "EndDate");
		sStartTime = GenericLib.getExcelData(sTestCaseID, "StartTime"); sEndTime = GenericLib.getExcelData(sTestCaseID, "EndTime");
		
		try 
		{	
			sWorkOrderID=appServices.getWOORecordID(sWOJsonData);
			sWOName =appServices.getWOName(sWorkOrderID);
			
			dc_servicemaxsetupPage.navigateTeamTechnicianMngmt();
			dc_servicemaxsetupPage.searchTeam(sTeam,sTech, sStreet, sCity, sState, sZip, sCountry,true,true,dc_salesforPage);
			dc_servicemaxsetupPage.searchTech(sTeam,sTech, sTechStreet, sCity, sState, sTechZip, sCountry, true,true,dc_salesforPage);
			dc_servicemaxsetupPage.getEleTeamRdBtn(sTeam).click();
			Thread.sleep(GenericLib.iLowSleep);
			dc_servicemaxsetupPage.addDispatcher();
			dc_salesforPage.navigatehome();
			
			dc_servicemaxsetupPage.navigateServiceMaxSetup();
			dc_servicemaxsetupPage.getEleDispatchManagementBtn().click();
			Thread.sleep(GenericLib.iLowSleep);
			NXGReports.addStep("Navigation to Dispatch Management module", LogAs.PASSED,null);
			
			dc_servicemaxsetupPage.createEventFieldUpdatesRule();	
			
			dc_salesforPage.navigatehome();
			dc_salesforPage.naviagateDC();
			scn = new Screen();
			dc_dispatchconsolePage.gridfilterSearch(scn, "W", sWOName);
			dc_dispatchconsolePage.setGanttCalender(scn, sFromDate, sToDate);
			dc_dispatchconsolePage.searchTechnician(scn, sTechName, dc_dispatchconsolePage.sKarolBaghTechTxt);
		
			if(scn.exists(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn))!=null)
			{scn.click(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn));	}
			Thread.sleep(GenericLib.iMedSleep);
			dc_dispatchconsolePage.dragDropWO(scn, dc_dispatchconsolePage.sEventTimeImg);
			dc_dispatchconsolePage.createEvent(scn, sStartDate, sStartTime, sEndDate, sEndTime);
		
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sAssignedTxt))!=null), "Event is not assigend to technician");
			NXGReports.addStep("Event is created and assigned to Technician", LogAs.PASSED,null);
				
			scn.doubleClick(new Pattern(dc_dispatchconsolePage.sWOEventTxt));
			Thread.sleep(5000);
			scn.click(new Pattern(dc_dispatchconsolePage.sEventFieldUpdatesIcn));
			
			Thread.sleep(5000);
			Assert.assertTrue(((scn.exists(new Pattern(dc_dispatchconsolePage.sEventFieldUpdatesImg))!=null)),"Event field updates are not displayed");
			NXGReports.addStep("Event field updates are displayed", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sSaveBtn));
		}
		catch(Exception e){
		NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
		}
		finally 
		{	try {
			if(dc_salesforPage.sDCWnd!=null) {
			driver.switchTo().window(dc_salesforPage.sDCWnd).close();}
			driver.switchTo().window(dc_salesforPage.sParentWnd);}catch(Exception e) {}
			
		}
	}
	
	@Test(priority=12, enabled=true, description="RS_7277: Verify Immediate Dispatch Process")
	public void dcImmediateDispatchProcess() throws Exception
		{
			sTestCaseID="RS_7277";	
			sWOJsonData="{\"SVMXC__City__c\":\"Delhi\",\"SVMXC__Zip__c\":\"110003\",\"SVMXC__Country__c\":\"India\",\"SVMXC__State__c\":\"Haryana\"}";
			
			sTeam=GenericLib.getExcelData(sTestCaseID, "Team");  sStreet = GenericLib.getExcelData(sTestCaseID, "Street"); sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
			sTech=GenericLib.getExcelData(sTestCaseID, "Tech"); sTechZip = GenericLib.getExcelData(sTestCaseID, "TechZip"); sTechStreet=GenericLib.getExcelData(sTestCaseID, "Tech_street");
			sFromDate = GenericLib.getExcelData(sTestCaseID, "FromDate"); sToDate =GenericLib.getExcelData(sTestCaseID, "ToDate"); sTechName = GenericLib.getExcelData(sTestCaseID, "TechName"); sStartDate = GenericLib.getExcelData(sTestCaseID, "StartDate"); sEndDate = GenericLib.getExcelData(sTestCaseID, "EndDate");
			sStartTime = GenericLib.getExcelData(sTestCaseID, "StartTime"); sEndTime = GenericLib.getExcelData(sTestCaseID, "EndTime");
			
			try 
			{	
				dc_servicemaxsetupPage.navigateTeamTechnicianMngmt();
				dc_servicemaxsetupPage.searchTeam(sTeam,sTech, sStreet, sCity, sState, sZip, sCountry,true,true,dc_salesforPage);
				dc_servicemaxsetupPage.searchTech(sTeam,sTech, sTechStreet, sCity, sState, sTechZip, sCountry, true,true,dc_salesforPage);
				dc_servicemaxsetupPage.getEleTeamRdBtn(sTeam).click();
				Thread.sleep(GenericLib.iLowSleep);
				dc_servicemaxsetupPage.addDispatcher();
				dc_salesforPage.navigatehome();
				
				dc_servicemaxsetupPage.navigateServiceMaxSetup();
				dc_servicemaxsetupPage.getEleDispatchManagementBtn().click();
				Thread.sleep(GenericLib.iLowSleep);
				NXGReports.addStep("Navigation to Dispatch Management module", LogAs.PASSED,null);
				scn = new Screen();
				dc_servicemaxsetupPage.createImmediateDispatchProcess(sTech, GenericLib.getCongigValue(GenericLib.sConfigFile, "DISPATCHER"),dc_dispatchconsolePage,scn);	
				
				sWorkOrderID=appServices.getWOORecordID(sWOJsonData);
				driver.navigate().to(GenericLib.getCongigValue(GenericLib.sConfigFile, "DOMAIN_URL")+sWorkOrderID);
				sWOName =appServices.getWOName(sWorkOrderID);
				Thread.sleep(GenericLib.iLowSleep);
				
				Assert.assertTrue(driver.findElement(By.xpath("//div/a[text()='"+sTech+"']")).isDisplayed(), "Failed to add technician through immediate dispatch process");
				NXGReports.addStep("Technician is added to WO through immediate dispatch process", LogAs.PASSED,null);
				
			}
			catch(Exception e){
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
			}
			
		}
	@Test(priority=13, enabled=true, description="RS_3733: Verify Dispatch Console views")
	public void dcDispatchVIewRule() throws Exception
	{
		sTestCaseID="RS_3733";	
		try 
		{	
			dc_servicemaxsetupPage.navigateServiceMaxSetup();
			dc_servicemaxsetupPage.getEleDispatchManagementBtn().click();
			Thread.sleep(GenericLib.iLowSleep);
			NXGReports.addStep("Navigation to Dispatch Management module", LogAs.PASSED,null);

			dc_servicemaxsetupPage.createDispatchViewRule(scn, dc_dispatchconsolePage);
			Thread.sleep(GenericLib.iMedSleep);
			dc_servicemaxsetupPage.createMapView(scn, dc_dispatchconsolePage,"Account", "DC_AccMap_View","Billing City","Mysore");
			dc_servicemaxsetupPage.createMapView(scn, dc_dispatchconsolePage,"Location", "DC_LocMap_View","City","Mysore");
			dc_servicemaxsetupPage.createWOView(scn, dc_dispatchconsolePage, "DC_WOGrid_View","Grid");
			dc_servicemaxsetupPage.createWOView(scn, dc_dispatchconsolePage, "DC_WOGridMap_View","Grid And Map");
			dc_servicemaxsetupPage.createWOView(scn, dc_dispatchconsolePage, "DC_WOMap_View","Map");

			dc_salesforPage.navigatehome();
			dc_salesforPage.naviagateDC();

			scn = new Screen();
			NXGReports.addStep("Launching DC", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sMyWOsLst));
			Thread.sleep(GenericLib.iLowSleep);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sWOGridViewTxt))!=null),"Created DC_WOGrid_View is not displayed ");
			NXGReports.addStep("Created DC_WOGrid_View is displayed on the grid view", LogAs.PASSED,null);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sWOGridMapViewTxt))!=null),"Created DC_WOGridMap_View is not displayed ");
			NXGReports.addStep("Created DC_WOGridMap_View is displayed on the grid view", LogAs.PASSED,null);

			try {
				if(scn.exists(new Pattern(dc_dispatchconsolePage.sGanttCollapseIcn))!=null)
				{scn.click(new Pattern(dc_dispatchconsolePage.sGanttCollapseIcn));
				Thread.sleep(GenericLib.iLowSleep);}
			}catch(Exception e) {}
			scn.dragDrop(new Pattern(dc_dispatchconsolePage.sSliderIcn),new Pattern(dc_dispatchconsolePage.sAddEventIcn));
			Thread.sleep(GenericLib.iLowSleep);
			scn.click(new Pattern(dc_dispatchconsolePage.sPlotIcn));
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sWOMapViewTxt))!=null),"Created DC_WOGrid_View is not displayed ");
			NXGReports.addStep("Created DC_WOGrid_View is displayed on the Map for WO", LogAs.PASSED,null);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sWOsGridMapViewTxt))!=null),"Created DC_WOGridMap_View is not displayed ");
			NXGReports.addStep("Created DC_WOGridMap_View is displayed on the Map for WO", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sAccountBtn));
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sAccMapViewTxt))!=null),"Created DC_AccMap_View is not displayed ");
			NXGReports.addStep("Created DC_AccMap_View is displayed on the Map for accounts ", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sLocationBtn));
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sLocMapViewTxt))!=null),"Created DC_LocMap_View is not displayed ");
			NXGReports.addStep("Created DC_LocMap_View is displayed on map for location ", LogAs.PASSED,null);

			scn.dragDrop(new Pattern(dc_dispatchconsolePage.sSliderIcn),new Pattern(dc_dispatchconsolePage.sMaximIcn));
		}
		catch(Exception e){
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		finally 
		{	try {
			if(dc_salesforPage.sDCWnd!=null) {
				driver.switchTo().window(dc_salesforPage.sDCWnd).close();}
			driver.switchTo().window(dc_salesforPage.sParentWnd);}catch(Exception e) {}

		}

	}
		
	@Test(priority=14, enabled=true, description="RS_3734: Dispatch console hovers")
	public void dcDispatchHoverRule() throws Exception
	{
		sTestCaseID="RS_3734";	
		
		try 
		{	
			dc_servicemaxsetupPage.navigateServiceMaxSetup();
			dc_servicemaxsetupPage.getEleDispatchManagementBtn().click();
			Thread.sleep(GenericLib.iLowSleep);
			NXGReports.addStep("Navigation to Dispatch Management module", LogAs.PASSED,null);
			dc_servicemaxsetupPage.createDispatchHoverRule();	
		}
		catch(Exception e){
		NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
		}
		
	}
	
}
