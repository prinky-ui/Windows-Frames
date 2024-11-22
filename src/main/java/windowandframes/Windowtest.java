package windowandframes;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowtest {
	public String baseUrl = "https://the-internet.herokuapp.com/windows";
	WebDriver driver = new ChromeDriver();
	String parentwindow;
	String secondwindow;
	
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
	}
	
	public void clickhere () {
	 driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	 //parentwindow = driver.getWindowHandle();
	 //System.out.println("From get window handel method "+parentwindow);
	 secondwindow = driver.getWindowHandle();
	 driver.switchTo().window(secondwindow);
	 secondwindow = driver.getCurrentUrl();
	
		System.out.println("Second Window Get handle method  is " +secondwindow);
		
		System.out.println("The title of the page is "+ secondwindow);
		
		//String text = driver.findElement(By.className("example")).getText();
		//System.out.println("The verify text on the page is" +text );
		
	}
	public static void main(String[] args) {
		Windowtest windowtest = new Windowtest ();
		windowtest.launchApp();
		windowtest.clickhere();
		

	}

}
