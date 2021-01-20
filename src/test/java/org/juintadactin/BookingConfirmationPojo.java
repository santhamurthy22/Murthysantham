package org.juintadactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationPojo extends Base{

	public BookingConfirmationPojo() {
	PageFactory.initElements(driver, this);
		}
	
	@FindBy(id="order_no")
    private WebElement orderNo;

	public WebElement getOrderNo() {
		return orderNo;
	}
	}

	
	
	
	

