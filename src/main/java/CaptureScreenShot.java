import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.nopcommerce.com/en");
        driver.manage().window().maximize();
        /*
        //Full page screen-shot
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\screenshots\\homepage.png");
        FileUtils.copyFile(src,trg);
        driver.close();

        */

        // Screen-shot of partial/portion of the page
        WebElement section=driver.findElement(By.xpath("/html/body/div[7]/header/nav/div[2]/a/img"));
        File src=section.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\screenshots\\Logo.png");
        FileUtils.copyFile(src,trg);


    }
}
