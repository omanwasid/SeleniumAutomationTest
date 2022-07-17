import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class AutoSuggestDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("sb_form_q")).sendKeys("Selenium download");
        List<WebElement>list=driver.findElements(By.xpath("//*[@id=\"sa_5010\"]/div[2]/span/strong"));
        //Thread.sleep(1000);

        System.out.println("Size of Auto Suggestions length:"+list.size());
        //Problem with size of length output and not directed with selected item.
        for (WebElement listitem:list)
        {
            if(listitem.getText().contains("download"))
            {
                listitem.click();
                break;
            }

        }

    }
}
