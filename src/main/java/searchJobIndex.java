import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.ByteOrder;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class searchJobIndex {

    public static void main(String[] args) {
        //By loginLinkLocator = By.xpath("//*[@id=\"u_0_1e_pg\"]");
        By searchInputLocator = By.xpath("//*[@id=\"search-component\"]/div[1]/div[1]/input");
        By searchAreaInputLocator = By.xpath("//input[@placeholder='Select or enter areas']");
        //By userEmailInputLocator = By.xpath("//input[@name='reg_email__']");

        //By userPasswordInputLocator = By.xpath("//input[@name='reg_passwd__']");
        //By userReEmailInputLocator = By.cssSelector("//input[@id='u_0_v_/D']");

        By cookiePopUpLocator = By.xpath("//button[@id='jix-cookie-consent-accept-all']");
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElement(loginLinkLocator).click();

        driver.get("https://www.jobindex.dk/");
        driver.findElement(cookiePopUpLocator).click();


        driver.findElement(searchInputLocator).sendKeys("Selenium Webdriver");
        //driver.findElement(searchAreaInputLocator).click();
        //driver.findElement(searchAreaInputLocator).sendKeys("Storkøbenhavn");
        //driver.findElement(lastNameInputLocator).sendKeys("Wasid");
        //driver.findElement(userEmailInputLocator).sendKeys("wasid@ymail.com");
        //driver.findElement(userPasswordInputLocator).sendKeys("dS3v8mma");
        //driver.findElement(userReEmailInputLocator).sendKeys("wasid@ymail.com");

        //Select DropDown Area
        WebElement drpAreaElm = driver.findElement(By.id("day"));
        Select drpArea = new Select(drpAreaElm);
        drpArea.selectByVisibleText("Storkøbenhavn");

        //Select DropDown Month
        //WebElement drpMonthElm = driver.findElement(By.id("month"));
        //Select drpMonth = new Select(drpMonthElm);
        //drpMonth.selectByVisibleText("Dec");

        //Select DropDown Year
        //WebElement drpYearElm = driver.findElement(By.id("year"));
        //Select drpYear = new Select(drpYearElm);
        //drpYear.selectByVisibleText("1980");



    }
}

