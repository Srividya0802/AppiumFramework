package framework.Appium;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
	public class Demos extends Capability
	{
		
		AndroidDriver<AndroidElement> driver;
		
		@BeforeTest
		public void bt() throws IOException, InterruptedException{
			//driver = capabilities(appPackage,appActivity,deviceName,platformName,chromeExecutable);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Thread.sleep(5000);
	}
	
		@Test(enabled=false)
		public void testcase1()
		{
			//i want to select the radio button which is female
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			//i want to enter the name
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sprint");
			String name = driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).getAttribute("text");
			//i want to select the dropdown
			driver.findElement(By.id("android:id/text1")).click();
			//now i want to scroll
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			Assert.assertEquals("Sprint", name);
		}
		
		@Test(enabled = false)
		public void testcase2() {
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			driver.findElement(By.id("android:id/text1")).click();
			//now i want to scroll
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			String errMsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
			//System.out.println(driver.findElement(By.xpath("//*[@text='Please enter your name']")).getAttribute("name"));
			String exp = "Please enter your name";
			Assert.assertEquals(errMsg, exp);
		}
		
		@Test(enabled=false)
		public void testcase3()
		{
			//i want to select the radio button which is female
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			//hide the keyboard
			driver.hideKeyboard();
			//i want to enter the name
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("kansas");
			//i want to fetch the name and store in variable
			String Name = driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).getAttribute("text");
			//i want to select the dropdown
			driver.findElement(By.id("android:id/text1")).click();
			//now i want to scroll
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
			//click on lets shop
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			//asserting the name
			String expected = "kansas";
			Assert.assertEquals(Name, expected);
			////i want to scroll till a element and click on the add to cart button ;finding the total number of items on page
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))");
			//int links  = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
			//System.out.println(links);
			//driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\").instance(0)).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
			int links  = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
			for(int i=0;i<links;i++)
			{
				String name =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
				if(name.equalsIgnoreCase("Air Jordan 9 Retro"))
						{
					         driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
					         break;
						}
							}
			    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			   	String cartproduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
				String product = "Air Jordan 9 Retro";
				Assert.assertEquals(product , cartproduct);
				
		}
		
		@Test()
		public void testcase4() throws InterruptedException, IOException
		{
			service=startServer();
			driver = capabilities(appPackage,appActivity,deviceName,platformName,chromeExecutable);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//i want to select the radio button which is female
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			//i want to enter the name
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sprint");
			String name = driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).getAttribute("text");
			//i want to select the dropdown
			driver.findElement(By.id("android:id/text1")).click();
			//now i want to scroll
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"))").click();
						driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			// i want to click on add to cart of first two elements without scroll; below line wil click on first add to cart
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			//i want to click on second add to cart button; here we gave get(0) since after first add to cart is selcted it becomes added to cart hence the index of second becomes 0 only
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			//click on add to cart button
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			//Get the price of the selected items
			Thread.sleep(3000);
			String amt1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
			String amt2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
			System.out.println(amt1);
			System.out.println(amt2);
			amt1=amt1.substring(1);
			amt2=amt2.substring(1);
			Double amt1value = Double.parseDouble(amt1);
			Double amt2value = Double.parseDouble(amt2);
			Double TotalVal = amt1value + amt2value;
			String Tot= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
			Tot = Tot.substring(1);
			Double FinalTotVal = Double.parseDouble(Tot);
			Assert.assertEquals(FinalTotVal, TotalVal);
			
			WebElement tapele=	driver.findElementByAndroidUIAutomator("text(\"Send me e-mails on discounts related to selected products in future\")");
			TouchAction t = new TouchAction(driver);
			t.tap(tapOptions().withElement(element(tapele))).perform();
			
			WebElement elem2 = driver.findElementByAndroidUIAutomator("text(\"Please read our terms of conditions\")");
			t.longPress(longPressOptions().withElement(element(elem2)).withDuration(ofSeconds(3))).release().perform();
			driver.findElement(By.id("android:id/button1")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
			Thread.sleep(7000);
			
			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
			    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
			}
			driver.context("WEBVIEW_com.androidsample.generalstore");
			Thread.sleep(3000);		
			  driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
			    driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.context("NATIVE_APP");
			service.stop();
		}
		
		
		}
		