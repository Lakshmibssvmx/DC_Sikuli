package org.ge.dclibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericLib 
{
	public static String sDirPath = System.getProperty("user.dir");
	public static String sResources = sDirPath+"\\resources";
	public static String sGeckoPath = sResources+"\\driver\\geckodriver.exe";
	public static String sChromedriverPath = sResources+"\\driver\\chromedriver.exe";
	public static String sIEDriverPath = sResources+"\\driver\\IEDriverServer.exe";
	public static String sMicroSoftEdgePath = sResources+"\\driver\\MicrosoftWebDriver.exe";
	public static String sDcGanttImg = sResources+"\\images\\dcgantt";
	public static String sDcGridImg = sResources+"\\images\\dcgrid";
	public static String sConfigFile =  sResources+"\\dc_config.properties";
	public static String sTestDataFile = sResources + "\\TestData.xlsx";
	//public static String sChromeProfile = "C://Users//212672444//AppData//Local//Google//Chrome//User Data//DC_Profile";
	public static String sChromeProfile =sResources+"\\DC_ChromeProfile";
	
	public static int iVHighSleep = 45000;
	public static int iHighSleep = 10000;
	public static int iMedSleep = 8000;
	public static int iLowSleep = 4000;
	
	/*
	 * @author: LAKSHMI BS Description: To read the basic environment settings from dc_config.properties
	 * data from config file
	 */
	public static String getCongigValue(String sFile, String sKey) {
		Properties prop = new Properties();
		String sValue = null;
		try {
			InputStream input = new FileInputStream(sFile);
			prop.load(input);
			sValue = prop.getProperty(sKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sValue;
	}

	/*
	 * @author: LAKSHMI BS Description: To set the settings data in dc_config.properties
	 * data from config file
	 */
	public static void setCongigValue(String sFile, String sKey, String sValue) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(sFile));
			prop.load(fis);
			fis.close();

			FileOutputStream fos = new FileOutputStream(new File(sFile));
			prop.setProperty(sKey, sValue);
			prop.store(fos, "Updating folder path");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/*
	 * @author: LAKSHMI BS Description: To read test data from excel sheet
	 */
	public static String getExcelData(String sTestCaseID, String sKey) {
		String sData = null;
		try {

			FileInputStream fis = new FileInputStream(sTestDataFile);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet("TestData");
			int iRowNum = sht.getLastRowNum();
			int k = 0;
			for (int i = 1; i <= iRowNum; i++) {
				if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
					int iCellNum = sht.getRow(i).getLastCellNum();
					
					for(int j=0;j<iCellNum;j++)
					{
						if(sht.getRow(i).getCell(j).getStringCellValue().equals(sKey))
							{sData = sht.getRow(i+1).getCell(j).getStringCellValue();}
							
					}
					
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sData;
	}
	
	public static void main(String[] args) 
	{String value=null;
	value=	getExcelData("RS_3807", "Country");
	System.out.println(value);
	}
	
}
