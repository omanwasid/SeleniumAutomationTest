import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleBootstrapDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        driver.findElement(By.xpath("//div[@class='btn-group']//button//span")).click();

        List<WebElement> list = (List<WebElement>) driver.findElement(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));


        System.out.println(list.size());

        for (int i =0; i<list.size(); i++)
        {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("Angular")){
                list.get(i).click();
                break;
            }
            }

        }

    }
    // Not shown the size of the list and for loop not working


