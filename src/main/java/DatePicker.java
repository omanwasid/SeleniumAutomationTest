import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DatePicker {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.redbus.in/");

        driver.manage().window().maximize();

        String year = "2023";
        String month = "Aug";
        String date = "10";

        driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[3]/div/input")).click();
        // Opens the date picker

        while (true) {
            String monthyear = driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]")).getText();

            String arr[] = monthyear.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            if (mon.equals(month) && yr.equals(year))
                break;
            else
                driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")).click();
            //Date Selection

            List<WebElement> alldates = driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr/td"));

            for (WebElement ele : alldates) {
                String dt = ele.getText();
                if (dt.equals(date)) {
                    ele.click();
                    break;
                }
            }
        }


          }
}
