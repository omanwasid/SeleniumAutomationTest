import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DatePickerDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"dob\"]")).click(); //Open the Date Picker

        // Month and Year Selection
        //Select month_drp =new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        Select month_drp =new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]")));
        month_drp.selectByVisibleText("Dec");

        //Select year_drp =new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        Select year_drp =new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]")));

        year_drp.selectByVisibleText("2010");

        String date="15";

        //Date Selection
        List<WebElement> alldates = (List<WebElement>) driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for (WebElement ele:alldates)
         {
              String dt=ele.getText();

              if (dt.equals(date))
              {
                  ele.click();
                  break;
              }
         }




    }
}
