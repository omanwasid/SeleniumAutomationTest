import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class registrationJobIndex {
    public static void main(String[] args) {

        // creating driver object
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Locators
        By signupLinkLocator = By.cssSelector("div[class='col-md-3 d-none d-lg-block'] li[class='d-none d-lg-inline'] a[class='main-nav-link']");
        By cookiePopUpLocator =  By.cssSelector("#jix-cookie-consent-accept-all");
        By userEmailInputLocator = By.cssSelector("#email");
        By signupButtonLocator = By.xpath("/html/body/div[1]/main/section/div[2]/form/div[2]/button");
        try {
            // launch chrome and go to url
            driver.get("https://www.jobindex.dk/");
            driver.findElement(cookiePopUpLocator).click();
            driver.findElement(signupLinkLocator).click();
            driver.findElement(userEmailInputLocator).sendKeys("wasid@ymail.com");
            driver.findElement(signupButtonLocator).click();

            System.out.println("Your Test Passed");
            // sleeping the execution for 4000 milly sec
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            System.out.println("Your Test Failed");
        }
        //close chrome
        //driver.close();
    }
}
