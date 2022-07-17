import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class jobIndexLogin {


        public static void main(String[] args) {
            // Locators
            By loginLinkLocator = By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]");
            By cookiePopUpLocator =  By.cssSelector("#jix-cookie-consent-accept-all");
            By loginUserNameInputLocator = By.cssSelector("input#email");
            By loginPasswordInputLocator = By.cssSelector("input#password");
            By loginButtonLocator = By.xpath("//*[@id=\"_jix_login_contents\"]/div[2]/div[1]/form/div[4]/button");

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
            driver.findElement(loginLinkLocator).click();
            driver.findElement(loginUserNameInputLocator).sendKeys("oman46@gmail.com");
            driver.findElement(loginPasswordInputLocator).sendKeys("dS3v8mma");
            driver.findElement(loginButtonLocator).click();
            // get the actual value of the title
            String actualTitle = driver.getTitle();
            System.out.println("actual title is: " + actualTitle);
            String expectedTitle = "Job og ledige stillinger. Find ledige job | Jobindex";
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
