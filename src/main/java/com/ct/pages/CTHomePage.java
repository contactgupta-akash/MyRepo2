package com.ct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CTHomePage {

private static By ONE_WAY_RB_LOC=By.xpath("//input[@id='OneWay']");
	
	WebDriver driver;

	public CTHomePage(WebDriver driver) {
		this.driver=driver; 
	}
	
	public void navigateToClearTrip(){
		driver.get("https://www.cleartrip.com/");
	}
	
	public void selectOneWay(){
		driver.findElement(ONE_WAY_RB_LOC).click();
	}
}
