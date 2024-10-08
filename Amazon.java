import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		WebDriver d = null;
//		System.setProperty("webdriver.edge.driver","C:\\Program Files\\msedgedriver.exe");
		d=new ChromeDriver();
		
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		d.manage().window().maximize();
		Scanner sc = new Scanner(System.in);
		d.get("https://www.amazon.in/");
		Select s = new Select(d.findElement(By.xpath("//*[@id='searchDropdownBox']")));
		s.selectByVisibleText("Electronics");
		String text= "Mobile_phones";
		d.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(text);
		d.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		for(int i=0;i<5;i++)
		{
			d.findElements(By.xpath("//h2[contains(@class,'a-size-mini')]/a")).get(i).click();
		}
			Set<String> abc=d.getWindowHandles();
			Iterator<String>it=abc.iterator();		

		while(it.hasNext()) 
		{
			d.switchTo().window(it.next());
			System.out.println(d.getTitle());
			d.close();
		}
		
	}

		
		
		
		
}
