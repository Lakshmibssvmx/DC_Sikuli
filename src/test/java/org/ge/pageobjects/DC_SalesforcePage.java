package org.ge.pageobjects;

import java.util.Iterator;
import java.util.Set;
import org.ge.dclibrary.GenericLib;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

public class DC_SalesforcePage 
{
	WebDriver driver = null;
	public static String sParentWnd = null;
	public static String sDCWnd = null;
	public DC_SalesforcePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	private WebElement eleUsernameTxtFld;
	public WebElement getEleUsernameTxtFld() 
	{
		return eleUsernameTxtFld;
	}
	@FindBy(id="password")
	private WebElement elePasswordTxtFld;
	public WebElement getElePasswordTxtFld() 
	{
		return elePasswordTxtFld;
	}
	@FindBy(id="Login")
	private WebElement eleLoginBtn;
	public WebElement getEleLoginBtn() 
	{
		return eleLoginBtn;
	}
	
	@FindBy(id="home_Tab")
	private WebElement eleHomeTab;
	public WebElement getEleHomeTab() 
	{
		return eleHomeTab;
	}
	
	@FindBy(xpath="//div[@class='sidebarModuleBody']//a[text()='Dispatch Console']")
	private WebElement eleDispatchConsoleLnk;
	public WebElement getEleDispatchConsoleLnk() 
	{
		return eleDispatchConsoleLnk;
	}
	@FindBy(xpath="//a[@href='/_ui/core/userprofile/UserProfilePage']")
	private WebElement eleProfileLnk;
	public WebElement getEleProfileLnk() 
	{
		return eleProfileLnk;
	}
	@FindBy(xpath="//h2[text()='Recent Items']")
	private WebElement eleRecentItemsTxt;
	public WebElement getEleRecentItemsTxt() 
	{
		return eleRecentItemsTxt;
	}

	private WebElement eleTeamTxt;
	public WebElement getEleTeamTxt(String sTeam) 
	{
		eleTeamTxt=driver.findElement(By.xpath("//h2[text()=' "+ sTeam+"']"));
		return eleTeamTxt;
	}
	private WebElement eleTechTxt;
	public WebElement getEleTechTxt(String sTech) 
	{
		eleTechTxt=driver.findElement(By.xpath("//h2[text()=' "+ sTech+"']"));
		return eleTechTxt;
	}
	
	@FindBy(xpath="//td/span[text()='Latitude']/../..//td[@class='dataCol inlineEditWrite']/div")
	private WebElement eleLatitudeTxt;
	
	public WebElement getEleLatitudeTxt() 
	{
		return eleLatitudeTxt;
	}
	@FindBy(xpath="//td/span[text()='Longitude']/../..//td[@class='dataCol inlineEditWrite']/div")
	private WebElement eleLongitudeTxt;
	public WebElement getEleLongitudeTxt() 
	{
		return eleLongitudeTxt;
	}
	
	@FindBy(xpath="//td/span[text()='Home Longitude']/../..//td[@class='dataCol inlineEditWrite']/div")
	private WebElement eleHomeLongitudeTxt;
	public WebElement getEleHomeLongitudeTxt() 
	{
		return eleHomeLongitudeTxt;
	}
	
	@FindBy(xpath="//td/span[text()='Home Latitude']/../..//td[@class='dataCol inlineEditWrite']/div")
	private WebElement eleHomeLatitudeTxt;
	public WebElement getEleHomeLatitudeTxt() 
	{
		return eleHomeLatitudeTxt;
	}
	
	@FindBy(xpath="//input[@title=' Validate Address']")
	private WebElement eleValidateAddressBtn;
	public WebElement getEleValidateAddressBtn() 
	{
		return eleValidateAddressBtn;
	}
	
	@FindBy(css="iframe[title='Service_Group_Wizard']")
	private WebElement eleServiceWizardTeamFrm;
	public WebElement getEleServiceWizardTeamFrm() 
	{
		return eleServiceWizardTeamFrm;
	}
	
	@FindBy(css="iframe[title='Service_Group_Member_Wizard']")
	private WebElement eleServiceWizardTechFrm;
	public WebElement getEleServiceWizardTechFrm() 
	{
		return eleServiceWizardTechFrm;
	}
	public void login(String sUser, String sPwd) throws InterruptedException
	{
		System.out.println("login");
		try {
			
			Assert.assertTrue(getEleUsernameTxtFld().isDisplayed(), "Salesforce login page is not displayed");
			getEleUsernameTxtFld().sendKeys(sUser);
			getElePasswordTxtFld().sendKeys(sPwd);
			getEleLoginBtn().click();
			Thread.sleep(5000);
			handleLightningAlert();
			Assert.assertTrue(getEleHomeTab().isDisplayed(), "Failed to login");
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	
	public void navigatehome() throws InterruptedException
	{
		getEleHomeTab().click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		handleLightningAlert();
		Assert.assertTrue(getEleRecentItemsTxt().isDisplayed(), "Failed to navigate to home page");
	}
	
	public void handleLightningAlert()
	{
		try {
			driver.findElement(By.id("tryLexDialogX")).click();
		}catch(Exception e) {
			
		}
		
	}
	public void naviagateDC() throws InterruptedException
	{	getEleDispatchConsoleLnk().click();
		Thread.sleep(GenericLib.iMedSleep);
		windowHandle();
		driver.switchTo().window(sDCWnd);
		driver.manage().window().maximize();
		Thread.sleep(GenericLib.iVHighSleep);
	}
	
	public void windowHandle()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator=windowHandles.iterator();
		while(iterator.hasNext())
		{
			sParentWnd = iterator.next();
			sDCWnd = iterator.next();
		}
		System.out.println(sParentWnd);
		System.out.println(sDCWnd);
	}
	public void validateTech(String sTech) throws InterruptedException
	{
		
		Assert.assertTrue(getEleTechTxt(sTech).isDisplayed(), "Technician page is not displayed");
		NXGReports.addStep("Created Technician page is successfully displayed", LogAs.PASSED,null);
		driver.switchTo().frame(getEleServiceWizardTechFrm());
		getEleValidateAddressBtn().click();
		Thread.sleep(GenericLib.iHighSleep);
		driver.switchTo().defaultContent();
		Assert.assertTrue(getEleHomeLatitudeTxt().isDisplayed(), "Failed to validate address of technician.");
		Assert.assertTrue(getEleHomeLongitudeTxt().isDisplayed(), "Failed to validate address of techncian.");
		NXGReports.addStep("Address of the tech is successfully validated", LogAs.PASSED,null);
		
	}
	public void validateTeam(String sTeam) throws InterruptedException
	{
		
		Assert.assertTrue(getEleTeamTxt(sTeam).isDisplayed(), "Team page is not displayed");
		NXGReports.addStep("Created Team page is successfully displayed", LogAs.PASSED,null);
		driver.switchTo().frame(getEleServiceWizardTeamFrm());
		getEleValidateAddressBtn().click();
		Thread.sleep(GenericLib.iHighSleep);
		driver.switchTo().defaultContent();	
		Assert.assertTrue(getEleLatitudeTxt().isDisplayed(), "Failed to validate address of team.");
		Assert.assertTrue(getEleLongitudeTxt().isDisplayed(), "Failed to validate address of team.");
		NXGReports.addStep("Address of the team is successfully validated", LogAs.PASSED,null);
		
	}
}
