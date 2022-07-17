import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CheckDropDownSorted {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.twoplugs.com");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul/li[2]/a")).click();
        driver.manage().window().maximize();

        WebElement drpElement = driver.findElement(By.xpath("/html/body/div[7]/div/section/form/div/div/div/div/div[1]/div/div[1]/div/div/div/select"));
        Select drpSelect = new Select(drpElement);
        /*
        How to select button dropdown elements fx: www.jobindex.dk
         */
        //Button drpElement =driver.findElement(By.xpath("/html/body/div[7]/div/section/form/div/div/div/div/di"));

        List<WebElement> options = drpSelect.getOptions();

        ArrayList originalList = new ArrayList();
        ArrayList tempList = new ArrayList();

        for (WebElement option : options)
        {
            originalList.add(option.getText());
            tempList.add(option.getText());
        }
        System.out.println("Original List:"+originalList);
        System.out.println("Temporary List:"+tempList);

        Collections.sort(tempList);

        System.out.println("Original List:"+originalList);
        System.out.println("Temporary List After Sorting:"+tempList);

        if (originalList.equals(tempList))
        {
            System.out.println("Drop Down Sorted....");
        }
        else
        {
            System.out.println("Drop Down Unsorted....");
        }
        driver.close();
    }
}

