package com.ct.bookflight;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ct.pages.CTHomePage;
import com.ct.test.base.Driver;

public class SearchFlightTest extends Driver {
	
  private CTHomePage cthomepage;	
 
  @Test
  public void searchFlightTest() {
	  driver=new FirefoxDriver();
	  cthomepage =new CTHomePage(driver);
	
	  cthomepage.navigateToClearTrip();
	  cthomepage.selectOneWay();
	  //implement Implicit wait..
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("New");
	  
	  List<WebElement> lst=driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
	  System.out.println("total destination is "+lst.size());
	  for(int i=1;i<=lst.size();i++){
		if(driver.findElement(By.xpath("//ul[@id='ui-id-1']//li["+i+"]/a")).getText().contains("Newark")){
			System.out.println(driver.findElement(By.xpath("//ul[@id='ui-id-1']//li["+i+"]/a")).getText());
			driver.findElement(By.xpath("//ul[@id='ui-id-1']//li["+i+"]/a")).click();
			break;
		}
	  }
	  
	  driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("bangalore");
	  driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys(Keys.ARROW_DOWN);
	  driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys(Keys.ENTER);
	  //select future date in calendar
	  driver.findElement(By.xpath("//a[text()='13']")).click();
	  //click search flights
	  driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
	  String parentWindowID=driver.getWindowHandle();
	  //click 'know more' link for the first flight
	  driver.findElement(By.xpath(".//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li[1]/table/tbody[1]/tr/td/a")).click();
	  //switch to child window-
	  Set<String> wid= driver.getWindowHandles();
	  for(String winID :wid){
		  if(!parentWindowID.equals(winID)){
			  driver.switchTo().window(winID);
			  System.out.println("switched window title is"+driver.getTitle());
			  break;
		  }
	  }
	  Assert.assertTrue(driver.getCurrentUrl().contains("special-offer"), "window not switched!!");
	  driver.quit();
  }
}
