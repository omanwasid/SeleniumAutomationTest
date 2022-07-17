import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class MouseDoubleClickAction {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[3]/div[2]/div[2]")).click();
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult");
        WebElement input1=driver.findElement(By.xpath("/html/body/input[1]"));
        input1.clear();
        input1.sendKeys("Welcome to Automation with Selenium");

        WebElement button=driver.findElement(By.xpath("/html/body/button"));

        Actions act=new Actions(driver);
        act.doubleClick(button).perform();//Double Click Action
    }
}

