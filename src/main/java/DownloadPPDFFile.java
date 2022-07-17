import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;

class DownloadPDFFile {
    public static void main(String[] args) {

        String location=System.getProperty("user.dir")+"\\src\\main\\Download\\";
         /*
        // Chrome
        HashMap preferences=new HashMap();
        preferences.put("plugins.always_open_pdf_externally",true); //for PDF file download
        preferences.put("download.default_directory",location);

        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs",preferences);

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver(options);

        // Edge

        HashMap preferences=new HashMap();
        preferences.put("plugins.always_open_pdf_externally",true); //for PDF file download
        preferences.put("download.default_directory",location);

        EdgeOptions options=new EdgeOptions();
        options.setExperimentalOption("prefs",preferences);

        WebDriverManager.edgedriver().setup();
        WebDriver driver= new EdgeDriver(options); */


        //Firefox
        FirefoxProfile profile=new FirefoxProfile();
        profile.setPreference("pdfjs.disabled",true); //for pdf
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
        profile.setPreference("browser.download.folderList",2);
        profile.setPreference("browser.dir",location);

        FirefoxOptions options=new FirefoxOptions();
        options.setProfile(profile);

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver(options);


        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div[2]/div/div/table/tbody/tr[1]/td[5]/a")).click();

    /*  Chrome browser download pdf file successfully but need to close google ad message manually.
    Edge browser shows the error with setExperimentalOption.
    Firefox browser download pdf file successfully but not in the desired location and need to close google ad message manually..
    */

    }
}


