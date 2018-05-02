package org.ge.pageobjects;

import org.ge.dclibrary.GenericLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

public class DC_ServiceMaxSetupPage 
{
	WebDriver driver = null;
	String sXpath = "";
	Actions actions = null;
	Select selList = null;
	Select selectLst = null;
	public DC_ServiceMaxSetupPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[@class='buttonNormalTextWithIconGroup'][text()='Service Organization']")
	private WebElement eleServiceOrganizationBtn;
	public WebElement getEleServiceOrganizationBtn() 
	{
		return eleServiceOrganizationBtn;
	}

	@FindBy(xpath="//a[@id='btnLink8']/div/img")
	private WebElement eleServiceOrgImg;
	public WebElement getEleServiceOrgImg() 
	{
		return eleServiceOrgImg;
	}


	@FindBy(xpath="//input[@value='New Service Team']")
	private WebElement eleNewServiceTeamBtn;
	public WebElement getEleNewServiceTeamBtn() 
	{
		return eleNewServiceTeamBtn;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PTeam:TeamSec:ItmName:TName")
	private WebElement eleTeamNameTxtFld;
	public WebElement getEleTeamNameTxtFld() 
	{
		return eleTeamNameTxtFld;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PTeam:TeamSec:ItmActv:TActive")
	private WebElement eleActiveTeamChkBx;
	public WebElement getEleActiveTeamChkBx() 
	{
		return eleActiveTeamChkBx;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PTeam:TeamSec:ItmStrt:TStreet")
	private WebElement eleStreetTeamTxtFld;
	public WebElement getEleStreetTeamTextFld() 
	{
		return eleStreetTeamTxtFld;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PTeam:TeamSec:ItmCity:TCity")
	private WebElement eleCityTeamTxtFld;
	public WebElement getEleCityTeamTxtFld() 
	{
		return eleCityTeamTxtFld;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PTeam:TeamSec:ItmState:TState")
	private WebElement eleStateTeamTxtFld;
	public WebElement getEleStateTeamTxtFld() 
	{
		return eleStateTeamTxtFld;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PTeam:TeamSec:ItmZip:TZip")
	private WebElement eleZipTeamTxtFld;
	public WebElement getEleZipTeamTxtFld() 
	{
		return eleZipTeamTxtFld;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PTeam:TeamSec:ItmCntry:TCntry")
	private WebElement eleCountryTeamLst;
	public WebElement getEleCountryTeamLst() 
	{
		return eleCountryTeamLst;
	}
	@FindBy(xpath="//input[@value='Save']")
	private WebElement eleSaveBtn;
	public WebElement getEleSaveBtn() 
	{
		return eleSaveBtn;
	}

	@FindBy(xpath="//input[@value='Save & Close']")
	private WebElement eleSaveCloseBtn;
	public WebElement getEleSaveCloseBtn() 
	{
		return eleSaveCloseBtn;
	}

	@FindBy(xpath="//input[@type='submit']")
	private WebElement eleSubmitBtn;
	public WebElement getEleSubmitBtn() 
	{
		return eleSubmitBtn;
	}
	@FindBy(xpath="//input[@value='Next >>']")
	private WebElement eleNextBtn;
	public WebElement getEleNextBtn() 
	{
		return eleNextBtn;
	}

	@FindBy(xpath="//tr[@class='dataRow even first last']//input[@type='text']")
	private WebElement eleDipatchRuleNameTxtFld;
	public WebElement getEleDispatchRuleNameTxtFld() 
	{
		return eleDipatchRuleNameTxtFld;
	}

	@FindBy(xpath="//span[@class='lookupInput']/input[@type='text']")
	private WebElement eleDipatchTechNameTxtFld;
	public WebElement getEleDipatchTechNameTxtFld() 
	{
		return eleDipatchTechNameTxtFld;
	}

	@FindBy(xpath="//td[text()='Assignment Rules']")
	private WebElement eleAssignmentRulesTxt;
	public WebElement getEleAssignmentRulesTxt() 
	{
		return eleAssignmentRulesTxt;
	}

	private WebElement eleTeamLnk;
	public WebElement getEleTeamLnk(String sTeam) 
	{
		eleTeamLnk=driver.findElement(By.xpath("//span/a[text()='"+sTeam+"']"));
		return eleTeamLnk;
	}

	private WebElement eleViewTxt;
	public WebElement getEleViewTxt(String sViewTxt) 
	{
		eleViewTxt=driver.findElement(By.xpath("//span[text()='"+sViewTxt+"']"));
		return eleViewTxt;
	}
	
	private WebElement eleViewIdChkBx;
	public WebElement getEleViewIdChkBx(String sViewName) 
	{
		eleViewIdChkBx=driver.findElement(By.xpath("//span[text()='"+sViewName+"']/../..//input[@type='checkbox']"));
		return eleViewIdChkBx;
	}

	private WebElement eleTeamRdBtn;
	public WebElement getEleTeamRdBtn(String sTeam) 
	{
		eleTeamRdBtn=driver.findElement(By.xpath("//tr[@class=' ev_dhx_skyblue']/td/img"));
		return eleTeamRdBtn;
	}

	@FindBy(xpath="//td[text()='Dispatcher']")
	private WebElement eleDispatcherTab;
	public WebElement getEleDispatcherTab() 
	{
		return eleDispatcherTab;
	}
	@FindBy(xpath="//input[@value='Add Dispatcher']")
	private WebElement eleAddDispatcherBtn;
	public WebElement getEleAddDispatcherBtn() 
	{
		return eleAddDispatcherBtn;
	}
	@FindBy(xpath="//span[@class='lookupInput']/input")
	private WebElement eleAddDispatcherTxtFld;
	public WebElement getEleAddDispatcherTxtFld() 
	{
		return eleAddDispatcherTxtFld;
	}

	@FindBy(xpath="//h4[text()='Success:']")
	private WebElement eleSuccessTxt;
	public WebElement getEleSuccessTxt() 
	{
		return eleSuccessTxt;
	}
	@FindBy(xpath="//li/a[text()='ServiceMax Setup']")
	private WebElement eleServiceMaxSetupLnk;
	public WebElement getEleServiceMaxSetupLnk() 
	{
		return eleServiceMaxSetupLnk;
	}
	@FindBy(xpath="//div[text()='Welcome to ServiceMax Setup Home.']")
	private WebElement eleWelcometoServiceMaxSetupTxt;
	public WebElement getEleWelcometoServiceMaxSetupTxt() 
	{
		return eleWelcometoServiceMaxSetupTxt;
	}
	@FindBy(xpath="//div[text()='Define Service Organization']")
	private WebElement eleDefineServiceOrgTxt;
	public WebElement getEleDefineServiceOrgTxt() 
	{
		return eleDefineServiceOrgTxt;
	}
	@FindBy(id="TrackTechTeam:selected_ID:TTree:PanelBar:PBItem:searchText")
	private WebElement eleSearchTxtFld;
	public WebElement getEleSearchTxtFld() 
	{
		return eleSearchTxtFld;
	}


	@FindBy(id="TrackTechTeam:selected_ID:TTree:PanelBar:PBItem:Search")
	private WebElement eleGoBtn;
	public WebElement getEleGoBtn() 
	{
		return eleGoBtn;
	}
	@FindBy(xpath="//td[@id='TrackTechTeam:selected_ID:TTree:pbtns']//input[@value='New Technician']")
	private WebElement eleNewTechnicianBtn;
	public WebElement getEleNewTechnicianBtn() 
	{
		return eleNewTechnicianBtn;
	}

	@FindBy(id="TrackTechTeam:POPUPS:PbTechBlock:TechSec:ItmNm:TName")
	private WebElement eleTechNameTxtFld;
	public WebElement getEleTechNameTxtFld() 
	{
		return eleTechNameTxtFld;
	}

	@FindBy(id="TrackTechTeam:POPUPS:PbTechBlock:TechSec:ItmRole:TRole")
	private WebElement eleRoleLst;
	public WebElement getEleRoleLst() 
	{
		return eleRoleLst;
	}

	@FindBy(id="TrackTechTeam:POPUPS:PbTechBlock:TechSec:ItmStret:TStreet")
	private WebElement eleStreetTechTxtFld;
	public WebElement getEleStreetTechTextFld() 
	{
		return eleStreetTechTxtFld;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PbTechBlock:TechSec:ItmCity:TCity")
	private WebElement eleCityTechTxtFld;
	public WebElement getEleCityTechTxtFld() 
	{
		return eleCityTechTxtFld;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PbTechBlock:TechSec:ItmState:TState")
	private WebElement eleStateTechTxtFld;
	public WebElement getEleStateTechTxtFld() 
	{
		return eleStateTechTxtFld;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PbTechBlock:TechSec:ItmZip:TZip")
	private WebElement eleZipTechTxtFld;
	public WebElement getEleZipTechTxtFld() 
	{
		return eleZipTechTxtFld;
	}
	@FindBy(id="TrackTechTeam:POPUPS:PbTechBlock:TechSec:ItmCntry:TCntry")
	private WebElement eleCountryTechLst;
	public WebElement getEleCountryTechLst() 
	{
		return eleCountryTechLst;
	}


	@FindBy(id="TrackTechTeam:POPUPS:PbTechBlock:TechSec:ItmActv:TActive")
	private WebElement eleActiveTechChkBx;
	public WebElement getEleActiveTechChkBx() 
	{
		return eleActiveTechChkBx;
	}

	@FindBy(id="TrackTechTeam:POPUPS:PbTechBlock:TechSec:ItmES:TCcal")
	private WebElement eleEnableSchChkBx;
	public WebElement getEleEnableSchChkBx() 
	{
		return eleEnableSchChkBx;
	}

	private WebElement eleTechLnk;
	public WebElement getEleTechLnk(String sTech) 
	{
		eleTechLnk=driver.findElement(By.xpath("//span/a[text()='"+sTech+"']"));
		return eleTechLnk;
	}

	
	@FindBy(xpath="//table[@class='detailList']//select")
	private WebElement eleTerrCoverageLst;
	public WebElement getEleTerrCoverageLst() 
	{
		return eleTerrCoverageLst;
	}

	@FindBy(xpath="//a[@id='btnLink9']/div/img")
	private WebElement eleTerritoriesImg;
	public WebElement getEleTerritoriesImg() 
	{
		return eleTerritoriesImg;
	}
	@FindBy(xpath="//input[@maxlength='255']")
	private WebElement eleTerrCoverageTxtFld;
	public WebElement getEleTerrCoverageTxtFld() 
	{
		return eleTerrCoverageTxtFld;
	}


	private WebElement eleTerritoryLnk;
	public WebElement getEleTerritoryLnk(String sTerritory) 
	{
		eleTerritoryLnk=driver.findElement(By.xpath("//span/a[text()='"+sTerritory+"']"));
		return eleTerritoryLnk;
	}

	@FindBy(xpath="//input[@title='Add Coverage']")
	private WebElement eleAddCoverageBtn;
	public WebElement getEleAddCoverageBtn() 
	{
		return eleAddCoverageBtn;
	}


	@FindBy(xpath="//input[@title='Submit']")
	private WebElement eleSubmitTerritoryBtn;
	public WebElement getEleSubmitTerritoryBtn() 
	{
		return eleSubmitTerritoryBtn;
	}

	@FindBy(xpath="//span[@class='lookupInput']/input[@name='Territory:POPUPS:TerritoryBlock:"+".*"+":TTparent']")
	private WebElement eleParentTerritoryNameTxtFld;
	public WebElement getEleParentTerritoryNameTxtFld() 
	{
		return eleParentTerritoryNameTxtFld;
	}

	private WebElement eleTerritoryRdBtn;
	public WebElement getEleTerritoryRdBtn(String sTerritory) 
	{
		eleTerritoryRdBtn=driver.findElement(By.xpath("//a[text()='"+sTerritory+"']/../../../../td/img"));
		return eleTerritoryRdBtn;
	}
	@FindBy(xpath="//input[@title='Add Territory']")
	private WebElement eleAddTerritoryBtn;
	public WebElement getEleAddTerritoryBtn() 
	{
		return eleAddTerritoryBtn;
	}

	@FindBy(xpath="//td[@class='data2Col first']/div/input")
	private WebElement eleTerritoryNameTxtFld;
	public WebElement getEleTerritoryNameTxtFld() 
	{
		return eleTerritoryNameTxtFld;
	}

	@FindBy(xpath="//h1[text()='Territory Management Console']")
	private WebElement eleTerritoryMngmtTxt;
	public WebElement getEleTerritoryMngmtTxt() 
	{
		return eleTerritoryMngmtTxt;
	}

	//Dispatch Management


	@FindBy(xpath="//div[@class='buttonNormalTextWithIconGroup'][text()='Dispatch Management']")
	private WebElement eleDispatchManagementBtn;
	public WebElement getEleDispatchManagementBtn() 
	{
		return eleDispatchManagementBtn;
	}

	@FindBy(xpath="//a[@id='btnLink19']/div/img")
	private WebElement eleEventSubjectRuleImg;
	public WebElement getEleEventSubjectRuleImg() 
	{
		return eleEventSubjectRuleImg;
	}

	@FindBy(xpath="//div[text()='Event Hover Rules']/../../../../div/img")
	private WebElement eleEventHoverRuleImg;
	public WebElement getEleEventHoverRuleImg() 
	{
		return eleEventHoverRuleImg;
	}

	@FindBy(xpath="//div[text()='Dispatch Console Hovers']/../../../../div/img")
	private WebElement eleDCHoverRuleImg;
	public WebElement getEleDCHoverRuleImg() 
	{
		return eleDCHoverRuleImg;
	}

	@FindBy(xpath="//div[text()='Dispatch Console Views']/../../../../div/img")
	private WebElement eleDCViewRuleImg;
	public WebElement getEleDCViewRuleImg() 
	{
		return eleDCViewRuleImg;
	}

	@FindBy(xpath="//div[text()='Dispatch Console Field Updates']/../../../../div/img")
	private WebElement eleDCFieldUpdatesImg;
	public WebElement getEleDCFieldUpdatesImg() 
	{
		return eleDCFieldUpdatesImg;
	}

	@FindBy(xpath="//div[text()='Dispatch Processes']/../../../../div/img")
	private WebElement eleDispatchProcessImg;
	public WebElement getEleDispatchProcessImg() 
	{
		return eleDispatchProcessImg;
	}

	@FindBy(xpath="//td[text()='In this screen, you can create one or more Event Subject Rules.']")
	private WebElement eleEventSubjectRuleTxt;
	public WebElement getEleEventSubjectRuleTxt() 
	{
		return eleEventSubjectRuleTxt;
	}
	@FindBy(xpath="//td[@class='rich-toolbar-item '][text()='In this screen, you can create one or more Event Hover Rules.']")
	private WebElement eleEventHoverRuleTxt;
	public WebElement getEleEventHoverRuleTxt() 
	{
		return eleEventHoverRuleTxt;
	}

	@FindBy(xpath="//span[@class='boldText'][text()='Choose Work Order & Event fields to be updated from Dispatch Console']")
	private WebElement eleDCFieldUpdateRuleTxt;
	public WebElement getEleDCFieldUpdateRuleTxt() 
	{
		return eleDCFieldUpdateRuleTxt;
	}

	@FindBy(xpath="//div[text()='Dispatch Process Name']")
	private WebElement eleDispatchProcessNameTxt;
	public WebElement getEleDispatchProcessNameTxt() 
	{
		return eleDispatchProcessNameTxt;
	}

	@FindBy(xpath="//h2[text()='Configure Map Hover']")
	private WebElement eleConfigMapHoverTxt;
	public WebElement getEleConfigMapHoverTxt() 
	{
		return eleConfigMapHoverTxt;
	}

	@FindBy(xpath="//h2[text()='Manage Views']")
	private WebElement eleManageViewTxt;
	public WebElement getEleManageViewTxt() 
	{
		return eleManageViewTxt;
	}

	@FindBy(xpath="//td[@class='dataCol  first  last ']/div/select")
	private WebElement eleViewObjectLst;
	public WebElement getEleViewObjectLst() 
	{
		return eleViewObjectLst;
	}

	@FindBy(xpath="//span[text()='DC_EventSubjectRule']")
	private WebElement eleDCEventSubjectRuleTxt;
	public WebElement getEleDCEventSubjectRuleTxt() 
	{
		return eleDCEventSubjectRuleTxt;
	}

	@FindBy(xpath="//span[text()='DC_EventHoverRule']")
	private WebElement eleDCEventHoverRuleTxt;
	public WebElement getEleDCEventHoverRuleTxt() 
	{
		return eleDCEventHoverRuleTxt;
	}

	@FindBy(xpath="//span[text()='DC_AutoDispatchProcess']")
	private WebElement eleDCAutoDispatchProcessTxt;
	public WebElement getEleDCAutoDispatchProcessTxt() 
	{
		return eleDCAutoDispatchProcessTxt;
	}

	@FindBy(xpath="//span[text()='DC_EventSubjectRule']/../..//input[@type='checkbox']")
	private WebElement eleDCSubjectRuleChkBx;
	public WebElement getEleDCSubjectRuleChkBx() 
	{
		return eleDCSubjectRuleChkBx;
	}
	@FindBy(xpath="//span[text()='DC_EventHoverRule']/../..//input[@type='checkbox']")
	private WebElement eleDCHoverRuleChkBx;
	public WebElement getEleDCHoverRuleChkBx() 
	{
		return eleDCHoverRuleChkBx;
	}
	@FindBy(xpath="//span[text()='DC_AutoDispatchProcess']/../../td/input[@type='checkbox']")
	private WebElement eleDCAutoDispatchProcessChkBx;
	public WebElement getEleDCAutoDispatchProcessChkBx() 
	{
		return eleDCAutoDispatchProcessChkBx;
	}

	@FindBy(xpath="//input[@value='New Rule']")
	private WebElement eleNewRuleBtn;
	public WebElement getEleNewRuleBtn() 
	{
		return eleNewRuleBtn;
	}
	@FindBy(xpath="//input[@value='New Process']")
	private WebElement eleNewProcessBtn;
	public WebElement getEleNewProcessBtn() 
	{
		return eleNewProcessBtn;
	}


	@FindBy(xpath="//label[text()='Process Name']/../..//input")
	private WebElement eleProcessNameTxtFld;
	public WebElement getEleProcessNameTxtFld() 
	{
		return eleProcessNameTxtFld;
	}


	@FindBy(xpath="//input[@value='Delete Rule']")
	private WebElement eleDeleteRuleBtn;
	public WebElement getEleDeleteRuleBtn() 
	{
		return eleDeleteRuleBtn;
	}

	@FindBy(xpath="//input[@value='Delete']")
	private WebElement eleDeleteBtn;
	public WebElement getEleDeleteBtn() 
	{
		return eleDeleteBtn;
	}

	@FindBy(xpath="//td[2]/input[@type='text']")
	private WebElement eleRuleNameTxtFld;
	public WebElement getEleRuleNameTxtFld() 
	{
		return eleRuleNameTxtFld;
	}
	@FindBy(xpath="(//div/input[@type='text'])[2]")
	private WebElement eleViewNameTxtFld;
	public WebElement getEleViewNameTxtFld() 
	{
		return eleViewNameTxtFld;
	}

	@FindBy(xpath="(//div/input[@type='text'])[3]")
	private WebElement eleViewIdTxtFld;
	public WebElement getEleViewIdTxtFld() 
	{
		return eleViewIdTxtFld;
	}

	@FindBy(xpath="//td[2]/select")
	private WebElement eleWOFieldLst;
	public WebElement getEleWOFieldLst() 
	{
		return eleWOFieldLst;
	}

	@FindBy(xpath="//label[text()='Dispatch Method']/../..//select")
	private WebElement eleDispatchMethodLst;
	public WebElement getEleDispatchMethodLst() 
	{
		return eleDispatchMethodLst;
	}

	@FindBy(xpath="//tr[@class='dataRow even first']/td[2]/select")
	private WebElement eleWOField1Lst;
	public WebElement getEleWOField1Lst() 
	{
		return eleWOField1Lst;
	}

	@FindBy(xpath="//tr[@class='dataRow even first last']/td[2]/select")
	private WebElement eleFieldNameLst;
	public WebElement getEleFieldNameLst() 
	{
		return eleFieldNameLst;
	}

	@FindBy(xpath="//tr[@class='dataRow even first last']/td[3]/select")
	private WebElement eleOperatorLst;
	public WebElement getEleOperatorLst() 
	{
		return eleOperatorLst;
	}

	@FindBy(xpath="//tr[@class='dataRow even first']/td[3]/select")
	private WebElement eleOperator1Lst;
	public WebElement getEleOperator1Lst() 
	{
		return eleOperator1Lst;
	}

	@FindBy(xpath="//select[@onchange='AssignWOto()']")
	private WebElement eleAssignWOLst;
	public WebElement getEleAssignWOLst() 
	{
		return eleAssignWOLst;
	}
	@FindBy(xpath="//select[@onchange='RulesNotMatchedThenAssignWOto()']")
	private WebElement eleAssignWONotMatchedLst;
	public WebElement getEleAssignWONotMatchedLst() 
	{
		return eleAssignWONotMatchedLst;
	}
	@FindBy(xpath="//label[text()='Dispatcher']/../..//span[@class='lookupInput']/input[@type='text']")
	private WebElement eleDispatcherTxtFld;
	public WebElement getEleDispatcherTxtFld() 
	{
		return eleDispatcherTxtFld;
	}

	@FindBy(xpath="//tr[@class='dataRow even first']//td/input")
	private WebElement eleWOFieldValue1TxtFld;
	public WebElement getEleWOFieldValue1TxtFld() 
	{
		return eleWOFieldValue1TxtFld;
	}

	@FindBy(xpath="//span[text()='Update Field1']/../../td[2]/div/select")
	private WebElement eleUpdateField1Lst;
	public WebElement getEleUpdateField1Lst() 
	{
		return eleUpdateField1Lst;
	}

	@FindBy(xpath="//span[text()='Update Field2']/../../td[2]/div/select")
	private WebElement eleUpdateField2Lst;
	public WebElement getEleUpdateField2Lst() 
	{
		return eleUpdateField2Lst;
	}

	//@FindBy(xpath="(//table[@class='detailList'])[1]/tbody/tr[2]//select")
	@FindBy(xpath="//span[text()='Update Field3']/../../td[2]/div/select")

	private WebElement eleUpdateField3Lst;
	public WebElement getEleUpdateField3Lst() 
	{
		return eleUpdateField3Lst;
	}
	@FindBy(xpath="//span[text()='Update Field4']/../../td[2]/div/select")
	private WebElement eleUpdateField4Lst;
	public WebElement getEleUpdateField4Lst() 
	{
		return eleUpdateField4Lst;
	}
	@FindBy(xpath="//td[3]/select")
	private WebElement eleWoOperatorLst;
	public WebElement getEleWoOperatorLst() 
	{
		return eleWoOperatorLst;
	}

	@FindBy(xpath="//td[4]/input[@type='text']")
	private WebElement eleWOCityValueTxtFld;
	public WebElement getEleWOCityValueTxtFld() 
	{
		return eleWOCityValueTxtFld;
	}

	@FindBy(xpath="//tr[2]/td[2]/select")
	private WebElement eleWOField2Lst;
	public WebElement getEleWOField2Lst() 
	{
		return eleWOField2Lst;
	}

	@FindBy(xpath="//tr[2]/td[3]/select")
	private WebElement eleWoOperator2Lst;
	public WebElement getEleWoOperator2Lst() 
	{
		return eleWoOperator2Lst;
	}

	@FindBy(xpath="//tr[2]/td[4]/input[@type='text']")
	private WebElement eleWOZipValueTxtFld;
	public WebElement getEleWOZipValueTxtFld() 
	{
		return eleWOZipValueTxtFld;
	}

	@FindBy(xpath="//tr[@class='line']//select")
	private WebElement eleFieldResultLst;
	public WebElement getEleFieldResultLst() 
	{
		return eleFieldResultLst;
	}

	@FindBy(xpath="//tr[@class='line']//table//tr[2]//input[@type='image']")
	private WebElement eleArrowRightBtn;
	public WebElement getEleArrowRightBtn() 
	{
		return eleArrowRightBtn;
	}

	@FindBy(xpath="//td[text()='Field 1']/../td[2]/div/select")
	private WebElement eleMapWOField1Lst;
	public WebElement getEleMapWOField1Lst() 
	{
		return eleMapWOField1Lst;
	}
	@FindBy(xpath="//td[text()='Field 2']/../td[2]/div/select")
	private WebElement eleMapWOField2Lst;
	public WebElement getEleMapWOField2Lst() 
	{
		return eleMapWOField2Lst;
	}
	@FindBy(xpath="//td[text()='Field 3']/../td[2]/div/select")
	private WebElement eleMapWOField3Lst;
	public WebElement getEleMapWOField3Lst() 
	{
		return eleMapWOField3Lst;
	}
	@FindBy(xpath="//td[text()='Field 4']/../td[2]/div/select")
	private WebElement eleMapWOField4Lst;
	public WebElement getEleMapWOField4Lst() 
	{
		return eleMapWOField4Lst;
	}

	@FindBy(xpath="//td[text()='Field 5']/../td[2]/div/select")
	private WebElement eleMapWOField5Lst;
	public WebElement getEleMapWOField5Lst() 
	{
		return eleMapWOField5Lst;
	}

	@FindBy(xpath="//div[3]//td[text()='Field 1']/../td[2]/div/select")
	private WebElement eleMapLocField1Lst;
	public WebElement getEleMapLocField1Lst() 
	{
		return eleMapLocField1Lst;
	}
	@FindBy(xpath="//div[3]//td[text()='Field 2']/../td[2]/div/select")
	private WebElement eleMapLocField2Lst;
	public WebElement getEleMapLocField2Lst() 
	{
		return eleMapLocField2Lst;
	}
	@FindBy(xpath="//div[3]//td[text()='Field 3']/../td[2]/div/select")
	private WebElement eleMapLocField3Lst;
	public WebElement getEleMapLocField3Lst() 
	{
		return eleMapLocField3Lst;
	}
	@FindBy(xpath="//div[3]//td[text()='Field 4']/../td[2]/div/select")
	private WebElement eleMapLocField4Lst;
	public WebElement getEleMapLocField4Lst() 
	{
		return eleMapLocField4Lst;
	}

	@FindBy(xpath="//div[3]//td[text()='Field 5']/../td[2]/div/select")
	private WebElement eleMapLocField5Lst;
	public WebElement getEleMapLocField5Lst() 
	{
		return eleMapLocField5Lst;
	}

	@FindBy(xpath="//div[5]//td[text()='Field 1']/../td[2]/div/select")
	private WebElement eleMapAccField1Lst;
	public WebElement getEleMapAccField1Lst() 
	{
		return eleMapAccField1Lst;
	}
	@FindBy(xpath="//div[5]//td[text()='Field 2']/../td[2]/div/select")
	private WebElement eleMapAccField2Lst;
	public WebElement getEleMapAccField2Lst() 
	{
		return eleMapAccField2Lst;
	}
	@FindBy(xpath="//div[5]//td[text()='Field 3']/../td[2]/div/select")
	private WebElement eleMapAccField3Lst;
	public WebElement getEleMapAccField3Lst() 
	{
		return eleMapAccField3Lst;
	}
	@FindBy(xpath="//div[5]//td[text()='Field 4']/../td[2]/div/select")
	private WebElement eleMapAccField4Lst;
	public WebElement getEleMapAccField4Lst() 
	{
		return eleMapAccField4Lst;
	}

	@FindBy(xpath="//div[5]//td[text()='Field 5']/../td[2]/div/select")
	private WebElement eleMapAccField5Lst;
	public WebElement getEleMapAccField5Lst() 
	{
		return eleMapAccField5Lst;
	}

	@FindBy(xpath="//td[@class='dataCol first last']/select")
	private WebElement eleViewForLst;
	public WebElement getEleViewForLst() 
	{
		return eleViewForLst;
	}

	@FindBy(xpath="//input[@value='New']")
	private WebElement eleNewBtn;
	public WebElement getEleNewBtn() 
	{
		return eleNewBtn;
	}
	
	///Methods---
	//Navigation to ServiceMax setup
	public void navigateServiceMaxSetup() throws InterruptedException
	{
		actions = new Actions(driver);
		actions.moveToElement(getEleServiceMaxSetupLnk()).click(getEleServiceMaxSetupLnk()).build().perform();
		Assert.assertTrue(getEleWelcometoServiceMaxSetupTxt().isDisplayed(),"Failed to navigate to ServiceMax setup page");
		NXGReports.addStep("Navigation to ServiceMax Setup page", LogAs.PASSED,null);
	}

	//Creation of Event Subject Rule
	public void createEventSubjectRule() throws InterruptedException
	{
		actions = new Actions(driver);
		actions.moveToElement(getEleEventSubjectRuleImg()).pause(1000).doubleClick(getEleEventSubjectRuleImg()).build().perform();

		//actions.doubleClick(getEleEventSubjectRuleImg()).build().perform();
		Thread.sleep(GenericLib.iHighSleep);
		Assert.assertTrue(getEleEventSubjectRuleTxt().isDisplayed(),"Failed to navigate to Event Subject Rules page");
		NXGReports.addStep("Navigation to Event Subject Rules to create subject rule", LogAs.PASSED,null);

		try {
			if(getEleDCEventSubjectRuleTxt().isDisplayed())
			{
				getEleDCSubjectRuleChkBx().click();
				getEleDeleteRuleBtn().click();
				Thread.sleep(GenericLib.iMedSleep);
				driver.switchTo().alert().accept();
				Thread.sleep(GenericLib.iHighSleep);
			}
		}catch(Exception e){	}

		getEleNewRuleBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		getEleRuleNameTxtFld().sendKeys("DC_EventSubjectRule");
		selList = new Select(getEleWOFieldLst());
		selList.selectByVisibleText("City");;
		selList = new Select(getEleWoOperatorLst());
		selList.selectByVisibleText("Equals");
		getEleWOCityValueTxtFld().sendKeys("Delhi");
		selList = new Select(getEleWOField2Lst());
		selList.selectByVisibleText("Zip");;
		selList = new Select(getEleWoOperator2Lst());
		selList.selectByVisibleText("Starts With");
		getEleWOZipValueTxtFld().sendKeys("1100");

		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("City");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Zip");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Country");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Work Order Number");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		getEleSaveBtn().click();

		Assert.assertTrue(getEleDCEventSubjectRuleTxt().isDisplayed(),"Failed to create event subject rule for delhi team");
		NXGReports.addStep(" Event Subject Rule for Delhi users was successfully created", LogAs.PASSED,null);

	}	

	//Creation of Event Hover Rule
	public void createEventHoverRule() throws InterruptedException
	{
		actions = new Actions(driver);
		//actions.doubleClick(getEleEventHoverRuleImg()).build().perform();
		actions.moveToElement(getEleEventHoverRuleImg()).pause(1000).doubleClick(getEleEventHoverRuleImg()).build().perform();

		Thread.sleep(GenericLib.iHighSleep);
		Assert.assertTrue(getEleEventHoverRuleTxt().isDisplayed(),"Failed to navigate to Event Hover Rules page");
		NXGReports.addStep("Navigation to Event Hover Rules to create Hover rule was successful", LogAs.PASSED,null);

		try {
			if(getEleDCEventHoverRuleTxt().isDisplayed())
			{  
				getEleDCHoverRuleChkBx().click();
				getEleDeleteRuleBtn().click();
				Thread.sleep(GenericLib.iMedSleep);
				driver.switchTo().alert().accept();
				Thread.sleep(GenericLib.iHighSleep);
			}
		}catch(Exception e){	}

		getEleNewRuleBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		getEleRuleNameTxtFld().sendKeys("DC_EventHoverRule");
		selList = new Select(getEleWOFieldLst());
		selList.selectByVisibleText("City");;
		selList = new Select(getEleWoOperatorLst());
		selList.selectByVisibleText("Equals");
		getEleWOCityValueTxtFld().sendKeys("Delhi");
		selList = new Select(getEleWOField2Lst());
		selList.selectByVisibleText("Zip");;
		selList = new Select(getEleWoOperator2Lst());
		selList.selectByVisibleText("Starts With");
		getEleWOZipValueTxtFld().sendKeys("1100");


		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Account");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Billing Type");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Contact");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Dispatch Process");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		getEleSaveBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		Assert.assertTrue(getEleDCEventHoverRuleTxt().isDisplayed(),"Failed to create event hover rule for delhi team");
		NXGReports.addStep(" Event Hover Rule for Delhi users was successfully created", LogAs.PASSED,null);



	}	

	//Creation of Event Field updates
	public void createEventFieldUpdatesRule() throws InterruptedException
	{
		actions = new Actions(driver);
		actions.moveToElement(getEleDCFieldUpdatesImg()).pause(1000).doubleClick(getEleDCFieldUpdatesImg()).build().perform();

		Thread.sleep(GenericLib.iHighSleep);
		Assert.assertTrue(getEleDCFieldUpdateRuleTxt().isDisplayed(),"Failed to navigate to event field updates page");
		NXGReports.addStep("Navigation to event field update page was successful", LogAs.PASSED,null);

		selList = new Select(getEleUpdateField1Lst());
		selList.selectByVisibleText("Billing Type");;
		Thread.sleep(GenericLib.iLowSleep);

		selList = new Select(getEleUpdateField2Lst());
		selList.selectByVisibleText("Invoice Number");;
		Thread.sleep(GenericLib.iLowSleep);

		selList = new Select(getEleUpdateField3Lst());
		selList.selectByVisibleText("Entitlement Type");;
		Thread.sleep(GenericLib.iLowSleep);

		selList = new Select(getEleUpdateField4Lst());
		selList.selectByVisibleText("Purpose of Visit");;
		Thread.sleep(GenericLib.iLowSleep);

		getEleSaveBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		Assert.assertTrue(getEleSuccessTxt().isDisplayed(),"Failed to create field updates");
		NXGReports.addStep(" Event Field updates were successfully created", LogAs.PASSED,null);

	}	

	//Creation of Immediate dispatch process
	public void createImmediateDispatchProcess(String sTech, String sDispatcher, DC_DispatchConsolePage dc_dispatchconsolePage, Screen scn) throws InterruptedException, FindFailed
	{
		actions = new Actions(driver);
		actions.moveToElement(getEleDispatchProcessImg()).clickAndHold(getEleDispatchProcessImg()).click(getEleDispatchProcessImg()).build().perform();
		String sOperatorImg = null;
		Thread.sleep(GenericLib.iHighSleep);
		Assert.assertTrue(getEleNewProcessBtn().isDisplayed(),"Failed to navigate to Dispatch Process management page");
		NXGReports.addStep("Navigation to Dispatch process management page was successful", LogAs.PASSED,null);

		try {
			if(getEleDCAutoDispatchProcessTxt().isDisplayed())
			{  	
				getEleDCAutoDispatchProcessChkBx().click();
				getEleDeleteBtn().click();
				driver.switchTo().alert().accept();
				Thread.sleep(GenericLib.iMedSleep);
			}
		}catch(Exception e){	}
		getEleNewProcessBtn().click();
		Thread.sleep(GenericLib.iLowSleep);

		getEleProcessNameTxtFld().sendKeys("DC_AutoDispatchProcess");
		selList = new Select(getEleWOField1Lst());
		selList.selectByVisibleText("Zip");

		scn = new Screen();
		try {
			scn.click(new Pattern(dc_dispatchconsolePage.sOperatorFFLst));
		}catch (Exception e) {
			scn.click(new Pattern(dc_dispatchconsolePage.sOperatorLst));
		}
		scn.type(Key.DOWN);
		scn.type("S");
		scn.type(Key.ENTER);
		Thread.sleep(GenericLib.iLowSleep);
		scn = new Screen();
		scn.type(Key.TAB);
		scn.type("1100");

		/*scn = new Screen();
		scn.type(Key.TAB);
		scn.type("1100");*/

		selList = new Select(getEleDispatchMethodLst());
		selList.selectByVisibleText("Immediate");
		Thread.sleep(GenericLib.iMedSleep);
		getEleNextBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		Assert.assertTrue(getEleAssignmentRulesTxt().isDisplayed(),"Failed to navigate to Assignment rules page");
		NXGReports.addStep(" Navigation to Assignment rules page was successful", LogAs.PASSED,null);
		getEleNewRuleBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		getEleDispatchRuleNameTxtFld().sendKeys("DC_AutoDispatchProcess");

		selList = new Select(getEleAssignWOLst());
		selList.selectByVisibleText("Technician");
		Thread.sleep(GenericLib.iMedSleep);
		getEleDipatchTechNameTxtFld().sendKeys(sTech);

		selList = new Select(getEleAssignWONotMatchedLst());
		selList.selectByVisibleText("Dispatcher");
		Thread.sleep(GenericLib.iMedSleep);

		getEleDispatcherTxtFld().sendKeys(sDispatcher);
		getEleSaveBtn().click();
		Assert.assertTrue(getEleSuccessTxt().isDisplayed(),"Rule is not saved");
		NXGReports.addStep("Immediate dispatch rule is saved successfully", LogAs.PASSED,null);
	}	

	//Navigation to Team Technician Management Console page
	public void navigateTeamTechnicianMngmt() throws InterruptedException
	{
		navigateServiceMaxSetup();
		getEleServiceOrganizationBtn().click();
		Thread.sleep(2000);
		//Assert.assertTrue(getEleDefineServiceOrgTxt().isDisplayed(),"Failed to navigate to ServiceOrg page");
		NXGReports.addStep("Navigation to Service Org module", LogAs.PASSED,null);

		actions = new Actions(driver);
		actions.moveToElement(getEleServiceOrgImg()).pause(1000).doubleClick(getEleServiceOrgImg()).build().perform();

		//actions.doubleClick(getEleServiceOrgImg()).build().perform();
		Thread.sleep(2000);
		Assert.assertTrue(getEleNewServiceTeamBtn().isDisplayed(),"Failed to navigate to Team Technician Management Console page");
		NXGReports.addStep("Navigation to Team Technician Management Console to create Teams", LogAs.PASSED,null);

	}

	//Navigation to Territory Management Console
	public void navigateTerritoryMngmt() throws InterruptedException
	{
		navigateServiceMaxSetup();
		getEleServiceOrganizationBtn().click();
		Thread.sleep(2000);
		//Assert.assertTrue(getEleDefineServiceOrgTxt().isDisplayed(),"Failed to navigate to ServiceOrg page");
		NXGReports.addStep("Navigation to Service Org module", LogAs.PASSED,null);

		actions = new Actions(driver);
		actions.moveToElement(getEleTerritoriesImg()).pause(1000).doubleClick(getEleTerritoriesImg()).build().perform();

		//actions.doubleClick(getEleTerritoriesImg()).build().perform();
		Thread.sleep(GenericLib.iLowSleep);
		Assert.assertTrue(getEleTerritoryMngmtTxt().isDisplayed(),"Failed to navigate to Territory Management Console page");
		NXGReports.addStep("Navigation to Territory Management Console to create Teams", LogAs.PASSED,null);
	}

	//Add territory 
	public void SearchAddTerritory(String sTerritoryName, String sParentName) throws InterruptedException
	{
		try {
			Assert.assertTrue(getEleTerritoryLnk(sTerritoryName).isDisplayed(), "Territory is not displayed,");	
			Thread.sleep(GenericLib.iLowSleep);}
		catch(Exception e) 
		{
			getEleAddTerritoryBtn().click();
			Thread.sleep(GenericLib.iLowSleep);
			getEleTerritoryNameTxtFld().sendKeys(sTerritoryName);

			getEleSubmitTerritoryBtn().click();
			Assert.assertTrue(getEleTerritoryLnk(sTerritoryName).isDisplayed(),"Failed to navigate to Territory Management Console page");
			NXGReports.addStep("Navigation to Territory Management Console to create Teams", LogAs.PASSED,null);
		}
	}

	//Creation of Team and validate team address
	public void createTeam(String sTeam, String sStreet, String sCity, String sState, String sZip, String sCountry, Boolean bValidate, DC_SalesforcePage dc_salesforPage) throws InterruptedException
	{
		getEleNewServiceTeamBtn().click();
		getEleTeamNameTxtFld().sendKeys(sTeam);
		getEleActiveTeamChkBx().click();
		getEleStreetTeamTextFld().sendKeys(sStreet);
		getEleCityTeamTxtFld().sendKeys(sCity);
		getEleStateTeamTxtFld().sendKeys(sState);
		getEleZipTeamTxtFld().sendKeys(sZip);
		selList = new Select(getEleCountryTeamLst());
		selList.selectByValue(sCountry);
		Thread.sleep(5000);
		getEleSaveBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		Assert.assertTrue(getEleTeamLnk(sTeam).isDisplayed(), sTeam +" is not created");
		NXGReports.addStep("Creation of "+sTeam+" is successful", LogAs.PASSED,null);
		dc_salesforPage.handleLightningAlert();

		if(bValidate)
		{
			getEleTeamLnk(sTeam).click();
			Thread.sleep(GenericLib.iHighSleep);
			dc_salesforPage.validateTeam(sTeam);
		}

	}

	//Creation of Technician and validate technician address
	public void createTechnician(String sTech, String sStreet, String sCity, String sState, String sZip, String sCountry,Boolean bValidate, DC_SalesforcePage dc_salesforPage) throws InterruptedException
	{
		getEleNewTechnicianBtn().click();
		//actions = new Actions(driver);
		//actions.click(getEleNewTechnicianBtn()).build().perform();
		getEleTechNameTxtFld().sendKeys(sTech);
		selList = new Select(getEleRoleLst());
		selList.selectByValue("Technician");
		getEleActiveTechChkBx().click();
		getEleEnableSchChkBx().click();
		getEleStreetTechTextFld().sendKeys(sStreet);
		getEleCityTechTxtFld().sendKeys(sCity);
		getEleStateTechTxtFld().sendKeys(sState);
		getEleZipTechTxtFld().sendKeys(sZip);
		selList = new Select(getEleCountryTechLst());
		selList.selectByValue(sCountry);
		Thread.sleep(5000);
		getEleSaveBtn().click();
		Thread.sleep(5000);
		Assert.assertTrue(getEleTechLnk(sTech).isDisplayed(), "Test technician is not created");
		NXGReports.addStep("Creation of Technician is successful", LogAs.PASSED,null);
		if(bValidate){
			getEleTechLnk(sTech).click();
			Thread.sleep(GenericLib.iMedSleep);
			dc_salesforPage.validateTech(sTech);
		}

	}

	//To add dispatcher
	public void addDispatcher() throws Exception
	{
		getEleDispatcherTab().click();
		Thread.sleep(GenericLib.iMedSleep);
		try {
			if(getEleAddDispatcherTxtFld().isDisplayed())
			{
				NXGReports.addStep("Dispatcher field exists", LogAs.PASSED,null);
				System.out.println("Dispatcher exists");
			}
		}
		catch(Exception e) {
			System.out.println("Dispatcher doenot  exists");
			getEleAddDispatcherBtn().click();
			Thread.sleep(GenericLib.iLowSleep);

			getEleAddDispatcherTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "DISPATCHER"));

			try {
				getEleSaveBtn().click();
				Thread.sleep(GenericLib.iLowSleep);
				Assert.assertTrue(getEleSuccessTxt().isDisplayed(), "Dispatcher is not added to created team");
				NXGReports.addStep("Dispatcher access to created teamS", LogAs.PASSED,null);

			}
			catch(Exception es) {
				actions = new Actions(driver);
				actions.doubleClick(getEleSaveBtn()).build().perform();
			}
		}
	}


	public void searchTeam(String sTeam, String sTech, String sStreet, String sCity, String sState, String sZip, String sCountry, Boolean bTeam,Boolean bValidate, DC_SalesforcePage dc_salesforPage) throws InterruptedException
	{
		getEleSearchTxtFld().sendKeys(sTeam);
		getEleGoBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		try {
			Assert.assertTrue(getEleTeamRdBtn(sTeam).isDisplayed(), "Team is not displayed, failed to search");	
			getEleTeamRdBtn(sTeam).click();
			Thread.sleep(GenericLib.iMedSleep);}
		catch(Exception e) {
			if(bTeam) {createTeam(sTeam, sStreet, sCity, sState, sZip, sCountry, bValidate, dc_salesforPage);}
			dc_salesforPage.navigatehome();
			navigateTeamTechnicianMngmt();
			searchTeam(sTeam, sTech, sStreet, sCity, sState, sZip, sCountry, false, false, dc_salesforPage);
		}

	}	

	public void searchTech(String sTeam, String sTech,String sStreet, String sCity, String sState, String sZip, String sCountry, Boolean bTech,Boolean bValidate, DC_SalesforcePage dc_salesforPage) throws InterruptedException
	{
		try {	
			Assert.assertTrue(getEleTechLnk(sTech).isDisplayed(), "Test technician is not created");}
		catch (Exception e) {
			if(bTech) {createTechnician(sTech, sStreet, sCity, sState, sZip, sCountry, bValidate, dc_salesforPage);}}
		dc_salesforPage.navigatehome();
		Thread.sleep(GenericLib.iMedSleep);
		navigateTeamTechnicianMngmt();
		searchTeam(sTeam, sTech, sStreet, sCity, sState, sZip, sCountry, false, false, dc_salesforPage);

	}

	//Creation of Dispatch Hover Rule
	public void createDispatchHoverRule() throws InterruptedException
	{
		actions = new Actions(driver);
		//actions.doubleClick(getEleEventHoverRuleImg()).build().perform();
		actions.moveToElement(getEleDCHoverRuleImg()).pause(1000).doubleClick(getEleDCHoverRuleImg()).build().perform();

		Thread.sleep(GenericLib.iHighSleep);
		Assert.assertTrue(getEleConfigMapHoverTxt().isDisplayed(),"Failed to navigate to Configure Map Hover Rules page");
		NXGReports.addStep("Navigation to Configure Map Hover Rules to create Hover rule was successful", LogAs.PASSED,null);

		selList = new Select(getEleMapWOField1Lst());
		selList.selectByVisibleText("Order Status");

		selList = new Select(getEleMapWOField2Lst());
		selList.selectByVisibleText("Account");

		selList = new Select(getEleMapWOField3Lst());
		selList.selectByVisibleText("Contact");

		selList = new Select(getEleMapWOField4Lst());
		selList.selectByVisibleText("City");

		selList = new Select(getEleMapWOField5Lst());
		selList.selectByVisibleText("Dispatch Status");

		selList = new Select(getEleMapLocField1Lst());
		selList.selectByVisibleText("Location Name");

		selList = new Select(getEleMapLocField2Lst());
		selList.selectByVisibleText("Stocking Location");

		selList = new Select(getEleMapLocField3Lst());
		selList.selectByVisibleText("Email");

		selList = new Select(getEleMapLocField4Lst());
		selList.selectByVisibleText("City");

		selList = new Select(getEleMapLocField5Lst());
		selList.selectByVisibleText("Owner ID");

		selList = new Select(getEleMapAccField1Lst());
		selList.selectByVisibleText("Account Name");

		selList = new Select(getEleMapAccField2Lst());
		selList.selectByVisibleText("Account Site");

		selList = new Select(getEleMapAccField3Lst());
		selList.selectByVisibleText("SIC Code");

		selList = new Select(getEleMapAccField4Lst());
		selList.selectByVisibleText("Industry");

		selList = new Select(getEleMapAccField5Lst());
		selList.selectByVisibleText("Annual Revenue");

		getEleSaveBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		Assert.assertTrue(getEleSuccessTxt().isDisplayed(),"Failed to create Map hover rule.");
		NXGReports.addStep(" Map Hover Rule was successfully created", LogAs.PASSED,null);
	}	

	//Creation of Dispatch Hover Rule
	public void createDispatchViewRule(Screen scn, DC_DispatchConsolePage dc_dispatchconsolePage ) throws InterruptedException, FindFailed
	{
		actions = new Actions(driver);
		//actions.doubleClick(getEleEventHoverRuleImg()).build().perform();
		actions.moveToElement(getEleDCViewRuleImg()).pause(1000).doubleClick(getEleDCViewRuleImg()).build().perform();
		Thread.sleep(GenericLib.iMedSleep);
		deleteView("DC_AccMap_View");
		deleteView("DC_LocMap_View");
		deleteView("DC_WOGrid_View");
		deleteView("DC_WOGridMap_View");
		deleteView("DC_WOMap_View");

	}	

	public void deleteView(String sViewName) throws InterruptedException
	{
		try {
		getEleViewIdChkBx(sViewName).click();
		getEleDeleteBtn().click();
		System.out.println("Deleting "+sViewName);
		Thread.sleep(GenericLib.iMedSleep);
		driver.switchTo().alert().accept();
		Thread.sleep(GenericLib.iHighSleep);
		}catch(Exception e)
		{System.out.println("Could not find"+ sViewName);
		}
		
	}
	public void createMapView(Screen scn, DC_DispatchConsolePage dc_dispatchconsolePage,String sViewObject, String sViewTxt, String sFieldName, String sFieldValue) throws InterruptedException, FindFailed
	{
		
		Assert.assertTrue(getEleManageViewTxt().isDisplayed(),"Failed to navigate to Dispatch console Manage View Rules page");
		NXGReports.addStep("Navigation to Dispatch Console Manage view Rules was successful", LogAs.PASSED,null);

		getEleNewBtn().click();

		selList = new Select(getEleViewObjectLst());
		selList.selectByVisibleText(sViewObject);
		Thread.sleep(GenericLib.iMedSleep);
		getEleViewNameTxtFld().sendKeys(sViewTxt);
		getEleViewIdTxtFld().sendKeys(sViewTxt);

		selList = new Select(getEleFieldNameLst());
		selList.selectByVisibleText(sFieldName);
		scn = new Screen();
		try {
			scn.click(new Pattern(dc_dispatchconsolePage.sOperatorFFLst));
		}catch (Exception e) {
			scn.click(new Pattern(dc_dispatchconsolePage.sOperatorLst));
		}
		scn.type(Key.DOWN);
		scn.type("Eq");
		scn.type(Key.ENTER);
		Thread.sleep(GenericLib.iLowSleep);
		scn = new Screen();
		scn.type(Key.TAB);
		scn.type(sFieldValue);

		getEleSaveCloseBtn().click();

		Thread.sleep(GenericLib.iMedSleep);
		Assert.assertTrue(getEleViewTxt(sViewTxt).isDisplayed(),"Failed to create dispatch view rule for "+sViewObject);
		NXGReports.addStep("Dispatch console view "+ sViewTxt+" was created successfully.", LogAs.PASSED,null);	
	}

	public void createWOView(Screen scn, DC_DispatchConsolePage dc_dispatchconsolePage, String sViewTxt, String sViewFor) throws InterruptedException, FindFailed
	{
		Assert.assertTrue(getEleManageViewTxt().isDisplayed(),"Failed to navigate to Dispatch console Manage View Rules page");
		NXGReports.addStep("Navigation to Dispatch Console Manage view Rules was successful", LogAs.PASSED,null);

		getEleNewBtn().click();

		selList = new Select(getEleViewObjectLst());
		selList.selectByVisibleText("Work Order");
		Thread.sleep(GenericLib.iMedSleep);
		getEleViewNameTxtFld().sendKeys(sViewTxt);
		getEleViewIdTxtFld().sendKeys(sViewTxt);

		selList = new Select(getEleViewForLst());
		selList.selectByVisibleText(sViewFor);
		
		selList = new Select(getEleFieldNameLst());
		selList.selectByVisibleText("City");
		
		scn = new Screen();
		try {
			scn.click(new Pattern(dc_dispatchconsolePage.sOperatorFFLst));
		}catch (Exception e) {
			scn.click(new Pattern(dc_dispatchconsolePage.sOperatorLst));
		}
		scn.type(Key.DOWN);
		scn.type("Eq");
		scn.type(Key.ENTER);
		Thread.sleep(GenericLib.iLowSleep);
		scn = new Screen();
		scn.type(Key.TAB);
		scn.type("Mysore");
		Thread.sleep(GenericLib.iLowSleep);
		
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Account");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Technician");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Billing Type");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Contact");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("City");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		selList = new Select(getEleFieldResultLst());
		selList.selectByVisibleText("Dispatch Status");
		getEleArrowRightBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		
		getEleSaveCloseBtn().click();
		Thread.sleep(GenericLib.iMedSleep);
		Assert.assertTrue(getEleViewTxt(sViewTxt).isDisplayed(),"Failed to create dispatch view rule for Work Order Object.");
		NXGReports.addStep("Dispatch console view "+ sViewTxt+" was created successfully.", LogAs.PASSED,null);	
	}

}
