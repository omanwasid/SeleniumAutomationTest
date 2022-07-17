import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile {
    public static void main(String[]args) throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://monsterindia.com/");
        driver.manage().window().maximize();

        /* SendKeys() method only is applicable if,(type=file) defined in the html page */
        driver.findElement(By.xpath("/html/body/div[3]/section[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/a[2]/span[2]")).click();

        //Using SendKeys() method
        //driver.findElement(By.xpath("/html/body/div[3]/section[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/section/div/form/div[1]/div[1]/div/div/input[1]")).sendKeys("C:\\Users\\45422\\Desktop\\Wasid_CV.docx");

        //Using Robot Class Methods
        WebElement button=driver.findElement(By.xpath("/html/body/div[3]/section[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/section/div/form/div[1]/div[1]/div/div/input[1]"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",button);

        /*

        1)Copy the path
        2)Ctrl+V
        3)Enter

        */
        Robot rb=new Robot();
        rb.delay(2000);

        //put path to file in a clipboard
        StringSelection ss=new StringSelection("C:\\Users\\45422\\Desktop\\Wasid_CV.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        //CTRL+V
        rb.keyPress(KeyEvent.VK_CONTROL);// Press On CTRL Key
        rb.keyPress(KeyEvent.VK_V);//Press On CTRL Key
        rb.delay(2000);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(2000);

        //ENTER
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);



    }

}
