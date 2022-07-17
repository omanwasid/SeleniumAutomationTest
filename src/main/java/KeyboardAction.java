import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class KeyboardAction {
        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.get("https://the-internet.herokuapp.com/key_presses");
            driver.manage().window().maximize();

            Actions act=new Actions(driver);

            act.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);

            act.sendKeys(Keys.SEPARATOR).perform();
            Thread.sleep(2000);

            act.sendKeys(Keys.BACK_SPACE).perform();
            Thread.sleep(2000);

            act.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(2000);

            act.sendKeys(Keys.TAB).perform();
            Thread.sleep(2000);

            act.sendKeys(Keys.LEFT_SHIFT).perform();
            Thread.sleep(2000);
        }
}
