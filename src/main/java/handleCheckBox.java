import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class handleCheckBox {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        // Select Specific Check box.
        driver.findElement(By.xpath("//input[@id='female']")).click();
        driver.findElement(By.xpath("//input[@id='monday']")).click();
        driver.findElement(By.xpath("//input[@id='tuesday']")).click();
        driver.findElement(By.xpath("//input[@id='wednesday']")).click();
        driver.findElement(By.xpath("//input[@id='thursday']")).click();
        driver.findElement(By.xpath("//input[@id='friday']")).click();
        driver.findElement(By.xpath("//input[@id='saturday']")).click();
        driver.findElement(By.xpath("//input[@id='sunday']")).click();
        // Select All Check boxes.
        //driver.findElement(By.xpath("//input[@id='monday']")).click();
        List<WebElement> checkboxes= (List<WebElement>) driver.findElement(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        System.out.println("Total Number of Check Boxes:"+ checkboxes.size());
        for(int i=0;i<=checkboxes.size();i++)
        {
            checkboxes.get(i).click();
        }
         /*for(WebElement chbox:checkboxes)
        {
            chbox.click();
        }*/
    }
}




