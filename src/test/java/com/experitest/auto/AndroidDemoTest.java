package com.experitest.auto;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AndroidDemoTest extends BaseTest {
	protected AndroidDriver<AndroidElement> driver = null;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		dc.setCapability("appVersion", "1.2374");
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
	}
	
	@Test
	public void test(){
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
	        driver.findElement(By.xpath("//*[@text='Switzerland']")).click();
	        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
	        driver.findElement(By.xpath("//*[@text='Yes']")).click();
	}
	
	@AfterMethod
	public void tearDown(){
		System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}
	
}
