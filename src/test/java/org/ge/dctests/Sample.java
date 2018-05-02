package org.ge.dctests;

import java.io.IOException;
import org.ge.dclibrary.AppServices;
import org.ge.dclibrary.BaseLib;
import org.ge.dclibrary.GenericLib;
import org.ge.pageobjects.DC_DispatchConsolePage;
import org.ge.pageobjects.DC_SalesforcePage;
import org.ge.pageobjects.DC_ServiceMaxSetupPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;

public class Sample extends BaseLib
{
	private final static String USER_AGENT = "Mozilla/5.0";
	public static String sAccessToken = null;
	public static String sWORecordID = null;
	public static String sWorkOrderName = null;

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
	static int sRandID = new Random().nextInt(1000);
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

	

	@Test(priority=9, enabled=true, description="RS_3731: Event Subject rules ")
	public void dcEventSubjectRule() throws Exception
	{
		sTestCaseID="RS_3731";	
		sWOJsonData="{\"SVMXC__City__c\":\"Delhi\",\"SVMXC__Zip__c\":\"110003\",\"SVMXC__Country__c\":\"India\",\"SVMXC__State__c\":\"Karnataka\"}";
		
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
			Thread.sleep(GenericLib.iMedSleep);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sAssignedTxt))!=null), "Event is not assigend to technician");
			NXGReports.addStep("Event is created and assigned to Technician", LogAs.PASSED,null);
			
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sEventCreateImg))!=null), "Event is not displayed on the gantt");
			NXGReports.addStep("Created event is displayed on the gantt", LogAs.PASSED,null);
			scn.doubleClick(new Pattern(dc_dispatchconsolePage.sWOEventTxt));
			Thread.sleep(5000);
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sEventSubjectTxt))!=null), "Event Subject is not displayed on the edit event window");
			NXGReports.addStep("Event Subject text is displayed on the edit window", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sEventFieldUpdatesIcn));
			
			Thread.sleep(5000);
			Assert.assertTrue(((scn.exists(new Pattern(dc_dispatchconsolePage.sEventFieldUpdatesImg))!=null)),"Event field updates are not displayed");
			NXGReports.addStep("Event field updates are displayed", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sSaveBtn));
			Thread.sleep(5000);
			
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
	@Test(priority=14, enabled=false, description="RS_3734: Dispatch console hovers")
	public void dcDispatchHoverRule() throws Exception
	{
		sTestCaseID="RS_3734";	
		/*sWOJsonData="{\"SVMXC__City__c\":\"Delhi\",\"SVMXC__Zip__c\":\"110003\",\"SVMXC__Country__c\":\"India\",\"SVMXC__State__c\":\"Karnataka\"}";
		
		sTeam=GenericLib.getExcelData(sTestCaseID, "Team");  sStreet = GenericLib.getExcelData(sTestCaseID, "Street"); sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
		sTech=GenericLib.getExcelData(sTestCaseID, "Tech"); sTechZip = GenericLib.getExcelData(sTestCaseID, "TechZip"); sTechStreet=GenericLib.getExcelData(sTestCaseID, "Tech_street");
		sFromDate = GenericLib.getExcelData(sTestCaseID, "FromDate"); sToDate =GenericLib.getExcelData(sTestCaseID, "ToDate"); sTechName = GenericLib.getExcelData(sTestCaseID, "TechName"); sStartDate = GenericLib.getExcelData(sTestCaseID, "StartDate"); sEndDate = GenericLib.getExcelData(sTestCaseID, "EndDate");
		sStartTime = GenericLib.getExcelData(sTestCaseID, "StartTime"); sEndTime = GenericLib.getExcelData(sTestCaseID, "EndTime");
		*/
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
	
	
	
	@Test(priority=14, enabled=false, description="RS_3734: Dispatch console hovers")
	public void dcDispatchHoverRule2() throws Exception
	{
		sTestCaseID="RS_3734";	
		sWOJsonData="{\"SVMXC__City__c\":\"Mysore\",\"SVMXC__Zip__c\":\"570020\",\"SVMXC__Country__c\":\"India\",\"SVMXC__State__c\":\"Karnataka\"}";
		
		sTeam=GenericLib.getExcelData(sTestCaseID, "Team");  sStreet = GenericLib.getExcelData(sTestCaseID, "Street"); sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
		sTech=GenericLib.getExcelData(sTestCaseID, "Tech"); sTechZip = GenericLib.getExcelData(sTestCaseID, "TechZip"); sTechStreet=GenericLib.getExcelData(sTestCaseID, "Tech_street");
		sFromDate = GenericLib.getExcelData(sTestCaseID, "FromDate"); sToDate =GenericLib.getExcelData(sTestCaseID, "ToDate"); sTechName = GenericLib.getExcelData(sTestCaseID, "TechName"); sStartDate = GenericLib.getExcelData(sTestCaseID, "StartDate"); sEndDate = GenericLib.getExcelData(sTestCaseID, "EndDate");
		sStartTime = GenericLib.getExcelData(sTestCaseID, "StartTime"); sEndTime = GenericLib.getExcelData(sTestCaseID, "EndTime");
		String sValidateUrl = "";
		try 
		{	sWorkOrderID=appServices.getWOORecordID(sWOJsonData);
			sWOName =appServices.getWOName(sWorkOrderID);
			sValidateUrl = "apex/SVMXC__COMM_validateAddress?city=SVMXC__City__c&country=SVMXC__Country__c&latitude=SVMXC__Latitude__c&longitude=SVMXC__Longitude__c&objID="+sWorkOrderID+"&objName=SVMXC__Service_Order__c&state=SVMXC__State__c&street=SVMXC__Street__c&zip=SVMXC__Zip__c";
			
			driver.navigate().to(GenericLib.getCongigValue(GenericLib.sConfigFile, "DOMAIN_URL")+sValidateUrl);
			Thread.sleep(GenericLib.iLowSleep);
			dc_salesforPage.navigatehome();
			/*
			dc_servicemaxsetupPage.navigateServiceMaxSetup();
			dc_servicemaxsetupPage.getEleDispatchManagementBtn().click();
			Thread.sleep(GenericLib.iLowSleep);
			NXGReports.addStep("Navigation to Dispatch Management module", LogAs.PASSED,null);
			dc_servicemaxsetupPage.createDispatchHoverRule();	
			dc_salesforPage.navigatehome();*/
			dc_salesforPage.naviagateDC();
			scn = new Screen();
			dc_dispatchconsolePage.gridfilterSearch(scn, "W", sWOName);
			dc_dispatchconsolePage.setGanttCalender(scn, sFromDate, sToDate);
			dc_dispatchconsolePage.searchTechnician(scn, sTechName, dc_dispatchconsolePage.sChamundiHillTechTxt);
		
			if(scn.exists(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn))!=null)
			{scn.click(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn));}
			Thread.sleep(GenericLib.iMedSleep);
			dc_dispatchconsolePage.dragDropWO(scn, dc_dispatchconsolePage.sEventTimeImg);
			dc_dispatchconsolePage.createEvent(scn, sStartDate, sStartTime, sEndDate, sEndTime);
		
			Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sAssignedTxt))!=null), "Event is not assigend to technician");
			NXGReports.addStep("Event is created and assigned to Technician", LogAs.PASSED,null);
			scn.click(new Pattern(dc_dispatchconsolePage.sGanttCollapseIcn));
			scn.dragDrop(new Pattern(dc_dispatchconsolePage.sSliderIcn),new Pattern(dc_dispatchconsolePage.sAddEventIcn));
			Thread.sleep(GenericLib.iLowSleep);
			
			//scn.click(new Pattern(dc_dispatchconsolePage.s));
			
			
			
		}
		catch(Exception e){
		NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
		}
		
	}
	
	
	@Test(priority=13, enabled=false, description="RS_3734: Dispatch console hovers")
	public void dcDispatchVIewRule2() throws Exception
	{
		sTestCaseID="RS_3734";	
		sWOJsonData="{\"SVMXC__City__c\":\"Delhi\",\"SVMXC__Zip__c\":\"110030\",\"SVMXC__Country__c\":\"India\",\"SVMXC__State__c\":\"Haryana\"}";

		sTeam=GenericLib.getExcelData(sTestCaseID, "Team");  sStreet = GenericLib.getExcelData(sTestCaseID, "Street"); sCity =GenericLib.getExcelData(sTestCaseID, "City"); sState = GenericLib.getExcelData(sTestCaseID, "State"); sZip = GenericLib.getExcelData(sTestCaseID, "Zip"); sCountry = GenericLib.getExcelData(sTestCaseID, "Country");
		sTech=GenericLib.getExcelData(sTestCaseID, "Tech"); sTechZip = GenericLib.getExcelData(sTestCaseID, "TechZip"); sTechStreet=GenericLib.getExcelData(sTestCaseID, "Tech_street");
		sFromDate = GenericLib.getExcelData(sTestCaseID, "FromDate"); sToDate =GenericLib.getExcelData(sTestCaseID, "ToDate"); sTechName = GenericLib.getExcelData(sTestCaseID, "TechName"); sStartDate = GenericLib.getExcelData(sTestCaseID, "StartDate"); sEndDate = GenericLib.getExcelData(sTestCaseID, "EndDate");
		sStartTime = GenericLib.getExcelData(sTestCaseID, "StartTime"); sEndTime = GenericLib.getExcelData(sTestCaseID, "EndTime");

		try 
		{	/*
			dc_servicemaxsetupPage.navigateTeamTechnicianMngmt();
			dc_servicemaxsetupPage.searchTeam(sTeam,sTech, sStreet, sCity, sState, sZip, sCountry,true,true,dc_salesforPage);
			dc_servicemaxsetupPage.searchTech(sTeam,sTech, sTechStreet, sCity, sState, sTechZip, sCountry, true,true,dc_salesforPage);
			dc_servicemaxsetupPage.getEleTeamRdBtn(sTeam).click();
			Thread.sleep(GenericLib.iLowSleep);
			dc_servicemaxsetupPage.addDispatcher();
			dc_salesforPage.navigatehome();*/

			dc_servicemaxsetupPage.navigateServiceMaxSetup();
			dc_servicemaxsetupPage.getEleDispatchManagementBtn().click();
			Thread.sleep(GenericLib.iLowSleep);
			NXGReports.addStep("Navigation to Dispatch Management module", LogAs.PASSED,null);

			dc_servicemaxsetupPage.createDispatchViewRule(scn, dc_dispatchconsolePage);
			Thread.sleep(GenericLib.iMedSleep);
			dc_servicemaxsetupPage.createMapView(scn, dc_dispatchconsolePage,"Account", "DC_AccMap_View","Billing City","Delhi");
			dc_servicemaxsetupPage.createMapView(scn, dc_dispatchconsolePage,"Location", "DC_LocMap_View","City","Delhi");
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


	@Test(priority=20, enabled=false)
	public void createEvent() throws Exception
	{	sTestCaseID="RS_3800";
		sWorkOrderID=GenericLib.getExcelData(sTestCaseID, "WorkOrderID"); sFromDate = GenericLib.getExcelData(sTestCaseID, "FromDate"); sToDate =GenericLib.getExcelData(sTestCaseID, "ToDate"); sTechName = GenericLib.getExcelData(sTestCaseID, "TechName"); sStartDate = GenericLib.getExcelData(sTestCaseID, "StartDate"); sEndDate = GenericLib.getExcelData(sTestCaseID, "EndDate");
		sStartTime = GenericLib.getExcelData(sTestCaseID, "StartTime"); sEndTime = GenericLib.getExcelData(sTestCaseID, "EndTime");
		try {
			
		dc_salesforPage.naviagateDC();
		scn = new Screen();
		dc_dispatchconsolePage.gridfilterSearch(scn, "W", sWorkOrderID);
		dc_dispatchconsolePage.setGanttCalender(scn, sFromDate, sToDate);
		dc_dispatchconsolePage.searchTechnician(scn, sTechName, dc_dispatchconsolePage.sChickPetTechTxt);
	
		if(scn.exists(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn))!=null)
		{scn.click(new Pattern(dc_dispatchconsolePage.sGanttExpandIcn));	}
		Thread.sleep(GenericLib.iMedSleep);
		dc_dispatchconsolePage.dragDropWO(scn, dc_dispatchconsolePage.sEventTimeImg);
		dc_dispatchconsolePage.createEvent(scn, sStartDate, sStartTime, sEndDate, sEndTime);
	
		Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sAssignedTxt))!=null), "Event is not assigend to technician");
		NXGReports.addStep("Event is created and assigned to Technician", LogAs.PASSED,null);
		
		Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sEventCreateImg))!=null), "Event is not displayed on the gantt");
		NXGReports.addStep("Created event is displayed on the gantt", LogAs.PASSED,null);
		
		}
		catch(Exception e)
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			
			throw e;
		}
		finally 
		{
			if(dc_salesforPage.sDCWnd!=null) {
				driver.switchTo().window(dc_salesforPage.sDCWnd).close();}
				driver.switchTo().window(dc_salesforPage.sParentWnd);
		}
	}
	
	@Test(priority=3, enabled=false)
	public void locateTechMapRoute() throws Exception
	{
		DC_DispatchConsolePage dc_dispatchconsolePage = new DC_DispatchConsolePage();
		sTestCaseID="RS_3801";
		sWorkOrderID=GenericLib.getExcelData(sTestCaseID, "WorkOrderID"); sFromDate = GenericLib.getExcelData(sTestCaseID, "FromDate"); sToDate =GenericLib.getExcelData(sTestCaseID, "ToDate"); sTechName = GenericLib.getExcelData(sTestCaseID, "TechName"); sStartDate = GenericLib.getExcelData(sTestCaseID, "StartDate"); sEndDate = GenericLib.getExcelData(sTestCaseID, "EndDate");
		sStartTime = GenericLib.getExcelData(sTestCaseID, "StartTime"); sEndTime = GenericLib.getExcelData(sTestCaseID, "EndTime");
		try {
		dc_salesforPage.naviagateDC();
		System.out.println(sTechName);
		scn = new Screen();
		
		/*
		scn.dragDrop(new Pattern(dc_dispatchconsolePage.sSliderIcn), new Pattern(dc_dispatchconsolePage.sAddEventIcn));
		Thread.sleep(10000);
		dc_dispatchconsolePage.searchTechnician(scn, sTechName, dc_dispatchconsolePage.sChickPetTechTxt);
		Thread.sleep(10000);
		Assert.assertTrue((scn.exists(new Pattern(dc_dispatchconsolePage.sChickPetTechMapImg))!=null), "Event is not displayed on the gantt");
		NXGReports.addStep("Created event is displayed on the gantt", LogAs.PASSED,null);
		*/
		scn.dragDrop(new Pattern(dc_dispatchconsolePage.sSliderIcn),new Pattern(dc_dispatchconsolePage.sMaximIcn));
		}
		catch(Exception e)
		{
			NXGReports.addStep("Testscript Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			
			throw e;
		}
		finally 
		{
			/*if(dc_salesforPage.sDCWnd!=null) {
		driver.switchTo().window(dc_salesforPage.sDCWnd).close();}
				driver.switchTo().window(dc_salesforPage.sParentWnd);*/
				
		}
	}




}