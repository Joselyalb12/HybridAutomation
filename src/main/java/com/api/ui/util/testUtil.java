package com.api.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.ui.base.TestBase;

public class testUtil extends TestBase {

	public static long Page_load = 10;
	public static long Implicit_Wait = 10;
	
	public static String XL_SHEET_PATH ="C:\\Users\\Josel\\Desktop\\Automation Documents\\Automation.test1\\src\\main\\java\\com\\api\\ui\\testdata\\TestData.xlsx";
			
		static Workbook book;
		static Sheet sheet;
		static JavascriptExecutor js;
		//2 D arrays User Name Password for Example
		public static Object [] [] getTestData(String sheetName) {
			FileInputStream file = null; //No value scenarios, then the action will not be performed due to lack of data
			try {
				file = new FileInputStream(XL_SHEET_PATH);
				//To catch error on the File level
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {//To catch error on the Excel Level
				book= WorkbookFactory.create(file);
			}catch(InvalidFormatException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}//To go through the information inside the EXCEL: EX.
			sheet=book.getSheet(sheetName);
			//Creating an object and hold the object
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			//
			for(int i = 0; i< sheet.getLastRowNum(); i++) {
				for(int j = 0; j <sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return data;
		}//ScreenShot method 
		public static void takescreenshotat() throws IOException {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//Creating a File from the system and Saving the Image with time stamp.
			String currentDirect = System.getProperty("user.dir"); 
			FileUtils.copyFile(srcFile, new File(currentDirect + 
					"/screenshot/" + System.currentTimeMillis() + ".png"));
		}
		
		//JQuery(JavaScript) this is used when the developer uses Jquery this will get the Jquery to run the script
		//Capture everything that is happening during the execution of the script	
		/*
		 * */
			public static void runTimeInfo(String messageType, String message) throws InterruptedException {
				js = (JavascriptExecutor) driver;
				
		//Telling the script to go to the Website and run the jquery
		//Get the documents from the JQuery
		//Getting the API for the jquery form url
					
				js.executeScript("If (!window.JQuery){"
						+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript':"
						+ "jquery.src= 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js':"
						+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
				Thread.sleep(6000);
				
				js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
				

				//Recording the Header information from the URL link to record the Method & Status HTTPcode/Header information/URL
				//THE OVERALL Response of the page.
				//The Developers need
				js.executeScript("$('head').append('<link rel=\"stylesheet\" "
						+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
				Thread.sleep(6000);
				
						//We are getting the info by Using the GET form of the WebSite
						js.executeScript("$ growl ({ title: 'GET' , message: '/'});");
						
						//If else methods are used to separate and record the information form of error, information, warning//
						//We Always should segregate this so it is easier to read 
						if(messageType.equals("error")) {
							js.executeScript("$growl.error({ title: 'ERROR' message: '"+message+"'});");
							
						}else if (messageType.equals("info")) {
							js.executeScript("$growl.info({ title: 'Notice' message: '+your voice message will appear here+'});");
							
						}else if(messageType.equals("warning")) {
							js.executeScript("$growl.warning({ title: 'Warning!' message: '+message: Your warning Message will appear here+'});");
						}else
							System.out.println("Show NO Error Message");
						Thread.sleep(9000);
							
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	

