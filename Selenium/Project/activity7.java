package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class activity7 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
    driver = new FirefoxDriver();

    //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
}

    @Test
    public void exampleTestCase() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
        Thread.sleep(3000);
        String header = driver.findElement(By.xpath("//h1")).getText();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).submit();
        Thread.sleep(3000);
        String yourSection = driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).getText();
       // WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']//child::article"));
        int count = elements.size();
       // String count = driver.findElement(By)
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        System.out.println("Page header is: " + header);
        System.out.println("Number of courses available: " + count);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
