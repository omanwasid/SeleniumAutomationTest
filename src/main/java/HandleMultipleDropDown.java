import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleMultipleDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial-old/");
        driver.manage().window().maximize();


        Select NoOfEmployees =new Select(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/fieldset/div[7]/div/select")));
        NoOfEmployees.selectByVisibleText("21 - 25");

        Select IndustryDrp =new Select(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/fieldset/div[9]/div/select")));
        IndustryDrp.selectByVisibleText("Agriculture / Forestry");

        Select CountryDrp =new Select(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/fieldset/div[11]/div/select")));
        CountryDrp.selectByVisibleText("Bangladesh");




    }
}
