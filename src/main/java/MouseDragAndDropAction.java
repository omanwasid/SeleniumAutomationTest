import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MouseDragAndDropAction {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div/div[2]/div/div/div[1]/p/iframe")));
        //or xpath://iframe[@class='demo-frame lazyloaded']

       WebElement iteam1=driver.findElement(By.xpath("//li[1]"));
       WebElement iteam2=driver.findElement(By.xpath("/html/body/div[1]/ul/li[2]/img"));

       WebElement trash=driver.findElement(By.xpath("/html/body/div[1]/div"));

       Actions act=new Actions(driver);
       //act.dragAndDropBy(iteam1,trash,135,40).perform();
       //act.dragAndDropBy(iteam2, trash).perform();
    }

}
