package org.juintadactin;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static WebDriverWait w;
	public static Actions ac;
	public static Robot r;
	public static Select s;
	
	public static void lanuchBrowser() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		}
	public static void closeBrowser() {
		driver.quit();
		}
	public static void lanuchUrl(String Url) {
		driver.get(Url);
	}
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	public static void searchFill(WebElement element, String text) {
		element.sendKeys(text);
	}		
	public static void btnClick(WebElement element) {
		element.click();
	}
	public static void txtSelect(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	public static void javaClick(String s,WebElement element) {
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click",element);
			}	
	public static String excelRead(int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\santh\\eclipse-workspace\\JuintAdactin\\Excel\\Santhamurthy.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Santhamurthy");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
        int cellType = c.getCellType();
		String value = "";
        if (cellType == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			value = sd.format(d);
		} else {
			double dd = c.getNumericCellValue(); // type casting//
			long l = (long) dd; // type casting//
			value = String.valueOf(l);
			}
		return value;
	}
	public static void excelWrite(int rowNo, int cellNo, String text) throws IOException {
		File f = new File("C:\\Users\\santh\\eclipse-workspace\\JuintAdactin\\Excel\\Santhamurthy.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Santhamurthy");
		Row r = s.getRow(rowNo);
		Cell c = r.createCell(cellNo);
		c.setCellValue(text);
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
	}
	public static void excelUpdate(int rowNo,int cellNo, String text) throws IOException {
		File f = new File("C:\\Users\\santh\\eclipse-workspace\\MavenSanth\\Excel\\SampleData.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Input");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		c.setCellValue(text);
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
	}
}