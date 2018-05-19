package org.jsystemtest.web_tests;

import static org.junit.Assert.*;
import org.jsystem.webdriver_so.WebDriverSystemObject;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestWebGoogle extends SystemTestCase4  {

	private String url, pageTitle, chuoitim;
  	protected WebDriver webDriver;
    protected WebDriverSystemObject seleniumSystemObject;
    private String diachi;
    
    
    @SuppressWarnings("deprecation")
   	@Before
       	public void setUp() throws Exception {
    	
   	
    	
   		seleniumSystemObject = (WebDriverSystemObject) system.getSystemObject("webDriverSystemObject");
           webDriver = seleniumSystemObject.getDriver();
           //Get value from SUT file
           diachi = sut.getValue("/sut/webDriverSystemObject/address/text()");
           report.report("DIA CHI DIA CHI: "+diachi);
   	}
    @After
	public void tearDown() {
        //seleniumSystemObject.close();
	}
    
	@Test
	//test properties only don't related to Data driven
	@TestProperties(name = "URL of web test:  '${chuoitim}'", paramsInclude = { "chuoitim" })
	public void searchCheese() {
		
		// Data driven example (need to put parameter ${chuoitim} at GUI)

		report.report("dia chi: " + diachi);
		report.report("chuoi can tim: " + getChuoitim());
		
		//maximize windows for IE and Firfox
		//webDriver.manage().window().maximize();
		//Open Browser with address
        //webDriver.get(url);    
		webDriver.get(diachi);
		//webDriver.get("https://www.google.com/");
	    sleep(500);
		
        // Find the text input element by its name
    	WebElement element = webDriver.findElement(By.name("q"));	
    	
        // Enter something to search for
        //element.sendKeys("Cheese!");	
    	//Get from Datadriven
        element.sendKeys(getChuoitim());
        
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        sleep(500);
        
		// Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
 //      (new WebDriverWait(webDriver, 100)).until(new ExpectedCondition<Boolean>() {
  //        public Boolean apply(WebDriver d) {
   //            return d.getTitle().toLowerCase().startsWith("cheese!");
   //        }
   //    });

        // Check the title of the page
        pageTitle = webDriver.getTitle();
        report.report("Name of page: "+ pageTitle);
        System.out.println("Page title is: " + webDriver.getTitle());		

	}
	
	public String getChuoitim() {
		return chuoitim;
	}

	public void setChuoitim(String chuoitim) {
		this.chuoitim = chuoitim;
	}
	
	public String getUrl() {
		return url;
	}

	@ParameterProperties(description = "URL of test web site")
	public void setUrl(String url) {
		this.url = url;
	}
	

}
