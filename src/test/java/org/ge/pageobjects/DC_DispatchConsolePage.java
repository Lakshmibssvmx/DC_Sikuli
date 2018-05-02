package org.ge.pageobjects;

import org.ge.dclibrary.BaseLib;
import org.ge.dclibrary.GenericLib;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

public class DC_DispatchConsolePage 
{
	//Images on the grid
	public String sGridImgPath = GenericLib.sResources+"\\images\\dcgrid";
	public String sContainsTxtFld = sGridImgPath+"\\ContainsTxtFld.png";
	public String sWOTxt = sGridImgPath+"\\WOImg.png";
	public String sAssignedTxt = sGridImgPath+"\\AssignedTxt.png";
	public String sFilterLst = sGridImgPath+"\\FilterLst.png";
	public String sWOrderTxt = sGridImgPath+"\\WOrderTxt.png";
	public String sMyWOsLst = sGridImgPath+"\\MyWorkOrdersLst.png";
	public String sWOGridMapViewTxt = sGridImgPath+"\\WOGridMapViewTxt.png";
	public String sWOGridViewTxt = sGridImgPath+"\\WOGridViewTxt.png";
	
	//Images on the gantt
	public String sGanttImgPath = GenericLib.sResources+"\\images\\dcgantt";
	public String sTestTeamTxt = sGanttImgPath+"\\TestTeamTxt.png";
	public String sMysoreTeamTxt = sGanttImgPath+"\\MysoreTeamTxt.png";
	public String sChamundiHillTechTxt = sGanttImgPath+"\\ChamundiHillTechTxt.png";
	public String sDateFromTxtFld = sGanttImgPath+"\\DateFromTxtFld.png";
	public String sRefreshIcn = sGanttImgPath+"\\RefreshIcn.png";
	public String sDefaultTechSearchTxtFld = sGanttImgPath+"\\DefaultTechSearchTxtFld.png";
	public String sTechnicianSearchTxtFld = sGanttImgPath+"\\TechnicianSearchTxtFld.png";
	public String sTechnicianSearchIcn = sGanttImgPath+"\\TechnicianSearchIcn.png";
	public String sGanttExpandIcn = sGanttImgPath+"\\GanttExpandIcn.png";
	public String sGanttCollapseIcn = sGanttImgPath+"\\GanttCollapseIcn.png";
	
	public String sEventTimeImg = sGanttImgPath+"\\EventTimeImg.png";
	public String sStartDateTxtFld = sGanttImgPath+"\\StartDateTxtFld.png";
	public String sEndDateTxtFld = sGanttImgPath+"\\EndDateTxtFld.png";
	public String sServiceTimeAutoIcn = sGanttImgPath+"\\ServiceTimeAutoIcn.png";
	public String sSaveBtn = sGanttImgPath+"\\SaveBtn.png";
	public String sEventCreateImg = sGanttImgPath+"\\EventCreateImg.png";
	public String sChickPetTechTxt = sGanttImgPath+"\\ChickPetTechTxt.png";
	public String sKarolBaghTechTxt = sGanttImgPath+"\\KarolBaghTechTxt.png";
	public String sEventSubjectTxt = sGanttImgPath+"\\EventSubjectTxt.png";
	public String sWOEventTxt = sGanttImgPath+"\\WOEventTxt.png";
	public String sEventDetailsTxt = sGanttImgPath+"\\EventDetailsTxt.png";
	public String sEventDetailsIcn = sGanttImgPath+"\\EventDetailsIcn.png";
	public String sEventHoverRulesTxt= sGanttImgPath+"\\EventHoverRulesTxt.png";
	public String sEventFieldUpdatesIcn= sGanttImgPath+"\\EventFieldUpdatesIcn.png";
	public String sEventFieldUpdatesImg= sGanttImgPath+"\\EventFieldUpdatesImg.png";
	
	public String sAddEventIcn = sGanttImgPath+"\\AddEventIcn.png";
	public String sServiceTeamViewLst = sGanttImgPath+"\\ServiceTeamViewLst.png";
	public String sTerritoryViewLst = sGanttImgPath+"\\TerritoryViewLst.png";
	
	public String sTerritoryViewTxt = sGanttImgPath+"\\TerritoryViewTxt.png";
	public String sServiceTeamViewTxt = sGanttImgPath+"\\ServiceTeamViewTxt.png";
	
	public String sExpandAllLnk = sGanttImgPath+"\\ExpandAllLnk.png";
	public String sCollapseAllLnk = sGanttImgPath+"\\CollapseAllLnk.png";
	
	public String sKarnatakaTerrTxt= sGanttImgPath+"\\KarnatakaTerrTxt.png";
	public String sMangaloreTerrTxt = sGanttImgPath+"\\MangaloreTerrTxt.png";
	public String sChennaiTerrTxt= sGanttImgPath+"\\ChennaiTerrTxt.png";
	public String sOmrTerrTxt = sGanttImgPath+"\\OmrTerrTxt.png";
	public String sChennaiTerrLst= sGanttImgPath+"\\ChennaiTerrLst.png";
	public String sKarnatakaTerrLst = sGanttImgPath+"\\KarnatakaTerrLst.png";
	public String sExpandedTerrLst = sGanttImgPath+"\\ExpandedTerrLst.png";
	public String sKarnatakaTerrCollapseImg= sGanttImgPath+"\\KarnatakaTerrCollapseImg.png";
	public String sChennaiTerrCollapseImg = sGanttImgPath+"\\ChennaiTerrCollapseImg.png";
	public String sMysoreTeamLst = sGanttImgPath+"\\MysoreTeamLst.png";
	public String sMysoreTeamCollapseImg = sGanttImgPath+"\\MysoreTeamCollapseImg.png";
	
	//images on the ServiceMax setup immediate dispatch
	public String sOperatorLst = sGanttImgPath+"\\OperatorLst.png";
	public String sOperatorFFLst = sGanttImgPath+"\\OperatorFFLst.png";
		
	//images on the Map
	public String sMapImgPath = GenericLib.sResources+"\\images\\dcmap";
	public String sChickPetTechMapImg = sMapImgPath+"\\WO-0008MapImg.png";
	public String sSliderIcn = sMapImgPath+"\\SliderIcn.png";
	public String sRightEndScroll = sMapImgPath+"\\RightEndScroll.png";
	public String sMaximIcn = sMapImgPath+"\\MaximIcn.png";
	public String sPlotIcn = sMapImgPath+"\\PlotIcn.png";
	public String sWOsGridMapViewTxt = sMapImgPath+"\\WOGridMapViewTxt.png";
	public String sWOMapViewTxt = sMapImgPath+"\\WOMapViewTxt.png";
	public String sAccMapViewTxt = sMapImgPath+"\\AccMapViewTxt.png";
	public String sLocMapViewTxt = sMapImgPath+"\\LocMapViewTxt.png";
	public String sAccountBtn = sMapImgPath+"\\AccountBtn.png";
	public String sLocationBtn = sMapImgPath+"\\LocationBtn.png";
	
	
	
	

	public void setGanttCalender(Screen scn, String sFromDate, String sToDate) throws FindFailed, InterruptedException
	{
		scn.click(new Pattern(sDateFromTxtFld));
		Thread.sleep(GenericLib.iLowSleep);
		scn.type("a", KeyModifier.CTRL);
		scn.type(Key.BACKSPACE);
		System.out.println("sFromDate"+sFromDate);
		scn.type(sFromDate);
		Thread.sleep(GenericLib.iLowSleep);
		scn.type(Key.TAB);
		scn.type(Key.BACKSPACE);
		scn.type(sToDate);
		scn.click(new Pattern(sRefreshIcn));
		Thread.sleep(GenericLib.iMedSleep);
	}


	public void searchTechnician(Screen scn, String sTechName, String iTechName) throws FindFailed, InterruptedException
	{
		try {
			scn.click(new Pattern(sDefaultTechSearchTxtFld));
			}
			catch (Exception e) {
				scn.click(new Pattern(sTechnicianSearchTxtFld));
			}
			Thread.sleep(GenericLib.iLowSleep);
			scn.type("a", KeyModifier.CTRL);
			scn.type(Key.BACKSPACE);
			scn.type(Key.ENTER);
			System.out.println(sTechName);
			scn.type(new Pattern(sTechnicianSearchTxtFld),sTechName);
			scn.click(new Pattern(sTechnicianSearchIcn));
			Thread.sleep(GenericLib.iLowSleep);
			Assert.assertTrue((scn.exists(new Pattern(iTechName))!=null), "Technician searh is not successful");
			NXGReports.addStep("Technician search is successfull", LogAs.PASSED,null);
			
			
	}
	
	public void createEvent(Screen scn, String sStartDate, String sStartTime, String sEndDate, String sEndTime ) throws FindFailed, InterruptedException
	{
		scn.click(new Pattern(sStartDateTxtFld));
		Thread.sleep(GenericLib.iMedSleep);
		scn.type("a", KeyModifier.CTRL);
		scn.type(Key.BACKSPACE);
		Thread.sleep(GenericLib.iMedSleep);
		scn.type(sStartDate);	
		scn.type(Key.TAB);
		scn.type(Key.BACKSPACE);
		scn.type(sStartTime);
		Thread.sleep(GenericLib.iMedSleep);
		
		scn.click(new Pattern(sEndDateTxtFld));
		//scn.type(Key.TAB);
		
		Thread.sleep(GenericLib.iMedSleep);
		scn.type("a", KeyModifier.CTRL);
		scn.type(Key.BACKSPACE);
		Thread.sleep(GenericLib.iMedSleep);
		scn.type(sEndDate);
		scn.type(Key.TAB);
		scn.type(Key.BACKSPACE);
		scn.type(sEndTime);
		
		scn.click(new Pattern(sServiceTimeAutoIcn));
		scn.click(new Pattern(sSaveBtn));
		Thread.sleep(GenericLib.iHighSleep);
		
	}
	public void dragDropWO(Screen scn, String sEventTimeImg) throws FindFailed, InterruptedException
	{
		scn.click(new Pattern(sWOrderTxt));
		scn.dragDrop(new Pattern(sWOTxt), new Pattern(sEventTimeImg));
		Thread.sleep(GenericLib.iMedSleep);
	}
	
	public void gridfilterSearch(Screen scn, String sKey, String sValue) throws FindFailed, InterruptedException
	{
		scn.click(new Pattern(sFilterLst));
		scn.type(sKey);
		scn.type(Key.ENTER);
		Thread.sleep(GenericLib.iLowSleep);
		scn.type(new Pattern(sContainsTxtFld), sValue);
		Thread.sleep(GenericLib.iLowSleep);
			
		
	}
	
	public void selectOperator(Screen scn, String sOperator) throws FindFailed, InterruptedException
	{
		scn.click(new Pattern(sOperatorLst));
		scn.type(sOperator);
		scn.type(Key.ENTER);
		Thread.sleep(GenericLib.iLowSleep);
		
		
	}
}


