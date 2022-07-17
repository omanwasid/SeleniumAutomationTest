import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionMultipleKeys {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://text-compare.com");
        driver.findElement(By.xpath("/html/body/div[8]/div/div/div/p[2]/span/button[2]")).click();
        driver.manage().window().maximize();

        WebElement input1 =driver.findElement(By.xpath("/html/body/div[2]/form/div/textarea[1]"));
        WebElement input2 =driver.findElement(By.xpath("/html/body/div[2]/form/div/textarea[2]"));

        input1.sendKeys("Welcome to UI Automation with Selenium");

        Actions act=new Actions(driver);

        //CTRL+A
        act.keyDown(Keys.CONTROL);
        act.sendKeys("a");
        act.keyUp(Keys.CONTROL);
        act.perform();

        //CTRL+C
        act.keyDown(Keys.CONTROL);
        act.sendKeys("c");
        act.keyUp(Keys.CONTROL);
        act.perform();

        //TAB- Shift to the input2
        act.sendKeys(Keys.TAB);

        //CTRL+V
        act.keyDown(Keys.CONTROL);
        act.sendKeys("v");
        act.keyUp(Keys.CONTROL);
        act.perform();

        if (input1.getAttribute("value").equals(input2.getAttribute("value")))
            System.out.println("Text is copied");
        else
            System.out.println("Text is not copied");
    }
}
