package Package1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;



public class class2 
{
	public static void main(String[] args) throws InterruptedException, IOException, AWTException 
	{
		
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(co);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.bhliquors.com");
		driver.findElement(By.xpath("//a[@class='button valid-age']")).click();
		Thread.sleep(2000);
		
		List<WebElement> alllinks=driver.findElements(By.tagName("a"));
		
		System.out.println("size -"+alllinks.size());
		
		int emptyurlcount=0;
		int brokenurlcount=0;
		int validurlcount=0;
		
		for(WebElement links:alllinks) 
		{
			
			String url=links.getAttribute("href");
			if( url==null) 
			{
				System.out.println(url+"-----This is empty url");
				emptyurlcount++;
				continue;
				
			}
			
			
			
			try 
			{
				URL urllinks=new URL(url);
				HttpsURLConnection huc=(HttpsURLConnection) urllinks.openConnection();
				huc.connect();
				
				if(huc.getResponseCode()>=400) 
				{
					System.out.println(huc.getResponseCode()+url+"-----This is broken link");
					brokenurlcount++;
					
				}
				else 
				{
					System.out.println(huc.getResponseCode()+url+"-----This is valid link");
					validurlcount++;
					
				}
				
				
				
			}
			catch(Exception e) 
			{
				
				
			}
			
			
		}
		
		System.out.println("empty url count- "+emptyurlcount);
		System.out.println("broken links count- "+brokenurlcount);
		System.out.println("valid links count- "+validurlcount);
		
		
		
		
		
	}
	
		
}
	

