import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class MouseOverAction {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/");

        driver.manage().window().maximize();

        WebElement desktopManu=driver.findElement(By.xpath("/html/body/main/div[1]/nav/div[2]/ul/li[1]/a"));
        WebElement PcManuIteam=driver.findElement(By.xpath("/html/body/main/div[1]/nav/div[2]/ul/li[1]/div/div/ul/li[1]/a"));

        Actions act=new Actions(driver);
        act.moveToElement(desktopManu).moveToElement(PcManuIteam).click().perform();
    }
}
