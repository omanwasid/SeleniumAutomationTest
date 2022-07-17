import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LifeBonder {


    public static void main(String[] args) throws InterruptedException {
        // Locators
        By cookiePopUpLocator =  By.cssSelector("a[aria-label='allow cookies']");
        By joinNowLocator = By.xpath("/html/body/div[3]/div/div/div/nav/div/ul/li[5]/a");
        By joinNowUserEmailInputLocator = By.cssSelector("#mce-EMAIL");
        By joinNowUserFirstNameInputLocator = By.cssSelector("#mce-FNAME");
        By joinNowUserLastNameInputLocator = By.cssSelector("#mce-LNAME");
        //By subscribeInputLocator = By.cssSelector("#mc-embedded-subscribe");

        By clickCrossButtonLocator = By.cssSelector("#newsletter > div > span");
        By clickWhyWeExistLinkLocator = By.cssSelector("#navbar > ul > li:nth-child(2) > a");
        By teamLocator = By.cssSelector("#navbar > ul > li:nth-child(3) > a");
        By blogLocator = By.cssSelector(".nav-link[href='https://lifebonder.com/blog']");
        By homeLocator = By.cssSelector("#navbar > ul > li:nth-child(1) > a");
        //By cookiePopUpLocator =  By.cssSelector("body > div.cc-window.cc-banner.cc-type-opt-in.cc-theme-classic.cc-bottom.cc-color-override--1784479384 > div > a.cc-btn.cc-allow");
        By signupLocator = By.cssSelector("#home > div.container.mt-5.animatedParent > a");

        // creating driver object
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        //setting up url
        String baseUrl = "https://lifebonder.com/";
        // launch chrome and execute the test steps
        driver.get(baseUrl);
        driver.findElement(cookiePopUpLocator).click();
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(joinNowLocator).click();
        driver.findElement(joinNowUserEmailInputLocator).sendKeys("oman46@gmail.com");
        driver.findElement(joinNowUserFirstNameInputLocator).sendKeys("Muhammad Al Mahmud");
        driver.findElement(joinNowUserLastNameInputLocator).sendKeys("Wasid");

        driver.findElement(clickCrossButtonLocator).click();
        //driver.findElement(continueWebsiteButtonLocator).click();
        driver.findElement(clickWhyWeExistLinkLocator).click();
        //driver.findElement(signupLocator).click();


        Thread.sleep(20000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(3000);

        driver.findElement(teamLocator).click();
        driver.findElement(homeLocator).click();
        //driver.findElement(cookiePopUpLocator).click();
        //driver.findElement(blogLocator).click();
        Thread.sleep(3000);
        driver.findElement(signupLocator).click();
        //driver.close();

        // get the actual value of the title
        String actualTitle = driver.getTitle();
        System.out.println("actual title is: " + actualTitle);
        String expectedTitle = "LifeBonder - Social Media Revolution!";
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

        //driver.close();
    }
}
