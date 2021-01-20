package org.juintadactin;
import java.io.IOException;

import org.juintadactin.BookAHotelPojo;
import org.juintadactin.LoginPojo;
import org.juintadactin.SearchHotelPojo;
import org.juintadactin.SelectHotelPojo;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Runner extends Base{
//	@BeforeClass
//	public void lanuchBrowser() {
//		System.out.println("start browser");
//	}
//	@AfterClass
//	public void closeBrowse(){
//		System.out.println("close browser");
//	}
	@Test
	public void tc1() throws IOException, InterruptedException {

		lanuchBrowser();
		
		lanuchUrl("https://adactinhotelapp.com/SearchHotel.php");
		
		maxWindow();
		                                            LoginPojo l = new LoginPojo();
		                                            js.executeScript("arguments[0].click",l.getUsername());
		searchFill(l.getUsername(),excelRead(0, 0));
		searchFill(l.getPassword(), excelRead(0, 1));
		btnClick(l.getLogin());

		                                           SearchHotelPojo s = new SearchHotelPojo();
		WebElement location = s.getLocation();
		txtSelect(location, "Sydney");
		WebElement hotels = s.getHotels();
		txtSelect(hotels, "Hotel Creek");
		WebElement roomtype = s.getRoom_type();;
		txtSelect(roomtype, "Standard");
		WebElement roomnos = s.getRoom_nos();
		txtSelect(roomnos, "1 - One");
		searchFill(s.getDatepick_in(), excelRead(0, 2));
		searchFill(s.getDatepick_in(), excelRead(0, 3));
		WebElement adultroom = s.getAdult_room();
		txtSelect(adultroom, "2 - Two");
		WebElement childroom = s.getChild_room();
		txtSelect(childroom, "2 - Two");
		btnClick(s.getSubmit());

		                                         SelectHotelPojo sh = new SelectHotelPojo();
		btnClick(sh.getRadiobutton());
		btnClick(sh.getConti());

		                                         BookAHotelPojo bj  =  new BookAHotelPojo();
		searchFill(bj.getFirst_name(),excelRead(0, 4));
		searchFill(bj.getLast_name(),excelRead(0, 5));
		searchFill(bj.getAddress(), excelRead(0, 6));
		searchFill(bj.getCc_num(), excelRead(0, 7));
		searchFill(bj.getCc_cvv(), excelRead(0, 8));
		WebElement cardtype = bj.getCc_type();
		txtSelect(cardtype, "VISA");
		WebElement selectmonth = bj.getCc_exp_month();
		txtSelect(selectmonth, "May");
		WebElement selectyear = bj.getCc_exp_year();
		txtSelect(selectyear, "2018");
	    btnClick(bj.getBook_now());
	    Thread.sleep(5000);
		
	                                                    BookingConfirmationPojo bc = new BookingConfirmationPojo();
	              String attribute = bc.getOrderNo().getAttribute("value");
	                      excelWrite(0,9,attribute);
	                      }
}
