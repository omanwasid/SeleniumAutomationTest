import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleBootstrapDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.hdfcbank.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[2]/div/a")).click();
         List<WebElement> ProductTypes = (List<WebElement>) driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[2]/div"));
        System.out.println("Number of Options:"+ProductTypes.size());

        for (WebElement pType:ProductTypes)
        {
            if (pType.getText().equals("Accounts"))
            {
            pType.click();
            break;
            }
            }
        }

    }


