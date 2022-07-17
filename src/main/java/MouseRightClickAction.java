import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseRightClickAction {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.nopcommerce.com/en");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.xpath("/html/body/div[7]/section/div/div/div/div/div/div/div[1]/div/div[1]/div/a[1]"));

        Actions act = new Actions(driver);
        act.contextClick(button).perform();//Right Click Action
    }
}
