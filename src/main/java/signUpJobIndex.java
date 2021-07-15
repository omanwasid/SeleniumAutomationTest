import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class signUpJobIndex {


    public static void main(String[] args) {

        // Locators
        By signupLinkLocator = By.cssSelector("div[class='col-md-3 d-none d-lg-block'] li[class='d-none d-lg-inline'] a[class='main-nav-link']");
        By cookiePopUpLocator =  By.cssSelector("#jix-cookie-consent-accept-all");
        By userEmailInputLocator = By.cssSelector("#email");
        By signupButtonLocator = By.xpath("/html/body/div[1]/main/section/div[2]/form/div[2]/button");

        // creating driver object
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        //setting up url
        String baseUrl = "https://www.jobindex.dk/";

        // launch chrome and execute the test steps
        driver.get(baseUrl);
        driver.findElement(cookiePopUpLocator).click();
        driver.findElement(signupLinkLocator).click();
        driver.findElement(userEmailInputLocator).sendKeys("wasid@ymail.com");
        driver.findElement(signupButtonLocator).click();

        // get the actual value of the title
        String actualTitle = driver.getTitle();
        System.out.println("actual title is: " + actualTitle);
        String expectedTitle = "Ny bruger oprettet — Tjek din e-mail | Jobindex";
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        // sleeping the execution for 4000 milly sec
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //close chrome
        //driver.close();
    }
}
