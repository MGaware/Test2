package Package1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class Class1 
{
	
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		int sum=0;
		for(int a=1; a<=10; a++) 
		{
			sum=sum+a;
			
			
		}
		System.out.println("sum of 1 to 10 -"+ sum);
		
	}
	

		
}


