package org.ge.dclibrary;


import java.util.concurrent.TimeUnit;
import org.ge.pageobjects.DC_SalesforcePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.kirwa.nxgreport.NXGReports;

public class BaseLib {
	{
		System.setProperty("KIRWA.reporter.config",	GenericLib.sResources+"\\KIRWA.properties");

	}
	public WebDriver driver = null;
	public DC_SalesforcePage dc_salesforPage = null;
	Actions act = null;
	Alert alert = null;
	DesiredCapabilities capabilities = null;
	@BeforeTest
	public void browserLaunch() {
		try {
			if (GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", GenericLib.sChromedriverPath);
				System.out.println("Chrome is set");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("user-data-dir="+GenericLib.sChromeProfile);
				options.addArguments("--start-maximized");
				System.out.println("Chrome is set with flash enabled");
				driver= new ChromeDriver(options);
			} else if (GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("firefox")) {	
				System.out.println("Firefox is set");
				System.setProperty("webdriver.gecko.driver", GenericLib.sGeckoPath);
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("plugin.state.flash", 2);
				System.out.println("Firefox is set with flash enabled");
				driver = new FirefoxDriver(options);
				
			}  else {
				System.out.println("Failed to launch the browser");
			}
			NXGReports.setWebDriver(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "URL"));
		} catch (Exception e) {
			System.out.println("Problem in launching browser");
			e.printStackTrace();
		}
		

	}

	public void loadURL(String sURL) throws InterruptedException {
		try {

			driver.get(sURL);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(5000);
		} catch (AssertionError e) {
			throw e;
		}
	}

}
