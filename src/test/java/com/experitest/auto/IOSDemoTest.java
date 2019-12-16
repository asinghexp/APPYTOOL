package com.experitest.auto;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDemoTest extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception {
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		dc.setCapability("testName", "IOSDemoTest");
		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
	}

	@Test
	public void test() {
		// Enter the test code
		 driver.rotate(ScreenOrientation.PORTRAIT);
	        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
	        driver.hideKeyboard();
	        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
	        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
	        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
	        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
	        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
	        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
	        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
	        driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
	        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
	        driver.findElement(By.xpath("//*[@id='Yes']")).click();
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}

}
