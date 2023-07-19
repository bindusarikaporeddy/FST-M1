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

public class activity9 {
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
        driver.findElement(By.xpath("//h3[contains(text(),'Social')]//following::p[1]/following::p[1]/a")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Developing')]")).click();
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        System.out.println("Page header is: " + header);
        Assert.assertEquals("Developing Strategy – Alchemy LMS", title, "Title matches");
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
