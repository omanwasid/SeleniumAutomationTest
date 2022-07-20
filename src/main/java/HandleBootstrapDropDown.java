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

        List<WebElement> ProductTypes= (List<WebElement>) driver.findElement(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li")).click();
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


