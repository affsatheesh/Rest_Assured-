package AutoIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class UsingAutoIT {

    public static void main(String [] arg) throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url="http://www.leafground.com/pages/upload.html";
        ((JavascriptExecutor)driver).executeScript("window.location = \'"+url+"\'");

        Thread.sleep(5000);
        WebElement clic = driver.findElement(By.xpath("//input[@name='filename']"));

        Actions action = new Actions(driver);
        action.click(clic).build().perform();

     //   ((JavascriptExecutor)driver).executeScript("arguments[0].click();", clic);

        Thread.sleep(5000);

        Runtime.getRuntime().exec("D:\\AutoIT\\test.exe");
    }

}
