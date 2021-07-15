import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.ByteOrder;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class signupFaceBook {

    public static void main(String[] args) {
        //By loginLinkLocator = By.xpath("//*[@id=\"u_0_1e_pg\"]");
        By firstNameInputLocator = By.xpath("//input[@name='firstname']");
        By lastNameInputLocator = By.xpath("//input[@name='lastname']");
        By userEmailInputLocator = By.xpath("//input[@name='reg_email__']");

        By userPasswordInputLocator = By.xpath("//input[@name='reg_passwd__']");
        //By userReEmailInputLocator = By.cssSelector("//input[@id='u_0_v_/D']");

        By cookiePopUpLocator = By.xpath("//button[@title='Accept All']");
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElement(loginLinkLocator).click();

        driver.get("https://en-gb.facebook.com/r.php?locale=en_GB&display=page");
        driver.findElement(cookiePopUpLocator).click();
        driver.findElement(firstNameInputLocator).sendKeys("Muhammad");
        driver.findElement(lastNameInputLocator).sendKeys("Wasid");
        driver.findElement(userEmailInputLocator).sendKeys("wasid@ymail.com");
        driver.findElement(userPasswordInputLocator).sendKeys("dS3v8mma");
        //driver.findElement(userReEmailInputLocator).sendKeys("wasid@ymail.com");

        //Select DropDown Day
        WebElement drpDateElm = driver.findElement(By.id("day"));
        Select drpDate = new Select(drpDateElm);
        drpDate.selectByVisibleText("1");

        //Select DropDown Month
        WebElement drpMonthElm = driver.findElement(By.id("month"));
        Select drpMonth = new Select(drpMonthElm);
        drpMonth.selectByVisibleText("Dec");

        //Select DropDown Year
        WebElement drpYearElm = driver.findElement(By.id("year"));
        Select drpYear = new Select(drpYearElm);
        drpYear.selectByVisibleText("1980");

        //Select RadioButton
        driver.findElement(By.xpath("//input[@value='2']")).click();

        /*Thread.sleep(3000);
        drpMonth.selectByValue("3");
        Thread.sleep(3000);
        List<WebElement> allOptions = drpMonth.getOptions();
        for (WebElement option : allOptions) {
            if (option.getText().equals("apr")) {
                option.click();

            }
        }*/
    }
}

