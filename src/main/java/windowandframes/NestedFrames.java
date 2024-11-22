package windowandframes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class NestedFrames {
public String baseUrl = "https://the-internet.herokuapp.com/nested_frames";
WebDriver driver = new ChromeDriver();

     public void luanchApp() {
	 driver.get(baseUrl);
	 driver.manage().window().maximize();
     }
     
     public void verifyframe () {
    	 WebElement topframeElement = driver.findElement(By.xpath("//frame[@name='frame-top']"));//Top Frame
    	 driver.switchTo().frame(topframeElement);
    	 System.out.println("Switch to Top Frame .....");
    	 List<WebElement> noofFrames = driver.findElements(By.tagName("frame"));//All Frames 
    	 System.out.println("No of the Frames present in the Web page :"+noofFrames.size());//3
    	 WebElement leftframeElement = driver.findElement(By.xpath("//frame[@name='frame-left']"));//Left Frame 
    	 //driver.switchTo().defaultContent();
         System.out.println("The Text present in the left frame :" +leftframeElement.getText());//Text from the left frame
    	// driver.switchTo().frame(topframeElement);//top frame
    	 WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
    	 driver.switchTo().frame("frame-middle");
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	 String text=driver.findElement(By.id("content")).getText();//Text from the middle frame
    	 System.out.println("The Text present in the Middle Frame is : "+text);
    	 driver.switchTo().defaultContent();
    	 driver.switchTo().frame(topframeElement);
    	 System.out.println("Switch to Top Frame .....");
    	 WebElement rightFrame = driver.findElement(By.name("frame-right"));
    	 System.out.println("Switch to the Right Frame ....");
    	 driver.switchTo().defaultContent();
    	 driver.switchTo().frame(topframeElement);
    	 System.out.println("Switch to Top Frame .....");
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	 WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
    	 System.out.println("Switch to the Bottom Frame....");
    	 driver.switchTo().frame(topframeElement);
    	 System.out.println("Switch to Top Frame .....");
    	 

     }
     public static void main(String[] args) {
		 NestedFrames nestedframe = new NestedFrames();
		 nestedframe.luanchApp();
		 nestedframe.verifyframe();
		
	}

}
