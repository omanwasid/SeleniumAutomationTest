import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class searchJobIndex {

    public static void main(String[] args) {

        // Define Locators

        By searchInputLocator = By.xpath("//*[@id=\"search-component\"]/div[1]/div[1]/input");
        By searchAreaInputLocator = By.xpath("//*[@id=\"search-component\"]/div[1]/div[2]/span/span[1]/span/ul/li/input");
        By userEmailInputLocator = By.xpath("//*[@id=\"jobagent_form\"]/div[1]/p[2]/div/input");
        By clickButtonLocator = By.xpath("//button[@class='btn btn-primary btn-sm']");
        By cookiePopUpLocator = By.xpath("//button[@id='jix-cookie-consent-accept-all']");

        // Creating driver object
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //setting up url
        driver.get("https://www.jobindex.dk/");

        // launch chrome and execute the test steps
        driver.findElement(cookiePopUpLocator).click();
        driver.findElement(searchInputLocator).sendKeys("Selenium Webdriver");
        driver.findElement(searchAreaInputLocator).click();
        driver.findElement(searchAreaInputLocator).sendKeys("Storkøbenhavn");
        driver.findElement(searchInputLocator).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(searchInputLocator).sendKeys(Keys.ENTER);
        driver.findElement(userEmailInputLocator).sendKeys("wasid@ymail.com");
        driver.findElement(clickButtonLocator).click();

    }
}

//s
//S


