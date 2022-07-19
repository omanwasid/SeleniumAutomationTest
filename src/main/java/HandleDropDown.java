import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.opencart.com/index.php?route=account/register");
        driver.manage().window().maximize();

        WebElement drpCountryElm=driver.findElement(By.id("input-country"));
        Select drpCountry = new Select(drpCountryElm);
        //drpCountry.selectByVisibleText("Ireland");
        //  3 methods are available: selectByVisibleText// selectByValue and selectByIndex

        //drpCountry.selectByValue("8"); // It displayed Anterctica

        //Selecting Options from drop-down without methods

        List<WebElement> alloptions=drpCountry.getOptions();

        for (WebElement option:alloptions)
        {
            if (option.getText().equals("Bangladesh"))
            {
            option.click();
            break;
            }
        }


    }
}
